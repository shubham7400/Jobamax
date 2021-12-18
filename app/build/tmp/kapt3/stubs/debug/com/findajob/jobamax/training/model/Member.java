package com.findajob.jobamax.training.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/findajob/jobamax/training/model/Member;", "", "()V", "user", "Lcom/findajob/jobamax/model/User;", "(Lcom/findajob/jobamax/model/User;)V", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "(Lcom/findajob/jobamax/model/JobSeeker;)V", "recruiter", "Lcom/findajob/jobamax/model/Recruiter;", "parseObject", "Lcom/parse/ParseObject;", "(Lcom/findajob/jobamax/model/Recruiter;Lcom/parse/ParseObject;)V", "handRaised", "", "getHandRaised", "()Z", "setHandRaised", "(Z)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "muted", "getMuted", "setMuted", "name", "getName", "setName", "profileUrl", "getProfileUrl", "setProfileUrl", "app_debug"})
public final class Member {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profileUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id = "";
    private boolean muted = false;
    private boolean handRaised = false;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfileUrl() {
        return null;
    }
    
    public final void setProfileUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getMuted() {
        return false;
    }
    
    public final void setMuted(boolean p0) {
    }
    
    public final boolean getHandRaised() {
        return false;
    }
    
    public final void setHandRaised(boolean p0) {
    }
    
    public Member() {
        super();
    }
    
    public Member(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user) {
        super();
    }
    
    public Member(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker) {
        super();
    }
    
    public Member(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Recruiter recruiter, @org.jetbrains.annotations.NotNull()
    com.parse.ParseObject parseObject) {
        super();
    }
}