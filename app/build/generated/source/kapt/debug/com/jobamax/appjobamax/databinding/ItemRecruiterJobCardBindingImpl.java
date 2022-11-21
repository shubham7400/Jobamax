package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemRecruiterJobCardBindingImpl extends ItemRecruiterJobCardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_most_parent, 1);
        sViewsWithIds.put(R.id.cl_profile_iv, 2);
        sViewsWithIds.put(R.id.circleImageView, 3);
        sViewsWithIds.put(R.id.tv_matched_per, 4);
        sViewsWithIds.put(R.id.tv_seeker_name, 5);
        sViewsWithIds.put(R.id.ll_university, 6);
        sViewsWithIds.put(R.id.tv_university_name, 7);
        sViewsWithIds.put(R.id.ll_job_title, 8);
        sViewsWithIds.put(R.id.tv_job_name, 9);
        sViewsWithIds.put(R.id.ll_work_type, 10);
        sViewsWithIds.put(R.id.tv_work_types, 11);
        sViewsWithIds.put(R.id.cl_job_location, 12);
        sViewsWithIds.put(R.id.iv_location_point, 13);
        sViewsWithIds.put(R.id.tv_job_location, 14);
        sViewsWithIds.put(R.id.ll_education, 15);
        sViewsWithIds.put(R.id.tv_education, 16);
        sViewsWithIds.put(R.id.cg_matches, 17);
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
        sViewsWithIds.put(R.id.cl_overlay, 30);
        sViewsWithIds.put(R.id.tv_overlay_label, 31);
        sViewsWithIds.put(R.id.tv_job_seeker_id, 32);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemRecruiterJobCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds));
    }
    private ItemRecruiterJobCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[25]
            , (com.google.android.material.chip.ChipGroup) bindings[17]
            , (com.google.android.material.chip.ChipGroup) bindings[23]
            , (com.google.android.material.chip.ChipGroup) bindings[29]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[30]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (androidx.recyclerview.widget.RecyclerView) bindings[21]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (androidx.recyclerview.widget.RecyclerView) bindings[28]
            , (androidx.recyclerview.widget.RecyclerView) bindings[27]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            );
        this.rootLayout.setTag(null);
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