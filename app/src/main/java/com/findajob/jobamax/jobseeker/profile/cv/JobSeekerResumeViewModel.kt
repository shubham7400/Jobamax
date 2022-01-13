package com.findajob.jobamax.jobseeker.profile.cv

import android.app.Application
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.*
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.repo.JobSeekerRepo
import com.findajob.jobamax.repo.JobSeekerResumeRepo
import com.findajob.jobamax.repo.SaveCvCallback
import com.findajob.jobamax.util.getFileName
import com.findajob.jobamax.util.log
import com.google.gson.Gson
import com.parse.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class JobSeekerResumeViewModel @Inject constructor(
    val context: Application,
    private val jobSeekerResumeRepo: JobSeekerResumeRepo,
    private val gsonConverter: Gson,
) : BaseAndroidViewModel(context) {

    var jobSeeker = JobSeeker()
    var jobSeekerParseObject: ParseObject? = null

    fun setJobSeeker(jobSeeker: ParseObject?) {
        if (jobSeeker == null) return
        this.jobSeeker = JobSeeker(jobSeeker)
        this.jobSeekerParseObject = jobSeeker
    }


    private val _educationsObservable: MutableLiveData<ArrayList<Education>> = MutableLiveData<ArrayList<Education>>()
    val educationObservable: LiveData<java.util.ArrayList<Education>> = _educationsObservable

    fun addEducation(education: Education) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val educationList = _educationsObservable.value ?: arrayListOf()
            educationList.add(education)
            _educationsObservable.postValue(educationList)
            jobSeeker.educations = gsonConverter.toJson(educationList)
        } catch (e: Exception) {
            log("could not add education", e)
        }
    }

    fun removeEducation(education: Education) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val educationList = _educationsObservable.value ?: arrayListOf()
            val index = educationList.indexOfFirst { it.id == education.id } ?: 0
            educationList.removeAt(index)
            _educationsObservable.postValue(educationList)
            jobSeeker.educations = gsonConverter.toJson(educationList)
        } catch (e: Exception) {
            log("Could not remove the ${education.name} education", e)
        }
    }

    fun updateEducation(education: Education) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val educationList = _educationsObservable.value ?: arrayListOf()
            val index = educationList.indexOfFirst { it.id == education.id } ?: 0
            educationList.removeAt(index)
            educationList.add(index, education)
            _educationsObservable.postValue(educationList)
            jobSeeker.educations = gsonConverter.toJson(educationList)
        } catch (e: Exception) {
            log("Could not update ${education.name} education", e)
        }
    }

    private val _experiencesObservable: MutableLiveData<ArrayList<Experience>> =
        MutableLiveData<ArrayList<Experience>>()
    val experiencesObservable: LiveData<ArrayList<Experience>> = _experiencesObservable

    fun addExperience(experience: Experience) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val experienceList = _experiencesObservable.value ?: arrayListOf()
            experienceList.add(experience)
            _experiencesObservable.postValue(experienceList)
            jobSeeker.experiences = gsonConverter.toJson(experienceList)
        } catch (e: Exception) {
            log("Could not add ${experience.job} experience", e)
        }
    }

    fun removeExperience(experience: Experience) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val experienceList = _experiencesObservable.value ?: arrayListOf()
            experienceList.remove(experience)
            _experiencesObservable.postValue(experienceList)
            jobSeeker.experiences = gsonConverter.toJson(experienceList)
        } catch (e: Exception) {
            log("Could not remove the ${experience.job} experience", e)
        }
    }


    fun updateExperience(experience: Experience) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val experienceList = _experiencesObservable.value ?: arrayListOf()
            val index = experienceList.indexOfFirst { it.id == experience.id } ?: 0
            experienceList.removeAt(index)
            experienceList.add(index, experience)
            jobSeeker.experiences = gsonConverter.toJson(experienceList)
            _experiencesObservable.postValue(experienceList)
        } catch (e: Exception) {
            log("Could not updateExperience ${experience.job}", e)
        }
    }


    private val _skillsObservable: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val skillsObservable: LiveData<ArrayList<String>> = _skillsObservable

    fun addSkill(skill: String) = viewModelScope.launch(Dispatchers.IO) {
        val skillList = _skillsObservable.value ?: arrayListOf()
        skillList.add(skill)
        _skillsObservable.postValue(skillList)
    }

    fun removeSkill(skill: String) = viewModelScope.launch(Dispatchers.IO) {
        val skillList = _skillsObservable.value ?: arrayListOf()
        skillList.remove(skill)
        _skillsObservable.postValue(skillList)
    }

    private val _activitiesObservable: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val activitiesObservable: LiveData<ArrayList<String>> = _activitiesObservable

    fun addActivity(activity: String) = viewModelScope.launch(Dispatchers.IO) {
        val activityList = _activitiesObservable.value ?: arrayListOf()
        activityList.add(activity)
        _activitiesObservable.postValue(activityList)
    }

    fun removeActivity(activity: String) = viewModelScope.launch(Dispatchers.IO) {
        val activityList = _activitiesObservable.value ?: arrayListOf()
        activityList.remove(activity)
        _activitiesObservable.postValue(activityList)
    }

    private val _aboutMeObservable = MutableLiveData<String>()
    val aboutMeObservable: LiveData<String> = _aboutMeObservable

    fun changeAboutMe(aboutMe: String) = viewModelScope.launch {
        _aboutMeObservable.postValue(aboutMe)
    }

    fun loadResume() = viewModelScope.launch(Dispatchers.IO) {
        if (jobSeekerParseObject == null) return@launch

        val experiences = ArrayList(gsonConverter.fromJson(jobSeeker.experiences, ExperienceGroup::class.java)?.list ?: listOf())
        _experiencesObservable.postValue(experiences)

        val educations = ArrayList(gsonConverter.fromJson(jobSeeker.educations, EducationGroup::class.java)?.list ?: listOf())
        _educationsObservable.postValue(educations)

        val skills = ArrayList(Gson().fromJson(jobSeeker.skills, SKillGroup::class.java)?.list ?: listOf())
        _skillsObservable.postValue(skills)

        val activities = ArrayList(gsonConverter.fromJson(jobSeeker.activities, ActivityGroup::class.java)?.list ?: listOf())
        _activitiesObservable.postValue(activities)

        val aboutMe = jobSeeker.aboutMe
        _aboutMeObservable.postValue(aboutMe)
    }

    private val _resumeSaveSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val resumeSaveSuccess: LiveData<Boolean> = _resumeSaveSuccess

    fun saveResumeData() = viewModelScope.launch(Dispatchers.IO) {
        val educationList = _educationsObservable.value ?: arrayListOf()
        val experienceList = _experiencesObservable.value ?: arrayListOf()
        val skillList = _skillsObservable.value ?: arrayListOf()
        val activityList = _activitiesObservable.value ?: arrayListOf()
        val aboutMe = _aboutMeObservable.value ?: ""

        val successfullySaved: Boolean = jobSeekerResumeRepo.saveResumeData(
            jobSeekerParseObject,
            educationList,
            experienceList,
            skillList,
            activityList,
            aboutMe,
        )

        _resumeSaveSuccess.postValue(successfullySaved)
    }
}