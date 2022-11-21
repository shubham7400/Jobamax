package com.jobamax.appjobamax.preference;

import android.content.Context;
import com.jobamax.appjobamax.model.User;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0004\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\n\u001a\u00020\u0007*\u00020\u0004\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0004\u001a\n\u0010\u000f\u001a\u00020\u0007*\u00020\u0004\u001a\u0012\u0010\u0010\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0012\u0010\u0012\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007\u001a\u0012\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007\u001a\u0012\u0010\u0017\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001\u001a\u0012\u0010\u0019\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007\u001a\u0012\u0010\u001a\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010\u001c\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010\u001d\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"FILE_NAME", "", "clearUserPref", "", "Landroid/content/Context;", "getCurrentLocation", "getJobSearchType", "", "getLanguage", "getLoginType", "getSeenOnBoarding", "getUserId", "getUserObjectId", "getUserType", "", "isLoggedIn", "setCurrentLocation", "location", "setJobSearchType", "flag", "setLanguage", "languageCode", "setLoggedIn", "setLoginType", "type", "setSeenOnBoarding", "setUserId", "str", "setUserObjectId", "setUserType", "userType", "app_debug"})
public final class UserPreferenceKt {
    private static final java.lang.String FILE_NAME = "user_pref";
    
    public static final void clearUserPref(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$clearUserPref) {
    }
    
    public static final boolean isLoggedIn(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isLoggedIn) {
        return false;
    }
    
    public static final void setLoggedIn(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setLoggedIn, boolean flag) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getUserId(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getUserId) {
        return null;
    }
    
    public static final void setUserId(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setUserId, @org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getUserObjectId(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getUserObjectId) {
        return null;
    }
    
    public static final void setUserObjectId(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setUserObjectId, @org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getLoginType(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getLoginType) {
        return null;
    }
    
    public static final void setLoginType(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setLoginType, @org.jetbrains.annotations.NotNull()
    java.lang.String type) {
    }
    
    public static final int getUserType(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getUserType) {
        return 0;
    }
    
    public static final void setUserType(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setUserType, int userType) {
    }
    
    public static final void setLanguage(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setLanguage, @org.jetbrains.annotations.NotNull()
    java.lang.String languageCode) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getLanguage(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getLanguage) {
        return null;
    }
    
    public static final void setCurrentLocation(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setCurrentLocation, @org.jetbrains.annotations.NotNull()
    java.lang.String location) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getCurrentLocation(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getCurrentLocation) {
        return null;
    }
    
    public static final boolean getSeenOnBoarding(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getSeenOnBoarding) {
        return false;
    }
    
    public static final void setSeenOnBoarding(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setSeenOnBoarding, boolean flag) {
    }
    
    public static final boolean getJobSearchType(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getJobSearchType) {
        return false;
    }
    
    public static final void setJobSearchType(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$setJobSearchType, boolean flag) {
    }
}