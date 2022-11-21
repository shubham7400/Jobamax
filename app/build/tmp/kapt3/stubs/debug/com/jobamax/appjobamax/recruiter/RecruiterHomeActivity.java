package com.jobamax.appjobamax.recruiter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.ActivityRecruiterHomeBinding;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.recruiter.home.RecruiterHomeFragment;
import com.jobamax.appjobamax.recruiter.message.RecruiterChatListFragment;
import com.jobamax.appjobamax.recruiter.profile.RecruiterProfileFragment;
import com.jobamax.appjobamax.recruiter.search.RecruiterSearchFragment;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u0011\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001b0\u001dJ\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0006\u0010#\u001a\u00020\u001bJ\b\u0010\u0013\u001a\u00020\u001bH\u0002J(\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/RecruiterHomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/ActivityRecruiterHomeBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ActivityRecruiterHomeBinding;", "binding$delegate", "Lkotlin/Lazy;", "profileTab", "Landroid/widget/ImageView;", "getProfileTab", "()Landroid/widget/ImageView;", "setProfileTab", "(Landroid/widget/ImageView;)V", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "configureUi", "", "callback", "Lkotlin/Function1;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "setData", "setTabSelection", "homeTab", "searchTab", "chatTab", "setUpViewPager", "setViewModelObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RecruiterHomeActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView profileTab;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterHomeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.ActivityRecruiterHomeBinding getBinding() {
        return null;
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
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getProfileTab() {
        return null;
    }
    
    public final void setProfileTab(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configureUi() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void setViewModelObserver() {
    }
    
    private final void setUpViewPager() {
    }
    
    private final void setTabSelection(android.widget.ImageView homeTab, android.widget.ImageView searchTab, android.widget.ImageView chatTab, android.widget.ImageView profileTab) {
    }
    
    private final void setRecruiter() {
    }
    
    public final void setData() {
    }
    
    public final void getRecruiter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
}