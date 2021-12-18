package com.findajob.jobamax.model

import com.parse.ParseObject
import java.util.*

class User {

    var id: String = UUID.randomUUID().toString()
    var userId: String = ""
    var email: String = ""
    var phoneNumber: String = ""
    var loginType: String = ""
    var role: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var profilePicUrl: String = ""


    companion object {
        const val CLASS_NAME="_User"
    }

}


interface GetUserCallback {
    fun onSuccess(parseObject: ParseObject)

    fun onFailure(e: Exception?)
}

interface GetAllUserCallback {
    fun onFinish(parseObject: List<ParseObject>)
}

interface UpdateUserCallback {
    fun onFinish(isSuccessful: Boolean)
}

interface GetCardDetailsCallback {
    fun onSuccess(map: HashMap<String, Any>?)

    fun onFailure(e: Exception?)
}

interface SaveCardDetailsCallback {
    fun onSuccess(response: Any?)

    fun onFailure(e: Exception?)
}
