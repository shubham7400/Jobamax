package com.jobamax.appjobamax

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.base.BaseActivityMain
import com.jobamax.appjobamax.databinding.ActivitySplashBinding
import com.jobamax.appjobamax.extensions.goToActivity
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