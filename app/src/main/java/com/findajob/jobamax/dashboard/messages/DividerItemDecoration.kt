package com.findajob.jobamax.dashboard.messages

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView


class DividerItemDecoration(val context: Context, val attrs: AttributeSet) :
    RecyclerView.ItemDecoration() {

    private var divider: Drawable? = null
    private var showFirstDivider = false
    private var showLastDivider = false

    init {
        val dividerRes =
            context.obtainStyledAttributes(attrs, intArrayOf(android.R.attr.listDivider))
        divider = dividerRes.getDrawable(0)
        dividerRes.recycle()
    }


}