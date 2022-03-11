package com.findajob.jobamax.jobseeker.source;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0002J\b\u0010%\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\"\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020)H\u0016J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0016J\b\u00109\u001a\u00020)H\u0016J\b\u0010:\u001a\u00020)H\u0016J\u0012\u0010;\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020)H\u0002J\b\u0010?\u001a\u00020)H\u0002J\b\u0010@\u001a\u00020)H\u0016J\b\u0010A\u001a\u00020)H\u0016J\b\u0010B\u001a\u00020)H\u0002J\b\u0010C\u001a\u00020)H\u0002J\b\u0010D\u001a\u00020)H\u0002R+\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR+\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR+\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020 0\u0006j\b\u0012\u0004\u0012\u00020 `\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b!\u0010\nR\u001b\u0010#\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010\f\u001a\u0004\b%\u0010&\u00a8\u0006E"}, d2 = {"Lcom/findajob/jobamax/jobseeker/source/JobSourceFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentJobSourceBinding;", "Lcom/findajob/jobamax/jobseeker/source/JobSourceInterface;", "()V", "choiceDuration", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/dialog/multiChoice/Choice;", "Lkotlin/collections/ArrayList;", "getChoiceDuration", "()Ljava/util/ArrayList;", "choiceDuration$delegate", "Lkotlin/Lazy;", "choiceEmployment", "getChoiceEmployment", "choiceEmployment$delegate", "jobSourceState", "Lcom/findajob/jobamax/model/JobSource;", "getJobSourceState", "()Lcom/findajob/jobamax/model/JobSource;", "setJobSourceState", "(Lcom/findajob/jobamax/model/JobSource;)V", "layoutRes", "", "getLayoutRes", "()I", "multiChoiceDialog", "Lcom/findajob/jobamax/dialog/multiChoice/MultiChoiceDialog;", "getMultiChoiceDialog", "()Lcom/findajob/jobamax/dialog/multiChoice/MultiChoiceDialog;", "multiChoiceDialog$delegate", "typeOfWorkSelected", "", "getTypeOfWorkSelected", "typeOfWorkSelected$delegate", "viewModel", "Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "viewModel$delegate", "configureViewModel", "", "Landroidx/lifecycle/ViewModel;", "initDuration", "initEmployment", "initFields", "initTypeOfWorkFields", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddEducationClicked", "onAddExperienceClicked", "onAddKeySkillClicked", "onAddLocationClicked", "onBackButtonClicked", "onCityClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onDurationField", "onEmploymentField", "onResetClicked", "onSubmitButtonClicked", "refreshEducationChips", "refreshExpChips", "refreshKeySkillsChips", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobSourceFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentJobSourceBinding> implements com.findajob.jobamax.jobseeker.source.JobSourceInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.model.JobSource jobSourceState;
    private final kotlin.Lazy choiceEmployment$delegate = null;
    private final kotlin.Lazy choiceDuration$delegate = null;
    private final kotlin.Lazy typeOfWorkSelected$delegate = null;
    private final kotlin.Lazy multiChoiceDialog$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public JobSourceFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobSource getJobSourceState() {
        return null;
    }
    
    public final void setJobSourceState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSource p0) {
    }
    
    private final java.util.ArrayList<com.findajob.jobamax.dialog.multiChoice.Choice> getChoiceEmployment() {
        return null;
    }
    
    private final java.util.ArrayList<com.findajob.jobamax.dialog.multiChoice.Choice> getChoiceDuration() {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> getTypeOfWorkSelected() {
        return null;
    }
    
    private final com.findajob.jobamax.dialog.multiChoice.MultiChoiceDialog getMultiChoiceDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void configureViewModel() {
    }
    
    private final void initViews() {
    }
    
    private final void initTypeOfWorkFields() {
    }
    
    private final void initDuration() {
    }
    
    private final void initEmployment() {
    }
    
    private final void onEmploymentField() {
    }
    
    private final void onDurationField() {
    }
    
    @java.lang.Override()
    public void onAddLocationClicked() {
    }
    
    private final void initFields() {
    }
    
    @java.lang.Override()
    public void onAddExperienceClicked() {
    }
    
    private final void refreshExpChips() {
    }
    
    @java.lang.Override()
    public void onAddEducationClicked() {
    }
    
    private final void refreshEducationChips() {
    }
    
    @java.lang.Override()
    public void onAddKeySkillClicked() {
    }
    
    private final void refreshKeySkillsChips() {
    }
    
    @java.lang.Override()
    public void onSubmitButtonClicked() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onResetClicked() {
    }
    
    @java.lang.Override()
    public void onCityClicked() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
}