package com.findajob.jobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0003R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/findajob/jobamax/model/WishlistedJob;", "", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "()V", "isArchived", "", "()Z", "setArchived", "(Z)V", "isFavroite", "setFavroite", "job", "getJob", "()Lcom/parse/ParseObject;", "setJob", "jobSeeker", "getJobSeeker", "setJobSeeker", "pfObject", "getPfObject", "setPfObject", "toParseObject", "app_debug"})
public final class WishlistedJob {
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeeker;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject job;
    private boolean isFavroite = false;
    private boolean isArchived = false;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject pfObject;
    
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
    
    public final boolean isFavroite() {
        return false;
    }
    
    public final void setFavroite(boolean p0) {
    }
    
    public final boolean isArchived() {
        return false;
    }
    
    public final void setArchived(boolean p0) {
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
    
    public WishlistedJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    public WishlistedJob() {
        super();
    }
}