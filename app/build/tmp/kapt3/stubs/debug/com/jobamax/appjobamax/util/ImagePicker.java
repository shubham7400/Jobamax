package com.jobamax.appjobamax.util;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.FileProvider;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jobamax.appjobamax.R;
import id.zelory.compressor.Compressor;
import kotlinx.coroutines.Dispatchers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u001a\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0013H\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00130\u00130\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/jobamax/appjobamax/util/ImagePicker;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "getImage", "Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;", "imageCode", "", "imagePickerType", "(Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;II)V", "cameraImage", "Ljava/io/File;", "getGetImage", "()Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;", "setGetImage", "(Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;)V", "selectImageFromGalleryResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "takeImageResult", "Landroid/net/Uri;", "captureFromCamera", "", "compressImageAndSendCallback", "file", "createFileFromStream", "ins", "Ljava/io/InputStream;", "destination", "createImageFile", "getFile", "uri", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "queryName", "selectImageFromGallery", "GetImage", "app_debug"})
public final class ImagePicker extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.util.ImagePicker.GetImage getImage;
    private final int imageCode = 0;
    private final int imagePickerType = 0;
    private java.io.File cameraImage;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> selectImageFromGalleryResult = null;
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> takeImageResult = null;
    private java.util.HashMap _$_findViewCache;
    
    public ImagePicker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.util.ImagePicker.GetImage getImage, int imageCode, int imagePickerType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.util.ImagePicker.GetImage getGetImage() {
        return null;
    }
    
    public final void setGetImage(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.util.ImagePicker.GetImage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void selectImageFromGallery() {
    }
    
    private final java.io.File getFile(android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String queryName(android.net.Uri uri) {
        return null;
    }
    
    private final void createFileFromStream(java.io.InputStream ins, java.io.File destination) {
    }
    
    private final void compressImageAndSendCallback(java.io.File file) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    private final java.io.File createImageFile() throws java.io.IOException {
        return null;
    }
    
    private final void captureFromCamera() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;", "", "setImageUri", "", "imageUri", "Landroid/net/Uri;", "requestCode", "", "app_debug"})
    public static abstract interface GetImage {
        
        public abstract void setImageUri(@org.jetbrains.annotations.Nullable()
        android.net.Uri imageUri, int requestCode);
    }
}