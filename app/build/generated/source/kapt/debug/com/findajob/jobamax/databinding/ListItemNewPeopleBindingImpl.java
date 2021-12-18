package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ListItemNewPeopleBindingImpl extends ListItemNewPeopleBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemNewPeopleBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ListItemNewPeopleBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.cardview.widget.CardView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.clNewPeople.setTag(null);
        this.cvImage.setTag(null);
        this.ivUserImage.setTag(null);
        this.tvName.setTag(null);
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
            setItem((com.findajob.jobamax.data.pojo.NewPeople) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.data.pojo.NewPeople Item) {
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
        com.findajob.jobamax.data.pojo.NewPeople item = mItem;
        java.lang.String itemName = null;
        java.lang.String itemProfilePicUrl = null;
        boolean itemIsActive = false;
        int itemIsActiveCvImageAndroidColorGreyishWhiteCvImageAndroidColorTransparent = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.name
                    itemName = item.getName();
                    // read item.profilePicUrl
                    itemProfilePicUrl = item.getProfilePicUrl();
                    // read item.isActive
                    itemIsActive = item.isActive();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(itemIsActive) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read item.isActive ? @android:color/greyishWhite : @android:color/transparent
                itemIsActiveCvImageAndroidColorGreyishWhiteCvImageAndroidColorTransparent = ((itemIsActive) ? (getColorFromResource(cvImage, R.color.greyishWhite)) : (getColorFromResource(cvImage, R.color.transparent)));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.cvImage.setCardBackgroundColor(itemIsActiveCvImageAndroidColorGreyishWhiteCvImageAndroidColorTransparent);
            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrlCircular(this.ivUserImage, itemProfilePicUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, itemName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
        flag 2 (0x3L): item.isActive ? @android:color/greyishWhite : @android:color/transparent
        flag 3 (0x4L): item.isActive ? @android:color/greyishWhite : @android:color/transparent
    flag mapping end*/
    //end
}