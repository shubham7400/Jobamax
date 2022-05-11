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
        sViewsWithIds.put(R.id.cl_header, 3);
        sViewsWithIds.put(R.id.iv_back_button, 4);
        sViewsWithIds.put(R.id.iv_job_search, 5);
        sViewsWithIds.put(R.id.iv_preview, 6);
        sViewsWithIds.put(R.id.textView6, 7);
        sViewsWithIds.put(R.id.constraintLayout3, 8);
        sViewsWithIds.put(R.id.tv_elevetor_pitch_section, 9);
        sViewsWithIds.put(R.id.tv_about_me_btn, 10);
        sViewsWithIds.put(R.id.tv_ddd, 11);
        sViewsWithIds.put(R.id.iv_ideal_job_info, 12);
        sViewsWithIds.put(R.id.rl_ideal_job_video, 13);
        sViewsWithIds.put(R.id.tv_ideal_job_video_title, 14);
        sViewsWithIds.put(R.id.iv_ideal_job_video, 15);
        sViewsWithIds.put(R.id.rl_ideal_job_message, 16);
        sViewsWithIds.put(R.id.tv_ideal_job_message_title, 17);
        sViewsWithIds.put(R.id.iv_ideal_job_message, 18);
        sViewsWithIds.put(R.id.rl_ideal_job_audio, 19);
        sViewsWithIds.put(R.id.tv_ideal_job_audio_title, 20);
        sViewsWithIds.put(R.id.iv_ideal_job_audio, 21);
        sViewsWithIds.put(R.id.tv_import_resume_btn, 22);
        sViewsWithIds.put(R.id.cl_education, 23);
        sViewsWithIds.put(R.id.textView7, 24);
        sViewsWithIds.put(R.id.textView8, 25);
        sViewsWithIds.put(R.id.cl_jobs, 26);
        sViewsWithIds.put(R.id.textView77, 27);
        sViewsWithIds.put(R.id.textView88, 28);
        sViewsWithIds.put(R.id.cl_volunteering, 29);
        sViewsWithIds.put(R.id.textView76, 30);
        sViewsWithIds.put(R.id.textView86, 31);
        sViewsWithIds.put(R.id.cl_skills, 32);
        sViewsWithIds.put(R.id.textView73, 33);
        sViewsWithIds.put(R.id.textView83, 34);
        sViewsWithIds.put(R.id.cl_interest, 35);
        sViewsWithIds.put(R.id.textViedw76, 36);
        sViewsWithIds.put(R.id.textView86d, 37);
        sViewsWithIds.put(R.id.cl_images, 38);
        sViewsWithIds.put(R.id.textViedwf76, 39);
        sViewsWithIds.put(R.id.textViewx86d, 40);
        sViewsWithIds.put(R.id.tv_dddd, 41);
        sViewsWithIds.put(R.id.iv_portfolio_info, 42);
        sViewsWithIds.put(R.id.rl_portfolio_video, 43);
        sViewsWithIds.put(R.id.tv_portfolio_video_title, 44);
        sViewsWithIds.put(R.id.iv_calender, 45);
        sViewsWithIds.put(R.id.rl_portfolio_message, 46);
        sViewsWithIds.put(R.id.tv_calender_titlef, 47);
        sViewsWithIds.put(R.id.iv_calvender, 48);
        sViewsWithIds.put(R.id.rl_portfolio_image, 49);
        sViewsWithIds.put(R.id.tv_portfolio_images_title, 50);
        sViewsWithIds.put(R.id.iv_calendxer, 51);
        sViewsWithIds.put(R.id.iv_add_ideal_workspace_btn, 52);
        sViewsWithIds.put(R.id.et_ideal_workspace, 53);
        sViewsWithIds.put(R.id.cg_ideal_workspace, 54);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 55, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[54]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[23]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[38]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[35]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[26]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[32]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[29]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.AutoCompleteTextView) bindings[53]
            , (android.widget.ImageView) bindings[52]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[45]
            , (android.widget.ImageView) bindings[51]
            , (android.widget.ImageView) bindings[48]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[42]
            , (android.widget.ImageView) bindings[6]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.RelativeLayout) bindings[19]
            , (android.widget.RelativeLayout) bindings[16]
            , (android.widget.RelativeLayout) bindings[13]
            , (android.widget.RelativeLayout) bindings[49]
            , (android.widget.RelativeLayout) bindings[46]
            , (android.widget.RelativeLayout) bindings[43]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[39]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[27]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.ImageView) bindings[34]
            , (android.widget.ImageView) bindings[31]
            , (android.widget.ImageView) bindings[37]
            , (android.widget.ImageView) bindings[28]
            , (android.widget.ImageView) bindings[40]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[50]
            , (android.widget.TextView) bindings[44]
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
        java.lang.String javaLangStringHelloJobSeekerFirstNameChar = null;
        java.lang.String javaLangStringHelloJobSeekerFirstName = null;
        java.lang.String jobSeekerProfilePicUrl = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;
        java.lang.String javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastName = null;
        java.lang.String jobSeekerLastName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                    // read jobSeeker.lastName
                    jobSeekerLastName = jobSeeker.getLastName();
                }


                // read ("Hello ") + (jobSeeker.firstName)
                javaLangStringHelloJobSeekerFirstName = ("Hello ") + (jobSeekerFirstName);


                // read (("Hello ") + (jobSeeker.firstName)) + (' ')
                javaLangStringHelloJobSeekerFirstNameChar = (javaLangStringHelloJobSeekerFirstName) + (' ');


                // read ((("Hello ") + (jobSeeker.firstName)) + (' ')) + (jobSeeker.lastName)
                javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastName = (javaLangStringHelloJobSeekerFirstNameChar) + (jobSeekerLastName);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivUser, jobSeekerProfilePicUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSeekerName, javaLangStringHelloJobSeekerFirstNameCharJobSeekerLastName);
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