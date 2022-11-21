package com.jobamax.appjobamax.jobseeker.build_profile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.DatePickerDialogFragment;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBinding;
import com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.WorkType;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.network.ApiFetchCompaniesService;
import com.jobamax.appjobamax.repos.SearchQueryCompanyRepo;
import com.parse.ParseException;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0002J\b\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020:H\u0002J$\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020@H\u0002J\b\u0010I\u001a\u00020:H\u0002J\b\u0010J\u001a\u00020:H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0002048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106\u00a8\u0006K"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/AddNewExperienceFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "adapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SearchQueryCompanySuggestionAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/jobseeker/build_profile/SearchQueryCompanySuggestionAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/jobseeker/build_profile/SearchQueryCompanySuggestionAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentAddNewExperienceBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentAddNewExperienceBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentAddNewExperienceBinding;)V", "canFetchList", "", "getCanFetchList", "()Z", "setCanFetchList", "(Z)V", "experienceOld", "Lcom/jobamax/appjobamax/model/Experience;", "getExperienceOld", "()Lcom/jobamax/appjobamax/model/Experience;", "setExperienceOld", "(Lcom/jobamax/appjobamax/model/Experience;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "searchQueryCompanyRepo", "Lcom/jobamax/appjobamax/repos/SearchQueryCompanyRepo;", "getSearchQueryCompanyRepo", "()Lcom/jobamax/appjobamax/repos/SearchQueryCompanyRepo;", "setSearchQueryCompanyRepo", "(Lcom/jobamax/appjobamax/repos/SearchQueryCompanyRepo;)V", "selectedCompany", "Lcom/jobamax/appjobamax/model/SearchQueryCompany;", "getSelectedCompany", "()Lcom/jobamax/appjobamax/model/SearchQueryCompany;", "setSelectedCompany", "(Lcom/jobamax/appjobamax/model/SearchQueryCompany;)V", "selectedWorkType", "", "getSelectedWorkType", "()Ljava/lang/String;", "setSelectedWorkType", "(Ljava/lang/String;)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addExperience", "", "addOrUpdateExperience", "configureUi", "getCompanySuggestions", "initializeJobSeeker", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDateClicked", "view", "setAdapterFunctionality", "setClickListeners", "app_debug"})
public final class AddNewExperienceFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.repos.SearchQueryCompanyRepo searchQueryCompanyRepo;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.SearchQueryCompany selectedCompany;
    public com.jobamax.appjobamax.jobseeker.build_profile.SearchQueryCompanySuggestionAdapter adapter;
    private boolean canFetchList = true;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.Experience experienceOld;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedWorkType = "";
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    private java.util.HashMap _$_findViewCache;
    
    public AddNewExperienceFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.repos.SearchQueryCompanyRepo getSearchQueryCompanyRepo() {
        return null;
    }
    
    public final void setSearchQueryCompanyRepo(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.repos.SearchQueryCompanyRepo p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.SearchQueryCompany getSelectedCompany() {
        return null;
    }
    
    public final void setSelectedCompany(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.SearchQueryCompany p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.build_profile.SearchQueryCompanySuggestionAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.build_profile.SearchQueryCompanySuggestionAdapter p0) {
    }
    
    public final boolean getCanFetchList() {
        return false;
    }
    
    public final void setCanFetchList(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.Experience getExperienceOld() {
        return null;
    }
    
    public final void setExperienceOld(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.Experience p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedWorkType() {
        return null;
    }
    
    public final void setSelectedWorkType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.Nullable()
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
    
    private final void setAdapterFunctionality() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void getCompanySuggestions() {
    }
    
    private final void onDateClicked(android.view.View view) {
    }
    
    private final void addExperience() {
    }
    
    private final void addOrUpdateExperience() {
    }
}