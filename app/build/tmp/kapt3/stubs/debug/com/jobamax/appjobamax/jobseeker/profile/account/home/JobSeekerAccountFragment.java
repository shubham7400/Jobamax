package com.jobamax.appjobamax.jobseeker.profile.account.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import com.jobamax.appjobamax.*;
import com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBinding;
import com.jobamax.appjobamax.dialog.WorkInProgressDialog;
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.WebsiteUrls;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.util.*;
import com.google.firebase.ktx.Firebase;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.dialog.DialogYesNoSimple;
import com.jobamax.appjobamax.jobseeker.profile.account.SeekerSettingActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.parse.ParseUser;
import com.pushwoosh.Pushwoosh;
import com.pushwoosh.exception.PushwooshException;
import com.pushwoosh.function.Callback;
import com.pushwoosh.function.Result;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010\'\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\b\u00102\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00063"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/account/home/JobSeekerAccountFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "Lcom/jobamax/appjobamax/jobseeker/profile/account/home/JobSeekerAccountInterface;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentJobSeekerAccountBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentJobSeekerAccountBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentJobSeekerAccountBinding;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "initializeJobSeeker", "onCommunityGuidelinesClicked", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteAccountClicked", "onEmailUsClicked", "onHelpAndSupportClicked", "onLogoutClicked", "onManageReadReceiptsClicked", "onNewsletterClicked", "onPasswordClicked", "onPersonalInformationClicked", "onPrivacyPolicyClicked", "onRestorePurchaseClicked", "onSafetyTipsClicked", "onShareJobamaxClicked", "onStart", "onTermsOfServiceClicked", "setClickListeners", "setData", "setViewModelObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobSeekerAccountFragment extends com.jobamax.appjobamax.base.BaseFragment implements com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface {
    public com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    private java.util.HashMap _$_findViewCache;
    
    public JobSeekerAccountFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.JobSeeker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    private final void initializeJobSeeker() {
    }
    
    private final void setViewModelObserver() {
    }
    
    private final void setData() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override()
    public void onManageReadReceiptsClicked() {
    }
    
    @java.lang.Override()
    public void onPersonalInformationClicked() {
    }
    
    @java.lang.Override()
    public void onNewsletterClicked() {
    }
    
    @java.lang.Override()
    public void onRestorePurchaseClicked() {
    }
    
    @java.lang.Override()
    public void onShareJobamaxClicked() {
    }
    
    @java.lang.Override()
    public void onHelpAndSupportClicked() {
    }
    
    @java.lang.Override()
    public void onEmailUsClicked() {
    }
    
    @java.lang.Override()
    public void onCommunityGuidelinesClicked() {
    }
    
    @java.lang.Override()
    public void onSafetyTipsClicked() {
    }
    
    @java.lang.Override()
    public void onPrivacyPolicyClicked() {
    }
    
    @java.lang.Override()
    public void onTermsOfServiceClicked() {
    }
    
    @java.lang.Override()
    public void onLogoutClicked() {
    }
    
    @java.lang.Override()
    public void onDeleteAccountClicked() {
    }
    
    @java.lang.Override()
    public void onPasswordClicked() {
    }
}