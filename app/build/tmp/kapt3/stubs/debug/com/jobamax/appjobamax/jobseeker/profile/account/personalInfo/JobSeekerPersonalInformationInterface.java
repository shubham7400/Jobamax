package com.jobamax.appjobamax.jobseeker.profile.account.personalInfo;

import android.view.View;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalInformationInterface;", "", "onBackPress", "", "onGenderClicked", "view", "Landroid/view/View;", "onSubmitClicked", "app_debug"})
public abstract interface JobSeekerPersonalInformationInterface {
    
    public abstract void onGenderClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void onSubmitClicked();
    
    public abstract void onBackPress();
}