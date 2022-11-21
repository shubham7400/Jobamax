package com.jobamax.appjobamax.jobseeker.search;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentJobMatchInfoDialogBinding;
import com.jobamax.appjobamax.model.JobOffer;
import com.jobamax.appjobamax.model.MatchTag;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/JobMatchInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentJobMatchInfoDialogBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentJobMatchInfoDialogBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentJobMatchInfoDialogBinding;)V", "isManualJobFilter", "", "()Z", "setManualJobFilter", "(Z)V", "topJobOffer", "Lcom/jobamax/appjobamax/model/JobOffer;", "configureUi", "", "createChip", "Landroid/view/View;", "matchTag", "Lcom/jobamax/appjobamax/model/MatchTag;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "setData", "Companion", "app_debug"})
public final class JobMatchInfoDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentJobMatchInfoDialogBinding binding;
    private com.jobamax.appjobamax.model.JobOffer topJobOffer;
    private boolean isManualJobFilter = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.jobseeker.search.JobMatchInfoDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public JobMatchInfoDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentJobMatchInfoDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentJobMatchInfoDialogBinding p0) {
    }
    
    public final boolean isManualJobFilter() {
        return false;
    }
    
    public final void setManualJobFilter(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void configureUi() {
    }
    
    private final void setData() {
    }
    
    private final android.view.View createChip(com.jobamax.appjobamax.model.MatchTag matchTag) {
        return null;
    }
    
    private final void setClickListeners() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/JobMatchInfoDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/jobamax/appjobamax/jobseeker/search/JobMatchInfoDialogFragment;", "topJobOffer", "Lcom/jobamax/appjobamax/model/JobOffer;", "isManualJobFilter", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.jobseeker.search.JobMatchInfoDialogFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.model.JobOffer topJobOffer, boolean isManualJobFilter) {
            return null;
        }
    }
}