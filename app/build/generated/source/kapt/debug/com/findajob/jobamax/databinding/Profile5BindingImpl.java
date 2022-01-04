package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class Profile5BindingImpl extends Profile5Binding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.tv_ddd, 3);
        sViewsWithIds.put(R.id.iv_add, 4);
        sViewsWithIds.put(R.id.tv_titles, 5);
        sViewsWithIds.put(R.id.rl_seek_bar_layoudt, 6);
        sViewsWithIds.put(R.id.tv_titley, 7);
        sViewsWithIds.put(R.id.seekBars, 8);
        sViewsWithIds.put(R.id.rl_seek_bar_layouxt, 9);
        sViewsWithIds.put(R.id.tv_titlev, 10);
        sViewsWithIds.put(R.id.seekBadr, 11);
        sViewsWithIds.put(R.id.rl_seek_bar_layoxut, 12);
        sViewsWithIds.put(R.id.tv_titlxe, 13);
        sViewsWithIds.put(R.id.seekBard, 14);
        sViewsWithIds.put(R.id.rl_seek_bar_layovut, 15);
        sViewsWithIds.put(R.id.tv_titlehb, 16);
        sViewsWithIds.put(R.id.seekBvard, 17);
        sViewsWithIds.put(R.id.rl_seek_bar_layocut, 18);
        sViewsWithIds.put(R.id.tv_titdle, 19);
        sViewsWithIds.put(R.id.seekBsar, 20);
        sViewsWithIds.put(R.id.rl_seek_bar_layout, 21);
        sViewsWithIds.put(R.id.tv_title, 22);
        sViewsWithIds.put(R.id.seekBar, 23);
        sViewsWithIds.put(R.id.tv_dddd, 24);
        sViewsWithIds.put(R.id.iv_adgd, 25);
        sViewsWithIds.put(R.id.tv_titlers, 26);
        sViewsWithIds.put(R.id.chipCpp, 27);
        sViewsWithIds.put(R.id.chipJava, 28);
        sViewsWithIds.put(R.id.chipPython, 29);
        sViewsWithIds.put(R.id.button3, 30);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public Profile5BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private Profile5BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[30]
            , (com.google.android.material.chip.Chip) bindings[27]
            , (com.google.android.material.chip.Chip) bindings[28]
            , (com.google.android.material.chip.Chip) bindings[29]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[18]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.RelativeLayout) bindings[21]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.RelativeLayout) bindings[15]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.SeekBar) bindings[11]
            , (android.widget.SeekBar) bindings[23]
            , (android.widget.SeekBar) bindings[14]
            , (android.widget.SeekBar) bindings[8]
            , (android.widget.SeekBar) bindings[20]
            , (android.widget.SeekBar) bindings[17]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[13]
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