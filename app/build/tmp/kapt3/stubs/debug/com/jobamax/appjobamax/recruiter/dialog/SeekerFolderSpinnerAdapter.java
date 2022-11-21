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

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0002\u0010\tJ\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020#H\u0016J\"\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a\u00a8\u0006\'"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/dialog/SeekerFolderSpinnerAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "activity", "Landroid/app/Activity;", "id", "", "list", "", "(Landroid/app/Activity;ILjava/util/List;)V", "folderId", "", "getFolderId", "()Ljava/lang/String;", "setFolderId", "(Ljava/lang/String;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "onAddMoreClick", "Lkotlin/Function0;", "", "getOnAddMoreClick", "()Lkotlin/jvm/functions/Function0;", "setOnAddMoreClick", "(Lkotlin/jvm/functions/Function0;)V", "onTitleClick", "getOnTitleClick", "setOnTitleClick", "getDropDownView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "getView", "isEnabled", "", "app_debug"})
public final class SeekerFolderSpinnerAdapter extends android.widget.ArrayAdapter<com.jobamax.appjobamax.recruiter.model.SeekerFolder> {
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.jobamax.appjobamax.recruiter.model.SeekerFolder> list;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onTitleClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onAddMoreClick;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String folderId = "";
    
    public SeekerFolderSpinnerAdapter(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int id, @org.jetbrains.annotations.NotNull()
    java.util.List<com.jobamax.appjobamax.recruiter.model.SeekerFolder> list) {
        super(null, 0);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.jobamax.appjobamax.recruiter.model.SeekerFolder> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.jobamax.appjobamax.recruiter.model.SeekerFolder> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnTitleClick() {
        return null;
    }
    
    public final void setOnTitleClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnAddMoreClick() {
        return null;
    }
    
    public final void setOnAddMoreClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFolderId() {
        return null;
    }
    
    public final void setFolderId(@org.jetbrains.annotations.NotNull()
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