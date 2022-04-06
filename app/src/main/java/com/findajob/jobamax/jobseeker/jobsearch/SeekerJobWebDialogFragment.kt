package com.findajob.jobamax.jobseeker.jobsearch

import android.app.Dialog
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.DialogFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentSeekerJobWebDialogBinding
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBinding
import com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobFilterDialogFragment
import com.findajob.jobamax.model.NewJobOffer

class SeekerJobWebDialogFragment : DialogFragment() {
    lateinit var binding: FragmentSeekerJobWebDialogBinding

    private var jobUrl = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSeekerJobWebDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        jobUrl = requireArguments().getString("job_url", "")
        setClickListeners()

        if (jobUrl != ""){
            binding.wvJobSite.settings.javaScriptEnabled = true
            binding.wvJobSite.webViewClient =  object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    /*progressHud.show()*/
                    super.onPageStarted(view, url, favicon)
                }
                override fun onPageFinished(view: WebView?, url: String?) {
                   /* progressHud.dismiss()*/
                    super.onPageFinished(view, url)
                }
            }
            binding.wvJobSite.loadUrl(jobUrl)
        }
    }

    private fun setClickListeners() {
        binding.acbAddToWishlist.setOnClickListener {
            dismiss()
        }
        binding.acbApplyNow.setOnClickListener {
            binding.acbApplyNow.visibility = View.GONE
            binding.acbAddToWishlist.visibility = View.GONE
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog

        if (dialog != null) {
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

    companion object {
        fun newInstance(jobUrl: String): SeekerJobWebDialogFragment {
            val fragment = SeekerJobWebDialogFragment()
            val args = Bundle()
            args.putSerializable("job_url", jobUrl)
            fragment.arguments = args
            return fragment
        }
    }

}