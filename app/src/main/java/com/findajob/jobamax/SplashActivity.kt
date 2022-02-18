package com.findajob.jobamax

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivitySplashBinding
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.util.log
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import com.pushwoosh.Pushwoosh
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.text.TextUtils
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import java.lang.Exception


@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivityMain<ActivitySplashBinding>() {

    override val layoutRes: Int get() = R.layout.activity_splash
    override fun getViewModel(): ViewModel? = null
    override fun onCreated(instance: Bundle?) {
         Pushwoosh.getInstance().registerForPushNotifications( ) // registering pushwoosh notification
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