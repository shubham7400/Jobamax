package com.jobamax.appjobamax.jobseeker.build_profile;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.*;
import android.widget.*;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.*;
import com.jobamax.appjobamax.dialog.*;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.extensions.*;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddDocument;
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddLink;
import com.jobamax.appjobamax.jobseeker.dialog.DialogWorkType;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.util.*;
import com.parse.*;
import com.pushwoosh.internal.platform.AndroidPlatformModule;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fJ \u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0002J\b\u00100\u001a\u00020\fH\u0016J\u0018\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\fH\u0016J\u0018\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\fH\u0016J\u0014\u00108\u001a\u00020\u00132\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(\u00a8\u0006;"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerEducationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerEducationAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/Education;", "requireContext", "Landroid/content/Context;", "staticView", "", "(Ljava/util/ArrayList;Landroid/content/Context;Z)V", "cardShadowColor", "", "getCardShadowColor", "()I", "setCardShadowColor", "(I)V", "clickListener", "Lkotlin/Function1;", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "firstColor", "getFirstColor", "setFirstColor", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "onItemClick", "getOnItemClick", "setOnItemClick", "getRequireContext", "()Landroid/content/Context;", "secondColor", "getSecondColor", "setSecondColor", "getStaticView", "()Z", "changeCardBackgroundColor", "shadowColor", "gradientFirstColor", "gradientSecondColor", "changeStrokeColor", "tag", "Landroid/view/View;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "educations", "ViewHolder", "app_debug"})
public final class SeekerEducationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Education> list;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context requireContext = null;
    private final boolean staticView = false;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.Education, kotlin.Unit> clickListener;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.Education, kotlin.Unit> onItemClick;
    private int cardShadowColor = com.jobamax.appjobamax.R.color.screen_background;
    private int firstColor = com.jobamax.appjobamax.R.color.theme_light_blue;
    private int secondColor = com.jobamax.appjobamax.R.color.theme_dark_blue;
    
    public SeekerEducationAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Education> list, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext, boolean staticView) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.Education> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Education> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getRequireContext() {
        return null;
    }
    
    public final boolean getStaticView() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.Education, kotlin.Unit> getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.Education, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.Education, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.Education, kotlin.Unit> p0) {
    }
    
    public final int getCardShadowColor() {
        return 0;
    }
    
    public final void setCardShadowColor(int p0) {
    }
    
    public final int getFirstColor() {
        return 0;
    }
    
    public final void setFirstColor(int p0) {
    }
    
    public final int getSecondColor() {
        return 0;
    }
    
    public final void setSecondColor(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Education> educations) {
    }
    
    public final void changeCardBackgroundColor(int shadowColor, int gradientFirstColor, int gradientSecondColor) {
    }
    
    private final void changeStrokeColor(android.view.View tag, int firstColor, int secondColor) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerEducationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemSeekerEducationBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemSeekerEducationBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemSeekerEducationBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemSeekerEducationBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemSeekerEducationBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemSeekerEducationBinding getBinding() {
            return null;
        }
    }
}