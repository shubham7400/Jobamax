package com.findajob.jobamax.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\"\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0004\u00a8\u0006%"}, d2 = {"Lcom/findajob/jobamax/util/ImagePicker;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "getImage", "Lcom/findajob/jobamax/util/ImagePicker$GetImage;", "(Lcom/findajob/jobamax/util/ImagePicker$GetImage;)V", "CAMERA_REQUEST_CODE", "", "GALARY_REQUEST_CODE", "cameraFilePath", "", "cameraImage", "Ljava/io/File;", "getCameraImage", "()Ljava/io/File;", "setCameraImage", "(Ljava/io/File;)V", "getGetImage", "()Lcom/findajob/jobamax/util/ImagePicker$GetImage;", "setGetImage", "captureFromCamera", "", "createImageFile", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "startGallery", "GetImage", "app_debug"})
public final class ImagePicker extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.util.ImagePicker.GetImage getImage;
    public java.io.File cameraImage;
    private java.lang.String cameraFilePath;
    private final int CAMERA_REQUEST_CODE = 1021;
    private final int GALARY_REQUEST_CODE = 1056;
    private java.util.HashMap _$_findViewCache;
    
    public ImagePicker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.util.ImagePicker.GetImage getImage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.util.ImagePicker.GetImage getGetImage() {
        return null;
    }
    
    public final void setGetImage(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.util.ImagePicker.GetImage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getCameraImage() {
        return null;
    }
    
    public final void setCameraImage(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void startGallery() {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    private final java.io.File createImageFile() throws java.io.IOException {
        return null;
    }
    
    private final void captureFromCamera() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/findajob/jobamax/util/ImagePicker$GetImage;", "", "setCameraImage", "", "filePath", "", "setGalleryImage", "imageUri", "Landroid/net/Uri;", "setImageFile", "file", "Ljava/io/File;", "app_debug"})
    public static abstract interface GetImage {
        
        public abstract void setGalleryImage(@org.jetbrains.annotations.Nullable()
        android.net.Uri imageUri);
        
        public abstract void setCameraImage(@org.jetbrains.annotations.Nullable()
        java.lang.String filePath);
        
        public abstract void setImageFile(@org.jetbrains.annotations.Nullable()
        java.io.File file);
    }
}