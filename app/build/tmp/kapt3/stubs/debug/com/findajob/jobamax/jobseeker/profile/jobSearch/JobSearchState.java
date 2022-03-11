package com.findajob.jobamax.jobseeker.profile.jobSearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010B\u001a\u00020\u0004R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001a\u0010-\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001a\u00103\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R \u00106\u001a\b\u0012\u0004\u0012\u00020\u001607X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R\u001a\u0010?\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011\u00a8\u0006C"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchState;", "", "()V", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "(Lcom/findajob/jobamax/model/JobSeeker;)V", "distance", "", "getDistance", "()I", "setDistance", "(I)V", "hideMeFlag", "", "getHideMeFlag", "()Z", "setHideMeFlag", "(Z)V", "internshipSelectedFlag", "getInternshipSelectedFlag", "setInternshipSelectedFlag", "job", "", "getJob", "()Ljava/lang/String;", "setJob", "(Ljava/lang/String;)V", "jobSeekerId", "getJobSeekerId", "setJobSeekerId", "jobSelectedFlag", "getJobSelectedFlag", "setJobSelectedFlag", "lat", "", "getLat", "()F", "setLat", "(F)V", "lng", "getLng", "setLng", "location", "getLocation", "setLocation", "oneToTwoWorkExSelectedFlag", "getOneToTwoWorkExSelectedFlag", "setOneToTwoWorkExSelectedFlag", "otherSelectedFlag", "getOtherSelectedFlag", "setOtherSelectedFlag", "twoPlusWorkExSelectedFlag", "getTwoPlusWorkExSelectedFlag", "setTwoPlusWorkExSelectedFlag", "typeOfWork", "", "getTypeOfWork", "()Ljava/util/List;", "setTypeOfWork", "(Ljava/util/List;)V", "underOneWorkExSelectedFlag", "getUnderOneWorkExSelectedFlag", "setUnderOneWorkExSelectedFlag", "workStudySelectedFlag", "getWorkStudySelectedFlag", "setWorkStudySelectedFlag", "toJobSeeker", "app_debug"})
public final class JobSearchState {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobSeekerId = "";
    private boolean hideMeFlag = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String job = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String location = "";
    private int distance = 100;
    private float lat = 0.0F;
    private float lng = 0.0F;
    private boolean jobSelectedFlag = false;
    private boolean workStudySelectedFlag = false;
    private boolean internshipSelectedFlag = false;
    private boolean otherSelectedFlag = false;
    private boolean underOneWorkExSelectedFlag = false;
    private boolean oneToTwoWorkExSelectedFlag = false;
    private boolean twoPlusWorkExSelectedFlag = false;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> typeOfWork;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final void setJobSeekerId(@org.jetbrains.annotations.NotNull()
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
    
    public final boolean getJobSelectedFlag() {
        return false;
    }
    
    public final void setJobSelectedFlag(boolean p0) {
    }
    
    public final boolean getWorkStudySelectedFlag() {
        return false;
    }
    
    public final void setWorkStudySelectedFlag(boolean p0) {
    }
    
    public final boolean getInternshipSelectedFlag() {
        return false;
    }
    
    public final void setInternshipSelectedFlag(boolean p0) {
    }
    
    public final boolean getOtherSelectedFlag() {
        return false;
    }
    
    public final void setOtherSelectedFlag(boolean p0) {
    }
    
    public final boolean getUnderOneWorkExSelectedFlag() {
        return false;
    }
    
    public final void setUnderOneWorkExSelectedFlag(boolean p0) {
    }
    
    public final boolean getOneToTwoWorkExSelectedFlag() {
        return false;
    }
    
    public final void setOneToTwoWorkExSelectedFlag(boolean p0) {
    }
    
    public final boolean getTwoPlusWorkExSelectedFlag() {
        return false;
    }
    
    public final void setTwoPlusWorkExSelectedFlag(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTypeOfWork() {
        return null;
    }
    
    public final void setTypeOfWork(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    public JobSearchState() {
        super();
    }
    
    public JobSearchState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobSeeker toJobSeeker() {
        return null;
    }
}