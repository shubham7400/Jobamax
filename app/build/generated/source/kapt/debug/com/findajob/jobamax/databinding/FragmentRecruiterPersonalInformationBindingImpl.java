package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterPersonalInformationBindingImpl extends FragmentRecruiterPersonalInformationBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBar, 11);
        sViewsWithIds.put(R.id.tv_toolbar_title, 12);
        sViewsWithIds.put(R.id.genderLabel, 13);
        sViewsWithIds.put(R.id.ccp, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.Button mboundView10;
    @NonNull
    private final android.widget.RelativeLayout mboundView4;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback178;
    @Nullable
    private final android.view.View.OnClickListener mCallback180;
    @Nullable
    private final android.view.View.OnClickListener mCallback179;
    @Nullable
    private final android.view.View.OnClickListener mCallback177;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener companyNameFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recruiter.companyName
            //         is recruiter.setCompanyName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(companyNameField);
            // localize variables for thread safety
            // recruiter
            com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel recruiter = mRecruiter;
            // recruiter != null
            boolean recruiterJavaLangObjectNull = false;
            // recruiter.companyName
            java.lang.String recruiterCompanyName = null;



            recruiterJavaLangObjectNull = (recruiter) != (null);
            if (recruiterJavaLangObjectNull) {




                recruiter.setCompanyName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener firstNameFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recruiter.firstName
            //         is recruiter.setFirstName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(firstNameField);
            // localize variables for thread safety
            // recruiter
            com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel recruiter = mRecruiter;
            // recruiter != null
            boolean recruiterJavaLangObjectNull = false;
            // recruiter.firstName
            java.lang.String recruiterFirstName = null;



            recruiterJavaLangObjectNull = (recruiter) != (null);
            if (recruiterJavaLangObjectNull) {




                recruiter.setFirstName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener lastNameFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recruiter.lastName
            //         is recruiter.setLastName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(lastNameField);
            // localize variables for thread safety
            // recruiter
            com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel recruiter = mRecruiter;
            // recruiter != null
            boolean recruiterJavaLangObjectNull = false;
            // recruiter.lastName
            java.lang.String recruiterLastName = null;



            recruiterJavaLangObjectNull = (recruiter) != (null);
            if (recruiterJavaLangObjectNull) {




                recruiter.setLastName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener postCodeFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recruiter.postCode
            //         is recruiter.setPostCode((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(postCodeField);
            // localize variables for thread safety
            // recruiter.postCode
            java.lang.String recruiterPostCode = null;
            // recruiter
            com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel recruiter = mRecruiter;
            // recruiter != null
            boolean recruiterJavaLangObjectNull = false;



            recruiterJavaLangObjectNull = (recruiter) != (null);
            if (recruiterJavaLangObjectNull) {




                recruiter.setPostCode(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentRecruiterPersonalInformationBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterPersonalInformationBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.appbar.AppBarLayout) bindings[11]
            , (com.hbb20.CountryCodePicker) bindings[14]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[2]
            , (android.widget.TextView) bindings[13]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[12]
            );
        this.companyNameField.setTag(null);
        this.dobField.setTag(null);
        this.emailField.setTag(null);
        this.firstNameField.setTag(null);
        this.imageView8.setTag(null);
        this.lastNameField.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (android.widget.Button) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView4 = (android.widget.RelativeLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.phoneField.setTag(null);
        this.postCodeField.setTag(null);
        setRootTag(root);
        // listeners
        mCallback178 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback180 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback179 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback177 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
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
        if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationInterface) variable);
        }
        else if (BR.recruiter == variableId) {
            setRecruiter((com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setRecruiter(@Nullable com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel Recruiter) {
        this.mRecruiter = Recruiter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.recruiter);
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
        int recruiterPhoneNumberLastIndexOfJavaLangString = 0;
        java.lang.String recruiterPostCode = null;
        java.lang.String recruiterPhoneNumber = null;
        java.lang.String recruiterCompanyName = null;
        java.lang.String recruiterFirstName = null;
        int recruiterPhoneNumberLastIndexOfJavaLangStringInt1 = 0;
        com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationInterface handler = mHandler;
        java.lang.String recruiterEmail = null;
        java.lang.String recruiterPhoneNumberSubstringRecruiterPhoneNumberLastIndexOfJavaLangStringInt1 = null;
        java.lang.String recruiterLastName = null;
        java.lang.String recruiterDob = null;
        com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel recruiter = mRecruiter;

        if ((dirtyFlags & 0x6L) != 0) {



                if (recruiter != null) {
                    // read recruiter.postCode
                    recruiterPostCode = recruiter.getPostCode();
                    // read recruiter.phoneNumber
                    recruiterPhoneNumber = recruiter.getPhoneNumber();
                    // read recruiter.companyName
                    recruiterCompanyName = recruiter.getCompanyName();
                    // read recruiter.firstName
                    recruiterFirstName = recruiter.getFirstName();
                    // read recruiter.email
                    recruiterEmail = recruiter.getEmail();
                    // read recruiter.lastName
                    recruiterLastName = recruiter.getLastName();
                    // read recruiter.dob
                    recruiterDob = recruiter.getDob();
                }


                if (recruiterPhoneNumber != null) {
                    // read recruiter.phoneNumber.lastIndexOf(" ")
                    recruiterPhoneNumberLastIndexOfJavaLangString = recruiterPhoneNumber.lastIndexOf(" ");
                }


                // read (recruiter.phoneNumber.lastIndexOf(" ")) + (1)
                recruiterPhoneNumberLastIndexOfJavaLangStringInt1 = (recruiterPhoneNumberLastIndexOfJavaLangString) + (1);


                if (recruiterPhoneNumber != null) {
                    // read recruiter.phoneNumber.substring((recruiter.phoneNumber.lastIndexOf(" ")) + (1))
                    recruiterPhoneNumberSubstringRecruiterPhoneNumberLastIndexOfJavaLangStringInt1 = recruiterPhoneNumber.substring(recruiterPhoneNumberLastIndexOfJavaLangStringInt1);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyNameField, recruiterCompanyName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dobField, recruiterDob);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.emailField, recruiterEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.firstNameField, recruiterFirstName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.lastNameField, recruiterLastName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.phoneField, recruiterPhoneNumberSubstringRecruiterPhoneNumberLastIndexOfJavaLangStringInt1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.postCodeField, recruiterPostCode);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.companyNameField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, companyNameFieldandroidTextAttrChanged);
            this.dobField.setOnClickListener(mCallback179);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.firstNameField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, firstNameFieldandroidTextAttrChanged);
            this.imageView8.setOnClickListener(mCallback177);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.lastNameField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, lastNameFieldandroidTextAttrChanged);
            this.mboundView10.setOnClickListener(mCallback180);
            this.mboundView4.setOnClickListener(mCallback178);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.postCodeField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, postCodeFieldandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onGenderClicked(callbackArg_0);
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onDobClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackPress();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): recruiter
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}