package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerJobsFilterBindingImpl extends FragmentSeekerJobsFilterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 2);
        sViewsWithIds.put(R.id.iv_back_button, 3);
        sViewsWithIds.put(R.id.et_job_keyword, 4);
        sViewsWithIds.put(R.id.textView29, 5);
        sViewsWithIds.put(R.id.autocomplete_fragment, 6);
        sViewsWithIds.put(R.id.tv_select_location, 7);
        sViewsWithIds.put(R.id.textView2e9, 8);
        sViewsWithIds.put(R.id.tv_distance, 9);
        sViewsWithIds.put(R.id.textView30, 10);
        sViewsWithIds.put(R.id.sb_distance, 11);
        sViewsWithIds.put(R.id.et_industry_name, 12);
        sViewsWithIds.put(R.id.accb_apprenticeship, 13);
        sViewsWithIds.put(R.id.accb_part_time, 14);
        sViewsWithIds.put(R.id.accb_internship, 15);
        sViewsWithIds.put(R.id.accb_permanent, 16);
        sViewsWithIds.put(R.id.accb_less_than_one, 17);
        sViewsWithIds.put(R.id.accb_one_to_two, 18);
        sViewsWithIds.put(R.id.accb_more_than_two, 19);
        sViewsWithIds.put(R.id.btn_save, 20);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerJobsFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerJobsFilterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[13]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[15]
            , (android.widget.CheckBox) bindings[17]
            , (android.widget.CheckBox) bindings[19]
            , (android.widget.CheckBox) bindings[18]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[14]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[16]
            , (androidx.fragment.app.FragmentContainerView) bindings[6]
            , (android.widget.Button) bindings[20]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[4]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.SeekBar) bindings[11]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[7]
            );
        this.civUser.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
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
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.civUser, jobSeekerProfilePicUrl);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): jobSeeker
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}