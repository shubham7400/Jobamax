package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogRequirementsBindingImpl extends DialogRequirementsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_logo, 1);
        sViewsWithIds.put(R.id.tvNotificationBody, 2);
        sViewsWithIds.put(R.id.requirementsContainer, 3);
        sViewsWithIds.put(R.id.recyclerView, 4);
        sViewsWithIds.put(R.id.checkboxGroup, 5);
        sViewsWithIds.put(R.id.checkbox_0, 6);
        sViewsWithIds.put(R.id.checkbox_1, 7);
        sViewsWithIds.put(R.id.checkbox_2, 8);
        sViewsWithIds.put(R.id.checkbox_3, 9);
        sViewsWithIds.put(R.id.checkbox_4, 10);
        sViewsWithIds.put(R.id.btnNegative, 11);
        sViewsWithIds.put(R.id.btnPositive, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogRequirementsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private DialogRequirementsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[11]
            , (android.widget.Button) bindings[12]
            , (android.widget.CheckBox) bindings[6]
            , (android.widget.CheckBox) bindings[7]
            , (android.widget.CheckBox) bindings[8]
            , (android.widget.CheckBox) bindings[9]
            , (android.widget.CheckBox) bindings[10]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.ImageView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.TextView) bindings[2]
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