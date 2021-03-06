package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerAddExperienceBindingImpl extends FragmentSeekerAddExperienceBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 2);
        sViewsWithIds.put(R.id.iv_back_button, 3);
        sViewsWithIds.put(R.id.textView16, 4);
        sViewsWithIds.put(R.id.et_job, 5);
        sViewsWithIds.put(R.id.textView19, 6);
        sViewsWithIds.put(R.id.et_company_name, 7);
        sViewsWithIds.put(R.id.relativeLayout4, 8);
        sViewsWithIds.put(R.id.textView139, 9);
        sViewsWithIds.put(R.id.autocomplete_fragment, 10);
        sViewsWithIds.put(R.id.tv_select_location, 11);
        sViewsWithIds.put(R.id.linearLayout4, 12);
        sViewsWithIds.put(R.id.textView13r49, 13);
        sViewsWithIds.put(R.id.tv_select_start_date, 14);
        sViewsWithIds.put(R.id.iv_clear_start_date, 15);
        sViewsWithIds.put(R.id.textView13rdd49, 16);
        sViewsWithIds.put(R.id.tv_select_end_date, 17);
        sViewsWithIds.put(R.id.iv_clear_end_date, 18);
        sViewsWithIds.put(R.id.textViewdd19, 19);
        sViewsWithIds.put(R.id.et_description, 20);
        sViewsWithIds.put(R.id.rv_company_suggestions, 21);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerAddExperienceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerAddExperienceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.fragment.app.FragmentContainerView) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[20]
            , (android.widget.EditText) bindings[5]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[15]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.RelativeLayout) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[21]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[14]
            );
        this.clMostParent.setTag(null);
        this.ivUserProfile.setTag(null);
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

            com.jobamax.appjobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.ivUserProfile, jobSeekerProfilePicUrl);
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