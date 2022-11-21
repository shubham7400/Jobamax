package com.jobamax.appjobamax.jobseeker.chat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.*;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentSeekerChatListBinding;
import com.jobamax.appjobamax.databinding.ItemJobSeekerChatListBinding;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.enums.SeekerChatListFilter;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.dialog.DialogJobSeekerThreadFilter;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.ChatThread;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient;
import com.parse.*;
import com.parse.livequery.SubscriptionHandling;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u001e\u0010$\u001a\u00020\u00102\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\'"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatThreadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatThreadAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/ChatThread;", "Lkotlin/collections/ArrayList;", "requireContext", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "onChatThreadClick", "Lkotlin/Function1;", "", "getOnChatThreadClick", "()Lkotlin/jvm/functions/Function1;", "setOnChatThreadClick", "(Lkotlin/jvm/functions/Function1;)V", "onProfileClick", "", "getOnProfileClick", "setOnProfileClick", "getRequireContext", "()Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "chatThreadList", "ViewHolder", "app_debug"})
public final class SeekerChatThreadAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.chat.SeekerChatThreadAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> list;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context requireContext = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.ChatThread, kotlin.Unit> onChatThreadClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onProfileClick;
    
    public SeekerChatThreadAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> list, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getRequireContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.ChatThread, kotlin.Unit> getOnChatThreadClick() {
        return null;
    }
    
    public final void setOnChatThreadClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.ChatThread, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnProfileClick() {
        return null;
    }
    
    public final void setOnProfileClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.chat.SeekerChatThreadAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.chat.SeekerChatThreadAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> chatThreadList) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatThreadAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemJobSeekerChatListBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemJobSeekerChatListBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemJobSeekerChatListBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemJobSeekerChatListBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemJobSeekerChatListBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemJobSeekerChatListBinding getBinding() {
            return null;
        }
    }
}