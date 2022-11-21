package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentManualFilterBindingImpl extends FragmentManualFilterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.autocomplete_fragment, 1);
        sViewsWithIds.put(R.id.tv_job_location, 2);
        sViewsWithIds.put(R.id.cl_work_type, 3);
        sViewsWithIds.put(R.id.iv_arrow_work, 4);
        sViewsWithIds.put(R.id.cg_contract_type, 5);
        sViewsWithIds.put(R.id.cl_experience, 6);
        sViewsWithIds.put(R.id.iv_arrow_exp, 7);
        sViewsWithIds.put(R.id.cg_work_experience, 8);
        sViewsWithIds.put(R.id.tv_criteria_category, 9);
        sViewsWithIds.put(R.id.cl_company_size, 10);
        sViewsWithIds.put(R.id.sc_is_jobamax_job, 11);
        sViewsWithIds.put(R.id.cg_company_size, 12);
        sViewsWithIds.put(R.id.et_company_name, 13);
        sViewsWithIds.put(R.id.iv_add_company, 14);
        sViewsWithIds.put(R.id.cg_company_tags, 15);
        sViewsWithIds.put(R.id.btn_save, 16);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentManualFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private FragmentManualFilterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.fragment.app.FragmentContainerView) bindings[1]
            , (androidx.appcompat.widget.AppCompatButton) bindings[16]
            , (com.google.android.material.chip.ChipGroup) bindings[12]
            , (com.google.android.material.chip.ChipGroup) bindings[15]
            , (com.google.android.material.chip.ChipGroup) bindings[5]
            , (com.google.android.material.chip.ChipGroup) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.EditText) bindings[13]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[4]
            , (androidx.appcompat.widget.SwitchCompat) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
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