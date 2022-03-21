package com.findajob.jobamax.jobseeker.jobsearch

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerJobWebBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SeekerJobWebFragment : BaseFragmentMain<FragmentSeekerJobWebBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_job_web
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private var jobUrl = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobWebBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        jobUrl = requireArguments().getString("job_url", "")
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.acbAddToWishlist.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.acbApplyNow.setOnClickListener {
            binding.acbApplyNow.visibility = View.GONE
            binding.acbAddToWishlist.visibility = View.GONE
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        if (jobUrl != ""){
            binding.wvJobSite.settings.javaScriptEnabled = true
            binding.wvJobSite.webViewClient =  object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    progressHud.show()
                    super.onPageStarted(view, url, favicon)
                }
                override fun onPageFinished(view: WebView?, url: String?) {
                    progressHud.dismiss()
                    super.onPageFinished(view, url)
                }
            }
            binding.wvJobSite.loadUrl(jobUrl)
        }
    }

}