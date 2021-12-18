package com.findajob.jobamax.recruiter.profile.account.personalInfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInfoIntroInterface;", "", "onBackClicked", "", "onDobClicked", "onGenderClicked", "view", "Landroid/view/View;", "onSkipped", "onSubmitClicked", "app_debug"})
public abstract interface RecruiterPersonalInfoIntroInterface {
    
    public abstract void onGenderClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void onDobClicked();
    
    public abstract void onSubmitClicked();
    
    public abstract void onSkipped();
    
    public abstract void onBackClicked();
}