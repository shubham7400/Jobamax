package com.findajob.jobamax.recruiter.profile.jobOffer.create;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/CreateJobOfferInterface;", "", "onAddKeySkillsClicked", "", "onBackButtonClicked", "onCityClicked", "onDeleteClicked", "onKeySkillsClicked", "onLevelOfHierarchyClicked", "view", "Landroid/view/View;", "onLocationClicked", "onSubmitButtonClicked", "onUploadJobPresentationClicked", "app_debug"})
public abstract interface CreateJobOfferInterface {
    
    public abstract void onBackButtonClicked();
    
    public abstract void onLocationClicked();
    
    public abstract void onUploadJobPresentationClicked();
    
    public abstract void onLevelOfHierarchyClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void onSubmitButtonClicked();
    
    public abstract void onAddKeySkillsClicked();
    
    public abstract void onKeySkillsClicked();
    
    public abstract void onCityClicked();
    
    public abstract void onDeleteClicked();
}