package com.jobamax.appjobamax.recruiter.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterSearchBinding;
import com.jobamax.appjobamax.databinding.ItemPortfolioImage2Binding;
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.DialogAddToFolderOrOffer;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.recruiter.model.*;
import com.jobamax.appjobamax.util.StudentStatus;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020I0OH\u0002J,\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010R\u001a\u00020S2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020I0OH\u0002J\b\u0010T\u001a\u00020IH\u0002J\u001a\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u001e2\b\b\u0002\u0010X\u001a\u00020PH\u0002J\b\u0010Y\u001a\u00020IH\u0002J\b\u0010Z\u001a\u00020IH\u0002J\u0010\u0010[\u001a\u00020I2\u0006\u0010\\\u001a\u00020\u001eH\u0002J\b\u0010]\u001a\u00020IH\u0002J\"\u0010^\u001a\u00020I2\u0006\u0010_\u001a\u00020K2\u0006\u0010`\u001a\u00020K2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J$\u0010c\u001a\u00020V2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\b\u0010j\u001a\u00020IH\u0016J$\u0010k\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020I0OH\u0002J\b\u0010l\u001a\u00020IH\u0002J\b\u0010\u0019\u001a\u00020IH\u0002J\b\u0010m\u001a\u00020IH\u0002J\b\u0010n\u001a\u00020IH\u0002J\b\u0010o\u001a\u00020IH\u0002J\b\u0010p\u001a\u00020IH\u0002J\b\u0010q\u001a\u00020IH\u0002J\b\u0010r\u001a\u00020IH\u0002J\b\u0010s\u001a\u00020IH\u0002J\b\u0010t\u001a\u00020IH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R \u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020>0-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010 \"\u0004\bA\u0010\"R\u001b\u0010B\u001a\u00020C8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010E\u00a8\u0006u"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/search/RecruiterSearchFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "adapter", "Lcom/jobamax/appjobamax/recruiter/search/RecruiterSearchedJobCardStackAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/recruiter/search/RecruiterSearchedJobCardStackAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/recruiter/search/RecruiterSearchedJobCardStackAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterSearchBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterSearchBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterSearchBinding;)V", "cardStackLayoutManager", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "getCardStackLayoutManager", "()Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "setCardStackLayoutManager", "(Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;)V", "cardStackListener", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "getCardStackListener", "()Lcom/yuyakaido/android/cardstackview/CardStackListener;", "setCardStackListener", "(Lcom/yuyakaido/android/cardstackview/CardStackListener;)V", "companySubscription", "Lcom/jobamax/appjobamax/recruiter/model/CompanySubscription;", "currentSourcingId", "", "getCurrentSourcingId", "()Ljava/lang/String;", "setCurrentSourcingId", "(Ljava/lang/String;)V", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "rewindJobSeekerId", "getRewindJobSeekerId", "setRewindJobSeekerId", "sourcingCriteriaList", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/recruiter/model/SourcingCriteria;", "getSourcingCriteriaList", "()Ljava/util/ArrayList;", "setSourcingCriteriaList", "(Ljava/util/ArrayList;)V", "sourcingCriteriaListAddMoreObject", "sourcingCriteriaListTitleObject", "sourcingSeekerList", "Lcom/jobamax/appjobamax/recruiter/model/SourcingSeeker;", "spinnerAdapter", "Lcom/jobamax/appjobamax/recruiter/search/SourcingCriteriaSpinnerAdapter;", "getSpinnerAdapter", "()Lcom/jobamax/appjobamax/recruiter/search/SourcingCriteriaSpinnerAdapter;", "setSpinnerAdapter", "(Lcom/jobamax/appjobamax/recruiter/search/SourcingCriteriaSpinnerAdapter;)V", "swipedSourcingSeekerList", "Lcom/jobamax/appjobamax/recruiter/search/SwipedSourcingSeeker;", "topJobSeekerId", "getTopJobSeekerId", "setTopJobSeekerId", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "acceptOrUndoSourcing", "", "type", "", "jobOffer", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "isSuccess", "Lkotlin/Function1;", "", "addOrRemoveFromSeekerFolder", "seekerFolder", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "configureUi", "createChip", "Landroid/view/View;", "tag", "isGradient", "fetchCompanySubscription", "getSourcingCriteria", "getSourcingSeekers", "sourcingId", "initializeRecruiter", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "rejectOrUndoSourcing", "rewindSourcing", "setCardStackView", "setClickListeners", "setData", "setObserver", "setSourcingCriteriaSpinnerAdapter", "setSubscription", "updateJobCriteriaList", "updateJobVisibility", "app_debug"})
public final class RecruiterSearchFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterSearchBinding binding;
    public com.jobamax.appjobamax.recruiter.search.RecruiterSearchedJobCardStackAdapter adapter;
    public com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager;
    public com.yuyakaido.android.cardstackview.CardStackListener cardStackListener;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    private com.jobamax.appjobamax.recruiter.model.CompanySubscription companySubscription;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String topJobSeekerId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String rewindJobSeekerId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentSourcingId = "";
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SourcingSeeker> sourcingSeekerList = null;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.search.SwipedSourcingSeeker> swipedSourcingSeekerList = null;
    public com.jobamax.appjobamax.recruiter.search.SourcingCriteriaSpinnerAdapter spinnerAdapter;
    private final com.jobamax.appjobamax.recruiter.model.SourcingCriteria sourcingCriteriaListTitleObject = null;
    private final com.jobamax.appjobamax.recruiter.model.SourcingCriteria sourcingCriteriaListAddMoreObject = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SourcingCriteria> sourcingCriteriaList;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterSearchFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterSearchBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterSearchBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.search.RecruiterSearchedJobCardStackAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.search.RecruiterSearchedJobCardStackAdapter p0) {
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
    public final java.lang.String getCurrentSourcingId() {
        return null;
    }
    
    public final void setCurrentSourcingId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.search.SourcingCriteriaSpinnerAdapter getSpinnerAdapter() {
        return null;
    }
    
    public final void setSpinnerAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.search.SourcingCriteriaSpinnerAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SourcingCriteria> getSourcingCriteriaList() {
        return null;
    }
    
    public final void setSourcingCriteriaList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SourcingCriteria> p0) {
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void getSourcingSeekers(java.lang.String sourcingId) {
    }
    
    private final void setSourcingCriteriaSpinnerAdapter() {
    }
    
    private final void updateJobCriteriaList() {
    }
    
    private final void initializeRecruiter() {
    }
    
    private final void setData() {
    }
    
    private final void fetchCompanySubscription() {
    }
    
    private final void setObserver() {
    }
    
    private final void setSubscription() {
    }
    
    private final void getSourcingCriteria() {
    }
    
    private final void setCardStackView() {
    }
    
    private final android.view.View createChip(java.lang.String tag, boolean isGradient) {
        return null;
    }
    
    private final void setClickListeners() {
    }
    
    private final void updateJobVisibility() {
    }
    
    private final void setCardStackListener() {
    }
    
    private final void addOrRemoveFromSeekerFolder(int type, com.jobamax.appjobamax.recruiter.model.SeekerFolder seekerFolder, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isSuccess) {
    }
    
    private final void acceptOrUndoSourcing(int type, com.jobamax.appjobamax.recruiter.model.JobTitleFilter jobOffer, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isSuccess) {
    }
    
    private final void rejectOrUndoSourcing(int type, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isSuccess) {
    }
    
    private final void rewindSourcing() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}