package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RecruiterHomeBindingImpl extends RecruiterHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView10, 1);
        sViewsWithIds.put(R.id.textView5, 2);
        sViewsWithIds.put(R.id.textView6, 3);
        sViewsWithIds.put(R.id.button3, 4);
        sViewsWithIds.put(R.id.melafd, 5);
        sViewsWithIds.put(R.id.oooo, 6);
        sViewsWithIds.put(R.id.image_user, 7);
        sViewsWithIds.put(R.id.abcdd, 8);
        sViewsWithIds.put(R.id.iv_calender, 9);
        sViewsWithIds.put(R.id.tv_calender_title, 10);
        sViewsWithIds.put(R.id.rrrr, 11);
        sViewsWithIds.put(R.id.iv_message_icon, 12);
        sViewsWithIds.put(R.id.tv_message_count_title, 13);
        sViewsWithIds.put(R.id.kkfff, 14);
        sViewsWithIds.put(R.id.iv_calenderd, 15);
        sViewsWithIds.put(R.id.tv_calender_titled, 16);
        sViewsWithIds.put(R.id.ccceff, 17);
        sViewsWithIds.put(R.id.tv_calender_titledd, 18);
        sViewsWithIds.put(R.id.rl_abcd, 19);
        sViewsWithIds.put(R.id.tv_ef, 20);
        sViewsWithIds.put(R.id.iv_right_arrow, 21);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RecruiterHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private RecruiterHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.Button) bindings[4]
            , (android.widget.RelativeLayout) bindings[17]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[7]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.RelativeLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.RelativeLayout) bindings[19]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[13]
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