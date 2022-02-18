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
        sViewsWithIds.put(R.id.iv_preview, 5);
        sViewsWithIds.put(R.id.textView6, 6);
        sViewsWithIds.put(R.id.constraintLayout3, 7);
        sViewsWithIds.put(R.id.tv_aaa, 8);
        sViewsWithIds.put(R.id.tv_about_me_btn, 9);
        sViewsWithIds.put(R.id.tv_ddd, 10);
        sViewsWithIds.put(R.id.iv_info, 11);
        sViewsWithIds.put(R.id.rl_ideal_job_video, 12);
        sViewsWithIds.put(R.id.tv_ideal_job_video_title, 13);
        sViewsWithIds.put(R.id.iv_ideal_job_video, 14);
        sViewsWithIds.put(R.id.rl_ideal_job_message, 15);
        sViewsWithIds.put(R.id.tv_ideal_job_message_title, 16);
        sViewsWithIds.put(R.id.iv_ideal_job_message, 17);
        sViewsWithIds.put(R.id.rl_ideal_job_image, 18);
        sViewsWithIds.put(R.id.tv_ideal_job_image_title, 19);
        sViewsWithIds.put(R.id.iv_ideal_job_image, 20);
        sViewsWithIds.put(R.id.rl_ideal_job_audio, 21);
        sViewsWithIds.put(R.id.tv_ideal_job_audio_title, 22);
        sViewsWithIds.put(R.id.iv_ideal_job_audio, 23);
        sViewsWithIds.put(R.id.tv_import_resume_btn, 24);
        sViewsWithIds.put(R.id.cl_education, 25);
        sViewsWithIds.put(R.id.textView7, 26);
        sViewsWithIds.put(R.id.textView8, 27);
        sViewsWithIds.put(R.id.cl_jobs, 28);
        sViewsWithIds.put(R.id.textView77, 29);
        sViewsWithIds.put(R.id.textView88, 30);
        sViewsWithIds.put(R.id.cl_volunteering, 31);
        sViewsWithIds.put(R.id.textView76, 32);
        sViewsWithIds.put(R.id.textView86, 33);
        sViewsWithIds.put(R.id.cl_skills, 34);
        sViewsWithIds.put(R.id.textView73, 35);
        sViewsWithIds.put(R.id.textView83, 36);
        sViewsWithIds.put(R.id.cl_interest, 37);
        sViewsWithIds.put(R.id.textViedw76, 38);
        sViewsWithIds.put(R.id.textView86d, 39);
        sViewsWithIds.put(R.id.rl_portfolio_video, 40);
        sViewsWithIds.put(R.id.tv_calender_title, 41);
        sViewsWithIds.put(R.id.iv_calender, 42);
        sViewsWithIds.put(R.id.rl_portfolio_message, 43);
        sViewsWithIds.put(R.id.tv_calender_titlef, 44);
        sViewsWithIds.put(R.id.iv_calvender, 45);
        sViewsWithIds.put(R.id.rl_portfolio_image, 46);
        sViewsWithIds.put(R.id.tv_calender_titlex, 47);
        sViewsWithIds.put(R.id.iv_calendxer, 48);
        sViewsWithIds.put(R.id.iv_add_ideal_workspace_btn, 49);
        sViewsWithIds.put(R.id.et_ideal_workspace, 50);
        sViewsWithIds.put(R.id.cg_ideal_workspace, 51);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 52, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[51]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[25]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[37]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[28]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[34]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[31]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (android.widget.AutoCompleteTextView) bindings[50]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[49]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[42]
            , (android.widget.ImageView) bindings[48]
            , (android.widget.ImageView) bindings[45]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[5]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.RelativeLayout) bindings[21]
            , (android.widget.RelativeLayout) bindings[18]
            , (android.widget.RelativeLayout) bindings[15]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[46]
            , (android.widget.RelativeLayout) bindings[43]
            , (android.widget.RelativeLayout) bindings[40]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[29]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.ImageView) bindings[33]
            , (android.widget.ImageView) bindings[39]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[44]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[1]
            );
        this.ivUser.setTag(null);
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
        java.lang.String jobSeekerFirstName = null;
        java.lang.String javaLangStringHelloJobSeekerFirstName = null;
        java.lang.String jobSeekerProfilePicUrl = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }


                // read ("Hello ") + (jobSeeker.firstName)
                javaLangStringHelloJobSeekerFirstName = ("Hello ") + (jobSeekerFirstName);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivUser, jobSeekerProfilePicUrl);
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