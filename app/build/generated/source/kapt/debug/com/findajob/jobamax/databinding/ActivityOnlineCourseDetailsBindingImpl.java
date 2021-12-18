package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityOnlineCourseDetailsBindingImpl extends ActivityOnlineCourseDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_background, 2);
        sViewsWithIds.put(R.id.appbar, 3);
        sViewsWithIds.put(R.id.backBtn, 4);
        sViewsWithIds.put(R.id.iv_banner, 5);
        sViewsWithIds.put(R.id.online_course_title, 6);
        sViewsWithIds.put(R.id.item_online_courses_rv_rating, 7);
        sViewsWithIds.put(R.id.item_online_courses_tv_rating, 8);
        sViewsWithIds.put(R.id.item_online_courses_numberof_rating, 9);
        sViewsWithIds.put(R.id.innerLine, 10);
        sViewsWithIds.put(R.id.imageView, 11);
        sViewsWithIds.put(R.id.item_online_courses_tv_percentage, 12);
        sViewsWithIds.put(R.id.online_course_instructor_profile_image, 13);
        sViewsWithIds.put(R.id.online_course_instructor_profile_name, 14);
        sViewsWithIds.put(R.id.enroll_for_tv, 15);
        sViewsWithIds.put(R.id.online_course_ctl, 16);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityOnlineCourseDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityOnlineCourseDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[4]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (android.widget.ImageView) bindings[11]
            , (android.view.View) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (androidx.appcompat.widget.AppCompatRatingBar) bindings[7]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (com.google.android.material.tabs.TabLayout) bindings[16]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            , (com.findajob.jobamax.util.NonSwipeableViewPager) bindings[1]
            );
        this.coordinate.setTag(null);
        this.vpa.setTag(null);
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
        if (BR.viewPagerAdapter == variableId) {
            setViewPagerAdapter((com.findajob.jobamax.util.ViewPagerAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewPagerAdapter(@Nullable com.findajob.jobamax.util.ViewPagerAdapter ViewPagerAdapter) {
        this.mViewPagerAdapter = ViewPagerAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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

        if ((dirtyFlags & 0x3L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.vpa.setAdapter(viewPagerAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewPagerAdapter
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}