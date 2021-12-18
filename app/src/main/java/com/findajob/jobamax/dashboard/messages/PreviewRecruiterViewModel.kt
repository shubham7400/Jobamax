package com.findajob.jobamax.dashboard.messages

import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.repo.GetAllJobOfferCallback
import com.findajob.jobamax.repo.MessageRepository
import com.parse.ParseObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PreviewRecruiterViewModel @Inject constructor(
    private val repo: MessageRepository
) : BaseViewModel() {
    fun getRecruiter(userId : String) : List<ParseObject> {
        return repo.getExistingRecruiter(userId)
    }

    fun loadJobOffers(userId: String, callback: GetAllJobOfferCallback) {
        repo.getAllJobOffers(userId, object : GetAllJobOfferCallback {
            override fun onFinish(parseObjects: List<ParseObject>) {
                callback.onFinish(parseObjects)
            }
        })
    }
}