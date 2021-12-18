package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemCurrentOnlineBindingImpl extends ItemCurrentOnlineBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.item_current_online_iv_avatar, 3);
        sViewsWithIds.put(R.id.ivSourcedMatched, 4);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.AppCompatImageView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemCurrentOnlineBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemCurrentOnlineBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[0]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            );
        this.itemCurrentOnlineCvOnline.setTag(null);
        this.itemCurrentOnlineIvName.setTag(null);
        this.mboundView1 = (androidx.appcompat.widget.AppCompatImageView) bindings[1];
        this.mboundView1.setTag(null);
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
            setItem((com.findajob.jobamax.data.pojo.CurrentOnline) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.data.pojo.CurrentOnline Item) {
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
        java.lang.String itemName = null;
        java.lang.String itemProfilePicUrl = null;
        com.findajob.jobamax.data.pojo.CurrentOnline item = mItem;
        java.lang.String itemLastName = null;
        java.lang.String itemCurrentOnlineIvNameAndroidStringFullNameItemNameItemLastName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.name
                    itemName = item.getName();
                    // read item.profilePicUrl
                    itemProfilePicUrl = item.getProfilePicUrl();
                    // read item.lastName
                    itemLastName = item.getLastName();
                }


                // read @android:string/full_name
                itemCurrentOnlineIvNameAndroidStringFullNameItemNameItemLastName = itemCurrentOnlineIvName.getResources().getString(R.string.full_name, itemName, itemLastName);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemCurrentOnlineIvName, itemCurrentOnlineIvNameAndroidStringFullNameItemNameItemLastName);
            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrlCircular(this.mboundView1, itemProfilePicUrl);
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