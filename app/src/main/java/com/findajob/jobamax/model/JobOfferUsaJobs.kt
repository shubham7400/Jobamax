package com.findajob.jobamax.model

data class MatchedObjectDescriptor(val OrganizationName: String = "",
                                   val PositionLocationDisplay: String = "",
                                   val PositionTitle: String = "",
                                   val PositionSchedule: List<PositionScheduleItem>?,
                                   val ApplicationCloseDate: String = "",
                                   val PositionID: String = "",
                                   val PositionEndDate: String = "",
                                   val PositionOfferingType: List<PositionOfferingTypeItem>?,
                                   val PositionRemuneration: List<PositionRemunerationItem>?,
                                   val ApplyURI: List<String>?,
                                   val PositionFormattedDescription: List<PositionFormattedDescriptionItem>?,
                                   val PositionLocation: List<PositionLocationItem>?,
                                   val QualificationSummary: String = "",
                                   val PositionStartDate: String = "",
                                   val UserArea: UserArea,
                                   val JobCategory: List<JobCategoryItem>?,
                                   val DepartmentName: String = "",
                                   val JobGrade: List<JobGradeItem>?,
                                   val PositionURI: String = "",
                                   val PublicationStartDate: String = "")


data class JobCategoryItem(val Code: String = "",
                           val Name: String = "")


data class PositionFormattedDescriptionItem(val LabelDescription: String = "",
                                            val Label: String = "")


data class SearchResult(val SearchResultCountAll: Int = 0,
                        val SearchResultItems: List<SearchResultItemsItem>?,
                        val SearchResultCount: Int = 0)


data class PositionRemunerationItem(val MaximumRange: String = "",
                                    val MinimumRange: String = "",
                                    val RateIntervalCode: String = "")

data class PositionScheduleItem(val Code: String = "",
                                val Name: String = "")


data class PositionLocationItem(val CountrySubDivisionCode: String = "",
                                val Latitude: Double = 0.0,
                                val CityName: String = "",
                                val CountryCode: String = "",
                                val Longitude: Double = 0.0,
                                val LocationName: String = "")


data class WhoMayApply(val Code: String = "",
                       val Name: String = "")


data class Details(val SecurityClearance: String = "",
                   val DrugTestRequired: String = "",
                   val WithinArea: String = "",
                   val WhatToExpectNext: String = "",
                   val OtherInformation: String = "",
                   val TeleworkEligible: Boolean = false,
                   val Benefits: String = "",
                   val Requirements: String = "",
                   val AgencyContactEmail: String = "",
                   val JobSummary: String = "",
                   val CommuteDistance: String = "",
                   val Education: String = "",
                   val ServiceType: String = "",
                   val LowGrade: String = "",
                   val RequiredDocuments: String = "",
                   val BenefitsDisplayDefaultText: Boolean = false,
                   val Relocation: String = "",
                   val BenefitsUrl: String = "",
                   val HowToApply: String = "",
                   val MajorDuties: List<String>?,
                   val HiringPath: List<String>?,
                   val OrganizationCodes: String = "",
                   val HighGrade: String = "",
                   val TravelCode: String = "",
                   val Evaluations: String = "",
                   val WhoMayApply: WhoMayApply,
                   val TotalOpenings: String = "",
                   val AgencyContactPhone: String = "",
                   val AgencyMarketingStatement: String = "",
                   val AnnouncementClosingType: String = "")


data class PositionOfferingTypeItem(val Code: String = "",
                                    val Name: String = "")


data class SearchResultItemsItem(val MatchedObjectDescriptor: MatchedObjectDescriptor,
                                 val RelevanceRank: Int = 0,
                                 val MatchedObjectId: String = "")


data class UserArea(val Details: Details,
                    val IsRadialSearch: Boolean = false)


data class JobOfferUsaJobs(val LanguageCode: String = "",
                           val SearchResult: SearchResult)


data class JobGradeItem(val Code: String = "")


