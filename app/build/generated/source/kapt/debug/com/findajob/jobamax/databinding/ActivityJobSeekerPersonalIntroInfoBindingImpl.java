package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityJobSeekerPersonalIntroInfoBindingImpl extends ActivityJobSeekerPersonalIntroInfoBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_action_bar, 5);
        sViewsWithIds.put(R.id.sv_main_body, 6);
        sViewsWithIds.put(R.id.tv_first_name_label, 7);
        sViewsWithIds.put(R.id.et_first_name, 8);
        sViewsWithIds.put(R.id.tv_last_name_label, 9);
        sViewsWithIds.put(R.id.et_last_name, 10);
        sViewsWithIds.put(R.id.tv_gender_label, 11);
        sViewsWithIds.put(R.id.tv_gender_hint, 12);
        sViewsWithIds.put(R.id.tv_date_of_birth, 13);
        sViewsWithIds.put(R.id.tv_postal_code, 14);
        sViewsWithIds.put(R.id.et_postal_code, 15);
        sViewsWithIds.put(R.id.tv_email, 16);
        sViewsWithIds.put(R.id.et_email_field, 17);
        sViewsWithIds.put(R.id.tv_phone_number, 18);
        sViewsWithIds.put(R.id.ll_phone_number_field, 19);
        sViewsWithIds.put(R.id.ccp, 20);
        sViewsWithIds.put(R.id.et_phone_number, 21);
        sViewsWithIds.put(R.id.tv_invitation_code, 22);
        sViewsWithIds.put(R.id.et_invitation_code, 23);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback69;
    @Nullable
    private final android.view.View.OnClickListener mCallback67;
    @Nullable
    private final android.view.View.OnClickListener mCallback68;
    @Nullable
    private final android.view.View.OnClickListener mCallback66;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityJobSeekerPersonalIntroInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private ActivityJobSeekerPersonalIntroInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[4]
            , (com.hbb20.CountryCodePicker) bindings[20]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.EditText) bindings[17]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[23]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[21]
            , (android.widget.EditText) bindings[15]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.ScrollView) bindings[6]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[14]
            );
        this.btnSave.setTag(null);
        this.ivBackButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rlGenderButton.setTag(null);
        this.tvDateOfBirthField.setTag(null);
        setRootTag(root);
        // listeners
        mCallback69 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback67 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback68 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback66 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
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
            setHandler((com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setJobSeeker(@Nullable com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel JobSeeker) {
        this.mJobSeeker = JobSeeker;
    }
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface Handler) {
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
        com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnSave.setOnClickListener(mCallback69);
            this.ivBackButton.setOnClickListener(mCallback66);
            this.rlGenderButton.setOnClickListener(mCallback67);
            this.tvDateOfBirthField.setOnClickListener(mCallback68);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onGenderClicked(callbackArg_0);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackClicked();
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