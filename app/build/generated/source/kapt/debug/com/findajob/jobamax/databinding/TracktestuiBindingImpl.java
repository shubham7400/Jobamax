package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class TracktestuiBindingImpl extends TracktestuiBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraintLayout8, 1);
        sViewsWithIds.put(R.id.relativeLayout, 2);
        sViewsWithIds.put(R.id.iv_back_button, 3);
        sViewsWithIds.put(R.id.tv_page_title, 4);
        sViewsWithIds.put(R.id.iv_user_profile, 5);
        sViewsWithIds.put(R.id.circleImageView2, 6);
        sViewsWithIds.put(R.id.textView21, 7);
        sViewsWithIds.put(R.id.textView22, 8);
        sViewsWithIds.put(R.id.appCompatButton, 9);
        sViewsWithIds.put(R.id.constraintLayout9, 10);
        sViewsWithIds.put(R.id.view, 11);
        sViewsWithIds.put(R.id.cardView2, 12);
        sViewsWithIds.put(R.id.textView23, 13);
        sViewsWithIds.put(R.id.imageView19, 14);
        sViewsWithIds.put(R.id.view2, 15);
        sViewsWithIds.put(R.id.view3, 16);
        sViewsWithIds.put(R.id.view11, 17);
        sViewsWithIds.put(R.id.cardView24, 18);
        sViewsWithIds.put(R.id.textView233, 19);
        sViewsWithIds.put(R.id.imageView139, 20);
        sViewsWithIds.put(R.id.view2e, 21);
        sViewsWithIds.put(R.id.vieww3, 22);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public TracktestuiBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private TracktestuiBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[18]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[3]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[5]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[4]
            , (android.view.View) bindings[11]
            , (android.view.View) bindings[17]
            , (android.view.View) bindings[15]
            , (android.view.View) bindings[21]
            , (android.view.View) bindings[16]
            , (android.view.View) bindings[22]
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