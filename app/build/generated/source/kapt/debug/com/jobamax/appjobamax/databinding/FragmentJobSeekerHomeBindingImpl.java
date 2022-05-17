package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerHomeBindingImpl extends FragmentJobSeekerHomeBinding  {

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
        sViewsWithIds.put(R.id.bt_job_search, 6);
        sViewsWithIds.put(R.id.ll1, 7);
        sViewsWithIds.put(R.id.v_profile, 8);
        sViewsWithIds.put(R.id.tv_aa, 9);
        sViewsWithIds.put(R.id.v_calendar, 10);
        sViewsWithIds.put(R.id.iv_calender, 11);
        sViewsWithIds.put(R.id.tv_calender_title, 12);
        sViewsWithIds.put(R.id.ll2, 13);
        sViewsWithIds.put(R.id.v_track, 14);
        sViewsWithIds.put(R.id.image_user2, 15);
        sViewsWithIds.put(R.id.textView28, 16);
        sViewsWithIds.put(R.id.v_wishlist, 17);
        sViewsWithIds.put(R.id.rl_abcd, 18);
        sViewsWithIds.put(R.id.tv_ef, 19);
        sViewsWithIds.put(R.id.iv_right_arrow, 20);
        sViewsWithIds.put(R.id.constraintLayout15, 21);
        sViewsWithIds.put(R.id.cl_img1, 22);
        sViewsWithIds.put(R.id.iv_3, 23);
        sViewsWithIds.put(R.id.cl_img2, 24);
        sViewsWithIds.put(R.id.iv_2, 25);
        sViewsWithIds.put(R.id.cl_img3, 26);
        sViewsWithIds.put(R.id.iv_1, 27);
        sViewsWithIds.put(R.id.btn_coaching, 28);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[6]
            , (android.widget.Button) bindings[28]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[22]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[26]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[21]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.RelativeLayout) bindings[18]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[17]
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
                mDirtyFlags = 0x8L;
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
            setJobSeeker((com.jobamax.appjobamax.model.JobSeeker) variable);
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

    public void setJobSeeker(@Nullable com.jobamax.appjobamax.model.JobSeeker JobSeeker) {
        this.mJobSeeker = JobSeeker;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.jobSeeker);
        super.requestRebind();
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
        java.lang.String javaLangStringHelloJobSeekerFirstNameChar = null;
        java.lang.String javaLangStringHelloJobSeekerFirstName = null;
        java.lang.String jobSeekerProfilePicUrl = null;
        com.jobamax.appjobamax.model.JobSeeker jobSeeker = mJobSeeker;
        java.lang.String javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastName = null;
        java.lang.String jobSeekerFirstName = null;
        java.lang.String javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastNameJavaLangString = null;
        java.lang.String jobSeekerLastName = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                    // read jobSeeker.lastName
                    jobSeekerLastName = jobSeeker.getLastName();
                }


                // read ("Hello ") + (jobSeeker.firstName)
                javaLangStringHelloJobSeekerFirstName = ("Hello ") + (jobSeekerFirstName);


                // read (("Hello ") + (jobSeeker.firstName)) + (' ')
                javaLangStringHelloJobSeekerFirstNameChar = (javaLangStringHelloJobSeekerFirstName) + (' ');


                // read ((("Hello ") + (jobSeeker.firstName)) + (' ')) + (jobSeeker.lastName)
                javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastName = (javaLangStringHelloJobSeekerFirstNameChar) + (jobSeekerLastName);


                // read (((("Hello ") + (jobSeeker.firstName)) + (' ')) + (jobSeeker.lastName)) + (",")
                javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastNameJavaLangString = (javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastName) + (",");
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.jobamax.appjobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.imageUser, jobSeekerProfilePicUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSeekerName, javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastNameJavaLangString);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): state
        flag 2 (0x3L): trackToggleFlag
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}