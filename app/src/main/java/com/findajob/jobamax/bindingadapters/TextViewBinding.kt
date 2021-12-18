package com.findajob.jobamax.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

class TextViewBinding {

    companion object {

        @BindingAdapter("setTextSubstring")
        @JvmStatic
        fun setText(textView: TextView, text: String?) {
            textView.text = text?.substringAfter("JCIpdf-")
        }
    }
}