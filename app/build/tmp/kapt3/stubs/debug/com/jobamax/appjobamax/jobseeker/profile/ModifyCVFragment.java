package com.jobamax.appjobamax.jobseeker.profile;

import android.Manifest;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentModifyCVBinding;
import com.jobamax.appjobamax.dialog.*;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.build_profile.*;
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddDocument;
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddLink;
import com.jobamax.appjobamax.jobseeker.dialog.DialogWorkType;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.Experience;
import com.jobamax.appjobamax.model.ExperienceGroup;
import com.jobamax.appjobamax.model.Volunteering;
import com.jobamax.appjobamax.model.VolunteeringGroup;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.util.*;
import com.parse.*;
import com.pushwoosh.internal.platform.AndroidPlatformModule;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.*;
import kotlin.collections.ArrayList;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010k\u001a\u00020lH\u0002J\b\u0010m\u001a\u00020lH\u0002J\b\u0010n\u001a\u00020lH\u0002J\b\u0010o\u001a\u00020lH\u0002J\b\u0010p\u001a\u00020lH\u0002J\u0010\u0010q\u001a\u00020l2\u0006\u0010r\u001a\u00020$H\u0002J\u0010\u0010s\u001a\u00020l2\u0006\u0010r\u001a\u00020$H\u0002J\u0010\u0010t\u001a\u00020l2\u0006\u0010r\u001a\u00020$H\u0002J\b\u0010u\u001a\u00020lH\u0002J\b\u0010v\u001a\u00020lH\u0002J\b\u0010w\u001a\u00020lH\u0002J\b\u0010x\u001a\u00020lH\u0002J\b\u0010y\u001a\u00020lH\u0002J&\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}2\b\u0010~\u001a\u0004\u0018\u00010\u007f2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020lH\u0016J\t\u0010\u0083\u0001\u001a\u00020lH\u0016J\t\u0010\u0084\u0001\u001a\u00020lH\u0016J\t\u0010\u0085\u0001\u001a\u00020lH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020l2\u0007\u0010\u0087\u0001\u001a\u00020$H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020l2\u0007\u0010\u0087\u0001\u001a\u00020$H\u0002J \u0010\u0089\u0001\u001a\u00020l2\u0015\u0010\u008a\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020l0\u008b\u0001H\u0002J\t\u0010\u008d\u0001\u001a\u00020lH\u0002J\t\u0010\u008e\u0001\u001a\u00020lH\u0002J\u0012\u0010\u008f\u0001\u001a\u00020l2\u0007\u0010\u0087\u0001\u001a\u00020$H\u0002J\t\u0010\u0090\u0001\u001a\u00020lH\u0002J\t\u0010\u0091\u0001\u001a\u00020lH\u0002J\t\u0010\u0092\u0001\u001a\u00020lH\u0002J\t\u0010\u0093\u0001\u001a\u00020lH\u0002J\t\u0010\u0094\u0001\u001a\u00020lH\u0002J\b\u0010!\u001a\u00020lH\u0002J\u001e\u0010\u0095\u0001\u001a\u00020l2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0007\u0010\u0098\u0001\u001a\u00020,H\u0016J\t\u0010\u0099\u0001\u001a\u00020lH\u0002J\t\u0010\u009a\u0001\u001a\u00020lH\u0002J\t\u0010\u009b\u0001\u001a\u00020lH\u0002J\t\u0010\u009c\u0001\u001a\u00020lH\u0002J\b\u0010L\u001a\u00020lH\u0002J\b\u0010R\u001a\u00020lH\u0002J\b\u0010e\u001a\u00020lH\u0002J\u0012\u0010\u009d\u0001\u001a\u00020l2\u0007\u0010\u0098\u0001\u001a\u00020,H\u0002J+\u0010\u009e\u0001\u001a\u00020l2\b\u0010\u009f\u0001\u001a\u00030\u0097\u00012\u0016\u0010\u008a\u0001\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020l0\u008b\u0001H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\b\u0012\u0004\u0012\u00020$0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020$0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b7\u00108R\u001a\u0010;\u001a\u00020<X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020$0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020$0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020$0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020IX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020$0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\u001aR\u001a\u0010P\u001a\u00020IX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010K\"\u0004\bR\u0010MR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020$0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010\u001aR\u001c\u0010U\u001a\u0010\u0012\f\u0012\n X*\u0004\u0018\u00010W0W0VX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010Y\u001a\b\u0012\u0004\u0012\u00020$0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u001a\"\u0004\b[\u0010\u001cR\u001b\u0010\\\u001a\u00020]8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010:\u001a\u0004\b^\u0010_R\u001a\u0010a\u001a\u00020bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR \u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u001a\"\u0004\bj\u0010\u001c\u00a8\u0006\u00a0\u0001"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/ModifyCVFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;", "()V", "autocompleteFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "getAutocompleteFragment", "()Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "setAutocompleteFragment", "(Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentModifyCVBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentModifyCVBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentModifyCVBinding;)V", "educationAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerEducationAdapter;", "educations", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/Education;", "experienceAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerExperienceListAdapter;", "experiences", "Lcom/jobamax/appjobamax/model/Experience;", "getExperiences", "()Ljava/util/ArrayList;", "setExperiences", "(Ljava/util/ArrayList;)V", "hardSkillAdapter", "Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter;", "getHardSkillAdapter", "()Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter;", "setHardSkillAdapter", "(Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter;)V", "hardSkillSuggestions", "", "imagePicker", "Lcom/jobamax/appjobamax/util/ImagePicker;", "getImagePicker", "()Lcom/jobamax/appjobamax/util/ImagePicker;", "setImagePicker", "(Lcom/jobamax/appjobamax/util/ImagePicker;)V", "imagePosition", "", "getImagePosition", "()I", "setImagePosition", "(I)V", "imagesUrl", "getImagesUrl", "setImagesUrl", "interestTagsSuggestions", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper$delegate", "Lkotlin/Lazy;", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "ownedHardSkills", "Lcom/jobamax/appjobamax/model/HardSkill;", "ownedInterest", "ownedSoftSkills", "ownedWorkspace", "photosAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/PhotosAdapter;", "portfolioDocLinkAdapter", "Lcom/jobamax/appjobamax/recruiter/home/PortfolioLinksAdapter;", "getPortfolioDocLinkAdapter", "()Lcom/jobamax/appjobamax/recruiter/home/PortfolioLinksAdapter;", "setPortfolioDocLinkAdapter", "(Lcom/jobamax/appjobamax/recruiter/home/PortfolioLinksAdapter;)V", "portfolioDocLinks", "getPortfolioDocLinks", "portfolioLinkAdapter", "getPortfolioLinkAdapter", "setPortfolioLinkAdapter", "portfolioLinks", "getPortfolioLinks", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "softSkillSuggestions", "getSoftSkillSuggestions", "setSoftSkillSuggestions", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "volunteeringAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;", "getVolunteeringAdapter", "()Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;", "setVolunteeringAdapter", "(Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;)V", "volunteerings", "Lcom/jobamax/appjobamax/model/Volunteering;", "getVolunteerings", "setVolunteerings", "addHardSkill", "", "addIdealWorkspace", "addInterest", "addSoftSkill", "configureUi", "createInterestTag", "label", "createSoftSkillTag", "createWorkspaceTag", "getExistingHardSkillTags", "getExistingInterestTags", "getExistingSoftSkillTags", "getOwnedSoftSkills", "initializeJobSeeker", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onResume", "saveChanges", "saveHardSkillTag", "tag", "saveInterestTag", "saveJobSeeker", "callback", "Lkotlin/Function1;", "", "savePortfolioDocLinks", "savePortfolioLinks", "saveSoftSkillTag", "selectPDF", "setClickListeners", "setData", "setEducationAdapter", "setExperienceAdapter", "setImageUri", "imageUri", "Landroid/net/Uri;", "imageCode", "setName", "setObserver", "setPhotosAdapter", "setPlaceAutocompleteFragment", "setupImagePicker", "uploadImage", "profilePicUri", "app_debug"})
public final class ModifyCVFragment extends com.jobamax.appjobamax.base.BaseFragment implements com.jobamax.appjobamax.util.ImagePicker.GetImage {
    public com.jobamax.appjobamax.databinding.FragmentModifyCVBinding binding;
    public com.google.android.libraries.places.widget.AutocompleteSupportFragment autocompleteFragment;
    private com.jobamax.appjobamax.jobseeker.build_profile.PhotosAdapter photosAdapter;
    public com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter hardSkillAdapter;
    private java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> ownedHardSkills;
    private java.util.ArrayList<java.lang.String> hardSkillSuggestions;
    private java.util.ArrayList<java.lang.String> ownedSoftSkills;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> softSkillSuggestions;
    private java.util.ArrayList<java.lang.String> ownedInterest;
    private java.util.ArrayList<java.lang.String> interestTagsSuggestions;
    private java.util.ArrayList<java.lang.String> ownedWorkspace;
    public com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter portfolioLinkAdapter;
    public com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter portfolioDocLinkAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> portfolioLinks = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> portfolioDocLinks = null;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Experience> experiences;
    private com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter experienceAdapter;
    private com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter educationAdapter;
    private java.util.ArrayList<com.jobamax.appjobamax.model.Education> educations;
    public com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter volunteeringAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> volunteerings;
    public com.jobamax.appjobamax.util.ImagePicker imagePicker;
    private int imagePosition = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> imagesUrl;
    private final kotlin.Lazy itemTouchHelper$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public ModifyCVFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentModifyCVBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentModifyCVBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.libraries.places.widget.AutocompleteSupportFragment getAutocompleteFragment() {
        return null;
    }
    
