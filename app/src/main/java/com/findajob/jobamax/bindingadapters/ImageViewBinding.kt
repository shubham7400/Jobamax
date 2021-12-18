package com.findajob.jobamax.bindingadapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.findajob.jobamax.data.pojo.Chat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ImageViewBinding @Inject constructor(@ApplicationContext context: Context) {

    companion object {
        @SuppressLint("ResourceType")
        @BindingAdapter("loadImageUrl")
        @JvmStatic
        fun loadFromUrl(imageView: ImageView, url: Chat/*String*/) {

//            with(url.file) {
                when {
                    url.message == null && url.file.contains(".mp4") -> {
                        imageView.visibility = View.VISIBLE
                        Glide.with(imageView.context)
                            .asBitmap()
                            .load(url.file)
                            .diskCacheStrategy(DiskCacheStrategy.DATA)
                            .into(imageView)
                    }
                    url.message == null && url.file.contains(".pdf") -> {
                        imageView.visibility = View.GONE
                    }
                    url.message == null && url.file.contains(".png") ||
                    url.message == null && url.file.contains(".jpeg") ||
                    url.message == null && url.file.contains(".jpg") -> {
                        imageView.visibility = View.VISIBLE
                        Glide.with(imageView.context)
                            .load(url.file)
                            .into(imageView)
                    }
                    url.message != null && url.file.isEmpty() -> {
                        imageView.visibility = View.GONE
                    }
                }
        }
    }
}