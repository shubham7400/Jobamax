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

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/SeekerLearnJobCardSwipingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/search/SeekerLearnJobCardSwipingAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/jobseeker/model/SearchJobCardSwipingTutorial;", "Lkotlin/collections/ArrayList;", "requireContext", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "onSwipeClick", "Lkotlin/Function1;", "", "", "getOnSwipeClick", "()Lkotlin/jvm/functions/Function1;", "setOnSwipeClick", "(Lkotlin/jvm/functions/Function1;)V", "getRequireContext", "()Landroid/content/Context;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class SeekerLearnJobCardSwipingAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.search.SeekerLearnJobCardSwipingAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.jobseeker.model.SearchJobCardSwipingTutorial> list;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context requireContext = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onSwipeClick;
    
    public SeekerLearnJobCardSwipingAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.jobseeker.model.SearchJobCardSwipingTutorial> list, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.jobseeker.model.SearchJobCardSwipingTutorial> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.jobseeker.model.SearchJobCardSwipingTutorial> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getRequireContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnSwipeClick() {
        return null;
    }
    
    public final void setOnSwipeClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.search.SeekerLearnJobCardSwipingAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.search.SeekerLearnJobCardSwipingAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/SeekerLearnJobCardSwipingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemLearnJobCardSwipingBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemLearnJobCardSwipingBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemLearnJobCardSwipingBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemLearnJobCardSwipingBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemLearnJobCardSwipingBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemLearnJobCardSwipingBinding getBinding() {
            return null;
        }
    }
}