package com.findajob.jobamax.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.model.*
import com.findajob.jobamax.util.ROLE_JOB_SEEKER
import com.findajob.jobamax.util.log
import com.parse.ParseCloud
import com.parse.ParseObject
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.HashMap

class LoginViewModel constructor(private val context: Application) : AndroidViewModel(context) {

    fun changePassword(params: HashMap<String,Any>, onSuccess: (Any) -> Unit, onError: (Throwable) -> Unit) {
        ParseCloud.callFunctionInBackground<Any>("resetPasswordRequest", params) { response, e ->
            if (e == null){
                onSuccess.invoke(response)
            }else{
                onError.invoke(e)
            }
        }
    }
}