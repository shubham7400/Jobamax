package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityJobSeekerHomeBindingImpl extends ActivityJobSeekerHomeBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 10);
        sViewsWithIds.put(R.id.firstIcon, 11);
        sViewsWithIds.put(R.id.secondIcon, 12);
        sViewsWithIds.put(R.id.toggleIcon, 13);
        sViewsWithIds.put(R.id.thirdIcon, 14);
        sViewsWithIds.put(R.id.fourthIcon, 15);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback124;
    @Nullable
    private final android.view.View.OnClickListener mCallback121;
    @Nullable
    private final android.view.View.OnClickListener mCallback122;
    @Nullable
    private final android.view.View.OnClickListener mCallback123;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityJobSeekerHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityJobSeekerHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[10]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[1]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.LinearLayout) bindings[2]
            , (android.view.View) bindings[7]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.LinearLayout) bindings[8]
            , (android.view.View) bindings[3]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.RelativeLayout) bindings[4]
            , (android.view.View) bindings[5]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.ImageView) bindings[13]
            );
        this.fifthGap.setTag(null);
        this.firstGap.setTag(null);
        this.firstIconLayout.setTag(null);
        this.fourthGap.setTag(null);
        this.fourthIconLayout.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.secondGap.setTag(null);
        this.secondIconLayout.setTag(null);
        this.thirdGap.setTag(null);
        this.thirdIconLayout.setTag(null);
        setRootTag(root);
        // listeners
        mCallback124 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback121 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback122 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback123 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.state == variableId) {
            setState((java.lang.Integer) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface) variable);
        }
        else if (BR.trackToggleFlag == variableId) {
            setTrackToggleFlag((java.lang.Boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setState(@Nullable java.lang.Integer State) {
        this.mState = State;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.state);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setTrackToggleFlag(@Nullable java.lang.Boolean TrackToggleFlag) {
        this.mTrackToggleFlag = TrackToggleFlag;
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
        int stateInt1ViewVISIBLEViewGONE = 0;
        boolean stateInt1 = false;
        int stateInt3Int2StateInt2Int1Int0 = 0;
        int stateInt2ViewVISIBLEViewGONE = 0;
        boolean stateInt4 = false;
        int stateInt4Int6Int0 = 0;
        int stateInt4ViewVISIBLEViewGONE = 0;
        int stateInt2BooleanTrueStateInt3ViewVISIBLEViewGONE = 0;
        int androidxDatabindingViewDataBindingSafeUnboxState = 0;
        java.lang.Integer state = mState;
        int stateInt3ViewVISIBLEViewGONE = 0;
        int stateInt2Int3Int0 = 0;
        int stateInt2Int1Int0 = 0;
        boolean stateInt2BooleanTrueStateInt3 = false;
        int stateInt1Int6Int0 = 0;
        int stateInt2Int4Int2 = 0;
        int stateInt3Int4Int0 = 0;
        boolean stateInt2 = false;
        com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface handler = mHandler;
        boolean stateInt3 = false;

        if ((dirtyFlags & 0x9L) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(state)
                androidxDatabindingViewDataBindingSafeUnboxState = androidx.databinding.ViewDataBinding.safeUnbox(state);


                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 1
                stateInt1 = (androidxDatabindingViewDataBindingSafeUnboxState) == (1);
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 4
                stateInt4 = (androidxDatabindingViewDataBindingSafeUnboxState) == (4);
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 2
                stateInt2 = (androidxDatabindingViewDataBindingSafeUnboxState) == (2);
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 3
                stateInt3 = (androidxDatabindingViewDataBindingSafeUnboxState) == (3);
            if((dirtyFlags & 0x9L) != 0) {
                if(stateInt1) {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x2000000L;
                }
                else {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x1000000L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(stateInt4) {
                        dirtyFlags |= 0x800L;
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x400L;
                        dirtyFlags |= 0x1000L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(stateInt2) {
                        dirtyFlags |= 0x200L;
                        dirtyFlags |= 0x80000L;
                        dirtyFlags |= 0x800000L;
                        dirtyFlags |= 0x8000000L;
                }
                else {
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x40000L;
                        dirtyFlags |= 0x400000L;
                        dirtyFlags |= 0x4000000L;
                }
            }
            if((dirtyFlags & 0x40L) != 0) {
                if(stateInt2) {
                        dirtyFlags |= 0x200000L;
                }
                else {
                        dirtyFlags |= 0x100000L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(stateInt3) {
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x20000L;
                        dirtyFlags |= 0x20000000L;
                }
                else {
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x10000L;
                        dirtyFlags |= 0x10000000L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 1 ? View.VISIBLE : View.GONE
                stateInt1ViewVISIBLEViewGONE = ((stateInt1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 1 ? 6 : 0
                stateInt1Int6Int0 = ((stateInt1) ? (6) : (0));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 4 ? 6 : 0
                stateInt4Int6Int0 = ((stateInt4) ? (6) : (0));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 4 ? View.VISIBLE : View.GONE
                stateInt4ViewVISIBLEViewGONE = ((stateInt4) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? View.VISIBLE : View.GONE
                stateInt2ViewVISIBLEViewGONE = ((stateInt2) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 3 : 0
                stateInt2Int3Int0 = ((stateInt2) ? (3) : (0));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 4 : 2
                stateInt2Int4Int2 = ((stateInt2) ? (4) : (2));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? View.VISIBLE : View.GONE
                stateInt3ViewVISIBLEViewGONE = ((stateInt3) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? 4 : 0
                stateInt3Int4Int0 = ((stateInt3) ? (4) : (0));
        }
        // batch finished

        if ((dirtyFlags & 0x40L) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 1 : 0
                stateInt2Int1Int0 = ((stateInt2) ? (1) : (0));
        }
        if ((dirtyFlags & 0x9L) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? true : androidx.databinding.ViewDataBinding.safeUnbox(state) == 3
                stateInt2BooleanTrueStateInt3 = ((stateInt2) ? (true) : (stateInt3));
            if((dirtyFlags & 0x9L) != 0) {
                if(stateInt2BooleanTrueStateInt3) {
                        dirtyFlags |= 0x8000L;
                }
                else {
                        dirtyFlags |= 0x4000L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? true : androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? View.VISIBLE : View.GONE
                stateInt2BooleanTrueStateInt3ViewVISIBLEViewGONE = ((stateInt2BooleanTrueStateInt3) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? 2 : androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 1 : 0
                stateInt3Int2StateInt2Int1Int0 = ((stateInt3) ? (2) : (stateInt2Int1Int0));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.findajob.jobamax.util.BindingAdapterUtilKt.setLayoutWeight(this.fifthGap, stateInt4Int6Int0);
            this.fifthGap.setVisibility(stateInt4ViewVISIBLEViewGONE);
            com.findajob.jobamax.util.BindingAdapterUtilKt.setLayoutWeight(this.firstGap, stateInt1Int6Int0);
            this.firstGap.setVisibility(stateInt1ViewVISIBLEViewGONE);
            com.findajob.jobamax.util.BindingAdapterUtilKt.setLayoutWeight(this.fourthGap, stateInt3Int4Int0);
            this.fourthGap.setVisibility(stateInt3ViewVISIBLEViewGONE);
            com.findajob.jobamax.util.BindingAdapterUtilKt.setLayoutWeight(this.secondGap, stateInt2Int3Int0);
            this.secondGap.setVisibility(stateInt2ViewVISIBLEViewGONE);
            com.findajob.jobamax.util.BindingAdapterUtilKt.setLayoutWeight(this.secondIconLayout, stateInt2Int4Int2);
            com.findajob.jobamax.util.BindingAdapterUtilKt.setLayoutWeight(this.thirdGap, stateInt3Int2StateInt2Int1Int0);
            this.thirdGap.setVisibility(stateInt2BooleanTrueStateInt3ViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.firstIconLayout.setOnClickListener(mCallback121);
            this.fourthIconLayout.setOnClickListener(mCallback124);
            this.secondIconLayout.setOnClickListener(mCallback122);
            this.thirdIconLayout.setOnClickListener(mCallback123);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onIconClicked(4);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onIconClicked(1);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onIconClicked(2);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {



                    handler.onIconClicked(3);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): state
        flag 1 (0x2L): handler
        flag 2 (0x3L): trackToggleFlag
        flag 3 (0x4L): null
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 1 ? View.VISIBLE : View.GONE
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 1 ? View.VISIBLE : View.GONE
        flag 6 (0x7L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? 2 : androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 1 : 0
        flag 7 (0x8L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? 2 : androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 1 : 0
        flag 8 (0x9L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? View.VISIBLE : View.GONE
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? View.VISIBLE : View.GONE
        flag 10 (0xbL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 4 ? 6 : 0
        flag 11 (0xcL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 4 ? 6 : 0
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 4 ? View.VISIBLE : View.GONE
        flag 13 (0xeL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 4 ? View.VISIBLE : View.GONE
        flag 14 (0xfL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? true : androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? View.VISIBLE : View.GONE
        flag 15 (0x10L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? true : androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? View.VISIBLE : View.GONE
        flag 16 (0x11L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? View.VISIBLE : View.GONE
        flag 17 (0x12L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? View.VISIBLE : View.GONE
        flag 18 (0x13L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 3 : 0
        flag 19 (0x14L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 3 : 0
        flag 20 (0x15L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 1 : 0
        flag 21 (0x16L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 1 : 0
        flag 22 (0x17L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? true : androidx.databinding.ViewDataBinding.safeUnbox(state) == 3
        flag 23 (0x18L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? true : androidx.databinding.ViewDataBinding.safeUnbox(state) == 3
        flag 24 (0x19L): androidx.databinding.ViewDataBinding.safeUnbox(state) == 1 ? 6 : 0
        flag 25 (0x1aL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 1 ? 6 : 0
        flag 26 (0x1bL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 4 : 2
        flag 27 (0x1cL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 2 ? 4 : 2
        flag 28 (0x1dL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? 4 : 0
        flag 29 (0x1eL): androidx.databinding.ViewDataBinding.safeUnbox(state) == 3 ? 4 : 0
    flag mapping end*/
    //end
}