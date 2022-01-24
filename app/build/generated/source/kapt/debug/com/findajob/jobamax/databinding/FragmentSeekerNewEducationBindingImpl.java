package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerNewEducationBindingImpl extends FragmentSeekerNewEducationBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 2);
        sViewsWithIds.put(R.id.iv_back_button, 3);
        sViewsWithIds.put(R.id.textView9, 4);
        sViewsWithIds.put(R.id.tv_school, 5);
        sViewsWithIds.put(R.id.textView10, 6);
        sViewsWithIds.put(R.id.et_program, 7);
        sViewsWithIds.put(R.id.textView11, 8);
        sViewsWithIds.put(R.id.et_gpa, 9);
        sViewsWithIds.put(R.id.btn_save_info, 10);
        sViewsWithIds.put(R.id.cb_current_student, 11);
        sViewsWithIds.put(R.id.linearLayout, 12);
        sViewsWithIds.put(R.id.textView15, 13);
        sViewsWithIds.put(R.id.tv_Start_date, 14);
        sViewsWithIds.put(R.id.cl_end_date, 15);
        sViewsWithIds.put(R.id.textView144, 16);
        sViewsWithIds.put(R.id.tv_end_date, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final de.hdodenhof.circleimageview.CircleImageView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerNewEducationBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerNewEducationBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[10]
            , (android.widget.CheckBox) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[7]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[14]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
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

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.mboundView1, jobSeekerProfilePicUrl);
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