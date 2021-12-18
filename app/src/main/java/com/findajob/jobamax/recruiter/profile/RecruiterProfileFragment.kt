package com.findajob.jobamax.recruiter.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.cropper.CropImage
import com.findajob.jobamax.cropper.CropImageView
import com.findajob.jobamax.databinding.FragmentProfileRecruiterBinding
import com.findajob.jobamax.dialog.JobamaxAnalyticsDialog
import com.findajob.jobamax.model.PaymentHistory
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.info.RecruiterInfo
import com.findajob.jobamax.recruiter.profile.info.RecruiterInfoAdapter
import com.findajob.jobamax.recruiter.profile.subscription.RecruiterSubscriptionActivity
import com.findajob.jobamax.recruiter.profile.subscription.model.Subscription
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.*
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_profile_recruiter.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File


@AndroidEntryPoint
class RecruiterProfileFragment : BaseFragmentMain<FragmentProfileRecruiterBinding>(),
    RecruiterProfileInterface, ImagePicker.GetImage {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var navController: NavController
    lateinit var imagePicker: ImagePicker
    private val activityResultHelper = ActivityResultHelper(this)
    val adapter: RecruiterInfoAdapter by lazy {
        RecruiterInfoAdapter()
    }

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initViews()
        initSubscription()
    }

    private fun initViews() {
        binding.apply {
            handler = this@RecruiterProfileFragment
        }
        navController = findNavController()
        initViewPager()
    }

    private fun initSubscription() {
        val subscriptionPlan = viewModel.recruiterParseObject?.getString("subscriptionPlan") ?: ""
        val isSubscriptionDone =
            viewModel.recruiterParseObject?.getBoolean("isSubscriptionDone") ?: false
        val forSubscription = subscriptionPlan.isEmpty() || isSubscriptionDone
        binding.forSubscription = forSubscription
    }

    private fun initViewPager() {
        val messageDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_message)
        messageDrawable?.setTint(ContextCompat.getColor(requireContext(), R.color.purple))
        adapter.collection = listOf(
            RecruiterInfo(
                0,
                messageDrawable,
                String.format(
                    getString(R.string.s_ai_searching),
                    0
                )
            ),
            RecruiterInfo(
                1,
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_matching),
                String.format(getString(R.string.s_matching_this_month), 5)
            )
        )
        with(binding) {
            vp.adapter = adapter
            TabLayoutMediator(tl, vp) { _, _ ->

            }.attach()
        }
    }


    private fun configureViewModel() {
//        viewModel = ViewModelProvider(requireActivity()).get(RecruiterHomeViewModel::class.java)
    }


    override fun onResume() {
        super.onResume()
        initFields()
    }

    private fun initFields() {
        val logoUrl = viewModel.company.logoUrl
        if (logoUrl.isNotEmpty()) loadIMageFromUrlCircular(binding.ivCompanyIcon, logoUrl)

        companyName.text = viewModel.company.name
    }

    override fun onAccountClicked() =
        navController.navigate(R.id.action_recruiterProfileFragment_to_recruiterAccountFragment)

    override fun onJobOfferClicked() =
        navController.navigate(R.id.action_recruiterProfileFragment_to_showAllJobOfferFragment)

    override fun onMediaClicked() =
        navController.navigate(R.id.action_recruiterProfileFragment_to_recruiterMediaFragment)

    override fun onSubscriptionClicked() {
        val isFreeTrial = viewModel.recruiterParseObject?.getBoolean("isFreeSubscriptionDone")
        val intent = Intent(requireContext(), RecruiterSubscriptionActivity::class.java)
        intent.putExtra("isFreeTrial", isFreeTrial)
        activityResultHelper.launch(intent).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                onSubscription(result)
                initSubscription()
            }
    }


    override fun onSponsorshipClicked() {

    }


    override fun onProfilePictureClicked() {
        if (requireActivity().checkForPermissions()) {
            setupImagePicker()
        }
    }

    override fun onCompanyClick() {
        navController.navigate(R.id.action_recruiterAccountFragment_to_companyInformationFragment)
    }

    override fun onGetJombaxAnalytics() {
        JobamaxAnalyticsDialog(requireActivity()) {
            println("on contact")
        }.show()
    }

    override fun onUpgradeClicked() {
        val subscriptionPlan = viewModel.recruiterParseObject?.getString("subscriptionPlan")
        val subscription = Subscription.generateMockData().find {
            it.plan == subscriptionPlan
        }
        subscription?.let {
            val args = bundleOf(
                Subscription.toString() to Gson().toJson(it),
            )

            navController.navigate(
                R.id.action_recruiterProfileFragment_to_recruiterCurrentSubscriptionFragment,
                args
            )

        }
//        subscription?.let {
//            val intent = Intent()
//            intent.putExtra("title", it.name)
//            intent.putExtra("description", offersValue(it.offer))
//            intent.putExtra("price", subscriptionPrice(it))
//            SubscriptionDialog(requireActivity(), intent).show()
//        }
    }


    private fun setupImagePicker() {
        imagePicker = ImagePicker(this)
        imagePicker.show(requireActivity().supportFragmentManager, imagePicker.getTag());
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val result = CropImage.getActivityResult(data)
                val companyLogoUri = result.uri
                if (companyLogoUri != null) {
                    progressHud.show()
                    loadImageFromUriCircular(binding.ivCompanyIcon, companyLogoUri)
//                    binding.ivCompanyIcon.load(companyLogoUri)
                    viewModel.uploadLogo(companyLogoUri, object : SaveParseObjectCallback {
                        override fun onFinish(isSuccessful: Boolean) {
                            progressHud.dismiss()
                            if (isSuccessful) {
                                toast("Media Uploaded Successfully")
                            } else toast("Something went wrong!")
                        }
                    })
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                context?.errorToast()
            }
        }
    }

    private fun onSubscription(result: ActivityResult) {
        val data = result.data
        println(data)
        data ?: return
        val plan = data.getStringExtra("plan") ?: ""
        val isFreeTrial = data.getBooleanExtra("isFreeTrial", false)
        if (result.resultCode == Activity.RESULT_OK) {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.recruiterParseObject?.put("subscriptionPlan", plan)
                viewModel.recruiterParseObject?.put(
                    "isFreeSubscriptionDone",
                    isFreeTrial
                )
                viewModel.recruiterParseObject?.saveInBackground {
                    initSubscription()
                }

                if (isFreeTrial) {

                    val currentUser = viewModel.currentUser
                    val paymentHistory = PaymentHistory()
                    val amount = data.getStringExtra("price") ?: ""
                    paymentHistory.customerId = currentUser.getString("stripeCustomerId").toString()
                    paymentHistory.amount = amount.filter { it.isDigit() }.toIntOrNull() ?: 0
                    paymentHistory.userId = currentUser.objectId
                    paymentHistory.subscriptionId = plan
                    val payment = paymentHistory.toParseObject()
                    payment.saveInBackground()
                }
            }
        }
    }

    override fun setGalleryImage(imageUri: Uri?) {
        imageUri?.let { cropImageFromUri(it) }
    }

    override fun setCameraImage(filePath: String?) {
        filePath?.let { cropImageFromUri(Uri.fromFile(File(filePath))) }

    }

    override fun setImageFile(file: File?) {
        file?.let { cropImageFromUri(Uri.fromFile(file)) }
    }

    private fun cropImageFromUri(uri: Uri) {
        CropImage.activity(uri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .setAspectRatio(1, 1)
            .setRequestedSize(480, 0, CropImageView.RequestSizeOptions.RESIZE_FIT)
            .start(this)
    }

    override val layoutRes: Int
        get() = R.layout.fragment_profile_recruiter

    override fun getViewModel(): ViewModel = viewModel

}

