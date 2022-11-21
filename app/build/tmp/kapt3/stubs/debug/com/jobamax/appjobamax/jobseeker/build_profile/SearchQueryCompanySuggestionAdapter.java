package com.jobamax.appjobamax.jobseeker.build_profile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.DatePickerDialogFragment;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBinding;
import com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.WorkType;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.network.ApiFetchCompaniesService;
import com.jobamax.appjobamax.repos.SearchQueryCompanyRepo;
import com.parse.ParseException;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u001e\u0010\u001b\u001a\u00020\r2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/SearchQueryCompanySuggestionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SearchQueryCompanySuggestionAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/SearchQueryCompany;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "setList", "onCompanyClick", "Lkotlin/Function1;", "", "getOnCompanyClick", "()Lkotlin/jvm/functions/Function1;", "setOnCompanyClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "suggestions", "ViewHolder", "app_debug"})
public final class SearchQueryCompanySuggestionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.build_profile.SearchQueryCompanySuggestionAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.SearchQueryCompany> list;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.SearchQueryCompany, kotlin.Unit> onCompanyClick;
    
    public SearchQueryCompanySuggestionAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.SearchQueryCompany> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.SearchQueryCompany> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.SearchQueryCompany> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.model.SearchQueryCompany, kotlin.Unit> getOnCompanyClick() {
        return null;
    }
    
    public final void setOnCompanyClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.model.SearchQueryCompany, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.build_profile.SearchQueryCompanySuggestionAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.build_profile.SearchQueryCompanySuggestionAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.SearchQueryCompany> suggestions) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/SearchQueryCompanySuggestionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemSearchQueryCompanyBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemSearchQueryCompanyBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemSearchQueryCompanyBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBinding getBinding() {
            return null;
        }
    }
}