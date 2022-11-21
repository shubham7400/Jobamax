package com.jobamax.appjobamax.databinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRecruiterChatBoardBindingImpl extends ActivityRecruiterChatBoardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cl_page_title, 1);
        sViewsWithIds.put(R.id.iv_back_button, 2);
        sViewsWithIds.put(R.id.constraintLayout20, 3);
        sViewsWithIds.put(R.id.civ_user, 4);
        sViewsWithIds.put(R.id.tv_seeker_name, 5);
        sViewsWithIds.put(R.id.iv_report, 6);
        sViewsWithIds.put(R.id.view3, 7);
        sViewsWithIds.put(R.id.rv_chat_message, 8);
        sViewsWithIds.put(R.id.v_devider, 9);
        sViewsWithIds.put(R.id.cl_send_action, 10);
        sViewsWithIds.put(R.id.iv_camere, 11);
        sViewsWithIds.put(R.id.iv_gallery, 12);
        sViewsWithIds.put(R.id.iv_message_audio, 13);
        sViewsWithIds.put(R.id.et_message_text, 14);
        sViewsWithIds.put(R.id.ll_sent_btn, 15);
        sViewsWithIds.put(R.id.cl_audio_action, 16);
        sViewsWithIds.put(R.id.iv_delete_audio, 17);
        sViewsWithIds.put(R.id.tv_recording_title, 18);
        sViewsWithIds.put(R.id.iv_send_audio, 19);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRecruiterChatBoardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityRecruiterChatBoardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.EditText) bindings[14]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.LinearLayout) bindings[15]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[5]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[7]
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