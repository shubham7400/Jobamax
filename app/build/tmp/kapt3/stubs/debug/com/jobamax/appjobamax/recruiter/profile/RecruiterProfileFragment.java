package com.jobamax.appjobamax.recruiter.profile;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentRecruiterProfileBinding;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.DialogSeePostJobOfferInfo;
import com.jobamax.appjobamax.recruiter.profile.setting.RecruiterSettingActivity;
import com.jobamax.appjobamax.util.ImagePicker;
import com.parse.ParseFile;
import com.parse.SaveCallback;
import kotlinx.coroutines.Dispatchers;
import java.io.InputStream;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\u001a\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J&\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020+2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020\u001d03H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00065"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/profile/RecruiterProfileFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "Lcom/jobamax/appjobamax/util/ImagePicker$GetImage;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterProfileBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterProfileBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterProfileBinding;)V", "imagePicker", "Lcom/jobamax/appjobamax/util/ImagePicker;", "getImagePicker", "()Lcom/jobamax/appjobamax/util/ImagePicker;", "setImagePicker", "(Lcom/jobamax/appjobamax/util/ImagePicker;)V", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "initializeRecruiter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "setData", "setImageUri", "imageUri", "Landroid/net/Uri;", "requestCode", "", "setObserver", "setupImagePicker", "uploadImage", "profilePicUri", "callback", "Lkotlin/Function1;", "", "app_debug"})
public final class RecruiterProfileFragment extends com.jobamax.appjobamax.base.BaseFragment implements com.jobamax.appjobamax.util.ImagePicker.GetImage {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterProfileBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    public com.jobamax.appjobamax.util.ImagePicker imagePicker;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterProfileFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterProfileBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterProfileBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    public final void setRecruiter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.Recruiter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.util.ImagePicker getImagePicker() {
        return null;
    }
    
    public final void setImagePicker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.util.ImagePicker p0) {
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
    
    private final void initializeRecruiter() {
    }
    
    private final void setObserver() {
    }
    
    private final void setData() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void setupImagePicker() {
    }
    
    @java.lang.Override()
    public void setImageUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri, int requestCode) {
    }
    
    private final void uploadImage(android.net.Uri profilePicUri, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> callback) {
    }
}