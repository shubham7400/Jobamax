package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityVideoChatViewBindingImpl extends ActivityVideoChatViewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.remote_video_view_container, 1);
        sViewsWithIds.put(R.id.tv_receiver_name, 2);
        sViewsWithIds.put(R.id.local_video_view_container, 3);
        sViewsWithIds.put(R.id.iv_toggle_video, 4);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityVideoChatViewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityVideoChatViewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[0]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.FrameLayout) bindings[3]
            , (android.widget.FrameLayout) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.activityVideoChatView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.dashboard.messages.ChatHandler) variable);
        }
        else if (BR.vm == variableId) {
            setVm((com.findajob.jobamax.dashboard.messages.ChatViewModel) variable);
        }
        else if (BR.profilePictureUrl == variableId) {
            setProfilePictureUrl((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.dashboard.messages.ChatHandler Handler) {
        this.mHandler = Handler;
    }
    public void setVm(@Nullable com.findajob.jobamax.dashboard.messages.ChatViewModel Vm) {
        this.mVm = Vm;
    }
    public void setProfilePictureUrl(@Nullable java.lang.String ProfilePictureUrl) {
        this.mProfilePictureUrl = ProfilePictureUrl;
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
        flag 0 (0x1L): handler
        flag 1 (0x2L): vm
        flag 2 (0x3L): profilePictureUrl
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}