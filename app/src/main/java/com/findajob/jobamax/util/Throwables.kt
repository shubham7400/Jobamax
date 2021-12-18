package com.findajob.jobamax.util

class ParseQueryEmptyThrowable : Throwable() {
    override val message: String
        get() = "The data could not be found"
}