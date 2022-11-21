package com.jobamax.appjobamax.recruiter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.ActivityRecruiterHomeBinding;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.recruiter.home.RecruiterHomeFragment;
import com.jobamax.appjobamax.recruiter.message.RecruiterChatListFragment;
import com.jobamax.appjobamax.recruiter.profile.RecruiterProfileFragment;
import com.jobamax.appjobamax.recruiter.search.RecruiterSearchFragment;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/RecruiterBottomNavigationPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_debug"})
public final class RecruiterBottomNavigationPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    
    public RecruiterBottomNavigationPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager childFragmentManager, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Lifecycle lifecycle) {
        super(null);
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