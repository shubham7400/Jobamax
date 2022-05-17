package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerJobMatchInfoDialogBindingImpl extends FragmentSeekerJobMatchInfoDialogBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.civ_user, 3);
        sViewsWithIds.put(R.id.circular_progress, 4);
        sViewsWithIds.put(R.id.ll_education, 5);
        sViewsWithIds.put(R.id.sb_education, 6);
        sViewsWithIds.put(R.id.tv_education_per, 7);
        sViewsWithIds.put(R.id.tv_education_missing_tag, 8);
        sViewsWithIds.put(R.id.rv_education_missing_tag, 9);
        sViewsWithIds.put(R.id.ll_hard_skill, 10);
        sViewsWithIds.put(R.id.sb_hard_skill, 11);
        sViewsWithIds.put(R.id.tv_hard_skill_per, 12);
        sViewsWithIds.put(R.id.tv_hard_skill_missing_tag, 13);
        sViewsWithIds.put(R.id.rv_hard_skill_missing_tag, 14);
        sViewsWithIds.put(R.id.ll_soft_skill, 15);
        sViewsWithIds.put(R.id.sb_soft_skill, 16);
        sViewsWithIds.put(R.id.tv_soft_skill_per, 17);
        sViewsWithIds.put(R.id.tv_soft_skill_missing_tag, 18);
        sViewsWithIds.put(R.id.rv_soft_skill_missing_tag, 19);
        sViewsWithIds.put(R.id.ll_job_title, 20);
        sViewsWithIds.put(R.id.sb_job_title, 21);
        sViewsWithIds.put(R.id.tv_job_title_per, 22);
        sViewsWithIds.put(R.id.tv_job_title_missing_tag, 23);
        sViewsWithIds.put(R.id.rv_job_title_missing_tag, 24);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerJobMatchInfoDialogBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerJobMatchInfoDialogBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator) bindings[4]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.RelativeLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.recyclerview.widget.RecyclerView) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (androidx.recyclerview.widget.RecyclerView) bindings[19]
            , (android.widget.SeekBar) bindings[6]
            , (android.widget.SeekBar) bindings[11]
            , (android.widget.SeekBar) bindings[21]
            , (android.widget.SeekBar) bindings[16]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[17]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}