package com.findajob.jobamax.model

import com.parse.ParseObject

class PaymentHistory() {
    var priceId: String = ""
    var userId: String = ""
    var amount: Int = 0
    var subscriptionId: String = ""
    var customerId: String = ""

    fun toParseObject(): ParseObject {
        val paymentHistory = ParseObject("PaymentHistory")
        paymentHistory.put("priceId", priceId)
        paymentHistory.put("userId", userId)
        paymentHistory.put("amount", amount)
        paymentHistory.put("subscriptionId", subscriptionId)
        paymentHistory.put("customerId", customerId)

        return paymentHistory
    }

    constructor(obj: ParseObject) : this() {
        this.priceId = obj["priceId"].toString()
        this.userId = obj["userId"].toString()
        this.amount = obj["amount"].toString().toIntOrNull() ?: 0
        this.subscriptionId = obj["subscriptionId"].toString()
        this.customerId = obj["customerId"].toString()
    }

    fun update(obj: ParseObject) {
        obj.put("priceId", priceId)
        obj.put("userId", userId)
        obj.put("amount", amount)
        obj.put("subscriptionId", subscriptionId)
        obj.put("customerId", customerId)
    }
}