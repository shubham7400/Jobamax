package com.jobamax.appjobamax

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.base.BaseActivityMain
import com.jobamax.appjobamax.databinding.ActivityWebViewBinding
import com.jobamax.appjobamax.util.ARG_WEB_URL
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : BaseActivityMain<ActivityWebViewBinding>() {

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
    }


    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    override val layoutRes: Int
        get() = R.layout.activity_web_view

    override fun getViewModel(): ViewModel? = null

}