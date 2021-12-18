package com.findajob.jobamax.util

import android.content.Context
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery

object JobSeekerSingleton{
    var jobSeeker: JobSeeker? = null
    fun getInstance(context: Context): JobSeeker? {
        return if (jobSeeker == null){
            val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
            query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context.getUserId())
            query.getFirstInBackground { result, e ->
                if (e == null && result != null){
                    jobSeeker = JobSeeker(result)
                }
            }
            jobSeeker
        }else{
            jobSeeker
        }
    }
}
