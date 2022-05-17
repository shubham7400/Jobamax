package com.jobamax.appjobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\'\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010-\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u0004R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010\'\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000b\u00a8\u00061"}, d2 = {"Lcom/jobamax/appjobamax/model/Company;", "", "()V", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "companyId", "", "getCompanyId", "()Ljava/lang/String;", "setCompanyId", "(Ljava/lang/String;)V", "companySize", "getCompanySize", "setCompanySize", "companyWebsite", "getCompanyWebsite", "setCompanyWebsite", "headquarterAddress", "getHeadquarterAddress", "setHeadquarterAddress", "logoUrl", "getLogoUrl", "setLogoUrl", "name", "getName", "setName", "position", "getPosition", "setPosition", "recruiterId", "getRecruiterId", "setRecruiterId", "regNumber", "getRegNumber", "setRegNumber", "vatNumber", "getVatNumber", "setVatNumber", "videoPresentationThumbLink", "getVideoPresentationThumbLink", "setVideoPresentationThumbLink", "videoPresentationUrl", "getVideoPresentationUrl", "setVideoPresentationUrl", "toParseObject", "update", "", "Companion", "app_release"})
public final class Company {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String recruiterId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String position = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyWebsite = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companySize = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String regNumber = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String vatNumber = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String headquarterAddress = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String logoUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String videoPresentationUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String videoPresentationThumbLink = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.model.Company.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CLASS_NAME = "company";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyId() {
        return null;
    }
    
    public final void setCompanyId(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getPosition() {
        return null;
    }
    
    public final void setPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyWebsite() {
        return null;
    }
    
    public final void setCompanyWebsite(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanySize() {
        return null;
    }
    
    public final void setCompanySize(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRegNumber() {
        return null;
    }
    
    public final void setRegNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVatNumber() {
        return null;
    }
    
    public final void setVatNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHeadquarterAddress() {
        return null;
    }
    
    public final void setHeadquarterAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLogoUrl() {
        return null;
    }
    
    public final void setLogoUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVideoPresentationUrl() {
        return null;
    }
    
    public final void setVideoPresentationUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVideoPresentationThumbLink() {
        return null;
    }
    
    public final void setVideoPresentationThumbLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Company() {
        super();
    }
    
    public Company(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    public final void update(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/jobamax/appjobamax/model/Company$Companion;", "", "()V", "CLASS_NAME", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}