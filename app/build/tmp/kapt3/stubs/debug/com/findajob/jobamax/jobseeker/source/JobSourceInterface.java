package com.findajob.jobamax.jobseeker.source;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/findajob/jobamax/jobseeker/source/JobSourceInterface;", "", "onAddEducationClicked", "", "onAddExperienceClicked", "onAddKeySkillClicked", "onAddLocationClicked", "onBackButtonClicked", "onCityClicked", "onResetClicked", "onSubmitButtonClicked", "app_debug"})
public abstract interface JobSourceInterface {
    
    public abstract void onAddLocationClicked();
    
    public abstract void onAddExperienceClicked();
    
    public abstract void onAddEducationClicked();
    
    public abstract void onAddKeySkillClicked();
    
    public abstract void onCityClicked();
    
    public abstract void onSubmitButtonClicked();
    
    public abstract void onBackButtonClicked();
    
    public abstract void onResetClicked();
}