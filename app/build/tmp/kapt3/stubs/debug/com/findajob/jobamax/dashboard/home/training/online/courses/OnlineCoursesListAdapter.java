package com.findajob.jobamax.dashboard.home.training.online.courses;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/OnlineCourse;", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListAdapter$Holder;", "()V", "clickListener", "Lkotlin/Function1;", "", "getClickListener$app_debug", "()Lkotlin/jvm/functions/Function1;", "setClickListener$app_debug", "(Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "Holder", "app_debug"})
public final class OnlineCoursesListAdapter extends androidx.paging.PagingDataAdapter<com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse, com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListAdapter.Holder> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse, kotlin.Unit> clickListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListAdapter.DiffCallback DiffCallback = null;
    
    public OnlineCoursesListAdapter() {
        super(null, null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse, kotlin.Unit> getClickListener$app_debug() {
        return null;
    }
    
    public final void setClickListener$app_debug(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListAdapter.Holder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemOnlineCoursesBinding;", "(Lcom/findajob/jobamax/databinding/ItemOnlineCoursesBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemOnlineCoursesBinding;", "Companion", "app_debug"})
    public static final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemOnlineCoursesBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListAdapter.Holder.Companion Companion = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemOnlineCoursesBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemOnlineCoursesBinding getBinding() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListAdapter$Holder$Companion;", "", "()V", "from", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListAdapter$Holder;", "parent", "Landroid/view/ViewGroup;", "layout", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListAdapter.Holder from(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent, int layout) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/OnlineCourse;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse> {
        
        private DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse oldItem, @org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse oldItem, @org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse newItem) {
            return false;
        }
    }
}