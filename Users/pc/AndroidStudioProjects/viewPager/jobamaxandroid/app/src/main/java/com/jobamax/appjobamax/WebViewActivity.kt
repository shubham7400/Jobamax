package com.jobamax.appjobamax

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.jobamax.appjobamax.base.BaseActivity
import com.jobamax.appjobamax.databinding.ActivityWebViewBinding
import com.jobamax.appjobamax.util.ARG_WEB_URL
import kotlinx.android.synthetic.main.activity_web_view.*


class WebViewActivity : BaseActivity() {
    lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

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



}