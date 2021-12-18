package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatHandler;", "", "launchCamera", "", "onBackPress", "onCallButtonPressed", "onRequirementsButtonPressed", "onSendMessage", "onVideoCallButtonPressed", "app_debug"})
public abstract interface ChatHandler {
    
    public abstract void onSendMessage();
    
    public abstract void onBackPress();
    
    public abstract void onCallButtonPressed();
    
    public abstract void onVideoCallButtonPressed();
    
    public abstract void onRequirementsButtonPressed();
    
    public abstract void launchCamera();
}