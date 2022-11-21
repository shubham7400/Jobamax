package com.jobamax.appjobamax.model

import java.io.Serializable

class UserTempInfo : Serializable {
    var email: String = ""
    var loginType: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var password: String = ""
    var profilePicUrl: String = ""
    var userId: String = ""
    var userType: Int? = null
    var age: Int? = null
    var university: University? = null
    var jobLocation: JobLocation? = null
    var promoCode: String? = null
}

class JobLocation : Serializable {
    var lat: Double? = null
    var long: Double? = null
    var address: String = ""
    var city: String = ""
}