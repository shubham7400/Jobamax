package com.jobamax.appjobamax.jobseeker.build_profile;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.*;
import android.widget.*;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.*;
import com.jobamax.appjobamax.dialog.*;
import com.jobamax.appjobamax.enums.LinkType;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.extensions.*;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddDocument;
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddLink;
import com.jobamax.appjobamax.jobseeker.dialog.DialogWorkType;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
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

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0004"}, d2 = {"PORTFOLIO_IMAGES_REQUEST_CODE", "", "PROFILE_IMAGE_REQUEST_CODE", "USER_IMAGES_REQUEST_CODE", "app_debug"})
public final class ModifyProfileFragmentKt {
    public static final int PROFILE_IMAGE_REQUEST_CODE = 1;
    public static final int USER_IMAGES_REQUEST_CODE = 2;
    public static final int PORTFOLIO_IMAGES_REQUEST_CODE = 3;
}