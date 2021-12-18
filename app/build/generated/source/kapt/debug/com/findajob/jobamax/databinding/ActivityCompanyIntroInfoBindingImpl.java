package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCompanyIntroInfoBindingImpl extends ActivityCompanyIntroInfoBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_action_bar, 3);
        sViewsWithIds.put(R.id.sv_main_body, 4);
        sViewsWithIds.put(R.id.tv_company_name_label, 5);
        sViewsWithIds.put(R.id.et_company_name_field, 6);
        sViewsWithIds.put(R.id.tv_position_label, 7);
        sViewsWithIds.put(R.id.et_position_field, 8);
        sViewsWithIds.put(R.id.tv_headquarters_label, 9);
        sViewsWithIds.put(R.id.et_headquarters_field, 10);
        sViewsWithIds.put(R.id.tv_vat_number_label, 11);
        sViewsWithIds.put(R.id.et_vat_number_field, 12);
        sViewsWithIds.put(R.id.tv_comapny_website_label, 13);
        sViewsWithIds.put(R.id.et_company_website_field, 14);
        sViewsWithIds.put(R.id.tv_company_size_label, 15);
        sViewsWithIds.put(R.id.cv_company_size_field, 16);
        sViewsWithIds.put(R.id.rg_company_size_options, 17);
        sViewsWithIds.put(R.id.rb_1_to_10, 18);
        sViewsWithIds.put(R.id.rb_11_to_50, 19);
        sViewsWithIds.put(R.id.rb_51_to_199, 20);
        sViewsWithIds.put(R.id.rb_200_to_500, 21);
        sViewsWithIds.put(R.id.rb_500_more, 22);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback255;
    @Nullable
    private final android.view.View.OnClickListener mCallback254;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCompanyIntroInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private ActivityCompanyIntroInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (androidx.cardview.widget.CardView) bindings[16]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[12]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.RadioButton) bindings[19]
            , (android.widget.RadioButton) bindings[18]
            , (android.widget.RadioButton) bindings[21]
            , (android.widget.RadioButton) bindings[22]
            , (android.widget.RadioButton) bindings[20]
            , (android.widget.RadioGroup) bindings[17]
            , (android.widget.ScrollView) bindings[4]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            );
        this.btnSave.setTag(null);
        this.ivBackButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback255 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback254 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            setHandler((com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoHandler handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.btnSave.setOnClickListener(mCallback255);
            this.ivBackButton.setOnClickListener(mCallback254);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoHandler handler = mHandler;
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
        flag 0 (0x1L): handler
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}