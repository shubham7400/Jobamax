package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityJobSeekerPersonalIntroInfoBindingImpl extends ActivityJobSeekerPersonalIntroInfoBinding implements com.jobamax.appjobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_action_bar, 5);
        sViewsWithIds.put(R.id.sv_main_body, 6);
        sViewsWithIds.put(R.id.ll_first_last_name, 7);
        sViewsWithIds.put(R.id.tv_first_name_label, 8);
        sViewsWithIds.put(R.id.et_first_name, 9);
        sViewsWithIds.put(R.id.tv_last_name_label, 10);
        sViewsWithIds.put(R.id.et_last_name, 11);
        sViewsWithIds.put(R.id.tv_gender_label, 12);
        sViewsWithIds.put(R.id.tv_gender_hint, 13);
        sViewsWithIds.put(R.id.ll_birth_pin_code, 14);
        sViewsWithIds.put(R.id.tv_date_of_birth, 15);
        sViewsWithIds.put(R.id.tv_postal_code, 16);
        sViewsWithIds.put(R.id.et_postal_code, 17);
        sViewsWithIds.put(R.id.tv_email, 18);
        sViewsWithIds.put(R.id.et_email_field, 19);
        sViewsWithIds.put(R.id.tv_phone_number, 20);
        sViewsWithIds.put(R.id.ll_phone_number_field, 21);
        sViewsWithIds.put(R.id.ccp, 22);
        sViewsWithIds.put(R.id.et_phone_number, 23);
        sViewsWithIds.put(R.id.tv_invitation_code, 24);
        sViewsWithIds.put(R.id.et_invitation_code, 25);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback25;
    @Nullable
    private final android.view.View.OnClickListener mCallback23;
    @Nullable
    private final android.view.View.OnClickListener mCallback26;
    @Nullable
    private final android.view.View.OnClickListener mCallback24;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityJobSeekerPersonalIntroInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private ActivityJobSeekerPersonalIntroInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[4]
            , (com.hbb20.CountryCodePicker) bindings[22]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.EditText) bindings[19]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[25]
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[23]
            , (android.widget.EditText) bindings[17]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.ScrollView) bindings[6]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[16]
            );
        this.btnSave.setTag(null);
        this.ivBackButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rlGenderButton.setTag(null);
        this.tvDateOfBirthField.setTag(null);
        setRootTag(root);
        // listeners
        mCallback25 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 3);
        mCallback23 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 1);
        mCallback26 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 4);
        mCallback24 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 2);
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
            setJobSeeker((com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setJobSeeker(@Nullable com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel JobSeeker) {
        this.mJobSeeker = JobSeeker;
    }
    public void setHandler(@Nullable com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface Handler) {
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
        com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnSave.setOnClickListener(mCallback26);
            this.ivBackButton.setOnClickListener(mCallback23);
            this.rlGenderButton.setOnClickListener(mCallback24);
            this.tvDateOfBirthField.setOnClickListener(mCallback25);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
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
                com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
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
                com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
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