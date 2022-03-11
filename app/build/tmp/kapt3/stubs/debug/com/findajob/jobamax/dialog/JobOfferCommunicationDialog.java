package com.findajob.jobamax.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\rJ\b\u0010 \u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/findajob/jobamax/dialog/JobOfferCommunicationDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "notificationHeader", "", "notificationBody", "focusButtonText", "nonfocusButtonText", "onFocusButtonClicked", "Lkotlin/Function0;", "", "onNonFocusButtonClicked", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "btnContact", "Landroid/widget/Button;", "getBtnContact", "()Landroid/widget/Button;", "setBtnContact", "(Landroid/widget/Button;)V", "tvNotificationBody", "Landroid/widget/TextView;", "getTvNotificationBody", "()Landroid/widget/TextView;", "setTvNotificationBody", "(Landroid/widget/TextView;)V", "tvNotificationHeader", "getTvNotificationHeader", "setTvNotificationHeader", "tvSkipButton", "getTvSkipButton", "setTvSkipButton", "initFields", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpObservers", "app_debug"})
public final class JobOfferCommunicationDialog extends android.app.Dialog {
    private final android.app.Activity activity = null;
    private final java.lang.String notificationHeader = null;
    private final java.lang.String notificationBody = null;
    private final java.lang.String focusButtonText = null;
    private final java.lang.String nonfocusButtonText = null;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onFocusButtonClicked = null;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onNonFocusButtonClicked = null;
    public android.widget.TextView tvNotificationHeader;
    public android.widget.TextView tvNotificationBody;
    public android.widget.Button btnContact;
    public android.widget.TextView tvSkipButton;
    
    public JobOfferCommunicationDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String notificationHeader, @org.jetbrains.annotations.NotNull()
    java.lang.String notificationBody, @org.jetbrains.annotations.NotNull()
    java.lang.String focusButtonText, @org.jetbrains.annotations.NotNull()
    java.lang.String nonfocusButtonText, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFocusButtonClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNonFocusButtonClicked) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvNotificationHeader() {
        return null;
    }
    
    public final void setTvNotificationHeader(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvNotificationBody() {
        return null;
    }
    
    public final void setTvNotificationBody(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnContact() {
        return null;
    }
    
    public final void setBtnContact(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvSkipButton() {
        return null;
    }
    
    public final void setTvSkipButton(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initFields() {
    }
    
    private final void setUpObservers() {
    }
    
    private final void initViews() {
    }
}