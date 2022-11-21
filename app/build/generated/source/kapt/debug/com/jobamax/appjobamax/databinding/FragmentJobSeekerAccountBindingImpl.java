package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerAccountBindingImpl extends FragmentJobSeekerAccountBinding implements com.jobamax.appjobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 13);
        sViewsWithIds.put(R.id.iv_back_button, 14);
        sViewsWithIds.put(R.id.tv_change_password, 15);
        sViewsWithIds.put(R.id.sb_push_notification, 16);
        sViewsWithIds.put(R.id.sc_hide_profile, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.TextView mboundView11;
    @NonNull
    private final android.widget.TextView mboundView12;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
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
    private final android.view.View.OnClickListener mCallback16;
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    @Nullable
    private final android.view.View.OnClickListener mCallback14;
    @Nullable
    private final android.view.View.OnClickListener mCallback15;
    @Nullable
    private final android.view.View.OnClickListener mCallback12;
    @Nullable
    private final android.view.View.OnClickListener mCallback13;
    @Nullable
    private final android.view.View.OnClickListener mCallback10;
    @Nullable
    private final android.view.View.OnClickListener mCallback11;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    @Nullable
    private final android.view.View.OnClickListener mCallback18;
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerAccountBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerAccountBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.RelativeLayout) bindings[13]
            , (androidx.appcompat.widget.SwitchCompat) bindings[16]
            , (androidx.appcompat.widget.SwitchCompat) bindings[17]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[3]
            );
        this.civUser.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (android.widget.TextView) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView12 = (android.widget.TextView) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        this.tvNewsletter.setTag(null);
        setRootTag(root);
        // listeners
        mCallback16 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 9);
        mCallback17 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 10);
        mCallback14 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 7);
        mCallback15 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 8);
        mCallback12 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 5);
        mCallback13 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 6);
        mCallback10 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 3);
        mCallback11 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 4);
        mCallback9 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 2);
        mCallback18 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 11);
        mCallback8 = new com.jobamax.appjobamax.generated.callback.OnClickListener(this, 1);
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
            setHandler((com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface) variable);
        }
        else if (BR.jobSeeker == variableId) {
            setJobSeeker((com.jobamax.appjobamax.model.JobSeeker) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setJobSeeker(@Nullable com.jobamax.appjobamax.model.JobSeeker JobSeeker) {
        this.mJobSeeker = JobSeeker;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.jobSeeker);
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
        com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
        java.lang.String jobSeekerProfilePicUrl = null;
        com.jobamax.appjobamax.model.JobSeeker jobSeeker = mJobSeeker;

        if ((dirtyFlags & 0x6L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.jobamax.appjobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.civUser, jobSeekerProfilePicUrl);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView10.setOnClickListener(mCallback16);
            this.mboundView11.setOnClickListener(mCallback17);
            this.mboundView12.setOnClickListener(mCallback18);
            this.mboundView2.setOnClickListener(mCallback8);
            this.mboundView4.setOnClickListener(mCallback10);
            this.mboundView5.setOnClickListener(mCallback11);
            this.mboundView6.setOnClickListener(mCallback12);
            this.mboundView7.setOnClickListener(mCallback13);
            this.mboundView8.setOnClickListener(mCallback14);
            this.mboundView9.setOnClickListener(mCallback15);
            this.tvNewsletter.setOnClickListener(mCallback9);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 9: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onTermsOfServiceClicked();
                }
                break;
            }
            case 10: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
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
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSafetyTipsClicked();
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPrivacyPolicyClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onEmailUsClicked();
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCommunityGuidelinesClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onShareJobamaxClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
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
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onNewsletterClicked();
                }
                break;
            }
            case 11: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onDeleteAccountClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.jobamax.appjobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPersonalInformationClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): jobSeeker
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}