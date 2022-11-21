package com.jobamax.appjobamax.util;

import android.Manifest;
import android.widget.ImageView;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e\"\u0019\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\"\u00a2\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$\"\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001a\"\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0)\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+\"\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010)\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010+\u00a8\u0006."}, d2 = {"ALGORITHM", "", "APPRENTICESHIP", "ARG_USER", "ARG_WEB_URL", "FRENCH_LANG_CODE", "GOOGLE_LOGIN_TYPE", "INTERNSHIP", "JOBAMAX_DOWNLOAD_URL", "JOB_SEEKER_TYPE", "KEY", "LOCATION_REFRESH_DISTANCE", "", "LOCATION_REFRESH_TIME", "MSG", "ONE_OR_WTO", "PART_TIME", "PERMANENT", "PROFILE_PIC_URL", "REQUEST_ALL_PERMISSIONS", "TWO_OR_THREE", "UNDER_ONE", "UX_CAM_API_KEY", "companySizeList", "Ljava/util/ArrayList;", "getCompanySizeList", "()Ljava/util/ArrayList;", "contractMap", "Ljava/util/LinkedHashMap;", "getContractMap", "()Ljava/util/LinkedHashMap;", "experienceMap", "getExperienceMap", "permissions", "", "getPermissions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "reportReason", "getReportReason", "seekerSelectionSteps", "Ljava/util/HashMap;", "getSeekerSelectionSteps", "()Ljava/util/HashMap;", "seekerSelectionStepsV2", "getSeekerSelectionStepsV2", "app_debug"})
public final class ConstantKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_USER = "arg_user";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_WEB_URL = "arg_web_url";
    public static final int REQUEST_ALL_PERMISSIONS = 101;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] permissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION"};
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOB_SEEKER_TYPE = "1";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROFILE_PIC_URL = "profile_pic_url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRENCH_LANG_CODE = "fr";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.LinkedHashMap<java.lang.String, java.lang.String> contractMap = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTERNSHIP = "stage";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APPRENTICESHIP = "alternance";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PART_TIME = "CDD";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PERMANENT = "CDI";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.LinkedHashMap<java.lang.String, java.lang.String> experienceMap = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNDER_ONE = "under-one";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ONE_OR_WTO = "one-two";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TWO_OR_THREE = "two-three";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.ArrayList<java.lang.String> companySizeList = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.ArrayList<java.lang.String> reportReason = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.HashMap<java.lang.String, java.lang.Integer> seekerSelectionSteps = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.HashMap<java.lang.String, java.lang.String> seekerSelectionStepsV2 = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GOOGLE_LOGIN_TYPE = "google";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOBAMAX_DOWNLOAD_URL = "https://jobamax.page.link/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ALGORITHM = "AES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY = "CFZEGEN642DDX54A";
    public static final int LOCATION_REFRESH_TIME = 10000;
    public static final int LOCATION_REFRESH_DISTANCE = 0;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MSG = "Device is not connected to the internet.";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UX_CAM_API_KEY = "9nkbriit16rt492";
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String[] getPermissions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.LinkedHashMap<java.lang.String, java.lang.String> getContractMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.LinkedHashMap<java.lang.String, java.lang.String> getExperienceMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.ArrayList<java.lang.String> getCompanySizeList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.ArrayList<java.lang.String> getReportReason() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.HashMap<java.lang.String, java.lang.Integer> getSeekerSelectionSteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.HashMap<java.lang.String, java.lang.String> getSeekerSelectionStepsV2() {
        return null;
    }
}