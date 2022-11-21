package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecruiterHomeBindingImpl extends FragmentRecruiterHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(12);
        sIncludes.setIncludes(1, 
            new String[] {"item_recruiter_job_card"},
            new int[] {2},
            new int[] {com.jobamax.appjobamax.R.layout.item_recruiter_job_card});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.csv_job, 3);
        sViewsWithIds.put(R.id.cl_company_logo, 4);
        sViewsWithIds.put(R.id.imageView14, 5);
        sViewsWithIds.put(R.id.tv_subscription, 6);
        sViewsWithIds.put(R.id.sp_1, 7);
        sViewsWithIds.put(R.id.ll_floating_btn, 8);
        sViewsWithIds.put(R.id.fab_rewind, 9);
        sViewsWithIds.put(R.id.fab_refuse, 10);
        sViewsWithIds.put(R.id.fab_shortlist, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecruiterHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentRecruiterHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (com.yuyakaido.android.cardstackview.CardStackView) bindings[3]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[10]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[9]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[11]
            , (android.widget.ImageView) bindings[5]
            , (com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding) bindings[2]
            , (android.widget.LinearLayout) bindings[8]
            , (com.jobamax.appjobamax.customview.CustomSpinner) bindings[7]
            , (android.widget.TextView) bindings[6]
            );
        setContainedBinding(this.lJob);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            return variableSet;
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
                return onChangeLJob((com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLJob(com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding LJob, int fieldId) {
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
        // batch finished
        executeBindingsOn(lJob);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): lJob
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}