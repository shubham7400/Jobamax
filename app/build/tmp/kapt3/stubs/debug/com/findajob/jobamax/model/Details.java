package com.findajob.jobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00bb\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u00a2\u0006\u0002\u0010$J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\tH\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018H\u00c6\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018H\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Y\u001a\u00020\u001fH\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010[\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0003H\u00c6\u0003J\t\u0010]\u001a\u00020\u0003H\u00c6\u0003J\t\u0010^\u001a\u00020\u0003H\u00c6\u0003J\t\u0010_\u001a\u00020\u0003H\u00c6\u0003J\t\u0010`\u001a\u00020\u0003H\u00c6\u0003J\t\u0010a\u001a\u00020\tH\u00c6\u0003J\t\u0010b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010d\u001a\u00020\u0003H\u00c6\u0003J\u00c5\u0002\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010f\u001a\u00020\t2\b\u0010g\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010h\u001a\u00020iH\u00d6\u0001J\t\u0010j\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010!\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010&R\u0011\u0010\"\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010#\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\u0013\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0011\u0010 \u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010&R\u0011\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010&R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010&R\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010&\u00a8\u0006k"}, d2 = {"Lcom/findajob/jobamax/model/Details;", "", "SecurityClearance", "", "DrugTestRequired", "WithinArea", "WhatToExpectNext", "OtherInformation", "TeleworkEligible", "", "Benefits", "Requirements", "AgencyContactEmail", "JobSummary", "CommuteDistance", "Education", "ServiceType", "LowGrade", "RequiredDocuments", "BenefitsDisplayDefaultText", "Relocation", "BenefitsUrl", "HowToApply", "MajorDuties", "", "HiringPath", "OrganizationCodes", "HighGrade", "TravelCode", "Evaluations", "WhoMayApply", "Lcom/findajob/jobamax/model/WhoMayApply;", "TotalOpenings", "AgencyContactPhone", "AgencyMarketingStatement", "AnnouncementClosingType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/findajob/jobamax/model/WhoMayApply;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgencyContactEmail", "()Ljava/lang/String;", "getAgencyContactPhone", "getAgencyMarketingStatement", "getAnnouncementClosingType", "getBenefits", "getBenefitsDisplayDefaultText", "()Z", "getBenefitsUrl", "getCommuteDistance", "getDrugTestRequired", "getEducation", "getEvaluations", "getHighGrade", "getHiringPath", "()Ljava/util/List;", "getHowToApply", "getJobSummary", "getLowGrade", "getMajorDuties", "getOrganizationCodes", "getOtherInformation", "getRelocation", "getRequiredDocuments", "getRequirements", "getSecurityClearance", "getServiceType", "getTeleworkEligible", "getTotalOpenings", "getTravelCode", "getWhatToExpectNext", "getWhoMayApply", "()Lcom/findajob/jobamax/model/WhoMayApply;", "getWithinArea", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class Details {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String SecurityClearance = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String DrugTestRequired = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String WithinArea = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String WhatToExpectNext = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String OtherInformation = null;
    private final boolean TeleworkEligible = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Benefits = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Requirements = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String AgencyContactEmail = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String JobSummary = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String CommuteDistance = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Education = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ServiceType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String LowGrade = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String RequiredDocuments = null;
    private final boolean BenefitsDisplayDefaultText = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Relocation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String BenefitsUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String HowToApply = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> MajorDuties = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> HiringPath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String OrganizationCodes = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String HighGrade = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TravelCode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Evaluations = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.model.WhoMayApply WhoMayApply = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TotalOpenings = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String AgencyContactPhone = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String AgencyMarketingStatement = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String AnnouncementClosingType = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Details copy(@org.jetbrains.annotations.NotNull()
    java.lang.String SecurityClearance, @org.jetbrains.annotations.NotNull()
    java.lang.String DrugTestRequired, @org.jetbrains.annotations.NotNull()
    java.lang.String WithinArea, @org.jetbrains.annotations.NotNull()
    java.lang.String WhatToExpectNext, @org.jetbrains.annotations.NotNull()
    java.lang.String OtherInformation, boolean TeleworkEligible, @org.jetbrains.annotations.NotNull()
    java.lang.String Benefits, @org.jetbrains.annotations.NotNull()
    java.lang.String Requirements, @org.jetbrains.annotations.NotNull()
    java.lang.String AgencyContactEmail, @org.jetbrains.annotations.NotNull()
    java.lang.String JobSummary, @org.jetbrains.annotations.NotNull()
    java.lang.String CommuteDistance, @org.jetbrains.annotations.NotNull()
    java.lang.String Education, @org.jetbrains.annotations.NotNull()
    java.lang.String ServiceType, @org.jetbrains.annotations.NotNull()
    java.lang.String LowGrade, @org.jetbrains.annotations.NotNull()
    java.lang.String RequiredDocuments, boolean BenefitsDisplayDefaultText, @org.jetbrains.annotations.NotNull()
    java.lang.String Relocation, @org.jetbrains.annotations.NotNull()
    java.lang.String BenefitsUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String HowToApply, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> MajorDuties, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> HiringPath, @org.jetbrains.annotations.NotNull()
    java.lang.String OrganizationCodes, @org.jetbrains.annotations.NotNull()
    java.lang.String HighGrade, @org.jetbrains.annotations.NotNull()
    java.lang.String TravelCode, @org.jetbrains.annotations.NotNull()
    java.lang.String Evaluations, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.WhoMayApply WhoMayApply, @org.jetbrains.annotations.NotNull()
    java.lang.String TotalOpenings, @org.jetbrains.annotations.NotNull()
    java.lang.String AgencyContactPhone, @org.jetbrains.annotations.NotNull()
    java.lang.String AgencyMarketingStatement, @org.jetbrains.annotations.NotNull()
    java.lang.String AnnouncementClosingType) {
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
    
    public Details(@org.jetbrains.annotations.NotNull()
    java.lang.String SecurityClearance, @org.jetbrains.annotations.NotNull()
    java.lang.String DrugTestRequired, @org.jetbrains.annotations.NotNull()
    java.lang.String WithinArea, @org.jetbrains.annotations.NotNull()
    java.lang.String WhatToExpectNext, @org.jetbrains.annotations.NotNull()
    java.lang.String OtherInformation, boolean TeleworkEligible, @org.jetbrains.annotations.NotNull()
    java.lang.String Benefits, @org.jetbrains.annotations.NotNull()
    java.lang.String Requirements, @org.jetbrains.annotations.NotNull()
    java.lang.String AgencyContactEmail, @org.jetbrains.annotations.NotNull()
    java.lang.String JobSummary, @org.jetbrains.annotations.NotNull()
    java.lang.String CommuteDistance, @org.jetbrains.annotations.NotNull()
    java.lang.String Education, @org.jetbrains.annotations.NotNull()
    java.lang.String ServiceType, @org.jetbrains.annotations.NotNull()
    java.lang.String LowGrade, @org.jetbrains.annotations.NotNull()
    java.lang.String RequiredDocuments, boolean BenefitsDisplayDefaultText, @org.jetbrains.annotations.NotNull()
    java.lang.String Relocation, @org.jetbrains.annotations.NotNull()
    java.lang.String BenefitsUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String HowToApply, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> MajorDuties, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> HiringPath, @org.jetbrains.annotations.NotNull()
    java.lang.String OrganizationCodes, @org.jetbrains.annotations.NotNull()
    java.lang.String HighGrade, @org.jetbrains.annotations.NotNull()
    java.lang.String TravelCode, @org.jetbrains.annotations.NotNull()
    java.lang.String Evaluations, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.WhoMayApply WhoMayApply, @org.jetbrains.annotations.NotNull()
    java.lang.String TotalOpenings, @org.jetbrains.annotations.NotNull()
    java.lang.String AgencyContactPhone, @org.jetbrains.annotations.NotNull()
    java.lang.String AgencyMarketingStatement, @org.jetbrains.annotations.NotNull()
    java.lang.String AnnouncementClosingType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecurityClearance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDrugTestRequired() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWithinArea() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWhatToExpectNext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOtherInformation() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getTeleworkEligible() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBenefits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRequirements() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAgencyContactEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCommuteDistance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEducation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getServiceType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLowGrade() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRequiredDocuments() {
        return null;
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final boolean getBenefitsDisplayDefaultText() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRelocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBenefitsUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHowToApply() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getMajorDuties() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getHiringPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrganizationCodes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHighGrade() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTravelCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEvaluations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.WhoMayApply component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.WhoMayApply getWhoMayApply() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTotalOpenings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAgencyContactPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAgencyMarketingStatement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnnouncementClosingType() {
        return null;
    }
}