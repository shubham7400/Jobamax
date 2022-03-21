package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerJobsBindingImpl extends FragmentSeekerJobsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(18);
        sIncludes.setIncludes(2, 
            new String[] {"item_seeker_job_card"},
            new int[] {3},
            new int[] {com.findajob.jobamax.R.layout.item_seeker_job_card});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 4);
        sViewsWithIds.put(R.id.iv_back_button, 5);
        sViewsWithIds.put(R.id.cl_search_bar, 6);
        sViewsWithIds.put(R.id.et_job_keyword, 7);
        sViewsWithIds.put(R.id.iv_search_icon, 8);
        sViewsWithIds.put(R.id.iv_filter_job, 9);
        sViewsWithIds.put(R.id.csv_job, 10);
        sViewsWithIds.put(R.id.nsv_card, 11);
        sViewsWithIds.put(R.id.ll_float_buttons, 12);
        sViewsWithIds.put(R.id.fab_rewind, 13);
        sViewsWithIds.put(R.id.fab_refuse, 14);
        sViewsWithIds.put(R.id.fab_share, 15);
        sViewsWithIds.put(R.id.fab_apply, 16);
        sViewsWithIds.put(R.id.pcv_match, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerJobsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerJobsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (com.yuyakaido.android.cardstackview.CardStackView) bindings[10]
            , (android.widget.EditText) bindings[7]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[16]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[14]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[13]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[15]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[8]
            , (com.findajob.jobamax.databinding.ItemSeekerJobCardBinding) bindings[3]
            , (android.widget.LinearLayout) bindings[12]
            , (androidx.core.widget.NestedScrollView) bindings[11]
            , (com.ramijemli.percentagechartview.PercentageChartView) bindings[17]
            , (android.widget.RelativeLayout) bindings[4]
            );
        this.civUser.setTag(null);
        setContainedBinding(this.lJob);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.LinearLayout) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        lJob.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (lJob.hasPendingBindings()) {
            return true;
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
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.jobSeeker);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        lJob.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLJob((com.findajob.jobamax.databinding.ItemSeekerJobCardBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLJob(com.findajob.jobamax.databinding.ItemSeekerJobCardBinding LJob, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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

        if ((dirtyFlags & 0x6L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.profilePicUrl
                    jobSeekerProfilePicUrl = jobSeeker.getProfilePicUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.civUser, jobSeekerProfilePicUrl);
        }
        executeBindingsOn(lJob);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): lJob
        flag 1 (0x2L): jobSeeker
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}