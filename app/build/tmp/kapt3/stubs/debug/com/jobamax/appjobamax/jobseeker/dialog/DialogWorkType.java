package com.jobamax.appjobamax.jobseeker.dialog;

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
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR6\u0010\u000e\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u0012\u0004\u0012\u00020\u00130\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/dialog/DialogWorkType;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "binding", "Lcom/jobamax/appjobamax/databinding/DialogWorkTypeBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/DialogWorkTypeBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/DialogWorkTypeBinding;)V", "onWorkClick", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "", "getOnWorkClick", "()Lkotlin/jvm/functions/Function1;", "setOnWorkClick", "(Lkotlin/jvm/functions/Function1;)V", "dismiss", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpDialogView", "setUpObservers", "app_debug"})
public final class DialogWorkType extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    public com.jobamax.appjobamax.databinding.DialogWorkTypeBinding binding;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.util.ArrayList<java.lang.String>, kotlin.Unit> onWorkClick;
    
    public DialogWorkType(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
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