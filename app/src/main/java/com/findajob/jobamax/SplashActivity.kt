package com.findajob.jobamax

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivitySplashBinding
import com.findajob.jobamax.extensions.goToActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivityMain<ActivitySplashBinding>() {

    override val layoutRes: Int get() = R.layout.activity_splash
    override fun getViewModel(): ViewModel? = null
    override fun onCreated(instance: Bundle?) {
        goToActivity(MainActivity::class.java, true)
    }
}