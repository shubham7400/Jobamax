package com.findajob.jobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00fb\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010 J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0018H\u00c6\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0007H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007H\u00c6\u0003J\u0091\u0002\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00072\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00032\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010P\u001a\u00020QH\u00d6\u0001J\t\u0010R\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107\u00a8\u0006S"}, d2 = {"Lcom/findajob/jobamax/model/MatchedObjectDescriptor;", "", "OrganizationName", "", "PositionLocationDisplay", "PositionTitle", "PositionSchedule", "", "Lcom/findajob/jobamax/model/PositionScheduleItem;", "ApplicationCloseDate", "PositionID", "PositionEndDate", "PositionOfferingType", "Lcom/findajob/jobamax/model/PositionOfferingTypeItem;", "PositionRemuneration", "Lcom/findajob/jobamax/model/PositionRemunerationItem;", "ApplyURI", "PositionFormattedDescription", "Lcom/findajob/jobamax/model/PositionFormattedDescriptionItem;", "PositionLocation", "Lcom/findajob/jobamax/model/PositionLocationItem;", "QualificationSummary", "PositionStartDate", "UserArea", "Lcom/findajob/jobamax/model/UserArea;", "JobCategory", "Lcom/findajob/jobamax/model/JobCategoryItem;", "DepartmentName", "JobGrade", "Lcom/findajob/jobamax/model/JobGradeItem;", "PositionURI", "PublicationStartDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/findajob/jobamax/model/UserArea;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationCloseDate", "()Ljava/lang/String;", "getApplyURI", "()Ljava/util/List;", "getDepartmentName", "getJobCategory", "getJobGrade", "getOrganizationName", "getPositionEndDate", "getPositionFormattedDescription", "getPositionID", "getPositionLocation", "getPositionLocationDisplay", "getPositionOfferingType", "getPositionRemuneration", "getPositionSchedule", "getPositionStartDate", "getPositionTitle", "getPositionURI", "getPublicationStartDate", "getQualificationSummary", "getUserArea", "()Lcom/findajob/jobamax/model/UserArea;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class MatchedObjectDescriptor {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String OrganizationName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PositionLocationDisplay = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PositionTitle = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.model.PositionScheduleItem> PositionSchedule = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ApplicationCloseDate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PositionID = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PositionEndDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.model.PositionOfferingTypeItem> PositionOfferingType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.model.PositionRemunerationItem> PositionRemuneration = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> ApplyURI = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.model.PositionFormattedDescriptionItem> PositionFormattedDescription = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.model.PositionLocationItem> PositionLocation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String QualificationSummary = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PositionStartDate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.model.UserArea UserArea = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.model.JobCategoryItem> JobCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String DepartmentName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.model.JobGradeItem> JobGrade = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PositionURI = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PublicationStartDate = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.MatchedObjectDescriptor copy(@org.jetbrains.annotations.NotNull()
    java.lang.String OrganizationName, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionLocationDisplay, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionTitle, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionScheduleItem> PositionSchedule, @org.jetbrains.annotations.NotNull()
    java.lang.String ApplicationCloseDate, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionID, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionEndDate, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionOfferingTypeItem> PositionOfferingType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionRemunerationItem> PositionRemuneration, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> ApplyURI, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionFormattedDescriptionItem> PositionFormattedDescription, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionLocationItem> PositionLocation, @org.jetbrains.annotations.NotNull()
    java.lang.String QualificationSummary, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionStartDate, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UserArea UserArea, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.JobCategoryItem> JobCategory, @org.jetbrains.annotations.NotNull()
    java.lang.String DepartmentName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.JobGradeItem> JobGrade, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionURI, @org.jetbrains.annotations.NotNull()
    java.lang.String PublicationStartDate) {
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
    
    public MatchedObjectDescriptor(@org.jetbrains.annotations.NotNull()
    java.lang.String OrganizationName, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionLocationDisplay, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionTitle, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionScheduleItem> PositionSchedule, @org.jetbrains.annotations.NotNull()
    java.lang.String ApplicationCloseDate, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionID, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionEndDate, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionOfferingTypeItem> PositionOfferingType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionRemunerationItem> PositionRemuneration, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> ApplyURI, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionFormattedDescriptionItem> PositionFormattedDescription, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.PositionLocationItem> PositionLocation, @org.jetbrains.annotations.NotNull()
    java.lang.String QualificationSummary, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionStartDate, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UserArea UserArea, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.JobCategoryItem> JobCategory, @org.jetbrains.annotations.NotNull()
    java.lang.String DepartmentName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.findajob.jobamax.model.JobGradeItem> JobGrade, @org.jetbrains.annotations.NotNull()
    java.lang.String PositionURI, @org.jetbrains.annotations.NotNull()
    java.lang.String PublicationStartDate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrganizationName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositionLocationDisplay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositionTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionScheduleItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionScheduleItem> getPositionSchedule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApplicationCloseDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositionID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositionEndDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionOfferingTypeItem> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionOfferingTypeItem> getPositionOfferingType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionRemunerationItem> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionRemunerationItem> getPositionRemuneration() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getApplyURI() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionFormattedDescriptionItem> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionFormattedDescriptionItem> getPositionFormattedDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionLocationItem> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.PositionLocationItem> getPositionLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQualificationSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositionStartDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.UserArea component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.UserArea getUserArea() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.JobCategoryItem> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.JobCategoryItem> getJobCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDepartmentName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.JobGradeItem> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.model.JobGradeItem> getJobGrade() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositionURI() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPublicationStartDate() {
        return null;
    }
}