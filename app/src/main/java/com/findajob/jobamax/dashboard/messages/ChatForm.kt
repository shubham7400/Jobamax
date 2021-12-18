package com.findajob.jobamax.dashboard.messages

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.findajob.jobamax.BR

class ChatForm : BaseObservable() {

    var message = ObservableField<String>()
    var file = ObservableField<String>()

    @get:Bindable
    var messageValid: Boolean = false
        set(messageValid) {
            field = messageValid
            notifyPropertyChanged(BR.messageValid)
        }

    @get:Bindable
    var showTemplate: Int = View.GONE
        set(showTemplate) {
            field = showTemplate
            notifyPropertyChanged(BR.showTemplate)
        }

    @get:Bindable
    var infoValid: Boolean = false
        get() =  messageValid
        set(infoValid) {
            field = infoValid
            notifyPropertyChanged(BR.infoValid)
        }

}