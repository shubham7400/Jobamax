package com.jobamax.appjobamax.jobseeker.chat;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.common.api.Api;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseActivity;
import com.jobamax.appjobamax.databinding.*;
import com.jobamax.appjobamax.jobseeker.dialog.ReportDialog;
import com.jobamax.appjobamax.enums.*;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.ChatThread;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.Message;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient;
import com.jobamax.appjobamax.util.*;
import com.parse.*;
import com.parse.livequery.ParseLiveQueryClient;
import com.parse.livequery.SubscriptionHandling;
import id.zelory.compressor.Compressor;
import kotlinx.coroutines.Dispatchers;
import java.io.File;
import java.io.IOException;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"TYPE_AUDIO", "", "TYPE_IMAGE", "TYPE_TEXT", "TYPE_THUMB", "TYPE_VIDEO", "app_debug"})
public final class SeekerChatBoardActivityKt {
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_THUMB = 4;
}