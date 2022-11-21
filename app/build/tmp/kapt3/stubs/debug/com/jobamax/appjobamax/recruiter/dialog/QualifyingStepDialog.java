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

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001f\u001a\u00020\nH\u0002J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/dialog/QualifyingStepDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "qualifyingSteps", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/recruiter/model/QualifyingStep;", "Lkotlin/collections/ArrayList;", "okButtonClicked", "Lkotlin/Function1;", "", "(Landroid/app/Activity;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "binding", "Lcom/jobamax/appjobamax/databinding/DialogQualifyingStepBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/DialogQualifyingStepBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/DialogQualifyingStepBinding;)V", "getOkButtonClicked", "()Lkotlin/jvm/functions/Function1;", "getQualifyingSteps", "()Ljava/util/ArrayList;", "selectedQualifyingStep", "getSelectedQualifyingStep", "()Lcom/jobamax/appjobamax/recruiter/model/QualifyingStep;", "setSelectedQualifyingStep", "(Lcom/jobamax/appjobamax/recruiter/model/QualifyingStep;)V", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpDialogView", "setUpObservers", "app_debug"})
public final class QualifyingStepDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.QualifyingStep> qualifyingSteps = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.QualifyingStep, kotlin.Unit> okButtonClicked = null;
    public com.jobamax.appjobamax.databinding.DialogQualifyingStepBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.recruiter.model.QualifyingStep selectedQualifyingStep;
    
    public QualifyingStepDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.QualifyingStep> qualifyingSteps, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.QualifyingStep, kotlin.Unit> okButtonClicked) {
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
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.QualifyingStep> getQualifyingSteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.QualifyingStep, kotlin.Unit> getOkButtonClicked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.DialogQualifyingStepBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.DialogQualifyingStepBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.QualifyingStep getSelectedQualifyingStep() {
        return null;
    }
    
    public final void setSelectedQualifyingStep(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.QualifyingStep p0) {
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