package com.findajob.jobamax.model

import com.parse.ParseObject

class JobSource {

    var source: String = ""
    var location: String = ""
    var distance: Int = 100
    var experiences: String = ""
    var experienceList: ArrayList<String> = arrayListOf()
    var educationList: ArrayList<String> = arrayListOf()
    var locationList: ArrayList<String> = arrayListOf()
    var keySkillList: ArrayList<String> = arrayListOf()

    constructor()

    constructor(obj: ParseObject) {
        try {
            this.source = obj["source"]?.toString() ?: ""
        } catch (e: Exception) {
            e.printStackTrace()
        }

        this.location = obj.getString("location") ?: ""
        this.distance = obj.getInt("distance")

        try {
            this.experienceList = ArrayList((obj["experienceList"] as? List<String>) ?: listOf())
        } catch (e: Exception) {

        }
        try {
            this.educationList = ArrayList((obj["educationList"] as? List<String>) ?: listOf())
        } catch (e: Exception) {

        }
        try {
            this.locationList = ArrayList((obj["locationList"] as? List<String>) ?: listOf())
        } catch (e: Exception) {

        }
        try {
            this.keySkillList = ArrayList((obj["keySkillList"] as? List<String>) ?: listOf())
        } catch (e: Exception) {

        }

    }

    fun udpate(obj: ParseObject) {
        obj.put("source", source)
        obj.put("experienceList", experienceList)
        obj.put("educationList", educationList)
        obj.put("locationList", locationList)
        obj.put("keySkillList", keySkillList)
        obj.put("location", location)
        obj.put("distance", distance)
    }

    fun toParseObject(): ParseObject {
        val jobSource = ParseObject("JobSource")

        jobSource.put("source", source)
        jobSource.put("experienceList", experienceList)
        jobSource.put("educationList", educationList)
        jobSource.put("locationList", locationList)
        jobSource.put("keySkillList", keySkillList)
        jobSource.put("location", location)
        jobSource.put("distance", distance)

        return jobSource
    }
}