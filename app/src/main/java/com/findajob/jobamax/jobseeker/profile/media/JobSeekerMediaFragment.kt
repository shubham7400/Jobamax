package com.findajob.jobamax.jobseeker.profile.media

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.cropper.CropImage
import com.findajob.jobamax.cropper.CropImageView
import com.findajob.jobamax.databinding.FragmentJobSeekerMediaBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.checkForPermissions
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.getFileName
import com.findajob.jobamax.util.toast
import kotlinx.android.synthetic.main.fragment_job_seeker_media.*

const val REQUEST_CODE_PERSONAL_PRESENTATION = 1007
const val REQUEST_CODE_ATTACHMENTS = 1008

class JobSeekerMediaFragment : BaseFragment(), JobSeekerMediaInterface {
	
	lateinit var binding: FragmentJobSeekerMediaBinding
	lateinit var viewModel: JobSeekerMediaViewModel
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val homeViewModel = ViewModelProvider(requireActivity()).get(JobSeekerHomeViewModel::class.java)
		viewModel = JobSeekerMediaViewModel(requireActivity().application, homeViewModel)
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentJobSeekerMediaBinding.inflate(inflater, container, false)
		binding.handler = this
		binding.jobSeeker = viewModel.jobSeeker
		return binding.root
	}
	
	override fun onBackButtonClicked() = (requireActivity() as JobSeekerHomeActivity).onBackPressed()
	
	override fun onSubmitButtonClicked() {
		if (viewModel.personalPresentationUri == null && viewModel.attachmentUri == null && viewModel.profilePicUri == null) {
			toast("Upload at least one file!")
			return
		}
		progressHud.show()
		viewModel.uploadProfilePicUri(object : SaveParseObjectCallback {
			override fun onFinish(isSuccessful: Boolean) {
				progressHud.dismiss()
				if (isSuccessful) {
					toast("Media Uploaded Successfully")
				} else {
					binding.jobSeeker = viewModel.jobSeeker
					toast("Something went wrong!")
				}
			}
		})
	}
	
	override fun onProfilePictureClicked() {
		if (requireActivity().checkForPermissions()) {
			CropImage.activity()
				.setGuidelines(CropImageView.Guidelines.ON)
				.setCropShape(CropImageView.CropShape.RECTANGLE)
				.setAspectRatio(1, 1)
				.setRequestedSize(480, 0, CropImageView.RequestSizeOptions.RESIZE_FIT)
				.start(this)
		}
	}
	
	override fun onPersonalPresentationClicked() {
		val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
		intent.addCategory(Intent.CATEGORY_OPENABLE)
		intent.type = "*/*"
		startActivityForResult(intent, REQUEST_CODE_PERSONAL_PRESENTATION)
	}
	
	override fun onAttachmentClicked() {
		val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
		intent.addCategory(Intent.CATEGORY_OPENABLE)
		intent.type = "*/*"
		startActivityForResult(intent, REQUEST_CODE_ATTACHMENTS)
	}
	
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == REQUEST_CODE_PERSONAL_PRESENTATION) {
			if (resultCode == Activity.RESULT_OK && data != null) {
				viewModel.personalPresentationUri = data.data
				personalPresentationIcon.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_done))
				personalPresentationLabel.text = requireActivity().getFileName(viewModel.personalPresentationUri!!)
			}
		} else if (requestCode == REQUEST_CODE_ATTACHMENTS) {
			if (resultCode == Activity.RESULT_OK && data != null) {
				viewModel.attachmentUri = data.data
				attachmentIcon.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_done))
				attachmentLabel.text = requireActivity().getFileName(viewModel.attachmentUri!!)
			}
		} else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK && data != null) {
				val result = CropImage.getActivityResult(data)
				viewModel.profilePicUri = result.uri
				profilePicIcon.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_done))
				profilePictureLabel.text = requireActivity().getFileName(viewModel.profilePicUri!!)
			} else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
				requireContext().errorToast()
			}
		}
	}
}

