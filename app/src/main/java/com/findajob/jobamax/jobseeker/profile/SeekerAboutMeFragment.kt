package com.findajob.jobamax.jobseeker.profile

import android.Manifest
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
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.home.SaveParseObjectCallback
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.picasso.transformations.CropCircleTransformation


@AndroidEntryPoint
class SeekerAboutMeFragment : BaseFragmentMain<FragmentSeekerAboutMeBinding>() , ImagePicker.GetImage, IOnBackPressed {

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
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
             if (it) {
                 binding.jobSeeker = viewModel.jobSeeker
             }
         }
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
            if (requireActivity().checkForPermissions(arrayOf(Manifest.permission.CAMERA))) {
                setupImagePicker()
            }
        }
         binding.ivBackButton.setOnClickListener {
             requireActivity().onBackPressed()
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
                                getCurrent()
                            } else toast("Something went wrong!")
                        }
                    })
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                requireContext().errorToast()
            }
        }
    }

    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context?.getUserId())
        query.include("portfolio")
        query.include("idealJob")
        progressHud.show()
        query.findInBackground { it, e ->
            progressHud.dismiss()
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                }
            }
        }
    }


    override fun setImageUri(imageUri: Uri?) {
        imageUri?.let { cropImageFromUri(it) }
    }

    private fun cropImageFromUri(uri: Uri) {
        CropImage.activity(uri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .setAspectRatio(1, 1)
            .setRequestedSize(480, 0, CropImageView.RequestSizeOptions.RESIZE_FIT)
            .start(this)
    }

    override fun onBackPressed(callback: () -> Unit) {
        if(binding.etFirstName.text.isNullOrEmpty()){
            binding.etFirstName.setText("")
        }
        if (binding.etLastName.text.isNullOrEmpty()){
            binding.etLastName.setText("")
        }
        if(binding.etProfession.text.isNullOrEmpty()){
            binding.etProfession.setText("")
        }
        if (binding.etDescription.text.isNullOrEmpty()){
            binding.etDescription.setText("")
        }
        viewModel.jobSeekerObject!!.put(ParseTableFields.firstName.toString(), binding.etFirstName.text.toString())
        viewModel.jobSeekerObject!!.put(ParseTableFields.lastName.toString(), binding.etLastName.text.toString())
        viewModel.jobSeekerObject!!.put(ParseTableFields.profession.toString(), binding.etProfession.text.toString())
        viewModel.jobSeekerObject!!.put(ParseTableFields.elevatorPitch.toString(), binding.etDescription.text.toString())
        viewModel.jobSeekerObject!!.saveInBackground {
            it?.let { toast(it.message.toString()) }
            callback()
        }
    }
}