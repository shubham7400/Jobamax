package com.findajob.jobamax.jobseeker.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u0011\u001a\u00020\u001aH\u0014J\"\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u0012\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010\'H\u0014J\u0012\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0016H\u0002J\u0012\u0010.\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u00065"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/SeekerAboutMeFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerAboutMeBinding;", "Lcom/findajob/jobamax/util/ImagePicker$GetImage;", "()V", "imagePicker", "Lcom/findajob/jobamax/util/ImagePicker;", "getImagePicker", "()Lcom/findajob/jobamax/util/ImagePicker;", "setImagePicker", "(Lcom/findajob/jobamax/util/ImagePicker;)V", "layoutRes", "", "getLayoutRes", "()I", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "cropImageFromUri", "uri", "Landroid/net/Uri;", "Landroidx/lifecycle/ViewModel;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "setCameraImage", "filePath", "", "setClickListeners", "setGalleryImage", "imageUri", "setImageFile", "file", "Ljava/io/File;", "setupImagePicker", "viewModelObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SeekerAboutMeFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerAboutMeBinding> implements com.findajob.jobamax.util.ImagePicker.GetImage {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.util.ImagePicker imagePicker;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerAboutMeFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.util.ImagePicker getImagePicker() {
        return null;
    }
    
    public final void setImagePicker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.util.ImagePicker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void setupImagePicker() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void setGalleryImage(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri) {
    }
    
    @java.lang.Override()
    public void setCameraImage(@org.jetbrains.annotations.Nullable()
    java.lang.String filePath) {
    }
    
    @java.lang.Override()
    public void setImageFile(@org.jetbrains.annotations.Nullable()
    java.io.File file) {
    }
    
    private final void cropImageFromUri(android.net.Uri uri) {
    }
}