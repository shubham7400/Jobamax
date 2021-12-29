package com.findajob.jobamax.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

fun <T> Context.gotoActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun Activity.goToActivity(mClass: Class<*>, finishCurrentActivity: Boolean, extras: Bundle? = null, withResult: Boolean = false, requestCode: Int = -1) {
    val intent = Intent(this, mClass)
    extras?.apply { intent.putExtras(this) }
    if (!withResult)
        this.startActivity(intent)
    else
        this.startActivityForResult(intent, requestCode)

    if (finishCurrentActivity)
        this.finish()

}