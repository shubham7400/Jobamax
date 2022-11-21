package com.jobamax.appjobamax.recruiter.message;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseActivity;
import com.jobamax.appjobamax.databinding.ActivityRecruiterChatBoardBinding;
import com.jobamax.appjobamax.databinding.ItemMessageAudioBinding;
import com.jobamax.appjobamax.databinding.ItemMessageImageBinding;
import com.jobamax.appjobamax.databinding.ItemMessageTextBinding;
import com.jobamax.appjobamax.enums.*;
import com.jobamax.appjobamax.jobseeker.chat.*;
import com.jobamax.appjobamax.jobseeker.dialog.ReportDialog;
import com.jobamax.appjobamax.model.ChatThread;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.Message;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker;
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

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020BH\u0002J\b\u0010D\u001a\u00020BH\u0002J\u001a\u00104\u001a\u00020B2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020B0FJ\b\u0010H\u001a\u00020BH\u0002J\b\u0010I\u001a\u00020BH\u0002J\u0012\u0010J\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\b\u0010M\u001a\u00020BH\u0014J\b\u0010N\u001a\u00020BH\u0002J\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020\"H\u0002J\b\u0010Q\u001a\u00020BH\u0002J\b\u0010R\u001a\u00020BH\u0002J\b\u0010\u0010\u001a\u00020BH\u0002J\b\u0010S\u001a\u00020BH\u0002J\b\u0010T\u001a\u00020BH\u0002J\u001a\u0010U\u001a\u00020B2\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020\"H\u0002J\b\u0010\\\u001a\u00020BH\u0002J\u0012\u0010]\u001a\u00020B2\b\b\u0002\u0010^\u001a\u00020YH\u0002J\u0018\u0010_\u001a\u00020B2\u0006\u0010X\u001a\u00020Y2\u0006\u0010`\u001a\u00020YH\u0002J\b\u0010a\u001a\u00020BH\u0002J\b\u0010b\u001a\u00020BH\u0002J\b\u0010c\u001a\u00020BH\u0002J\u0010\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u00020\"H\u0002J\b\u0010f\u001a\u00020BH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000203X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010;X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\b>\u0010?\u00a8\u0006g"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterChatBoardActivity;", "Lcom/jobamax/appjobamax/base/BaseActivity;", "Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;", "()V", "alphaAnimator", "Landroid/animation/ObjectAnimator;", "binding", "Lcom/jobamax/appjobamax/databinding/ActivityRecruiterChatBoardBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ActivityRecruiterChatBoardBinding;", "binding$delegate", "Lkotlin/Lazy;", "chatMessageAdapter", "Lcom/jobamax/appjobamax/recruiter/message/RecruiterChatMessageAdapter;", "getChatMessageAdapter", "()Lcom/jobamax/appjobamax/recruiter/message/RecruiterChatMessageAdapter;", "setChatMessageAdapter", "(Lcom/jobamax/appjobamax/recruiter/message/RecruiterChatMessageAdapter;)V", "chatMessages", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/Message;", "chatThread", "Lcom/jobamax/appjobamax/model/ChatThread;", "getChatThread", "()Lcom/jobamax/appjobamax/model/ChatThread;", "setChatThread", "(Lcom/jobamax/appjobamax/model/ChatThread;)V", "countDownTimer", "Landroid/os/CountDownTimer;", "getCountDownTimer", "()Landroid/os/CountDownTimer;", "setCountDownTimer", "(Landroid/os/CountDownTimer;)V", "fileName", "", "imagePicker", "Lcom/jobamax/appjobamax/util/ImagePicker;", "getImagePicker", "()Lcom/jobamax/appjobamax/util/ImagePicker;", "setImagePicker", "(Lcom/jobamax/appjobamax/util/ImagePicker;)V", "jobTitleFilter", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "parseLiveQueryClient", "Lcom/parse/livequery/ParseLiveQueryClient;", "pqMessage", "Lcom/parse/ParseQuery;", "Lcom/parse/ParseObject;", "recorder", "Landroid/media/MediaRecorder;", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "recruitmentSeeker", "Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;", "subscriptionHandling", "Lcom/parse/livequery/SubscriptionHandling;", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "animation", "", "configureUi", "getChatMessages", "callback", "Lkotlin/Function1;", "", "initializeRecruiter", "initializeUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRecord", "sendAudioMessage", "audioUrl", "sendMessageNotification", "sendTextMessage", "setClickListeners", "setData", "setImageUri", "imageUri", "Landroid/net/Uri;", "imageCode", "", "setMessageImage", "imageUrl", "setParseLiveQuery", "setTimer", "millisInFuture", "setupImagePicker", "imagePickerType", "startChat", "startRecording", "stopRecording", "submitReport", "reason", "uploadAudio", "app_debug"})
public final class RecruiterChatBoardActivity extends com.jobamax.appjobamax.base.BaseActivity implements com.jobamax.appjobamax.util.ImagePicker.GetImage {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    private android.media.MediaRecorder recorder;
    private java.lang.String fileName = "";
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer countDownTimer;
    public com.jobamax.appjobamax.util.ImagePicker imagePicker;
    private com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker recruitmentSeeker;
    private com.jobamax.appjobamax.recruiter.model.JobTitleFilter jobTitleFilter;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.ChatThread chatThread;
    private final java.util.ArrayList<com.jobamax.appjobamax.model.Message> chatMessages = null;
    public com.jobamax.appjobamax.recruiter.message.RecruiterChatMessageAdapter chatMessageAdapter;
    private android.animation.ObjectAnimator alphaAnimator;
    private com.parse.livequery.ParseLiveQueryClient parseLiveQueryClient;
    private com.parse.livequery.SubscriptionHandling<com.parse.ParseObject> subscriptionHandling;
    private com.parse.ParseQuery<com.parse.ParseObject> pqMessage;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterChatBoardActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.ActivityRecruiterChatBoardBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    public final void setRecruiter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.Recruiter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.CountDownTimer getCountDownTimer() {
        return null;
    }
    
    public final void setCountDownTimer(@org.jetbrains.annotations.Nullable()
    android.os.CountDownTimer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.util.ImagePicker getImagePicker() {
        return null;
    }
    
    public final void setImagePicker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.util.ImagePicker p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.ChatThread getChatThread() {
        return null;
    }
    
    public final void setChatThread(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.ChatThread p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.message.RecruiterChatMessageAdapter getChatMessageAdapter() {
        return null;
    }
    
    public final void setChatMessageAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.message.RecruiterChatMessageAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configureUi() {
    }
    
    private final void setChatMessageAdapter() {
    }
    
    private final void initializeUi() {
    }
    
    private final void initializeRecruiter() {
    }
    
    public final void getRecruiter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    private final void setData() {
    }
    
    private final void startChat() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void getChatMessages() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void submitReport(java.lang.String reason) {
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
    
    private final void setupImagePicker(int imageCode, int imagePickerType) {
    }
    
    @java.lang.Override()
    public void setImageUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri, int imageCode) {
    }
    
    private final void setMessageImage(java.lang.String imageUrl) {
    }
    
    private final void sendMessageNotification() {
    }
    
    private final void animation() {
    }
    
    private final void sendTextMessage() {
    }
    
    private final void setTimer(int millisInFuture) {
    }
    
    private final void setParseLiveQuery() {
    }
}