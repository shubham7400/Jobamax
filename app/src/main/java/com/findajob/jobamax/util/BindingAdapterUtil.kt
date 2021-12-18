package com.findajob.jobamax.util

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("android:layout_weight")
fun setLayoutWeight(view: View, weight: Float) {
	val layoutParams = view.layoutParams as? LinearLayout.LayoutParams
	layoutParams?.let {
		it.weight = weight
		view.layoutParams = it
	}
}

@BindingAdapter("layout_height")
fun setLayoutHeight(view: View, height: Float) {
	val layoutParams = view.layoutParams
	layoutParams.height = height.toInt()
	view.layoutParams = layoutParams
}


@BindingAdapter("layout_width")
fun setLayoutWidth(view: View, width: Float) {
	val layoutParams = view.layoutParams
	layoutParams.width = width.toInt()
	view.layoutParams = layoutParams
}

@BindingAdapter("showView")
fun showView(view: View, show: Boolean?) {
	view.visibility = if (show == true) View.VISIBLE else View.GONE
}
