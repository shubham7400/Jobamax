package com.jobamax.appjobamax.recruiter.profile

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentRecruiterProfileBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.checkForPermissions
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.extensions.yyyyMMddHHmmss
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity
import com.jobamax.appjobamax.jobseeker.build_profile.PROFILE_IMAGE_REQUEST_CODE
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.dialog.DialogSeePostJobOfferInfo
import com.jobamax.appjobamax.recruiter.profile.setting.RecruiterSettingActivity
import com.jobamax.appjobamax.util.ImagePicker
import com.jobamax.appjobamax.util.getFileName
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseFile
import com.parse.SaveCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream
import java.util.*


class RecruiterProfileFragment : BaseFragment() , ImagePicker.GetImage {
    lateinit var binding: FragmentRecruiterProfileBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    lateinit var imagePicker: ImagePicker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterProfileBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        initializeRecruiter()
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterHomeActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }
    }

    private fun setData() {
        loadImageFromUrl(binding.civUser, recruiter.profilePicUrl, R.drawable.default_user_img)
        binding.tvCompanyName.text = recruiter.company?.getString(ParseTableFields.NAME.value)
        binding.tvCompanyEmail.text = recruiter.email
    }

    private fun setClickListeners() {
        binding.tvPostJobOffer.setOnClickListener {  }
        binding.tvSeeJobOffer.setOnClickListener {  }
        binding.tvCompany.setOnClickListener {  }
        binding.ivSetting.setOnClickListener {
            startActivity(Intent(requireContext(), RecruiterSettingActivity::class.java))
        }
        binding.tvPostJobOffer.setOnClickListener { DialogSeePostJobOfferInfo(requireActivity()).show() }
        binding.tvSeeJobOffer.setOnClickListener { DialogSeePostJobOfferInfo(requireActivity()).show() }
        binding.tvCompany.setOnClickListener { DialogSeePostJobOfferInfo(requireActivity()).show() }
        binding.civUser.setOnClickListener {
            if (requireActivity().checkForPermissions(arrayOf(Manifest.permission.CAMERA))) {
                setupImagePicker()
            }
        }
    }

    private fun setupImagePicker() {
        imagePicker = ImagePicker(this, PROFILE_IMAGE_REQUEST_CODE)
        imagePicker.show(requireActivity().supportFragmentManager, imagePicker.tag)
    }

    override fun setImageUri(imageUri: Uri?, requestCode: Int) {
        if (imageUri != null) {
            when(requestCode){
                PROFILE_IMAGE_REQUEST_CODE -> {
                    lifecycleScope.launch(Dispatchers.Main){
                        progressHud.show()
                    }
                    uploadImage(imageUri){ url ->
                        progressHud.dismiss()
                        url?.let {
                            viewModel.recruiterObject?.put("profilePicUrl", url)
                            progressHud.show()
                            viewModel.recruiterObject?.saveInBackground { exception ->
                                progressHud.dismiss()
                                if (exception == null){
                                    try {
                                        (requireActivity() as RecruiterHomeActivity).getRecruiter { }
                                    }catch (e: Exception){ }
                                }else{
                                    toast(exception.message.toString())
                                }
                            }
                        }
                    }
                }
            }
        }else{
            toast("Something Went Wrong.")
        }
     }

    private fun uploadImage(profilePicUri: Uri, callback: (String?) -> Unit) {
        val inputStream: InputStream? = requireContext().contentResolver.openInputStream(profilePicUri)
        var fileName = requireContext().getFileName(profilePicUri)
        if (fileName.isEmpty())
            fileName = Date().yyyyMMddHHmmss()
        val parseFile = ParseFile(fileName, inputStream?.readBytes())
        parseFile.saveInBackground(SaveCallback {
            if (it == null) { callback(parseFile.url) } else callback(null)
        })
    }

}