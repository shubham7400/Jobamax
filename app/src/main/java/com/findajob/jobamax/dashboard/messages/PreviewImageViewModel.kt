package com.findajob.jobamax.dashboard.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Chat
import com.findajob.jobamax.extensions.configureInterceptorWithEmpty
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.repo.MessageRepository
import com.findajob.jobamax.util.CustomLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


@HiltViewModel
class PreviewImageViewModel @Inject constructor(
    private val repo: MessageRepository
) : BaseViewModel() {


}