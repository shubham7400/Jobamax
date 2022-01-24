package com.findajob.jobamax.jobseeker.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.cropper.CropImage
import com.findajob.jobamax.cropper.CropImageView
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.*
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.pushwoosh.internal.platform.AndroidPlatformModule.getApplicationContext
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.fragment_job_seeker_profile.*
import java.io.File
import java.util.*

@AndroidEntryPoint
class SeekerAboutMeFragment : BaseFragmentMain<FragmentSeekerAboutMeBinding>() , ImagePicker.GetImage{

    override val layoutRes: Int get() = R.layout.fragment_seeker_about_me
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var imagePicker: ImagePicker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAboutMeBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, {
             if (it){
                 binding.jobSeeker = viewModel.jobSeeker
             }
         })
    }

    private fun setClickListeners() {
        binding.ivInsta.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerSocialMediaIdsFragment, null))
        binding.ivLinkedin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerSocialMediaIdsFragment, null))
        binding.ivTiktok.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerSocialMediaIdsFragment, null))
        binding.ivEdit.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerSocialMediaIdsFragment, null))

        binding.ivProfileUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivUserProfilePic.setOnClickListener {
            if (requireActivity().checkForPermissions()) {
                setupImagePicker()
            }
        }
         binding.ivBackButton.setOnClickListener {
             (activity as SeekerProfileActivity).onBackPressed()
         }
        binding.btnSaveInfo.setOnClickListener {
            when {
                binding.etFirstName.text.isNullOrEmpty() -> {
                    toast("First name can not be empty.")
                }
                binding.etLastName.text.isNullOrEmpty() -> {
                    toast("Last name can not be empty.")
                }
                else -> {
                    viewModel.updateJobSeeker(binding.etFirstName.text.toString(), binding.etLastName.text.toString()){
                        if (it == null){
                            toast("User Updated.")
                            viewModel.getJobSeeker()
                        }else{
                            toast("${it.message.toString()} Something went wrong")
                        }
                    }
                }
            }
        }
    }

    private fun setupImagePicker() {
        imagePicker = ImagePicker(this)
        imagePicker.show(requireActivity().supportFragmentManager, imagePicker.tag);
    }

    override fun onCreated(savedInstance: Bundle?) {
         binding.jobSeeker = viewModel.jobSeeker
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val result = CropImage.getActivityResult(data)
                val profilePicUri = result.uri
                if (profilePicUri != null) {
                    progressHud.show()
                    Picasso.get().load(profilePicUri).transform(CropCircleTransformation()).into(binding.ivUserProfilePic)
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