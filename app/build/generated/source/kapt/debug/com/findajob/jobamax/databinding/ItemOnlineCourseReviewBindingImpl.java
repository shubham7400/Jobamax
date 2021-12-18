package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemOnlineCourseReviewBindingImpl extends ItemOnlineCourseReviewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.item_home_cl_bg, 5);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemOnlineCourseReviewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemOnlineCourseReviewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.TextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatRatingBar) bindings[2]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.itemHomeCvBg.setTag(null);
        this.itemOnlineCourseRvNumber.setTag(null);
        this.itemOnlineCoursesRvRating.setTag(null);
        this.itemOnlineCoursesTvTitle.setTag(null);
        this.onlineCourseReviewContent.setTag(null);
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
            setItem((com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review Item) {
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
        com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review item = mItem;
        java.lang.String itemUserDisplayName = null;
        com.findajob.jobamax.dashboard.home.training.online.courses.model.review.User itemUser = null;
        java.lang.String stringValueOfItemRating = null;
        java.lang.String itemContent = null;
        float itemRating = 0f;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.user
                    itemUser = item.getUser();
                    // read item.content
                    itemContent = item.getContent();
                    // read item.rating
                    itemRating = item.getRating();
                }


                if (itemUser != null) {
                    // read item.user.display_name
                    itemUserDisplayName = itemUser.getDisplay_name();
                }
                // read String.valueOf(item.rating)
                stringValueOfItemRating = java.lang.String.valueOf(itemRating);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemOnlineCourseRvNumber, stringValueOfItemRating);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.itemOnlineCoursesRvRating, itemRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemOnlineCoursesTvTitle, itemUserDisplayName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.onlineCourseReviewContent, itemContent);
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