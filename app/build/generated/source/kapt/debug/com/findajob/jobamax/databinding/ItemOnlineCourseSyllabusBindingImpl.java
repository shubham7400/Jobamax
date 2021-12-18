package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemOnlineCourseSyllabusBindingImpl extends ItemOnlineCourseSyllabusBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.seperator, 3);
        sViewsWithIds.put(R.id.syllabus_asset_icon, 4);
        sViewsWithIds.put(R.id.syllabus_asset_arrow, 5);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemOnlineCourseSyllabusBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemOnlineCourseSyllabusBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.view.View) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[4]
            );
        this.chapterDescriptionTv.setTag(null);
        this.chapterTitleTv.setTag(null);
        this.itemSyllabusClBg.setTag(null);
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
        if (BR.item == variableId) {
            setItem((com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        java.lang.String itemDescriptionReplaceAllJavaLangStringJavaLangString = null;
        com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus item = mItem;
        java.lang.String itemTitle = null;
        java.lang.String itemDescription = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.description
                    itemDescription = item.getDescription();
                }


                if (itemDescription != null) {
                    // read item.description.replaceAll("\\<.*?\\>", "")
                    itemDescriptionReplaceAllJavaLangStringJavaLangString = itemDescription.replaceAll("\\<.*?\\>", "");
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.chapterDescriptionTv, itemDescriptionReplaceAllJavaLangStringJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.chapterTitleTv, itemTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}