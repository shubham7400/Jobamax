package com.jobamax.appjobamax.base

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.extensions.setLocale
import com.jobamax.appjobamax.preference.getLanguage
import com.google.gson.Gson
import com.kaopiz.kprogresshud.KProgressHUD
import io.reactivex.disposables.CompositeDisposable


abstract class BaseActivityMain<V : ViewDataBinding> : AppCompatActivity() {

    private val disposeBag = CompositeDisposable()

    lateinit var progressHud: KProgressHUD

    protected val gson = Gson()

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected lateinit var binding: V

    protected abstract fun getViewModel(): ViewModel?



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLocale(getLanguage())

        binding = DataBindingUtil.setContentView(this, layoutRes)


        progressHud = KProgressHUD.create(this@BaseActivityMain)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
        onCreated(savedInstanceState)
    }



    protected abstract fun onCreated(instance: Bundle?)

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onDestroy() {
        super.onDestroy()
         disposeBag.clear()
    }


    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(menuItem)
        }
    }


}