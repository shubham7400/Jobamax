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
import com.jobamax.appjobamax.databinding.DialogAddToFolderOrOfferBinding;
import com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000fJ\b\u0010.\u001a\u00020\rH\u0002J\u0012\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u00020\rH\u0002J\b\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\rH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00066"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/dialog/DialogAddToFolderOrOffer;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "_jobTitleFilterList", "", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "_seekerFolders", "Ljava/util/HashSet;", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "Lkotlin/collections/HashSet;", "onJobSelection", "Lkotlin/Function1;", "", "onSeekerFolderSelection", "(Landroid/app/Activity;Ljava/util/List;Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "binding", "Lcom/jobamax/appjobamax/databinding/DialogAddToFolderOrOfferBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/DialogAddToFolderOrOfferBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/DialogAddToFolderOrOfferBinding;)V", "jobTitleFilterList", "Ljava/util/ArrayList;", "jobTitleFilterSpinnerAdapter", "Lcom/jobamax/appjobamax/recruiter/home/JobTitleFilterSpinnerAdapter;", "getOnJobSelection", "()Lkotlin/jvm/functions/Function1;", "getOnSeekerFolderSelection", "seekerFolderSpinnerAdapter", "Lcom/jobamax/appjobamax/recruiter/dialog/SeekerFolderSpinnerAdapter;", "seekerFolders", "selectedJobTitleFilter", "getSelectedJobTitleFilter", "()Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "setSelectedJobTitleFilter", "(Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;)V", "selectedSeekerFolder", "getSelectedSeekerFolder", "()Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "setSelectedSeekerFolder", "(Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;)V", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "setJobTitleFilterSpinnerAdapter", "setSeekerFoldersSpinnerAdapter", "setUpDialogView", "app_debug"})
public final class DialogAddToFolderOrOffer extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    private final java.util.List<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> _jobTitleFilterList = null;
    private final java.util.HashSet<com.jobamax.appjobamax.recruiter.model.SeekerFolder> _seekerFolders = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.JobTitleFilter, kotlin.Unit> onJobSelection = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.SeekerFolder, kotlin.Unit> onSeekerFolderSelection = null;
    public com.jobamax.appjobamax.databinding.DialogAddToFolderOrOfferBinding binding;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> jobTitleFilterList = null;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SeekerFolder> seekerFolders = null;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.recruiter.model.JobTitleFilter selectedJobTitleFilter;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.recruiter.model.SeekerFolder selectedSeekerFolder;
    private com.jobamax.appjobamax.recruiter.dialog.SeekerFolderSpinnerAdapter seekerFolderSpinnerAdapter;
    private com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter jobTitleFilterSpinnerAdapter;
    
    public DialogAddToFolderOrOffer(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    java.util.List<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> _jobTitleFilterList, @org.jetbrains.annotations.Nullable()
    java.util.HashSet<com.jobamax.appjobamax.recruiter.model.SeekerFolder> _seekerFolders, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.JobTitleFilter, kotlin.Unit> onJobSelection, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.SeekerFolder, kotlin.Unit> onSeekerFolderSelection) {
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
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.JobTitleFilter, kotlin.Unit> getOnJobSelection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.SeekerFolder, kotlin.Unit> getOnSeekerFolderSelection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.DialogAddToFolderOrOfferBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.DialogAddToFolderOrOfferBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.JobTitleFilter getSelectedJobTitleFilter() {
        return null;
    }
    
    public final void setSelectedJobTitleFilter(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.JobTitleFilter p0) {
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
    
    private final void setSeekerFoldersSpinnerAdapter() {
    }
    
    private final void setJobTitleFilterSpinnerAdapter() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void setUpDialogView() {
    }
}