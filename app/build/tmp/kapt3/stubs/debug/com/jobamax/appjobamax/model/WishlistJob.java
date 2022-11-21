package com.jobamax.appjobamax.model;

import java.io.Serializable;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u0017X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/jobamax/appjobamax/model/WishlistJob;", "Ljava/io/Serializable;", "()V", "companyLogo", "", "getCompanyLogo", "()Ljava/lang/String;", "companyName", "getCompanyName", "isApplied", "", "()Z", "setApplied", "(Z)V", "isArchived", "setArchived", "isFavroite", "setFavroite", "jobOfferId", "getJobOfferId", "jobTitle", "getJobTitle", "jobType", "", "getJobType", "()J", "jobUrl", "getJobUrl", "location", "getLocation", "typeOfWork", "getTypeOfWork", "app_debug"})
public final class WishlistJob implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jobOfferId = "";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String companyLogo = "";
    private boolean isArchived = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jobTitle = "";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String companyName = "";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jobUrl = "";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String location = "";
    private boolean isApplied = false;
    private final long jobType = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String typeOfWork = "";
    private boolean isFavroite = false;
    
    public WishlistJob() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyLogo() {
        return null;
    }
    
    public final boolean isArchived() {
        return false;
    }
    
    public final void setArchived(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final boolean isApplied() {
        return false;
    }
    
    public final void setApplied(boolean p0) {
    }
    
    public final long getJobType() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypeOfWork() {
        return null;
    }
    
    public final boolean isFavroite() {
        return false;
    }
    
    public final void setFavroite(boolean p0) {
    }
}