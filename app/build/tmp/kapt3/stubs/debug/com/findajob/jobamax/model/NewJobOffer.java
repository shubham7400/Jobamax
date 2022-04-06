package com.findajob.jobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J \u0010a\u001a\u0012\u0012\u0004\u0012\u00020\u00070bj\b\u0012\u0004\u0012\u00020\u0007`c2\u0006\u0010d\u001a\u00020\u0007H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010\'\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010\u000bR\u001a\u00102\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR\u001a\u00105\u001a\u000206X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR\u001a\u0010>\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR \u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000f\"\u0004\bC\u0010\u0011R\u001a\u0010D\u001a\u000206X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R\u001a\u0010G\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\t\"\u0004\b-\u0010\u000bR\u001a\u0010I\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\t\"\u0004\bK\u0010\u000bR\u001a\u0010L\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\t\"\u0004\bN\u0010\u000bR\u001a\u0010O\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\t\"\u0004\bQ\u0010\u000bR \u0010R\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0011R\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\t\"\u0004\b]\u0010\u000bR \u0010^\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000f\"\u0004\b`\u0010\u0011\u00a8\u0006e"}, d2 = {"Lcom/findajob/jobamax/model/NewJobOffer;", "Ljava/io/Serializable;", "()V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "aboutOfCompany", "", "getAboutOfCompany", "()Ljava/lang/String;", "setAboutOfCompany", "(Ljava/lang/String;)V", "benefits", "", "getBenefits", "()Ljava/util/List;", "setBenefits", "(Ljava/util/List;)V", "city", "getCity", "setCity", "companyId", "getCompanyId", "setCompanyId", "companyLogo", "getCompanyLogo", "setCompanyLogo", "companyName", "getCompanyName", "setCompanyName", "description", "getDescription", "setDescription", "evolutionPerspective", "getEvolutionPerspective", "setEvolutionPerspective", "hardSkills", "getHardSkills", "setHardSkills", "industry", "getIndustry", "setIndustry", "isMonthlySalary", "", "()Z", "setMonthlySalary", "(Z)V", "jobOfferId", "getJobOfferId", "setJobOfferId", "jobTitle", "getJobTitle", "setJobTitle", "jobType", "", "getJobType", "()I", "setJobType", "(I)V", "jobUrl", "getJobUrl", "setJobUrl", "location", "getLocation", "setLocation", "matches", "getMatches", "setMatches", "matchesPercentage", "getMatchesPercentage", "setMatchesPercentage", "monthlySalary", "getMonthlySalary", "profilePicUrl", "getProfilePicUrl", "setProfilePicUrl", "recruiterId", "getRecruiterId", "setRecruiterId", "salary", "getSalary", "setSalary", "softSkills", "getSoftSkills", "setSoftSkills", "subMatches", "Lcom/findajob/jobamax/model/SubMatches;", "getSubMatches", "()Lcom/findajob/jobamax/model/SubMatches;", "setSubMatches", "(Lcom/findajob/jobamax/model/SubMatches;)V", "typeOfWork", "getTypeOfWork", "setTypeOfWork", "workplaceVibes", "getWorkplaceVibes", "setWorkplaceVibes", "convertToList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "str", "app_debug"})
public final class NewJobOffer implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String recruiterId = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> benefits;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> softSkills;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String aboutOfCompany = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String city = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String location = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobTitle = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyName = "";
    private boolean isMonthlySalary = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String industry = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String salary = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String typeOfWork = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> matches;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String evolutionPerspective = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String monthlySalary = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profilePicUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyLogo = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobOfferId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> workplaceVibes;
    private int matchesPercentage = 0;
    private int jobType = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> hardSkills;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.model.SubMatches subMatches;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRecruiterId() {
        return null;
    }
    
    public final void setRecruiterId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBenefits() {
        return null;
    }
    
    public final void setBenefits(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSoftSkills() {
        return null;
    }
    
    public final void setSoftSkills(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAboutOfCompany() {
        return null;
    }
    
    public final void setAboutOfCompany(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getJobTitle() {
        return null;
    }
    
    public final void setJobTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyName() {
        return null;
    }
    
    public final void setCompanyName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isMonthlySalary() {
        return false;
    }
    
    public final void setMonthlySalary(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getSalary() {
        return null;
    }
    
    public final void setSalary(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypeOfWork() {
        return null;
    }
    
    public final void setTypeOfWork(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getMatches() {
        return null;
    }
    
    public final void setMatches(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEvolutionPerspective() {
        return null;
    }
    
    public final void setEvolutionPerspective(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getCompanyId() {
        return null;
    }
    
    public final void setCompanyId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfilePicUrl() {
        return null;
    }
    
    public final void setProfilePicUrl(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    public final void setJobOfferId(@org.jetbrains.annotations.NotNull()
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
    public final java.util.List<java.lang.String> getWorkplaceVibes() {
        return null;
    }
    
    public final void setWorkplaceVibes(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    public final int getMatchesPercentage() {
        return 0;
    }
    
    public final void setMatchesPercentage(int p0) {
    }
    
    public final int getJobType() {
        return 0;
    }
    
    public final void setJobType(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getHardSkills() {
        return null;
    }
    
    public final void setHardSkills(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.model.SubMatches getSubMatches() {
        return null;
    }
    
    public final void setSubMatches(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.model.SubMatches p0) {
    }
    
    public NewJobOffer() {
        super();
    }
    
    public NewJobOffer(@org.jetbrains.annotations.NotNull()
    org.json.JSONObject jsonObject) {
        super();
    }
    
    private final java.util.ArrayList<java.lang.String> convertToList(java.lang.String str) {
        return null;
    }
}