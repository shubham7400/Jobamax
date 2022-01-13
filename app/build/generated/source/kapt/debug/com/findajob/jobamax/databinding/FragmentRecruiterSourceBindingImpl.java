package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterSourceBindingImpl extends FragmentRecruiterSourceBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_filter_layout, 6);
        sViewsWithIds.put(R.id.sourceLabel, 7);
        sViewsWithIds.put(R.id.cardStackView, 8);
        sViewsWithIds.put(R.id.footerLayout, 9);
        sViewsWithIds.put(R.id.noJobSeekerFoundLabel, 10);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback227;
    @Nullable
    private final android.view.View.OnClickListener mCallback225;
    @Nullable
    private final android.view.View.OnClickListener mCallback226;
    @Nullable
    private final android.view.View.OnClickListener mCallback223;
    @Nullable
    private final android.view.View.OnClickListener mCallback224;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecruiterSourceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterSourceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.yuyakaido.android.cardstackview.CardStackView) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[4]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[3]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[5]
            , (android.widget.TextView) bindings[7]
            );
        this.filterLayout.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.ImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.refuseButton.setTag(null);
        this.rewindButton.setTag(null);
        this.sourceButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback227 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback225 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback226 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback223 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback224 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
            setHandler((com.findajob.jobamax.recruiter.track.RecruiterSourceInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.recruiter.track.RecruiterSourceInterface Handler) {
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
        com.findajob.jobamax.recruiter.track.RecruiterSourceInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.filterLayout.setOnClickListener(mCallback223);
            this.mboundView2.setOnClickListener(mCallback224);
            this.refuseButton.setOnClickListener(mCallback226);
            this.rewindButton.setOnClickListener(mCallback225);
            this.sourceButton.setOnClickListener(mCallback227);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.track.RecruiterSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onChatClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.track.RecruiterSourceInterface handler = mHandler;
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
                com.findajob.jobamax.recruiter.track.RecruiterSourceInterface handler = mHandler;
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
                com.findajob.jobamax.recruiter.track.RecruiterSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSourceClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.track.RecruiterSourceInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSourceClicked();
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