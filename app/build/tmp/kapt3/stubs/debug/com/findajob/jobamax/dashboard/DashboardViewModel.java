package com.findajob.jobamax.dashboard;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\t0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/findajob/jobamax/dashboard/DashboardViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "currentPage", "Landroidx/lifecycle/MutableLiveData;", "", "getCurrentPage", "()Landroidx/lifecycle/MutableLiveData;", "setCurrentPage", "(Landroidx/lifecycle/MutableLiveData;)V", "navItemId", "getNavItemId", "offscreenPageLimit", "getOffscreenPageLimit", "()I", "setOffscreenPageLimit", "(I)V", "pageSelected", "kotlin.jvm.PlatformType", "getPageSelected", "setPageSelected", "onNavigationClick", "", "item", "Landroid/view/MenuItem;", "onPageSelected", "", "position", "app_debug"})
public final class DashboardViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> navItemId = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> pageSelected;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> currentPage;
    private int offscreenPageLimit = 0;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getNavItemId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getPageSelected() {
        return null;
    }
    
    public final void setPageSelected(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCurrentPage() {
        return null;
    }
    
    public final void setCurrentPage(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    public final int getOffscreenPageLimit() {
        return 0;
    }
    
    public final void setOffscreenPageLimit(int p0) {
    }
    
    public final void onPageSelected(int position) {
    }
    
    public final boolean onNavigationClick(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
}