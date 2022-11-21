package com.jobamax.appjobamax.jobseeker.build_profile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jobamax.appjobamax.DatePickerDialogFragment;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentAddNewEducationBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.Education;
import com.jobamax.appjobamax.model.EducationGroup;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.University;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.lang.Exception;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\"\u0010,\u001a\u00020*2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/\u0012\u0004\u0012\u00020*0.H\u0002J\b\u00101\u001a\u00020*H\u0002J$\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u000203H\u0002J\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020*H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010(\u001a\u0004\b%\u0010&\u00a8\u0006?"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/AddNewEducationFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "adapter", "Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentAddNewEducationBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentAddNewEducationBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentAddNewEducationBinding;)V", "canFetchList", "", "getCanFetchList", "()Z", "setCanFetchList", "(Z)V", "educationOld", "Lcom/jobamax/appjobamax/model/Education;", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "university", "Lcom/jobamax/appjobamax/model/University;", "getUniversity", "()Lcom/jobamax/appjobamax/model/University;", "setUniversity", "(Lcom/jobamax/appjobamax/model/University;)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addOrUpdateEducation", "", "configureUi", "getUniversities", "result", "Lkotlin/Function1;", "", "Lcom/parse/ParseObject;", "initializeJobSeeker", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDateClicked", "view", "saveEducation", "setAdapterFunctionality", "setClickListeners", "app_debug"})
public final class AddNewEducationFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentAddNewEducationBinding binding;
    private com.jobamax.appjobamax.model.Education educationOld;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.University university;
    private boolean canFetchList = true;
    public com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter adapter;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public AddNewEducationFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentAddNewEducationBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentAddNewEducationBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.University getUniversity() {
        return null;
    }
    
    public final void setUniversity(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.University p0) {
    }
    
    public final boolean getCanFetchList() {
        return false;
    }
    
    public final void setCanFetchList(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.JobSeeker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
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
    
    private final void setClickListeners() {
    }
    
    private final void setAdapterFunctionality() {
    }
    
    private final void getUniversities(kotlin.jvm.functions.Function1<? super java.util.List<? extends com.parse.ParseObject>, kotlin.Unit> result) {
    }
    
    private final void saveEducation() {
    }
    
    private final void addOrUpdateEducation() {
    }
    
    private final void onDateClicked(android.view.View view) {
    }
}