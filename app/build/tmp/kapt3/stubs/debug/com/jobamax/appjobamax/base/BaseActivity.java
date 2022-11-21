package com.jobamax.appjobamax.base;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/jobamax/appjobamax/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "progressHud", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "getProgressHud", "()Lcom/kaopiz/kprogresshud/KProgressHUD;", "setProgressHud", "(Lcom/kaopiz/kprogresshud/KProgressHUD;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "app_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.kaopiz.kprogresshud.KProgressHUD progressHud;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kaopiz.kprogresshud.KProgressHUD getProgressHud() {
        return null;
    }
    
    public final void setProgressHud(@org.jetbrains.annotations.NotNull()
    com.kaopiz.kprogresshud.KProgressHUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}