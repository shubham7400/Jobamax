package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002xyB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0019\u0010+\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J\u0018\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0016\u00104\u001a\u00020\'2\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u000207J@\u00108\u001a4\u00120\u0012.\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;\u0012\u0004\u0012\u000203 \b*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;\u0012\u0004\u0012\u000203\u0018\u00010:0:092\u0006\u0010,\u001a\u00020\u0019J\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u000709J\u0006\u0010=\u001a\u00020\u0019J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070;2\u0006\u0010?\u001a\u00020\u0019J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070;2\u0006\u0010?\u001a\u00020\u0019J(\u0010A\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020B \b*\n\u0012\u0004\u0012\u00020B\u0018\u00010;0;092\u0006\u0010C\u001a\u00020\u0007J(\u0010D\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000200 \b*\n\u0012\u0004\u0012\u000200\u0018\u00010;0;092\u0006\u0010C\u001a\u00020\u0007J\u0012\u0010E\u001a\u0004\u0018\u00010\u00072\u0006\u0010?\u001a\u00020\u0019H\u0002J(\u0010F\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020G \b*\n\u0012\u0004\u0012\u00020G\u0018\u00010;0;092\u0006\u0010H\u001a\u00020\u0019J<\u0010I\u001a\u00020\'2\u0006\u0010J\u001a\u00020\u00192\u0018\u0010K\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002000;\u0012\u0004\u0012\u00020\'0L2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\'0LJ$\u0010N\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00190\u0019092\u0006\u0010H\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019J(\u0010O\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190P2\u0006\u0010Q\u001a\u00020\u0007H\u0002J(\u0010R\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020B \b*\n\u0012\u0004\u0012\u00020B\u0018\u00010;0;092\u0006\u0010H\u001a\u00020SJ\u0012\u0010T\u001a\u0004\u0018\u00010\u00072\u0006\u0010?\u001a\u00020\u0019H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010\u00072\u0006\u00105\u001a\u00020\u0019H\u0002J\u0016\u0010V\u001a\u00020\'2\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u000207J\u001e\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070;2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010X\u001a\u00020\u0007H\u0002J\u0016\u0010Y\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u00192\u0006\u00106\u001a\u00020ZJ(\u0010[\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020G \b*\n\u0012\u0004\u0012\u00020G\u0018\u00010;0;092\u0006\u0010H\u001a\u00020\u0019J\u001c\u0010\\\u001a\u00020\'2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\'0LH\u0002J\u0010\u0010^\u001a\u0004\u0018\u00010\u00072\u0006\u0010?\u001a\u00020\u0019J\u001c\u0010_\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007092\u0006\u0010?\u001a\u00020\u0019J\u001c\u0010`\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010303092\u0006\u0010?\u001a\u00020\u0019J\u0019\u0010a\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J\u0019\u0010b\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J!\u0010c\u001a\u00020\'2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dJ\u0019\u0010e\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J \u0010f\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J&\u0010g\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u00192\u0016\u0010h\u001a\u0012\u0012\u0004\u0012\u00020\u00190ij\b\u0012\u0004\u0012\u00020\u0019`jJ:\u0010k\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010303092\u001c\u0010l\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0006\u0012\u0004\u0018\u00010\u00190P2\u0006\u0010J\u001a\u00020\u0019J:\u0010m\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010303092\u001c\u0010l\u001a\u0018\u0012\u0004\u0012\u00020n\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0006\u0012\u0004\u0018\u00010\u00190P2\u0006\u0010J\u001a\u00020\u0019J!\u0010o\u001a\u00020\'2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010p\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dJ\u0019\u0010q\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J!\u0010r\u001a\u00020\'2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dJ\u0019\u0010s\u001a\u00020\'2\u0006\u0010l\u001a\u00020<H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010tJ\u0019\u0010u\u001a\u00020\'2\u0006\u0010p\u001a\u00020\u0019H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\u0019\u0010v\u001a\u00020\'2\u0006\u0010/\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J!\u0010w\u001a\u00020\'2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dR2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006z"}, d2 = {"Lcom/findajob/jobamax/repo/MessageRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_parseJobSeekerQuery", "Lcom/parse/ParseQuery;", "Lcom/parse/ParseObject;", "kotlin.jvm.PlatformType", "_parseRecruiterQuery", "get_parseRecruiterQuery", "()Lcom/parse/ParseQuery;", "_parseRecruiterQuery$delegate", "Lkotlin/Lazy;", "_userQuery", "get_userQuery", "_userQuery$delegate", "getContext", "()Landroid/content/Context;", "currentUser", "getCurrentUser", "()Lcom/parse/ParseObject;", "setCurrentUser", "(Lcom/parse/ParseObject;)V", "currentUserEmail", "", "getCurrentUserEmail", "()Ljava/lang/String;", "currentUserEmail$delegate", "currentUserId", "getCurrentUserId", "currentUserId$delegate", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/findajob/jobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/findajob/jobamax/model/JobSeeker;)V", "createRelation", "", "key", "firstUser", "secondUser", "deleteChat", "receiverObjectId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessage", "message", "Lcom/findajob/jobamax/data/pojo/Message;", "(Lcom/findajob/jobamax/data/pojo/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findRelationSource", "", "getAllJobOffers", "recruiterId", "callback", "Lcom/findajob/jobamax/repo/GetAllJobOfferCallback;", "getChats", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/findajob/jobamax/data/pojo/Chat;", "getCurrentUsersProfilePicUrl", "getExistingJobSeeker", "userId", "getExistingRecruiter", "getFilteredOfferMatches", "Lcom/findajob/jobamax/data/pojo/NewPeople;", "offer", "getFilteredOfferMessages", "getJobSeekerById", "getMatchedUsers", "Lcom/findajob/jobamax/data/pojo/CurrentOnline;", "roleType", "getMessages", "source", "onSuccess", "Lkotlin/Function1;", "onFailure", "getName", "getNameProfileOfNewMatchedUsers", "Lkotlin/Triple;", "it", "getNewMatchedUsers", "", "getRecruiterById", "getRecruiterByRecruiterId", "getRecruiterOffers", "getRelatedDatabaseData", "parseObject", "getRequirements", "Lcom/findajob/jobamax/repo/MessageRepository$GetRequirementsCallback;", "getSourcedUsers", "getUser", "listen", "getUserById", "getUserByIdInBackground", "isAJobSeeker", "makeMessageSeen", "markMessageAsSource", "matchUser", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromShortlist", "removeMatchRelation", "saveRequirements", "requirements", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sendImage", "chat", "sendMessage", "Lcom/findajob/jobamax/dashboard/messages/ChatForm;", "setMessageAsSource", "jobOfferId", "shortListAMessage", "sourceUser", "toggleSeen", "(Lcom/findajob/jobamax/data/pojo/Chat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unArchiveJobOffer", "unarchiveConversation", "unmatchUser", "GetOffersCallback", "GetRequirementsCallback", "app_debug"})
public final class MessageRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.model.JobSeeker jobSeeker;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject currentUser;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUserId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUserEmail$delegate = null;
    private final kotlin.Lazy _userQuery$delegate = null;
    private final kotlin.Lazy _parseRecruiterQuery$delegate = null;
    private final com.parse.ParseQuery<com.parse.ParseObject> _parseJobSeekerQuery = null;
    
    @javax.inject.Inject()
    public MessageRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.model.JobSeeker p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCurrentUser() {
        return null;
    }
    
    public final void setCurrentUser(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    private final void getUser(kotlin.jvm.functions.Function1<? super com.findajob.jobamax.model.JobSeeker, kotlin.Unit> listen) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> getCurrentUser() {
        return null;
    }
    
    private final com.parse.ParseQuery<com.parse.ParseObject> get_userQuery() {
        return null;
    }
    
    private final com.parse.ParseQuery<com.parse.ParseObject> get_parseRecruiterQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setMessageAsSource(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Gets the chat lists based on the user id
     *
     * @return a pair of list of [Chat] and a [Boolean] denoting if the chat is empty or not
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<kotlin.Pair<java.util.List<com.findajob.jobamax.data.pojo.Chat>, java.lang.Boolean>> getChats(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId) {
        return null;
    }
    
    /**
     * Deletes the chats and all the messages from both user side
     *
     * @param receiverObjectId which is a [String]
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteChat(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteMessage(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUsersProfilePicUrl() {
        return null;
    }
    
    /**
     * This function takes the user id, and returns Recruiter Parse Object
     *
     * @param userId as String
     *
     * @return Recruiter [ParseObject]
     */
    private final com.parse.ParseObject getRecruiterById(java.lang.String userId) {
        return null;
    }
    
    /**
     * This function takes the user id, and returns JobSeeker Parse Object
     *
     * @param userId as String
     *
     * @return JobSeeker [ParseObject]
     */
    private final com.parse.ParseObject getJobSeekerById(java.lang.String userId) {
        return null;
    }
    
    /**
     * This function takes the user id, and returns an User Parse Object
     *
     * @param userId as String
     *
     * @return _User [ParseObject]
     */
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getUserById(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> getUserByIdInBackground(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    private final com.parse.ParseObject getRecruiterByRecruiterId(java.lang.String recruiterId) {
        return null;
    }
    
    /**
     * Creates an one-to-one relation with the key RELATION_KEY_MATCHED
     *
     * @param firstUser, a ParseObject
     * @param secondUser, a ParseObject
     */
    private final void createRelation(java.lang.String key, com.parse.ParseObject firstUser, com.parse.ParseObject secondUser) {
    }
    
    /**
     * Matches the current user with the one specified
     *
     * @param receiverObjectId as [String] of the person the current user going to be matched
     * with
     * @param roleType as [String] of the current user, if he is a [Recruiter] or a [JobSeeker]
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object matchUser(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Removes the one-to-one relation with the key RELATION_KEY_MATCHED
     *
     * @param firstUser, a ParseObject
     * @param secondUser, a ParseObject
     */
    private final void removeMatchRelation(java.lang.String key, com.parse.ParseObject firstUser, com.parse.ParseObject secondUser) {
    }
    
    /**
     * Removes the match of the current user with the one specified
     *
     * @param receiverObjectId as [String] of the person the current user going to cut the match
     * with
     * @param roleType as [String] of the current user, if he is a [Recruiter] or a [JobSeeker]
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object unmatchUser(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.util.List<com.parse.ParseObject> getRelatedDatabaseData(java.lang.String key, com.parse.ParseObject parseObject) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.findajob.jobamax.data.pojo.CurrentOnline>> getMatchedUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType) {
        return null;
    }
    
    private final java.lang.Object markMessageAsSource(com.findajob.jobamax.data.pojo.Message message, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final boolean findRelationSource(com.parse.ParseObject firstUser, com.parse.ParseObject secondUser) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sourceUser(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.findajob.jobamax.data.pojo.CurrentOnline>> getSourcedUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType) {
        return null;
    }
    
    private final kotlin.Triple<java.lang.String, java.lang.String, java.lang.String> getNameProfileOfNewMatchedUsers(com.parse.ParseObject it) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.findajob.jobamax.data.pojo.NewPeople>> getNewMatchedUsers(int roleType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.String> getName(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId) {
        return null;
    }
    
    /**
     * Toggles seen icon when the user sees the message
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object toggleSeen(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Chat chat, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.Boolean> sendMessage(@org.jetbrains.annotations.NotNull()
    kotlin.Triple<com.findajob.jobamax.dashboard.messages.ChatForm, java.lang.Boolean, java.lang.String> chat, @org.jetbrains.annotations.NotNull()
    java.lang.String source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.Boolean> sendImage(@org.jetbrains.annotations.NotNull()
    kotlin.Triple<java.lang.String, java.lang.Boolean, java.lang.String> chat, @org.jetbrains.annotations.NotNull()
    java.lang.String source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.findajob.jobamax.data.pojo.NewPeople>> getFilteredOfferMatches(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject offer) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.findajob.jobamax.data.pojo.Message>> getFilteredOfferMessages(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject offer) {
        return null;
    }
    
    public final void getMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.findajob.jobamax.data.pojo.Message>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFailure) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object makeMessageSeen(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Short list a message, by adding the current user to the short listed by
     * list of the message table
     *
     * @param message of [Message] type
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object shortListAMessage(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeFromShortlist(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.parse.ParseObject> getExistingJobSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    /**
     * Determine whether the user with the user id provided
     * is a job seeker or not
     * If he is, it will emit true, or else will emit false
     *
     * @param userId id of the user that will queried in [String]
     *
     * @return [Single] of [Boolean] type
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.Boolean> isAJobSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    public final void getRecruiterOffers(@org.jetbrains.annotations.NotNull()
    java.lang.String recruiterId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.parse.ParseObject> getExistingRecruiter(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    public final void getAllJobOffers(@org.jetbrains.annotations.NotNull()
    java.lang.String recruiterId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    public final void saveRequirements(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> requirements) {
    }
    
    public final void getRequirements(@org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.MessageRepository.GetRequirementsCallback callback) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object unarchiveConversation(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object unArchiveJobOffer(java.lang.String jobOfferId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/findajob/jobamax/repo/MessageRepository$GetOffersCallback;", "", "onFinish", "", "app_debug"})
    public static abstract interface GetOffersCallback {
        
        public abstract void onFinish();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/repo/MessageRepository$GetRequirementsCallback;", "", "onFinish", "", "requirements", "", "", "app_debug"})
    public static abstract interface GetRequirementsCallback {
        
        public abstract void onFinish(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> requirements);
    }
}