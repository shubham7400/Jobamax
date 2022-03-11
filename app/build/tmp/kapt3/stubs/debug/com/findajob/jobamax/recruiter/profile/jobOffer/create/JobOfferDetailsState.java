package com.findajob.jobamax.recruiter.profile.jobOffer.create;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b)\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010q\u001a\u000207J\u0006\u0010r\u001a\u000207J\u0006\u0010s\u001a\u00020\u0004R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010\'\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001a\u00103\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\u001a\u00106\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\u001a\u0010>\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R\u001a\u0010@\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R\u001a\u0010B\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u00109\"\u0004\bC\u0010;R\u001a\u0010D\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000f\"\u0004\bF\u0010\u0011R\u001a\u0010G\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u00109\"\u0004\bI\u0010;R \u0010J\u001a\b\u0012\u0004\u0012\u00020\b0KX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010\fR\u001a\u0010N\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R\u001a\u0010Q\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u000f\"\u0004\bA\u0010\u0011R\u001a\u0010S\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u000f\"\u0004\bU\u0010\u0011R\u001a\u0010V\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u00109\"\u0004\bX\u0010;R\u001a\u0010Y\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u00109\"\u0004\b[\u0010;R\u001a\u0010\\\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000f\"\u0004\b^\u0010\u0011R\u001a\u0010_\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000f\"\u0004\ba\u0010\u0011R \u0010b\u001a\b\u0012\u0004\u0012\u00020\b0KX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\n\"\u0004\bd\u0010\fR\u001a\u0010e\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u00109\"\u0004\bg\u0010;R \u0010h\u001a\b\u0012\u0004\u0012\u00020\b0KX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\n\"\u0004\bj\u0010\fR\u001a\u0010k\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u00109\"\u0004\bm\u0010;R\u001a\u0010n\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u00109\"\u0004\bp\u0010;\u00a8\u0006t"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/JobOfferDetailsState;", "", "()V", "jobOffer", "Lcom/findajob/jobamax/model/JobOffer;", "(Lcom/findajob/jobamax/model/JobOffer;)V", "benefits", "", "", "getBenefits", "()Ljava/util/List;", "setBenefits", "(Ljava/util/List;)V", "city", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "company", "getCompany", "setCompany", "companyId", "getCompanyId", "setCompanyId", "companyWebsite", "getCompanyWebsite", "setCompanyWebsite", "description", "getDescription", "setDescription", "distance", "", "getDistance", "()I", "setDistance", "(I)V", "documentName", "getDocumentName", "setDocumentName", "documentUrl", "getDocumentUrl", "setDocumentUrl", "geoLocation", "Lcom/parse/ParseGeoPoint;", "getGeoLocation", "()Lcom/parse/ParseGeoPoint;", "setGeoLocation", "(Lcom/parse/ParseGeoPoint;)V", "hierarchyFlag", "getHierarchyFlag", "setHierarchyFlag", "industry", "getIndustry", "setIndustry", "internshipSelectedFlag", "", "getInternshipSelectedFlag", "()Z", "setInternshipSelectedFlag", "(Z)V", "isArchived", "setArchived", "isLoaded", "setLoaded", "isMonthlySalary", "setMonthlySalary", "isYearlySalary", "setYearlySalary", "jobOfferId", "getJobOfferId", "setJobOfferId", "jobSelectedFlag", "getJobSelectedFlag", "setJobSelectedFlag", "keySkills", "", "getKeySkills", "setKeySkills", "location", "getLocation", "setLocation", "monthlySalary", "getMonthlySalary", "name", "getName", "setName", "oneToTwoWorkExSelectedFlag", "getOneToTwoWorkExSelectedFlag", "setOneToTwoWorkExSelectedFlag", "otherSelectedFlag", "getOtherSelectedFlag", "setOtherSelectedFlag", "recruiterId", "getRecruiterId", "setRecruiterId", "screeningQuestion", "getScreeningQuestion", "setScreeningQuestion", "skills", "getSkills", "setSkills", "twoPlusWorkExSelectedFlag", "getTwoPlusWorkExSelectedFlag", "setTwoPlusWorkExSelectedFlag", "typeOfWork", "getTypeOfWork", "setTypeOfWork", "underOneWorkExSelectedFlag", "getUnderOneWorkExSelectedFlag", "setUnderOneWorkExSelectedFlag", "workStudySelectedFlag", "getWorkStudySelectedFlag", "setWorkStudySelectedFlag", "isExperienceSelected", "isJobCategorySelected", "toJobOffer", "app_debug"})
public final class JobOfferDetailsState {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobOfferId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String recruiterId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name = "";
    @org.jetbrains.annotations.NotNull()
    private com.parse.ParseGeoPoint geoLocation;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String company = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String city = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String industry = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String monthlySalary = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> skills;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> keySkills;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description = "";
    private boolean jobSelectedFlag = false;
    private boolean workStudySelectedFlag = false;
    private boolean internshipSelectedFlag = false;
    private boolean otherSelectedFlag = false;
    private boolean underOneWorkExSelectedFlag = false;
    private boolean oneToTwoWorkExSelectedFlag = false;
    private boolean twoPlusWorkExSelectedFlag = false;
    private int distance = 100;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String location = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyWebsite = "";
    private boolean isMonthlySalary = true;
    private boolean isYearlySalary;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String screeningQuestion = "";
    private boolean isArchived = false;
    
