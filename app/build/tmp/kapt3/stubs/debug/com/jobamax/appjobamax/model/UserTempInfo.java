package com.jobamax.appjobamax.model;

import java.io.Serializable;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b\'\u0010\u000fR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001e\u00101\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\b\u00a8\u00064"}, d2 = {"Lcom/jobamax/appjobamax/model/UserTempInfo;", "Ljava/io/Serializable;", "()V", "age", "", "getAge", "()Ljava/lang/Integer;", "setAge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "firstName", "getFirstName", "setFirstName", "jobLocation", "Lcom/jobamax/appjobamax/model/JobLocation;", "getJobLocation", "()Lcom/jobamax/appjobamax/model/JobLocation;", "setJobLocation", "(Lcom/jobamax/appjobamax/model/JobLocation;)V", "lastName", "getLastName", "setLastName", "loginType", "getLoginType", "setLoginType", "password", "getPassword", "setPassword", "profilePicUrl", "getProfilePicUrl", "setProfilePicUrl", "promoCode", "getPromoCode", "setPromoCode", "university", "Lcom/jobamax/appjobamax/model/University;", "getUniversity", "()Lcom/jobamax/appjobamax/model/University;", "setUniversity", "(Lcom/jobamax/appjobamax/model/University;)V", "userId", "getUserId", "setUserId", "userType", "getUserType", "setUserType", "app_debug"})
public final class UserTempInfo implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String email = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String loginType = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String password = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profilePicUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userId = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer userType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer age;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.University university;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.JobLocation jobLocation;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String promoCode;
    
    public UserTempInfo() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getUserType() {
        return null;
    }
    
    public final void setUserType(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAge() {
        return null;
    }
    
    public final void setAge(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.University getUniversity() {
        return null;
    }
    
    public final void setUniversity(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.University p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.JobLocation getJobLocation() {
        return null;
    }
    
    public final void setJobLocation(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.JobLocation p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPromoCode() {
        return null;
    }
    
    public final void setPromoCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}