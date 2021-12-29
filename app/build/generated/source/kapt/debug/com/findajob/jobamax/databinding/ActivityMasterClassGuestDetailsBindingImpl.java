package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMasterClassGuestDetailsBindingImpl extends ActivityMasterClassGuestDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 5);
        sViewsWithIds.put(R.id.ll_guest_link, 6);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMasterClassGuestDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityMasterClassGuestDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.ivGuest.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.tvGuestDescription.setTag(null);
        this.tvGuestName.setTag(null);
        this.tvGuestTitle.setTag(null);
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
        if (BR.guest == variableId) {
            setGuest((com.findajob.jobamax.dashboard.home.training.masterclass.model.Guest) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGuest(@Nullable com.findajob.jobamax.dashboard.home.training.masterclass.model.Guest Guest) {
        this.mGuest = Guest;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.guest);
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
        java.lang.String guestDescription = null;
        java.lang.String guestImageUrl = null;
        com.findajob.jobamax.dashboard.home.training.masterclass.model.Guest guest = mGuest;
        java.lang.String guestTitle = null;
        java.lang.String guestName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (guest != null) {
                    // read guest.description
                    guestDescription = guest.getDescription();
                    // read guest.imageUrl
                    guestImageUrl = guest.getImageUrl();
                    // read guest.title
                    guestTitle = guest.getTitle();
                    // read guest.name
                    guestName = guest.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivGuest, guestImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvGuestDescription, guestDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvGuestName, guestName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvGuestTitle, guestTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): guest
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}