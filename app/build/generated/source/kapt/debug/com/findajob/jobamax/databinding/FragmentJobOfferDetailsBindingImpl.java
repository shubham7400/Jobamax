package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobOfferDetailsBindingImpl extends FragmentJobOfferDetailsBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_app_bar, 22);
        sViewsWithIds.put(R.id.tv_job_details_label, 23);
        sViewsWithIds.put(R.id.iv_end_job_button, 24);
        sViewsWithIds.put(R.id.btn_submit, 25);
        sViewsWithIds.put(R.id.locationTextLabel, 26);
        sViewsWithIds.put(R.id.rl_distance_layout, 27);
        sViewsWithIds.put(R.id.distanceLabel, 28);
        sViewsWithIds.put(R.id.rl_seek_bar_layout, 29);
        sViewsWithIds.put(R.id.ll_1_to_10, 30);
        sViewsWithIds.put(R.id.cb_1_to_10, 31);
        sViewsWithIds.put(R.id.ll_11_to_50, 32);
        sViewsWithIds.put(R.id.cb_11_to_50, 33);
        sViewsWithIds.put(R.id.ll_51_to_199, 34);
        sViewsWithIds.put(R.id.cb_51_to_199, 35);
        sViewsWithIds.put(R.id.ll_200_to_500, 36);
        sViewsWithIds.put(R.id.cb_200_to_500, 37);
        sViewsWithIds.put(R.id.ll_500_more, 38);
        sViewsWithIds.put(R.id.cb_500_more, 39);
        sViewsWithIds.put(R.id.rl_part_time_check_box, 40);
        sViewsWithIds.put(R.id.partTimeCheck, 41);
        sViewsWithIds.put(R.id.rl_full_time_check_box, 42);
        sViewsWithIds.put(R.id.fullTimeCheck, 43);
        sViewsWithIds.put(R.id.rl_internship_check_box, 44);
        sViewsWithIds.put(R.id.internshipCheck, 45);
        sViewsWithIds.put(R.id.keySkillsField, 46);
        sViewsWithIds.put(R.id.keySkillChipGroup, 47);
        sViewsWithIds.put(R.id.benefitsRecycler, 48);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.CheckBox mboundView10;
    @NonNull
    private final android.widget.CheckBox mboundView11;
    @NonNull
    private final android.widget.RelativeLayout mboundView13;
    @NonNull
    private final android.widget.LinearLayout mboundView15;
    @NonNull
    private final android.widget.CheckBox mboundView16;
    @NonNull
    private final android.widget.CheckBox mboundView17;
    @NonNull
    private final android.widget.CheckBox mboundView18;
    @NonNull
    private final androidx.appcompat.widget.AppCompatButton mboundView21;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback196;
    @Nullable
    private final android.view.View.OnClickListener mCallback192;
    @Nullable
    private final android.view.View.OnClickListener mCallback193;
    @Nullable
    private final android.view.View.OnClickListener mCallback194;
    @Nullable
    private final android.view.View.OnClickListener mCallback195;
    @Nullable
    private final android.view.View.OnClickListener mCallback191;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener companyFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.company
            //         is offer.setCompany((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(companyField);
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.company
            java.lang.String offerCompany = null;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setCompany(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener companyWebsiteFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.companyWebsite
            //         is offer.setCompanyWebsite((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(companyWebsiteField);
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.companyWebsite
            java.lang.String offerCompanyWebsite = null;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setCompanyWebsite(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener descriptionFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.description
            //         is offer.setDescription((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(descriptionField);
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.description
            java.lang.String offerDescription = null;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setDescription(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener industryFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.industry
            //         is offer.setIndustry((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(industryField);
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.industry
            java.lang.String offerIndustry = null;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setIndustry(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView16androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.underOneWorkExSelectedFlag
            //         is offer.setUnderOneWorkExSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView16.isChecked();
            // localize variables for thread safety
            // offer.underOneWorkExSelectedFlag
            boolean offerUnderOneWorkExSelectedFlag = false;
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setUnderOneWorkExSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView17androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.oneToTwoWorkExSelectedFlag
            //         is offer.setOneToTwoWorkExSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView17.isChecked();
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.oneToTwoWorkExSelectedFlag
            boolean offerOneToTwoWorkExSelectedFlag = false;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setOneToTwoWorkExSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView18androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.twoPlusWorkExSelectedFlag
            //         is offer.setTwoPlusWorkExSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView18.isChecked();
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.twoPlusWorkExSelectedFlag
            boolean offerTwoPlusWorkExSelectedFlag = false;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setTwoPlusWorkExSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener monthlySalaryFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.monthlySalary
            //         is offer.setMonthlySalary((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(monthlySalaryField);
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.monthlySalary
            java.lang.String offerMonthlySalary = null;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setMonthlySalary(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener nameFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of offer.name
            //         is offer.setName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(nameField);
            // localize variables for thread safety
            // offer
            com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
            // offer != null
            boolean offerJavaLangObjectNull = false;
            // offer.name
            java.lang.String offerName = null;



            offerJavaLangObjectNull = (offer) != (null);
            if (offerJavaLangObjectNull) {




                offer.setName(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentJobOfferDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 49, sIncludes, sViewsWithIds));
    }
    private FragmentJobOfferDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[48]
            , (androidx.appcompat.widget.AppCompatButton) bindings[25]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[33]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[31]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[37]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[39]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[35]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[22]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[20]
            , (android.widget.TextView) bindings[28]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[43]
            , (android.widget.EditText) bindings[9]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[45]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.chip.ChipGroup) bindings[47]
            , (android.widget.EditText) bindings[46]
            , (android.widget.TextView) bindings[14]
            , (android.widget.LinearLayout) bindings[32]
            , (android.widget.LinearLayout) bindings[30]
            , (android.widget.LinearLayout) bindings[36]
            , (android.widget.LinearLayout) bindings[38]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[26]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[6]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[41]
            , (android.widget.RelativeLayout) bindings[27]
            , (android.widget.LinearLayout) bindings[42]
            , (android.widget.LinearLayout) bindings[44]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[40]
            , (android.widget.RelativeLayout) bindings[29]
            , (android.widget.EditText) bindings[19]
            , (android.widget.SeekBar) bindings[5]
            , (android.widget.TextView) bindings[23]
            );
        this.companyField.setTag(null);
        this.companyWebsiteField.setTag(null);
        this.descriptionField.setTag(null);
        this.industryField.setTag(null);
        this.ivBackButton.setTag(null);
        this.ivHideJobButton.setTag(null);
        this.levelOfHierarchyField.setTag(null);
        this.locationLabel.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (android.widget.CheckBox) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (android.widget.CheckBox) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView13 = (android.widget.RelativeLayout) bindings[13];
        this.mboundView13.setTag(null);
        this.mboundView15 = (android.widget.LinearLayout) bindings[15];
        this.mboundView15.setTag(null);
        this.mboundView16 = (android.widget.CheckBox) bindings[16];
        this.mboundView16.setTag(null);
        this.mboundView17 = (android.widget.CheckBox) bindings[17];
        this.mboundView17.setTag(null);
        this.mboundView18 = (android.widget.CheckBox) bindings[18];
        this.mboundView18.setTag(null);
        this.mboundView21 = (androidx.appcompat.widget.AppCompatButton) bindings[21];
        this.mboundView21.setTag(null);
        this.monthlySalaryField.setTag(null);
        this.nameField.setTag(null);
        this.rlLocationLayout.setTag(null);
        this.screeningQuestionField.setTag(null);
        this.seekBar.setTag(null);
        setRootTag(root);
        // listeners
        mCallback196 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback192 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback193 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback194 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback195 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback191 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
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
            setOffer((com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOffer(@Nullable com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState Offer) {
        this.mOffer = Offer;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.offer);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handler);
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
        boolean offerUnderOneWorkExSelectedFlag = false;
        boolean offerHierarchyFlagInt2 = false;
        int offerDistance = 0;
        java.lang.String offerHierarchyFlagInt0LevelOfHierarchyFieldAndroidStringLowOfferHierarchyFlagInt1LevelOfHierarchyFieldAndroidStringMediumOfferHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString = null;
        boolean offerHierarchyFlagInt1 = false;
        java.lang.String offerDescription = null;
        java.lang.String offerMonthlySalary = null;
        java.lang.String offerLocation = null;
        boolean offerOneToTwoWorkExSelectedFlag = false;
        com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState offer = mOffer;
        boolean offerHierarchyFlagInt0 = false;
        java.lang.String offerCompany = null;
        boolean offerIsMonthlySalary = false;
        java.lang.String offerIndustry = null;
        boolean offerTwoPlusWorkExSelectedFlag = false;
        java.lang.String offerCompanyWebsite = null;
        java.lang.String offerHierarchyFlagInt1LevelOfHierarchyFieldAndroidStringMediumOfferHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString = null;
        int offerHierarchyFlag = 0;
        java.lang.String offerHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString = null;
        java.lang.String offerScreeningQuestion = null;
        com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler handler = mHandler;
        boolean offerIsYearlySalary = false;
        java.lang.String offerName = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (offer != null) {
                    // read offer.underOneWorkExSelectedFlag
                    offerUnderOneWorkExSelectedFlag = offer.getUnderOneWorkExSelectedFlag();
                    // read offer.distance
                    offerDistance = offer.getDistance();
                    // read offer.description
                    offerDescription = offer.getDescription();
                    // read offer.monthlySalary
                    offerMonthlySalary = offer.getMonthlySalary();
                    // read offer.location
                    offerLocation = offer.getLocation();
                    // read offer.oneToTwoWorkExSelectedFlag
                    offerOneToTwoWorkExSelectedFlag = offer.getOneToTwoWorkExSelectedFlag();
                    // read offer.company
                    offerCompany = offer.getCompany();
                    // read offer.isMonthlySalary
                    offerIsMonthlySalary = offer.isMonthlySalary();
                    // read offer.industry
                    offerIndustry = offer.getIndustry();
                    // read offer.twoPlusWorkExSelectedFlag
                    offerTwoPlusWorkExSelectedFlag = offer.getTwoPlusWorkExSelectedFlag();
                    // read offer.companyWebsite
                    offerCompanyWebsite = offer.getCompanyWebsite();
                    // read offer.hierarchyFlag
                    offerHierarchyFlag = offer.getHierarchyFlag();
                    // read offer.screeningQuestion
                    offerScreeningQuestion = offer.getScreeningQuestion();
                    // read offer.isYearlySalary
                    offerIsYearlySalary = offer.isYearlySalary();
                    // read offer.name
                    offerName = offer.getName();
                }


                // read offer.hierarchyFlag == 0
                offerHierarchyFlagInt0 = (offerHierarchyFlag) == (0);
            if((dirtyFlags & 0x5L) != 0) {
                if(offerHierarchyFlagInt0) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x8L) != 0) {



                if (offer != null) {
                    // read offer.hierarchyFlag
                    offerHierarchyFlag = offer.getHierarchyFlag();
                }


                // read offer.hierarchyFlag == 1
                offerHierarchyFlagInt1 = (offerHierarchyFlag) == (1);
            if((dirtyFlags & 0x8L) != 0) {
                if(offerHierarchyFlagInt1) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x20L) != 0) {

                // read offer.hierarchyFlag == 2
                offerHierarchyFlagInt2 = (offerHierarchyFlag) == (2);
            if((dirtyFlags & 0x20L) != 0) {
                if(offerHierarchyFlagInt2) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }


                // read offer.hierarchyFlag == 2 ? @android:string/high : ""
                offerHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString = ((offerHierarchyFlagInt2) ? (levelOfHierarchyField.getResources().getString(R.string.high)) : (""));
        }

        if ((dirtyFlags & 0x8L) != 0) {

                // read offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
                offerHierarchyFlagInt1LevelOfHierarchyFieldAndroidStringMediumOfferHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString = ((offerHierarchyFlagInt1) ? (levelOfHierarchyField.getResources().getString(R.string.medium)) : (offerHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString));
        }

        if ((dirtyFlags & 0x5L) != 0) {

                // read offer.hierarchyFlag == 0 ? @android:string/low : offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
                offerHierarchyFlagInt0LevelOfHierarchyFieldAndroidStringLowOfferHierarchyFlagInt1LevelOfHierarchyFieldAndroidStringMediumOfferHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString = ((offerHierarchyFlagInt0) ? (levelOfHierarchyField.getResources().getString(R.string.low)) : (offerHierarchyFlagInt1LevelOfHierarchyFieldAndroidStringMediumOfferHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString));
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyField, offerCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyWebsiteField, offerCompanyWebsite);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.descriptionField, offerDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.industryField, offerIndustry);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.levelOfHierarchyField, offerHierarchyFlagInt0LevelOfHierarchyFieldAndroidStringLowOfferHierarchyFlagInt1LevelOfHierarchyFieldAndroidStringMediumOfferHierarchyFlagInt2LevelOfHierarchyFieldAndroidStringHighJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.locationLabel, offerLocation);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView10, offerIsMonthlySalary);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView11, offerIsYearlySalary);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView16, offerUnderOneWorkExSelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView17, offerOneToTwoWorkExSelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView18, offerTwoPlusWorkExSelectedFlag);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.monthlySalaryField, offerMonthlySalary);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameField, offerName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.screeningQuestionField, offerScreeningQuestion);
            androidx.databinding.adapters.SeekBarBindingAdapter.setProgress(this.seekBar, offerDistance);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.companyField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, companyFieldandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.companyWebsiteField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, companyWebsiteFieldandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.descriptionField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, descriptionFieldandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.industryField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, industryFieldandroidTextAttrChanged);
            this.ivBackButton.setOnClickListener(mCallback191);
            this.ivHideJobButton.setOnClickListener(mCallback192);
            this.mboundView13.setOnClickListener(mCallback194);
            this.mboundView15.setOnClickListener(mCallback195);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView16, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView16androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView17, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView17androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView18, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView18androidCheckedAttrChanged);
            this.mboundView21.setOnClickListener(mCallback196);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.monthlySalaryField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, monthlySalaryFieldandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.nameField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, nameFieldandroidTextAttrChanged);
            this.rlLocationLayout.setOnClickListener(mCallback193);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 6: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitButtonClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onHideJobClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onLocationClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onLevelOfHierarchyClicked(callbackArg_0);
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddKeySkillsClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): offer
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
        flag 3 (0x4L): offer.hierarchyFlag == 0 ? @android:string/low : offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 4 (0x5L): offer.hierarchyFlag == 0 ? @android:string/low : offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 5 (0x6L): offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 6 (0x7L): offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 7 (0x8L): offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 8 (0x9L): offer.hierarchyFlag == 2 ? @android:string/high : ""
    flag mapping end*/
    //end
}