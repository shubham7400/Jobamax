package com.jobamax.appjobamax.recruiter.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBinding;
import com.jobamax.appjobamax.databinding.ItemRecruiterChatListBinding;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.model.University;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.DialogSeekerFolder;
import com.jobamax.appjobamax.recruiter.dialog.FilterJobRoleWiseDialog;
import com.jobamax.appjobamax.recruiter.dialog.QualifyingStepDialog;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.QualifyingStep;
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010A\u001a\u00020<H\u0016J\u0018\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020<H\u0016J\u0018\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020<H\u0016J\u001e\u0010I\u001a\u00020\u00192\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u000e\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020<J\u000e\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u000fR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dRK\u0010$\u001a3\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00190%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R6\u0010-\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR&\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R \u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R \u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R\u001a\u0010;\u001a\u00020<X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006P"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerChatListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerChatListAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;", "Lkotlin/collections/ArrayList;", "requireContext", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "isRecruitmentSeekerSelected", "", "()Z", "setRecruitmentSeekerSelected", "(Z)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "onChatClick", "Lkotlin/Function1;", "", "getOnChatClick", "()Lkotlin/jvm/functions/Function1;", "setOnChatClick", "(Lkotlin/jvm/functions/Function1;)V", "onProfileClick", "getOnProfileClick", "setOnProfileClick", "onRatingChange", "getOnRatingChange", "setOnRatingChange", "onRefusedSeekerSelectionForSort", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "updateVisibility", "getOnRefusedSeekerSelectionForSort", "()Lkotlin/jvm/functions/Function2;", "setOnRefusedSeekerSelectionForSort", "(Lkotlin/jvm/functions/Function2;)V", "onSeekerSelectionForSort", "getOnSeekerSelectionForSort", "setOnSeekerSelectionForSort", "onSortClick", "getOnSortClick", "setOnSortClick", "getRequireContext", "()Landroid/content/Context;", "selectedRecruitmentSeekers", "getSelectedRecruitmentSeekers", "setSelectedRecruitmentSeekers", "selectedRefusedRecruitmentSeekers", "getSelectedRefusedRecruitmentSeekers", "setSelectedRefusedRecruitmentSeekers", "selectionType", "", "getSelectionType", "()I", "setSelectionType", "(I)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "recruitmentSeekerList", "update", "qualifyingStepSelectionType", "updateRecruitmentSeekerSelection", "b", "ViewHolder", "app_debug"})
public final class RecruiterRecruitmentSeekerChatListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerChatListAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> list;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context requireContext = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> onSortClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> onChatClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> onRatingChange;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> onProfileClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker>, kotlin.Unit> onSeekerSelectionForSort;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker>, ? super java.lang.Boolean, kotlin.Unit> onRefusedSeekerSelectionForSort;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    private boolean isRecruitmentSeekerSelected = false;
    private int selectionType = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> selectedRecruitmentSeekers;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> selectedRefusedRecruitmentSeekers;
    
    public RecruiterRecruitmentSeekerChatListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> list, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getRequireContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> getOnSortClick() {
        return null;
    }
    
    public final void setOnSortClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> getOnChatClick() {
        return null;
    }
    
    public final void setOnChatClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> getOnRatingChange() {
        return null;
    }
    
    public final void setOnRatingChange(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> getOnProfileClick() {
        return null;
    }
    
    public final void setOnProfileClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker>, kotlin.Unit> getOnSeekerSelectionForSort() {
        return null;
    }
    
    public final void setOnSeekerSelectionForSort(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker>, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker>, java.lang.Boolean, kotlin.Unit> getOnRefusedSeekerSelectionForSort() {
        return null;
    }
    
    public final void setOnRefusedSeekerSelectionForSort(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker>, ? super java.lang.Boolean, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    public final boolean isRecruitmentSeekerSelected() {
        return false;
    }
    
    public final void setRecruitmentSeekerSelected(boolean p0) {
    }
    
    public final int getSelectionType() {
        return 0;
    }
    
    public final void setSelectionType(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> getSelectedRecruitmentSeekers() {
        return null;
    }
    
    public final void setSelectedRecruitmentSeekers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> getSelectedRefusedRecruitmentSeekers() {
        return null;
    }
    
    public final void setSelectedRefusedRecruitmentSeekers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerChatListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerChatListAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker> recruitmentSeekerList) {
    }
    
    public final void updateRecruitmentSeekerSelection(boolean b) {
    }
    
    public final void update(int qualifyingStepSelectionType) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerChatListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemRecruiterChatListBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemRecruiterChatListBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemRecruiterChatListBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemRecruiterChatListBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemRecruiterChatListBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemRecruiterChatListBinding getBinding() {
            return null;
        }
    }
}