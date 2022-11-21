package com.jobamax.appjobamax.jobseeker.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.DailogChangeUniversityBinding;
import com.jobamax.appjobamax.databinding.ItemSeekerSearchUniversityBinding;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.model.University;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import kotlinx.android.synthetic.main.dailog_change_university.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010+\u001a\u00020!2\u0018\u0010,\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0004\u0012\u00020!0\u001fH\u0002J\b\u0010/\u001a\u00020!H\u0002J\u0012\u00100\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u00020!H\u0002J\b\u00105\u001a\u00020!H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u00066"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/dialog/DialogChangeUniversity;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "adapter", "Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/jobseeker/dialog/SeekerSearchUniversityAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/DailogChangeUniversityBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/DailogChangeUniversityBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/DailogChangeUniversityBinding;)V", "canFetchList", "", "getCanFetchList", "()Z", "setCanFetchList", "(Z)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "onDoneClick", "Lkotlin/Function1;", "Lcom/jobamax/appjobamax/model/University;", "", "getOnDoneClick", "()Lkotlin/jvm/functions/Function1;", "setOnDoneClick", "(Lkotlin/jvm/functions/Function1;)V", "university", "getUniversity", "()Lcom/jobamax/appjobamax/model/University;", "setUniversity", "(Lcom/jobamax/appjobamax/model/University;)V", "getUniversities", "result", "", "Lcom/parse/ParseObject;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setAdapterFunctionality", "setUpDialogView", "setUpObservers", "app_debug"})
public final class DialogChangeUniversity extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    public com.jobamax.appjobamax.databinding.DailogChangeUniversityBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.University, kotlin.Unit> onDoneClick;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.University university;
    private boolean canFetchList = true;
    public com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter adapter;
    
    public DialogChangeUniversity(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
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
    public final com.jobamax.appjobamax.databinding.DailogChangeUniversityBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.DailogChangeUniversityBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.University, kotlin.Unit> getOnDoneClick() {
        return null;
    }
    
    public final void setOnDoneClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.University, kotlin.Unit> p0) {
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
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setUpObservers() {
    }
    
    private final void getUniversities(kotlin.jvm.functions.Function1<? super java.util.List<? extends com.parse.ParseObject>, kotlin.Unit> result) {
    }
    
    private final void setAdapterFunctionality() {
    }
    
    private final void setUpDialogView() {
    }
}