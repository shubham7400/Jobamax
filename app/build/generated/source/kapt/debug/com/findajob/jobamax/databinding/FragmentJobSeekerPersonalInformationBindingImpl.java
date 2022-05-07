package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerPersonalInformationBindingImpl extends FragmentJobSeekerPersonalInformationBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBar, 10);
        sViewsWithIds.put(R.id.tv_toolbar_title, 11);
        sViewsWithIds.put(R.id.genderLabel, 12);
        sViewsWithIds.put(R.id.ccp, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView4;
    @NonNull
    private final android.widget.EditText mboundView7;
    @NonNull
    private final android.widget.Button mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback57;
    @Nullable
    private final android.view.View.OnClickListener mCallback55;
    @Nullable
    private final android.view.View.OnClickListener mCallback58;
    @Nullable
    private final android.view.View.OnClickListener mCallback56;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener firstNameFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of jobSeeker.firstName
            //         is jobSeeker.setFirstName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(firstNameField);
            // localize variables for thread safety
            // jobSeeker
            com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel jobSeeker = mJobSeeker;
            // jobSeeker.firstName
            java.lang.String jobSeekerFirstName = null;
            // jobSeeker != null
            boolean jobSeekerJavaLangObjectNull = false;



            jobSeekerJavaLangObjectNull = (jobSeeker) != (null);
            if (jobSeekerJavaLangObjectNull) {




                jobSeeker.setFirstName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener lastNameFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of jobSeeker.lastName
            //         is jobSeeker.setLastName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(lastNameField);
            // localize variables for thread safety
            // jobSeeker
            com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel jobSeeker = mJobSeeker;
            // jobSeeker != null
            boolean jobSeekerJavaLangObjectNull = false;
            // jobSeeker.lastName
            java.lang.String jobSeekerLastName = null;



            jobSeekerJavaLangObjectNull = (jobSeeker) != (null);
            if (jobSeekerJavaLangObjectNull) {




                jobSeeker.setLastName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener postCodeFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of jobSeeker.postCode
            //         is jobSeeker.setPostCode((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(postCodeField);
            // localize variables for thread safety
            // jobSeeker
            com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel jobSeeker = mJobSeeker;
            // jobSeeker.postCode
            java.lang.String jobSeekerPostCode = null;
            // jobSeeker != null
            boolean jobSeekerJavaLangObjectNull = false;



            jobSeekerJavaLangObjectNull = (jobSeeker) != (null);
            if (jobSeekerJavaLangObjectNull) {




                jobSeeker.setPostCode(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentJobSeekerPersonalInformationBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerPersonalInformationBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.appbar.AppBarLayout) bindings[10]
            , (com.hbb20.CountryCodePicker) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.EditText) bindings[2]
            , (android.widget.TextView) bindings[12]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[11]
            );
        this.dobField.setTag(null);
        this.firstNameField.setTag(null);
        this.imageView8.setTag(null);
        this.lastNameField.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.RelativeLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView7 = (android.widget.EditText) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView9 = (android.widget.Button) bindings[9];
        this.mboundView9.setTag(null);
        this.phoneField.setTag(null);
        this.postCodeField.setTag(null);
        setRootTag(root);
        // listeners
        mCallback57 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback55 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback58 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback56 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
        if (BR.jobSeeker == variableId) {
            setJobSeeker((com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setJobSeeker(@Nullable com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel JobSeeker) {
        this.mJobSeeker = JobSeeker;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.jobSeeker);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationInterface Handler) {
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
        int jobSeekerPhoneNumberLastIndexOfJavaLangString = 0;
        com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel jobSeeker = mJobSeeker;
        java.lang.String jobSeekerFirstName = null;
        int jobSeekerPhoneNumberLastIndexOfJavaLangStringInt1 = 0;
        com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationInterface handler = mHandler;
        java.lang.String jobSeekerDob = null;
        java.lang.String jobSeekerPostCode = null;
        java.lang.String jobSeekerPhoneNumber = null;
        java.lang.String jobSeekerLastName = null;
        java.lang.String jobSeekerEmail = null;
        java.lang.String jobSeekerPhoneNumberSubstringJobSeekerPhoneNumberLastIndexOfJavaLangStringInt1 = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                    // read jobSeeker.dob
                    jobSeekerDob = jobSeeker.getDob();
                    // read jobSeeker.postCode
                    jobSeekerPostCode = jobSeeker.getPostCode();
                    // read jobSeeker.phoneNumber
                    jobSeekerPhoneNumber = jobSeeker.getPhoneNumber();
                    // read jobSeeker.lastName
                    jobSeekerLastName = jobSeeker.getLastName();
                    // read jobSeeker.email
                    jobSeekerEmail = jobSeeker.getEmail();
                }


                if (jobSeekerPhoneNumber != null) {
                    // read jobSeeker.phoneNumber.lastIndexOf(" ")
                    jobSeekerPhoneNumberLastIndexOfJavaLangString = jobSeekerPhoneNumber.lastIndexOf(" ");
                }


                // read (jobSeeker.phoneNumber.lastIndexOf(" ")) + (1)
                jobSeekerPhoneNumberLastIndexOfJavaLangStringInt1 = (jobSeekerPhoneNumberLastIndexOfJavaLangString) + (1);


                if (jobSeekerPhoneNumber != null) {
                    // read jobSeeker.phoneNumber.substring((jobSeeker.phoneNumber.lastIndexOf(" ")) + (1))
                    jobSeekerPhoneNumberSubstringJobSeekerPhoneNumberLastIndexOfJavaLangStringInt1 = jobSeekerPhoneNumber.substring(jobSeekerPhoneNumberLastIndexOfJavaLangStringInt1);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.dobField.setOnClickListener(mCallback57);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.firstNameField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, firstNameFieldandroidTextAttrChanged);
            this.imageView8.setOnClickListener(mCallback55);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.lastNameField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, lastNameFieldandroidTextAttrChanged);
            this.mboundView4.setOnClickListener(mCallback56);
            this.mboundView9.setOnClickListener(mCallback58);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.postCodeField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, postCodeFieldandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dobField, jobSeekerDob);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.firstNameField, jobSeekerFirstName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.lastNameField, jobSeekerLastName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, jobSeekerEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.phoneField, jobSeekerPhoneNumberSubstringJobSeekerPhoneNumberLastIndexOfJavaLangStringInt1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.postCodeField, jobSeekerPostCode);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackPress();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onGenderClicked(callbackArg_0);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}