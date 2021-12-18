package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPaymentBindingImpl extends ActivityPaymentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.customToolbar, 1);
        sViewsWithIds.put(R.id.backButton, 2);
        sViewsWithIds.put(R.id.standardCard, 3);
        sViewsWithIds.put(R.id.titleText, 4);
        sViewsWithIds.put(R.id.priceText, 5);
        sViewsWithIds.put(R.id.descriptionText, 6);
        sViewsWithIds.put(R.id.cardView, 7);
        sViewsWithIds.put(R.id.card_logo, 8);
        sViewsWithIds.put(R.id.card_digits, 9);
        sViewsWithIds.put(R.id.cardInputWidget, 10);
        sViewsWithIds.put(R.id.payButton, 11);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPaymentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityPaymentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[9]
            , (com.stripe.android.view.CardInputWidget) bindings[10]
            , (android.widget.ImageView) bindings[8]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (android.widget.Button) bindings[11]
            , (android.widget.TextView) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.TextView) bindings[4]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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