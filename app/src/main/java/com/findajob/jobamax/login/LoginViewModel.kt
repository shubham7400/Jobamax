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

    var roleType = ""

    private val disposeBag = CompositeDisposable()

    // LiveData not working
    private val _existingUser = MutableLiveData<ParseObject>()
    val existingUser: LiveData<ParseObject> = _existingUser

    // LiveData not working
    private val _existingUserError = MutableLiveData<String>()
    val existingUserError: LiveData<String> = _existingUserError

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _detailedUser = MutableLiveData<User>()
    val detailedUser: LiveData<User> = _detailedUser

    fun saveUserDetails(user: User) {
        user.id = UUID.randomUUID().toString()
        val parseObject = if (roleType == ROLE_JOB_SEEKER)
            JobSeeker(user).toParseObject() else Recruiter(user).toParseObject()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                parseObject.save()
                _detailedUser.postValue(user)
            } catch (e: Exception) {
                _errorMessage.postValue(e.localizedMessage ?: "Could not save user details")
            }
        }
    }

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