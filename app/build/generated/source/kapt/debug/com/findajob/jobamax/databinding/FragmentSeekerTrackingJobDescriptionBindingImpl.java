package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerTrackingJobDescriptionBindingImpl extends FragmentSeekerTrackingJobDescriptionBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 2);
        sViewsWithIds.put(R.id.iv_back_button, 3);
        sViewsWithIds.put(R.id.tv_page_title, 4);
        sViewsWithIds.put(R.id.cl_top_parent, 5);
        sViewsWithIds.put(R.id.constraintLayout13, 6);
        sViewsWithIds.put(R.id.iv_company, 7);
        sViewsWithIds.put(R.id.tv_job_title, 8);
        sViewsWithIds.put(R.id.tv_job_type, 9);
        sViewsWithIds.put(R.id.tv_company_address, 10);
        sViewsWithIds.put(R.id.iv_report, 11);
        sViewsWithIds.put(R.id.constraintLayout14, 12);
        sViewsWithIds.put(R.id.appCompatButton2, 13);
        sViewsWithIds.put(R.id.tv_company_name, 14);
        sViewsWithIds.put(R.id.ll_about_job, 15);
        sViewsWithIds.put(R.id.tv_title_about, 16);
        sViewsWithIds.put(R.id.tv_about_job, 17);
        sViewsWithIds.put(R.id.ll_about_company, 18);
        sViewsWithIds.put(R.id.tv_company_url, 19);
        sViewsWithIds.put(R.id.tv_about_company, 20);
        sViewsWithIds.put(R.id.ll_hard_skill, 21);
        sViewsWithIds.put(R.id.rv_hard_skill, 22);
        sViewsWithIds.put(R.id.ll_soft_skill, 23);
        sViewsWithIds.put(R.id.cg_soft_skill, 24);
        sViewsWithIds.put(R.id.ll_industry, 25);
        sViewsWithIds.put(R.id.tv_industry, 26);
        sViewsWithIds.put(R.id.ll_salary, 27);
        sViewsWithIds.put(R.id.ll_benefits, 28);
        sViewsWithIds.put(R.id.rv_hard_sklilsl, 29);
        sViewsWithIds.put(R.id.ll_workspace, 30);
        sViewsWithIds.put(R.id.cg_benefits, 31);
        sViewsWithIds.put(R.id.cl_overlay, 32);
        sViewsWithIds.put(R.id.tv_overlay_label, 33);
        sViewsWithIds.put(R.id.tv_job_offer_id, 34);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerTrackingJobDescriptionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 35, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerTrackingJobDescriptionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[13]
            , (com.google.android.material.chip.ChipGroup) bindings[31]
            , (com.google.android.material.chip.ChipGroup) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[32]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (android.widget.ImageView) bindings[3]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[7]
            , (android.widget.ImageView) bindings[11]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[30]
            , (android.widget.RelativeLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[29]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[16]
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
        java.lang.String jobSeekerProfilePicUrl = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivUserProfile, jobSeekerProfilePicUrl);
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