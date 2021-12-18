package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemSubscriptionDetailsBindingImpl extends ItemSubscriptionDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rv_offer, 6);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSubscriptionDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ItemSubscriptionDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[0]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            );
        this.btnSubmit.setTag(null);
        this.cvContainer.setTag(null);
        this.desc.setTag(null);
        this.name.setTag(null);
        this.offerHeader.setTag(null);
        this.price.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            setItem((com.findajob.jobamax.recruiter.profile.subscription.model.Subscription) variable);
        }
        else if (BR.subscriptionPrice == variableId) {
            setSubscriptionPrice((java.lang.CharSequence) variable);
        }
        else if (BR.offers == variableId) {
            setOffers((java.lang.CharSequence) variable);
        }
        else if (BR.buttonLabel == variableId) {
            setButtonLabel((java.lang.CharSequence) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.recruiter.profile.subscription.model.Subscription Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setSubscriptionPrice(@Nullable java.lang.CharSequence SubscriptionPrice) {
        this.mSubscriptionPrice = SubscriptionPrice;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.subscriptionPrice);
        super.requestRebind();
    }
    public void setOffers(@Nullable java.lang.CharSequence Offers) {
        this.mOffers = Offers;
    }
    public void setButtonLabel(@Nullable java.lang.CharSequence ButtonLabel) {
        this.mButtonLabel = ButtonLabel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.buttonLabel);
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
        com.findajob.jobamax.recruiter.profile.subscription.model.Subscription item = mItem;
        java.lang.CharSequence subscriptionPrice = mSubscriptionPrice;
        java.lang.String itemName = null;
        java.lang.String itemDesc = null;
        java.lang.String itemOfferHeader = null;
        java.lang.CharSequence buttonLabel = mButtonLabel;

        if ((dirtyFlags & 0x11L) != 0) {



                if (item != null) {
                    // read item.name
                    itemName = item.getName();
                    // read item.desc
                    itemDesc = item.getDesc();
                    // read item.offerHeader
                    itemOfferHeader = item.getOfferHeader();
                }
        }
        if ((dirtyFlags & 0x12L) != 0) {
        }
        if ((dirtyFlags & 0x18L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.btnSubmit, buttonLabel);
        }
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.desc, itemDesc);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, itemName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.offerHeader, itemOfferHeader);
        }
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.price, subscriptionPrice);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): subscriptionPrice
        flag 2 (0x3L): offers
        flag 3 (0x4L): buttonLabel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}