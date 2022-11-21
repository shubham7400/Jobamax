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

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020-H\u0016J\b\u00108\u001a\u00020-H\u0016J\b\u0010\u0013\u001a\u00020-H\u0002J\b\u00109\u001a\u00020-H\u0002J\b\u0010:\u001a\u00020-H\u0002J\b\u0010!\u001a\u00020-H\u0002J\b\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020-H\u0002J\b\u0010>\u001a\u00020-H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020\'8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)\u00a8\u0006?"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatListFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "appliedFilter", "Lcom/jobamax/appjobamax/enums/SeekerChatListFilter;", "getAppliedFilter", "()Lcom/jobamax/appjobamax/enums/SeekerChatListFilter;", "setAppliedFilter", "(Lcom/jobamax/appjobamax/enums/SeekerChatListFilter;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerChatListBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentSeekerChatListBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentSeekerChatListBinding;)V", "chatThreadAdapter", "Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatThreadAdapter;", "getChatThreadAdapter", "()Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatThreadAdapter;", "setChatThreadAdapter", "(Lcom/jobamax/appjobamax/jobseeker/chat/SeekerChatThreadAdapter;)V", "chatThreadList", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/ChatThread;", "Lkotlin/collections/ArrayList;", "getChatThreadList", "()Ljava/util/ArrayList;", "setChatThreadList", "(Ljava/util/ArrayList;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "subscriptionHandling", "Lcom/parse/livequery/SubscriptionHandling;", "Lcom/parse/ParseObject;", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "getAllChatRecruiter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "setClickListeners", "setData", "setParseLiveQuery", "setViewModelObserver", "update", "updateChatThreadList", "app_debug"})
public final class SeekerChatListFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentSeekerChatListBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    private com.parse.livequery.SubscriptionHandling<com.parse.ParseObject> subscriptionHandling;
    public com.jobamax.appjobamax.jobseeker.chat.SeekerChatThreadAdapter chatThreadAdapter;
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.enums.SeekerChatListFilter appliedFilter = com.jobamax.appjobamax.enums.SeekerChatListFilter.All;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> chatThreadList;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerChatListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentSeekerChatListBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentSeekerChatListBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.JobSeeker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.chat.SeekerChatThreadAdapter getChatThreadAdapter() {
        return null;
    }
    
    public final void setChatThreadAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.chat.SeekerChatThreadAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.enums.SeekerChatListFilter getAppliedFilter() {
        return null;
    }
    
    public final void setAppliedFilter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.enums.SeekerChatListFilter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> getChatThreadList() {
        return null;
    }
    
    public final void setChatThreadList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.ChatThread> p0) {
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
    
    private final void setJobSeeker() {
    }
    
    private final void setData() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void setViewModelObserver() {
    }
    
    private final void setChatThreadAdapter() {
    }
    
    private final void getAllChatRecruiter() {
    }
    
    private final void updateChatThreadList() {
    }
    
    private final void update() {
    }
    
    private final void setParseLiveQuery() {
    }
    
    private final void setClickListeners() {
    }
}