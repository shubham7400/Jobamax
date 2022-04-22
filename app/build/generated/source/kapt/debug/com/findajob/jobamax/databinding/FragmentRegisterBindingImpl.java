package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRegisterBindingImpl extends FragmentRegisterBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_back_button, 5);
        sViewsWithIds.put(R.id.jobamaxImage, 6);
        sViewsWithIds.put(R.id.loginImage, 7);
        sViewsWithIds.put(R.id.et_email_field, 8);
        sViewsWithIds.put(R.id.et_password_field, 9);
        sViewsWithIds.put(R.id.et_confirm_password_field, 10);
        sViewsWithIds.put(R.id.tv_login, 11);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.Button mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    @Nullable
    private final android.view.View.OnClickListener mCallback18;
    @Nullable
    private final android.view.View.OnClickListener mCallback19;
    @Nullable
    private final android.view.View.OnClickListener mCallback20;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[9]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[11]
            );
        this.ivShowConfirmPasswordButton.setTag(null);
        this.ivShowPasswordButton.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.Button) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        setRootTag(root);
        // listeners
        mCallback17 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback18 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback19 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback20 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
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
            setHandler((com.findajob.jobamax.login.RegisterInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.login.RegisterInterface Handler) {
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
        com.findajob.jobamax.login.RegisterInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.ivShowConfirmPasswordButton.setOnClickListener(mCallback18);
            this.ivShowPasswordButton.setOnClickListener(mCallback17);
            this.mboundView3.setOnClickListener(mCallback19);
            this.mboundView4.setOnClickListener(mCallback20);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.RegisterInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onEyeClicked(1);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.RegisterInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onEyeClicked(2);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.RegisterInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onRegisterClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.RegisterInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onLoginClicked();
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