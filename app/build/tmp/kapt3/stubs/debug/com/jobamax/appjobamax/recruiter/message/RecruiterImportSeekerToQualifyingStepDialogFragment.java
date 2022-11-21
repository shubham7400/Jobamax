package com.jobamax.appjobamax.recruiter.message;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentRecruiterImportSeekerToQualifyingStepDialogBinding;
import com.jobamax.appjobamax.databinding.ItemFolderSeekerBinding;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.recruiter.model.FolderSeeker;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import org.json.JSONArray;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010\r\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterImportSeekerToQualifyingStepDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterImportSeekerToQualifyingStepDialogBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterImportSeekerToQualifyingStepDialogBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterImportSeekerToQualifyingStepDialogBinding;)V", "folderSeekerAdapter", "Lcom/jobamax/appjobamax/recruiter/message/FolderSeekerAdapter;", "getFolderSeekerAdapter", "()Lcom/jobamax/appjobamax/recruiter/message/FolderSeekerAdapter;", "setFolderSeekerAdapter", "(Lcom/jobamax/appjobamax/recruiter/message/FolderSeekerAdapter;)V", "folderSeekers", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/recruiter/model/FolderSeeker;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "jobOffer", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "qualifyingStep", "", "Ljava/lang/Integer;", "seekerFolder", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "selectedFolderSeekers", "configureUi", "", "getFolderSeekers", "importFolderSeekers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "validateReason", "Companion", "app_debug"})
public final class RecruiterImportSeekerToQualifyingStepDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterImportSeekerToQualifyingStepDialogBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    private com.jobamax.appjobamax.recruiter.model.JobTitleFilter jobOffer;
    private java.lang.Integer qualifyingStep;
    private com.jobamax.appjobamax.recruiter.model.SeekerFolder seekerFolder;
    public com.jobamax.appjobamax.recruiter.message.FolderSeekerAdapter folderSeekerAdapter;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.FolderSeeker> folderSeekers = null;
    private final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.FolderSeeker> selectedFolderSeekers = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.recruiter.message.RecruiterImportSeekerToQualifyingStepDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterImportSeekerToQualifyingStepDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterImportSeekerToQualifyingStepDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterImportSeekerToQualifyingStepDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.message.FolderSeekerAdapter getFolderSeekerAdapter() {
        return null;
    }
    
    public final void setFolderSeekerAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.message.FolderSeekerAdapter p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    private final void setFolderSeekerAdapter() {
    }
    
    private final void validateReason() {
    }
    
    private final void getFolderSeekers() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void importFolderSeekers() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterImportSeekerToQualifyingStepDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/jobamax/appjobamax/recruiter/message/RecruiterImportSeekerToQualifyingStepDialogFragment;", "jobOffer", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "qualifyingStep", "", "seekerFolder", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.recruiter.message.RecruiterImportSeekerToQualifyingStepDialogFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.recruiter.model.JobTitleFilter jobOffer, int qualifyingStep, @org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.recruiter.model.SeekerFolder seekerFolder) {
            return null;
        }
    }
}