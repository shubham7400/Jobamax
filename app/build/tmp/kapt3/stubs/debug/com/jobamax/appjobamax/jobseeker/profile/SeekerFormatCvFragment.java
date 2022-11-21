package com.jobamax.appjobamax.jobseeker.profile;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.res.ResourcesCompat;
import com.google.gson.reflect.TypeToken;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.VideoPlayActivity;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.*;
import com.jobamax.appjobamax.dialog.SimpleMessageDialog;
import com.jobamax.appjobamax.dialog.YesNoDialog;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.enums.SeekerProfileTheme;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter;
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter;
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter;
import com.jobamax.appjobamax.util.StudentStatus;
import org.json.JSONObject;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import kotlin.collections.ArrayList;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010v\u001a\u00020wH\u0003J \u0010x\u001a\u00020w2\u0006\u0010y\u001a\u00020(2\u0006\u0010z\u001a\u00020\b2\u0006\u0010{\u001a\u00020\bH\u0002J \u0010|\u001a\u00020w2\u0006\u0010}\u001a\u00020?2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bH\u0002J7\u0010\u0080\u0001\u001a\u00020w2\u0007\u0010\u0081\u0001\u001a\u00020\b2\u0007\u0010\u0082\u0001\u001a\u00020\b2\u0007\u0010\u0083\u0001\u001a\u00020\b2\u0007\u0010\u0084\u0001\u001a\u00020\b2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J#\u0010\u0087\u0001\u001a\u00020w2\b\u0010\u0088\u0001\u001a\u00030\u0086\u00012\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bH\u0002J\t\u0010\u0089\u0001\u001a\u00020wH\u0002J\t\u0010\u008a\u0001\u001a\u00020wH\u0002J\"\u0010\u008b\u0001\u001a\u00020?2\u0007\u0010\u008c\u0001\u001a\u0002022\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bH\u0002J\t\u0010\u008d\u0001\u001a\u00020wH\u0002J\t\u0010\u008e\u0001\u001a\u00020wH\u0002J+\u0010\u008f\u0001\u001a\u00020?2\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020w2\u0007\u0010\u0097\u0001\u001a\u00020EH\u0002J\t\u0010\u0098\u0001\u001a\u00020wH\u0002J\t\u0010\u0099\u0001\u001a\u00020wH\u0002J\t\u0010\u009a\u0001\u001a\u00020wH\u0002J\t\u0010\u009b\u0001\u001a\u00020wH\u0002J\t\u0010\u009c\u0001\u001a\u00020wH\u0002J\t\u0010\u009d\u0001\u001a\u00020wH\u0002J\t\u0010\u009e\u0001\u001a\u00020wH\u0002J\b\u0010\"\u001a\u00020wH\u0002J\t\u0010\u009f\u0001\u001a\u00020wH\u0002J\u0019\u0010\u00a0\u0001\u001a\u00020w2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bH\u0002J\b\u0010;\u001a\u00020wH\u0002J\t\u0010\u00a1\u0001\u001a\u00020wH\u0002J\t\u0010\u00a2\u0001\u001a\u00020wH\u0002J\t\u0010\u00a3\u0001\u001a\u00020wH\u0002J\u0019\u0010\u00a4\u0001\u001a\u00020w2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bH\u0002J\t\u0010\u00a5\u0001\u001a\u00020wH\u0002J\b\u0010n\u001a\u00020wH\u0002J\u0019\u0010\u00a6\u0001\u001a\u00020w2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bH\u0002J\t\u0010\u00a7\u0001\u001a\u00020wH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020(0\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R \u00101\u001a\b\u0012\u0004\u0012\u0002020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u000e\u00105\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u000e\u0010B\u001a\u00020CX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020SX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u0002020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\n\"\u0004\ba\u0010\fR\u000e\u0010b\u001a\u00020cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010d\u001a\u00020e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bf\u0010gR\u001a\u0010j\u001a\u00020kX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u000e\u0010p\u001a\u00020qX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010r\u001a\b\u0012\u0004\u0012\u00020s0\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u001b\"\u0004\bu\u0010\u001d\u00a8\u0006\u00a8\u0001"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/SeekerFormatCvFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "audioVideoBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileAudioVideoBinding;", "bioBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileBioBinding;", "currentThemeIconStyle", "", "getCurrentThemeIconStyle", "()I", "setCurrentThemeIconStyle", "(I)V", "educationAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerEducationAdapter;", "educationBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileEducationBinding;", "educations", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/Education;", "experienceAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerExperienceListAdapter;", "experienceBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileExperienceBinding;", "experiences", "Lcom/jobamax/appjobamax/model/Experience;", "getExperiences", "()Ljava/util/ArrayList;", "setExperiences", "(Ljava/util/ArrayList;)V", "hardSkillAdapter", "Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter;", "getHardSkillAdapter", "()Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter;", "setHardSkillAdapter", "(Lcom/jobamax/appjobamax/recruiter/home/SeekerHardSkillAdapter;)V", "idealWorkspaceBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileIdealWorkspaceBinding;", "imageViewAndDrawableIdMap", "Ljava/util/HashMap;", "Landroid/widget/ImageView;", "imagesAdapter", "Lcom/jobamax/appjobamax/jobseeker/profile/ImageAdapter;", "getImagesAdapter", "()Lcom/jobamax/appjobamax/jobseeker/profile/ImageAdapter;", "setImagesAdapter", "(Lcom/jobamax/appjobamax/jobseeker/profile/ImageAdapter;)V", "imagesBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileImagesBinding;", "imagesUrl", "", "getImagesUrl", "setImagesUrl", "interestBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileInterestBinding;", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "layoutIds", "list", "Landroid/view/View;", "getList", "setList", "mSeekbarUpdateHandler", "Landroid/os/Handler;", "mStartPlaying", "", "mUpdateSeekbar", "Ljava/lang/Runnable;", "getMUpdateSeekbar", "()Ljava/lang/Runnable;", "setMUpdateSeekbar", "(Ljava/lang/Runnable;)V", "mainBinding", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerFormatCvBinding;", "getMainBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentSeekerFormatCvBinding;", "setMainBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentSeekerFormatCvBinding;)V", "maskDragListener", "Landroid/view/View$OnDragListener;", "ownedHardSkills", "Lcom/jobamax/appjobamax/model/HardSkill;", "ownedSoftSkills", "player", "Landroid/media/MediaPlayer;", "getPlayer", "()Landroid/media/MediaPlayer;", "setPlayer", "(Landroid/media/MediaPlayer;)V", "portfolioBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfilePortfolioBinding;", "scrolledY", "getScrolledY", "setScrolledY", "skillBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileSkillBinding;", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "volunteeringAdapter", "Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;", "getVolunteeringAdapter", "()Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;", "setVolunteeringAdapter", "(Lcom/jobamax/appjobamax/jobseeker/build_profile/SeekerVolunteeringAdapter;)V", "volunteeringBinding", "Lcom/jobamax/appjobamax/databinding/ItemProfileVolunteeringBinding;", "volunteerings", "Lcom/jobamax/appjobamax/model/Volunteering;", "getVolunteerings", "setVolunteerings", "attachViewDragListener", "", "changeSingleIconTheme", "imageView", "drawableId", "themeId", "changeStrokeColor", "tag", "firstColor", "secondColor", "changeTheme", "backgroundColor", "themeLightColor", "themeDarkColor", "themeIconStyle", "llThemeIconView", "Landroid/widget/LinearLayout;", "changeThemeButtonBackground", "layout", "configureUi", "confirmAllLayoutIds", "createChip", "label", "getOwnedSoftSkills", "initializePlayer", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPlay", "start", "removeBackgroundFromThemeButton", "setCardVisibility", "setChildViews", "setClickListeners", "setData", "setEducationAdapter", "setExperienceAdapter", "setImageAdapter", "setInterestTags", "setLayoutIds", "setObserver", "setPortfolio", "setSoftSkillTags", "setTheme", "setWorkspaceTags", "stopPlaying", "app_debug"})
public final class SeekerFormatCvFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentSeekerFormatCvBinding mainBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileBioBinding bioBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileEducationBinding educationBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileExperienceBinding experienceBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileSkillBinding skillBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileAudioVideoBinding audioVideoBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileVolunteeringBinding volunteeringBinding;
    private com.jobamax.appjobamax.databinding.ItemProfilePortfolioBinding portfolioBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileIdealWorkspaceBinding idealWorkspaceBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileInterestBinding interestBinding;
    private com.jobamax.appjobamax.databinding.ItemProfileImagesBinding imagesBinding;
    private int currentThemeIconStyle = com.jobamax.appjobamax.R.style.theme_blue;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer player;
    private boolean mStartPlaying = true;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Runnable mUpdateSeekbar;
    private final android.os.Handler mSeekbarUpdateHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    public com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter hardSkillAdapter;
    private java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> ownedHardSkills;
    private java.util.ArrayList<java.lang.String> ownedSoftSkills;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Experience> experiences;
    private com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter experienceAdapter;
    private com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter educationAdapter;
    private java.util.ArrayList<com.jobamax.appjobamax.model.Education> educations;
    public com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter volunteeringAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> volunteerings;
    private final java.util.HashMap<java.lang.Integer, android.widget.ImageView> imageViewAndDrawableIdMap = null;
    private java.util.ArrayList<java.lang.Integer> layoutIds;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<android.view.View> list;
    private int scrolledY = 0;
    public com.jobamax.appjobamax.jobseeker.profile.ImageAdapter imagesAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> imagesUrl;
    private final android.view.View.OnDragListener maskDragListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerFormatCvFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentSeekerFormatCvBinding getMainBinding() {
        return null;
    }
    
    public final void setMainBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentSeekerFormatCvBinding p0) {
    }
    
    public final int getCurrentThemeIconStyle() {
        return 0;
    }
    
    public final void setCurrentThemeIconStyle(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.media.MediaPlayer getPlayer() {
        return null;
    }
    
    public final void setPlayer(@org.jetbrains.annotations.Nullable()
    android.media.MediaPlayer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Runnable getMUpdateSeekbar() {
        return null;
    }
    
    public final void setMUpdateSeekbar(@org.jetbrains.annotations.Nullable()
    java.lang.Runnable p0) {
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
    public final com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter getHardSkillAdapter() {
        return null;
    }
    
    public final void setHardSkillAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter p0) {
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
    public final java.util.ArrayList<android.view.View> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<android.view.View> p0) {
    }
    
    public final int getScrolledY() {
        return 0;
    }
    
    public final void setScrolledY(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.profile.ImageAdapter getImagesAdapter() {
        return null;
    }
    
    public final void setImagesAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.profile.ImageAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getImagesUrl() {
        return null;
    }
    
    public final void setImagesUrl(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
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
    
    private final void setLayoutIds() {
    }
    
    private final void confirmAllLayoutIds() {
    }
    
    private final void setChildViews() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void attachViewDragListener() {
    }
    
    private final void setTheme() {
    }
    
    private final void changeSingleIconTheme(android.widget.ImageView imageView, int drawableId, int themeId) {
    }
    
    private final void setJobSeeker() {
    }
    
    private final void setObserver() {
    }
    
    private final void setData() {
    }
    
    private final void setCardVisibility() {
    }
    
    private final void setPortfolio() {
    }
    
    private final void setSoftSkillTags(int firstColor, int secondColor) {
    }
    
    private final void setWorkspaceTags(int firstColor, int secondColor) {
    }
    
    private final void setInterestTags(int firstColor, int secondColor) {
    }
    
    private final void setHardSkillAdapter() {
    }
    
    private final void getOwnedSoftSkills() {
    }
    
    private final android.view.View createChip(java.lang.String label, int firstColor, int secondColor) {
        return null;
    }
    
    private final void changeStrokeColor(android.view.View tag, int firstColor, int secondColor) {
    }
    
    private final void setImageAdapter() {
    }
    
    private final void setExperienceAdapter() {
    }
    
    private final void setEducationAdapter() {
    }
    
    private final void setVolunteeringAdapter() {
    }
    
    private final void onPlay(boolean start) {
    }
    
    private final void initializePlayer() {
    }
    
    private final void stopPlaying() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void changeTheme(int backgroundColor, int themeLightColor, int themeDarkColor, int themeIconStyle, android.widget.LinearLayout llThemeIconView) {
    }
    
    private final void changeThemeButtonBackground(android.widget.LinearLayout layout, int firstColor, int secondColor) {
    }
    
    private final void removeBackgroundFromThemeButton() {
    }
}