package com.jobamax.appjobamax.model;

import java.io.Serializable;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001a\u00106\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001a\u0010?\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010$\"\u0004\bA\u0010&R\u001a\u0010B\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001a\u0010E\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010$\"\u0004\bG\u0010&R\u001a\u0010H\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R*\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\u00040Lj\b\u0012\u0004\u0012\u00020\u0004`MX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\b\u00a8\u0006U"}, d2 = {"Lcom/jobamax/appjobamax/model/JobOffer;", "Ljava/io/Serializable;", "()V", "city", "", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "companyId", "getCompanyId", "setCompanyId", "companyLogo", "getCompanyLogo", "setCompanyLogo", "companyName", "getCompanyName", "setCompanyName", "description", "getDescription", "setDescription", "hasShowCase", "", "getHasShowCase", "()Z", "setHasShowCase", "(Z)V", "jobOfferId", "getJobOfferId", "setJobOfferId", "jobTitle", "getJobTitle", "setJobTitle", "jobType", "", "getJobType", "()I", "setJobType", "(I)V", "jobUrl", "getJobUrl", "setJobUrl", "location", "getLocation", "setLocation", "matches", "Lcom/jobamax/appjobamax/model/Matches;", "getMatches", "()Lcom/jobamax/appjobamax/model/Matches;", "setMatches", "(Lcom/jobamax/appjobamax/model/Matches;)V", "matchesPercentage", "getMatchesPercentage", "setMatchesPercentage", "myCriteria", "Lcom/jobamax/appjobamax/model/MyCriteria;", "getMyCriteria", "()Lcom/jobamax/appjobamax/model/MyCriteria;", "setMyCriteria", "(Lcom/jobamax/appjobamax/model/MyCriteria;)V", "postedDate", "getPostedDate", "setPostedDate", "randomViewCount", "getRandomViewCount", "setRandomViewCount", "salary", "getSalary", "setSalary", "swipeLeftCount", "getSwipeLeftCount", "setSwipeLeftCount", "swipeRightCount", "getSwipeRightCount", "setSwipeRightCount", "tags", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTags", "()Ljava/util/ArrayList;", "setTags", "(Ljava/util/ArrayList;)V", "typeOfWork", "getTypeOfWork", "setTypeOfWork", "app_debug"})
public final class JobOffer implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobOfferId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobTitle = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String city = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String location = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String salary = "";
    private int jobType = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyId = "";
    private boolean hasShowCase = false;
    private int swipeRightCount = 0;
    private int swipeLeftCount = 0;
    private int randomViewCount = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String typeOfWork = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String postedDate = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyLogo = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> tags;
    private int matchesPercentage = 0;
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.model.Matches matches;
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.model.MyCriteria myCriteria;
    
    public JobOffer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    public final void setJobOfferId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobTitle() {
        return null;
    }
    
    public final void setJobTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSalary() {
        return null;
    }
    
    public final void setSalary(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getJobType() {
        return 0;
    }
    
    public final void setJobType(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyId() {
        return null;
    }
    
    public final void setCompanyId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getHasShowCase() {
        return false;
    }
    
    public final void setHasShowCase(boolean p0) {
    }
    
    public final int getSwipeRightCount() {
        return 0;
    }
    
    public final void setSwipeRightCount(int p0) {
    }
    
    public final int getSwipeLeftCount() {
        return 0;
    }
    
    public final void setSwipeLeftCount(int p0) {
    }
    
    public final int getRandomViewCount() {
        return 0;
    }
    
    public final void setRandomViewCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypeOfWork() {
        return null;
    }
    
    public final void setTypeOfWork(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPostedDate() {
        return null;
    }
    
    public final void setPostedDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyName() {
        return null;
    }
    
    public final void setCompanyName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyLogo() {
        return null;
    }
    
    public final void setCompanyLogo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobUrl() {
        return null;
    }
    
    public final void setJobUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getTags() {
        return null;
    }
    
    public final void setTags(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    public final int getMatchesPercentage() {
        return 0;
    }
    
    public final void setMatchesPercentage(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.Matches getMatches() {
        return null;
    }
    
    public final void setMatches(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.Matches p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.MyCriteria getMyCriteria() {
        return null;
    }
    
    public final void setMyCriteria(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.MyCriteria p0) {
    }
}