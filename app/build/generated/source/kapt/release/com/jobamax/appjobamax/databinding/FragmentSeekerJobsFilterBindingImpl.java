package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
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
        sViewsWithIds.put(R.id.tv_job_title_hint, 4);
        sViewsWithIds.put(R.id.et_job_keyword, 5);
        sViewsWithIds.put(R.id.ll_add_category, 6);
        sViewsWithIds.put(R.id.iv_add_category, 7);
        sViewsWithIds.put(R.id.ll_industry, 8);
        sViewsWithIds.put(R.id.linearLayout6, 9);
        sViewsWithIds.put(R.id.textView29, 10);
        sViewsWithIds.put(R.id.autocomplete_fragment, 11);
        sViewsWithIds.put(R.id.tv_select_location, 12);
        sViewsWithIds.put(R.id.textView2e9, 13);
        sViewsWithIds.put(R.id.tv_distance, 14);
        sViewsWithIds.put(R.id.textView30, 15);
        sViewsWithIds.put(R.id.sb_distance, 16);
        sViewsWithIds.put(R.id.aaaa, 17);
        sViewsWithIds.put(R.id.et_company_name, 18);
        sViewsWithIds.put(R.id.bbbb, 19);
        sViewsWithIds.put(R.id.lllll, 20);
        sViewsWithIds.put(R.id.accb_apprenticeship, 21);
        sViewsWithIds.put(R.id.accb_part_time, 22);
        sViewsWithIds.put(R.id.accb_internship, 23);
        sViewsWithIds.put(R.id.accb_permanent, 24);
        sViewsWithIds.put(R.id.cccc, 25);
        sViewsWithIds.put(R.id.accb_less_than_one, 26);
        sViewsWithIds.put(R.id.accb_one_to_two, 27);
        sViewsWithIds.put(R.id.accb_more_than_two, 28);
        sViewsWithIds.put(R.id.rv_job_types, 29);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerJobsFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerJobsFilterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[17]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[21]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[23]
            , (android.widget.CheckBox) bindings[26]
            , (android.widget.CheckBox) bindings[28]
            , (android.widget.CheckBox) bindings[27]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[22]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[24]
            , (androidx.fragment.app.FragmentContainerView) bindings[11]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[25]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.EditText) bindings[18]
            , (android.widget.EditText) bindings[5]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.RelativeLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[29]
            , (android.widget.SeekBar) bindings[16]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[12]
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
            setJobSeeker((com.jobamax.appjobamax.model.JobSeeker) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setJobSeeker(@Nullable com.jobamax.appjobamax.model.JobSeeker JobSeeker) {
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
        com.jobamax.appjobamax.model.JobSeeker jobSeeker = mJobSeeker;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.jobamax.appjobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.civUser, jobSeekerProfilePicUrl);
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