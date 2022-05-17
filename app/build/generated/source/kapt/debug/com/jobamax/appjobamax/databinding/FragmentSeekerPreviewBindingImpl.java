package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerPreviewBindingImpl extends FragmentSeekerPreviewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 2);
        sViewsWithIds.put(R.id.iv_back_button, 3);
        sViewsWithIds.put(R.id.linearLayoutCompat2s, 4);
        sViewsWithIds.put(R.id.constraintLayout12, 5);
        sViewsWithIds.put(R.id.civ_seeker, 6);
        sViewsWithIds.put(R.id.tv_seeker_name, 7);
        sViewsWithIds.put(R.id.tv_seeker_profession, 8);
        sViewsWithIds.put(R.id.linearLayout7, 9);
        sViewsWithIds.put(R.id.iv_instagram, 10);
        sViewsWithIds.put(R.id.iv_linkedin, 11);
        sViewsWithIds.put(R.id.iv_tiktok, 12);
        sViewsWithIds.put(R.id.tv_about_title, 13);
        sViewsWithIds.put(R.id.tv_seeker_about, 14);
        sViewsWithIds.put(R.id.tv_school, 15);
        sViewsWithIds.put(R.id.rv_school, 16);
        sViewsWithIds.put(R.id.tv_experience, 17);
        sViewsWithIds.put(R.id.rv_experience, 18);
        sViewsWithIds.put(R.id.iv_see_less_experience, 19);
        sViewsWithIds.put(R.id.iv_see_more_experience, 20);
        sViewsWithIds.put(R.id.tv_hard_skill, 21);
        sViewsWithIds.put(R.id.rv_hard_skill, 22);
        sViewsWithIds.put(R.id.tv_soft_skill, 23);
        sViewsWithIds.put(R.id.cg_soft_skill, 24);
        sViewsWithIds.put(R.id.tv_volunteering_title, 25);
        sViewsWithIds.put(R.id.rv_volunteering, 26);
        sViewsWithIds.put(R.id.tv_interest, 27);
        sViewsWithIds.put(R.id.cg_activities, 28);
        sViewsWithIds.put(R.id.tv_ideal_job_title, 29);
        sViewsWithIds.put(R.id.tv_ideal_job_description, 30);
        sViewsWithIds.put(R.id.cv_ideal_job_video, 31);
        sViewsWithIds.put(R.id.iv_ideal_job_video, 32);
        sViewsWithIds.put(R.id.rv_ideal_job_images, 33);
        sViewsWithIds.put(R.id.cl_audio_player, 34);
        sViewsWithIds.put(R.id.iv_audio_play_btn, 35);
        sViewsWithIds.put(R.id.sb_audio, 36);
        sViewsWithIds.put(R.id.tv_audio_duration, 37);
        sViewsWithIds.put(R.id.tv_ideal_workspace_title, 38);
        sViewsWithIds.put(R.id.cg_ideal_workspace, 39);
        sViewsWithIds.put(R.id.tv_portfolio_title, 40);
        sViewsWithIds.put(R.id.tv_portfolio_description, 41);
        sViewsWithIds.put(R.id.cv_portfolio_video, 42);
        sViewsWithIds.put(R.id.iv_portfolio_video, 43);
        sViewsWithIds.put(R.id.rv_portfolio_images, 44);
        sViewsWithIds.put(R.id.cl_portfolio_audio_player, 45);
        sViewsWithIds.put(R.id.ll_links, 46);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerPreviewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 47, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerPreviewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[28]
            , (com.google.android.material.chip.ChipGroup) bindings[39]
            , (com.google.android.material.chip.ChipGroup) bindings[24]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[34]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[45]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[31]
            , (androidx.cardview.widget.CardView) bindings[42]
            , (android.widget.ImageView) bindings[35]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[32]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[43]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[12]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[9]
            , (androidx.core.widget.NestedScrollView) bindings[4]
            , (android.widget.LinearLayout) bindings[46]
            , (android.widget.RelativeLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[33]
            , (androidx.recyclerview.widget.RecyclerView) bindings[44]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (android.widget.SeekBar) bindings[36]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[37]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[40]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[25]
            );
        this.ivUserProfile.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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
            setJobSeeker((com.jobamax.appjobamax.model.JobSeeker) variable);
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
        java.lang.String jobSeekerProfilePicUrl = null;
        com.jobamax.appjobamax.model.JobSeeker jobSeeker = mJobSeeker;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.jobamax.appjobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivUserProfile, jobSeekerProfilePicUrl);
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