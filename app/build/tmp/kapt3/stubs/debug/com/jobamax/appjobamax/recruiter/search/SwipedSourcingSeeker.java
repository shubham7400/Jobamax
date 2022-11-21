package com.jobamax.appjobamax.recruiter.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterSearchBinding;
import com.jobamax.appjobamax.databinding.ItemPortfolioImage2Binding;
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.DialogAddToFolderOrOffer;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.recruiter.model.*;
import com.jobamax.appjobamax.util.StudentStatus;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u00c6\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/search/SwipedSourcingSeeker;", "", "sourcingId", "", "jobSeekerId", "isSwipedRight", "", "selectedJobOffer", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "selectedSeekerFolder", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;)V", "()Z", "getJobSeekerId", "()Ljava/lang/String;", "getSelectedJobOffer", "()Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "getSelectedSeekerFolder", "()Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "getSourcingId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class SwipedSourcingSeeker {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sourcingId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jobSeekerId = null;
    private final boolean isSwipedRight = false;
    @org.jetbrains.annotations.Nullable()
    private final com.jobamax.appjobamax.recruiter.model.JobTitleFilter selectedJobOffer = null;
    @org.jetbrains.annotations.Nullable()
    private final com.jobamax.appjobamax.recruiter.model.SeekerFolder selectedSeekerFolder = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.search.SwipedSourcingSeeker copy(@org.jetbrains.annotations.NotNull()
    java.lang.String sourcingId, @org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, boolean isSwipedRight, @org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.JobTitleFilter selectedJobOffer, @org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.SeekerFolder selectedSeekerFolder) {
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
    
    public SwipedSourcingSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String sourcingId, @org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, boolean isSwipedRight, @org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.JobTitleFilter selectedJobOffer, @org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.SeekerFolder selectedSeekerFolder) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSourcingId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean isSwipedRight() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.JobTitleFilter component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.JobTitleFilter getSelectedJobOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.SeekerFolder component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.SeekerFolder getSelectedSeekerFolder() {
        return null;
    }
}