    public final void setAutocompleteFragment(@org.jetbrains.annotations.NotNull()
    com.google.android.libraries.places.widget.AutocompleteSupportFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter getHardSkillAdapter() {
        return null;
    }
    
    public final void setHardSkillAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSoftSkillSuggestions() {
        return null;
    }
    
    public final void setSoftSkillSuggestions(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter getPortfolioLinkAdapter() {
        return null;
    }
    
    public final void setPortfolioLinkAdapter(@org.jetbrains.annotations.NotNull()
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
    public final java.util.ArrayList<java.lang.String> getPortfolioLinks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getPortfolioDocLinks() {
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
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.util.ImagePicker getImagePicker() {
        return null;
    }
    
    public final void setImagePicker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.util.ImagePicker p0) {
    }
    
    public final int getImagePosition() {
        return 0;
    }
    
    public final void setImagePosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getImagesUrl() {
        return null;
    }
    
    public final void setImagesUrl(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    private final androidx.recyclerview.widget.ItemTouchHelper getItemTouchHelper() {
        return null;
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
    
    private final void setObserver() {
    }
    
    private final void setData() {
    }
    
    private final void setPlaceAutocompleteFragment() {
    }
    
    private final void getOwnedSoftSkills() {
    }
    
    private final void setExperienceAdapter() {
    }
    
    private final void setEducationAdapter() {
    }
    
    private final void setVolunteeringAdapter() {
    }
    
    private final void initializeJobSeeker() {
    }
    
    private final void setPhotosAdapter() {
    }
    
    private final void setHardSkillAdapter() {
    }
    
    private final void setPortfolioLinkAdapter() {
    }
    
    private final void setPortfolioDocLinkAdapter() {
    }
    
    private final void savePortfolioDocLinks() {
    }
    
    private final void savePortfolioLinks() {
    }
    
    private final void createSoftSkillTag(java.lang.String label) {
    }
    
    private final void createInterestTag(java.lang.String label) {
    }
    
    private final void createWorkspaceTag(java.lang.String label) {
    }
    
    private final void setClickListeners() {
    }
    
    private final void addInterest() {
    }
    
    private final void getExistingInterestTags() {
    }
    
    private final void saveInterestTag(java.lang.String tag) {
    }
    
    private final void addIdealWorkspace() {
    }
    
    private final void addSoftSkill() {
    }
    
    private final void saveSoftSkillTag(java.lang.String tag) {
    }
    
    private final void getExistingSoftSkillTags() {
    }
    
    private final void addHardSkill() {
    }
    
    private final void saveHardSkillTag(java.lang.String tag) {
    }
    
    private final void getExistingHardSkillTags() {
    }
    
    private final void selectPDF() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void saveChanges() {
    }
    
    private final void setName() {
    }
    
    private final void setupImagePicker(int imageCode) {
    }
    
    @java.lang.Override()
    public void setImageUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri, int imageCode) {
    }
    
    private final void saveJobSeeker(kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    private final void uploadImage(android.net.Uri profilePicUri, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
}