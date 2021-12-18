package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterRecruitBindingImpl extends FragmentRecruiterRecruitBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_filter_layout, 5);
        sViewsWithIds.put(R.id.jobOfferLabel, 6);
        sViewsWithIds.put(R.id.cardStackView, 7);
        sViewsWithIds.put(R.id.footerLayout, 8);
        sViewsWithIds.put(R.id.progressBar, 9);
        sViewsWithIds.put(R.id.noJobSeekerFoundLabel, 10);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback159;
    @Nullable
    private final android.view.View.OnClickListener mCallback157;
    @Nullable
    private final android.view.View.OnClickListener mCallback158;
    @Nullable
    private final android.view.View.OnClickListener mCallback160;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecruiterRecruitBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterRecruitBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[4]
            , (com.yuyakaido.android.cardstackview.CardStackView) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (android.widget.ProgressBar) bindings[9]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[3]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[2]
            );
        this.acceptButton.setTag(null);
        this.filterLayout.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.refuseButton.setTag(null);
        this.rewindButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback159 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback157 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback158 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback160 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
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
            setHandler((com.findajob.jobamax.recruiter.track.RecruiterRecruitInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.recruiter.track.RecruiterRecruitInterface Handler) {
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
        com.findajob.jobamax.recruiter.track.RecruiterRecruitInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.acceptButton.setOnClickListener(mCallback160);
            this.filterLayout.setOnClickListener(mCallback157);
            this.refuseButton.setOnClickListener(mCallback159);
            this.rewindButton.setOnClickListener(mCallback158);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.track.RecruiterRecruitInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCancelClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.track.RecruiterRecruitInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onJobOfferClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.track.RecruiterRecruitInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onRewindClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.track.RecruiterRecruitInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAcceptClicked();
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