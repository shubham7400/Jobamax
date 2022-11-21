package com.jobamax.appjobamax.jobseeker.search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.google.firebase.ktx.Firebase;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.WebViewActivity;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentSeekerSearchJobBinding;
import com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding;
import com.jobamax.appjobamax.dialog.JobReportDialog;
import com.jobamax.appjobamax.dialog.MessageDialog;
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.delegation.CircularRevealViewAnimation;
import com.jobamax.appjobamax.jobseeker.delegation.CircularRevealViewAnimationImpl;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.preference.*;
import com.jobamax.appjobamax.util.*;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00015B%\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0011\u0010\'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\"H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\"H\u0096\u0001J\u0018\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020&H\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020&H\u0016J\u0011\u00101\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\"H\u0096\u0001J\u0011\u00102\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\"H\u0096\u0001J\u001e\u00103\u001a\u00020\u00112\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015\u00a8\u00066"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/SeekerJobNewCardStackAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/search/SeekerJobNewCardStackAdapter$ViewHolder;", "Lcom/jobamax/appjobamax/jobseeker/delegation/CircularRevealViewAnimation;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/JobOffer;", "Lkotlin/collections/ArrayList;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Ljava/util/ArrayList;Landroidx/fragment/app/FragmentActivity;)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "onCompanyClick", "Lkotlin/Function1;", "", "getOnCompanyClick", "()Lkotlin/jvm/functions/Function1;", "setOnCompanyClick", "(Lkotlin/jvm/functions/Function1;)V", "onDescriptionClick", "getOnDescriptionClick", "setOnDescriptionClick", "reportFlagClick", "getReportFlagClick", "setReportFlagClick", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "seeDescriptionClick", "getSeeDescriptionClick", "setSeeDescriptionClick", "createChip", "Landroid/view/View;", "tag", "", "getItemCount", "", "hideViewAnimationFromLeft", "view", "hideViewAnimationFromRight", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showViewAnimationFromLeft", "showViewAnimationFromRight", "submitList", "arrList", "ViewHolder", "app_debug"})
public final class SeekerJobNewCardStackAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.search.SeekerJobNewCardStackAdapter.ViewHolder> implements com.jobamax.appjobamax.jobseeker.delegation.CircularRevealViewAnimation {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> list;
    @org.jetbrains.annotations.NotNull()
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> seeDescriptionClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> reportFlagClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> onDescriptionClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> onCompanyClick;
    
    public SeekerJobNewCardStackAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> list, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity requireActivity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> getSeeDescriptionClick() {
        return null;
    }
    
    public final void setSeeDescriptionClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> getReportFlagClick() {
        return null;
    }
    
    public final void setReportFlagClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> getOnDescriptionClick() {
        return null;
    }
    
    public final void setOnDescriptionClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> getOnCompanyClick() {
        return null;
    }
    
    public final void setOnCompanyClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.JobOffer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.search.SeekerJobNewCardStackAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.search.SeekerJobNewCardStackAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.JobOffer> arrList) {
    }
    
    private final android.view.View createChip(java.lang.String tag) {
        return null;
    }
    
    @java.lang.Override()
    public void hideViewAnimationFromLeft(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void hideViewAnimationFromRight(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void showViewAnimationFromLeft(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void showViewAnimationFromRight(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/SeekerJobNewCardStackAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemSeekerJobCardBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemSeekerJobCardBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemSeekerJobCardBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding getBinding() {
            return null;
        }
    }
}