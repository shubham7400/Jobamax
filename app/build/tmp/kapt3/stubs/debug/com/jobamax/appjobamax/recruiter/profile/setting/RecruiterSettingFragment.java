package com.jobamax.appjobamax.recruiter.profile.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.ktx.Firebase;
import com.jobamax.appjobamax.NewSplashActivity;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.WebViewActivity;
import com.jobamax.appjobamax.databinding.FragmentRecruiterSettingBinding;
import com.jobamax.appjobamax.dialog.DialogYesNoSimple;
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath;
import com.jobamax.appjobamax.enums.WebsiteUrls;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.pushwoosh.Pushwoosh;
import kotlinx.android.synthetic.main.fragment_recruiter_personal_info.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/profile/setting/RecruiterSettingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterSettingBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterSettingBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterSettingBinding;)V", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "initializeRecruiter", "logout", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onShareJobamaxClicked", "onStart", "setClickListeners", "setData", "setObserver", "app_debug"})
public final class RecruiterSettingFragment extends androidx.fragment.app.Fragment {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterSettingBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterSettingFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterSettingBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterSettingBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    public final void setRecruiter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.Recruiter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void configureUi() {
    }
    
    private final void initializeRecruiter() {
    }
    
    private final void setObserver() {
    }
    
    private final void setData() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void onShareJobamaxClicked() {
    }
    
    private final void logout() {
    }
}