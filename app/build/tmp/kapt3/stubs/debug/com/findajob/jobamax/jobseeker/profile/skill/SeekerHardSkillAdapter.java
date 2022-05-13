package com.findajob.jobamax.jobseeker.profile.skill;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0016J\u001e\u0010!\u001a\u00020\n2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0007R,\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/skill/SeekerHardSkillAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/jobseeker/profile/skill/SeekerHardSkillAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/data/pojo/HardSkill;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "clickListener", "Lkotlin/Function1;", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getList", "()Ljava/util/ArrayList;", "setList", "skillLevelChangeListener", "Lkotlin/Function2;", "", "getSkillLevelChangeListener", "()Lkotlin/jvm/functions/Function2;", "setSkillLevelChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "ownedHardSkills", "ViewHolder", "app_debug"})
public final class SeekerHardSkillAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.jobseeker.profile.skill.SeekerHardSkillAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> list;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.HardSkill, kotlin.Unit> clickListener;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super com.findajob.jobamax.data.pojo.HardSkill, ? super java.lang.Integer, kotlin.Unit> skillLevelChangeListener;
    
    public SeekerHardSkillAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.data.pojo.HardSkill, kotlin.Unit> getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.HardSkill, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<com.findajob.jobamax.data.pojo.HardSkill, java.lang.Integer, kotlin.Unit> getSkillLevelChangeListener() {
        return null;
    }
    
    public final void setSkillLevelChangeListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.findajob.jobamax.data.pojo.HardSkill, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.jobseeker.profile.skill.SeekerHardSkillAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.skill.SeekerHardSkillAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> ownedHardSkills) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/skill/SeekerHardSkillAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemSeekerHardSkillBinding;", "(Lcom/findajob/jobamax/databinding/ItemSeekerHardSkillBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemSeekerHardSkillBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemSeekerHardSkillBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemSeekerHardSkillBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemSeekerHardSkillBinding getBinding() {
            return null;
        }
    }
}