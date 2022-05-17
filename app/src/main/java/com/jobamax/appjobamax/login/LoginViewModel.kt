package com.jobamax.appjobamax.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.parse.ParseCloud
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