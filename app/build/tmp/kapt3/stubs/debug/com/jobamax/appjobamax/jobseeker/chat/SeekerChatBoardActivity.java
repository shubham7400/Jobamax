package com.jobamax.appjobamax.jobseeker.chat;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.common.api.Api;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseActivity;
import com.jobamax.appjobamax.databinding.*;
import com.jobamax.appjobamax.jobseeker.dialog.ReportDialog;
import com.jobamax.appjobamax.enums.*;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.ChatThread;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.Message;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient;
import com.jobamax.appjobamax.util.*;
import com.parse.*;
import com.parse.livequery.ParseLiveQueryClient;
import com.parse.livequery.SubscriptionHandling;
import id.zelory.compressor.Compressor;
import kotlinx.coroutines.Dispatchers;
import java.io.File;
import java.io.IOException;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020>H\u0002J\b\u0010@\u001a\u00020>H\u0002J\u001a\u0010%\u001a\u00020>2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020>0BJ\b\u0010D\u001a\u00020>H\u0002J\u0012\u0010E\u001a\u00020>2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\b\u0010H\u001a\u00020>H\u0014J\b\u0010I\u001a\u00020>H\u0014J\b\u0010J\u001a\u00020>H\u0002J\u0010\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020\u001cH\u0002J\u0010\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020\u001cH\u0002J\b\u0010O\u001a\u00020>H\u0002J\b\u0010P\u001a\u00020>H\u0002J\b\u0010\u0010\u001a\u00020>H\u0002J\b\u0010Q\u001a\u00020>H\u0002J\b\u0010R\u001a\u00020>H\u0002J\u001a\u0010S\u001a\u00020>2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010\'\u001a\u00020>H\u0002J\b\u0010X\u001a\u00020>H\u0002J\u0018\u0010Y\u001a\u00020>2\u0006\u0010V\u001a\u00020W2\u0006\u0010Z\u001a\u00020WH\u0002J\b\u0010[\u001a\u00020>H\u0002J\b\u0010\\\u001a\u00020>H\u0002J\u0010\u0010]\u001a\u00020>2\u0006\u0010^\u001a\u00020\u001cH\u0002J\b\u0010_\u001a\u00020>H\u0002J\b\u0010`\u001a\u00020>H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020-\u0018\u000107X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b:\u0010;\u00a8\u0006a"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatBoardActivity;", "Lcom/jobamax/appjobamax/base/BaseActivity;", "Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;", "()V", "alphaAnimator", "Landroid/animation/ObjectAnimator;", "binding", "Lcom/jobamax/appjobamax/databinding/ActivitySeekerChatBoardBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ActivitySeekerChatBoardBinding;", "binding$delegate", "Lkotlin/Lazy;", "chatMessageAdapter", "Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatMessageAdapter;", "getChatMessageAdapter", "()Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatMessageAdapter;", "setChatMessageAdapter", "(Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatMessageAdapter;)V", "chatMessages", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/Message;", "chatThread", "Lcom/jobamax/appjobamax/model/ChatThread;", "getChatThread", "()Lcom/jobamax/appjobamax/model/ChatThread;", "setChatThread", "(Lcom/jobamax/appjobamax/model/ChatThread;)V", "fileName", "", "imagePicker", "Lcom/jobamax/appjobamax/util/ImagePicker;", "getImagePicker", "()Lcom/jobamax/appjobamax/util/ImagePicker;", "setImagePicker", "(Lcom/jobamax/appjobamax/util/ImagePicker;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "parseLiveQueryClient", "Lcom/parse/livequery/ParseLiveQueryClient;", "pqMessage", "Lcom/parse/ParseQuery;", "Lcom/parse/ParseObject;", "recorder", "Landroid/media/MediaRecorder;", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "subscriptionHandling", "Lcom/parse/livequery/SubscriptionHandling;", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "animation", "", "configureUi", "getChatMessages", "callback", "Lkotlin/Function1;", "", "initializeUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRecord", "sendAudioMessage", "audioUrl", "sendMessageImage", "imageUrl", "sendMessageNotification", "sendTextMessage", "setClickListeners", "setData", "setImageUri", "imageUri", "Landroid/net/Uri;", "imageCode", "", "setParseLiveQuery", "setupImagePicker", "imagePickerType", "startRecording", "stopRecording", "submitReport", "reason", "updateFilter", "uploadAudio", "app_debug"})
public final class SeekerChatBoardActivity extends com.jobamax.appjobamax.base.BaseActivity implements com.jobamax.appjobamax.util.ImagePicker.GetImage {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.Recruiter recruiter;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    private android.media.MediaRecorder recorder;
    private java.lang.String fileName = "";
    public com.jobamax.appjobamax.util.ImagePicker imagePicker;
    private android.animation.ObjectAnimator alphaAnimator;
    private com.parse.livequery.ParseLiveQueryClient parseLiveQueryClient;
    private com.parse.livequery.SubscriptionHandling<com.parse.ParseObject> subscriptionHandling;
    private com.parse.ParseQuery<com.parse.ParseObject> pqMessage;
    public com.jobamax.appjobamax.jobseeker.chat.SeekerChatMessageAdapter chatMessageAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.ChatThread chatThread;
    private final java.util.ArrayList<com.jobamax.appjobamax.model.Message> chatMessages = null;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerChatBoardActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.ActivitySeekerChatBoardBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    public final void setRecruiter(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.Recruiter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.JobSeeker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.util.ImagePicker getImagePicker() {
        return null;
    }
    
    public final void setImagePicker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.util.ImagePicker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.chat.SeekerChatMessageAdapter getChatMessageAdapter() {
        return null;
    }
    
    public final void setChatMessageAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.chat.SeekerChatMessageAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.ChatThread getChatThread() {
        return null;
    }
    
    public final void setChatThread(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.ChatThread p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configureUi() {
    }
    
    private final void updateFilter() {
    }
    
    private final void setJobSeeker() {
    }
    
    public final void getJobSeeker(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    private final void setData() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    private final void initializeUi() {
    }
    
    private final void setParseLiveQuery() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void getChatMessages() {
    }
    
    private final void setChatMessageAdapter() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void submitReport(java.lang.String reason) {
    }
    
    private final void animation() {
    }
    
    private final void onRecord() {
    }
    
    private final void startRecording() {
    }
    
    private final void stopRecording() {
    }
    
    private final void uploadAudio() {
    }
    
    private final void sendAudioMessage(java.lang.String audioUrl) {
    }
    
    private final void sendTextMessage() {
    }
    
    private final void sendMessageNotification() {
    }
    
    private final void setupImagePicker(int imageCode, int imagePickerType) {
    }
    
    @java.lang.Override()
    public void setImageUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri, int imageCode) {
    }
    
    private final void sendMessageImage(java.lang.String imageUrl) {
    }
}