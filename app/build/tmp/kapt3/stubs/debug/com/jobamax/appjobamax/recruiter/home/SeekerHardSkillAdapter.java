package com.jobamax.appjobamax.recruiter.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBinding;
import com.jobamax.appjobamax.databinding.ItemPortfolioLinkBinding;
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding;
import com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.*;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.JobMatchedDialog;
import com.jobamax.appjobamax.recruiter.model.CompanySubscription;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2;
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient;
import com.jobamax.appjobamax.util.StudentStatus;
import com.parse.*;
import com.parse.livequery.SubscriptionHandling;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import kotlin.collections.HashSet;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u00020\fH\u0016J\u0018\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\fH\u0016J\u0018\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\fH\u0016J\u0014\u00109\u001a\u00020\u00132\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R,\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/HardSkill;", "requireContext", "Landroid/content/Context;", "staticView", "", "(Ljava/util/ArrayList;Landroid/content/Context;Z)V", "cardShadowColor", "", "getCardShadowColor", "()I", "setCardShadowColor", "(I)V", "clickListener", "Lkotlin/Function1;", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "firstColor", "getFirstColor", "setFirstColor", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getRequireContext", "()Landroid/content/Context;", "secondColor", "getSecondColor", "setSecondColor", "skillLevelChangeListener", "Lkotlin/Function2;", "getSkillLevelChangeListener", "()Lkotlin/jvm/functions/Function2;", "setSkillLevelChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "changeCardBackgroundColor", "shadowColor", "gradientFirstColor", "gradientSecondColor", "changeStrokeColor", "sb", "Landroid/widget/SeekBar;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "ownedHardSkills", "ViewHolder", "app_debug"})
public final class SeekerHardSkillAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> list;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context requireContext = null;
    private final boolean staticView = false;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.HardSkill, kotlin.Unit> clickListener;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super com.jobamax.appjobamax.model.HardSkill, ? super java.lang.Integer, kotlin.Unit> skillLevelChangeListener;
    private int cardShadowColor = com.jobamax.appjobamax.R.color.screen_background;
    private int firstColor = com.jobamax.appjobamax.R.color.theme_light_blue;
    private int secondColor = com.jobamax.appjobamax.R.color.theme_dark_blue;
    
    public SeekerHardSkillAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> list, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext, boolean staticView) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getRequireContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.HardSkill, kotlin.Unit> getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.HardSkill, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<com.jobamax.appjobamax.model.HardSkill, java.lang.Integer, kotlin.Unit> getSkillLevelChangeListener() {
        return null;
    }
    
    public final void setSkillLevelChangeListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.jobamax.appjobamax.model.HardSkill, ? super java.lang.Integer, kotlin.Unit> p0) {
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
    public com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> ownedHardSkills) {
    }
    
    public final void changeCardBackgroundColor(int shadowColor, int gradientFirstColor, int gradientSecondColor) {
    }
    
    public final void changeStrokeColor(@org.jetbrains.annotations.NotNull()
    android.widget.SeekBar sb) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemSeekerHardSkillBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemSeekerHardSkillBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemSeekerHardSkillBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding getBinding() {
            return null;
        }
    }
}