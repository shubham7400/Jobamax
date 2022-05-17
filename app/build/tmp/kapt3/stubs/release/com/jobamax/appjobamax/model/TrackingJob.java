package com.jobamax.appjobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u0003R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/jobamax/appjobamax/model/TrackingJob;", "Ljava/io/Serializable;", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "()V", "isSelected", "", "()Z", "setSelected", "(Z)V", "job", "getJob", "()Lcom/parse/ParseObject;", "setJob", "jobSeeker", "getJobSeeker", "setJobSeeker", "jobSeekerId", "", "getJobSeekerId", "()Ljava/lang/String;", "setJobSeekerId", "(Ljava/lang/String;)V", "pfObject", "getPfObject", "setPfObject", "phases", "getPhases", "setPhases", "toParseObject", "app_release"})
public final class TrackingJob implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Transient()
    private transient com.parse.ParseObject jobSeeker;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject job;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobSeekerId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String phases = "";
    private boolean isSelected = false;
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Transient()
    private transient com.parse.ParseObject pfObject;
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final void setJobSeekerId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhases() {
        return null;
    }
    
    public final void setPhases(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getPfObject() {
        return null;
    }
    
    public final void setPfObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    public TrackingJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    public TrackingJob() {
        super();
    }
}