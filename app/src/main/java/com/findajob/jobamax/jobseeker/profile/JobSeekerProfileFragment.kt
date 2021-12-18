package com.findajob.jobamax.jobseeker.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.cropper.CropImage
import com.findajob.jobamax.cropper.CropImageView
import com.findajob.jobamax.databinding.FragmentJobSeekerProfileBinding
import com.findajob.jobamax.dialog.JobamaxBecomeAmbassadorDialog
import com.findajob.jobamax.dialog.JobamaxReachDialog
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.info.Info
import com.findajob.jobamax.jobseeker.profile.info.InfoAdapter
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.*
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.fragment_job_seeker_profile.*
import java.io.File


@AndroidEntryPoint
class JobSeekerProfileFragment : BaseFragmentMain<FragmentJobSeekerProfileBinding>(),
    JobSeekerProfileInterface, ImagePicker.GetImage {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()

    lateinit var navController: NavController
    lateinit var imagePicker: ImagePicker
    val adapter: InfoAdapter by lazy {
        InfoAdapter()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_job_seeker_profile

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
    }

    private fun initViews() {
        binding.lifecycleOwner = this
        binding.handler = this
    }


    override fun getViewModel(): ViewModel = viewModel


    override fun onResume() {
        super.onResume()
        initFields()
        initViewPager()
    }

    private fun initViewPager() {
        adapter.collection = listOf(
            Info(
                0,
                R.drawable.ic_message,
                String.format(
                    getString(R.string.s_reaches_this_month),
                    viewModel.jobSeeker.totalReach
                )
            ),
            Info(1, R.drawable.ic_message, "3 reach left this month")
        )
        with(binding) {
            vp.adapter = adapter
            TabLayoutMediator(tl, vp) { _, _ ->

            }.attach()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    private fun setupImagePicker() {
        imagePicker = ImagePicker(this)
        imagePicker.show(requireActivity().supportFragmentManager, imagePicker.tag);
    }

    private fun initFields() {
        if (viewModel.jobSeeker.profilePicUrl.isNotEmpty())
            Picasso.get().load(viewModel.jobSeeker.profilePicUrl)
                .transform(CropCircleTransformation()).into(profilePicIcon)
        userNameLabel.text = viewModel.jobSeeker.firstName
    }

    override fun onAccountClicked() =
        navController.navigate(R.id.action_jobSeekerProfileFragment_to_jobSeekerAccountFragment)// startActivity(Intent(requireActivity(), JobSeekerAccountActivity::class.java))

    override fun onCVClicked() =
        navController.navigate(R.id.action_jobSeekerProfileFragment_to_jobSeekerCvFragment)

    override fun onMediaClicked() =
        navController.navigate(R.id.action_jobSeekerProfileFragment_to_jobSeekerMediaFragment)

    override fun onJobSearchClicked() = navController.navigate(
        R.id.action_jobSeekerProfileFragment_to_jobSearchFragment2,
        bundleOf(ARG_JOBSEARCH to true)
    )

    override fun onGetJobamaxReachClicked() = JobamaxReachDialog(requireActivity()) {
        (requireActivity() as JobSeekerHomeActivity).initBilling()
    }.show()

    /*override fun onTrainingRoomClicked() {
        startActivity(Intent(requireContext(), ManageRoomActivity::class.java))
    }*/

    override fun onProfilePictureClicked() {
        if (requireActivity().checkForPermissions()) {
            setupImagePicker()
        }
    }

    override fun onBecomeAmbassadorClicked() {
        JobamaxBecomeAmbassadorDialog(requireActivity()) {
            println("Apply")
        }.show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val result = CropImage.getActivityResult(data)
                val profilePicUri = result.uri
                if (profilePicUri != null) {
                    progressHud.show()
                    Picasso.get().load(profilePicUri).transform(CropCircleTransformation())
                        .into(profilePicIcon)
                    viewModel.uploadProfilePicUri(profilePicUri, object : SaveParseObjectCallback {
                        override fun onFinish(isSuccessful: Boolean) {
                            progressHud.dismiss()
                            if (isSuccessful) {
                                toast("Media Uploaded Successfully")
                            } else toast("Something went wrong!")
                        }
                    })
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                requireContext().errorToast()
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


}