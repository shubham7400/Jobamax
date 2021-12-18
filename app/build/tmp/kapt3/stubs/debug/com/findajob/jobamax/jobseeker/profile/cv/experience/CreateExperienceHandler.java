package com.findajob.jobamax.jobseeker.profile.cv.experience;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/cv/experience/CreateExperienceHandler;", "", "onBackButtonClicked", "", "onDateClicked", "view", "Landroid/view/View;", "flag", "", "onLocationClicked", "onSaveButtonClicked", "app_debug"})
public abstract interface CreateExperienceHandler {
    
    public abstract void onSaveButtonClicked();
    
    public abstract void onDateClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view, int flag);
    
    public abstract void onBackButtonClicked();
    
    public abstract void onLocationClicked();
}