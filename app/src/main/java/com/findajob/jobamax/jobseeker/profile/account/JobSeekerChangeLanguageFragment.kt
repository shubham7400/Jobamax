package com.findajob.jobamax.jobseeker.profile.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.MainActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerChangeLanguageBinding
import com.findajob.jobamax.dialog.multiChoice.BasicDialog
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.preference.getLanguage
import com.findajob.jobamax.preference.setLanguage


class JobSeekerChangeLanguageFragment : BaseFragmentMain<FragmentJobSeekerChangeLanguageBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_change_language
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobSeekerChangeLanguageBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {

    }

    override fun onCreated(savedInstance: Bundle?) {
        binding.jobSeeker = viewModel.jobSeeker

        if (requireContext().getLanguage() == "en"){
            binding.tvEnglishLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0,  R.drawable.ic_done_blue, 0)
            binding.tvFrenchLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0, 0, 0)
        }else{
            binding.tvEnglishLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0, 0, 0)
            binding.tvFrenchLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0,  R.drawable.ic_done_blue, 0)
        }
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.tvEnglishLanguage.setOnClickListener {
            binding.tvEnglishLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0,  R.drawable.ic_done_blue, 0)
            binding.tvFrenchLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0, 0, 0)
            requireContext().setLanguage("en")
            restart()
        }
        binding.tvFrenchLanguage.setOnClickListener {
            binding.tvEnglishLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0, 0, 0)
            binding.tvFrenchLanguage.setCompoundDrawablesWithIntrinsicBounds(0,0,  R.drawable.ic_done_blue, 0)
            requireContext().setLanguage("fr")
            restart()
        }
    }

    fun restart() {
        val basicDialog = BasicDialog(requireActivity(), getString(R.string.language_change_alert_message), true){
            val intent = Intent(requireContext(), MainActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finishAffinity()
        }
        basicDialog.show()
    }

}