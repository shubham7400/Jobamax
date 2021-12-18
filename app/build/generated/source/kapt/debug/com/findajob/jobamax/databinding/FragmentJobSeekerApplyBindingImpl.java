package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerApplyBindingImpl extends FragmentJobSeekerApplyBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.keywordLabel, 6);
        sViewsWithIds.put(R.id.footerLayout, 7);
        sViewsWithIds.put(R.id.cardStackView, 8);
        sViewsWithIds.put(R.id.progressBar, 9);
        sViewsWithIds.put(R.id.noJobFoundLabel, 10);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback155;
    @Nullable
    private final android.view.View.OnClickListener mCallback156;
    @Nullable
    private final android.view.View.OnClickListener mCallback153;
    @Nullable
    private final android.view.View.OnClickListener mCallback154;
    @Nullable
    private final android.view.View.OnClickListener mCallback152;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerApplyBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerApplyBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[5]
            , (com.yuyakaido.android.cardstackview.CardStackView) bindings[8]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[4]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (android.widget.ProgressBar) bindings[9]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[3]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[2]
            );
        this.acceptButton.setTag(null);
        this.chatButton.setTag(null);
        this.filterLayout.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rejectButton.setTag(null);
        this.rewindButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback155 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback156 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback153 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback154 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback152 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
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
            setHandler((com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface Handler) {
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
        com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.acceptButton.setOnClickListener(mCallback156);
            this.chatButton.setOnClickListener(mCallback155);
            this.filterLayout.setOnClickListener(mCallback152);
            this.rejectButton.setOnClickListener(mCallback154);
            this.rewindButton.setOnClickListener(mCallback153);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onChatClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAcceptClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onRewindClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.track.JobSeekerApplyInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSearchClicked();
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