package com.jobamax.appjobamax.recruiter.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00cf\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\u0019J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u000eH\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u00fb\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010I\u001a\u00020JH\u00d6\u0001J\t\u0010K\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\"\u00a8\u0006L"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/model/SourcingSeeker;", "", "profileURL", "", "softSkills", "lastName", "images", "", "city", "university", "educations", "portfolioLinks", "experiences", "matchedPercentage", "", "firstName", "elevatorPitch", "portfolioDocLinks", "matches", "volunteerings", "workspaces", "interests", "jobSeekerId", "hardSkills", "interestedIn", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCity", "()Ljava/lang/String;", "getEducations", "getElevatorPitch", "getExperiences", "getFirstName", "getHardSkills", "getImages", "()Ljava/util/List;", "getInterestedIn", "getInterests", "getJobSeekerId", "getLastName", "getMatchedPercentage", "()J", "getMatches", "getPortfolioDocLinks", "getPortfolioLinks", "getProfileURL", "getSoftSkills", "getUniversity", "getVolunteerings", "getWorkspaces", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class SourcingSeeker {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String profileURL = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String softSkills = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lastName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> images = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String city = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String university = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String educations = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> portfolioLinks = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String experiences = null;
    private final long matchedPercentage = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String firstName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String elevatorPitch = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> portfolioDocLinks = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> matches = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String volunteerings = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> workspaces = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> interests = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jobSeekerId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hardSkills = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> interestedIn = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.model.SourcingSeeker copy(@org.jetbrains.annotations.NotNull()
    java.lang.String profileURL, @org.jetbrains.annotations.NotNull()
    java.lang.String softSkills, @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> images, @org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String university, @org.jetbrains.annotations.NotNull()
    java.lang.String educations, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> portfolioLinks, @org.jetbrains.annotations.NotNull()
    java.lang.String experiences, long matchedPercentage, @org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    java.lang.String elevatorPitch, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> portfolioDocLinks, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> matches, @org.jetbrains.annotations.NotNull()
    java.lang.String volunteerings, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> workspaces, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> interests, @org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, @org.jetbrains.annotations.NotNull()
    java.lang.String hardSkills, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> interestedIn) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SourcingSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String profileURL, @org.jetbrains.annotations.NotNull()
    java.lang.String softSkills, @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> images, @org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String university, @org.jetbrains.annotations.NotNull()
    java.lang.String educations, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> portfolioLinks, @org.jetbrains.annotations.NotNull()
    java.lang.String experiences, long matchedPercentage, @org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    java.lang.String elevatorPitch, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> portfolioDocLinks, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> matches, @org.jetbrains.annotations.NotNull()
    java.lang.String volunteerings, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> workspaces, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> interests, @org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, @org.jetbrains.annotations.NotNull()
    java.lang.String hardSkills, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> interestedIn) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfileURL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSoftSkills() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUniversity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEducations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPortfolioLinks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExperiences() {
        return null;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final long getMatchedPercentage() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getElevatorPitch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPortfolioDocLinks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getMatches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVolunteerings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getWorkspaces() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getInterests() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHardSkills() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getInterestedIn() {
        return null;
    }
}