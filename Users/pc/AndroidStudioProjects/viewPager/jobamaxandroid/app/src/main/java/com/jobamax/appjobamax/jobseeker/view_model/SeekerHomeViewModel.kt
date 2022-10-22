package com.jobamax.appjobamax.jobseeker.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.recruiter.model.SourcingCriteria
import com.jobamax.appjobamax.util.convertCustomObjectToJsonString
import com.parse.ParseException
import com.parse.ParseObject

class SeekerHomeViewModel : ViewModel(){
    val gson = Gson()

    var jobSeekerObject: ParseObject? = null
    val jobSeeker get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)
    var isJobSeekerUpdated = MutableLiveData<Boolean>()


    // chat thread list
    private val _chatThreadList = MutableLiveData<List<ChatThread>>(listOf())
    val chatThreadList: LiveData<List<ChatThread>> get() = _chatThreadList
    fun setChatThreadList(list : List<ChatThread>){
        _chatThreadList.value = list
    }




    fun addNewOrUpdateEducation(education: Education, callback: (it: ParseException?) -> Unit) {
        val educations = try {
            ArrayList(gson.fromJson(jobSeekerObject?.get("educations").toString(), EducationGroup::class.java)?.list ?: listOf())
        }catch (e: java.lang.Exception){
            log("${e.message.toString()}")
            arrayListOf()
        }
        var isEducationExist = false
        for (edu in educations.iterator()){
            if (edu.id == education.id){
                isEducationExist = true
                educations[educations.indexOf(edu)].apply {
                    name = education.name
                    program = education.program
                    description = education.description
                    gpa = education.gpa
                    startDate = education.startDate
                    endDate = education.endDate
                    logo = education.logo
                }
            }
        }
        if (!isEducationExist){
            educations.add(education)
        }
        val educationGroup = EducationGroup(educations)
        jobSeekerObject?.put(ParseTableFields.EDUCATIONS.value, gson.toJson(educationGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
        }
    }

    fun addAndUpdateExperience(experience: Experience, callback: (it: ParseException?) -> Unit) {
        val experiences = ArrayList(gson.fromJson(jobSeekerObject?.get(ParseTableFields.EXPERIENCES.value).toString(), ExperienceGroup::class.java)?.list ?: listOf())
        var isExperienceExist = false
        for (edu in experiences.iterator()){
            if (edu.id == experience.id){
                isExperienceExist = true
                experiences[experiences.indexOf(edu)].apply {
                    this.job = experience.job
                    this.company = experience.company
                    this.description = experience.description
                    this.location = experience.location
                    this.startDate  = experience.endDate
                }
            }
        }
        if (!isExperienceExist){
            experiences.add(experience)
        }
        val experienceGroup = ExperienceGroup(experiences)
        jobSeekerObject?.put(ParseTableFields.COMPANY_NAMES.value, ArrayList(experienceGroup.list.map { it.company.lowercase() }.filter { it.isNotEmpty() }))
        jobSeekerObject?.put(ParseTableFields.EXPERIENCES.value, gson.toJson(experienceGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
        }
    }

    fun addOrUpdateVolunteering(volunteering: Volunteering, callback: (it: ParseException?) -> Unit) {
        val volunteerings = ArrayList(gson.fromJson(jobSeekerObject?.get("volunteerings").toString(), VolunteeringGroup::class.java)?.list ?: listOf())
        var isVolunteeringExist = false
        for (volunt in volunteerings.iterator()){
            if (volunt.id == volunteering.id){
                isVolunteeringExist = true
                volunteerings[volunteerings.indexOf(volunt)].apply {
                    job = volunteering.job
                    description = volunteering.description
                    company = volunteering.company
                    location = volunteering.location
                    startDate = volunteering.startDate
                    endDate = volunteering.endDate
                }
            }
        }
        if (!isVolunteeringExist){
            volunteerings.add(volunteering)
        }
        val volunteeringGroup = VolunteeringGroup(volunteerings)
        jobSeekerObject?.put(ParseTableFields.VOLUNTEERINGS.value, gson.toJson(volunteeringGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
        }
    }



}