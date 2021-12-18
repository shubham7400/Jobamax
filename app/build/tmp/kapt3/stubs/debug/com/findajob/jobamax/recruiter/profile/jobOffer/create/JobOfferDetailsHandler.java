package com.findajob.jobamax.recruiter.profile.jobOffer.create;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/JobOfferDetailsHandler;", "", "onAddKeySkillsClicked", "", "onBackButtonClicked", "onHideJobClicked", "onKeySkillsClicked", "onLevelOfHierarchyClicked", "view", "Landroid/view/View;", "onLocationClicked", "onSubmitButtonClicked", "app_debug"})
public abstract interface JobOfferDetailsHandler {
    
    public abstract void onBackButtonClicked();
    
    public abstract void onLocationClicked();
    
    public abstract void onLevelOfHierarchyClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void onSubmitButtonClicked();
    
    public abstract void onAddKeySkillsClicked();
    
    public abstract void onKeySkillsClicked();
    
    public abstract void onHideJobClicked();
}