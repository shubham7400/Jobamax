package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerSocialLinksBindingImpl extends FragmentJobSeekerSocialLinksBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    @NonNull
    private final android.widget.LinearLayout mboundView5;
    @NonNull
    private final android.widget.LinearLayout mboundView7;
    @NonNull
    private final android.widget.LinearLayout mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback235;
    @Nullable
    private final android.view.View.OnClickListener mCallback233;
    @Nullable
    private final android.view.View.OnClickListener mCallback231;
    @Nullable
    private final android.view.View.OnClickListener mCallback236;
    @Nullable
    private final android.view.View.OnClickListener mCallback234;
    @Nullable
    private final android.view.View.OnClickListener mCallback232;
    @Nullable
    private final android.view.View.OnClickListener mCallback230;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etFacebookandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of jobSeeker.facebook
            //         is jobSeeker.setFacebook((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etFacebook);
            // localize variables for thread safety
            // jobSeeker
            com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel jobSeeker = mJobSeeker;
            // jobSeeker != null
            boolean jobSeekerJavaLangObjectNull = false;
            // jobSeeker.facebook
            java.lang.String jobSeekerFacebook = null;



            jobSeekerJavaLangObjectNull = (jobSeeker) != (null);
            if (jobSeekerJavaLangObjectNull) {




                jobSeeker.setFacebook(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener etInstagramandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of jobSeeker.instagram
            //         is jobSeeker.setInstagram((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etInstagram);
            // localize variables for thread safety
            // jobSeeker
            com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel jobSeeker = mJobSeeker;
            // jobSeeker != null
            boolean jobSeekerJavaLangObjectNull = false;
            // jobSeeker.instagram
            java.lang.String jobSeekerInstagram = null;



            jobSeekerJavaLangObjectNull = (jobSeeker) != (null);
            if (jobSeekerJavaLangObjectNull) {




                jobSeeker.setInstagram(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener etLinkedinandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of jobSeeker.linkedin
            //         is jobSeeker.setLinkedin((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etLinkedin);
            // localize variables for thread safety
            // jobSeeker.linkedin
            java.lang.String jobSeekerLinkedin = null;
            // jobSeeker
            com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel jobSeeker = mJobSeeker;
            // jobSeeker != null
            boolean jobSeekerJavaLangObjectNull = false;



            jobSeekerJavaLangObjectNull = (jobSeeker) != (null);
            if (jobSeekerJavaLangObjectNull) {




                jobSeeker.setLinkedin(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener etTwitterandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of jobSeeker.twitter
            //         is jobSeeker.setTwitter((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etTwitter);
            // localize variables for thread safety
            // jobSeeker
            com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel jobSeeker = mJobSeeker;
            // jobSeeker.twitter
            java.lang.String jobSeekerTwitter = null;
            // jobSeeker != null
            boolean jobSeekerJavaLangObjectNull = false;



            jobSeekerJavaLangObjectNull = (jobSeeker) != (null);
            if (jobSeekerJavaLangObjectNull) {




                jobSeeker.setTwitter(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentJobSeekerSocialLinksBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerSocialLinksBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            , (android.widget.Button) bindings[11]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[6]
            );
        this.btnEdit.setTag(null);
        this.btnSave.setTag(null);
        this.etFacebook.setTag(null);
        this.etInstagram.setTag(null);
        this.etLinkedin.setTag(null);
        this.etTwitter.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (android.widget.LinearLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView7 = (android.widget.LinearLayout) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView9 = (android.widget.LinearLayout) bindings[9];
        this.mboundView9.setTag(null);
        setRootTag(root);
        // listeners
        mCallback235 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback233 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback231 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback236 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 7);
        mCallback234 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback232 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback230 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
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
            setJobSeeker((com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setJobSeeker(@Nullable com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel JobSeeker) {
        this.mJobSeeker = JobSeeker;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.jobSeeker);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface Handler) {
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
        java.lang.String jobSeekerTwitter = null;
        java.lang.String jobSeekerInstagram = null;
        com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel jobSeeker = mJobSeeker;
        java.lang.String jobSeekerFacebook = null;
        com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
        java.lang.String jobSeekerLinkedin = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.twitter
                    jobSeekerTwitter = jobSeeker.getTwitter();
                    // read jobSeeker.instagram
                    jobSeekerInstagram = jobSeeker.getInstagram();
                    // read jobSeeker.facebook
                    jobSeekerFacebook = jobSeeker.getFacebook();
                    // read jobSeeker.linkedin
                    jobSeekerLinkedin = jobSeeker.getLinkedin();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnEdit.setOnClickListener(mCallback231);
            this.btnSave.setOnClickListener(mCallback236);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etFacebook, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etFacebookandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etInstagram, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etInstagramandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etLinkedin, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etLinkedinandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etTwitter, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etTwitterandroidTextAttrChanged);
            this.mboundView1.setOnClickListener(mCallback230);
            this.mboundView3.setOnClickListener(mCallback232);
            this.mboundView5.setOnClickListener(mCallback233);
            this.mboundView7.setOnClickListener(mCallback234);
            this.mboundView9.setOnClickListener(mCallback235);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etFacebook, jobSeekerFacebook);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etInstagram, jobSeekerInstagram);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etLinkedin, jobSeekerLinkedin);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etTwitter, jobSeekerTwitter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 6: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onLinkedinIconClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onTwitterIconClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onEditButtonClicked();
                }
                break;
            }
            case 7: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSaveButtonClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onInstagramIconClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onFacebookIconClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
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