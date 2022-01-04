package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSearchBindingImpl extends FragmentJobSearchBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.customToolbar, 13);
        sViewsWithIds.put(R.id.cardView, 14);
        sViewsWithIds.put(R.id.jobField, 15);
        sViewsWithIds.put(R.id.locationTextLabel, 16);
        sViewsWithIds.put(R.id.distanceLabel, 17);
        sViewsWithIds.put(R.id.seekBar, 18);
        sViewsWithIds.put(R.id.fullTimeCheck, 19);
        sViewsWithIds.put(R.id.partTimeCheck, 20);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.CheckBox mboundView10;
    @NonNull
    private final androidx.appcompat.widget.AppCompatCheckBox mboundView4;
    @NonNull
    private final android.widget.CheckBox mboundView5;
    @NonNull
    private final android.widget.CheckBox mboundView6;
    @NonNull
    private final android.widget.CheckBox mboundView7;
    @NonNull
    private final android.widget.CheckBox mboundView8;
    @NonNull
    private final android.widget.CheckBox mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback217;
    @Nullable
    private final android.view.View.OnClickListener mCallback215;
    @Nullable
    private final android.view.View.OnClickListener mCallback216;
    @Nullable
    private final android.view.View.OnClickListener mCallback214;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView10androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of state.twoPlusWorkExSelectedFlag
            //         is state.setTwoPlusWorkExSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView10.isChecked();
            // localize variables for thread safety
            // state.twoPlusWorkExSelectedFlag
            boolean stateTwoPlusWorkExSelectedFlag = false;
            // state != null
            boolean stateJavaLangObjectNull = false;
            // state
            com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;



            stateJavaLangObjectNull = (state) != (null);
            if (stateJavaLangObjectNull) {




                state.setTwoPlusWorkExSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView4androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of state.jobSelectedFlag
            //         is state.setJobSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView4.isChecked();
            // localize variables for thread safety
            // state != null
            boolean stateJavaLangObjectNull = false;
            // state
            com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;
            // state.jobSelectedFlag
            boolean stateJobSelectedFlag = false;



            stateJavaLangObjectNull = (state) != (null);
            if (stateJavaLangObjectNull) {




                state.setJobSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView5androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of state.workStudySelectedFlag
            //         is state.setWorkStudySelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView5.isChecked();
            // localize variables for thread safety
            // state.workStudySelectedFlag
            boolean stateWorkStudySelectedFlag = false;
            // state != null
            boolean stateJavaLangObjectNull = false;
            // state
            com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;



            stateJavaLangObjectNull = (state) != (null);
            if (stateJavaLangObjectNull) {




                state.setWorkStudySelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of state.internshipSelectedFlag
            //         is state.setInternshipSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView6.isChecked();
            // localize variables for thread safety
            // state != null
            boolean stateJavaLangObjectNull = false;
            // state.internshipSelectedFlag
            boolean stateInternshipSelectedFlag = false;
            // state
            com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;



            stateJavaLangObjectNull = (state) != (null);
            if (stateJavaLangObjectNull) {




                state.setInternshipSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView7androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of state.otherSelectedFlag
            //         is state.setOtherSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView7.isChecked();
            // localize variables for thread safety
            // state.otherSelectedFlag
            boolean stateOtherSelectedFlag = false;
            // state != null
            boolean stateJavaLangObjectNull = false;
            // state
            com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;



            stateJavaLangObjectNull = (state) != (null);
            if (stateJavaLangObjectNull) {




                state.setOtherSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView8androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of state.underOneWorkExSelectedFlag
            //         is state.setUnderOneWorkExSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView8.isChecked();
            // localize variables for thread safety
            // state.underOneWorkExSelectedFlag
            boolean stateUnderOneWorkExSelectedFlag = false;
            // state != null
            boolean stateJavaLangObjectNull = false;
            // state
            com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;



            stateJavaLangObjectNull = (state) != (null);
            if (stateJavaLangObjectNull) {




                state.setUnderOneWorkExSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView9androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of state.oneToTwoWorkExSelectedFlag
            //         is state.setOneToTwoWorkExSelectedFlag((boolean) callbackArg_0)
            boolean callbackArg_0 = mboundView9.isChecked();
            // localize variables for thread safety
            // state.oneToTwoWorkExSelectedFlag
            boolean stateOneToTwoWorkExSelectedFlag = false;
            // state != null
            boolean stateJavaLangObjectNull = false;
            // state
            com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;



            stateJavaLangObjectNull = (state) != (null);
            if (stateJavaLangObjectNull) {




                state.setOneToTwoWorkExSelectedFlag(((boolean) (callbackArg_0)));
            }
        }
    };

    public FragmentJobSearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private FragmentJobSearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[14]
            , (android.widget.RelativeLayout) bindings[13]
            , (android.widget.TextView) bindings[17]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[19]
            , (android.widget.EditText) bindings[15]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[16]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[20]
            , (android.widget.TextView) bindings[12]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.SeekBar) bindings[18]
            , (android.widget.Button) bindings[11]
            );
        this.locationLabel.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (android.widget.CheckBox) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView4 = (androidx.appcompat.widget.AppCompatCheckBox) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.CheckBox) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.CheckBox) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.CheckBox) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.CheckBox) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.CheckBox) bindings[9];
        this.mboundView9.setTag(null);
        this.resetButton.setTag(null);
        this.rlLocation.setTag(null);
        this.submitButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback217 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback215 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback216 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback214 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
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
            setHandler((com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface) variable);
        }
        else if (BR.state == variableId) {
            setState((com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setState(@Nullable com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState State) {
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
        boolean stateWorkStudySelectedFlag = false;
        boolean stateOtherSelectedFlag = false;
        boolean stateInternshipSelectedFlag = false;
        boolean stateJobSelectedFlag = false;
        com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface handler = mHandler;
        com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState state = mState;
        java.lang.String stateLocation = null;
        boolean stateUnderOneWorkExSelectedFlag = false;
        boolean stateOneToTwoWorkExSelectedFlag = false;
        boolean stateTwoPlusWorkExSelectedFlag = false;

        if ((dirtyFlags & 0x6L) != 0) {



                if (state != null) {
                    // read state.workStudySelectedFlag
                    stateWorkStudySelectedFlag = state.getWorkStudySelectedFlag();
                    // read state.otherSelectedFlag
                    stateOtherSelectedFlag = state.getOtherSelectedFlag();
                    // read state.internshipSelectedFlag
                    stateInternshipSelectedFlag = state.getInternshipSelectedFlag();
                    // read state.jobSelectedFlag
                    stateJobSelectedFlag = state.getJobSelectedFlag();
                    // read state.location
                    stateLocation = state.getLocation();
                    // read state.underOneWorkExSelectedFlag
                    stateUnderOneWorkExSelectedFlag = state.getUnderOneWorkExSelectedFlag();
                    // read state.oneToTwoWorkExSelectedFlag
                    stateOneToTwoWorkExSelectedFlag = state.getOneToTwoWorkExSelectedFlag();
                    // read state.twoPlusWorkExSelectedFlag
                    stateTwoPlusWorkExSelectedFlag = state.getTwoPlusWorkExSelectedFlag();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.locationLabel, stateLocation);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView10, stateTwoPlusWorkExSelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView4, stateJobSelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView5, stateWorkStudySelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView6, stateInternshipSelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView7, stateOtherSelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView8, stateUnderOneWorkExSelectedFlag);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView9, stateOneToTwoWorkExSelectedFlag);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback214);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView10, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView10androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView4, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView4androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView5, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView5androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView6, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView6androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView7, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView7androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView8, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView8androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.mboundView9, (android.widget.CompoundButton.OnCheckedChangeListener)null, mboundView9androidCheckedAttrChanged);
            this.resetButton.setOnClickListener(mCallback217);
            this.rlLocation.setOnClickListener(mCallback215);
            this.submitButton.setOnClickListener(mCallback216);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onResetClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitButtonClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
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