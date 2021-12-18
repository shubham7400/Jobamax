package com.findajob.jobamax.recruiter.profile.media

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.cropper.CropImage
import com.findajob.jobamax.cropper.CropImageView
import com.findajob.jobamax.databinding.FragmentRecruiterMediaBinding
import com.findajob.jobamax.model.Company
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.checkForPermissions
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.getFileName
import com.findajob.jobamax.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recruiter_media.*

private const val REQUEST_CODE_VIDEO_PRESENTATION = 1007


@AndroidEntryPoint
class RecruiterMediaFragment : BaseFragmentMain<FragmentRecruiterMediaBinding>(),
    RecruiterMediaInterface {

    val viewModel: RecruiterMediaViewModel by activityViewModels()
    val recruiterViewModel: RecruiterHomeViewModel by viewModels()


    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_media

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initViews()
    }

    private fun initViews() {
        binding.handler = this
        binding.company = viewModel.company
    }

    private fun configureViewModel() {
        viewModel.companyParseObject = recruiterViewModel.companyParseObject
        viewModel.recruiterParseObject = recruiterViewModel.recruiterParseObject
    }

    override fun getViewModel(): ViewModel = viewModel


    override fun onBackButtonClicked() {
        requireActivity().onBackPressed()
    }

    override fun onCompanyLogoClicked() {
        if (activity?.checkForPermissions() == true) {
            CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .setAspectRatio(1, 1)
                .setRequestedSize(480, 0, CropImageView.RequestSizeOptions.RESIZE_FIT)
                .start(this)
        }
    }

    override fun onVideoPresentationClicked() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "video/*"
        startActivityForResult(intent, REQUEST_CODE_VIDEO_PRESENTATION)
    }

    override fun onSubmitButtonClicked() {
        if (viewModel.videoUri == null && viewModel.logoUri == null) {
            toast("Upload at least one file!")
            return
        }
        progressHud.show()
        viewModel.uploadLogo(object : SaveParseObjectCallback {
            override fun onFinish(isSuccessful: Boolean) {
                progressHud.dismiss()
                if (isSuccessful) {
                    toast("Media Uploaded Successfully")
                } else {
                    binding.company = Company(viewModel.companyParseObject!!)
                    toast("Something went wrong!")
                }
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_VIDEO_PRESENTATION) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                viewModel.videoUri = data.data
                videoPresentationIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_done
                    )
                )
                videoLabel.text = requireActivity().getFileName(viewModel.videoUri!!)
            }
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val result = CropImage.getActivityResult(data)
                viewModel.logoUri = result.uri
                logoTickIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_done
                    )
                )
                logoLabel.text = requireActivity().getFileName(viewModel.logoUri!!)
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                requireActivity().errorToast()
            }
        }
    }

}

