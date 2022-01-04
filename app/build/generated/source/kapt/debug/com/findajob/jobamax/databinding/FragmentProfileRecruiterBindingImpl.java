package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProfileRecruiterBindingImpl extends FragmentProfileRecruiterBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.headerLayout, 9);
        sViewsWithIds.put(R.id.companyName, 10);
        sViewsWithIds.put(R.id.vp, 11);
        sViewsWithIds.put(R.id.tl, 12);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView2;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    @NonNull
    private final android.widget.LinearLayout mboundView4;
    @NonNull
    private final android.widget.LinearLayout mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final androidx.cardview.widget.CardView mboundView8;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback38;
    @Nullable
    private final android.view.View.OnClickListener mCallback39;
    @Nullable
    private final android.view.View.OnClickListener mCallback36;
    @Nullable
    private final android.view.View.OnClickListener mCallback37;
    @Nullable
    private final android.view.View.OnClickListener mCallback35;
    @Nullable
    private final android.view.View.OnClickListener mCallback41;
    @Nullable
    private final android.view.View.OnClickListener mCallback42;
    @Nullable
    private final android.view.View.OnClickListener mCallback40;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProfileRecruiterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentProfileRecruiterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[10]
            , (android.widget.LinearLayout) bindings[9]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (com.google.android.material.tabs.TabLayout) bindings[12]
            , (androidx.viewpager2.widget.ViewPager2) bindings[11]
            );
        this.ivCompanyIcon.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.LinearLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.LinearLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.LinearLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (androidx.cardview.widget.CardView) bindings[8];
        this.mboundView8.setTag(null);
        setRootTag(root);
        // listeners
        mCallback38 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback39 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback36 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback37 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback35 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback41 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 7);
        mCallback42 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 8);
        mCallback40 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
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
            setHandler((com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface) variable);
        }
        else if (BR.forSubscription == variableId) {
            setForSubscription((java.lang.Boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setForSubscription(@Nullable java.lang.Boolean ForSubscription) {
        this.mForSubscription = ForSubscription;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.forSubscription);
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
        com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
        boolean forSubscription = false;
        java.lang.Boolean ForSubscription1 = mForSubscription;
        boolean androidxDatabindingViewDataBindingSafeUnboxForSubscription = false;

        if ((dirtyFlags & 0x6L) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(forSubscription)
                androidxDatabindingViewDataBindingSafeUnboxForSubscription = androidx.databinding.ViewDataBinding.safeUnbox(ForSubscription1);


                // read !androidx.databinding.ViewDataBinding.safeUnbox(forSubscription)
                forSubscription = !androidxDatabindingViewDataBindingSafeUnboxForSubscription;
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivCompanyIcon.setOnClickListener(mCallback35);
            this.mboundView2.setOnClickListener(mCallback36);
            this.mboundView3.setOnClickListener(mCallback37);
            this.mboundView4.setOnClickListener(mCallback38);
            this.mboundView5.setOnClickListener(mCallback39);
            this.mboundView6.setOnClickListener(mCallback40);
            this.mboundView7.setOnClickListener(mCallback41);
            this.mboundView8.setOnClickListener(mCallback42);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.findajob.jobamax.util.BindingAdapterUtilKt.showView(this.mboundView6, ForSubscription1);
            com.findajob.jobamax.util.BindingAdapterUtilKt.showView(this.mboundView7, forSubscription);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onJobOfferClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onMediaClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAccountClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCompanyClick();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onProfilePictureClicked();
                }
                break;
            }
            case 7: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onUpgradeClicked();
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onGetJombaxAnalytics();
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.RecruiterProfileInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubscriptionClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): forSubscription
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}