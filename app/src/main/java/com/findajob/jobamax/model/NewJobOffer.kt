package com.findajob.jobamax.model

import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.Serializable



class NewJobOffer : Serializable {
    var recruiterId: String = ""
    var benefits: List<String> = listOf()
    var softSkills: List<String> = listOf()
    var aboutOfCompany: String = ""
    var city: String = ""
    var location: String = ""
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
    var companyLogo: String = ""
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
        location = jsonObject.getString("location")
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
        companyLogo = jsonObject.getString("companyLogo")
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

class SubMatches(val educationPer: Int, val jobTitlePer: Int, val idealJobPer: Int, val hardSkillPer: Int, val workspacePer: Int, val softSkillPer: Int, val missingHardSkills: ArrayList<String>, val missingEducations: ArrayList<String>, val missingJobTitles: ArrayList<String>, val missingSoftSkills: ArrayList<String>,): Serializable
