package com.findajob.jobamax.recruiter.profile.account.newsletter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/newsletter/RecruiterNewsletterInterface;", "", "onBackPress", "", "toggleNewsletterFlag", "flag", "", "app_debug"})
public abstract interface RecruiterNewsletterInterface {
    
    public abstract void toggleNewsletterFlag(boolean flag);
    
    public abstract void onBackPress();
}