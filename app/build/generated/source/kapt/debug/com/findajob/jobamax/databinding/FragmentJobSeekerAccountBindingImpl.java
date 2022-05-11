package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerAccountBindingImpl extends FragmentJobSeekerAccountBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 15);
        sViewsWithIds.put(R.id.iv_back_button, 16);
        sViewsWithIds.put(R.id.cl_change_language, 17);
        sViewsWithIds.put(R.id.tv_change_language, 18);
        sViewsWithIds.put(R.id.tv_current_language, 19);
        sViewsWithIds.put(R.id.iv_change_language_arrow, 20);
        sViewsWithIds.put(R.id.sb_push_notification, 21);
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
    private final android.widget.TextView mboundView13;
    @NonNull
    private final android.widget.TextView mboundView14;
    @NonNull
    private final android.widget.TextView mboundView2;
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
    private final android.view.View.OnClickListener mCallback39;
    @Nullable
    private final android.view.View.OnClickListener mCallback37;
    @Nullable
    private final android.view.View.OnClickListener mCallback45;
    @Nullable
    private final android.view.View.OnClickListener mCallback35;
    @Nullable
    private final android.view.View.OnClickListener mCallback43;
    @Nullable
    private final android.view.View.OnClickListener mCallback33;
    @Nullable
    private final android.view.View.OnClickListener mCallback42;
    @Nullable
    private final android.view.View.OnClickListener mCallback40;
    @Nullable
    private final android.view.View.OnClickListener mCallback38;
    @Nullable
    private final android.view.View.OnClickListener mCallback36;
    @Nullable
    private final android.view.View.OnClickListener mCallback34;
    @Nullable
    private final android.view.View.OnClickListener mCallback44;
    @Nullable
    private final android.view.View.OnClickListener mCallback41;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerAccountBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerAccountBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[17]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.RelativeLayout) bindings[15]
            , (androidx.appcompat.widget.SwitchCompat) bindings[21]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[4]
            );
        this.civUser.setTag(null);
        this.ivMyPersonalInfo.setTag(null);
        this.ivNewsletterArrow.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
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
        mCallback39 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 7);
        mCallback37 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback45 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 13);
        mCallback35 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback43 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 11);
        mCallback33 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback42 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 10);
        mCallback40 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 8);
        mCallback38 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback36 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback34 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback44 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 12);
        mCallback41 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 9);
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
        if (BR.jobSeeker == variableId) {
            setJobSeeker((com.findajob.jobamax.model.JobSeeker) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setJobSeeker(@Nullable com.findajob.jobamax.model.JobSeeker JobSeeker) {
        this.mJobSeeker = JobSeeker;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.jobSeeker);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
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
        java.lang.String jobSeekerProfilePicUrl = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;
        com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface handler = mHandler;

        if ((dirtyFlags & 0x5L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.civUser, jobSeekerProfilePicUrl);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivMyPersonalInfo.setOnClickListener(mCallback34);
            this.ivNewsletterArrow.setOnClickListener(mCallback36);
            this.mboundView10.setOnClickListener(mCallback41);
            this.mboundView11.setOnClickListener(mCallback42);
            this.mboundView12.setOnClickListener(mCallback43);
            this.mboundView13.setOnClickListener(mCallback44);
            this.mboundView14.setOnClickListener(mCallback45);
            this.mboundView2.setOnClickListener(mCallback33);
            this.mboundView6.setOnClickListener(mCallback37);
            this.mboundView7.setOnClickListener(mCallback38);
            this.mboundView8.setOnClickListener(mCallback39);
            this.mboundView9.setOnClickListener(mCallback40);
            this.tvNewsletter.setOnClickListener(mCallback35);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 7: {
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
            case 5: {
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
            case 13: {
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
            case 3: {
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
            case 11: {
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
            case 1: {
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


                    handler.onPrivacyPolicyClicked();
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


                    handler.onCommunityGuidelinesClicked();
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


                    handler.onHelpAndSupportClicked();
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


                    handler.onNewsletterClicked();
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
            case 12: {
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
            case 9: {
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
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}