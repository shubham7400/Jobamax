package com.jobamax.appjobamax.model;

import com.jobamax.appjobamax.enums.ParseTableFields;
import com.parse.ParseObject;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0010\u0018\u0000 r2\u00020\u0001:\u0001rB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010q\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010\'R\u001a\u0010*\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010\'R\u001a\u0010,\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR\u001a\u00102\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010%\"\u0004\b4\u0010\'R\u001a\u00105\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010%\"\u0004\b7\u0010\'R\u001a\u00108\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010%\"\u0004\b:\u0010\'R\u001a\u0010;\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010\'R\u001a\u0010>\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR\u001a\u0010A\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR\u001a\u0010D\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR\u001a\u0010G\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\f\"\u0004\bI\u0010\u000eR\u001a\u0010J\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010%\"\u0004\bL\u0010\'R\u001a\u0010M\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR\u001c\u0010P\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\bR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020ZX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\f\"\u0004\ba\u0010\u000eR \u0010b\u001a\b\u0012\u0004\u0012\u00020\n0cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010%\"\u0004\bj\u0010\'R\u001a\u0010k\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\f\"\u0004\bm\u0010\u000eR\u001a\u0010n\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\f\"\u0004\bp\u0010\u000e\u00a8\u0006s"}, d2 = {"Lcom/jobamax/appjobamax/model/Recruiter;", "", "user", "Lcom/jobamax/appjobamax/model/User;", "(Lcom/jobamax/appjobamax/model/User;)V", "()V", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "age", "", "getAge", "()Ljava/lang/String;", "setAge", "(Ljava/lang/String;)V", "company", "getCompany", "()Lcom/parse/ParseObject;", "setCompany", "companyId", "getCompanyId", "setCompanyId", "dob", "getDob", "setDob", "email", "getEmail", "setEmail", "firstName", "getFirstName", "setFirstName", "gender", "getGender", "setGender", "hideMeFlag", "", "getHideMeFlag", "()Z", "setHideMeFlag", "(Z)V", "isNetworkingHandRaised", "setNetworkingHandRaised", "isNetworkingMuted", "setNetworkingMuted", "lastName", "getLastName", "setLastName", "loginType", "getLoginType", "setLoginType", "messagePNFlag", "getMessagePNFlag", "setMessagePNFlag", "newMatchPNFlag", "getNewMatchPNFlag", "setNewMatchPNFlag", "newsLetterNotification", "getNewsLetterNotification", "setNewsLetterNotification", "newsLetterPNFlag", "getNewsLetterPNFlag", "setNewsLetterPNFlag", "password", "getPassword", "setPassword", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "postCode", "getPostCode", "setPostCode", "profilePicUrl", "getProfilePicUrl", "setProfilePicUrl", "readReceiptFlag", "getReadReceiptFlag", "setReadReceiptFlag", "recruiterId", "getRecruiterId", "setRecruiterId", "recruiterParseObject", "getRecruiterParseObject", "setRecruiterParseObject", "roomExpiryDate", "Ljava/util/Date;", "getRoomExpiryDate", "()Ljava/util/Date;", "setRoomExpiryDate", "(Ljava/util/Date;)V", "roomId", "", "getRoomId", "()I", "setRoomId", "(I)V", "scheduleLink", "getScheduleLink", "setScheduleLink", "socialAccounts", "", "getSocialAccounts", "()Ljava/util/List;", "setSocialAccounts", "(Ljava/util/List;)V", "temporaryDisableFlag", "getTemporaryDisableFlag", "setTemporaryDisableFlag", "temporaryDisableTime", "getTemporaryDisableTime", "setTemporaryDisableTime", "userId", "getUserId", "setUserId", "toParseObject", "Companion", "app_debug"})
public final class Recruiter {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String recruiterId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gender = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String age = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profilePicUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String loginType = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dob = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String postCode = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String email = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String scheduleLink = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String phoneNumber = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyId = "";
    private boolean hideMeFlag = false;
    private boolean readReceiptFlag = false;
    private boolean newMatchPNFlag = false;
    private boolean messagePNFlag = false;
    private boolean isNetworkingMuted = false;
    private boolean isNetworkingHandRaised = false;
    private boolean newsLetterPNFlag = false;
    private boolean temporaryDisableFlag = false;
    private boolean newsLetterNotification = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String temporaryDisableTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> socialAccounts;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject company;
    private int roomId = 0;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date roomExpiryDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String password = "";
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject recruiterParseObject;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.model.Recruiter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CLASS_NAME = "Recruiter";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRecruiterId() {
        return null;
    }
    
    public final void setRecruiterId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    public final java.lang.String getAge() {
        return null;
    }
    
    public final void setAge(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getLoginType() {
        return null;
    }
    
    public final void setLoginType(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getPostCode() {
        return null;
    }
    
    public final void setPostCode(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getScheduleLink() {
        return null;
    }
    
    public final void setScheduleLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyId() {
        return null;
    }
    
    public final void setCompanyId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getHideMeFlag() {
        return false;
    }
    
    public final void setHideMeFlag(boolean p0) {
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
    
    public final boolean getNewsLetterPNFlag() {
        return false;
    }
    
    public final void setNewsLetterPNFlag(boolean p0) {
    }
    
    public final boolean getTemporaryDisableFlag() {
        return false;
    }
    
    public final void setTemporaryDisableFlag(boolean p0) {
    }
    
    public final boolean getNewsLetterNotification() {
        return false;
    }
    
    public final void setNewsLetterNotification(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTemporaryDisableTime() {
        return null;
    }
    
    public final void setTemporaryDisableTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSocialAccounts() {
        return null;
    }
    
    public final void setSocialAccounts(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCompany() {
        return null;
    }
    
    public final void setCompany(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getRecruiterParseObject() {
        return null;
    }
    
    public final void setRecruiterParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    public Recruiter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.User user) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    public Recruiter() {
        super();
    }
    
    public Recruiter(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/jobamax/appjobamax/model/Recruiter$Companion;", "", "()V", "CLASS_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}