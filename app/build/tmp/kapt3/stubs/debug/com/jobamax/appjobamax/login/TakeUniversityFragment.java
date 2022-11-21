package com.jobamax.appjobamax.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentTakeUniversityBinding;
import com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.model.University;
import com.jobamax.appjobamax.model.UserTempInfo;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\"\u0010#\u001a\u00020\"2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&\u0012\u0004\u0012\u00020\"0%H\u0002J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00062"}, d2 = {"Lcom/jobamax/appjobamax/login/TakeUniversityFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentTakeUniversityBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentTakeUniversityBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentTakeUniversityBinding;)V", "canFetchList", "", "getCanFetchList", "()Z", "setCanFetchList", "(Z)V", "university", "Lcom/jobamax/appjobamax/model/University;", "getUniversity", "()Lcom/jobamax/appjobamax/model/University;", "setUniversity", "(Lcom/jobamax/appjobamax/model/University;)V", "user", "Lcom/jobamax/appjobamax/model/UserTempInfo;", "getUser", "()Lcom/jobamax/appjobamax/model/UserTempInfo;", "setUser", "(Lcom/jobamax/appjobamax/model/UserTempInfo;)V", "configureUi", "", "getUniversities", "result", "Lkotlin/Function1;", "", "Lcom/parse/ParseObject;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setAdapterFunctionality", "setClickListeners", "app_debug"})
public final class TakeUniversityFragment extends androidx.fragment.app.Fragment {
    public com.jobamax.appjobamax.databinding.FragmentTakeUniversityBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.UserTempInfo user;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.University university;
    private boolean canFetchList = true;
    public com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    public TakeUniversityFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentTakeUniversityBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentTakeUniversityBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.UserTempInfo getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.UserTempInfo p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.University getUniversity() {
        return null;
    }
    
    public final void setUniversity(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.University p0) {
    }
    
    public final boolean getCanFetchList() {
        return false;
    }
    
    public final void setCanFetchList(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter p0) {
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
    
    private final void setClickListeners() {
    }
    
    private final void getUniversities(kotlin.jvm.functions.Function1<? super java.util.List<? extends com.parse.ParseObject>, kotlin.Unit> result) {
    }
    
    private final void setAdapterFunctionality() {
    }
}