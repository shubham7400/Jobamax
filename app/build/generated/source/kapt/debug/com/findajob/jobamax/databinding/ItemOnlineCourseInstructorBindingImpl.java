package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemOnlineCourseInstructorBindingImpl extends ItemOnlineCourseInstructorBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.item_home_cl_bg, 4);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemOnlineCourseInstructorBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemOnlineCourseInstructorBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.TextView) bindings[2]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            );
        this.imageView5.setTag(null);
        this.itemInstructorCvBg.setTag(null);
        this.onlineCourseInstructorJobTitle.setTag(null);
        this.onlineCoursesInstructorName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.item == variableId) {
            setItem((com.findajob.jobamax.dashboard.home.training.online.courses.model.VisibleInstructor) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.dashboard.home.training.online.courses.model.VisibleInstructor Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
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
        java.lang.String itemJobTitle = null;
        java.lang.String itemDisplayName = null;
        com.findajob.jobamax.dashboard.home.training.online.courses.model.VisibleInstructor item = mItem;
        java.lang.String itemImageLarge = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.job_title
                    itemJobTitle = item.getJob_title();
                    // read item.display_name
                    itemDisplayName = item.getDisplay_name();
                    // read item.image_large
                    itemImageLarge = item.getImage_large();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadIMageFromUrlCircular(this.imageView5, itemImageLarge);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.onlineCourseInstructorJobTitle, itemJobTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.onlineCoursesInstructorName, itemDisplayName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}