    /**
     * 0 -> Low
     * 1 -> Medium
     * 2 -> High
     */
    private int hierarchyFlag = -1;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> typeOfWork;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> benefits;
    private boolean isLoaded = false;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    public final void setJobOfferId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRecruiterId() {
        return null;
    }
    
    public final void setRecruiterId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseGeoPoint getGeoLocation() {
        return null;
    }
    
    public final void setGeoLocation(@org.jetbrains.annotations.NotNull()
    com.parse.ParseGeoPoint p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompany() {
        return null;
    }
    
    public final void setCompany(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyId() {
        return null;
    }
    
    public final void setCompanyId(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getIndustry() {
        return null;
    }
    
    public final void setIndustry(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMonthlySalary() {
        return null;
    }
    
    public final void setMonthlySalary(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSkills() {
        return null;
    }
    
    public final void setSkills(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getKeySkills() {
        return null;
    }
    
    public final void setKeySkills(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    public final int getDistance() {
        return 0;
    }
    
    public final void setDistance(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentName() {
        return null;
    }
    
    public final void setDocumentName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentUrl() {
        return null;
    }
    
    public final void setDocumentUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyWebsite() {
        return null;
    }
    
    public final void setCompanyWebsite(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isMonthlySalary() {
        return false;
    }
    
    public final void setMonthlySalary(boolean p0) {
    }
    
    public final boolean isYearlySalary() {
        return false;
    }
    
    public final void setYearlySalary(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScreeningQuestion() {
        return null;
    }
    
    public final void setScreeningQuestion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isArchived() {
        return false;
    }
    
    public final void setArchived(boolean p0) {
    }
    
    public final int getHierarchyFlag() {
        return 0;
    }
    
    public final void setHierarchyFlag(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTypeOfWork() {
        return null;
    }
    
    public final void setTypeOfWork(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBenefits() {
        return null;
    }
    
    public final void setBenefits(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    public final boolean isLoaded() {
        return false;
    }
    
    public final void setLoaded(boolean p0) {
    }
    
    public final boolean isJobCategorySelected() {
        return false;
    }
    
    public final boolean isExperienceSelected() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobOffer toJobOffer() {
        return null;
    }
    
    public JobOfferDetailsState() {
        super();
    }
    
    public JobOfferDetailsState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobOffer jobOffer) {
        super();
    }
}