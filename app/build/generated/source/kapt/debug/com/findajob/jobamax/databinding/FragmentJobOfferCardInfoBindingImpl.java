package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobOfferCardInfoBindingImpl extends FragmentJobOfferCardInfoBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ivGradCurveBackground, 8);
        sViewsWithIds.put(R.id.backButton, 9);
        sViewsWithIds.put(R.id.jobamax_logo, 10);
        sViewsWithIds.put(R.id.cardView, 11);
        sViewsWithIds.put(R.id.scrollView, 12);
        sViewsWithIds.put(R.id.parentLayout, 13);
        sViewsWithIds.put(R.id.companyCard, 14);
        sViewsWithIds.put(R.id.companyIcon, 15);
        sViewsWithIds.put(R.id.keySkillChipGroup, 16);
        sViewsWithIds.put(R.id.benefitsLayout, 17);
        sViewsWithIds.put(R.id.benefitsRecycler, 18);
        sViewsWithIds.put(R.id.companyVideoLayout, 19);
        sViewsWithIds.put(R.id.thumbProgressBar, 20);
        sViewsWithIds.put(R.id.videoThumbnailIcon, 21);
        sViewsWithIds.put(R.id.playIcon, 22);
        sViewsWithIds.put(R.id.overlayLayout, 23);
        sViewsWithIds.put(R.id.overlayLabel, 24);
        sViewsWithIds.put(R.id.scrollToTopCard, 25);
        sViewsWithIds.put(R.id.scrollToTopButton, 26);
        sViewsWithIds.put(R.id.footerLayout, 27);
        sViewsWithIds.put(R.id.rejectButton, 28);
        sViewsWithIds.put(R.id.chatButton, 29);
        sViewsWithIds.put(R.id.acceptButton, 30);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobOfferCardInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private FragmentJobOfferCardInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[30]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.LinearLayout) bindings[17]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (androidx.cardview.widget.CardView) bindings[11]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[29]
            , (androidx.cardview.widget.CardView) bindings[14]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.TextView) bindings[1]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (com.google.android.material.chip.ChipGroup) bindings[16]
            , (android.widget.TextView) bindings[24]
            , (android.widget.RelativeLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.TextView) bindings[2]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[28]
            , (android.widget.ImageView) bindings[26]
            , (androidx.cardview.widget.CardView) bindings[25]
            , (android.widget.ScrollView) bindings[12]
            , (android.widget.ProgressBar) bindings[20]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[21]
            );
        this.companyName.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.positionLabel.setTag(null);
        this.typeOfWorkLabel.setTag(null);
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
        java.lang.String offerIndustry = null;
        java.lang.String offerCompanyName = null;
        java.lang.String offerTypeOfWork0ToString = null;
        java.lang.String stringExtensionsToTitleCaseOfferLevelOfHierarchy = null;
        java.lang.String offerDescription = null;
        java.lang.String offerName = null;
        java.lang.String offerMonthlySalary = null;
        java.lang.String javaLangStringHiringOfferName = null;
        java.lang.String offerTypeOfWork0 = null;
        java.lang.String stringExtensionsToTitleCaseOfferTypeOfWork0ToString = null;
        java.lang.String offerLevelOfHierarchy = null;
        java.util.List<java.lang.String> offerTypeOfWork = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (offer != null) {
                    // read offer.industry
                    offerIndustry = offer.getIndustry();
                    // read offer.companyName
                    offerCompanyName = offer.getCompanyName();
                    // read offer.description
                    offerDescription = offer.getDescription();
                    // read offer.name
                    offerName = offer.getName();
                    // read offer.monthlySalary
                    offerMonthlySalary = offer.getMonthlySalary();
                    // read offer.levelOfHierarchy
                    offerLevelOfHierarchy = offer.getLevelOfHierarchy();
                    // read offer.typeOfWork
                    offerTypeOfWork = offer.getTypeOfWork();
                }


                // read ("Hiring: ") + (offer.name)
                javaLangStringHiringOfferName = ("Hiring: ") + (offerName);
                // read StringExtensions.toTitleCase(offer.levelOfHierarchy)
                stringExtensionsToTitleCaseOfferLevelOfHierarchy = com.findajob.jobamax.extensions.StringKt.toTitleCase(offerLevelOfHierarchy);
                if (offerTypeOfWork != null) {
                    // read offer.typeOfWork[0]
                    offerTypeOfWork0 = getFromList(offerTypeOfWork, 0);
                }


                if (offerTypeOfWork0 != null) {
                    // read offer.typeOfWork[0].toString()
                    offerTypeOfWork0ToString = offerTypeOfWork0.toString();
                }


                // read StringExtensions.toTitleCase(offer.typeOfWork[0].toString())
                stringExtensionsToTitleCaseOfferTypeOfWork0ToString = com.findajob.jobamax.extensions.StringKt.toTitleCase(offerTypeOfWork0ToString);
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyName, offerCompanyName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, offerDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, offerIndustry);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, offerMonthlySalary);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, stringExtensionsToTitleCaseOfferLevelOfHierarchy);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.positionLabel, javaLangStringHiringOfferName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.typeOfWorkLabel, stringExtensionsToTitleCaseOfferTypeOfWork0ToString);
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