package com.jobamax.appjobamax.recruiter.model;

import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.parse.ParseObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u0000 12\u00020\u0001:\u00011B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u00100\u001a\u00020\u0004R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010\'\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010*\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001a\u0010-\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001a\u00a8\u00062"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/model/CompanySubscription;", "", "()V", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "companyId", "", "getCompanyId", "()Ljava/lang/String;", "setCompanyId", "(Ljava/lang/String;)V", "companySubscriptionParseObject", "getCompanySubscriptionParseObject", "()Lcom/parse/ParseObject;", "setCompanySubscriptionParseObject", "isActivate", "", "()Z", "setActivate", "(Z)V", "planType", "", "getPlanType", "()I", "setPlanType", "(I)V", "selectPlanType", "getSelectPlanType", "setSelectPlanType", "totalJobOffers", "getTotalJobOffers", "setTotalJobOffers", "totalMatches", "getTotalMatches", "setTotalMatches", "totalSourcings", "getTotalSourcings", "setTotalSourcings", "usedJobOffer", "getUsedJobOffer", "setUsedJobOffer", "usedMatches", "getUsedMatches", "setUsedMatches", "usedSourcing", "getUsedSourcing", "setUsedSourcing", "toParseObject", "Companion", "app_debug"})
public final class CompanySubscription {
    private int totalJobOffers = 0;
    private int totalSourcings = 0;
    private int totalMatches = 0;
    private int usedMatches = 0;
    private int usedJobOffer = 0;
    private int usedSourcing = 0;
    private int planType = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectPlanType = "";
    private boolean isActivate = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyId = "";
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject companySubscriptionParseObject;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.recruiter.model.CompanySubscription.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CLASS_NAME = "CompanySubscription";
    
    public final int getTotalJobOffers() {
        return 0;
    }
    
    public final void setTotalJobOffers(int p0) {
    }
    
    public final int getTotalSourcings() {
        return 0;
    }
    
    public final void setTotalSourcings(int p0) {
    }
    
    public final int getTotalMatches() {
        return 0;
    }
    
    public final void setTotalMatches(int p0) {
    }
    
    public final int getUsedMatches() {
        return 0;
    }
    
    public final void setUsedMatches(int p0) {
    }
    
    public final int getUsedJobOffer() {
        return 0;
    }
    
    public final void setUsedJobOffer(int p0) {
    }
    
    public final int getUsedSourcing() {
        return 0;
    }
    
    public final void setUsedSourcing(int p0) {
    }
    
    public final int getPlanType() {
        return 0;
    }
    
    public final void setPlanType(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectPlanType() {
        return null;
    }
    
    public final void setSelectPlanType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isActivate() {
        return false;
    }
    
    public final void setActivate(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyId() {
        return null;
    }
    
    public final void setCompanyId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCompanySubscriptionParseObject() {
        return null;
    }
    
    public final void setCompanySubscriptionParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    public CompanySubscription() {
        super();
    }
    
    public CompanySubscription(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/model/CompanySubscription$Companion;", "", "()V", "CLASS_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}