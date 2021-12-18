package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSelectRoleBindingImpl extends FragmentSelectRoleBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.topLayout, 5);
        sViewsWithIds.put(R.id.jobamaxImage, 6);
        sViewsWithIds.put(R.id.IAmLabel, 7);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback216;
    @Nullable
    private final android.view.View.OnClickListener mCallback217;
    @Nullable
    private final android.view.View.OnClickListener mCallback214;
    @Nullable
    private final android.view.View.OnClickListener mCallback215;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSelectRoleBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentSelectRoleBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[5]
            );
        this.jobSeekerLabel.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.recruiterIcon.setTag(null);
        this.seekerIcon.setTag(null);
        setRootTag(root);
        // listeners
        mCallback216 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback217 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback214 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback215 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
            setHandler((com.findajob.jobamax.login.SelectRoleInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.login.SelectRoleInterface Handler) {
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
        com.findajob.jobamax.login.SelectRoleInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.jobSeekerLabel.setOnClickListener(mCallback215);
            this.mboundView4.setOnClickListener(mCallback217);
            this.recruiterIcon.setOnClickListener(mCallback216);
            this.seekerIcon.setOnClickListener(mCallback214);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.SelectRoleInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onRecruiterClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.SelectRoleInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onRecruiterClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.SelectRoleInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onJobSeekerClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.login.SelectRoleInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onJobSeekerClicked();
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