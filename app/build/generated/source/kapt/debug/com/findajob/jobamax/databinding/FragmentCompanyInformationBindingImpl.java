package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCompanyInformationBindingImpl extends FragmentCompanyInformationBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBar, 8);
        sViewsWithIds.put(R.id.rv_company_size, 9);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.Button mboundView7;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback70;
    @Nullable
    private final android.view.View.OnClickListener mCallback71;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener companyFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of companyData.name
            //         is companyData.setName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(companyField);
            // localize variables for thread safety
            // companyData
            com.findajob.jobamax.model.Company companyData = mCompanyData;
            // companyData != null
            boolean companyDataJavaLangObjectNull = false;
            // companyData.name
            java.lang.String companyDataName = null;



            companyDataJavaLangObjectNull = (companyData) != (null);
            if (companyDataJavaLangObjectNull) {




                companyData.setName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener companyRegFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of companyData.regNumber
            //         is companyData.setRegNumber((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(companyRegField);
            // localize variables for thread safety
            // companyData
            com.findajob.jobamax.model.Company companyData = mCompanyData;
            // companyData != null
            boolean companyDataJavaLangObjectNull = false;
            // companyData.regNumber
            java.lang.String companyDataRegNumber = null;



            companyDataJavaLangObjectNull = (companyData) != (null);
            if (companyDataJavaLangObjectNull) {




                companyData.setRegNumber(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener companyWebsiteandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of companyData.companyWebsite
            //         is companyData.setCompanyWebsite((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(companyWebsite);
            // localize variables for thread safety
            // companyData
            com.findajob.jobamax.model.Company companyData = mCompanyData;
            // companyData != null
            boolean companyDataJavaLangObjectNull = false;
            // companyData.companyWebsite
            java.lang.String companyDataCompanyWebsite = null;



            companyDataJavaLangObjectNull = (companyData) != (null);
            if (companyDataJavaLangObjectNull) {




                companyData.setCompanyWebsite(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener headquarterFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of companyData.headquarterAddress
            //         is companyData.setHeadquarterAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(headquarterField);
            // localize variables for thread safety
            // companyData
            com.findajob.jobamax.model.Company companyData = mCompanyData;
            // companyData != null
            boolean companyDataJavaLangObjectNull = false;
            // companyData.headquarterAddress
            java.lang.String companyDataHeadquarterAddress = null;



            companyDataJavaLangObjectNull = (companyData) != (null);
            if (companyDataJavaLangObjectNull) {




                companyData.setHeadquarterAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener vatFieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of companyData.vatNumber
            //         is companyData.setVatNumber((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(vatField);
            // localize variables for thread safety
            // companyData
            com.findajob.jobamax.model.Company companyData = mCompanyData;
            // companyData.vatNumber
            java.lang.String companyDataVatNumber = null;
            // companyData != null
            boolean companyDataJavaLangObjectNull = false;



            companyDataJavaLangObjectNull = (companyData) != (null);
            if (companyDataJavaLangObjectNull) {




                companyData.setVatNumber(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentCompanyInformationBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentCompanyInformationBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (android.widget.EditText) bindings[5]
            );
        this.companyField.setTag(null);
        this.companyRegField.setTag(null);
        this.companyWebsite.setTag(null);
        this.headquarterField.setTag(null);
        this.ivBack.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView7 = (android.widget.Button) bindings[7];
        this.mboundView7.setTag(null);
        this.vatField.setTag(null);
        setRootTag(root);
        // listeners
        mCallback70 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback71 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
        if (BR.companyData == variableId) {
            setCompanyData((com.findajob.jobamax.model.Company) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.recruiter.profile.account.company.CompanyInformationInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCompanyData(@Nullable com.findajob.jobamax.model.Company CompanyData) {
        this.mCompanyData = CompanyData;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.companyData);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.account.company.CompanyInformationInterface Handler) {
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
        com.findajob.jobamax.model.Company companyData = mCompanyData;
        java.lang.String companyDataVatNumber = null;
        java.lang.String companyDataRegNumber = null;
        java.lang.String companyDataHeadquarterAddress = null;
        com.findajob.jobamax.recruiter.profile.account.company.CompanyInformationInterface handler = mHandler;
        java.lang.String companyDataName = null;
        java.lang.String companyDataCompanyWebsite = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (companyData != null) {
                    // read companyData.vatNumber
                    companyDataVatNumber = companyData.getVatNumber();
                    // read companyData.regNumber
                    companyDataRegNumber = companyData.getRegNumber();
                    // read companyData.headquarterAddress
                    companyDataHeadquarterAddress = companyData.getHeadquarterAddress();
                    // read companyData.name
                    companyDataName = companyData.getName();
                    // read companyData.companyWebsite
                    companyDataCompanyWebsite = companyData.getCompanyWebsite();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyField, companyDataName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyRegField, companyDataRegNumber);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyWebsite, companyDataCompanyWebsite);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.headquarterField, companyDataHeadquarterAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.vatField, companyDataVatNumber);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.companyField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, companyFieldandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.companyRegField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, companyRegFieldandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.companyWebsite, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, companyWebsiteandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.headquarterField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, headquarterFieldandroidTextAttrChanged);
            this.ivBack.setOnClickListener(mCallback70);
            this.mboundView7.setOnClickListener(mCallback71);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.vatField, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, vatFieldandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.account.company.CompanyInformationInterface handler = mHandler;
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
                com.findajob.jobamax.recruiter.profile.account.company.CompanyInformationInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitButtonClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): companyData
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}