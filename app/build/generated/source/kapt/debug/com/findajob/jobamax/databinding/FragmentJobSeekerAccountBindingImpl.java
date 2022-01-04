package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerAccountBindingImpl extends FragmentJobSeekerAccountBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener, com.findajob.jobamax.generated.callback.OnCheckedChangeListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 23);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatImageView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.TextView mboundView11;
    @NonNull
    private final android.widget.TextView mboundView12;
    @NonNull
    private final android.widget.TextView mboundView13;
    @NonNull
    private final android.widget.TextView mboundView14;
    @NonNull
    private final android.widget.TextView mboundView15;
    @NonNull
    private final android.widget.TextView mboundView16;
    @NonNull
    private final android.widget.TextView mboundView17;
    @NonNull
    private final android.widget.TextView mboundView18;
    @NonNull
    private final android.widget.TextView mboundView19;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView20;
    @NonNull
    private final android.widget.TextView mboundView21;
    @NonNull
    private final android.widget.TextView mboundView22;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.LinearLayout mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.TextView mboundView8;
    @NonNull
    private final android.widget.TextView mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback106;
    @Nullable
    private final android.view.View.OnClickListener mCallback104;
    @Nullable
    private final android.view.View.OnClickListener mCallback89;
    @Nullable
    private final android.view.View.OnClickListener mCallback102;
    @Nullable
    private final android.view.View.OnClickListener mCallback100;
    @Nullable
    private final android.view.View.OnClickListener mCallback99;
    @Nullable
    private final android.view.View.OnClickListener mCallback96;
    @Nullable
    private final android.view.View.OnClickListener mCallback94;
    @Nullable
    private final android.view.View.OnClickListener mCallback92;
    @Nullable
    private final android.widget.CompoundButton.OnCheckedChangeListener mCallback90;
    @Nullable
    private final android.view.View.OnClickListener mCallback108;
    @Nullable
    private final android.view.View.OnClickListener mCallback107;
    @Nullable
    private final android.view.View.OnClickListener mCallback105;
    @Nullable
    private final android.view.View.OnClickListener mCallback103;
    @Nullable
    private final android.view.View.OnClickListener mCallback98;
    @Nullable
    private final android.view.View.OnClickListener mCallback88;
    @Nullable
    private final android.view.View.OnClickListener mCallback101;
    @Nullable
    private final android.view.View.OnClickListener mCallback97;
    @Nullable
    private final android.view.View.OnClickListener mCallback95;
    @Nullable
    private final android.view.View.OnClickListener mCallback93;
    @Nullable
    private final android.view.View.OnClickListener mCallback91;
    @Nullable
    private final android.view.View.OnClickListener mCallback109;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerAccountBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerAccountBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.SwitchCompat) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[23]
            );
        this.hideMeFlag.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.appcompat.widget.AppCompatImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (android.widget.TextView) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView12 = (android.widget.TextView) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView13 = (android.widget.TextView) bindings[13];
        this.mboundView13.setTag(null);
        this.mboundView14 = (android.widget.TextView) bindings[14];
        this.mboundView14.setTag(null);
        this.mboundView15 = (android.widget.TextView) bindings[15];
        this.mboundView15.setTag(null);
        this.mboundView16 = (android.widget.TextView) bindings[16];
        this.mboundView16.setTag(null);
        this.mboundView17 = (android.widget.TextView) bindings[17];
        this.mboundView17.setTag(null);
        this.mboundView18 = (android.widget.TextView) bindings[18];
        this.mboundView18.setTag(null);
        this.mboundView19 = (android.widget.TextView) bindings[19];
        this.mboundView19.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView20 = (android.widget.TextView) bindings[20];
        this.mboundView20.setTag(null);
        this.mboundView21 = (android.widget.TextView) bindings[21];
        this.mboundView21.setTag(null);
        this.mboundView22 = (android.widget.TextView) bindings[22];
        this.mboundView22.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.LinearLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        setRootTag(root);
        // listeners
        mCallback106 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 19);
        mCallback104 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 17);
        mCallback89 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback102 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 15);
        mCallback100 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 13);
        mCallback99 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 12);
        mCallback96 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 9);
        mCallback94 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 7);
        mCallback92 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback90 = new com.findajob.jobamax.generated.callback.OnCheckedChangeListener(this, 3);
        mCallback108 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 21);
        mCallback107 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 20);
        mCallback105 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 18);
        mCallback103 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 16);
        mCallback98 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 11);
        mCallback88 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback101 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 14);
        mCallback97 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 10);
        mCallback95 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 8);
        mCallback93 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback91 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback109 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 22);
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
            setHandler((com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface Handler) {
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
        com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.hideMeFlag, mCallback90, (androidx.databinding.InverseBindingListener)null);
            this.mboundView1.setOnClickListener(mCallback88);
            this.mboundView10.setOnClickListener(mCallback97);
            this.mboundView11.setOnClickListener(mCallback98);
            this.mboundView12.setOnClickListener(mCallback99);
            this.mboundView13.setOnClickListener(mCallback100);
            this.mboundView14.setOnClickListener(mCallback101);
            this.mboundView15.setOnClickListener(mCallback102);
            this.mboundView16.setOnClickListener(mCallback103);
            this.mboundView17.setOnClickListener(mCallback104);
            this.mboundView18.setOnClickListener(mCallback105);
            this.mboundView19.setOnClickListener(mCallback106);
            this.mboundView2.setOnClickListener(mCallback89);
            this.mboundView20.setOnClickListener(mCallback107);
            this.mboundView21.setOnClickListener(mCallback108);
            this.mboundView22.setOnClickListener(mCallback109);
            this.mboundView4.setOnClickListener(mCallback91);
            this.mboundView5.setOnClickListener(mCallback92);
            this.mboundView6.setOnClickListener(mCallback93);
            this.mboundView7.setOnClickListener(mCallback94);
            this.mboundView8.setOnClickListener(mCallback95);
            this.mboundView9.setOnClickListener(mCallback96);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 19: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPrivacyPreferencesClicked();
                }
                break;
            }
            case 17: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onTermsOfServiceClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPersonalInformationClicked();
                }
                break;
            }
            case 15: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSafetyTipsClicked();
                }
                break;
            }
            case 13: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onEmailUsClicked();
                }
                break;
            }
            case 12: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onHelpAndSupportClicked();
                }
                break;
            }
            case 9: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPaymentMethodsClicked();
                }
                break;
            }
            case 7: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPushNotificationsClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSocialLayoutClicked();
                }
                break;
            }
            case 21: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onTemporaryDisableAccountClicked();
                }
                break;
            }
            case 20: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onLogoutClicked();
                }
                break;
            }
            case 18: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onLicensesClicked();
                }
                break;
            }
            case 16: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPrivacyPolicyClicked();
                }
                break;
            }
            case 11: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onShareJobamaxClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
                }
                break;
            }
            case 14: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCommunityGuidelinesClicked();
                }
                break;
            }
            case 10: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onRestorePurchaseClicked();
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onNewsletterClicked();
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPasswordClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onManageReadReceiptsClicked();
                }
                break;
            }
            case 22: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onDeleteAccountClicked();
                }
                break;
            }
        }
    }
    public final void _internalCallbackOnCheckedChanged(int sourceId , android.widget.CompoundButton callbackArg_0, boolean callbackArg_1) {
        // localize variables for thread safety
        // handler
        com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
        // handler != null
        boolean handlerJavaLangObjectNull = false;



        handlerJavaLangObjectNull = (handler) != (null);
        if (handlerJavaLangObjectNull) {



            handler.toggleHideMe(callbackArg_1);
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