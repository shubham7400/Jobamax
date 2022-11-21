package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentModifyProfileBindingImpl extends FragmentModifyProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraintLayout16, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.tv_go_to_validate_cv, 3);
        sViewsWithIds.put(R.id.view, 4);
        sViewsWithIds.put(R.id.civ_user, 5);
        sViewsWithIds.put(R.id.cv_update_image, 6);
        sViewsWithIds.put(R.id.tv_profile_match_per, 7);
        sViewsWithIds.put(R.id.ll_import_profile, 8);
        sViewsWithIds.put(R.id.iv_import_resume, 9);
        sViewsWithIds.put(R.id.et_name, 10);
        sViewsWithIds.put(R.id.sp_education, 11);
        sViewsWithIds.put(R.id.cb_university_status, 12);
        sViewsWithIds.put(R.id.cl_video_intro, 13);
        sViewsWithIds.put(R.id.cl_audio_intro, 14);
        sViewsWithIds.put(R.id.cl_work_type, 15);
        sViewsWithIds.put(R.id.imageView13, 16);
        sViewsWithIds.put(R.id.tv_work_types, 17);
        sViewsWithIds.put(R.id.cl_location, 18);
        sViewsWithIds.put(R.id.imagesView13, 19);
        sViewsWithIds.put(R.id.tv_job_location, 20);
        sViewsWithIds.put(R.id.et_bio, 21);
        sViewsWithIds.put(R.id.tv_bio_length, 22);
        sViewsWithIds.put(R.id.iv_add_education, 23);
        sViewsWithIds.put(R.id.rv_education, 24);
        sViewsWithIds.put(R.id.iv_add_experience, 25);
        sViewsWithIds.put(R.id.rv_experience, 26);
        sViewsWithIds.put(R.id.iv_skill_info, 27);
        sViewsWithIds.put(R.id.actv_hard_skill, 28);
        sViewsWithIds.put(R.id.iv_add_hard_skill, 29);
        sViewsWithIds.put(R.id.rv_hard_skill, 30);
        sViewsWithIds.put(R.id.actv_soft_skill, 31);
        sViewsWithIds.put(R.id.iv_add_soft_skill, 32);
        sViewsWithIds.put(R.id.cg_soft_skill, 33);
        sViewsWithIds.put(R.id.iv_add_volunteering, 34);
        sViewsWithIds.put(R.id.rv_volunteering, 35);
        sViewsWithIds.put(R.id.actv_area_of_interest, 36);
        sViewsWithIds.put(R.id.iv_add_area_of_interest, 37);
        sViewsWithIds.put(R.id.cg_interests, 38);
        sViewsWithIds.put(R.id.rv_photos, 39);
        sViewsWithIds.put(R.id.cl_add_document, 40);
        sViewsWithIds.put(R.id.imageView1s3, 41);
        sViewsWithIds.put(R.id.rv_portfolio_doc_link, 42);
        sViewsWithIds.put(R.id.cl_add_link, 43);
        sViewsWithIds.put(R.id.imageVieew13, 44);
        sViewsWithIds.put(R.id.rv_portfolio_link, 45);
        sViewsWithIds.put(R.id.actv_workspace, 46);
        sViewsWithIds.put(R.id.iv_add_workspace_btn, 47);
        sViewsWithIds.put(R.id.cg_workspace, 48);
        sViewsWithIds.put(R.id.autocomplete_fragment, 49);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentModifyProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 50, sIncludes, sViewsWithIds));
    }
    private FragmentModifyProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.AutoCompleteTextView) bindings[36]
            , (android.widget.AutoCompleteTextView) bindings[28]
            , (android.widget.AutoCompleteTextView) bindings[31]
            , (android.widget.AutoCompleteTextView) bindings[46]
            , (androidx.fragment.app.FragmentContainerView) bindings[49]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[12]
            , (com.google.android.material.chip.ChipGroup) bindings[38]
            , (com.google.android.material.chip.ChipGroup) bindings[33]
            , (com.google.android.material.chip.ChipGroup) bindings[48]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[40]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[43]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[18]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (android.widget.EditText) bindings[21]
            , (android.widget.EditText) bindings[10]
            , (android.widget.ImageView) bindings[44]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[41]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[37]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[25]
            , (android.widget.ImageView) bindings[29]
            , (android.widget.ImageView) bindings[32]
            , (android.widget.ImageView) bindings[34]
            , (android.widget.ImageView) bindings[47]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.LinearLayout) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (androidx.recyclerview.widget.RecyclerView) bindings[30]
            , (androidx.recyclerview.widget.RecyclerView) bindings[39]
            , (androidx.recyclerview.widget.RecyclerView) bindings[42]
            , (androidx.recyclerview.widget.RecyclerView) bindings[45]
            , (androidx.recyclerview.widget.RecyclerView) bindings[35]
            , (androidx.appcompat.widget.AppCompatSpinner) bindings[11]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[17]
            , (android.view.View) bindings[4]
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