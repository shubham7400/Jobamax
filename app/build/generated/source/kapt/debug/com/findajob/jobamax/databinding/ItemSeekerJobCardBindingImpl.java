package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
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
        sViewsWithIds.put(R.id.constraintLayout13, 1);
        sViewsWithIds.put(R.id.iv_company, 2);
        sViewsWithIds.put(R.id.tv_job_title, 3);
        sViewsWithIds.put(R.id.tv_job_type, 4);
        sViewsWithIds.put(R.id.tv_company_address, 5);
        sViewsWithIds.put(R.id.iv_report, 6);
        sViewsWithIds.put(R.id.tv_company_name, 7);
        sViewsWithIds.put(R.id.ll_about_job, 8);
        sViewsWithIds.put(R.id.tv_title_about, 9);
        sViewsWithIds.put(R.id.tv_about_job, 10);
        sViewsWithIds.put(R.id.ll_about_company, 11);
        sViewsWithIds.put(R.id.tv_company_url, 12);
        sViewsWithIds.put(R.id.tv_about_company, 13);
        sViewsWithIds.put(R.id.ll_hard_skill, 14);
        sViewsWithIds.put(R.id.rv_hard_skill, 15);
        sViewsWithIds.put(R.id.ll_soft_skill, 16);
        sViewsWithIds.put(R.id.cg_soft_skill, 17);
        sViewsWithIds.put(R.id.ll_industry, 18);
        sViewsWithIds.put(R.id.tv_industry, 19);
        sViewsWithIds.put(R.id.ll_salary, 20);
        sViewsWithIds.put(R.id.ll_benefits, 21);
        sViewsWithIds.put(R.id.rv_hard_sklilsl, 22);
        sViewsWithIds.put(R.id.ll_workspace, 23);
        sViewsWithIds.put(R.id.cg_benefits, 24);
        sViewsWithIds.put(R.id.acb_see_less_job_desc, 25);
        sViewsWithIds.put(R.id.acb_see_job_desc, 26);
        sViewsWithIds.put(R.id.cl_overlay, 27);
        sViewsWithIds.put(R.id.tv_overlay_label, 28);
        sViewsWithIds.put(R.id.tv_job_offer_id, 29);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSeekerJobCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private ItemSeekerJobCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[26]
            , (androidx.appcompat.widget.AppCompatButton) bindings[25]
            , (com.google.android.material.chip.ChipGroup) bindings[24]
            , (com.google.android.material.chip.ChipGroup) bindings[17]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[27]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[23]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[15]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[9]
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