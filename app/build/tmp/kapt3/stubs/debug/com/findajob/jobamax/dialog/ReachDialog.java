package com.findajob.jobamax.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001$B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001e\u001a\u00020\fH\u0002J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\fH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/findajob/jobamax/dialog/ReachDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "companyName", "", "onButtonClicked", "Lkotlin/Function1;", "Lcom/findajob/jobamax/dialog/ReachDialog$SubmitButton;", "Lkotlin/ParameterName;", "name", "button", "", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "btnNegative", "Landroid/widget/Button;", "btnPositive", "getCompanyName", "()Ljava/lang/String;", "setCompanyName", "(Ljava/lang/String;)V", "getOnButtonClicked", "()Lkotlin/jvm/functions/Function1;", "tvBody", "Landroid/widget/TextView;", "tvNotificationBody", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpDialogView", "setUpObservers", "SubmitButton", "app_debug"})
public final class ReachDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String companyName;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.findajob.jobamax.dialog.ReachDialog.SubmitButton, kotlin.Unit> onButtonClicked = null;
    private android.widget.TextView tvNotificationBody;
    private android.widget.TextView tvBody;
    private android.widget.Button btnPositive;
    private android.widget.Button btnNegative;
    
    public ReachDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String companyName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.dialog.ReachDialog.SubmitButton, kotlin.Unit> onButtonClicked) {
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
    public final java.lang.String getCompanyName() {
        return null;
    }
    
    public final void setCompanyName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.dialog.ReachDialog.SubmitButton, kotlin.Unit> getOnButtonClicked() {
        return null;
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
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dialog/ReachDialog$SubmitButton;", "", "(Ljava/lang/String;I)V", "POSITIVE", "NEGATIVE", "app_debug"})
    public static enum SubmitButton {
        /*public static final*/ POSITIVE /* = new POSITIVE() */,
        /*public static final*/ NEGATIVE /* = new NEGATIVE() */;
        
        SubmitButton() {
        }
    }
}