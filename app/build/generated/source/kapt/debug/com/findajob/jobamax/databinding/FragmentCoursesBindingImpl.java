package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCoursesBindingImpl extends FragmentCoursesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.courses_ctl, 2);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentCoursesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentCoursesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.findajob.jobamax.util.CustomTabLayout) bindings[2]
            , (com.findajob.jobamax.util.NonSwipeableViewPager) bindings[1]
            );
        this.coursesVp.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.vm == variableId) {
            setVm((com.findajob.jobamax.dashboard.DashboardViewModel) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.dashboard.DashboardHandler) variable);
        }
        else if (BR.viewPagerAdapter == variableId) {
            setViewPagerAdapter((com.findajob.jobamax.util.ViewPagerAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.findajob.jobamax.dashboard.DashboardViewModel Vm) {
        this.mVm = Vm;
    }
    public void setHandler(@Nullable com.findajob.jobamax.dashboard.DashboardHandler Handler) {
        this.mHandler = Handler;
    }
    public void setViewPagerAdapter(@Nullable com.findajob.jobamax.util.ViewPagerAdapter ViewPagerAdapter) {
        this.mViewPagerAdapter = ViewPagerAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewPagerAdapter);
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
        com.findajob.jobamax.util.ViewPagerAdapter viewPagerAdapter = mViewPagerAdapter;

        if ((dirtyFlags & 0xcL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.coursesVp.setAdapter(viewPagerAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): handler
        flag 2 (0x3L): viewPagerAdapter
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}