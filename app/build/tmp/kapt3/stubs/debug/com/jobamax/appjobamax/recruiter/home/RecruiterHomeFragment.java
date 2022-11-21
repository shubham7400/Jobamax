package com.jobamax.appjobamax.recruiter.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBinding;
import com.jobamax.appjobamax.databinding.ItemPortfolioLinkBinding;
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding;
import com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.*;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.JobMatchedDialog;
import com.jobamax.appjobamax.recruiter.model.CompanySubscription;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2;
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient;
import com.jobamax.appjobamax.util.StudentStatus;
import com.parse.*;
import com.parse.livequery.SubscriptionHandling;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import kotlin.collections.HashSet;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020!H\u0002J\b\u0010\\\u001a\u00020XH\u0002J\b\u0010/\u001a\u00020XH\u0002J\u0010\u0010]\u001a\u00020X2\u0006\u0010^\u001a\u00020!H\u0002J\b\u0010_\u001a\u00020XH\u0002J\b\u0010`\u001a\u00020XH\u0002J\"\u0010a\u001a\u00020X2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020c2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J$\u0010g\u001a\u00020Z2\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\b\u0010n\u001a\u00020XH\u0016J\b\u0010o\u001a\u00020XH\u0016J\b\u0010p\u001a\u00020XH\u0016J$\u0010q\u001a\u00020X2\u0006\u0010r\u001a\u00020c2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020X0tH\u0002J\b\u0010v\u001a\u00020XH\u0002J\b\u0010\u0019\u001a\u00020XH\u0002J\b\u0010w\u001a\u00020XH\u0002J\b\u0010x\u001a\u00020XH\u0002J\b\u0010y\u001a\u00020XH\u0002J\b\u0010z\u001a\u00020XH\u0002J\b\u0010{\u001a\u00020XH\u0002J\b\u0010|\u001a\u00020XH\u0002J\b\u0010}\u001a\u00020XH\u0002J\b\u0010~\u001a\u00020XH\u0002J\b\u0010\u007f\u001a\u00020XH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020<0-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001a\u0010@\u001a\u00020AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020M0-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R\u001b\u0010Q\u001a\u00020R8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bS\u0010T\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/home/RecruiterHomeFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "adapter", "Lcom/jobamax/appjobamax/recruiter/home/RecruitmentSeekerJobCardStackAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/recruiter/home/RecruitmentSeekerJobCardStackAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/recruiter/home/RecruitmentSeekerJobCardStackAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterHomeBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterHomeBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterHomeBinding;)V", "cardStackLayoutManager", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "getCardStackLayoutManager", "()Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "setCardStackLayoutManager", "(Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;)V", "cardStackListener", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "getCardStackListener", "()Lcom/yuyakaido/android/cardstackview/CardStackListener;", "setCardStackListener", "(Lcom/yuyakaido/android/cardstackview/CardStackListener;)V", "companySubscription", "Lcom/jobamax/appjobamax/recruiter/model/CompanySubscription;", "companySubscriptionHandling", "Lcom/parse/livequery/SubscriptionHandling;", "Lcom/parse/ParseObject;", "currentJobOfferId", "", "getCurrentJobOfferId", "()Ljava/lang/String;", "setCurrentJobOfferId", "(Ljava/lang/String;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "jobTitleFilterList", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "getJobTitleFilterList", "()Ljava/util/ArrayList;", "setJobTitleFilterList", "(Ljava/util/ArrayList;)V", "jobTitleFilterListAddMoreObject", "jobTitleFilterListTitleObject", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "recruitmentSeekerList", "Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;", "rewindJobSeekerId", "getRewindJobSeekerId", "setRewindJobSeekerId", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "spinnerAdapter", "Lcom/jobamax/appjobamax/recruiter/home/JobTitleFilterSpinnerAdapter;", "getSpinnerAdapter", "()Lcom/jobamax/appjobamax/recruiter/home/JobTitleFilterSpinnerAdapter;", "setSpinnerAdapter", "(Lcom/jobamax/appjobamax/recruiter/home/JobTitleFilterSpinnerAdapter;)V", "swipedRecruitmentSeekerList", "Lcom/jobamax/appjobamax/recruiter/home/SwipedRecruitmentSeeker;", "topJobSeekerId", "getTopJobSeekerId", "setTopJobSeekerId", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "createChip", "Landroid/view/View;", "tag", "fetchCompanySubscription", "getRecruitmentSeekers", "jobOfferId", "getSeekerFolders", "initializeRecruiter", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "recruitmentService", "recruitmentStep", "isSuccess", "Lkotlin/Function1;", "", "rewindRecruitmentSeeker", "setCardStackView", "setClickListeners", "setData", "setJobTitleFilterSpinnerAdapter", "setObserver", "setSubscription", "subscribeCompanySubscription", "updateJobTitleFilterList", "updateJobVisibility", "app_debug"})
public final class RecruiterHomeFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    private com.jobamax.appjobamax.recruiter.model.CompanySubscription companySubscription;
    private com.parse.livequery.SubscriptionHandling<com.parse.ParseObject> companySubscriptionHandling;
    public com.jobamax.appjobamax.recruiter.home.RecruitmentSeekerJobCardStackAdapter adapter;
    public com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager;
    public com.yuyakaido.android.cardstackview.CardStackListener cardStackListener;
    public com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter spinnerAdapter;
    private final com.jobamax.appjobamax.recruiter.model.JobTitleFilter jobTitleFilterListTitleObject = null;
    private final com.jobamax.appjobamax.recruiter.model.JobTitleFilter jobTitleFilterListAddMoreObject = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> jobTitleFilterList;
    private java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> recruitmentSeekerList;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.home.SwipedRecruitmentSeeker> swipedRecruitmentSeekerList = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String topJobSeekerId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String rewindJobSeekerId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentJobOfferId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.Runnable runnable;
    @org.jetbrains.annotations.NotNull()
    private android.os.Handler handler;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterHomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBinding p0) {
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
    public final com.jobamax.appjobamax.recruiter.home.RecruitmentSeekerJobCardStackAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.home.RecruitmentSeekerJobCardStackAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.yuyakaido.android.cardstackview.CardStackLayoutManager getCardStackLayoutManager() {
        return null;
    }
    
    public final void setCardStackLayoutManager(@org.jetbrains.annotations.NotNull()
    com.yuyakaido.android.cardstackview.CardStackLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.yuyakaido.android.cardstackview.CardStackListener getCardStackListener() {
        return null;
    }
    
    public final void setCardStackListener(@org.jetbrains.annotations.NotNull()
    com.yuyakaido.android.cardstackview.CardStackListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter getSpinnerAdapter() {
        return null;
    }
    
    public final void setSpinnerAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> getJobTitleFilterList() {
        return null;
    }
    
    public final void setJobTitleFilterList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTopJobSeekerId() {
        return null;
    }
    
    public final void setTopJobSeekerId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRewindJobSeekerId() {
        return null;
    }
    
    public final void setRewindJobSeekerId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentJobOfferId() {
        return null;
    }
    
    public final void setCurrentJobOfferId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    private final void subscribeCompanySubscription() {
    }
    
    private final void fetchCompanySubscription() {
    }
    
    private final void initializeRecruiter() {
    }
    
    private final void setData() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void getSeekerFolders() {
    }
    
    private final void setObserver() {
    }
    
    private final void setSubscription() {
    }
    
    private final void setJobTitleFilterSpinnerAdapter() {
    }
    
    private final void getRecruitmentSeekers(java.lang.String jobOfferId) {
    }
    
    private final void updateJobTitleFilterList() {
    }
    
    private final void getJobTitleFilterList() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void setCardStackView() {
    }
    
    private final android.view.View createChip(java.lang.String tag) {
        return null;
    }
    
    private final void updateJobVisibility() {
    }
    
    private final void setCardStackListener() {
    }
    
    private final void rewindRecruitmentSeeker() {
    }
    
    private final void recruitmentService(int recruitmentStep, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isSuccess) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Runnable getRunnable() {
        return null;
    }
    
    public final void setRunnable(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    public final void setHandler(@org.jetbrains.annotations.NotNull()
    android.os.Handler p0) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
}