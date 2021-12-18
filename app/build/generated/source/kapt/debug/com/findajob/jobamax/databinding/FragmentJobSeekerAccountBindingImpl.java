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
    private final android.view.View.OnClickListener mCallback203;
    @Nullable
    private final android.view.View.OnClickListener mCallback201;
    @Nullable
    private final android.view.View.OnClickListener mCallback188;
    @Nullable
    private final android.view.View.OnClickListener mCallback186;
    @Nullable
    private final android.view.View.OnClickListener mCallback198;
    @Nullable
    private final android.widget.CompoundButton.OnCheckedChangeListener mCallback184;
    @Nullable
    private final android.view.View.OnClickListener mCallback196;
    @Nullable
    private final android.view.View.OnClickListener mCallback182;
    @Nullable
    private final android.view.View.OnClickListener mCallback194;
    @Nullable
    private final android.view.View.OnClickListener mCallback192;
    @Nullable
    private final android.view.View.OnClickListener mCallback202;
    @Nullable
    private final android.view.View.OnClickListener mCallback199;
    @Nullable
    private final android.view.View.OnClickListener mCallback189;
    @Nullable
    private final android.view.View.OnClickListener mCallback200;
    @Nullable
    private final android.view.View.OnClickListener mCallback197;
    @Nullable
    private final android.view.View.OnClickListener mCallback187;
    @Nullable
    private final android.view.View.OnClickListener mCallback195;
    @Nullable
    private final android.view.View.OnClickListener mCallback185;
    @Nullable
    private final android.view.View.OnClickListener mCallback193;
    @Nullable
    private final android.view.View.OnClickListener mCallback183;
    @Nullable
    private final android.view.View.OnClickListener mCallback191;
    @Nullable
    private final android.view.View.OnClickListener mCallback190;
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
        mCallback203 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 22);
        mCallback201 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 20);
        mCallback188 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 7);
        mCallback186 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback198 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 17);
        mCallback184 = new com.findajob.jobamax.generated.callback.OnCheckedChangeListener(this, 3);
        mCallback196 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 15);
        mCallback182 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback194 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 13);
        mCallback192 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 11);
        mCallback202 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 21);
        mCallback199 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 18);
        mCallback189 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 8);
        mCallback200 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 19);
        mCallback197 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 16);
        mCallback187 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback195 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 14);
        mCallback185 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback193 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 12);
        mCallback183 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback191 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 10);
        mCallback190 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 9);
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

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.hideMeFlag, mCallback184, (androidx.databinding.InverseBindingListener)null);
            this.mboundView1.setOnClickListener(mCallback182);
            this.mboundView10.setOnClickListener(mCallback191);
            this.mboundView11.setOnClickListener(mCallback192);
            this.mboundView12.setOnClickListener(mCallback193);
            this.mboundView13.setOnClickListener(mCallback194);
            this.mboundView14.setOnClickListener(mCallback195);
            this.mboundView15.setOnClickListener(mCallback196);
            this.mboundView16.setOnClickListener(mCallback197);
            this.mboundView17.setOnClickListener(mCallback198);
            this.mboundView18.setOnClickListener(mCallback199);
            this.mboundView19.setOnClickListener(mCallback200);
            this.mboundView2.setOnClickListener(mCallback183);
            this.mboundView20.setOnClickListener(mCallback201);
            this.mboundView21.setOnClickListener(mCallback202);
            this.mboundView22.setOnClickListener(mCallback203);
            this.mboundView4.setOnClickListener(mCallback185);
            this.mboundView5.setOnClickListener(mCallback186);
            this.mboundView6.setOnClickListener(mCallback187);
            this.mboundView7.setOnClickListener(mCallback188);
            this.mboundView8.setOnClickListener(mCallback189);
            this.mboundView9.setOnClickListener(mCallback190);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
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