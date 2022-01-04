package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentJobSeekerMediaBindingImpl extends FragmentJobSeekerMediaBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.customToolbar, 9);
        sViewsWithIds.put(R.id.profilePictureLabel, 10);
        sViewsWithIds.put(R.id.personalPresentationLabel, 11);
        sViewsWithIds.put(R.id.attachmentLabel, 12);
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
    private final android.widget.RelativeLayout mboundView6;
    @NonNull
    private final android.widget.Button mboundView8;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    @Nullable
    private final android.view.View.OnClickListener mCallback19;
    @Nullable
    private final android.view.View.OnClickListener mCallback20;
    @Nullable
    private final android.view.View.OnClickListener mCallback16;
    @Nullable
    private final android.view.View.OnClickListener mCallback18;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentJobSeekerMediaBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentJobSeekerMediaBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[12]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[11]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[10]
            );
        this.attachmentIcon.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.RelativeLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView4 = (android.widget.RelativeLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (android.widget.RelativeLayout) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView8 = (android.widget.Button) bindings[8];
        this.mboundView8.setTag(null);
        this.personalPresentationIcon.setTag(null);
        this.profilePicIcon.setTag(null);
        setRootTag(root);
        // listeners
        mCallback17 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback19 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback20 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback16 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback18 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
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
            setHandler((com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface) variable);
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
    public void setHandler(@Nullable com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface Handler) {
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
        boolean jobSeekerAttachmentCVLinkEmpty = false;
        android.graphics.drawable.Drawable jobSeekerAttachmentCVLinkEmptyAttachmentIconAndroidDrawableIcUploadJobPresentationAttachmentIconAndroidDrawableIcDone = null;
        java.lang.String jobSeekerProfilePicUrl = null;
        boolean jobSeekerProfilePicUrlEmpty = false;
        boolean jobSeekerPersonalPresentationLinkEmpty = false;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;
        java.lang.String jobSeekerPersonalPresentationLink = null;
        com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface handler = mHandler;
        android.graphics.drawable.Drawable jobSeekerPersonalPresentationLinkEmptyPersonalPresentationIconAndroidDrawableIcVideoPresentationPersonalPresentationIconAndroidDrawableIcDone = null;
        java.lang.String jobSeekerAttachmentCVLink = null;
        android.graphics.drawable.Drawable jobSeekerProfilePicUrlEmptyProfilePicIconAndroidDrawableIcUploadJobPresentationProfilePicIconAndroidDrawableIcDone = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                    // read jobSeeker.personalPresentationLink
                    jobSeekerPersonalPresentationLink = jobSeeker.getPersonalPresentationLink();
                    // read jobSeeker.attachmentCVLink
                    jobSeekerAttachmentCVLink = jobSeeker.getAttachmentCVLink();
                }


                if (jobSeekerProfilePicUrl != null) {
                    // read jobSeeker.profilePicUrl.empty
                    jobSeekerProfilePicUrlEmpty = jobSeekerProfilePicUrl.isEmpty();
                }
            if((dirtyFlags & 0x5L) != 0) {
                if(jobSeekerProfilePicUrlEmpty) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }
                if (jobSeekerPersonalPresentationLink != null) {
                    // read jobSeeker.personalPresentationLink.empty
                    jobSeekerPersonalPresentationLinkEmpty = jobSeekerPersonalPresentationLink.isEmpty();
                }
            if((dirtyFlags & 0x5L) != 0) {
                if(jobSeekerPersonalPresentationLinkEmpty) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }
                if (jobSeekerAttachmentCVLink != null) {
                    // read jobSeeker.attachmentCVLink.empty
                    jobSeekerAttachmentCVLinkEmpty = jobSeekerAttachmentCVLink.isEmpty();
                }
            if((dirtyFlags & 0x5L) != 0) {
                if(jobSeekerAttachmentCVLinkEmpty) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read jobSeeker.profilePicUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
                jobSeekerProfilePicUrlEmptyProfilePicIconAndroidDrawableIcUploadJobPresentationProfilePicIconAndroidDrawableIcDone = ((jobSeekerProfilePicUrlEmpty) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(profilePicIcon.getContext(), R.drawable.ic_upload_job_presentation)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(profilePicIcon.getContext(), R.drawable.ic_done)));
                // read jobSeeker.personalPresentationLink.empty ? @android:drawable/ic_video_presentation : @android:drawable/ic_done
                jobSeekerPersonalPresentationLinkEmptyPersonalPresentationIconAndroidDrawableIcVideoPresentationPersonalPresentationIconAndroidDrawableIcDone = ((jobSeekerPersonalPresentationLinkEmpty) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(personalPresentationIcon.getContext(), R.drawable.ic_video_presentation)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(personalPresentationIcon.getContext(), R.drawable.ic_done)));
                // read jobSeeker.attachmentCVLink.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
                jobSeekerAttachmentCVLinkEmptyAttachmentIconAndroidDrawableIcUploadJobPresentationAttachmentIconAndroidDrawableIcDone = ((jobSeekerAttachmentCVLinkEmpty) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(attachmentIcon.getContext(), R.drawable.ic_upload_job_presentation)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(attachmentIcon.getContext(), R.drawable.ic_done)));
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.attachmentIcon, jobSeekerAttachmentCVLinkEmptyAttachmentIconAndroidDrawableIcUploadJobPresentationAttachmentIconAndroidDrawableIcDone);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.personalPresentationIcon, jobSeekerPersonalPresentationLinkEmptyPersonalPresentationIconAndroidDrawableIcVideoPresentationPersonalPresentationIconAndroidDrawableIcDone);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.profilePicIcon, jobSeekerProfilePicUrlEmptyProfilePicIconAndroidDrawableIcUploadJobPresentationProfilePicIconAndroidDrawableIcDone);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback16);
            this.mboundView2.setOnClickListener(mCallback17);
            this.mboundView4.setOnClickListener(mCallback18);
            this.mboundView6.setOnClickListener(mCallback19);
            this.mboundView8.setOnClickListener(mCallback20);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onProfilePictureClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onAttachmentClicked();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface handler = mHandler;
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
                com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackButtonClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.jobseeker.profile.media.JobSeekerMediaInterface handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onPersonalPresentationClicked();
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
        flag 3 (0x4L): jobSeeker.attachmentCVLink.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
        flag 4 (0x5L): jobSeeker.attachmentCVLink.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
        flag 5 (0x6L): jobSeeker.personalPresentationLink.empty ? @android:drawable/ic_video_presentation : @android:drawable/ic_done
        flag 6 (0x7L): jobSeeker.personalPresentationLink.empty ? @android:drawable/ic_video_presentation : @android:drawable/ic_done
        flag 7 (0x8L): jobSeeker.profilePicUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
        flag 8 (0x9L): jobSeeker.profilePicUrl.empty ? @android:drawable/ic_upload_job_presentation : @android:drawable/ic_done
    flag mapping end*/
    //end
}