package com.jobamax.appjobamax.recruiter.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBinding;
import com.jobamax.appjobamax.databinding.ItemPortfolioLinkBinding;
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding;
import com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.*;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.JobMatchedDialog;
import com.jobamax.appjobamax.recruiter.model.CompanySubscription;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2;
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient;
import com.jobamax.appjobamax.util.StudentStatus;
import com.parse.*;
import com.parse.livequery.SubscriptionHandling;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import kotlin.collections.HashSet;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/home/SwipedRecruitmentSeeker;", "", "jobSeekerId", "", "jobOfferId", "recruitmentStep", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getJobOfferId", "()Ljava/lang/String;", "getJobSeekerId", "getRecruitmentStep", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SwipedRecruitmentSeeker {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jobSeekerId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jobOfferId = null;
    private final int recruitmentStep = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.home.SwipedRecruitmentSeeker copy(@org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, @org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId, int recruitmentStep) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SwipedRecruitmentSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, @org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId, int recruitmentStep) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getRecruitmentStep() {
        return 0;
    }
}