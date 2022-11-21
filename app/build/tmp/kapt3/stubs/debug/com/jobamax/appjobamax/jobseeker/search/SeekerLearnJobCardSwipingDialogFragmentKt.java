package com.jobamax.appjobamax.jobseeker.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentSeekerLearnJobCardSwipingDialogBinding;
import com.jobamax.appjobamax.databinding.ItemLearnJobCardSwipingBinding;
import com.jobamax.appjobamax.enums.LearnSwipeCardName;
import com.jobamax.appjobamax.jobseeker.model.SearchJobCardSwipingTutorial;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0004"}, d2 = {"SWIPE_LEFT", "", "SWIPE_RIGHT", "SWIPE_TOP", "app_debug"})
public final class SeekerLearnJobCardSwipingDialogFragmentKt {
    public static final int SWIPE_LEFT = 1;
    public static final int SWIPE_TOP = 2;
    public static final int SWIPE_RIGHT = 3;
}