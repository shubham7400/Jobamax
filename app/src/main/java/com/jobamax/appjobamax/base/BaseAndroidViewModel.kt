package com.jobamax.appjobamax.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable

abstract class BaseAndroidViewModel(context: Application) : AndroidViewModel(context) {

    protected val disposeBag = CompositeDisposable()

    protected val gson = Gson()

    private val _hasInternetConnection = MutableLiveData<Boolean>()
    val hasInternetConnection: LiveData<Boolean> = _hasInternetConnection
    fun setHasInternetConnection(value: Boolean) {
        _hasInternetConnection.value = value
    }

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading
    fun setLoading(value: Boolean, post: Boolean = false) {
        if (post) {
            _loading.postValue(value)
        } else {
            _loading.value = value
        }
    }

    private val _error = MutableLiveData<String>(null)
    val error: LiveData<String> = _error
    fun setError(value: String?) {
        _error.value = value ?: ""
    }

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message
    fun setMessage(value: String) {
        _message.value = value
    }

    protected fun handleException(exception: Throwable, errorMessage: (String?) -> Unit) {
//        if (exception is HttpException) {
//            errorMessage.invoke(exception.response()?.errorBody()?.string())
//        } else
//            errorMessage.invoke(exception.localizedMessage)
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }

}