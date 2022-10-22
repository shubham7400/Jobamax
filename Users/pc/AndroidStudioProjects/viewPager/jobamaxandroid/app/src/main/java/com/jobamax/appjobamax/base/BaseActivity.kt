package com.jobamax.appjobamax.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.jobamax.appjobamax.extensions.setLocale
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.extensions.log
import com.kaopiz.kprogresshud.KProgressHUD

abstract class BaseActivity : AppCompatActivity() {

    lateinit var progressHud: KProgressHUD

    val gson = Gson()

    override fun onResume() {
        super.onResume()
        setLocale(getLanguage())
    }

    override fun onStart() {
        super.onStart()
        setLocale(getLanguage())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressHud = KProgressHUD.create(this@BaseActivity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
    }


}