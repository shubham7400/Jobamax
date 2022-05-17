package com.jobamax.appjobamax.jobseeker.profile.account.personalInfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalInformationInterface;", "", "onBackPress", "", "onDobClicked", "onGenderClicked", "view", "Landroid/view/View;", "onSubmitClicked", "app_release"})
public abstract interface JobSeekerPersonalInformationInterface {
    
    public abstract void onGenderClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void onSubmitClicked();
    
    public abstract void onDobClicked();
    
    public abstract void onBackPress();
}