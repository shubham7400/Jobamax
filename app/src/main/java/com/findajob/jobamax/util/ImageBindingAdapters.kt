package com.findajob.jobamax.util

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.findajob.jobamax.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
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



