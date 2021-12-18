package com.findajob.jobamax.util

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.findajob.jobamax.R
import com.google.android.material.tabs.TabLayout

class CustomTabLayout : TabLayout {
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context!!, attrs, defStyleAttr) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val tabLayout = getChildAt(0) as ViewGroup
        val childCount = tabLayout.childCount
        if (childCount != 0) {
            val displayMetrics = context.resources.displayMetrics
            val tabMinWidth = displayMetrics.widthPixels / childCount
            for (i in 0 until childCount) {
                tabLayout.getChildAt(i).minimumWidth = tabMinWidth
            }

            if (childCount > 1)
                setSelectedTabIndicatorColor(
                    ContextCompat.getColor(
                        tabLayout.context,
//                        R.color.colorAccent
                        R.color.white
                    )
                )
            else
                setSelectedTabIndicatorColor(
                    ContextCompat.getColor(
                        tabLayout.context,
                        R.color.colorPrimary
                    )
                )
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}
