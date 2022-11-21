package com.jobamax.appjobamax.jobseeker.profile.account.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&\u00a8\u0006\u0011"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/account/home/JobSeekerAccountInterface;", "", "onCommunityGuidelinesClicked", "", "onDeleteAccountClicked", "onEmailUsClicked", "onHelpAndSupportClicked", "onLogoutClicked", "onManageReadReceiptsClicked", "onNewsletterClicked", "onPasswordClicked", "onPersonalInformationClicked", "onPrivacyPolicyClicked", "onRestorePurchaseClicked", "onSafetyTipsClicked", "onShareJobamaxClicked", "onTermsOfServiceClicked", "app_debug"})
public abstract interface JobSeekerAccountInterface {
    
    public abstract void onPersonalInformationClicked();
    
    public abstract void onManageReadReceiptsClicked();
    
    public abstract void onNewsletterClicked();
    
    public abstract void onRestorePurchaseClicked();
    
    public abstract void onShareJobamaxClicked();
    
    public abstract void onHelpAndSupportClicked();
    
    public abstract void onEmailUsClicked();
    
    public abstract void onCommunityGuidelinesClicked();
    
    public abstract void onSafetyTipsClicked();
    
    public abstract void onPrivacyPolicyClicked();
    
    public abstract void onTermsOfServiceClicked();
    
    public abstract void onLogoutClicked();
    
    public abstract void onDeleteAccountClicked();
    
    public abstract void onPasswordClicked();
}