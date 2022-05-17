package com.jobamax.appjobamax.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/jobamax/appjobamax/login/RegisterInterface;", "", "onEyeClicked", "", "eyeType", "", "onLoginClicked", "onRegisterClicked", "app_debug"})
public abstract interface RegisterInterface {
    
    public abstract void onLoginClicked();
    
    public abstract void onRegisterClicked();
    
    public abstract void onEyeClicked(int eyeType);
}