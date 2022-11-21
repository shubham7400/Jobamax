package com.jobamax.appjobamax.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.jobamax.appjobamax.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(imageView: ImageView, imgUrl: String?) {
    if (imgUrl.isNullOrEmpty()){
        imageView.setImageResource(R.drawable.default_user_img)
    }else{
        imgUrl.let {
            Glide.with(imageView.context).applyDefaultRequestOptions( RequestOptions().placeholder(R.drawable.default_user_img).error(R.drawable.default_user_img))
                .load(it)
                .into(imageView)
        }
    }
}



