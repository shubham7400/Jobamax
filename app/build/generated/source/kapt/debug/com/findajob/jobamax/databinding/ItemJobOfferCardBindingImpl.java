package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemJobOfferCardBindingImpl extends ItemJobOfferCardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardView, 3);
        sViewsWithIds.put(R.id.company_photo, 4);
        sViewsWithIds.put(R.id.overlayLayout, 5);
        sViewsWithIds.put(R.id.overlayLabel, 6);
        sViewsWithIds.put(R.id.infoCard, 7);
        sViewsWithIds.put(R.id.infoButton, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemJobOfferCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ItemJobOfferCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[8]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.RelativeLayout) bindings[5]
            );
        this.companyName.setTag(null);
        this.jobTitle.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.offer == variableId) {
            setOffer((com.findajob.jobamax.model.JobOffer) variable);
        }
        else if (BR.jobsource == variableId) {
            setJobsource((int) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOffer(@Nullable com.findajob.jobamax.model.JobOffer Offer) {
        this.mOffer = Offer;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.offer);
        super.requestRebind();
    }
    public void setJobsource(int Jobsource) {
        this.mJobsource = Jobsource;
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
        com.findajob.jobamax.model.JobOffer offer = mOffer;
        java.lang.String offerName = null;
        java.lang.String javaLangStringHiringOfferName = null;
        java.lang.String offerCompanyName = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (offer != null) {
                    // read offer.name
                    offerName = offer.getName();
                    // read offer.companyName
                    offerCompanyName = offer.getCompanyName();
                }


                // read ("Hiring: ") + (offer.name)
                javaLangStringHiringOfferName = ("Hiring: ") + (offerName);
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyName, offerCompanyName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.jobTitle, javaLangStringHiringOfferName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): offer
        flag 1 (0x2L): jobsource
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}