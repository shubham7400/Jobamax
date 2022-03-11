package com.findajob.jobamax.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-H\u0003J\b\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\rH\u0002J\u0012\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00067"}, d2 = {"Lcom/findajob/jobamax/dialog/AddEventDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "providedOrganiser", "Lcom/parse/ParseObject;", "selectedRoom", "getEvent", "Lkotlin/Function1;", "Lcom/findajob/jobamax/model/Event;", "Lkotlin/ParameterName;", "name", "event", "", "(Landroid/app/Activity;Lcom/parse/ParseObject;Lcom/parse/ParseObject;Lkotlin/jvm/functions/Function1;)V", "btnSave", "Landroid/widget/Button;", "getBtnSave", "()Landroid/widget/Button;", "setBtnSave", "(Landroid/widget/Button;)V", "dpDate", "Landroid/widget/DatePicker;", "getDpDate", "()Landroid/widget/DatePicker;", "setDpDate", "(Landroid/widget/DatePicker;)V", "etName", "Landroid/widget/EditText;", "getEtName", "()Landroid/widget/EditText;", "setEtName", "(Landroid/widget/EditText;)V", "isNameGotten", "", "()Z", "setNameGotten", "(Z)V", "tvSkipButton", "Landroid/widget/TextView;", "getTvSkipButton", "()Landroid/widget/TextView;", "setTvSkipButton", "(Landroid/widget/TextView;)V", "getDateAndDay", "Lkotlin/Pair;", "Ljava/util/Date;", "", "hideKeyboard", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpObservers", "toggleButtonName", "app_debug"})
public final class AddEventDialog extends android.app.Dialog {
    private final android.app.Activity activity = null;
    private final com.parse.ParseObject providedOrganiser = null;
    private final com.parse.ParseObject selectedRoom = null;
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.model.Event, kotlin.Unit> getEvent;
    public android.widget.EditText etName;
    public android.widget.DatePicker dpDate;
    public android.widget.Button btnSave;
    public android.widget.TextView tvSkipButton;
    private boolean isNameGotten = false;
    
    public AddEventDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.parse.ParseObject providedOrganiser, @org.jetbrains.annotations.Nullable()
    com.parse.ParseObject selectedRoom, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.model.Event, kotlin.Unit> getEvent) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEtName() {
        return null;
    }
    
    public final void setEtName(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.DatePicker getDpDate() {
        return null;
    }
    
    public final void setDpDate(@org.jetbrains.annotations.NotNull()
    android.widget.DatePicker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnSave() {
        return null;
    }
    
    public final void setBtnSave(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvSkipButton() {
        return null;
    }
    
    public final void setTvSkipButton(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    public final boolean isNameGotten() {
        return false;
    }
    
    public final void setNameGotten(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setUpObservers() {
    }
    
    private final void toggleButtonName() {
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private final kotlin.Pair<java.util.Date, java.lang.String> getDateAndDay() {
        return null;
    }
    
    private final void hideKeyboard() {
    }
}