package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/repo/CompanyRepo;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "get", "", "callback", "Lcom/findajob/jobamax/repo/GetCompanyCallback;", "recruiterId", "", "save", "company", "Lcom/parse/ParseObject;", "Lcom/findajob/jobamax/repo/SaveParseObjectCallback;", "app_debug"})
public final class CompanyRepo {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    public CompanyRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void save(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject company, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void get(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetCompanyCallback callback) {
    }
    
    public final void get(@org.jetbrains.annotations.NotNull()
    java.lang.String recruiterId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetCompanyCallback callback) {
    }
}