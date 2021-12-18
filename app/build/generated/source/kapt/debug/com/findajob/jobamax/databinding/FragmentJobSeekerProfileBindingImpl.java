package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerProfileBindingImpl extends FragmentJobSeekerProfileBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.headerLayout, 8);
        sViewsWithIds.put(R.id.userNameLabel, 9);
        sViewsWithIds.put(R.id.vp, 10);
        sViewsWithIds.put(R.id.tl, 11);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView2;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    @NonNull
    private final android.widget.LinearLayout mboundView4;
    @NonNull
    private final android.widget.LinearLayout mboundView5;
    @NonNull
    private final androidx.cardview.widget.CardView mboundView6;
    @NonNull
    private final androidx.cardview.widget.CardView mboundView7;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback7;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[8]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (com.google.android.material.tabs.TabLayout) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (androidx.viewpager2.widget.ViewPager2) bindings[10]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.LinearLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.LinearLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.LinearLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (androidx.cardview.widget.CardView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (androidx.cardview.widget.CardView) bindings[7];
        this.mboundView7.setTag(null);
        this.profilePicIcon.setTag(null);
        setRootTag(root);
        // listeners
        mCallback7 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 7);
        mCallback5 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback6 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback3 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback4 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback1 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
            setHandler((com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface Handler) {
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
        com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.mboundView2.setOnClickListener(mCallback2);
            this.mboundView3.setOnClickListener(mCallback3);
            this.mboundView4.setOnClickListener(mCallback4);
            this.mboundView5.setOnClickListener(mCallback5);
            this.mboundView6.setOnClickListener(mCallback6);
            this.mboundView7.setOnClickListener(mCallback7);
            this.profilePicIcon.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 7: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBecomeAmbassadorClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onMediaClicked();
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onGetJobamaxReachClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCVClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onJobSearchClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onProfilePictureClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAccountClicked();
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