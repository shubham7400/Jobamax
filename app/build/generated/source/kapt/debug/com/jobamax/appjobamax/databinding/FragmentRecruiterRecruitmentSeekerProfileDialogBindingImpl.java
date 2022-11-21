package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterRecruitmentSeekerProfileDialogBindingImpl extends FragmentRecruiterRecruitmentSeekerProfileDialogBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_most_parent, 1);
        sViewsWithIds.put(R.id.iv_close, 2);
        sViewsWithIds.put(R.id.cl_profile_iv, 3);
        sViewsWithIds.put(R.id.circleImageView, 4);
        sViewsWithIds.put(R.id.tv_matched_per, 5);
        sViewsWithIds.put(R.id.tv_seeker_name, 6);
        sViewsWithIds.put(R.id.ll_university, 7);
        sViewsWithIds.put(R.id.tv_university_name, 8);
        sViewsWithIds.put(R.id.ll_job_title, 9);
        sViewsWithIds.put(R.id.tv_job_name, 10);
        sViewsWithIds.put(R.id.ll_work_type, 11);
        sViewsWithIds.put(R.id.tv_work_types, 12);
        sViewsWithIds.put(R.id.cl_job_location, 13);
        sViewsWithIds.put(R.id.iv_location_point, 14);
        sViewsWithIds.put(R.id.tv_job_location, 15);
        sViewsWithIds.put(R.id.ll_education, 16);
        sViewsWithIds.put(R.id.tv_education, 17);
        sViewsWithIds.put(R.id.ll_full_des, 18);
        sViewsWithIds.put(R.id.tv_bio, 19);
        sViewsWithIds.put(R.id.rv_education, 20);
        sViewsWithIds.put(R.id.rv_experience, 21);
        sViewsWithIds.put(R.id.rv_hard_skill, 22);
        sViewsWithIds.put(R.id.cg_soft_skill_tags, 23);
        sViewsWithIds.put(R.id.rv_volunteering, 24);
        sViewsWithIds.put(R.id.cg_interests, 25);
        sViewsWithIds.put(R.id.rv_portfolio_doc_link, 26);
        sViewsWithIds.put(R.id.rv_portfolio_link, 27);
        sViewsWithIds.put(R.id.rv_portfolio_images, 28);
        sViewsWithIds.put(R.id.cg_workspace, 29);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecruiterRecruitmentSeekerProfileDialogBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterRecruitmentSeekerProfileDialogBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[25]
            , (com.google.android.material.chip.ChipGroup) bindings[23]
            , (com.google.android.material.chip.ChipGroup) bindings[29]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (androidx.recyclerview.widget.RecyclerView) bindings[21]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (androidx.recyclerview.widget.RecyclerView) bindings[28]
            , (androidx.recyclerview.widget.RecyclerView) bindings[27]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[12]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}