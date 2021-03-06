package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
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
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(24);
        sIncludes.setIncludes(2, 
            new String[] {"item_seeker_job_card"},
            new int[] {3},
            new int[] {com.jobamax.appjobamax.R.layout.item_seeker_job_card});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 4);
        sViewsWithIds.put(R.id.iv_back_button, 5);
        sViewsWithIds.put(R.id.iv_favorite, 6);
        sViewsWithIds.put(R.id.cl_search_bar, 7);
        sViewsWithIds.put(R.id.constraintLayout, 8);
        sViewsWithIds.put(R.id.et_job_keyword, 9);
        sViewsWithIds.put(R.id.iv_search_icon, 10);
        sViewsWithIds.put(R.id.v_filter_state, 11);
        sViewsWithIds.put(R.id.iv_filter_job, 12);
        sViewsWithIds.put(R.id.csv_job, 13);
        sViewsWithIds.put(R.id.nsv_card, 14);
        sViewsWithIds.put(R.id.ll_float_buttons, 15);
        sViewsWithIds.put(R.id.ll_rewind, 16);
        sViewsWithIds.put(R.id.fab_rewind, 17);
        sViewsWithIds.put(R.id.fab_refuse, 18);
        sViewsWithIds.put(R.id.fab_share, 19);
        sViewsWithIds.put(R.id.fab_apply, 20);
        sViewsWithIds.put(R.id.ll_match_percent, 21);
        sViewsWithIds.put(R.id.pcv_match, 22);
        sViewsWithIds.put(R.id.rv_job_types, 23);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerJobsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerJobsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (com.yuyakaido.android.cardstackview.CardStackView) bindings[13]
            , (android.widget.EditText) bindings[9]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[20]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[18]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[17]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[19]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[10]
            , (com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding) bindings[3]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[16]
            , (androidx.core.widget.NestedScrollView) bindings[14]
            , (antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator) bindings[22]
            , (android.widget.RelativeLayout) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[23]
            , (android.view.View) bindings[11]
            );
        this.civUser.setTag(null);
        this.clMostParent.setTag(null);
        setContainedBinding(this.lJob);
        this.mboundView2 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[2];
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
                return onChangeLJob((com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLJob(com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding LJob, int fieldId) {
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