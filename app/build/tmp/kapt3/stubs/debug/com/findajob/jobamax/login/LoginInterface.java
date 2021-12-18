package com.findajob.jobamax.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/findajob/jobamax/login/LoginInterface;", "", "onEmailLoginClicked", "", "onEyeClicked", "onFacebookLoginClicked", "onForgotPasswordClicked", "onGoogleLoginClicked", "onLinkedInLoginClicked", "onRegisterClicked", "app_debug"})
public abstract interface LoginInterface {
    
    public abstract void onFacebookLoginClicked();
    
    public abstract void onGoogleLoginClicked();
    
    public abstract void onLinkedInLoginClicked();
    
    public abstract void onEmailLoginClicked();
    
    public abstract void onRegisterClicked();
    
    public abstract void onForgotPasswordClicked();
    
    public abstract void onEyeClicked();
}