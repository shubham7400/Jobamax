package com.jobamax.appjobamax.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jobamax.appjobamax.extensions.setLocale
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.util.log

abstract class BaseActivity : AppCompatActivity() {


    override fun onResume() {
        super.onResume()
        log("dslkflsdk onResume")
        setLocale(getLanguage())
    }

    override fun onStart() {
        super.onStart()
        log("dslkflsdk onStart")
        setLocale(getLanguage())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}