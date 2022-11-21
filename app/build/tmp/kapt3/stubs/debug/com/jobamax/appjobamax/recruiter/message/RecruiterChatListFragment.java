package com.jobamax.appjobamax.recruiter.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBinding;
import com.jobamax.appjobamax.databinding.ItemRecruiterChatListBinding;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.model.University;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.DialogSeekerFolder;
import com.jobamax.appjobamax.recruiter.dialog.FilterJobRoleWiseDialog;
import com.jobamax.appjobamax.recruiter.dialog.QualifyingStepDialog;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.QualifyingStep;
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\u001a\u00109\u001a\u0002072\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020\u000fH\u0002J\u001c\u0010=\u001a\u0002072\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002070?H\u0002J\b\u0010@\u001a\u000207H\u0002J\u0010\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020CH\u0002J$\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u000207H\u0016J\b\u0010M\u001a\u000207H\u0002J\b\u0010N\u001a\u000207H\u0002J\u0012\u0010O\u001a\u0002072\b\b\u0002\u0010<\u001a\u00020\u000fH\u0002J\b\u0010\'\u001a\u000207H\u0002J\b\u0010P\u001a\u000207H\u0002J\b\u0010Q\u001a\u000207H\u0002J\u0010\u0010R\u001a\u0002072\u0006\u0010S\u001a\u00020*H\u0002J\u001a\u0010T\u001a\u0002072\b\u0010S\u001a\u0004\u0018\u00010*2\u0006\u0010U\u001a\u00020\u001cH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u0010\rR\u001b\u00100\u001a\u0002018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103\u00a8\u0006V"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterChatListFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterChatListBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterChatListBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterChatListBinding;)V", "isSelectedAllForSorting", "", "()Z", "setSelectedAllForSorting", "(Z)V", "qualifyingStepSelectionType", "", "getQualifyingStepSelectionType", "()I", "setQualifyingStepSelectionType", "(I)V", "qualifyingStepSpinnerAdapter", "Lcom/jobamax/appjobamax/recruiter/message/QualifyingStepSpinnerAdapter;", "getQualifyingStepSpinnerAdapter", "()Lcom/jobamax/appjobamax/recruiter/message/QualifyingStepSpinnerAdapter;", "setQualifyingStepSpinnerAdapter", "(Lcom/jobamax/appjobamax/recruiter/message/QualifyingStepSpinnerAdapter;)V", "qualifyingSteps", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/recruiter/model/QualifyingStep;", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "recruitmentSeekerChatListAdapter", "Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerChatListAdapter;", "getRecruitmentSeekerChatListAdapter", "()Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerChatListAdapter;", "setRecruitmentSeekerChatListAdapter", "(Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerChatListAdapter;)V", "selectedRecruitmentSeekerList", "Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;", "selectedRefusedRecruitmentSeekerList", "selectionList", "showSelectJobOfferDialog", "getShowSelectJobOfferDialog", "setShowSelectJobOfferDialog", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "getJobTitleFilterList", "getRecruitmentSeekers", "jobOfferId", "", "selectionType", "getSelectionCount", "onSuccess", "Lkotlin/Function1;", "initializeRecruiter", "moveRecruitmentSeekerToFolder", "seekerFolder", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setClickListeners", "setData", "setQualifyingStepAdapter", "setViewModelObserver", "updateJobTitle", "updateRating", "rs", "updateSortList", "qs", "app_debug"})
public final class RecruiterChatListFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    public com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerChatListAdapter recruitmentSeekerChatListAdapter;
    public com.jobamax.appjobamax.recruiter.message.QualifyingStepSpinnerAdapter qualifyingStepSpinnerAdapter;
    private int qualifyingStepSelectionType = 0;
    private boolean showSelectJobOfferDialog = true;
    private final java.util.ArrayList<java.lang.Integer> selectionList = null;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.QualifyingStep> qualifyingSteps = null;
    private boolean isSelectedAllForSorting = false;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> selectedRecruitmentSeekerList = null;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> selectedRefusedRecruitmentSeekerList = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterChatListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBinding p0) {
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
    public final com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerChatListAdapter getRecruitmentSeekerChatListAdapter() {
        return null;
    }
    
    public final void setRecruitmentSeekerChatListAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerChatListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.message.QualifyingStepSpinnerAdapter getQualifyingStepSpinnerAdapter() {
        return null;
    }
    
    public final void setQualifyingStepSpinnerAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.message.QualifyingStepSpinnerAdapter p0) {
    }
    
    public final int getQualifyingStepSelectionType() {
        return 0;
    }
    
    public final void setQualifyingStepSelectionType(int p0) {
    }
    
    public final boolean getShowSelectJobOfferDialog() {
        return false;
    }
    
    public final void setShowSelectJobOfferDialog(boolean p0) {
    }
    
    public final boolean isSelectedAllForSorting() {
        return false;
    }
    
    public final void setSelectedAllForSorting(boolean p0) {
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
    
    private final void setViewModelObserver() {
    }
    
    private final void initializeRecruiter() {
    }
    
    private final void setData() {
    }
    
    private final void getJobTitleFilterList() {
    }
    
    private final void getRecruitmentSeekers(java.lang.String jobOfferId, int selectionType) {
    }
    
    private final void setQualifyingStepAdapter(int selectionType) {
    }
    
    private final void setRecruitmentSeekerChatListAdapter() {
    }
    
    private final void updateRating(com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker rs) {
    }
    
    private final void updateSortList(com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker rs, com.jobamax.appjobamax.recruiter.model.QualifyingStep qs) {
    }
    
    private final void setClickListeners() {
    }
    
    private final void moveRecruitmentSeekerToFolder(com.jobamax.appjobamax.recruiter.model.SeekerFolder seekerFolder) {
    }
    
    private final void getSelectionCount(kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onSuccess) {
    }
    
    private final void updateJobTitle() {
    }
}