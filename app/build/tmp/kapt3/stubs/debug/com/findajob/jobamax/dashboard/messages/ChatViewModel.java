package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0013H\u0002J\u000e\u0010\u001a\u001a\u00020R2\u0006\u0010T\u001a\u00020\u0013J\u0006\u0010U\u001a\u00020RJ\b\u0010V\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010=\u001a\u00020R2\u0006\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\u0013J\u000e\u0010Y\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u0013J\u000e\u0010Z\u001a\u00020R2\u0006\u0010T\u001a\u00020\u0013J\u0016\u0010[\u001a\u00020R2\u0006\u0010T\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020]J\u000e\u0010^\u001a\u00020R2\u0006\u0010X\u001a\u00020\u0013J\u000e\u0010_\u001a\u00020R2\u0006\u0010`\u001a\u00020aJ\u001c\u0010b\u001a\u00020R2\u0006\u0010T\u001a\u00020\u00132\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00130dJ\u000e\u0010e\u001a\u00020R2\u0006\u0010f\u001a\u00020\u0013J\u0006\u0010g\u001a\u00020RJ\u0010\u0010h\u001a\u00020R2\u0006\u0010i\u001a\u00020jH\u0002J\u000e\u0010k\u001a\u00020R2\u0006\u0010l\u001a\u00020mJ\u0016\u0010n\u001a\u00020R2\u0006\u0010o\u001a\u00020\u00132\u0006\u0010p\u001a\u00020\u0013J\u0016\u0010q\u001a\u00020R2\u0006\u0010T\u001a\u00020\u00132\u0006\u0010r\u001a\u00020\u0013J\u000e\u0010s\u001a\u00020R2\u0006\u0010t\u001a\u00020uJ\u000e\u0010v\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0013J\u000e\u0010w\u001a\u00020R2\u0006\u0010S\u001a\u00020\fJ\u000e\u0010x\u001a\u00020R2\u0006\u0010S\u001a\u00020\fJ\u0016\u0010P\u001a\u00020R2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010y\u001a\u00020\u0013J\u0010\u0010z\u001a\u00020R2\u0006\u0010\u0018\u001a\u00020\nH\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u00130\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\'\u0010\u001eR\u001b\u0010*\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b+\u0010\u001eR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u001b\u0010/\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b0\u0010\u001eR\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u001a\u00108\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\u001bR\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00130\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010)\u001a\u0004\bC\u0010DR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010#R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010#R \u0010J\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001e\"\u0004\bP\u0010 \u00a8\u0006{"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatViewModel;", "Lcom/findajob/jobamax/base/BaseViewModel;", "context", "Landroid/app/Application;", "repo", "Lcom/findajob/jobamax/repo/MessageRepository;", "(Landroid/app/Application;Lcom/findajob/jobamax/repo/MessageRepository;)V", "_chat", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/findajob/jobamax/data/pojo/Chat;", "_checkIfJobSeeker", "", "_currentUserObservable", "Lcom/parse/ParseObject;", "_form", "Lcom/findajob/jobamax/util/CustomLiveData;", "Lcom/findajob/jobamax/dashboard/messages/ChatForm;", "_name", "", "_receiverUserObservable", "autoCompletePublishSubjectMessage", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "chat", "Landroidx/lifecycle/LiveData;", "getChat", "()Landroidx/lifecycle/LiveData;", "chatSource", "getChatSource", "()Ljava/lang/String;", "setChatSource", "(Ljava/lang/String;)V", "checkIfJobSeeker", "getCheckIfJobSeeker", "()Landroidx/lifecycle/MutableLiveData;", "getContext", "()Landroid/app/Application;", "currentUsedId", "getCurrentUsedId", "currentUsedId$delegate", "Lkotlin/Lazy;", "currentUserEmail", "getCurrentUserEmail", "currentUserEmail$delegate", "currentUserObservable", "getCurrentUserObservable", "currentUserProfilePicUrl", "getCurrentUserProfilePicUrl", "currentUserProfilePicUrl$delegate", "fcmRepo", "Lcom/findajob/jobamax/repo/FCMRepo;", "form", "getForm", "inputTemplate", "getInputTemplate", "isChatEmpty", "()Z", "setChatEmpty", "(Z)V", "name", "getName", "receiverObjId", "receiverUserObservable", "getReceiverUserObservable", "requestQueue", "Lcom/android/volley/RequestQueue;", "getRequestQueue", "()Lcom/android/volley/RequestQueue;", "requestQueue$delegate", "selectFiles", "getSelectFiles", "selectImage", "getSelectImage", "threadStatus", "getThreadStatus", "setThreadStatus", "(Landroidx/lifecycle/MutableLiveData;)V", "uniqueMessageId", "getUniqueMessageId", "setUniqueMessageId", "filteredMessage", "", "value", "receiverObjectId", "getCurrentUser", "getCurrentUserInstant", "roleType", "userId", "getReceiverUserInstant", "getRecieverUser", "getRequirements", "callback", "Lcom/findajob/jobamax/repo/MessageRepository$GetRequirementsCallback;", "isAJobSeeker", "onMessageChange", "text", "", "saveRequirements", "arrRequirements", "Ljava/util/ArrayList;", "sendImage", "url", "sendMessage", "sendNotification", "notification", "Lorg/json/JSONObject;", "sendPushNotificationByUserId", "requestData", "Lcom/findajob/jobamax/model/fcm/PushNotification;", "sendRequirementsNotification", "uniqueId", "requirements", "setAsSource", "jobOfferId", "setInputTemplate", "index", "", "setReceiverId", "setSelectFiles", "setSelectImage", "receiverId", "toggleSeen", "app_debug"})
public final class ChatViewModel extends com.findajob.jobamax.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    private final com.findajob.jobamax.repo.MessageRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> selectImage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> selectFiles = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUsedId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUserEmail$delegate = null;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _currentUserObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> currentUserObservable = null;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _receiverUserObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> receiverUserObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> inputTemplate = null;
    private final com.findajob.jobamax.repo.FCMRepo fcmRepo = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> receiverObjId = null;
    private final com.findajob.jobamax.util.CustomLiveData<com.findajob.jobamax.dashboard.messages.ChatForm> _form = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.dashboard.messages.ChatForm> form = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.data.pojo.Chat>> _chat = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.data.pojo.Chat>> chat = null;
    private boolean isChatEmpty = true;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String chatSource = "isJob";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uniqueMessageId = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> threadStatus;
    private final io.reactivex.subjects.PublishSubject<java.lang.String> autoCompletePublishSubjectMessage = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _name = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> name = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _checkIfJobSeeker = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> checkIfJobSeeker = null;
    private final kotlin.Lazy requestQueue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUserProfilePicUrl$delegate = null;
    
    @javax.inject.Inject()
    public ChatViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.MessageRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getSelectImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getSelectFiles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUsedId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getCurrentUserObservable() {
        return null;
    }
    
    public final void getCurrentUser() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCurrentUserInstant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject getReceiverUserInstant(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getReceiverUserObservable() {
        return null;
    }
    
    public final void getRecieverUser(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getInputTemplate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.dashboard.messages.ChatForm> getForm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.data.pojo.Chat>> getChat() {
        return null;
    }
    
    public final boolean isChatEmpty() {
        return false;
    }
    
    public final void setChatEmpty(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChatSource() {
        return null;
    }
    
    public final void setChatSource(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUniqueMessageId() {
        return null;
    }
    
    public final void setUniqueMessageId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getThreadStatus() {
        return null;
    }
    
    public final void setThreadStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getName() {
        return null;
    }
    
    public final void getName(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType, @org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    public final void onMessageChange(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence text) {
    }
    
    private final void filteredMessage(java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getCheckIfJobSeeker() {
        return null;
    }
    
    public final void isAJobSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    public final void getChat(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId) {
    }
    
    private final void toggleSeen(com.findajob.jobamax.data.pojo.Chat chat) {
    }
    
    public final void setAsSource(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId) {
    }
    
    public final void sendMessage() {
    }
    
    public final void sendImage(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public final void setSelectImage(boolean value) {
    }
    
    public final void setSelectFiles(boolean value) {
    }
    
    public final void setInputTemplate(int index) {
    }
    
    public final void setReceiverId(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void sendPushNotificationByUserId(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.fcm.PushNotification requestData) {
    }
    
    public final void saveRequirements(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> arrRequirements) {
    }
    
    public final void getRequirements(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.MessageRepository.GetRequirementsCallback callback) {
    }
    
    public final void sendRequirementsNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String uniqueId, @org.jetbrains.annotations.NotNull()
    java.lang.String requirements) {
    }
    
    private final com.android.volley.RequestQueue getRequestQueue() {
        return null;
    }
    
    private final void sendNotification(org.json.JSONObject notification) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserProfilePicUrl() {
        return null;
    }
    
    public final void setUniqueMessageId(@org.jetbrains.annotations.NotNull()
    java.lang.String currentUsedId, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverId) {
    }
}