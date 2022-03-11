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
        sViewsWithIds.put(R.id.appbar, 6);
        sViewsWithIds.put(R.id.video_view, 7);
        sViewsWithIds.put(R.id.tv_play_btn, 8);
        sViewsWithIds.put(R.id.rv_guest, 9);
        sViewsWithIds.put(R.id.iv_like_dislike, 10);
        sViewsWithIds.put(R.id.iv_share, 11);
        sViewsWithIds.put(R.id.tv_session, 12);
        sViewsWithIds.put(R.id.rv_episodes, 13);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.AppCompatImageView mboundView1;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback152;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMasterClassDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityMasterClassDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[10]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[12]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (com.google.android.exoplayer2.ui.PlayerView) bindings[7]
            );
        this.appBarPlusVideo.setTag(null);
        this.ivAddMyList.setTag(null);
        this.mboundView1 = (androidx.appcompat.widget.AppCompatImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.tvSessionYear.setTag(null);
        this.tvVideoDescription.setTag(null);
        this.tvVideoTitle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback152 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
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
        if (BR.item == variableId) {
            setItem((com.findajob.jobamax.dashboard.home.training.masterclass.model.Topic) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface) variable);
        }
        else if (BR.episode == variableId) {
            setEpisode((com.findajob.jobamax.dashboard.home.training.masterclass.model.Episode) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.dashboard.home.training.masterclass.model.Topic Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setEpisode(@Nullable com.findajob.jobamax.dashboard.home.training.masterclass.model.Episode Episode) {
        this.mEpisode = Episode;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.episode);
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
        com.findajob.jobamax.dashboard.home.training.masterclass.model.Topic item = mItem;
        android.graphics.drawable.Drawable itemMylistAddedIvAddMyListAndroidDrawableIcDoneIvAddMyListAndroidDrawableIcAdd = null;
        java.lang.String itemSeasonYear = null;
        java.lang.String episodeDescription = null;
        com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface handler = mHandler;
        java.lang.String episodeSubTitle = null;
        com.findajob.jobamax.dashboard.home.training.masterclass.model.Episode episode = mEpisode;
        boolean itemMylistAdded = false;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.seasonYear
                    itemSeasonYear = item.getSeasonYear();
                    // read item.mylistAdded
                    itemMylistAdded = item.isMylistAdded();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemMylistAdded) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read item.mylistAdded ? @android:drawable/ic_done : @android:drawable/ic_add
                itemMylistAddedIvAddMyListAndroidDrawableIcDoneIvAddMyListAndroidDrawableIcAdd = ((itemMylistAdded) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(ivAddMyList.getContext(), R.drawable.ic_done)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(ivAddMyList.getContext(), R.drawable.ic_add)));
        }
        if ((dirtyFlags & 0xcL) != 0) {



                if (episode != null) {
                    // read episode.description
                    episodeDescription = episode.getDescription();
                    // read episode.subTitle
                    episodeSubTitle = episode.getSubTitle();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.ivAddMyList, itemMylistAddedIvAddMyListAndroidDrawableIcDoneIvAddMyListAndroidDrawableIcAdd);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSessionYear, itemSeasonYear);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback152);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvVideoDescription, episodeDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvVideoTitle, episodeSubTitle);
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
        flag 0 (0x1L): item
        flag 1 (0x2L): handler
        flag 2 (0x3L): episode
        flag 3 (0x4L): null
        flag 4 (0x5L): item.mylistAdded ? @android:drawable/ic_done : @android:drawable/ic_add
        flag 5 (0x6L): item.mylistAdded ? @android:drawable/ic_done : @android:drawable/ic_add
    flag mapping end*/
    //end
}