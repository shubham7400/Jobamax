package com.findajob.jobamax

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivitySplashBinding
import com.findajob.jobamax.extensions.goToActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivityMain<ActivitySplashBinding>() {

    override val layoutRes: Int get() = R.layout.activity_splash
    override fun getViewModel(): ViewModel? = null
    override fun onCreated(instance: Bundle?) {
        showSplashAndNavigate()
    }
    private fun showSplashAndNavigate() {
        lifecycleScope.launch(Dispatchers.IO) {
            Thread.sleep(2000)
            withContext(Dispatchers.Main) {
                goToActivity(MainActivity::class.java, true)
            }
        }
    }

}