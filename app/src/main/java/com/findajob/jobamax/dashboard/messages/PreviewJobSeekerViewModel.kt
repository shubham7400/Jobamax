package com.findajob.jobamax.dashboard.messages

import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.repo.MessageRepository
import com.parse.ParseObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PreviewJobSeekerViewModel @Inject constructor(
    private val repo: MessageRepository
) : BaseViewModel() {
    fun getJobSeeker(userId : String) : List<ParseObject> {
        return repo.getExistingJobSeeker(userId)
    }
}