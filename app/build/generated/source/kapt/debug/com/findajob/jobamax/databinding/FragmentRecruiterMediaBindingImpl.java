package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterMediaBindingImpl extends FragmentRecruiterMediaBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.customToolbar, 7);
        sViewsWithIds.put(R.id.logoLabel, 8);
        sViewsWithIds.put(R.id.videoLabel, 9);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.RelativeLayout mboundView2;
    @NonNull
    private final android.widget.RelativeLayout mboundView4;
    @NonNull
    private final androidx.appcompat.widget.AppCompatButton mboundView6;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback177;
    @Nullable
    private final android.view.View.OnClickListener mCallback178;
    @Nullable
    private final android.view.View.OnClickListener mCallback175;
    @Nullable
    private final android.view.View.OnClickListener mCallback176;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecruiterMediaBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterMediaBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ImageView) bindings[5]
            );
        this.logoTickIcon.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.RelativeLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView4 = (android.widget.RelativeLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (androidx.appcompat.widget.AppCompatButton) bindings[6];
        this.mboundView6.setTag(null);
        this.videoPresentationIcon.setTag(null);
        setRootTag(root);
        // listeners
        mCallback177 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback178 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback175 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback176 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
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
            setHandler((com.findajob.jobamax.recruiter.profile.media.RecruiterMediaInterface) variable);
        }
        else if (BR.company == variableId) {
            setCompany((com.findajob.jobamax.model.Company) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.recruiter.profile.media.RecruiterMediaInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setCompany(@Nullable com.findajob.jobamax.model.Company Company) {
        this.mCompany = Company;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.company);
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
        com.findajob.jobamax.recruiter.profile.media.RecruiterMediaInterface handler = mHandler;
        java.lang.String companyVideoPresentationUrl = null;
        boolean companyLogoUrlEmpty = false;
        boolean companyVideoPresentationUrlEmpty = false;
        android.graphics.drawable.Drawable companyLogoUrlEmptyLogoTickIconAndroidDrawableIcUploadJobPresentationLogoTickIconAndroidDrawableIcDone = null;
        com.findajob.jobamax.model.Company company = mCompany;
        java.lang.String companyLogoUrl = null;
        android.graphics.drawable.Drawable companyVideoPresentationUrlEmptyVideoPresentationIconAndroidDrawableIcUploadJobPresentationVideoPresentationIconAndroidDrawableIcDone = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (company != null) {
                    // read company.videoPresentationUrl
                    companyVideoPresentationUrl = company.getVideoPresentationUrl();
                    // read company.logoUrl
                    companyLogoUrl = company.getLogoUrl();
                }


                if (companyVideoPresentationUrl != null) {
                    // read company.videoPresentationUrl.empty
                    companyVideoPresentationUrlEmpty = companyVideoPresentationUrl.isEmpty();
                }
            if((dirtyFlags & 0x6L) != 0) {
                if(companyVideoPresentationUrlEmpty) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }
                if (companyLogoUrl != null) {
                    // read company.logoUrl.empty
                    companyLogoUrlEmpty = companyLogoUrl.isEmpty();
                }
            if((dirtyFlags & 0x6L) != 0) {
                if(companyLogoUrlEmpty) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read company.videoPresentationUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
                companyVideoPresentationUrlEmptyVideoPresentationIconAndroidDrawableIcUploadJobPresentationVideoPresentationIconAndroidDrawableIcDone = ((companyVideoPresentationUrlEmpty) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(videoPresentationIcon.getContext(), R.drawable.ic_upload_job_presentation)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(videoPresentationIcon.getContext(), R.drawable.ic_done)));
                // read company.logoUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
                companyLogoUrlEmptyLogoTickIconAndroidDrawableIcUploadJobPresentationLogoTickIconAndroidDrawableIcDone = ((companyLogoUrlEmpty) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(logoTickIcon.getContext(), R.drawable.ic_upload_job_presentation)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(logoTickIcon.getContext(), R.drawable.ic_done)));
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.logoTickIcon, companyLogoUrlEmptyLogoTickIconAndroidDrawableIcUploadJobPresentationLogoTickIconAndroidDrawableIcDone);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.videoPresentationIcon, companyVideoPresentationUrlEmptyVideoPresentationIconAndroidDrawableIcUploadJobPresentationVideoPresentationIconAndroidDrawableIcDone);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback175);
            this.mboundView2.setOnClickListener(mCallback176);
            this.mboundView4.setOnClickListener(mCallback177);
            this.mboundView6.setOnClickListener(mCallback178);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.media.RecruiterMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onVideoPresentationClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.media.RecruiterMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSubmitButtonClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.media.RecruiterMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.recruiter.profile.media.RecruiterMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCompanyLogoClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): company
        flag 2 (0x3L): null
        flag 3 (0x4L): company.logoUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
        flag 4 (0x5L): company.logoUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
        flag 5 (0x6L): company.videoPresentationUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
        flag 6 (0x7L): company.videoPresentationUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
    flag mapping end*/
    //end
}