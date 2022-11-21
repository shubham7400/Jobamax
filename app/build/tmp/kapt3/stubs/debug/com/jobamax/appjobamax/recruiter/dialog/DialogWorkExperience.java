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
import com.jobamax.appjobamax.databinding.DialogWorkExperienceBinding;
import com.jobamax.appjobamax.enums.WorkType;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/jobamax/appjobamax/recruiter/dialog/DialogWorkExperience;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "selectedWorkExperience", "", "(Landroid/app/Activity;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "binding", "Lcom/jobamax/appjobamax/databinding/DialogWorkExperienceBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/DialogWorkExperienceBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/DialogWorkExperienceBinding;)V", "onExperienceClick", "Lkotlin/Function1;", "", "getOnExperienceClick", "()Lkotlin/jvm/functions/Function1;", "setOnExperienceClick", "(Lkotlin/jvm/functions/Function1;)V", "getSelectedWorkExperience", "()Ljava/lang/String;", "setSelectedWorkExperience", "(Ljava/lang/String;)V", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpDialogView", "setUpObservers", "app_debug"})
public final class DialogWorkExperience extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedWorkExperience;
    public com.jobamax.appjobamax.databinding.DialogWorkExperienceBinding binding;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onExperienceClick;
    
    public DialogWorkExperience(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedWorkExperience) {
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
    public final java.lang.String getSelectedWorkExperience() {
        return null;
    }
    
    public final void setSelectedWorkExperience(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.DialogWorkExperienceBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.DialogWorkExperienceBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnExperienceClick() {
        return null;
    }
    
    public final void setOnExperienceClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setUpObservers() {
    }
    
    private final void setUpDialogView() {
    }
}