package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemProfileBioBindingImpl extends ItemProfileBioBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_circle_image, 1);
        sViewsWithIds.put(R.id.cl_profile_iv, 2);
        sViewsWithIds.put(R.id.circleImageView, 3);
        sViewsWithIds.put(R.id.tv_user_name, 4);
        sViewsWithIds.put(R.id.ll_university, 5);
        sViewsWithIds.put(R.id.iv_collage, 6);
        sViewsWithIds.put(R.id.tv_university_name, 7);
        sViewsWithIds.put(R.id.ll_job_title, 8);
        sViewsWithIds.put(R.id.iv_job_post, 9);
        sViewsWithIds.put(R.id.tv_job_name, 10);
        sViewsWithIds.put(R.id.ll_interested_in, 11);
        sViewsWithIds.put(R.id.iv_search, 12);
        sViewsWithIds.put(R.id.tv_interested_in, 13);
        sViewsWithIds.put(R.id.linearLayout10, 14);
        sViewsWithIds.put(R.id.ll_job_location, 15);
        sViewsWithIds.put(R.id.iv_location_point, 16);
        sViewsWithIds.put(R.id.tv_job_location, 17);
        sViewsWithIds.put(R.id.ll_education, 18);
        sViewsWithIds.put(R.id.iv_education, 19);
        sViewsWithIds.put(R.id.tv_education, 20);
        sViewsWithIds.put(R.id.linearLayout11, 21);
        sViewsWithIds.put(R.id.tv_bio, 22);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemProfileBioBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private ItemProfileBioBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[3]
            , (androidx.cardview.widget.CardView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[4]
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