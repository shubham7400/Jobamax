package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerProfileBindingImpl extends FragmentSeekerProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView11, 3);
        sViewsWithIds.put(R.id.iv_back_button, 4);
        sViewsWithIds.put(R.id.imageView17, 5);
        sViewsWithIds.put(R.id.textView6, 6);
        sViewsWithIds.put(R.id.constraintLayout3, 7);
        sViewsWithIds.put(R.id.tv_aaa, 8);
        sViewsWithIds.put(R.id.tv_about_me_btn, 9);
        sViewsWithIds.put(R.id.tv_ddd, 10);
        sViewsWithIds.put(R.id.iv_info, 11);
        sViewsWithIds.put(R.id.rl_portfolio, 12);
        sViewsWithIds.put(R.id.tv_calender_title, 13);
        sViewsWithIds.put(R.id.iv_calender, 14);
        sViewsWithIds.put(R.id.tv_calender_titlef, 15);
        sViewsWithIds.put(R.id.iv_calvender, 16);
        sViewsWithIds.put(R.id.tv_calender_titlex, 17);
        sViewsWithIds.put(R.id.iv_calendxer, 18);
        sViewsWithIds.put(R.id.cl_education, 19);
        sViewsWithIds.put(R.id.textView7, 20);
        sViewsWithIds.put(R.id.textView8, 21);
        sViewsWithIds.put(R.id.cl_jobs, 22);
        sViewsWithIds.put(R.id.textView77, 23);
        sViewsWithIds.put(R.id.textView88, 24);
        sViewsWithIds.put(R.id.cl_volunteering_activities, 25);
        sViewsWithIds.put(R.id.textView76, 26);
        sViewsWithIds.put(R.id.textView86, 27);
        sViewsWithIds.put(R.id.cl_skills, 28);
        sViewsWithIds.put(R.id.textView73, 29);
        sViewsWithIds.put(R.id.textView83, 30);
        sViewsWithIds.put(R.id.iv_add_ideal_workspace_btn, 31);
        sViewsWithIds.put(R.id.et_ideal_workspace, 32);
        sViewsWithIds.put(R.id.cg_ideal_workspace, 33);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final de.hdodenhof.circleimageview.CircleImageView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 34, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[33]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[19]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[22]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[28]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[25]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (android.widget.AutoCompleteTextView) bindings[32]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[31]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[23]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (de.hdodenhof.circleimageview.CircleImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.tvSeekerName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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

        if ((dirtyFlags & 0x3L) != 0) {



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
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.mboundView2, jobSeekerProfilePicUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSeekerName, javaLangStringHelloJobSeekerFirstName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}