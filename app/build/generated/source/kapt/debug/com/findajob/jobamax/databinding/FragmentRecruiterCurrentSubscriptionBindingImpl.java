package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterCurrentSubscriptionBindingImpl extends FragmentRecruiterCurrentSubscriptionBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cv_container, 7);
        sViewsWithIds.put(R.id.fl_container, 8);
        sViewsWithIds.put(R.id.divider_1, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView4;
    @NonNull
    private final androidx.appcompat.widget.AppCompatButton mboundView5;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback74;
    @Nullable
    private final android.view.View.OnClickListener mCallback72;
    @Nullable
    private final android.view.View.OnClickListener mCallback73;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecruiterCurrentSubscriptionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterCurrentSubscriptionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (android.view.View) bindings[9]
            , (android.widget.FrameLayout) bindings[8]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            );
        this.btnDemo.setTag(null);
        this.ivBack.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (androidx.appcompat.widget.AppCompatTextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (androidx.appcompat.widget.AppCompatButton) bindings[5];
        this.mboundView5.setTag(null);
        this.rbLabel.setTag(null);
        this.tvSubscriptionPrice.setTag(null);
        setRootTag(root);
        // listeners
        mCallback74 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback72 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback73 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
        if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.recruiter.profile.currentSubscription.CurrentSubscriptionInterface) variable);
        }
        else if (BR.item == variableId) {
            setItem((com.findajob.jobamax.recruiter.profile.subscription.model.Subscription) variable);
        }
        else if (BR.subscriptionPrice == variableId) {
            setSubscriptionPrice((java.lang.CharSequence) variable);
        }
        else if (BR.offers == variableId) {
            setOffers((java.lang.CharSequence) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.currentSubscription.CurrentSubscriptionInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setItem(@Nullable com.findajob.jobamax.recruiter.profile.subscription.model.Subscription Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setSubscriptionPrice(@Nullable java.lang.CharSequence SubscriptionPrice) {
        this.mSubscriptionPrice = SubscriptionPrice;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.subscriptionPrice);
        super.requestRebind();
    }
    public void setOffers(@Nullable java.lang.CharSequence Offers) {
        this.mOffers = Offers;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.offers);
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
        com.findajob.jobamax.recruiter.profile.currentSubscription.CurrentSubscriptionInterface handler = mHandler;
        com.findajob.jobamax.recruiter.profile.subscription.model.Subscription item = mItem;
        java.lang.CharSequence subscriptionPrice = mSubscriptionPrice;
        java.lang.String itemName = null;
        java.lang.CharSequence offers = mOffers;

        if ((dirtyFlags & 0x12L) != 0) {



                if (item != null) {
                    // read item.name
                    itemName = item.getName();
                }
        }
        if ((dirtyFlags & 0x14L) != 0) {
        }
        if ((dirtyFlags & 0x18L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.btnDemo.setOnClickListener(mCallback74);
            this.ivBack.setOnClickListener(mCallback72);
            this.mboundView5.setOnClickListener(mCallback73);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, offers);
        }
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.rbLabel, itemName);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSubscriptionPrice, subscriptionPrice);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.currentSubscription.CurrentSubscriptionInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onScheduleADemoClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.currentSubscription.CurrentSubscriptionInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.currentSubscription.CurrentSubscriptionInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onUpgradeClick();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): item
        flag 2 (0x3L): subscriptionPrice
        flag 3 (0x4L): offers
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}