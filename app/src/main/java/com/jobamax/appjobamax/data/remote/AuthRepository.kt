package com.jobamax.appjobamax.data.remote

class NoInternetException : Throwable() {
    companion object {
        const val MSG = "Device is not connected to the internet."
    }

    override val message: String
        get() = MSG
}





