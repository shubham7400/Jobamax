package com.jobamax.appjobamax.jobseeker.build_profile

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentImportProfileFromLinkedInBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.parse.FunctionCallback
import com.parse.ParseCloud



class ImportProfileFromLinkedIn : Fragment() {
    lateinit var binding: FragmentImportProfileFromLinkedInBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    private lateinit var rocketAnimation: AnimationDrawable
    var isReturnBack = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View   {
        binding = FragmentImportProfileFromLinkedInBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setLoadingView()
        try {
            isReturnBack = arguments?.getBoolean("is_return_back") ?: false
        }catch (e: Exception){
        }
        if (!isReturnBack){
            binding.tvPageTitle.visibility = View.VISIBLE
            binding.view.visibility = View.VISIBLE
        }
    }

    private fun setLoadingView() {
        binding.ivLoading.apply {
            setBackgroundResource(R.drawable.animation_loading_import_resume)
            rocketAnimation = background as AnimationDrawable
        }
        rocketAnimation.start()
    }

    private fun setClickListeners() {
        binding.tvImportResumeBtn.setOnClickListener {
            if (binding.etUrl.text.isNullOrEmpty()){
                //toast("Please Enter the link first.")
            }else{
                binding.clMostParent.visibility = View.GONE
                binding.llLoading.visibility = View.VISIBLE
                ParseCloud.callFunctionInBackground(ParseCloudFunction.IMPORT_FROM_LINKEDIN.value, hashMapOf("link" to binding.etUrl.text.toString().trim(), "jobSeekerId" to requireContext().getUserId()),
                    FunctionCallback<Any> { result, e ->
                        when {
                            e != null -> {
                                toast(e.message.toString())
                                binding.clMostParent.visibility = View.VISIBLE
                                binding.llLoading.visibility = View.GONE
                            }
                            result != null -> {
                                toast("Resume Imported Successfully.")
                                try {
                                    (requireActivity() as BuildProfileActivity).getJobSeeker{
                                        binding.clMostParent.visibility = View.VISIBLE
                                        binding.llLoading.visibility = View.GONE
                                        if (it){
                                            if (isReturnBack) {
                                                findNavController().popBackStack(R.id.modifyCVFragment, false)
                                            }else{
                                                findNavController().navigate(R.id.action_importProfileFromLinkedIn_to_profilePreviewFragment, null)
                                            }
                                        }
                                    }
                                }catch (e: Exception){
                                    try {
                                        (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker{
                                            binding.clMostParent.visibility = View.VISIBLE
                                            binding.llLoading.visibility = View.GONE
                                            if (it){
                                                findNavController().popBackStack(R.id.modifyCVFragment, false)
                                            }
                                        }
                                    }catch (e: Exception){
                                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker{
                                            binding.clMostParent.visibility = View.VISIBLE
                                            binding.llLoading.visibility = View.GONE
                                            if (it){
                                                findNavController().popBackStack(R.id.modifyCVFragment, false)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
    }

}