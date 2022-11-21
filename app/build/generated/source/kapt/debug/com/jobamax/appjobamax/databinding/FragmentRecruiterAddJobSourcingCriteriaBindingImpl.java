package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterAddJobSourcingCriteriaBindingImpl extends FragmentRecruiterAddJobSourcingCriteriaBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_page_title, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.v_devider, 3);
        sViewsWithIds.put(R.id.sp_1, 4);
        sViewsWithIds.put(R.id.cv_tag, 5);
        sViewsWithIds.put(R.id.et_title, 6);
        sViewsWithIds.put(R.id.ll_1, 7);
        sViewsWithIds.put(R.id.tv_abc, 8);
        sViewsWithIds.put(R.id.cv_1, 9);
        sViewsWithIds.put(R.id.cl_location, 10);
        sViewsWithIds.put(R.id.iv_location_point, 11);
        sViewsWithIds.put(R.id.tv_location_title, 12);
        sViewsWithIds.put(R.id.tv_location, 13);
        sViewsWithIds.put(R.id.iv_location_foreword_arrow, 14);
        sViewsWithIds.put(R.id.cl_work_type, 15);
        sViewsWithIds.put(R.id.iv_contract_type, 16);
        sViewsWithIds.put(R.id.tv_contract_type_title, 17);
        sViewsWithIds.put(R.id.tv_type_of_work, 18);
        sViewsWithIds.put(R.id.iv_work_type_foreword_arrow, 19);
        sViewsWithIds.put(R.id.ll_2, 20);
        sViewsWithIds.put(R.id.et_job_title, 21);
        sViewsWithIds.put(R.id.iv_add_job_title, 22);
        sViewsWithIds.put(R.id.cg_job_title_tags, 23);
        sViewsWithIds.put(R.id.ll_3, 24);
        sViewsWithIds.put(R.id.et_add_university, 25);
        sViewsWithIds.put(R.id.iv_add_university, 26);
        sViewsWithIds.put(R.id.cg_university_tags, 27);
        sViewsWithIds.put(R.id.ll_4, 28);
        sViewsWithIds.put(R.id.et_add_skill, 29);
        sViewsWithIds.put(R.id.iv_add_skill, 30);
        sViewsWithIds.put(R.id.cg_skill_tags, 31);
        sViewsWithIds.put(R.id.ll_5, 32);
        sViewsWithIds.put(R.id.et_add_company, 33);
        sViewsWithIds.put(R.id.iv_add_company, 34);
        sViewsWithIds.put(R.id.cg_company_tags, 35);
        sViewsWithIds.put(R.id.btn_add_sourcing_criteria, 36);
        sViewsWithIds.put(R.id.autocomplete_fragment, 37);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecruiterAddJobSourcingCriteriaBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 38, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterAddJobSourcingCriteriaBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.fragment.app.FragmentContainerView) bindings[37]
            , (androidx.appcompat.widget.AppCompatButton) bindings[36]
            , (com.google.android.material.chip.ChipGroup) bindings[35]
            , (com.google.android.material.chip.ChipGroup) bindings[23]
            , (com.google.android.material.chip.ChipGroup) bindings[31]
            , (com.google.android.material.chip.ChipGroup) bindings[27]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (androidx.cardview.widget.CardView) bindings[9]
            , (androidx.cardview.widget.CardView) bindings[5]
            , (android.widget.EditText) bindings[33]
            , (android.widget.EditText) bindings[29]
            , (android.widget.EditText) bindings[25]
            , (android.widget.EditText) bindings[21]
            , (android.widget.EditText) bindings[6]
            , (android.widget.ImageView) bindings[34]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.ImageView) bindings[26]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[32]
            , (com.jobamax.appjobamax.customview.CustomSpinner) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[18]
            , (android.view.View) bindings[3]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
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