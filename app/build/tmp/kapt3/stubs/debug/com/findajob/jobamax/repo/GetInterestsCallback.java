package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/repo/GetInterestsCallback;", "", "onFinish", "", "interests", "", "Lcom/parse/ParseObject;", "app_debug"})
public abstract interface GetInterestsCallback {
    
    public abstract void onFinish(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> interests);
}