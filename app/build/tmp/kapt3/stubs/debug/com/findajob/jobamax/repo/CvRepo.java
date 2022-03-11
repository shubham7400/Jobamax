package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/findajob/jobamax/repo/CvRepo;", "", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "get", "", "callback", "Lcom/findajob/jobamax/repo/GetCvCallback;", "save", "company", "Lcom/parse/ParseObject;", "Lcom/findajob/jobamax/repo/SaveCvCallback;", "app_debug"})
public final class CvRepo {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    
    public CvRepo(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    public final void save(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject company, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveCvCallback callback) {
    }
    
    public final void get(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetCvCallback callback) {
    }
}