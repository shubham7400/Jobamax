package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMasterClassDetailsBindingImpl extends ActivityMasterClassDetailsBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 9);
        sViewsWithIds.put(R.id.rv_videos, 10);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatImageView mboundView1;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView3;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView4;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView5;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView6;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView7;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView8;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback71;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMasterClassDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityMasterClassDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.appcompat.widget.AppCompatImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (androidx.appcompat.widget.AppCompatTextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (androidx.appcompat.widget.AppCompatTextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (androidx.appcompat.widget.AppCompatTextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (androidx.appcompat.widget.AppCompatTextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (androidx.appcompat.widget.AppCompatTextView) bindings[8];
        this.mboundView8.setTag(null);
        this.video.setTag(null);
        setRootTag(root);
        // listeners
        mCallback71 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            setHandler((com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface) variable);
        }
        else if (BR.item == variableId) {
            setItem((com.findajob.jobamax.data.pojo.VideoDetails) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setItem(@Nullable com.findajob.jobamax.data.pojo.VideoDetails Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.item);
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
        com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface handler = mHandler;
        com.findajob.jobamax.data.pojo.VideoDetails item = mItem;
        java.lang.String itemYear = null;
        java.lang.String itemTitle = null;
        java.lang.String itemResolution = null;
        java.lang.String itemSeason = null;
        java.lang.String itemVideoThumbnail = null;
        java.lang.String itemDescription = null;
        java.lang.String itemRating = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (item != null) {
                    // read item.year
                    itemYear = item.getYear();
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.resolution
                    itemResolution = item.getResolution();
                    // read item.season
                    itemSeason = item.getSeason();
                    // read item.videoThumbnail
                    itemVideoThumbnail = item.getVideoThumbnail();
                    // read item.description
                    itemDescription = item.getDescription();
                    // read item.rating
                    itemRating = item.getRating();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback71);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, itemTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, itemYear);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, itemRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, itemSeason);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, itemResolution);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, itemDescription);
            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrl(this.video, itemVideoThumbnail);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // handler
        com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface handler = mHandler;
        // handler != null
        boolean handlerJavaLangObjectNull = false;



        handlerJavaLangObjectNull = (handler) != (null);
        if (handlerJavaLangObjectNull) {


            handler.onBackPress();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): item
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}