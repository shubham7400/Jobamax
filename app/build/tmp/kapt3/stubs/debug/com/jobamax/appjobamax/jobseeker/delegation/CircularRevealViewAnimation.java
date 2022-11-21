package com.jobamax.appjobamax.jobseeker.delegation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewAnimationUtils;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/delegation/CircularRevealViewAnimation;", "", "hideViewAnimationFromLeft", "", "view", "Landroid/view/View;", "hideViewAnimationFromRight", "showViewAnimationFromLeft", "showViewAnimationFromRight", "app_debug"})
public abstract interface CircularRevealViewAnimation {
    
    public abstract void showViewAnimationFromLeft(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void hideViewAnimationFromLeft(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void showViewAnimationFromRight(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void hideViewAnimationFromRight(@org.jetbrains.annotations.NotNull()
    android.view.View view);
}