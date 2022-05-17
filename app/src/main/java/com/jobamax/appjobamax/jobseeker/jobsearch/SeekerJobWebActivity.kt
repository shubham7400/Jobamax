package com.jobamax.appjobamax.jobseeker.jobsearch

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseActivityMain
import com.jobamax.appjobamax.databinding.ActivitySeekerJobWebBinding
import com.jobamax.appjobamax.databinding.ActivityWebViewBinding
import com.jobamax.appjobamax.util.ARG_WEB_URL
import kotlinx.android.synthetic.main.activity_seeker_job_web.*
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.activity_web_view.webView

class SeekerJobWebActivity  : BaseActivityMain<ActivitySeekerJobWebBinding>() {

    override fun onCreated(instance: Bundle?) {
        progressHud.show()
        initWebView()
    }

    private fun initWebView() {
        val url = intent.getStringExtra(ARG_WEB_URL) ?: "https://www.google.com"

        webView.webViewClient = MyWebViewClient()
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                if (progress == 100)
                    progressHud.dismiss()
            }
        }

        webView.isHorizontalScrollBarEnabled = false
        webView.settings.apply {
            loadWithOverviewMode = true
            loadsImagesAutomatically = true
            useWideViewPort = true
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        webView.loadUrl(url)
        acb_add_to_wishlist.setOnClickListener { onBackPressed() }
        acb_apply_now.setOnClickListener { acb_apply_now.visibility = View.GONE }
    }


    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    override val layoutRes: Int
    get() = R.layout.activity_seeker_job_web

    override fun getViewModel(): ViewModel? = null

}