package com.findajob.jobamax.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/findajob/jobamax/util/AutoUpdatableAdapter;", "", "autoNotify", "", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "old", "", "new", "compare", "Lkotlin/Function2;", "", "app_debug"})
public abstract interface AutoUpdatableAdapter {
    
    public abstract <T extends java.lang.Object>void autoNotify(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> $this$autoNotify, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> old, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> p2_54480, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Boolean> compare);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        public static <T extends java.lang.Object>void autoNotify(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.util.AutoUpdatableAdapter $this, @org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.Adapter<?> $this$autoNotify, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends T> old, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends T> p3_54480, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Boolean> compare) {
        }
    }
}