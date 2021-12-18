package com.findajob.jobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\'\n\u0002\u0010\u0007\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 \u00a8\u00012\u00020\u0001:\u0002\u00a8\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u0007\b\u0016\u00a2\u0006\u0002\u0010\bJ\u0007\u0010\u00a7\u0001\u001a\u00020\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010\'\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001a\u00100\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR \u00103\u001a\b\u0012\u0004\u0012\u00020\n04X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR\u001a\u0010?\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010\u000eR\u001a\u0010B\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\f\"\u0004\bD\u0010\u000eR\u001a\u0010E\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0018\"\u0004\bG\u0010\u001aR\u001a\u0010H\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010\u001aR\u001a\u0010J\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0018\"\u0004\bK\u0010\u001aR\u001a\u0010L\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000eR \u0010O\u001a\b\u0012\u0004\u0012\u00020\n04X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u00106\"\u0004\bQ\u00108R\u001a\u0010R\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\f\"\u0004\bT\u0010\u000eR\u001a\u0010U\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR\u001a\u0010X\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\f\"\u0004\bZ\u0010\u000eR\u001a\u0010[\u001a\u00020\\X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010a\u001a\u00020\\X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R\u001a\u0010d\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010\f\"\u0004\bf\u0010\u000eR\u001a\u0010g\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010\u000eR\u001a\u0010j\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0018\"\u0004\bl\u0010\u001aR\u001a\u0010m\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0018\"\u0004\bo\u0010\u001aR\u001a\u0010p\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0018\"\u0004\br\u0010\u001aR\u001a\u0010s\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\f\"\u0004\bu\u0010\u000eR\u001a\u0010v\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\f\"\u0004\bx\u0010\u000eR\u001a\u0010y\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\f\"\u0004\b{\u0010\u000eR\u001a\u0010|\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\f\"\u0004\b~\u0010\u000eR\u001c\u0010\u007f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\f\"\u0005\b\u0081\u0001\u0010\u000eR\u001d\u0010\u0082\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0018\"\u0005\b\u0084\u0001\u0010\u001aR\"\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001d\u0010\u008b\u0001\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u001e\"\u0005\b\u008d\u0001\u0010 R\u001d\u0010\u008e\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\f\"\u0005\b\u0090\u0001\u0010\u000eR#\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\n04X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u00106\"\u0005\b\u0093\u0001\u00108R\u001d\u0010\u0094\u0001\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u001e\"\u0005\b\u0096\u0001\u0010 R\u001d\u0010\u0097\u0001\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u001e\"\u0005\b\u0099\u0001\u0010 R#\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\n04X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u00106\"\u0005\b\u009c\u0001\u00108R\u001d\u0010\u009d\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\f\"\u0005\b\u009f\u0001\u0010\u000eR \u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0011\n\u0000\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001\"\u0005\b\u00a3\u0001\u0010\u0007R\u001d\u0010\u00a4\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a5\u0001\u0010\f\"\u0005\b\u00a6\u0001\u0010\u000e\u00a8\u0006\u00a9\u0001"}, d2 = {"Lcom/findajob/jobamax/model/JobSeeker;", "", "user", "Lcom/findajob/jobamax/model/User;", "(Lcom/findajob/jobamax/model/User;)V", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "()V", "aboutMe", "", "getAboutMe", "()Ljava/lang/String;", "setAboutMe", "(Ljava/lang/String;)V", "activities", "getActivities", "setActivities", "attachmentCVLink", "getAttachmentCVLink", "setAttachmentCVLink", "disableAccountFlag", "", "getDisableAccountFlag", "()Z", "setDisableAccountFlag", "(Z)V", "distance", "", "getDistance", "()I", "setDistance", "(I)V", "dob", "getDob", "setDob", "documentName", "getDocumentName", "setDocumentName", "documentUrl", "getDocumentUrl", "setDocumentUrl", "educations", "getEducations", "setEducations", "email", "getEmail", "setEmail", "emailVerified", "getEmailVerified", "setEmailVerified", "experience", "", "getExperience", "()Ljava/util/List;", "setExperience", "(Ljava/util/List;)V", "experiences", "getExperiences", "setExperiences", "firstName", "getFirstName", "setFirstName", "gender", "getGender", "setGender", "gotReferralCode", "getGotReferralCode", "setGotReferralCode", "hideMeFlag", "getHideMeFlag", "setHideMeFlag", "isNetworkingHandRaised", "setNetworkingHandRaised", "isNetworkingMuted", "setNetworkingMuted", "job", "getJob", "setJob", "jobCategory", "getJobCategory", "setJobCategory", "jobSeekerId", "getJobSeekerId", "setJobSeekerId", "lastName", "getLastName", "setLastName", "lastTodayReachUpdatedAt", "getLastTodayReachUpdatedAt", "setLastTodayReachUpdatedAt", "lat", "", "getLat", "()F", "setLat", "(F)V", "lng", "getLng", "setLng", "location", "getLocation", "setLocation", "loginType", "getLoginType", "setLoginType", "messagePNFlag", "getMessagePNFlag", "setMessagePNFlag", "newMatchPNFlag", "getNewMatchPNFlag", "setNewMatchPNFlag", "newsLetterPNFlag", "getNewsLetterPNFlag", "setNewsLetterPNFlag", "password", "getPassword", "setPassword", "personalPresentationLink", "getPersonalPresentationLink", "setPersonalPresentationLink", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "postCode", "getPostCode", "setPostCode", "profilePicUrl", "getProfilePicUrl", "setProfilePicUrl", "readReceiptFlag", "getReadReceiptFlag", "setReadReceiptFlag", "roomExpiryDate", "Ljava/util/Date;", "getRoomExpiryDate", "()Ljava/util/Date;", "setRoomExpiryDate", "(Ljava/util/Date;)V", "roomId", "getRoomId", "setRoomId", "skills", "getSkills", "setSkills", "socialAccounts", "getSocialAccounts", "setSocialAccounts", "todayReach", "getTodayReach", "setTodayReach", "totalReach", "getTotalReach", "setTotalReach", "typeOfWork", "getTypeOfWork", "setTypeOfWork", "userId", "getUserId", "setUserId", "userObj", "getUserObj", "()Lcom/parse/ParseObject;", "setUserObj", "videoThumbnailUrl", "getVideoThumbnailUrl", "setVideoThumbnailUrl", "toParseObject", "Companion", "app_debug"})
public final class JobSeeker {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobSeekerId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userId = "";
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject userObj;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gender = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String loginType = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profilePicUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String postCode = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dob = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String email = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String phoneNumber = "";
    private boolean readReceiptFlag = false;
    private boolean newMatchPNFlag = false;
    private boolean messagePNFlag = false;
    private boolean newsLetterPNFlag = false;
    private boolean isNetworkingMuted = false;
    private boolean isNetworkingHandRaised = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String personalPresentationLink = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String attachmentCVLink = "";
    private boolean hideMeFlag = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String job = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String location = "";
    private int distance = 0;
    private float lat = 0.0F;
    private float lng = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> typeOfWork;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> jobCategory;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> experience;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> socialAccounts;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String educations = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String experiences = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String skills = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String activities = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String aboutMe = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String videoThumbnailUrl = "";
    private boolean disableAccountFlag = false;
    private int totalReach = 0;
    private int todayReach = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastTodayReachUpdatedAt = "";
    private int roomId = 0;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date roomExpiryDate;
    private boolean emailVerified = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String password = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gotReferralCode = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.model.JobSeeker.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CLASS_NAME = "JobSeeker";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final void setJobSeekerId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getUserObj() {
        return null;
    }
    
