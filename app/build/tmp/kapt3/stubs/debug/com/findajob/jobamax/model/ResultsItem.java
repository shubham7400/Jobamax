package com.findajob.jobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/findajob/jobamax/model/ResultsItem;", "", "created", "", "description", "salary_max", "", "title", "salaryIsPredicted", "adref", "salary_min", "Class", "contract_time", "location", "Lcom/findajob/jobamax/model/Location;", "company", "Lcom/findajob/jobamax/model/CompanyAdzuna;", "id", "category", "Lcom/findajob/jobamax/model/Category;", "redirect_url", "(Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Lcom/findajob/jobamax/model/Location;Lcom/findajob/jobamax/model/CompanyAdzuna;Ljava/lang/String;Lcom/findajob/jobamax/model/Category;Ljava/lang/String;)V", "getClass", "()Ljava/lang/String;", "getAdref", "getCategory", "()Lcom/findajob/jobamax/model/Category;", "getCompany", "()Lcom/findajob/jobamax/model/CompanyAdzuna;", "getContract_time", "getCreated", "getDescription", "getId", "getLocation", "()Lcom/findajob/jobamax/model/Location;", "getRedirect_url", "getSalaryIsPredicted", "getSalary_max", "()F", "getSalary_min", "getTitle", "app_debug"})
public final class ResultsItem {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String created = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final float salary_max = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String salaryIsPredicted = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String adref = null;
    private final float salary_min = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Class = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contract_time = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.model.Location location = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.model.CompanyAdzuna company = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.model.Category category = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String redirect_url = null;
    
    public ResultsItem(@org.jetbrains.annotations.NotNull()
    java.lang.String created, @org.jetbrains.annotations.NotNull()
    java.lang.String description, float salary_max, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String salaryIsPredicted, @org.jetbrains.annotations.NotNull()
    java.lang.String adref, float salary_min, @org.jetbrains.annotations.NotNull()
    java.lang.String Class, @org.jetbrains.annotations.NotNull()
    java.lang.String contract_time, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Location location, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.CompanyAdzuna company, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Category category, @org.jetbrains.annotations.NotNull()
    java.lang.String redirect_url) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final float getSalary_max() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSalaryIsPredicted() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAdref() {
        return null;
    }
    
    public final float getSalary_min() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClass() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContract_time() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Location getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.CompanyAdzuna getCompany() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Category getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRedirect_url() {
        return null;
    }
}