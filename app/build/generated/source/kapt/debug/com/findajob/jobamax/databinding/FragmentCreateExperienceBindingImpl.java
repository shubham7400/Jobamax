package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCreateExperienceBindingImpl extends FragmentCreateExperienceBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_action_bar, 6);
        sViewsWithIds.put(R.id.jobNameField, 7);
        sViewsWithIds.put(R.id.companyField, 8);
        sViewsWithIds.put(R.id.cb_currently_working, 9);
        sViewsWithIds.put(R.id.expDescriptionField, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback49;
    @Nullable
    private final android.view.View.OnClickListener mCallback47;
    @Nullable
    private final android.view.View.OnClickListener mCallback48;
    @Nullable
    private final android.view.View.OnClickListener mCallback46;
    @Nullable
    private final android.view.View.OnClickListener mCallback50;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentCreateExperienceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentCreateExperienceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[5]
            , (android.widget.CheckBox) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[10]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[2]
            );
        this.button.setTag(null);
        this.experienceEndDateField.setTag(null);
        this.experienceStartDateField.setTag(null);
        this.ivBackButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvLocationField.setTag(null);
        setRootTag(root);
        // listeners
        mCallback49 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback47 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback48 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback46 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback50 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
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
            setHandler((com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler Handler) {
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
        com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.button.setOnClickListener(mCallback50);
            this.experienceEndDateField.setOnClickListener(mCallback49);
            this.experienceStartDateField.setOnClickListener(mCallback48);
            this.ivBackButton.setOnClickListener(mCallback46);
            this.tvLocationField.setOnClickListener(mCallback47);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {




                    handler.onDateClicked(callbackArg_0, 1);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onLocationClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {




                    handler.onDateClicked(callbackArg_0, 1);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSaveButtonClicked();
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