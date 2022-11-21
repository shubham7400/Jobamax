package com.jobamax.appjobamax.recruiter.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.RelativeLayout;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.DialogWorkTypeBinding;
import com.jobamax.appjobamax.enums.WorkType;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R6\u0010\u0012\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0014j\b\u0012\u0004\u0012\u00020\u0006`\u0015\u0012\u0004\u0012\u00020\u00160\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/dialog/DialogWorkType2;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "workTypes", "", "", "(Landroid/app/Activity;Ljava/util/List;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "binding", "Lcom/jobamax/appjobamax/databinding/DialogWorkTypeBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/DialogWorkTypeBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/DialogWorkTypeBinding;)V", "onWorkClick", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "getOnWorkClick", "()Lkotlin/jvm/functions/Function1;", "setOnWorkClick", "(Lkotlin/jvm/functions/Function1;)V", "getWorkTypes", "()Ljava/util/List;", "dismiss", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpDialogView", "setUpObservers", "app_debug"})
public final class DialogWorkType2 extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> workTypes = null;
    public com.jobamax.appjobamax.databinding.DialogWorkTypeBinding binding;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.util.ArrayList<java.lang.String>, kotlin.Unit> onWorkClick;
    
    public DialogWorkType2(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> workTypes) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getActivity() {
        return null;
    }
    
    public final void setActivity(@org.jetbrains.annotations.NotNull()
    android.app.Activity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getWorkTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.DialogWorkTypeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.DialogWorkTypeBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.util.ArrayList<java.lang.String>, kotlin.Unit> getOnWorkClick() {
        return null;
    }
    
    public final void setOnWorkClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.ArrayList<java.lang.String>, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setUpObservers() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
    
    private final void setUpDialogView() {
    }
}