    public final void setUserObj(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstName() {
        return null;
    }
    
    public final void setFirstName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastName() {
        return null;
    }
    
    public final void setLastName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoginType() {
        return null;
    }
    
    public final void setLoginType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfilePicUrl() {
        return null;
    }
    
    public final void setProfilePicUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPostCode() {
        return null;
    }
    
    public final void setPostCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDob() {
        return null;
    }
    
    public final void setDob(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getReadReceiptFlag() {
        return false;
    }
    
    public final void setReadReceiptFlag(boolean p0) {
    }
    
    public final boolean getNewMatchPNFlag() {
        return false;
    }
    
    public final void setNewMatchPNFlag(boolean p0) {
    }
    
    public final boolean getMessagePNFlag() {
        return false;
    }
    
    public final void setMessagePNFlag(boolean p0) {
    }
    
    public final boolean getNewsLetterPNFlag() {
        return false;
    }
    
    public final void setNewsLetterPNFlag(boolean p0) {
    }
    
    public final boolean isNetworkingMuted() {
        return false;
    }
    
    public final void setNetworkingMuted(boolean p0) {
    }
    
    public final boolean isNetworkingHandRaised() {
        return false;
    }
    
    public final void setNetworkingHandRaised(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonalPresentationLink() {
        return null;
    }
    
    public final void setPersonalPresentationLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAttachmentCVLink() {
        return null;
    }
    
    public final void setAttachmentCVLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getHideMeFlag() {
        return false;
    }
    
    public final void setHideMeFlag(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getDistance() {
        return 0;
    }
    
    public final void setDistance(int p0) {
    }
    
    public final float getLat() {
        return 0.0F;
    }
    
    public final void setLat(float p0) {
    }
    
    public final float getLng() {
        return 0.0F;
    }
    
    public final void setLng(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTypeOfWork() {
        return null;
    }
    
    public final void setTypeOfWork(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getJobCategory() {
        return null;
    }
    
    public final void setJobCategory(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExperience() {
        return null;
    }
    
    public final void setExperience(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSocialAccounts() {
        return null;
    }
    
    public final void setSocialAccounts(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentUrl() {
        return null;
    }
    
    public final void setDocumentUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEducations() {
        return null;
    }
    
    public final void setEducations(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExperiences() {
        return null;
    }
    
    public final void setExperiences(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSkills() {
        return null;
    }
    
    public final void setSkills(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActivities() {
        return null;
    }
    
    public final void setActivities(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAboutMe() {
        return null;
    }
    
    public final void setAboutMe(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentName() {
        return null;
    }
    
    public final void setDocumentName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVideoThumbnailUrl() {
        return null;
    }
    
    public final void setVideoThumbnailUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getDisableAccountFlag() {
        return false;
    }
    
    public final void setDisableAccountFlag(boolean p0) {
    }
    
    public final int getTotalReach() {
        return 0;
    }
    
    public final void setTotalReach(int p0) {
    }
    
    public final int getTodayReach() {
        return 0;
    }
    
    public final void setTodayReach(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastTodayReachUpdatedAt() {
        return null;
    }
    
    public final void setLastTodayReachUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getRoomId() {
        return 0;
    }
    
    public final void setRoomId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getRoomExpiryDate() {
        return null;
    }
    
    public final void setRoomExpiryDate(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    public final boolean getEmailVerified() {
        return false;
    }
    
    public final void setEmailVerified(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGotReferralCode() {
        return null;
    }
    
    public final void setGotReferralCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    public JobSeeker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user) {
        super();
    }
    
    public JobSeeker(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    public JobSeeker() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/model/JobSeeker$Companion;", "", "()V", "CLASS_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}