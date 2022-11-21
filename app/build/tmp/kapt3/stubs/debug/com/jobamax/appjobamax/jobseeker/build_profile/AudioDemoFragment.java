package com.jobamax.appjobamax.jobseeker.build_profile;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentAudioDemoBinding;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.JobSeeker;
import java.io.IOException;
import java.lang.Exception;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020&H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\u00a8\u00066"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/AudioDemoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentAudioDemoBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentAudioDemoBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentAudioDemoBinding;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "mSeekbarUpdateHandler", "Landroid/os/Handler;", "mStartPlaying", "", "mUpdateSeekbar", "Ljava/lang/Runnable;", "getMUpdateSeekbar", "()Ljava/lang/Runnable;", "setMUpdateSeekbar", "(Ljava/lang/Runnable;)V", "player", "Landroid/media/MediaPlayer;", "getPlayer", "()Landroid/media/MediaPlayer;", "setPlayer", "(Landroid/media/MediaPlayer;)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "initializeJobSeeker", "initializePlayer", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPlay", "start", "setClickListeners", "setData", "stopPlaying", "app_debug"})
public final class AudioDemoFragment extends androidx.fragment.app.Fragment {
    public com.jobamax.appjobamax.databinding.FragmentAudioDemoBinding binding;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer player;
    private boolean mStartPlaying = true;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Runnable mUpdateSeekbar;
    private final android.os.Handler mSeekbarUpdateHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public AudioDemoFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentAudioDemoBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentAudioDemoBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.JobSeeker p0) {
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
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    private final void initializeJobSeeker() {
    }
    
    private final void setData() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void onPlay(boolean start) {
    }
    
    private final void initializePlayer() {
    }
    
    private final void stopPlaying() {
    }
}