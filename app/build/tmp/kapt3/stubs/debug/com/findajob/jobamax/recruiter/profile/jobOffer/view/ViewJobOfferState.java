package com.findajob.jobamax.recruiter.profile.jobOffer.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u000e\"\u0004\b(\u0010\u0010R\u001a\u0010)\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001a\u00105\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R\u001a\u00108\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001a\u0010@\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u001a\u0010B\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R\u001a\u0010E\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010;\"\u0004\bG\u0010=R \u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010\u000bR\u001a\u0010K\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010\u0010R\u001a\u0010N\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000e\"\u0004\bA\u0010\u0010R\u001a\u0010P\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000e\"\u0004\bR\u0010\u0010R\u001a\u0010S\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010;\"\u0004\bU\u0010=R\u001a\u0010V\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010;\"\u0004\bX\u0010=R\u001a\u0010Y\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010\u0010R\u001a\u0010\\\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000e\"\u0004\b^\u0010\u0010R \u0010_\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\t\"\u0004\ba\u0010\u000bR\u001a\u0010b\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010;\"\u0004\bd\u0010=R \u0010e\u001a\b\u0012\u0004\u0012\u00020\u00070fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\t\"\u0004\bh\u0010\u000bR\u001a\u0010i\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010;\"\u0004\bk\u0010=R\u001a\u0010l\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010;\"\u0004\bn\u0010=\u00a8\u0006o"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/view/ViewJobOfferState;", "", "jobOffer", "Lcom/findajob/jobamax/model/JobOffer;", "(Lcom/findajob/jobamax/model/JobOffer;)V", "benefits", "", "", "getBenefits", "()Ljava/util/List;", "setBenefits", "(Ljava/util/List;)V", "city", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "company", "getCompany", "setCompany", "companyId", "getCompanyId", "setCompanyId", "companySize", "getCompanySize", "setCompanySize", "companyWebsite", "getCompanyWebsite", "setCompanyWebsite", "description", "getDescription", "setDescription", "distance", "", "getDistance", "()I", "setDistance", "(I)V", "documentName", "getDocumentName", "setDocumentName", "documentUrl", "getDocumentUrl", "setDocumentUrl", "geoLocation", "Lcom/parse/ParseGeoPoint;", "getGeoLocation", "()Lcom/parse/ParseGeoPoint;", "setGeoLocation", "(Lcom/parse/ParseGeoPoint;)V", "hierarchyFlag", "getHierarchyFlag", "setHierarchyFlag", "industry", "getIndustry", "setIndustry", "internshipSelectedFlag", "", "getInternshipSelectedFlag", "()Z", "setInternshipSelectedFlag", "(Z)V", "isArchived", "setArchived", "isMonthlySalary", "setMonthlySalary", "jobOfferId", "getJobOfferId", "setJobOfferId", "jobSelectedFlag", "getJobSelectedFlag", "setJobSelectedFlag", "keySkills", "getKeySkills", "setKeySkills", "location", "getLocation", "setLocation", "monthlySalary", "getMonthlySalary", "name", "getName", "setName", "oneToTwoWorkExSelectedFlag", "getOneToTwoWorkExSelectedFlag", "setOneToTwoWorkExSelectedFlag", "otherSelectedFlag", "getOtherSelectedFlag", "setOtherSelectedFlag", "recruiterId", "getRecruiterId", "setRecruiterId", "screeningQuestion", "getScreeningQuestion", "setScreeningQuestion", "skills", "getSkills", "setSkills", "twoPlusWorkExSelectedFlag", "getTwoPlusWorkExSelectedFlag", "setTwoPlusWorkExSelectedFlag", "typeOfWork", "", "getTypeOfWork", "setTypeOfWork", "underOneWorkExSelectedFlag", "getUnderOneWorkExSelectedFlag", "setUnderOneWorkExSelectedFlag", "workStudySelectedFlag", "getWorkStudySelectedFlag", "setWorkStudySelectedFlag", "app_debug"})
public final class ViewJobOfferState {
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
    private int distance = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String location = "";
    private boolean isArchived = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companySize = "";
    
    /**
     * 0 -> Low
     * 1 -> Medium
     * 2 -> High
     */
    private int hierarchyFlag = -1;
    
    /**
     * 0 -> Full Time
     * 1 -> Part Time
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> typeOfWork;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> benefits;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyWebsite = "";
    private boolean isMonthlySalary = true;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String screeningQuestion = "";
    
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
    
    public final boolean isArchived() {
        return false;
    }
    
    public final void setArchived(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanySize() {
        return null;
    }
    
    public final void setCompanySize(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScreeningQuestion() {
        return null;
    }
    
    public final void setScreeningQuestion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public ViewJobOfferState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobOffer jobOffer) {
        super();
    }
}