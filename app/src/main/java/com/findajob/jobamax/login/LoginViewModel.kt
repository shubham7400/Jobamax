package com.findajob.jobamax.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.logThis
import com.findajob.jobamax.data.remote.AuthRepository
import com.findajob.jobamax.domain.CheckExistingJobSeekerUseCase
import com.findajob.jobamax.domain.CheckExistingRecruiterUseCase
import com.findajob.jobamax.model.*
import com.findajob.jobamax.repo.JobSeekerRepo
import com.findajob.jobamax.repo.RecruiterRepo
import com.findajob.jobamax.util.ROLE_JOB_SEEKER
import com.findajob.jobamax.util.log
import com.parse.ParseCloud
import com.parse.ParseObject
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class LoginViewModel constructor(private val context: Application) : AndroidViewModel(context) {
    internal lateinit var authRepository: AuthRepository
    internal lateinit var checkExistingRecruiterUseCase: CheckExistingRecruiterUseCase
    internal lateinit var checkExistingJobSeekerUseCase: CheckExistingJobSeekerUseCase

    private val recruiterRepo = RecruiterRepo(context)
    private val jobSeekerRepo = JobSeekerRepo(context)
    var roleType = ""

    private val disposeBag = CompositeDisposable()

    // LiveData not working
    private val _existingUser = MutableLiveData<ParseObject>()
    val existingUser: LiveData<ParseObject> = _existingUser

    // LiveData not working
    private val _existingUserError = MutableLiveData<String>()
    val existingUserError: LiveData<String> = _existingUserError

    /**
     * Get currently logged in user.
     *
     * @param user, [User] object
     * @param onSuccess, callback define success state by returning [ParseObject]
     * @param onError, callback define error state by returning [Throwable]
     */
    fun getCurrentUser(user: User, onSuccess: (ParseObject) -> Unit, onError: (Throwable) -> Unit) {
        logThis("${roleType == ROLE_JOB_SEEKER}")
        if (roleType == ROLE_JOB_SEEKER)
            getCurrentJobSeeker(user, onSuccess, onError)
        else getCurrentRecruiter(user, onSuccess, onError)
    }

    // Check if recruiter has existing profile or not
    private fun getCurrentRecruiter(user: User, onSuccess: (ParseObject) -> Unit, onError: (Throwable) -> Unit) {
        // Using UseCase: In future we will use UseCase. UseCase contain one business logic only.
        CheckExistingRecruiterUseCase.execute(checkExistingRecruiterUseCase, user,
            { onSuccess.invoke(it) },
            { onError.invoke(it) })
    }

    // Check if job seeker has existing profile or not
    private fun getCurrentJobSeeker(user: User, onSuccess: (ParseObject) -> Unit, onError: (Throwable) -> Unit) {
        // Using UseCase: Rx Implementation removed
        CheckExistingJobSeekerUseCase.execute(
            checkExistingJobSeekerUseCase,
            user,
            { onSuccess.invoke(it) },
            { onError.invoke(it) }
        )
    }

    fun updateFlag(callback: UpdateUserCallback) {
        val getUserCallback: GetUserCallback = object : GetUserCallback {
            override fun onSuccess(parseObject: ParseObject) {
                parseObject.put("newMatchPNFlag", true)
                parseObject.put("messagePNFlag", true)
                parseObject.saveInBackground {
                    callback.onFinish(it == null)
                    log("keep me posted error: $it")
                }
            }

            override fun onFailure(e: Exception?) {
                callback.onFinish(false)
            }
        }
        if (roleType == ROLE_JOB_SEEKER)
            jobSeekerRepo.getCurrent(getUserCallback)
        else recruiterRepo.getCurrent(getUserCallback)
    }


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