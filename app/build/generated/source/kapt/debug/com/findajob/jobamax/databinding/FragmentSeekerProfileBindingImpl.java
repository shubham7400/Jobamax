package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerProfileBindingImpl extends FragmentSeekerProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView11, 2);
        sViewsWithIds.put(R.id.iv_back_button, 3);
        sViewsWithIds.put(R.id.textView6, 4);
        sViewsWithIds.put(R.id.constraintLayout3, 5);
        sViewsWithIds.put(R.id.tv_aaa, 6);
        sViewsWithIds.put(R.id.tv_about_me_btn, 7);
        sViewsWithIds.put(R.id.tv_ddd, 8);
        sViewsWithIds.put(R.id.tv_calender_title, 9);
        sViewsWithIds.put(R.id.iv_calender, 10);
        sViewsWithIds.put(R.id.tv_calender_titlef, 11);
        sViewsWithIds.put(R.id.iv_calvender, 12);
        sViewsWithIds.put(R.id.tv_calender_titlex, 13);
        sViewsWithIds.put(R.id.iv_calendxer, 14);
        sViewsWithIds.put(R.id.cl_education, 15);
        sViewsWithIds.put(R.id.textView7, 16);
        sViewsWithIds.put(R.id.textView8, 17);
        sViewsWithIds.put(R.id.cl_jobs, 18);
        sViewsWithIds.put(R.id.textView77, 19);
        sViewsWithIds.put(R.id.textView88, 20);
        sViewsWithIds.put(R.id.cl_volunteering_activities, 21);
        sViewsWithIds.put(R.id.textView76, 22);
        sViewsWithIds.put(R.id.textView86, 23);
        sViewsWithIds.put(R.id.cl_skills, 24);
        sViewsWithIds.put(R.id.textView73, 25);
        sViewsWithIds.put(R.id.textView83, 26);
        sViewsWithIds.put(R.id.iv_add_ideal_workspace_btn, 27);
        sViewsWithIds.put(R.id.et_ideal_workspace, 28);
        sViewsWithIds.put(R.id.cg_ideal_workspace, 29);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[29]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[18]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[21]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.AutoCompleteTextView) bindings[28]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[19]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[26]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.tvSeekerName.setTag(null);
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
        java.lang.String javaLangStringHelloJobSeekerFirstName = null;
        com.findajob.jobamax.model.JobSeeker jobSeeker = mJobSeeker;
        java.lang.String jobSeekerFirstName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (jobSeeker != null) {
                    // read jobSeeker.firstName
                    jobSeekerFirstName = jobSeeker.getFirstName();
                }


                // read ("Hello ") + (jobSeeker.firstName)
                javaLangStringHelloJobSeekerFirstName = ("Hello ") + (jobSeekerFirstName);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSeekerName, javaLangStringHelloJobSeekerFirstName);
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