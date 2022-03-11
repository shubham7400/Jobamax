package com.findajob.jobamax.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/findajob/jobamax/util/CustomLiveData;", "T", "Landroidx/databinding/BaseObservable;", "Landroidx/lifecycle/MutableLiveData;", "()V", "callback", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "getCallback", "()Landroidx/databinding/Observable$OnPropertyChangedCallback;", "setCallback", "(Landroidx/databinding/Observable$OnPropertyChangedCallback;)V", "setValue", "", "value", "(Landroidx/databinding/BaseObservable;)V", "app_debug"})
public final class CustomLiveData<T extends androidx.databinding.BaseObservable> extends androidx.lifecycle.MutableLiveData<T> {
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.Observable.OnPropertyChangedCallback callback;
    
    public CustomLiveData() {
        super(null);
    }
    
    @java.lang.Override()
    public void setValue(@org.jetbrains.annotations.Nullable()
    T value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.Observable.OnPropertyChangedCallback getCallback() {
        return null;
    }
    
    public final void setCallback(@org.jetbrains.annotations.NotNull()
    androidx.databinding.Observable.OnPropertyChangedCallback p0) {
    }
}