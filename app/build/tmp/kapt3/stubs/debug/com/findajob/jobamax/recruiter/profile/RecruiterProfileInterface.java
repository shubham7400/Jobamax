package com.findajob.jobamax.recruiter.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/RecruiterProfileInterface;", "", "onAccountClicked", "", "onCompanyClick", "onGetJombaxAnalytics", "onJobOfferClicked", "onMediaClicked", "onProfilePictureClicked", "onSponsorshipClicked", "onSubscriptionClicked", "onUpgradeClicked", "app_debug"})
public abstract interface RecruiterProfileInterface {
    
    public abstract void onAccountClicked();
    
    public abstract void onJobOfferClicked();
    
    public abstract void onMediaClicked();
    
    public abstract void onSubscriptionClicked();
    
    public abstract void onSponsorshipClicked();
    
    public abstract void onProfilePictureClicked();
    
    public abstract void onCompanyClick();
    
    public abstract void onGetJombaxAnalytics();
    
    public abstract void onUpgradeClicked();
}