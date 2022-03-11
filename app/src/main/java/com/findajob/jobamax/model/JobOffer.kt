package com.findajob.jobamax.model

import com.findajob.jobamax.util.log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.parse.ParseGeoPoint
import com.parse.ParseObject
import org.json.JSONArray
import org.json.JSONObject

class JobOffer() {
    var jobOfferId: String = ""
    var recruiterId: String = ""
    var name: String = ""
    var geoLocation: ParseGeoPoint = ParseGeoPoint()
    var companyId: String = ""
    var companyName: String = ""
    var city: String = ""
    var industry: String = ""
    var typeOfWork: List<String> = listOf()
    var monthlySalary: String = ""
    var levelOfHierarchy: String = ""
    var skills: List<String> = listOf()
    var jobCategory: List<String> = listOf()
    var experience: List<String> = listOf()
    var description: String = ""
    var keySkills: List<String> = listOf()
    var distance: Int = 0
    var location: String = ""
    var documentName: String = ""
    var documentUrl: String = ""
    var benefits: List<String> = listOf()
    var isArchived: Boolean = false
    var companySize: String = "1-10"
    var companyWebsite: String = ""
    var screeningQuestion: String = ""

    var isMonthlySalary: Boolean = true

    fun toParseObject(): ParseObject {
        val jobOffer = ParseObject("JobOffer")
        jobOffer.put("jobOfferId", jobOfferId)
        jobOffer.put("recruiterId", recruiterId)
        jobOffer.put("name", name)
        jobOffer.put("geoLocation", geoLocation)
        jobOffer.put("companyId", companyId)
        jobOffer.put("companyName", companyName)
        jobOffer.put("city", city)
        jobOffer.put("industry", industry)
        jobOffer.put("typeOfWork", typeOfWork)
        jobOffer.put("monthlySalary", monthlySalary)
        jobOffer.put("levelOfHierarchy", levelOfHierarchy)
        jobOffer.put("skills", skills)

        try {
            jobOffer.put("jobCategory", jobCategory.toList())
            jobOffer.put("experience", experience.toList())
        } catch (e: Exception) {
            e.printStackTrace()
            log(e.message ?: "something went wrong")
        }
        jobOffer.put("description", description)
        jobOffer.put("keySkills", keySkills)
        jobOffer.put("distance", distance)
        jobOffer.put("location", location)
        jobOffer.put("documentName", documentName)
        jobOffer.put("documentUrl", documentUrl)
        jobOffer.put("isArchived", isArchived)

        jobOffer.put("companySize", companySize)
        jobOffer.put("companyWebsite", companyWebsite)
        jobOffer.put("screeningQuestion", screeningQuestion)
        jobOffer.put("isMonthlySalary", isMonthlySalary)

        return jobOffer
    }

    constructor(obj: ParseObject) : this() {
        this.jobOfferId = obj.getString("jobOfferId") ?: ""
        this.recruiterId = obj["recruiterId"].toString()
        this.name = obj["name"].toString()
        this.geoLocation = (obj["geoLocation"] as ParseGeoPoint?) ?: ParseGeoPoint()
        this.companyId = obj["companyId"].toString()
        this.companyName = obj["companyName"].toString()
        this.city = obj["city"].toString()
        this.industry = obj["industry"].toString()
        this.monthlySalary = obj["monthlySalary"].toString()
        this.levelOfHierarchy = obj["levelOfHierarchy"].toString()
        this.skills = ((obj["skills"] as? List<String>) ?: listOf())
        this.jobCategory = ((obj["jobCategory"] as? List<String>) ?: listOf())
        this.experience = (obj["experience"] as? List<String>) ?: listOf()
        this.description = obj["description"].toString()
        this.keySkills = ((obj["keySkills"] as? List<String>) ?: listOf())
        this.distance = obj["distance"].toString().toIntOrNull() ?: 0
        this.location = obj["location"].toString()
        this.documentName = obj["documentName"].toString()
        this.documentUrl = obj["documentUrl"].toString()
        this.typeOfWork = (obj["typeOfWork"] as? List<String>) ?: listOf()
        this.benefits = (obj["benefits"] as? List<String>) ?: listOf()
        this.isArchived = (obj["isArchived"] as? Boolean) ?: false
        this.companySize = (obj.getString("companySize")) ?: ""
        this.companyWebsite = (obj.getString("companyWebsite")) ?: ""
        this.screeningQuestion = (obj.getString("screeningQuestion")) ?: ""
        this.isMonthlySalary = obj.getBoolean("isMonthlySalary")

    }

