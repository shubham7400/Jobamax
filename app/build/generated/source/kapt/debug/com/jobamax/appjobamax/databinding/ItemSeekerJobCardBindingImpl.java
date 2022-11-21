package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemSeekerJobCardBindingImpl extends ItemSeekerJobCardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_swipe_count, 1);
        sViewsWithIds.put(R.id.iv_online, 2);
        sViewsWithIds.put(R.id.ll_most_parent, 3);
        sViewsWithIds.put(R.id.cl_profile_iv, 4);
        sViewsWithIds.put(R.id.circleImageView, 5);
        sViewsWithIds.put(R.id.tv_company_name2, 6);
        sViewsWithIds.put(R.id.tv_company_name, 7);
        sViewsWithIds.put(R.id.ll_job_title, 8);
        sViewsWithIds.put(R.id.iv_job_post, 9);
        sViewsWithIds.put(R.id.tv_job_name, 10);
        sViewsWithIds.put(R.id.linearLayout10, 11);
        sViewsWithIds.put(R.id.ll_work_type, 12);
        sViewsWithIds.put(R.id.iv_search, 13);
        sViewsWithIds.put(R.id.tv_work_types, 14);
        sViewsWithIds.put(R.id.ll_job_location, 15);
        sViewsWithIds.put(R.id.iv_location_point, 16);
        sViewsWithIds.put(R.id.tv_job_location, 17);
        sViewsWithIds.put(R.id.cg_tags, 18);
        sViewsWithIds.put(R.id.ll_job_desc, 19);
        sViewsWithIds.put(R.id.tv_job_description, 20);
        sViewsWithIds.put(R.id.ll_salary, 21);
        sViewsWithIds.put(R.id.tv_salary, 22);
        sViewsWithIds.put(R.id.ll_match, 23);
        sViewsWithIds.put(R.id.ll_match_with_profile, 24);
        sViewsWithIds.put(R.id.sb_education, 25);
        sViewsWithIds.put(R.id.cg_education_tags, 26);
        sViewsWithIds.put(R.id.ll_experience, 27);
        sViewsWithIds.put(R.id.sb_experience, 28);
        sViewsWithIds.put(R.id.cg_experience_tags, 29);
        sViewsWithIds.put(R.id.sb_hard_skill, 30);
        sViewsWithIds.put(R.id.cg_hard_skill_tags, 31);
        sViewsWithIds.put(R.id.sb_soft_skill, 32);
        sViewsWithIds.put(R.id.cg_soft_skill_tags, 33);
        sViewsWithIds.put(R.id.tv_55, 34);
        sViewsWithIds.put(R.id.tv_criteria_location, 35);
        sViewsWithIds.put(R.id.tv_57, 36);
        sViewsWithIds.put(R.id.tv_criteria_contract, 37);
        sViewsWithIds.put(R.id.ll_job_search, 38);
        sViewsWithIds.put(R.id.tv_58, 39);
        sViewsWithIds.put(R.id.tv_criteria_job_search_keyword, 40);
        sViewsWithIds.put(R.id.ll_job_desc2, 41);
        sViewsWithIds.put(R.id.tv_job_description2, 42);
        sViewsWithIds.put(R.id.tv_description, 43);
        sViewsWithIds.put(R.id.ll_salary2, 44);
        sViewsWithIds.put(R.id.tv_salary2, 45);
        sViewsWithIds.put(R.id.cl_overlay, 46);
        sViewsWithIds.put(R.id.tv_overlay_label, 47);
        sViewsWithIds.put(R.id.tv_job_offer_id, 48);
        sViewsWithIds.put(R.id.tv_job_type, 49);
        sViewsWithIds.put(R.id.cv_job_viewed_dialog, 50);
        sViewsWithIds.put(R.id.cv_job_online_dialog, 51);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSeekerJobCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 52, sIncludes, sViewsWithIds));
    }
    private ItemSeekerJobCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[26]
            , (com.google.android.material.chip.ChipGroup) bindings[29]
            , (com.google.android.material.chip.ChipGroup) bindings[31]
            , (com.google.android.material.chip.ChipGroup) bindings[33]
            , (com.google.android.material.chip.ChipGroup) bindings[18]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[46]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.cardview.widget.CardView) bindings[51]
            , (androidx.cardview.widget.CardView) bindings[50]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[41]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[38]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[44]
            , (android.widget.LinearLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.SeekBar) bindings[25]
            , (android.widget.SeekBar) bindings[28]
            , (android.widget.SeekBar) bindings[30]
            , (android.widget.SeekBar) bindings[32]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[39]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[37]
            , (android.widget.TextView) bindings[40]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[43]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[42]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[48]
            , (android.widget.TextView) bindings[49]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[14]
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