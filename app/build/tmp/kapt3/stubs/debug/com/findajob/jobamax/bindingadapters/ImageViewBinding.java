package com.findajob.jobamax.bindingadapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/findajob/jobamax/bindingadapters/ImageViewBinding;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Companion", "app_debug"})
public final class ImageViewBinding {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.bindingadapters.ImageViewBinding.Companion Companion = null;
    
    @javax.inject.Inject()
    public ImageViewBinding(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"ResourceType"})
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"loadImageUrl"})
    public static final void loadFromUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Chat url) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/bindingadapters/ImageViewBinding$Companion;", "", "()V", "loadFromUrl", "", "imageView", "Landroid/widget/ImageView;", "url", "Lcom/findajob/jobamax/data/pojo/Chat;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @android.annotation.SuppressLint(value = {"ResourceType"})
        @kotlin.jvm.JvmStatic()
        @androidx.databinding.BindingAdapter(value = {"loadImageUrl"})
        public final void loadFromUrl(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.data.pojo.Chat url) {
        }
    }
}