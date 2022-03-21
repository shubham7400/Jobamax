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

@BindingAdapter("loadImageFromDrawable")
fun loadImageFromDrawable(imageView: ImageView, icon: Int) {
    icon.let {
        imageView.load(it) {
            crossfade(true)
            crossfade(600)
            //              error(R.drawable.ic_error_placeholder)
        }
    }
}

@BindingAdapter("loadImageFromDrawableWithCorners")
fun loadImageFromDrawableWithCorners(imageView: ImageView, icon: Int) {
    icon.let {
        imageView.load(it) {
            crossfade(true)
            crossfade(600)
            transformations(RoundedCornersTransformation(24F))
        }
    }
}

@BindingAdapter("loadImageFromDrawableCircular")
fun loadImageFromDrawableCircular(imageView: ImageView, icon: Int) {
    icon.let {
        imageView.load(it) {
            crossfade(true)
            crossfade(600)
            transformations(CircleCropTransformation())
        }
    }
}

@BindingAdapter("loadImageFromUrlCircular")
fun loadImageFromUrlCircular(imageView: ImageView, icon: String?) {
    if (icon != null && icon.isNotEmpty()) {
        icon.let {
            Glide.with(imageView.context)
                .load(it)
                .circleCrop()
                .transition(withCrossFade())
                .into(imageView)
        }
    } else {
        val defaultIcon = R.drawable.ic_profile
        defaultIcon.let {
            Glide.with(imageView.context)
                .load(it)
                .circleCrop()
                .transition(withCrossFade())
                .into(imageView)
        }
    }
}

@BindingAdapter("loadImageFromDrawableBlur")
fun loadImageFromDrawableBlur(imageView: ImageView, icon: Int) {
    icon.let {
        imageView.load(it) {
            crossfade(true)
            crossfade(600)
            transformations(BlurTransformation(imageView.context, 5f))
        }
    }
}


//            @BindingAdapter("loadIMageFromUrl")
//            @JvmStatic
//            fun loadIMageFromUrl(imageView: ImageView, imgUrl: String){
//                imgUrl.let{
//                    imageView.load(it){
//                        crossfade(true)
//                    }
//                }
//
//            }

@BindingAdapter("loadIMageFromUrl")
fun loadIMageFromUrlCircular(imageView: ImageView, imgUrl: String) {
    imgUrl.let {
        imageView.load(it) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
    }

}

@BindingAdapter("loadIMageFromUrl")
fun loadImageFromUriCircular(imageView: ImageView, uri: Uri) {
    imageView.load(uri) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }

}

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

@BindingAdapter("loadImageFromDrawable")
fun loadImageFromDrawable(imageView: ImageView, icon: Drawable?) {
    icon.let {
        imageView.load(it) {
            crossfade(true)
            crossfade(600)
        }
    }
}

