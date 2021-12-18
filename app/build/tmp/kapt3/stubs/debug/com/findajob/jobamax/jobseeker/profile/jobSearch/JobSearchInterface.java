package com.findajob.jobamax.jobseeker.profile.jobSearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchInterface;", "", "onBackButtonClicked", "", "onLocationClicked", "onResetClicked", "onSubmitButtonClicked", "onTemporaryPermanentClicked", "view", "Landroid/view/View;", "app_debug"})
public abstract interface JobSearchInterface {
    
    public abstract void onBackButtonClicked();
    
    public abstract void onLocationClicked();
    
    public abstract void onTemporaryPermanentClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void onSubmitButtonClicked();
    
    public abstract void onResetClicked();
}