package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerChangePasswordBindingImpl extends FragmentSeekerChangePasswordBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.customToolbar, 4);
        sViewsWithIds.put(R.id.newPasswordField, 5);
        sViewsWithIds.put(R.id.confirmNewPasswordField, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback23;
    @Nullable
    private final android.view.View.OnClickListener mCallback21;
    @Nullable
    private final android.view.View.OnClickListener mCallback22;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerChangePasswordBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerChangePasswordBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (android.widget.EditText) bindings[5]
            , (android.widget.Button) bindings[3]
            );
        this.imageView.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatTextView) bindings[2];
        this.mboundView2.setTag(null);
        this.submitButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback23 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback21 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback22 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
            setHandler((com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordInterface Handler) {
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
        com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.imageView.setOnClickListener(mCallback21);
            this.mboundView2.setOnClickListener(mCallback22);
            this.submitButton.setOnClickListener(mCallback23);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackPress();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordInterface handler = mHandler;
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
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}