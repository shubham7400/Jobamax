package com.findajob.jobamax.jobseeker.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\fJ\u0010\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020>H\u0002J\b\u00103\u001a\u00020?H\u0014J\"\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00192\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J$\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010M\u001a\u0002082\b\u0010N\u001a\u0004\u0018\u00010LH\u0014J\u0010\u0010O\u001a\u0002082\u0006\u0010P\u001a\u00020\u001dH\u0002J\u0010\u0010Q\u001a\u0002082\u0006\u0010P\u001a\u00020\u001dH\u0002J+\u0010R\u001a\u0002082\u0006\u0010A\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\'2\u0006\u0010S\u001a\u00020TH\u0016\u00a2\u0006\u0002\u0010UJ\b\u0010V\u001a\u000208H\u0016J\b\u0010\t\u001a\u000208H\u0002J\u0012\u0010W\u001a\u0002082\b\u0010X\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010Y\u001a\u000208H\u0002J\u0012\u0010Z\u001a\u0002082\b\u0010[\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010\\\u001a\u0002082\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010_\u001a\u000208H\u0002J\b\u0010`\u001a\u000208H\u0002J\b\u0010a\u001a\u000208H\u0002J\b\u0010b\u001a\u000208H\u0002J\b\u0010c\u001a\u000208H\u0002J\b\u0010d\u001a\u000208H\u0002J\b\u0010e\u001a\u000208H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\'X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104\u00a8\u0006f"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/SeekerPortfolioFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerPortfolioBinding;", "Lcom/findajob/jobamax/util/ImagePicker$GetImage;", "()V", "adapter", "Lcom/findajob/jobamax/jobseeker/profile/PortfolioImageAdapter;", "getAdapter", "()Lcom/findajob/jobamax/jobseeker/profile/PortfolioImageAdapter;", "setAdapter", "(Lcom/findajob/jobamax/jobseeker/profile/PortfolioImageAdapter;)V", "audioUrl", "", "getAudioUrl", "()Ljava/lang/String;", "setAudioUrl", "(Ljava/lang/String;)V", "fileName", "imagePicker", "Lcom/findajob/jobamax/util/ImagePicker;", "getImagePicker", "()Lcom/findajob/jobamax/util/ImagePicker;", "setImagePicker", "(Lcom/findajob/jobamax/util/ImagePicker;)V", "layoutRes", "", "getLayoutRes", "()I", "mStartPlaying", "", "getMStartPlaying", "()Z", "setMStartPlaying", "(Z)V", "mStartRecording", "getMStartRecording", "setMStartRecording", "permissionToRecordAccepted", "permissions", "", "[Ljava/lang/String;", "player", "Landroid/media/MediaPlayer;", "portfolioImageUrlList", "Ljava/util/ArrayList;", "getPortfolioImageUrlList", "()Ljava/util/ArrayList;", "recorder", "Landroid/media/MediaRecorder;", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "convert", "", "path", "cropImageFromUri", "uri", "Landroid/net/Uri;", "Landroidx/lifecycle/ViewModel;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "onPlay", "start", "onRecord", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStop", "setCameraImage", "filePath", "setClickListeners", "setGalleryImage", "imageUri", "setImageFile", "file", "Ljava/io/File;", "setupImagePicker", "startPlaying", "startRecording", "stopPlaying", "stopRecording", "uploadAudio", "viewModelObserver", "app_debug"})
public final class SeekerPortfolioFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerPortfolioBinding> implements com.findajob.jobamax.util.ImagePicker.GetImage {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private java.lang.String fileName = "";
    private android.media.MediaRecorder recorder;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String audioUrl = "";
    private android.media.MediaPlayer player;
    private boolean mStartRecording = true;
    private boolean mStartPlaying = true;
    public com.findajob.jobamax.util.ImagePicker imagePicker;
    public com.findajob.jobamax.jobseeker.profile.PortfolioImageAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> portfolioImageUrlList = null;
    private boolean permissionToRecordAccepted = false;
    private java.lang.String[] permissions = {"android.permission.RECORD_AUDIO"};
    private java.util.HashMap _$_findViewCache;
    
    public SeekerPortfolioFragment() {
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
    public final java.lang.String getAudioUrl() {
        return null;
    }
    
    public final void setAudioUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getMStartRecording() {
        return false;
    }
    
    public final void setMStartRecording(boolean p0) {
    }
    
    public final boolean getMStartPlaying() {
        return false;
    }
    
    public final void setMStartPlaying(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.util.ImagePicker getImagePicker() {
        return null;
    }
    
    public final void setImagePicker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.util.ImagePicker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.profile.PortfolioImageAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.PortfolioImageAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getPortfolioImageUrlList() {
        return null;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
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
    
    private final void setAdapter() {
    }
    
    private final void setupImagePicker() {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void onRecord(boolean start) {
    }
    
    private final void onPlay(boolean start) {
    }
    
    private final void startPlaying() {
    }
    
    private final void stopPlaying() {
    }
    
    private final void startRecording() {
    }
    
    private final void stopRecording() {
    }
    
    private final void uploadAudio() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final byte[] convert(@org.jetbrains.annotations.NotNull()
    java.lang.String path) throws java.io.IOException {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @java.lang.Override()
    public void onStop() {
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