    fun update(obj: ParseObject) {
        obj.put("jobOfferId", jobOfferId)
        obj.put("recruiterId", recruiterId)
        obj.put("name", name)
        obj.put("geoLocation", geoLocation)
        obj.put("companyId", companyId)
        obj.put("companyName", companyName)
        obj.put("city", city)
        obj.put("industry", industry)
        obj.put("typeOfWork", typeOfWork)
        obj.put("monthlySalary", monthlySalary)
        obj.put("levelOfHierarchy", levelOfHierarchy)
        obj.put("skills", skills)
        obj.put("jobCategory", jobCategory)
        obj.put("experience", experience)
        obj.put("description", description)
        obj.put("keySkills", keySkills)
        obj.put("distance", distance)
        obj.put("location", location)
        obj.put("documentName", documentName)
        obj.put("documentUrl", documentUrl)
        obj.put("benefits", benefits)
        obj.put("isArchived", isArchived)

        obj.put("companySize", companySize)
        obj.put("companyWebsite", companyWebsite)
        obj.put("screeningQuestion", screeningQuestion)
        obj.put("isMonthlySalary", isMonthlySalary)
    }

    companion object {
        const val CLASS_NAME = "JobOffer"
    }
}

class   NewJobOffer {
    var recruiterId: String = ""
    var benefits: List<String> = listOf()
    var softSkills: List<String> = listOf()
    var aboutOfCompany: String = ""
    var city: String = ""
    var jobTitle: String = ""
    var companyName: String = ""
    var isMonthlySalary: Boolean = false
    var description: String = ""
    var industry: String = ""
    var salary: String = ""
    var typeOfWork: String = ""
    var matches: List<String> = listOf()
    var evolutionPerspective: String = ""
    var monthlySalary: String = ""
    var companyId: String = ""
    var profilePicUrl: String = ""
    var jobOfferId: String = ""
    var jobUrl: String = ""
    var workplaceVibes: List<String> = listOf()
    var matchesPercentage: Int = 0
    var jobType: Int = 0
    var hardSkills: List<String> = listOf()
    var subMatches: SubMatches? = null

    constructor()

    constructor(jsonObject: JSONObject) : this() {
        recruiterId = jsonObject.getString("recruiterId")
        benefits = convertToList(jsonObject.get("benefits").toString())
        softSkills = convertToList(jsonObject.get("softSkills").toString())
        aboutOfCompany = jsonObject.getString("aboutOfCompany")
        city = jsonObject.getString("city")
        jobTitle = jsonObject.getString("jobTitle")
        companyName = jsonObject.getString("companyName")
        isMonthlySalary = jsonObject.getBoolean("isMonthlySalary")
        description = jsonObject.getString("description")
        industry = jsonObject.getString("industry")
        salary = jsonObject.getString("salary")
        typeOfWork = jsonObject.getString("typeOfWork")
        matches = convertToList(jsonObject.get("matches").toString())
        evolutionPerspective = jsonObject.getString("evolutionPerspective")
        monthlySalary = jsonObject.getString("monthlySalary")
        companyId = jsonObject.getString("companyId")
        profilePicUrl = jsonObject.getString("profilePicUrl")
        jobOfferId = jsonObject.getString("jobOfferId")
        jobUrl = jsonObject.getString("jobUrl")
        workplaceVibes = convertToList(jsonObject.get("workplaceVibes").toString())
        matchesPercentage = jsonObject.getInt("matchesPercentage")
        jobType = jsonObject.getInt("jobType")
        hardSkills = convertToList(jsonObject.get("hardSkills").toString())
        subMatches = Gson().fromJson(jsonObject.getJSONObject("subMatches").toString(), SubMatches::class.java)
    }

     private fun convertToList(str: String) : ArrayList<String>{
         val list = ArrayList<String>()
         if (str == ""){
             return list
         }
          val jsonArray = JSONArray(str)
         for (index in 0 until  jsonArray.length()){
             list.add(jsonArray[index].toString())
         }
         return  list
     }
}

class SubMatches(val educationPer: Int, val jobTitlePer: Int, val idealJobPer: Int, val hardSkillPer: Int, val workspacePer: Int, val softSkillPer: Int)
