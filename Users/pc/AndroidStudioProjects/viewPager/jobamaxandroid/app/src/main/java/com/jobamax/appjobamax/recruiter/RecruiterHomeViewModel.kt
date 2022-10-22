package com.jobamax.appjobamax.recruiter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.SeekerFolder
import com.jobamax.appjobamax.recruiter.model.SourcingCriteria
import com.parse.ParseObject

class RecruiterHomeViewModel : ViewModel() {
    var recruiterObject: ParseObject? = null
    val recruiter get() = if (recruiterObject == null) Recruiter() else Recruiter(recruiterObject!!)
    var isRecruiterUpdated = MutableLiveData<Boolean>()

    // sourcing criteria list
    private val _sourcingCriteriaList = MutableLiveData<List<SourcingCriteria>>(listOf())
    val sourcingCriteriaList: LiveData<List<SourcingCriteria>> get() = _sourcingCriteriaList
    fun setSourcingCriteriaList(list : List<SourcingCriteria>){
        _sourcingCriteriaList.value = list
    }
    var shouldBeSelectedSourcingCriteriaSourcingId = MutableLiveData("")

    // job title filter list
    private val _jobTitleFilterList = MutableLiveData<List<JobTitleFilter>>(listOf())
    val jobTitleFilterList: LiveData<List<JobTitleFilter>> get() = _jobTitleFilterList
    fun setJobTitleFilterList(list : List<JobTitleFilter>){
        _jobTitleFilterList.value = list
    }

    // set selected job filter title
    private val _selectedJobTitleFilter = MutableLiveData<JobTitleFilter?>()
    val selectedJobTitleFilter: LiveData<JobTitleFilter?> get() = _selectedJobTitleFilter
    fun setSelectedJobTitleFilter(jobTitleFilter : JobTitleFilter?){
        _selectedJobTitleFilter.value = jobTitleFilter
    }

    // set seeker folders
    private val _seekerFolders = MutableLiveData<HashSet<SeekerFolder>>(hashSetOf())
    val seekerFolders: LiveData<HashSet<SeekerFolder>> get() = _seekerFolders
    fun setSeekerFolders(seekerFolders : HashSet<SeekerFolder>){
        _seekerFolders.value = seekerFolders
    }
}