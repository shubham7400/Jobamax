package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerDownloadCvBindingImpl extends FragmentSeekerDownloadCvBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraintLayout16, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.btn_modify_cv, 3);
        sViewsWithIds.put(R.id.iv_setting, 4);
        sViewsWithIds.put(R.id.scroll_view, 5);
        sViewsWithIds.put(R.id.ll_theme, 6);
        sViewsWithIds.put(R.id.iv_yellow, 7);
        sViewsWithIds.put(R.id.iv_theme_icon_salmon, 8);
        sViewsWithIds.put(R.id.iv_theme_icon_blue, 9);
        sViewsWithIds.put(R.id.iv_theme_icon_aquamarine, 10);
        sViewsWithIds.put(R.id.iv_theme_icon_light_salmon, 11);
        sViewsWithIds.put(R.id.iv_theme_icon_green, 12);
        sViewsWithIds.put(R.id.iv_theme_icon_yellow, 13);
        sViewsWithIds.put(R.id.iv_theme_icon_red, 14);
        sViewsWithIds.put(R.id.iv_theme_icon_grey, 15);
        sViewsWithIds.put(R.id.iv_theme_icon_normal, 16);
        sViewsWithIds.put(R.id.tv_theme_title, 17);
        sViewsWithIds.put(R.id.ll_parent, 18);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerDownloadCvBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerDownloadCvBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.core.widget.NestedScrollView) bindings[5]
            , (android.widget.TextView) bindings[17]
            );
        this.clTopParent.setTag(null);
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