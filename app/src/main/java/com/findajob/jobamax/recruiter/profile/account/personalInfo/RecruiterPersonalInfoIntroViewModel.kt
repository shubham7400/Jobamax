package com.findajob.jobamax.recruiter.profile.account.personalInfo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.model.Company
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.repo.RecruiterRepo
import com.findajob.jobamax.util.log
import com.parse.ParseException
import com.parse.ParseObject
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruiterPersonalInfoIntroViewModel @Inject constructor(
    val context: Application,
    val recruiterRepo: RecruiterRepo
) :
    BaseAndroidViewModel(context) {

    private var recruiterParseObject: ParseObject? = null
    private var companyParseObject: ParseObject? = null

    var company: Company = Company()

    private val recruiterLiveData = MutableLiveData<Recruiter>()

    fun getRecruiterObserver(): LiveData<Recruiter> = recruiterLiveData

    fun getRecruiter() {
        recruiterRepo
            .getCurrentRecruiter()
            .ioToMain()
            .subscribe(
                {
                    val parseObject = it
                    recruiterParseObject = parseObject
                    companyParseObject =
                        (parseObject["company"] as? ParseObject?) ?: Company().toParseObject()
                    company = Company(companyParseObject!!)
                    recruiterLiveData.value = Recruiter(recruiterParseObject!!)
                },
                {
                    log("could not get recruiter", it)
                }
            )
            .addTo(disposeBag)
    }

    fun submitData(
        personalInfoModel: RecruiterPersonalInformationModel,
        callback: (it: ParseException?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            personalInfoModel.update(recruiterParseObject!!)
            companyParseObject?.put("name", personalInfoModel.companyName)
            companyParseObject?.put("regNumber", company.regNumber)
            companyParseObject?.put("vatNumber", company.vatNumber)
            companyParseObject?.put("headquarterAddress", company.headquarterAddress)
            companyParseObject?.put("recruiterId", personalInfoModel.recruiterId)
            companyParseObject?.put("recruiter", recruiterParseObject!!)
            companyParseObject?.saveInBackground {
                recruiterParseObject?.put("company", companyParseObject!!)
                recruiterParseObject?.saveInBackground {
                    callback(it)
                }
            }
        }
    }
}