package com.jobamax.appjobamax.jobseeker.build_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentManualFilterMainBinding;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/ManualFilterMainFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentManualFilterMainBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentManualFilterMainBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentManualFilterMainBinding;)V", "configureUi", "", "goToFilterJobSearchTag", "goToModifyCv", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "setupViewPager", "AdapterTabPager", "app_debug"})
public final class ManualFilterMainFragment extends androidx.fragment.app.Fragment {
    public com.jobamax.appjobamax.databinding.FragmentManualFilterMainBinding binding;
    private java.util.HashMap _$_findViewCache;
    
    public ManualFilterMainFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentManualFilterMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentManualFilterMainBinding p0) {
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
    
    private final void setupViewPager() {
    }
    
    public final void goToFilterJobSearchTag() {
    }
    
    public final void goToModifyCv() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/ManualFilterMainFragment$AdapterTabPager;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "mFragmentList", "", "Landroidx/fragment/app/Fragment;", "mFragmentTitleList", "", "addFragment", "", "fragment", "title", "createFragment", "position", "", "getItemCount", "getTabTitle", "app_debug"})
    public static final class AdapterTabPager extends androidx.viewpager2.adapter.FragmentStateAdapter {
        private final java.util.List<androidx.fragment.app.Fragment> mFragmentList = null;
        private final java.util.List<java.lang.String> mFragmentTitleList = null;
        
        public AdapterTabPager(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentManager childFragmentManager, @org.jetbrains.annotations.NotNull()
        androidx.lifecycle.Lifecycle lifecycle) {
            super(null);
        }
        
        public final void addFragment(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTabTitle(int position) {
            return null;
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public androidx.fragment.app.Fragment createFragment(int position) {
            return null;
        }
    }
}