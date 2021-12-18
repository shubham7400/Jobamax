package com.findajob.jobamax.training.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/findajob/jobamax/training/model/ConstantApp;", "", "()V", "ACTION_KEY_CROLE", "", "ACTION_KEY_ROOM_NAME", "APP_BUILD_DATE", "BASE_VALUE_PERMISSION", "", "GOOGLE_PLAY_SERVICE_API", "PERMISSION_REQ_ID_RECORD_AUDIO", "PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE", "SERVER_HOST_GOOGLE", "AppError", "PrefManager", "app_debug"})
public final class ConstantApp {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.training.model.ConstantApp INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APP_BUILD_DATE = "today";
    public static final int BASE_VALUE_PERMISSION = 1;
    public static final int PERMISSION_REQ_ID_RECORD_AUDIO = 2;
    public static final int PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE = 4;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_KEY_CROLE = "C_Role";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_KEY_ROOM_NAME = "ecHANEL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER_HOST_GOOGLE = "https://maps.googleapis.com";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GOOGLE_PLAY_SERVICE_API = "AIzaSyA4NEv4m7rHGc22VGJz6ffdz2VIgY31avY";
    
    private ConstantApp() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/training/model/ConstantApp$PrefManager;", "", "()V", "PREF_PROPERTY_UID", "", "app_debug"})
    public static final class PrefManager {
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.training.model.ConstantApp.PrefManager INSTANCE = null;
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String PREF_PROPERTY_UID = "pOCXx_uid";
        
        private PrefManager() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/training/model/ConstantApp$AppError;", "", "()V", "NO_NETWORK_CONNECTION", "", "app_debug"})
    public static final class AppError {
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.training.model.ConstantApp.AppError INSTANCE = null;
        public static final int NO_NETWORK_CONNECTION = 3;
        
        private AppError() {
            super();
        }
    }
}