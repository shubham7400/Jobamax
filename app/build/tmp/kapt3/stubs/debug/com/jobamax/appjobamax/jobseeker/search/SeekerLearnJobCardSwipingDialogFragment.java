package com.jobamax.appjobamax.jobseeker.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentSeekerLearnJobCardSwipingDialogBinding;
import com.jobamax.appjobamax.databinding.ItemLearnJobCardSwipingBinding;
import com.jobamax.appjobamax.enums.LearnSwipeCardName;
import com.jobamax.appjobamax.jobseeker.model.SearchJobCardSwipingTutorial;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010\u0019\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006."}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/SeekerLearnJobCardSwipingDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "adapter", "Lcom/jobamax/appjobamax/jobseeker/search/SeekerLearnJobCardSwipingAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/jobseeker/search/SeekerLearnJobCardSwipingAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/jobseeker/search/SeekerLearnJobCardSwipingAdapter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerLearnJobCardSwipingDialogBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentSeekerLearnJobCardSwipingDialogBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentSeekerLearnJobCardSwipingDialogBinding;)V", "cardStackLayoutManager", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "getCardStackLayoutManager", "()Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "setCardStackLayoutManager", "(Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;)V", "cardStackListener", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "getCardStackListener", "()Lcom/yuyakaido/android/cardstackview/CardStackListener;", "setCardStackListener", "(Lcom/yuyakaido/android/cardstackview/CardStackListener;)V", "onFinish", "Lkotlin/Function0;", "", "getOnFinish", "()Lkotlin/jvm/functions/Function0;", "setOnFinish", "(Lkotlin/jvm/functions/Function0;)V", "configureUi", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCardStackView", "setClickListeners", "app_debug"})
public final class SeekerLearnJobCardSwipingDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentSeekerLearnJobCardSwipingDialogBinding binding;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onFinish;
    public com.jobamax.appjobamax.jobseeker.search.SeekerLearnJobCardSwipingAdapter adapter;
    public com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager;
    public com.yuyakaido.android.cardstackview.CardStackListener cardStackListener;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerLearnJobCardSwipingDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentSeekerLearnJobCardSwipingDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentSeekerLearnJobCardSwipingDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnFinish() {
        return null;
    }
    
    public final void setOnFinish(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.search.SeekerLearnJobCardSwipingAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.search.SeekerLearnJobCardSwipingAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.yuyakaido.android.cardstackview.CardStackLayoutManager getCardStackLayoutManager() {
        return null;
    }
    
    public final void setCardStackLayoutManager(@org.jetbrains.annotations.NotNull()
    com.yuyakaido.android.cardstackview.CardStackLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.yuyakaido.android.cardstackview.CardStackListener getCardStackListener() {
        return null;
    }
    
    public final void setCardStackListener(@org.jetbrains.annotations.NotNull()
    com.yuyakaido.android.cardstackview.CardStackListener p0) {
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
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void setCardStackView() {
    }
    
    private final void setCardStackListener() {
    }
}