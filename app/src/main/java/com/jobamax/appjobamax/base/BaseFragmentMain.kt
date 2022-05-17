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

abstract class BaseFragmentMain<V : ViewDataBinding> : Fragment() {

    protected val gson = Gson()

    private val disposeBag = CompositeDisposable()

    @get:LayoutRes
    protected abstract val layoutRes: Int

    private lateinit var baseView: View

    protected lateinit var binding: V

    protected abstract fun onCreated(savedInstance: Bundle?)

    protected abstract fun getViewModel(): ViewModel?

    lateinit var progressHud: KProgressHUD

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        baseView = binding.root

        setLocale(requireContext().getLanguage())

        return baseView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposeBag.clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressHud = KProgressHUD.create(activity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)

        onCreated(savedInstanceState)
    }
}