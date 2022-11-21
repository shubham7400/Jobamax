package com.jobamax.appjobamax.recruiter.message;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentRecruiterRecruitmentSeekerProfileDialogBinding;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker;
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2;
import com.jobamax.appjobamax.util.StudentStatus;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerProfileDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterRecruitmentSeekerProfileDialogBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterRecruitmentSeekerProfileDialogBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterRecruitmentSeekerProfileDialogBinding;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "recruitmentSeeker", "Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;", "getRecruitmentSeeker", "()Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;", "setRecruitmentSeeker", "(Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;)V", "configureUi", "", "createChip", "Landroid/view/View;", "tag", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "setData", "Companion", "app_debug"})
public final class RecruiterRecruitmentSeekerProfileDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterRecruitmentSeekerProfileDialogBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker recruitmentSeeker;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerProfileDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterRecruitmentSeekerProfileDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterRecruitmentSeekerProfileDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterRecruitmentSeekerProfileDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker getRecruitmentSeeker() {
        return null;
    }
    
    public final void setRecruitmentSeeker(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void setData() {
    }
    
    private final android.view.View createChip(java.lang.String tag) {
        return null;
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerProfileDialogFragment$Companion;", "", "()V", "getInstance", "Lcom/jobamax/appjobamax/recruiter/message/RecruiterRecruitmentSeekerProfileDialogFragment;", "rs", "Lcom/jobamax/appjobamax/recruiter/model/RecruitmentSeeker;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.recruiter.message.RecruiterRecruitmentSeekerProfileDialogFragment getInstance(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker rs) {
            return null;
        }
    }
}