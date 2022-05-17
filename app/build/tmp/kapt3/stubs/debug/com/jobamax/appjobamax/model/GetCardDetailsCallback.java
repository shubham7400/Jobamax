package com.jobamax.appjobamax.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&J\u001e\u0010\u0007\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/jobamax/appjobamax/model/GetCardDetailsCallback;", "", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "map", "Ljava/util/HashMap;", "", "app_debug"})
public abstract interface GetCardDetailsCallback {
    
    public abstract void onSuccess(@org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.Object> map);
    
    public abstract void onFailure(@org.jetbrains.annotations.Nullable()
    java.lang.Exception e);
}