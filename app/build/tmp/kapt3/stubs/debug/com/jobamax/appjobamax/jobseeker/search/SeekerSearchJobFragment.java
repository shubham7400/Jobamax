package com.jobamax.appjobamax.jobseeker.search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.google.firebase.ktx.Firebase;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.WebViewActivity;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentSeekerSearchJobBinding;
import com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding;
import com.jobamax.appjobamax.dialog.JobReportDialog;
import com.jobamax.appjobamax.dialog.MessageDialog;
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.delegation.CircularRevealViewAnimation;
import com.jobamax.appjobamax.jobseeker.delegation.CircularRevealViewAnimationImpl;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.preference.*;
import com.jobamax.appjobamax.util.*;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u000203H\u0002J\b\u0010]\u001a\u00020[H\u0002J\b\u0010^\u001a\u00020[H\u0002J\b\u0010_\u001a\u00020[H\u0002J&\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u00182\n\b\u0002\u0010c\u001a\u0004\u0018\u00010d2\b\b\u0002\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u00020[H\u0002J\b\u0010h\u001a\u00020[H\u0002J\"\u0010i\u001a\u00020[2\u0006\u0010j\u001a\u0002032\u0006\u0010k\u001a\u0002032\b\u0010l\u001a\u0004\u0018\u000109H\u0016J$\u0010m\u001a\u00020a2\u0006\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\b\u0010t\u001a\u00020[H\u0016J\b\u0010u\u001a\u00020[H\u0016J\b\u0010v\u001a\u00020[H\u0016J\u0010\u0010w\u001a\u00020[2\u0006\u0010\\\u001a\u000203H\u0002J\b\u0010x\u001a\u00020[H\u0002J\b\u0010y\u001a\u00020[H\u0002J\u0010\u0010z\u001a\u00020[2\u0006\u0010{\u001a\u00020$H\u0002J\b\u0010|\u001a\u00020[H\u0002J\b\u0010}\u001a\u00020[H\u0002J\u0006\u0010~\u001a\u00020[J\b\u0010\u007f\u001a\u00020[H\u0002J\t\u0010\u0080\u0001\u001a\u00020[H\u0002J\b\u0010-\u001a\u00020[H\u0002J\t\u0010\u0081\u0001\u001a\u00020[H\u0002J\t\u0010\u0082\u0001\u001a\u00020[H\u0002J\t\u0010\u0083\u0001\u001a\u00020[H\u0002J\t\u0010\u0084\u0001\u001a\u00020[H\u0002J\t\u0010\u0085\u0001\u001a\u00020[H\u0002J\u0012\u0010\u0086\u0001\u001a\u00020[2\u0007\u0010\u0087\u0001\u001a\u00020fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u000e\u00102\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u00104\u001a\b\u0012\u0004\u0012\u00020\u00180#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010&\"\u0004\b6\u0010(R\u001c\u00107\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u0001090908X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010!R\u000e\u0010C\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020EX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010=\"\u0004\bM\u0010?R\u001c\u0010N\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001f\"\u0004\bP\u0010!R\u001b\u0010Q\u001a\u00020R8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bS\u0010TR \u0010W\u001a\b\u0012\u0004\u0012\u00020\u00180#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010&\"\u0004\bY\u0010(\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/SeekerSearchJobFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "adapter", "Lcom/jobamax/appjobamax/jobseeker/search/SeekerJobNewCardStackAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/jobseeker/search/SeekerJobNewCardStackAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/jobseeker/search/SeekerJobNewCardStackAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerSearchJobBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentSeekerSearchJobBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentSeekerSearchJobBinding;)V", "cardStackLayoutManager", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "getCardStackLayoutManager", "()Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "setCardStackLayoutManager", "(Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;)V", "cardStackListener", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "companyUrl", "", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "jobOfferId", "getJobOfferId", "()Ljava/lang/String;", "setJobOfferId", "(Ljava/lang/String;)V", "jobOfferList", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/JobOffer;", "getJobOfferList", "()Ljava/util/ArrayList;", "setJobOfferList", "(Ljava/util/ArrayList;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "jobSeekerId", "getJobSeekerId", "setJobSeekerId", "leftSwipeCount", "", "refuseJobsId", "getRefuseJobsId", "setRefuseJobsId", "resultContract", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "rewindJobOffer", "getRewindJobOffer", "()Lcom/jobamax/appjobamax/model/JobOffer;", "setRewindJobOffer", "(Lcom/jobamax/appjobamax/model/JobOffer;)V", "rewindJobOfferId", "getRewindJobOfferId", "setRewindJobOfferId", "rightSwipeCount", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "swipeCount", "swipedJobOffer", "getSwipedJobOffer", "setSwipedJobOffer", "topJobOfferId", "getTopJobOfferId", "setTopJobOfferId", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "wishlistAddedJobsId", "getWishlistAddedJobsId", "setWishlistAddedJobsId", "addToRefuseJob", "", "type", "addToWishlistJob", "alignJobCard", "configureUi", "createChip", "Landroid/view/View;", "tag", "matchTag", "Lcom/jobamax/appjobamax/model/MatchTag;", "isFullGradient", "", "getJobOffers", "increaseSwipeCount", "onActivityResult", "requestCode", "resultCode", "data", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "removeJobFromRefuse", "removeJobFromWishlist", "saveSwipeCount", "setCardData", "job", "setCardStackListener", "setCardStackView", "setClickListeners", "setData", "setJobFilterSwitchListener", "setMatchPercentage", "shareJob", "showJobCardSwipeTutorial", "startJobMatchAnimation", "updateJobVisibility", "updateSwitchState", "isChecked", "app_debug"})
public final class SeekerSearchJobFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentSeekerSearchJobBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    private final java.lang.String companyUrl = "https://jobamax.com/webapp/company/";
    public com.jobamax.appjobamax.jobseeker.search.SeekerJobNewCardStackAdapter adapter;
    public com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager;
    private com.yuyakaido.android.cardstackview.CardStackListener cardStackListener;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> jobOfferList;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String topJobOfferId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String rewindJobOfferId;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.JobOffer swipedJobOffer;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.JobOffer rewindJobOffer;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> wishlistAddedJobsId;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> refuseJobsId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String jobSeekerId = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String jobOfferId = "";
    private int swipeCount = 0;
    private int rightSwipeCount = 0;
    private int leftSwipeCount = 0;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultContract = null;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.Runnable runnable;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerSearchJobFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentSeekerSearchJobBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentSeekerSearchJobBinding p0) {
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
    public final com.jobamax.appjobamax.jobseeker.search.SeekerJobNewCardStackAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.search.SeekerJobNewCardStackAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.yuyakaido.android.cardstackview.CardStackLayoutManager getCardStackLayoutManager() {
        return null;
    }
    
    public final void setCardStackLayoutManager(@org.jetbrains.annotations.NotNull()
    com.yuyakaido.android.cardstackview.CardStackLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> getJobOfferList() {
        return null;
    }
    
    public final void setJobOfferList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTopJobOfferId() {
        return null;
    }
    
    public final void setTopJobOfferId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRewindJobOfferId() {
        return null;
    }
    
    public final void setRewindJobOfferId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.JobOffer getSwipedJobOffer() {
        return null;
    }
    
    public final void setSwipedJobOffer(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.JobOffer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.JobOffer getRewindJobOffer() {
        return null;
    }
    
    public final void setRewindJobOffer(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.JobOffer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getWishlistAddedJobsId() {
        return null;
    }
    
    public final void setWishlistAddedJobsId(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getRefuseJobsId() {
        return null;
    }
    
    public final void setRefuseJobsId(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final void setJobSeekerId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    public final void setJobOfferId(@org.jetbrains.annotations.Nullable()
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
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void configureUi() {
    }
    
    private final void showJobCardSwipeTutorial() {
    }
    
    private final void setJobFilterSwitchListener() {
    }
    
    private final void setJobSeeker() {
    }
    
    private final void setData() {
    }
    
    private final void setCardData(com.jobamax.appjobamax.model.JobOffer job) {
    }
    
    private final android.view.View createChip(java.lang.String tag, com.jobamax.appjobamax.model.MatchTag matchTag, boolean isFullGradient) {
        return null;
    }
    
    private final void setCardStackView() {
    }
    
    private final void updateJobVisibility() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Runnable getRunnable() {
        return null;
    }
    
    public final void setRunnable(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable p0) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void alignJobCard() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void setMatchPercentage() {
    }
    
    private final void setCardStackListener() {
    }
    
    private final void increaseSwipeCount() {
    }
    
    private final void removeJobFromRefuse(int type) {
    }
    
    private final void saveSwipeCount() {
    }
    
    private final void shareJob() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void addToRefuseJob(int type) {
    }
    
    private final void addToWishlistJob() {
    }
    
    private final void removeJobFromWishlist() {
    }
    
    private final void getJobOffers() {
    }
    
    public final void setClickListeners() {
    }
    
    private final void startJobMatchAnimation() {
    }
    
    private final void updateSwitchState(boolean isChecked) {
    }
}