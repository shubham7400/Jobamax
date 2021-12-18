package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemJobSeekerRecruitCardBindingImpl extends ItemJobSeekerRecruitCardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardView, 5);
        sViewsWithIds.put(R.id.scrollView, 6);
        sViewsWithIds.put(R.id.parentLayout, 7);
        sViewsWithIds.put(R.id.profileCard, 8);
        sViewsWithIds.put(R.id.profileIcon, 9);
        sViewsWithIds.put(R.id.iv_go_there, 10);
        sViewsWithIds.put(R.id.experienceLayout, 11);
        sViewsWithIds.put(R.id.experienceRecycler, 12);
        sViewsWithIds.put(R.id.schoolLayout, 13);
        sViewsWithIds.put(R.id.schoolRecycler, 14);
        sViewsWithIds.put(R.id.skillLayout, 15);
        sViewsWithIds.put(R.id.skillChipGroup, 16);
        sViewsWithIds.put(R.id.activityLayout, 17);
        sViewsWithIds.put(R.id.activityRecycler, 18);
        sViewsWithIds.put(R.id.attachmentLayout, 19);
        sViewsWithIds.put(R.id.paperclipIcon, 20);
        sViewsWithIds.put(R.id.cvLabel, 21);
        sViewsWithIds.put(R.id.downloadIcon, 22);
        sViewsWithIds.put(R.id.videoPresentationLayout, 23);
        sViewsWithIds.put(R.id.thumbProgressBar, 24);
        sViewsWithIds.put(R.id.videoThumbnailIcon, 25);
        sViewsWithIds.put(R.id.playIcon, 26);
        sViewsWithIds.put(R.id.overlayLayout, 27);
        sViewsWithIds.put(R.id.overlayLabel, 28);
        sViewsWithIds.put(R.id.scrollToggleCard, 29);
        sViewsWithIds.put(R.id.scrollToggleButton, 30);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemJobSeekerRecruitCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private ItemJobSeekerRecruitCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[17]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (android.widget.LinearLayout) bindings[19]
            , (androidx.cardview.widget.CardView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[21]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.LinearLayout) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.TextView) bindings[28]
            , (android.widget.RelativeLayout) bindings[27]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.ImageView) bindings[26]
            , (android.widget.TextView) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[8]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.LinearLayout) bindings[13]
            , (androidx.recyclerview.widget.RecyclerView) bindings[14]
            , (android.widget.ImageView) bindings[30]
            , (androidx.cardview.widget.CardView) bindings[29]
            , (android.widget.ScrollView) bindings[6]
            , (com.google.android.material.chip.ChipGroup) bindings[16]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.ProgressBar) bindings[24]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.ImageView) bindings[25]
            );
        this.companyName.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.positionLabel.setTag(null);
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
        java.lang.String jobSeekerFirstNameJavaLangString = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;
        java.lang.String jobSeekerFirstName = null;
        java.lang.String jobSeekerJob = null;
        boolean jobSeekerAboutMeEmpty = false;
        int jobSeekerAboutMeEmptyViewGONEViewVISIBLE = 0;
        java.lang.String jobSeekerFirstNameJavaLangStringJobSeekerLastName = null;
        java.lang.String jobSeekerLastName = null;
        java.lang.String jobSeekerAboutMe = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                    // read jobSeeker.job
                    jobSeekerJob = jobSeeker.getJob();
                    // read jobSeeker.lastName
                    jobSeekerLastName = jobSeeker.getLastName();
                    // read jobSeeker.aboutMe
                    jobSeekerAboutMe = jobSeeker.getAboutMe();
                }


                // read (jobSeeker.firstName) + (" ")
                jobSeekerFirstNameJavaLangString = (jobSeekerFirstName) + (" ");
                if (jobSeekerAboutMe != null) {
                    // read jobSeeker.aboutMe.empty
                    jobSeekerAboutMeEmpty = jobSeekerAboutMe.isEmpty();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(jobSeekerAboutMeEmpty) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read ((jobSeeker.firstName) + (" ")) + (jobSeeker.lastName)
                jobSeekerFirstNameJavaLangStringJobSeekerLastName = (jobSeekerFirstNameJavaLangString) + (jobSeekerLastName);
                // read jobSeeker.aboutMe.empty ? View.GONE : View.VISIBLE
                jobSeekerAboutMeEmptyViewGONEViewVISIBLE = ((jobSeekerAboutMeEmpty) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companyName, jobSeekerFirstNameJavaLangStringJobSeekerLastName);
            this.mboundView3.setVisibility(jobSeekerAboutMeEmptyViewGONEViewVISIBLE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, jobSeekerAboutMe);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.positionLabel, jobSeekerJob);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): null
        flag 2 (0x3L): jobSeeker.aboutMe.empty ? View.GONE : View.VISIBLE
        flag 3 (0x4L): jobSeeker.aboutMe.empty ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}