package com.findajob.jobamax.jobseeker.profile.cv.education;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/cv/education/CreateEducationHandler;", "", "onAddEducationClicked", "", "onBackButtonClicked", "onDateClicked", "view", "Landroid/view/View;", "flag", "", "app_debug"})
public abstract interface CreateEducationHandler {
    
    public abstract void onAddEducationClicked();
    
    public abstract void onDateClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view, int flag);
    
    public abstract void onBackButtonClicked();
}