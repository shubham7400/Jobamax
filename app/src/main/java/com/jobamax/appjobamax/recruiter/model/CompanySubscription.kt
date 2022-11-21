package com.jobamax.appjobamax.recruiter.model

import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.parse.ParseObject

class CompanySubscription {
    var totalJobOffers: Int = 0
    var totalSourcings: Int = 0
    var totalMatches: Int = 0
    var usedMatches: Int = 0
    var usedJobOffer: Int = 0
    var usedSourcing: Int = 0
    var planType: Int = 0
    var selectPlanType: String = ""
    var isActivate: Boolean = false
    var companyId: String = ""
    var companySubscriptionParseObject: ParseObject? = null


    fun toParseObject(): ParseObject {
        val companySubscription = ParseObject(ParseTableName.COMPANY_SUBSCRIPTION.value)
        companySubscription.put(ParseTableFields.TOTAL_JOB_OFFERS.value, totalJobOffers)
        companySubscription.put(ParseTableFields.TOTAL_SOURCINGS.value, totalSourcings)
        companySubscription.put(ParseTableFields.TOTAL_MATCHES.value, totalMatches)
        companySubscription.put(ParseTableFields.USED_MATCHES.value, usedMatches)
        companySubscription.put(ParseTableFields.USED_JOB_OFFER.value, usedJobOffer)
        companySubscription.put(ParseTableFields.USED_SOURCING.value, usedSourcing)
        companySubscription.put(ParseTableFields.PLAN_TYPE.value, planType)
        companySubscription.put(ParseTableFields.SELECT_PLAN_TYPE.value, selectPlanType)
        companySubscription.put(ParseTableFields.IS_ACTIVATE.value, isActivate)
        companySubscription.put(ParseTableFields.COMPANY_ID.value, companyId)
        companySubscriptionParseObject?.let { companySubscription.put("companySubscriptionParseObject", companySubscriptionParseObject!!) }

        return companySubscription
    }

    constructor()

    constructor(obj: ParseObject) {
        this.totalJobOffers = obj[ParseTableFields.TOTAL_JOB_OFFERS.value]?.toString()?.toIntOrNull() ?: 0
        this.totalSourcings = obj[ParseTableFields.TOTAL_SOURCINGS.value]?.toString()?.toIntOrNull() ?: 0
        this.totalMatches = obj[ParseTableFields.TOTAL_MATCHES.value]?.toString()?.toIntOrNull() ?: 0
        this.usedMatches = obj[ParseTableFields.USED_MATCHES.value]?.toString()?.toIntOrNull() ?: 0
        this.usedJobOffer = obj[ParseTableFields.USED_JOB_OFFER.value]?.toString()?.toIntOrNull() ?: 0
        this.usedSourcing = obj[ParseTableFields.USED_SOURCING.value]?.toString()?.toIntOrNull() ?: 0
        this.planType = obj[ParseTableFields.PLAN_TYPE.value]?.toString()?.toIntOrNull() ?: 0
        this.selectPlanType = obj[ParseTableFields.SELECT_PLAN_TYPE.value]?.toString() ?: ""
        this.isActivate = obj[ParseTableFields.IS_ACTIVATE.value].toString().toBoolean()
        this.companyId = obj[ParseTableFields.COMPANY_ID.value]?.toString() ?: ""
        this.companySubscriptionParseObject = obj
    }

    companion object{
        const val CLASS_NAME="CompanySubscription"
    }
}

