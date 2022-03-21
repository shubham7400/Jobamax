package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerAboutMeBindingImpl extends FragmentSeekerAboutMeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView12, 7);
        sViewsWithIds.put(R.id.relativeLayout, 8);
        sViewsWithIds.put(R.id.iv_back_button, 9);
        sViewsWithIds.put(R.id.iv_edit, 10);
        sViewsWithIds.put(R.id.ll_social_media, 11);
        sViewsWithIds.put(R.id.iv_insta, 12);
        sViewsWithIds.put(R.id.iv_linkedin, 13);
        sViewsWithIds.put(R.id.iv_tiktok, 14);
        sViewsWithIds.put(R.id.iv_barcode, 15);
        sViewsWithIds.put(R.id.textView9, 16);
        sViewsWithIds.put(R.id.textView10, 17);
        sViewsWithIds.put(R.id.textView140, 18);
        sViewsWithIds.put(R.id.textView11, 19);
        sViewsWithIds.put(R.id.btn_save_info, 20);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerAboutMeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerAboutMeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[20]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[5]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.ImageView) bindings[14]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[16]
            );
        this.etDescription.setTag(null);
        this.etFirstName.setTag(null);
        this.etLastName.setTag(null);
        this.etProfession.setTag(null);
        this.ivProfileUser.setTag(null);
        this.ivUserProfilePic.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
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
        if (BR.jobSeeker == variableId) {
            setJobSeeker((com.findajob.jobamax.model.JobSeeker) variable);
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
        java.lang.String jobSeekerElevatorPitch = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;
        java.lang.String jobSeekerProfession = null;
        java.lang.String jobSeekerFirstName = null;
        boolean jobSeekerProfessionEqualsJavaLangString = false;
        java.lang.String jobSeekerElevatorPitchEqualsJavaLangStringJavaLangStringJobSeekerElevatorPitch = null;
        boolean jobSeekerElevatorPitchEqualsJavaLangString = false;
        java.lang.String jobSeekerProfessionEqualsJavaLangStringJavaLangStringJobSeekerProfession = null;
        java.lang.String jobSeekerLastName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                    // read jobSeeker.elevatorPitch
                    jobSeekerElevatorPitch = jobSeeker.getElevatorPitch();
                    // read jobSeeker.profession
                    jobSeekerProfession = jobSeeker.getProfession();
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                    // read jobSeeker.lastName
                    jobSeekerLastName = jobSeeker.getLastName();
                }


                if (jobSeekerElevatorPitch != null) {
                    // read jobSeeker.elevatorPitch.equals("")
                    jobSeekerElevatorPitchEqualsJavaLangString = jobSeekerElevatorPitch.equals("");
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(jobSeekerElevatorPitchEqualsJavaLangString) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
                if (jobSeekerProfession != null) {
                    // read jobSeeker.profession.equals("")
                    jobSeekerProfessionEqualsJavaLangString = jobSeekerProfession.equals("");
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(jobSeekerProfessionEqualsJavaLangString) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x3L) != 0) {

                // read jobSeeker.elevatorPitch.equals("") ? "" : jobSeeker.elevatorPitch
                jobSeekerElevatorPitchEqualsJavaLangStringJavaLangStringJobSeekerElevatorPitch = ((jobSeekerElevatorPitchEqualsJavaLangString) ? ("") : (jobSeekerElevatorPitch));
                // read jobSeeker.profession.equals("") ? "" : jobSeeker.profession
                jobSeekerProfessionEqualsJavaLangStringJavaLangStringJobSeekerProfession = ((jobSeekerProfessionEqualsJavaLangString) ? ("") : (jobSeekerProfession));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etDescription, jobSeekerElevatorPitchEqualsJavaLangStringJavaLangStringJobSeekerElevatorPitch);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etFirstName, jobSeekerFirstName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etLastName, jobSeekerLastName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etProfession, jobSeekerProfessionEqualsJavaLangStringJavaLangStringJobSeekerProfession);
            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivProfileUser, jobSeekerProfilePicUrl);
            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivUserProfilePic, jobSeekerProfilePicUrl);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): null
        flag 2 (0x3L): jobSeeker.elevatorPitch.equals("") ? "" : jobSeeker.elevatorPitch
        flag 3 (0x4L): jobSeeker.elevatorPitch.equals("") ? "" : jobSeeker.elevatorPitch
        flag 4 (0x5L): jobSeeker.profession.equals("") ? "" : jobSeeker.profession
        flag 5 (0x6L): jobSeeker.profession.equals("") ? "" : jobSeeker.profession
    flag mapping end*/
    //end
}