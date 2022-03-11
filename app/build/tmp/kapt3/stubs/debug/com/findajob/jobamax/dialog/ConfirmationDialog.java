package com.findajob.jobamax.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001+BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0002\u0010\u0011J\b\u0010%\u001a\u00020\u0010H\u0002J\u0012\u0010&\u001a\u00020\u00102\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R,\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/findajob/jobamax/dialog/ConfirmationDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "bodyText", "", "positiveButtonText", "negativeButtonText", "isNegativeButtonUnfocused", "", "onButtonClicked", "Lkotlin/Function1;", "Lcom/findajob/jobamax/dialog/ConfirmationDialog$CallConfirmationButton;", "Lkotlin/ParameterName;", "name", "button", "", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getBodyText", "()Ljava/lang/String;", "setBodyText", "(Ljava/lang/String;)V", "btnNegative", "Landroid/widget/Button;", "btnPositive", "getNegativeButtonText", "setNegativeButtonText", "getOnButtonClicked", "()Lkotlin/jvm/functions/Function1;", "getPositiveButtonText", "setPositiveButtonText", "tvNotificationBody", "Landroid/widget/TextView;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpDialogView", "setUpObservers", "CallConfirmationButton", "app_debug"})
public final class ConfirmationDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String bodyText;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String positiveButtonText;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String negativeButtonText;
    private final boolean isNegativeButtonUnfocused = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.findajob.jobamax.dialog.ConfirmationDialog.CallConfirmationButton, kotlin.Unit> onButtonClicked = null;
    private android.widget.TextView tvNotificationBody;
    private android.widget.Button btnPositive;
    private android.widget.Button btnNegative;
    
    public ConfirmationDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String bodyText, @org.jetbrains.annotations.NotNull()
    java.lang.String positiveButtonText, @org.jetbrains.annotations.NotNull()
    java.lang.String negativeButtonText, boolean isNegativeButtonUnfocused, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.dialog.ConfirmationDialog.CallConfirmationButton, kotlin.Unit> onButtonClicked) {
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
    public final java.lang.String getBodyText() {
        return null;
    }
    
    public final void setBodyText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositiveButtonText() {
        return null;
    }
    
    public final void setPositiveButtonText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNegativeButtonText() {
        return null;
    }
    
    public final void setNegativeButtonText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.dialog.ConfirmationDialog.CallConfirmationButton, kotlin.Unit> getOnButtonClicked() {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dialog/ConfirmationDialog$CallConfirmationButton;", "", "(Ljava/lang/String;I)V", "POSITIVE", "NEGATIVE", "app_debug"})
    public static enum CallConfirmationButton {
        /*public static final*/ POSITIVE /* = new POSITIVE() */,
        /*public static final*/ NEGATIVE /* = new NEGATIVE() */;
        
        CallConfirmationButton() {
        }
    }
}