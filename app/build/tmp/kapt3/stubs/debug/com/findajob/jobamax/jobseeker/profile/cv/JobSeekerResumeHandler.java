package com.findajob.jobamax.jobseeker.profile.cv;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/cv/JobSeekerResumeHandler;", "", "onAddActivityClicked", "", "onAddEducationClicked", "onAddExperienceClicked", "onAddSkillsClicked", "onBackButtonClicked", "app_debug"})
public abstract interface JobSeekerResumeHandler {
    
    public abstract void onAddExperienceClicked();
    
    public abstract void onAddEducationClicked();
    
    public abstract void onAddSkillsClicked();
    
    public abstract void onAddActivityClicked();
    
    public abstract void onBackButtonClicked();
}