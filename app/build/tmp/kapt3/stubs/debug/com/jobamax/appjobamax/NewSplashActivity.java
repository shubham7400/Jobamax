package com.jobamax.appjobamax;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkHost;
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity;
import com.jobamax.appjobamax.login.LoginFlowActivity;
import com.jobamax.appjobamax.model.UserTempInfo;
import com.jobamax.appjobamax.preference.*;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/jobamax/appjobamax/NewSplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "user", "Lcom/jobamax/appjobamax/model/UserTempInfo;", "getUser", "()Lcom/jobamax/appjobamax/model/UserTempInfo;", "configureUi", "", "handleIntent", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "showDeepLinkOffer", "appLinkData", "Landroid/net/Uri;", "app_debug"})
public final class NewSplashActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final com.jobamax.appjobamax.model.UserTempInfo user = null;
    private java.util.HashMap _$_findViewCache;
    
    public NewSplashActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.UserTempInfo getUser() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configureUi() {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final void handleIntent(android.content.Intent intent) {
    }
    
    private final void showDeepLinkOffer(android.net.Uri appLinkData) {
    }
}