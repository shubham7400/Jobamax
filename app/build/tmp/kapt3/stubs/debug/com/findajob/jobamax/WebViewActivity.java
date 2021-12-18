package com.findajob.jobamax;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/findajob/jobamax/WebViewActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityWebViewBinding;", "()V", "layoutRes", "", "getLayoutRes", "()I", "getViewModel", "Landroidx/lifecycle/ViewModel;", "initWebView", "", "onCreated", "instance", "Landroid/os/Bundle;", "MyWebViewClient", "app_debug"})
public final class WebViewActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityWebViewBinding> {
    private java.util.HashMap _$_findViewCache;
    
    public WebViewActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance) {
    }
    
    private final void initWebView() {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/WebViewActivity$MyWebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "app_debug"})
    static final class MyWebViewClient extends android.webkit.WebViewClient {
        
        public MyWebViewClient() {
            super();
        }
        
        @java.lang.Override()
        public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.NotNull()
        android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
        java.lang.String url) {
            return false;
        }
    }
}