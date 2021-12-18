package com.findajob.jobamax.util

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleEmitter

class ActivityResultHelper(activityResultCaller: ActivityResultCaller) {

    private var emitter: SingleEmitter<ActivityResult>? = null
    private val resultLauncher =
        activityResultCaller.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            emitter?.onSuccess(it)
        }

    fun launch(intent: Intent): Single<ActivityResult> {
        return Single.create {
            emitter = it
            resultLauncher.launch(intent)
        }
    }
}