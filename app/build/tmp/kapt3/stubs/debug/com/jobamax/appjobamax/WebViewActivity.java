package com.jobamax.appjobamax;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jobamax.appjobamax.base.BaseActivity;
import com.jobamax.appjobamax.databinding.ActivityWebViewBinding;
import kotlinx.android.synthetic.main.activity_web_view.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/jobamax/appjobamax/WebViewActivity;", "Lcom/jobamax/appjobamax/base/BaseActivity;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/ActivityWebViewBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ActivityWebViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "initWebView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "MyWebViewClient", "app_debug"})
public final class WebViewActivity extends com.jobamax.appjobamax.base.BaseActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy binding$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public WebViewActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.ActivityWebViewBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initWebView() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/jobamax/appjobamax/WebViewActivity$MyWebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "app_debug"})
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