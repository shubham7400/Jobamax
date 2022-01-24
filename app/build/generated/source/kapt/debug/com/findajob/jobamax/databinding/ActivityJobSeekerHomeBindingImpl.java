package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityJobSeekerHomeBindingImpl extends ActivityJobSeekerHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView10, 3);
        sViewsWithIds.put(R.id.iv_setting, 4);
        sViewsWithIds.put(R.id.textView6, 5);
        sViewsWithIds.put(R.id.ll1, 6);
        sViewsWithIds.put(R.id.v_profile, 7);
        sViewsWithIds.put(R.id.v_message, 8);
        sViewsWithIds.put(R.id.iv_message_icon, 9);
        sViewsWithIds.put(R.id.tv_message_count_title, 10);
        sViewsWithIds.put(R.id.v_calendar, 11);
        sViewsWithIds.put(R.id.tv_calender_title, 12);
        sViewsWithIds.put(R.id.bt_job_search, 13);
        sViewsWithIds.put(R.id.ll2, 14);
        sViewsWithIds.put(R.id.v_track, 15);
        sViewsWithIds.put(R.id.image_user2, 16);
        sViewsWithIds.put(R.id.v_wishlist, 17);
        sViewsWithIds.put(R.id.rl_abcd, 18);
        sViewsWithIds.put(R.id.tv_ef, 19);
        sViewsWithIds.put(R.id.iv_right_arrow, 20);
        sViewsWithIds.put(R.id.image_user3, 21);
        sViewsWithIds.put(R.id.image_user35, 22);
        sViewsWithIds.put(R.id.image_user3w, 23);
        sViewsWithIds.put(R.id.btn_coaching, 24);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityJobSeekerHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private ActivityJobSeekerHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[13]
            , (android.widget.Button) bindings[24]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[16]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[21]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[22]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[23]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.RelativeLayout) bindings[18]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[1]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[15]
            , (android.widget.RelativeLayout) bindings[17]
            );
        this.imageUser.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.tvSeekerName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.jobSeeker == variableId) {
            setJobSeeker((com.findajob.jobamax.model.JobSeeker) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface) variable);
        }
        else if (BR.state == variableId) {
            setState((java.lang.Integer) variable);
        }
        else if (BR.trackToggleFlag == variableId) {
            setTrackToggleFlag((java.lang.Boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setJobSeeker(@Nullable com.findajob.jobamax.model.JobSeeker JobSeeker) {
        this.mJobSeeker = JobSeeker;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.jobSeeker);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface Handler) {
        this.mHandler = Handler;
    }
    public void setState(@Nullable java.lang.Integer State) {
        this.mState = State;
    }
    public void setTrackToggleFlag(@Nullable java.lang.Boolean TrackToggleFlag) {
        this.mTrackToggleFlag = TrackToggleFlag;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String javaLangStringHelloJobSeekerFirstName = null;
        java.lang.String jobSeekerProfilePicUrl = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;
        java.lang.String jobSeekerFirstName = null;

        if ((dirtyFlags & 0x11L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                }


                // read ("Hello ") + (jobSeeker.firstName)
                javaLangStringHelloJobSeekerFirstName = ("Hello ") + (jobSeekerFirstName);
        }
        // batch finished
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.imageUser, jobSeekerProfilePicUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSeekerName, javaLangStringHelloJobSeekerFirstName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): handler
        flag 2 (0x3L): state
        flag 3 (0x4L): trackToggleFlag
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}