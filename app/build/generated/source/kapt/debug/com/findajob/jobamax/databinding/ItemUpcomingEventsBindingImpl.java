package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemUpcomingEventsBindingImpl extends ItemUpcomingEventsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemUpcomingEventsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemUpcomingEventsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            );
        this.itemUpcomingEventsIvThumbnail.setTag(null);
        this.itemUpcomingEventsTvDescription.setTag(null);
        this.itemUpcomingEventsTvName.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (com.google.android.material.textview.MaterialTextView) bindings[2];
        this.mboundView2.setTag(null);
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
            setItem((com.findajob.jobamax.data.pojo.UpcomingEvents) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.data.pojo.UpcomingEvents Item) {
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
        int itemImage = 0;
        com.findajob.jobamax.data.pojo.UpcomingEvents item = mItem;
        java.lang.String itemDate = null;
        java.lang.String itemEvent = null;
        java.lang.String itemDescription = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.image
                    itemImage = item.getImage();
                    // read item.date
                    itemDate = item.getDate();
                    // read item.event
                    itemEvent = item.getEvent();
                    // read item.description
                    itemDescription = item.getDescription();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromDrawable(this.itemUpcomingEventsIvThumbnail, itemImage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemUpcomingEventsTvDescription, itemDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemUpcomingEventsTvName, itemEvent);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, itemDate);
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