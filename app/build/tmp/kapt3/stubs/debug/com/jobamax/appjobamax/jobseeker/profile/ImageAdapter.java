package com.jobamax.appjobamax.jobseeker.profile;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.reflect.TypeToken;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.VideoPlayActivity;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.*;
import com.jobamax.appjobamax.dialog.SimpleMessageDialog;
import com.jobamax.appjobamax.dialog.SkillSuggestionDialog;
import com.jobamax.appjobamax.dialog.YesNoDialog;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.enums.SeekerProfileTheme;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.util.*;
import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.collections.ArrayList;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0015\u001a\u00020\u000e2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/ImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/profile/ImageAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "setList", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "imagesUrl", "ViewHolder", "app_debug"})
public final class ImageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.profile.ImageAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> list;
    
    public ImageAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.profile.ImageAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.profile.ImageAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> imagesUrl) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/ImageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemImageBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemImageBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemImageBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemImageBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemImageBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemImageBinding getBinding() {
            return null;
        }
    }
}