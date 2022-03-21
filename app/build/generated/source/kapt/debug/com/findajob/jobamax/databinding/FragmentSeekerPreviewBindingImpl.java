package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSeekerPreviewBindingImpl extends FragmentSeekerPreviewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.imageView10, 3);
        sViewsWithIds.put(R.id.linearLayoutCompat2s, 4);
        sViewsWithIds.put(R.id.constraintLayout12, 5);
        sViewsWithIds.put(R.id.civ_seeker, 6);
        sViewsWithIds.put(R.id.tv_seeker_name, 7);
        sViewsWithIds.put(R.id.tv_seeker_profession, 8);
        sViewsWithIds.put(R.id.linearLayout7, 9);
        sViewsWithIds.put(R.id.iv_instagram, 10);
        sViewsWithIds.put(R.id.iv_linkedin, 11);
        sViewsWithIds.put(R.id.iv_tiktok, 12);
        sViewsWithIds.put(R.id.textView26, 13);
        sViewsWithIds.put(R.id.tv_seeker_about, 14);
        sViewsWithIds.put(R.id.textView2x6, 15);
        sViewsWithIds.put(R.id.rv_school, 16);
        sViewsWithIds.put(R.id.textView2dx6, 17);
        sViewsWithIds.put(R.id.rv_experience, 18);
        sViewsWithIds.put(R.id.textViewd2dx6, 19);
        sViewsWithIds.put(R.id.rv_hard_skill, 20);
        sViewsWithIds.put(R.id.textViewde2dx6, 21);
        sViewsWithIds.put(R.id.cg_soft_skill, 22);
        sViewsWithIds.put(R.id.tv_volunteering_title, 23);
        sViewsWithIds.put(R.id.rv_volunteering, 24);
        sViewsWithIds.put(R.id.textVisewrde2dx6, 25);
        sViewsWithIds.put(R.id.cg_activities, 26);
        sViewsWithIds.put(R.id.textVisewdrde2dx6, 27);
        sViewsWithIds.put(R.id.tv_ideal_job_description, 28);
        sViewsWithIds.put(R.id.iv_ideal_job_video, 29);
        sViewsWithIds.put(R.id.rv_ideal_job_images, 30);
        sViewsWithIds.put(R.id.cl_audio_player, 31);
        sViewsWithIds.put(R.id.iv_audio_play_btn, 32);
        sViewsWithIds.put(R.id.sb_audio, 33);
        sViewsWithIds.put(R.id.tv_audio_duration, 34);
        sViewsWithIds.put(R.id.textVisewdrde2ddx6, 35);
        sViewsWithIds.put(R.id.tv_portfolio_description, 36);
        sViewsWithIds.put(R.id.iv_portfolio_video, 37);
        sViewsWithIds.put(R.id.rv_portfolio_images, 38);
        sViewsWithIds.put(R.id.cl_portfolio_audio_player, 39);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSeekerPreviewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 40, sIncludes, sViewsWithIds));
    }
    private FragmentSeekerPreviewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[26]
            , (com.google.android.material.chip.ChipGroup) bindings[22]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[31]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[39]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[32]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[29]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[37]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.LinearLayout) bindings[9]
            , (androidx.core.widget.NestedScrollView) bindings[4]
            , (android.widget.RelativeLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (androidx.recyclerview.widget.RecyclerView) bindings[30]
            , (androidx.recyclerview.widget.RecyclerView) bindings[38]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (android.widget.SeekBar) bindings[33]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[23]
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