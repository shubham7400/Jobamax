package com.jobamax.appjobamax.recruiter.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.DialogQualifyingStepBinding;
import com.jobamax.appjobamax.recruiter.message.QualifyingStepSpinnerAdapter;
import com.jobamax.appjobamax.recruiter.model.QualifyingStep;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\t\u00a2\u0006\u0002\u0010\nJ\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/dialog/QualifyingStepSpinnerAdapterV2;", "Landroid/widget/ArrayAdapter;", "Lcom/jobamax/appjobamax/recruiter/model/QualifyingStep;", "activity", "Landroid/app/Activity;", "id", "", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/app/Activity;ILjava/util/ArrayList;)V", "item", "", "getItem", "()Ljava/lang/String;", "setItem", "(Ljava/lang/String;)V", "getList", "()Ljava/util/ArrayList;", "onTitleClick", "Lkotlin/Function0;", "", "getOnTitleClick", "()Lkotlin/jvm/functions/Function0;", "setOnTitleClick", "(Lkotlin/jvm/functions/Function0;)V", "getDropDownView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "getView", "isEnabled", "", "app_debug"})
public final class QualifyingStepSpinnerAdapterV2 extends android.widget.ArrayAdapter<com.jobamax.appjobamax.recruiter.model.QualifyingStep> {
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.QualifyingStep> list = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onTitleClick;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String item = "";
    
    public QualifyingStepSpinnerAdapterV2(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int id, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.QualifyingStep> list) {
        super(null, 0);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.QualifyingStep> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnTitleClick() {
        return null;
    }
    
    public final void setOnTitleClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItem() {
        return null;
    }
    
    public final void setItem(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getDropDownView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isEnabled(int position) {
        return false;
    }
}