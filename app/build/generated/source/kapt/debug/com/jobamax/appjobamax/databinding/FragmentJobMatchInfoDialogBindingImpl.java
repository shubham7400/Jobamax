package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobMatchInfoDialogBindingImpl extends FragmentJobMatchInfoDialogBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_most_parent, 1);
        sViewsWithIds.put(R.id.iv_close, 2);
        sViewsWithIds.put(R.id.ll_match_profile, 3);
        sViewsWithIds.put(R.id.sb_education, 4);
        sViewsWithIds.put(R.id.cg_education_tags, 5);
        sViewsWithIds.put(R.id.ll_experience, 6);
        sViewsWithIds.put(R.id.sb_experience, 7);
        sViewsWithIds.put(R.id.cg_experience_tags, 8);
        sViewsWithIds.put(R.id.sb_hard_skill, 9);
        sViewsWithIds.put(R.id.cg_hard_skill_tags, 10);
        sViewsWithIds.put(R.id.sb_soft_skill, 11);
        sViewsWithIds.put(R.id.cg_soft_skill_tags, 12);
        sViewsWithIds.put(R.id.imageView11, 13);
        sViewsWithIds.put(R.id.tv_10, 14);
        sViewsWithIds.put(R.id.tv_location, 15);
        sViewsWithIds.put(R.id.imageView10, 16);
        sViewsWithIds.put(R.id.textView2, 17);
        sViewsWithIds.put(R.id.tv_type_of_work, 18);
        sViewsWithIds.put(R.id.cl_job_search, 19);
        sViewsWithIds.put(R.id.iv_122, 20);
        sViewsWithIds.put(R.id.tv11, 21);
        sViewsWithIds.put(R.id.tv_job_search_keyword, 22);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobMatchInfoDialogBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private FragmentJobMatchInfoDialogBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[5]
            , (com.google.android.material.chip.ChipGroup) bindings[8]
            , (com.google.android.material.chip.ChipGroup) bindings[10]
            , (com.google.android.material.chip.ChipGroup) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[19]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.SeekBar) bindings[4]
            , (android.widget.SeekBar) bindings[7]
            , (android.widget.SeekBar) bindings[9]
            , (android.widget.SeekBar) bindings[11]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[18]
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