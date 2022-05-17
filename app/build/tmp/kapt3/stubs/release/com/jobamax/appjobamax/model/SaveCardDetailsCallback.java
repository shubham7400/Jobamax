package com.jobamax.appjobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\t"}, d2 = {"Lcom/jobamax/appjobamax/model/SaveCardDetailsCallback;", "", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "response", "app_release"})
public abstract interface SaveCardDetailsCallback {
    
    public abstract void onSuccess(@org.jetbrains.annotations.Nullable()
    java.lang.Object response);
    
    public abstract void onFailure(@org.jetbrains.annotations.Nullable()
    java.lang.Exception e);
}