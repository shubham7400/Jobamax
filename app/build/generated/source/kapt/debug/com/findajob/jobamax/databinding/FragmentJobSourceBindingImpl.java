package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSourceBindingImpl extends FragmentJobSourceBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_action_bar, 8);
        sViewsWithIds.put(R.id.sv_main_body, 9);
        sViewsWithIds.put(R.id.et_source_field, 10);
        sViewsWithIds.put(R.id.rl_distance_layout, 11);
        sViewsWithIds.put(R.id.distanceLabel, 12);
        sViewsWithIds.put(R.id.rl_seek_bar_layout, 13);
        sViewsWithIds.put(R.id.experienceField, 14);
        sViewsWithIds.put(R.id.expChipGroup, 15);
        sViewsWithIds.put(R.id.educationField, 16);
        sViewsWithIds.put(R.id.educationChipGroup, 17);
        sViewsWithIds.put(R.id.skillField, 18);
        sViewsWithIds.put(R.id.skillChipGroup, 19);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView4;
    @NonNull
    private final android.widget.LinearLayout mboundView5;
    @NonNull
    private final android.widget.LinearLayout mboundView6;
    @NonNull
    private final androidx.appcompat.widget.AppCompatButton mboundView7;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback13;
    @Nullable
    private final android.view.View.OnClickListener mCallback11;
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    @Nullable
    private final android.view.View.OnClickListener mCallback12;
    @Nullable
    private final android.view.View.OnClickListener mCallback10;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSourceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private FragmentJobSourceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.TextView) bindings[12]
            , (com.google.android.material.chip.ChipGroup) bindings[17]
            , (android.widget.EditText) bindings[16]
            , (android.widget.EditText) bindings[10]
            , (com.google.android.material.chip.ChipGroup) bindings[15]
            , (android.widget.EditText) bindings[14]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.EditText) bindings[2]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.RelativeLayout) bindings[13]
            , (android.widget.SeekBar) bindings[3]
            , (com.google.android.material.chip.ChipGroup) bindings[19]
            , (android.widget.EditText) bindings[18]
            , (android.widget.ScrollView) bindings[9]
            );
        this.ivBackButton.setTag(null);
        this.locationField.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.LinearLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.LinearLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.LinearLayout) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (androidx.appcompat.widget.AppCompatButton) bindings[7];
        this.mboundView7.setTag(null);
        this.seekBar.setTag(null);
        setRootTag(root);
        // listeners
        mCallback13 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback11 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback8 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback12 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback10 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback9 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
            setHandler((com.findajob.jobamax.jobseeker.source.JobSourceInterface) variable);
        }
        else if (BR.state == variableId) {
            setState((com.findajob.jobamax.model.JobSource) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.source.JobSourceInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setState(@Nullable com.findajob.jobamax.model.JobSource State) {
        this.mState = State;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.state);
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
        com.findajob.jobamax.jobseeker.source.JobSourceInterface handler = mHandler;
        int stateDistance = 0;
        com.findajob.jobamax.model.JobSource state = mState;

        if ((dirtyFlags & 0x6L) != 0) {



                if (state != null) {
                    // read state.distance
                    stateDistance = state.getDistance();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivBackButton.setOnClickListener(mCallback8);
            this.locationField.setOnClickListener(mCallback9);
            this.mboundView4.setOnClickListener(mCallback10);
            this.mboundView5.setOnClickListener(mCallback11);
            this.mboundView6.setOnClickListener(mCallback12);
            this.mboundView7.setOnClickListener(mCallback13);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.SeekBarBindingAdapter.setProgress(this.seekBar, stateDistance);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 6: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.source.JobSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitButtonClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.source.JobSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddEducationClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.source.JobSourceInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.source.JobSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddKeySkillClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.source.JobSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAddExperienceClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.source.JobSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCityClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): state
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}