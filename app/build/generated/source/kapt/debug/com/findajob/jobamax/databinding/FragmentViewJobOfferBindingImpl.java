package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentViewJobOfferBindingImpl extends FragmentViewJobOfferBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_app_bar, 14);
        sViewsWithIds.put(R.id.tv_job_details_label, 15);
        sViewsWithIds.put(R.id.iv_hide_job_button, 16);
        sViewsWithIds.put(R.id.sv_main_body, 17);
        sViewsWithIds.put(R.id.cv_location, 18);
        sViewsWithIds.put(R.id.tv_location_label, 19);
        sViewsWithIds.put(R.id.v_horizontal_line, 20);
        sViewsWithIds.put(R.id.tv_distance_label, 21);
        sViewsWithIds.put(R.id.tv_distance_field, 22);
        sViewsWithIds.put(R.id.tv_name_of_job_label, 23);
        sViewsWithIds.put(R.id.tv_company_name_label, 24);
        sViewsWithIds.put(R.id.tv_comapny_website_label, 25);
        sViewsWithIds.put(R.id.tv_company_size_label, 26);
        sViewsWithIds.put(R.id.cv_company_size_field, 27);
        sViewsWithIds.put(R.id.rg_company_size_options, 28);
        sViewsWithIds.put(R.id.rb_1_to_10, 29);
        sViewsWithIds.put(R.id.rb_11_to_50, 30);
        sViewsWithIds.put(R.id.rb_51_to_199, 31);
        sViewsWithIds.put(R.id.rb_200_to_500, 32);
        sViewsWithIds.put(R.id.rb_500_more, 33);
        sViewsWithIds.put(R.id.tv_industry_label, 34);
        sViewsWithIds.put(R.id.tv_type_of_work, 35);
        sViewsWithIds.put(R.id.cv_type_of_work, 36);
        sViewsWithIds.put(R.id.rg_type_of_work_options, 37);
        sViewsWithIds.put(R.id.rb_part_time, 38);
        sViewsWithIds.put(R.id.rb_permanent, 39);
        sViewsWithIds.put(R.id.rb_internship, 40);
        sViewsWithIds.put(R.id.tv_salary_label, 41);
        sViewsWithIds.put(R.id.rg_salary_type, 42);
        sViewsWithIds.put(R.id.rb_monthly, 43);
        sViewsWithIds.put(R.id.rb_yearly, 44);
        sViewsWithIds.put(R.id.tv_level_of_hierarchy_label, 45);
        sViewsWithIds.put(R.id.rl_level_of_hierarchy_button, 46);
        sViewsWithIds.put(R.id.tv_key_skills_label, 47);
        sViewsWithIds.put(R.id.et_key_skills_field, 48);
        sViewsWithIds.put(R.id.tv_work_experience_label, 49);
        sViewsWithIds.put(R.id.cv_work_experience_field, 50);
        sViewsWithIds.put(R.id.rg_work_experience, 51);
        sViewsWithIds.put(R.id.rb_zero_to_one, 52);
        sViewsWithIds.put(R.id.rb_two_to_three, 53);
        sViewsWithIds.put(R.id.rb_three_more, 54);
        sViewsWithIds.put(R.id.tv_benefits_label, 55);
        sViewsWithIds.put(R.id.cv_benefits_field, 56);
        sViewsWithIds.put(R.id.tv_screening_label, 57);
        sViewsWithIds.put(R.id.tv_screening_hint, 58);
        sViewsWithIds.put(R.id.tv_about_label, 59);
        sViewsWithIds.put(R.id.s_space_bottom, 60);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback217;
    @Nullable
    private final android.view.View.OnClickListener mCallback215;
    @Nullable
    private final android.view.View.OnClickListener mCallback216;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentViewJobOfferBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 61, sIncludes, sViewsWithIds));
    }
    private FragmentViewJobOfferBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.cardview.widget.CardView) bindings[56]
            , (androidx.cardview.widget.CardView) bindings[27]
            , (androidx.cardview.widget.CardView) bindings[18]
            , (androidx.cardview.widget.CardView) bindings[36]
            , (androidx.cardview.widget.CardView) bindings[50]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[48]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[11]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.RadioButton) bindings[30]
            , (android.widget.RadioButton) bindings[29]
            , (android.widget.RadioButton) bindings[32]
            , (android.widget.RadioButton) bindings[33]
            , (android.widget.RadioButton) bindings[31]
            , (android.widget.RadioButton) bindings[40]
            , (android.widget.RadioButton) bindings[43]
            , (android.widget.RadioButton) bindings[38]
            , (android.widget.RadioButton) bindings[39]
            , (android.widget.RadioButton) bindings[54]
            , (android.widget.RadioButton) bindings[53]
            , (android.widget.RadioButton) bindings[44]
            , (android.widget.RadioButton) bindings[52]
            , (android.widget.RadioGroup) bindings[28]
            , (android.widget.RadioGroup) bindings[42]
            , (android.widget.RadioGroup) bindings[37]
            , (android.widget.RadioGroup) bindings[51]
            , (android.widget.RelativeLayout) bindings[46]
            , (android.widget.Space) bindings[60]
            , (android.widget.SeekBar) bindings[4]
            , (android.widget.ScrollView) bindings[17]
            , (android.widget.TextView) bindings[59]
            , (android.widget.TextView) bindings[55]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[58]
            , (android.widget.TextView) bindings[57]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[49]
            , (android.view.View) bindings[20]
            );
        this.btnSave.setTag(null);
        this.etAboutJob.setTag(null);
        this.etCompanyNameField.setTag(null);
        this.etCompanyWebsiteField.setTag(null);
        this.etIndustryField.setTag(null);
        this.etNameOfJobField.setTag(null);
        this.etSalary.setTag(null);
        this.etScreeningField.setTag(null);
        this.ivBackButton.setTag(null);
        this.ivEndJobButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.sbDistanceSeekBar.setTag(null);
        this.tvLevelOfHierarchyHint.setTag(null);
        this.tvLocationField.setTag(null);
        setRootTag(root);
        // listeners
        mCallback217 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback215 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback216 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
            setOffer((com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferState) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOffer(@Nullable com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferState Offer) {
        this.mOffer = Offer;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.offer);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferInterface Handler) {
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
        boolean offerHierarchyFlagInt2 = false;
        java.lang.String offerHierarchyFlagInt0TvLevelOfHierarchyHintAndroidStringLowOfferHierarchyFlagInt1TvLevelOfHierarchyHintAndroidStringMediumOfferHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString = null;
        int offerDistance = 0;
        boolean offerHierarchyFlagInt1 = false;
        java.lang.String offerDescription = null;
        java.lang.String offerMonthlySalary = null;
        java.lang.String offerLocation = null;
        java.lang.String offerHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString = null;
        com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferState offer = mOffer;
        boolean offerHierarchyFlagInt0 = false;
        java.lang.String offerCompany = null;
        java.lang.String offerIndustry = null;
        java.lang.String offerCompanyWebsite = null;
        int offerHierarchyFlag = 0;
        java.lang.String offerScreeningQuestion = null;
        com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferInterface handler = mHandler;
        java.lang.String offerName = null;
        java.lang.String offerHierarchyFlagInt1TvLevelOfHierarchyHintAndroidStringMediumOfferHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (offer != null) {
                    // read offer.distance
                    offerDistance = offer.getDistance();
                    // read offer.description
                    offerDescription = offer.getDescription();
                    // read offer.monthlySalary
                    offerMonthlySalary = offer.getMonthlySalary();
                    // read offer.location
                    offerLocation = offer.getLocation();
                    // read offer.company
                    offerCompany = offer.getCompany();
                    // read offer.industry
                    offerIndustry = offer.getIndustry();
                    // read offer.companyWebsite
                    offerCompanyWebsite = offer.getCompanyWebsite();
                    // read offer.hierarchyFlag
                    offerHierarchyFlag = offer.getHierarchyFlag();
                    // read offer.screeningQuestion
                    offerScreeningQuestion = offer.getScreeningQuestion();
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
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x80L) != 0) {

                // read offer.hierarchyFlag == 2
                offerHierarchyFlagInt2 = (offerHierarchyFlag) == (2);
            if((dirtyFlags & 0x80L) != 0) {
                if(offerHierarchyFlagInt2) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }


                // read offer.hierarchyFlag == 2 ? @android:string/high : ""
                offerHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString = ((offerHierarchyFlagInt2) ? (tvLevelOfHierarchyHint.getResources().getString(R.string.high)) : (""));
        }

        if ((dirtyFlags & 0x8L) != 0) {

                // read offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
                offerHierarchyFlagInt1TvLevelOfHierarchyHintAndroidStringMediumOfferHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString = ((offerHierarchyFlagInt1) ? (tvLevelOfHierarchyHint.getResources().getString(R.string.medium)) : (offerHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString));
        }

        if ((dirtyFlags & 0x5L) != 0) {

                // read offer.hierarchyFlag == 0 ? @android:string/low : offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
                offerHierarchyFlagInt0TvLevelOfHierarchyHintAndroidStringLowOfferHierarchyFlagInt1TvLevelOfHierarchyHintAndroidStringMediumOfferHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString = ((offerHierarchyFlagInt0) ? (tvLevelOfHierarchyHint.getResources().getString(R.string.low)) : (offerHierarchyFlagInt1TvLevelOfHierarchyHintAndroidStringMediumOfferHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString));
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnSave.setOnClickListener(mCallback217);
            this.ivBackButton.setOnClickListener(mCallback215);
            this.ivEndJobButton.setOnClickListener(mCallback216);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etAboutJob, offerDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etCompanyNameField, offerCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etCompanyWebsiteField, offerCompanyWebsite);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etIndustryField, offerIndustry);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etNameOfJobField, offerName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etSalary, offerMonthlySalary);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etScreeningField, offerScreeningQuestion);
            androidx.databinding.adapters.SeekBarBindingAdapter.setProgress(this.sbDistanceSeekBar, offerDistance);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvLevelOfHierarchyHint, offerHierarchyFlagInt0TvLevelOfHierarchyHintAndroidStringLowOfferHierarchyFlagInt1TvLevelOfHierarchyHintAndroidStringMediumOfferHierarchyFlagInt2TvLevelOfHierarchyHintAndroidStringHighJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvLocationField, offerLocation);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSaveClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferInterface handler = mHandler;
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
                com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onDeleteClicked();
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
        flag 5 (0x6L): offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 6 (0x7L): offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 7 (0x8L): offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
        flag 8 (0x9L): offer.hierarchyFlag == 1 ? @android:string/medium : offer.hierarchyFlag == 2 ? @android:string/high : ""
    flag mapping end*/
    //end
}