package com.jobamax.appjobamax.jobseeker.build_profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentProfilePreviewBinding;
import com.jobamax.appjobamax.dialog.BuildProfileSuggestionDialog;
import com.jobamax.appjobamax.dialog.SkillSuggestionDialog;
import com.jobamax.appjobamax.dialog.SimpleMessageDialog;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2;
import com.jobamax.appjobamax.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J&\u0010;\u001a\u0004\u0018\u0001082\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u000206H\u0002J\b\u0010C\u001a\u000206H\u0002J\b\u0010D\u001a\u000206H\u0002J\b\u0010E\u001a\u000206H\u0002J\b\u0010\u001a\u001a\u000206H\u0002J\b\u0010F\u001a\u000206H\u0002J\b\u0010/\u001a\u000206H\u0002J\b\u0010G\u001a\u000206H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001b\u0010%\u001a\u00020&8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\'\u0010(R\u001a\u0010+\u001a\u00020,X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\b\u0012\u0004\u0012\u0002020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010\u0015\u00a8\u0006H"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/ProfilePreviewFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentProfilePreviewBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentProfilePreviewBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentProfilePreviewBinding;)V", "educationAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerEducationAdapter;", "educations", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/Education;", "experienceAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerExperienceListAdapter;", "experiences", "Lcom/jobamax/appjobamax/model/Experience;", "getExperiences", "()Ljava/util/ArrayList;", "setExperiences", "(Ljava/util/ArrayList;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "portfolioDocLinkAdapter", "Lcom/jobamax/appjobamax/recruiter/home/PortfolioLinksAdapter;", "getPortfolioDocLinkAdapter", "()Lcom/jobamax/appjobamax/recruiter/home/PortfolioLinksAdapter;", "setPortfolioDocLinkAdapter", "(Lcom/jobamax/appjobamax/recruiter/home/PortfolioLinksAdapter;)V", "portfolioLinksAdapter", "getPortfolioLinksAdapter", "setPortfolioLinksAdapter", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "volunteeringAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;", "getVolunteeringAdapter", "()Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;", "setVolunteeringAdapter", "(Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;)V", "volunteerings", "Lcom/jobamax/appjobamax/model/Volunteering;", "getVolunteerings", "setVolunteerings", "configureUi", "", "createChip", "Landroid/view/View;", "label", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "setData", "setEducationAdapter", "setExperienceAdapter", "setObserver", "validate", "app_debug"})
public final class ProfilePreviewFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentProfilePreviewBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    public com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter portfolioLinksAdapter;
    public com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter portfolioDocLinkAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Experience> experiences;
    private com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter experienceAdapter;
    private com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter educationAdapter;
    private java.util.ArrayList<com.jobamax.appjobamax.model.Education> educations;
    public com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter volunteeringAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> volunteerings;
    private java.util.HashMap _$_findViewCache;
    
    public ProfilePreviewFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentProfilePreviewBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentProfilePreviewBinding p0) {
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
    public final com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter getPortfolioLinksAdapter() {
        return null;
    }
    
    public final void setPortfolioLinksAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter getPortfolioDocLinkAdapter() {
        return null;
    }
    
    public final void setPortfolioDocLinkAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.Experience> getExperiences() {
        return null;
    }
    
    public final void setExperiences(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Experience> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter getVolunteeringAdapter() {
        return null;
    }
    
    public final void setVolunteeringAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> getVolunteerings() {
        return null;
    }
    
    public final void setVolunteerings(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
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
    
    private final void setObserver() {
    }
    
    private final void setData() {
    }
    
    private final android.view.View createChip(java.lang.String label) {
        return null;
    }
    
    private final void setExperienceAdapter() {
    }
    
    private final void setEducationAdapter() {
    }
    
    private final void setVolunteeringAdapter() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void validate() {
    }
}