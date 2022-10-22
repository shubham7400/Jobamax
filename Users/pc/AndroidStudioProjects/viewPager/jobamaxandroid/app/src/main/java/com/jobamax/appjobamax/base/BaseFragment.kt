package com.jobamax.appjobamax.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.extensions.setLocale
import com.jobamax.appjobamax.preference.getLanguage
import com.google.gson.Gson
import com.kaopiz.kprogresshud.KProgressHUD
 import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {
    
    lateinit var progressHud: KProgressHUD
    val gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressHud = KProgressHUD.create(activity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
    }


}