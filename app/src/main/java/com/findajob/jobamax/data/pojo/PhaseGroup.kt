package com.findajob.jobamax.data.pojo

import java.io.Serializable
 import kotlin.collections.ArrayList


class Phase : Serializable {
    var name: String = ""
    var jobTitle: String = ""
    var date: String = ""
    var no: String = ""
}

class PhaseGroup(val phases: ArrayList<Phase> = arrayListOf()) : Serializable