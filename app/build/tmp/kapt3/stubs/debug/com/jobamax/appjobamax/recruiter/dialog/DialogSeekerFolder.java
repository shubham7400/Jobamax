package com.jobamax.appjobamax.recruiter.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.DialogFilterJobRoleWiseBinding;
import com.jobamax.appjobamax.databinding.DialogSeekerFolderBinding;
import com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001f\u001a\u00020\nH\u0002J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\nH\u0002R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\'"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/dialog/DialogSeekerFolder;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "_seekerFolders", "Ljava/util/HashSet;", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "Lkotlin/collections/HashSet;", "onContinueClick", "Lkotlin/Function1;", "", "(Landroid/app/Activity;Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "binding", "Lcom/jobamax/appjobamax/databinding/DialogSeekerFolderBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/DialogSeekerFolderBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/DialogSeekerFolderBinding;)V", "getOnContinueClick", "()Lkotlin/jvm/functions/Function1;", "seekerFolders", "Ljava/util/ArrayList;", "selectedSeekerFolder", "getSelectedSeekerFolder", "()Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "setSelectedSeekerFolder", "(Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;)V", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "setJobTitleFilterSpinnerAdapter", "setUpDialogView", "validateReason", "app_debug"})
public final class DialogSeekerFolder extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    private final java.util.HashSet<com.jobamax.appjobamax.recruiter.model.SeekerFolder> _seekerFolders = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.SeekerFolder, kotlin.Unit> onContinueClick = null;
    public com.jobamax.appjobamax.databinding.DialogSeekerFolderBinding binding;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SeekerFolder> seekerFolders = null;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.recruiter.model.SeekerFolder selectedSeekerFolder;
    
    public DialogSeekerFolder(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    java.util.HashSet<com.jobamax.appjobamax.recruiter.model.SeekerFolder> _seekerFolders, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.SeekerFolder, kotlin.Unit> onContinueClick) {
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
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.SeekerFolder, kotlin.Unit> getOnContinueClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.DialogSeekerFolderBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.DialogSeekerFolderBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.SeekerFolder getSelectedSeekerFolder() {
        return null;
    }
    
    public final void setSelectedSeekerFolder(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.SeekerFolder p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void validateReason() {
    }
    
    private final void setJobTitleFilterSpinnerAdapter() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void setUpDialogView() {
    }
}