package com.jobamax.appjobamax.customview

 import android.content.Context
import android.util.AttributeSet
 import androidx.appcompat.widget.AppCompatSpinner

class CustomSpinner : AppCompatSpinner {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    public override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}