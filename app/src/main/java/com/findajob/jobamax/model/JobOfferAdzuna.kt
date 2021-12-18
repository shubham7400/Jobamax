package com.findajob.jobamax.model

class CompanyAdzuna(val Class: String = "",
                   val display_name: String = "")


class Category(val Class: String = "",
                    val label: String = "",
                    val tag: String = "")


class ResultsItem(val created: String = "",
                       val description: String = "",
                       val salary_max: Float = 0f,
                       val title: String = "",
                       val salaryIsPredicted: String = "",
                       val adref: String = "",
                       val salary_min: Float = 0f,
                       val Class: String = "",
                       val contract_time: String = "",
                       val location: Location,
                       val company: CompanyAdzuna,
                       val id: String = "",
                       val category: Category,
                       val redirect_url: String = "")


class JobOfferAdzuna(val mean: Double = 0.0,
                     val count: Int = 0,
                     val Class: String = "",
                     val results: List<ResultsItem>?)


class Location(val area: List<String>?,
                    val Class: String = "",
                    val display_name: String = "")


