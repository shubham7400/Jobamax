package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerFilterJobBindingImpl extends FragmentSeekerFilterJobBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.textView24, 3);
        sViewsWithIds.put(R.id.cb_all, 4);
        sViewsWithIds.put(R.id.cb_favorite, 5);
        sViewsWithIds.put(R.id.cb_most_recent_one, 6);
        sViewsWithIds.put(R.id.cb_applied, 7);
        sViewsWithIds.put(R.id.cb_refused, 8);
        sViewsWithIds.put(R.id.cb_online_intervie, 9);
        sViewsWithIds.put(R.id.cb_assessments, 10);
        sViewsWithIds.put(R.id.cb_phone_call, 11);
        sViewsWithIds.put(R.id.cb_interview, 12);
        sViewsWithIds.put(R.id.cb_hired, 13);
        sViewsWithIds.put(R.id.btn_go, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerFilterJobBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerFilterJobBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[14]
            , (android.widget.CheckBox) bindings[4]
            , (android.widget.CheckBox) bindings[7]
            , (android.widget.CheckBox) bindings[10]
            , (android.widget.CheckBox) bindings[5]
            , (android.widget.CheckBox) bindings[13]
            , (android.widget.CheckBox) bindings[12]
            , (android.widget.CheckBox) bindings[6]
            , (android.widget.CheckBox) bindings[9]
            , (android.widget.CheckBox) bindings[11]
            , (android.widget.CheckBox) bindings[8]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.TextView) bindings[3]
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