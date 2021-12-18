package com.findajob.jobamax.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.esafirm.imagepicker.features.ImagePicker
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.kaopiz.kprogresshud.KProgressHUD
import com.uxcam.UXCam
import io.reactivex.disposables.CompositeDisposable


abstract class BaseActivityMain<V : ViewDataBinding> : AppCompatActivity() {

    protected val disposeBag = CompositeDisposable()

    lateinit var progressHud: KProgressHUD

    protected val gson = Gson()

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected lateinit var binding: V

    protected abstract fun getViewModel(): ViewModel?

//    private val loadingDialog: LoadingDialog by lazy(mode = LazyThreadSafetyMode.NONE) {
//        LoadingDialog(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)

        progressHud = KProgressHUD.create(this@BaseActivityMain)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)

        setupUxCam()

        onCreated(savedInstanceState)
    }

    private fun setupUxCam() {
        // get the name of concrete class
        UXCam.tagScreenName(this::class.java.simpleName)
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
//        loadingDialog.dismiss()
        disposeBag.clear()
    }

//    override fun onUserInteraction() {
//        super.onUserInteraction()
//
//        (application as App).userInteractionStream.accept(true)
//    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(menuItem)
        }
    }

    fun setToolbar(show: Boolean = false, showBackButton: Boolean = false, title: String = "") {
        val actionBar = supportActionBar

        actionBar?.run {
            if (show) {
                show()
                displayOptions = ActionBar.DISPLAY_SHOW_TITLE

                setHomeButtonEnabled(showBackButton)
                setDisplayHomeAsUpEnabled(showBackButton)

                if (title != "") {
                    setDisplayShowTitleEnabled(true)
                    this@run.title = title
                } else
                    setDisplayShowTitleEnabled(false)

            } else
                hide()
        }
    }

//    fun showLoading(isLoading: Boolean) {
//        loadingDialog.let {
//            if (isLoading && !loadingDialog.isShowing)
//                loadingDialog.show()
//            else if (!isLoading && loadingDialog.isShowing) {
//                loadingDialog.dismiss()
//            }
//        }
//    }

    protected fun openImagePicker(activity: Activity, showCamera: Boolean) {
        ImagePicker.create(activity)
            .toolbarImageTitle("Select Image(s)")
            .includeVideo(true)
            .toolbarArrowColor(ContextCompat.getColor(activity, R.color.colorPrimary))
            .multi()
            .limit(2)
            .toolbarDoneButtonText("Done")
            .showCamera(showCamera)
            .start()
    }

    fun showMessage(message: String, positive: Boolean, neutral: Boolean = false) {
        val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)

        val sbView = snackbar.view
        when {
            neutral -> sbView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.holo_blue_dark
                )
            )
            !positive -> {
                sbView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_red_dark
                    )
                )
            }
            else -> sbView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.holo_green_dark
                )
            )
        }

        val textValue =
            sbView.findViewById<TextView>(R.id.snackbar_text)
        textValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

        snackbar.show()
    }


//    protected fun makeFullScreen(){
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        this.window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//    }
}