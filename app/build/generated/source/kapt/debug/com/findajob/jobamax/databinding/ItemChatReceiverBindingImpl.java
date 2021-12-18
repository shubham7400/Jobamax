package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemChatReceiverBindingImpl extends ItemChatReceiverBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView3;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView5;
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView6;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemChatReceiverBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ItemChatReceiverBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.itemReceiverFile.setTag(null);
        this.itemReceiverImage.setTag(null);
        this.itemSenderBody.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (com.google.android.material.card.MaterialCardView) bindings[6];
        this.mboundView6.setTag(null);
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
            setItem((com.findajob.jobamax.data.pojo.Chat) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.data.pojo.Chat Item) {
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
        boolean itemMessageJavaLangObjectNull = false;
        int itemMessageJavaLangObjectNullViewGONEViewVISIBLE = 0;
        com.findajob.jobamax.data.pojo.Chat item = mItem;
        boolean itemFileContainsJavaLangStringPdf = false;
        int itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalseViewGONEViewVISIBLE = 0;
        boolean itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse = false;
        int itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalseViewVISIBLEViewGONE = 0;
        boolean ItemFileContainsJavaLangStringPdf1 = false;
        int itemMessageJavaLangObjectNullViewVISIBLEViewGONE = 0;
        java.lang.String itemMessage = null;
        boolean ItemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse1 = false;
        java.lang.String itemFile = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.message
                    itemMessage = item.getMessage();
                    // read item.file
                    itemFile = item.getFile();
                }


                // read item.message == null
                itemMessageJavaLangObjectNull = (itemMessage) == (null);
            if((dirtyFlags & 0x3L) != 0) {
                if(itemMessageJavaLangObjectNull) {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x800L;
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x4L;
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x400L;
                        dirtyFlags |= 0x1000L;
                }
            }


                // read item.message == null ? View.GONE : View.VISIBLE
                itemMessageJavaLangObjectNullViewGONEViewVISIBLE = ((itemMessageJavaLangObjectNull) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read item.message == null ? View.VISIBLE : View.GONE
                itemMessageJavaLangObjectNullViewVISIBLEViewGONE = ((itemMessageJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished

        if ((dirtyFlags & 0x2080L) != 0) {

                if (itemFile != null) {
                    // read item.file.contains(".pdf")
                    itemFileContainsJavaLangStringPdf = itemFile.contains(".pdf");
                }

            if ((dirtyFlags & 0x80L) != 0) {

                    // read !item.file.contains(".pdf")
                    ItemFileContainsJavaLangStringPdf1 = !itemFileContainsJavaLangStringPdf;
            }
        }

        if ((dirtyFlags & 0x3L) != 0) {

                // read item.message == null ? !item.file.contains(".pdf") : false
                itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse = ((itemMessageJavaLangObjectNull) ? (ItemFileContainsJavaLangStringPdf1) : (false));
                // read item.message == null ? item.file.contains(".pdf") : false
                ItemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse1 = ((itemMessageJavaLangObjectNull) ? (itemFileContainsJavaLangStringPdf) : (false));
            if((dirtyFlags & 0x3L) != 0) {
                if(itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(ItemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse1) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }


                // read item.message == null ? !item.file.contains(".pdf") : false ? View.GONE : View.VISIBLE
                itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalseViewGONEViewVISIBLE = ((itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read item.message == null ? item.file.contains(".pdf") : false ? View.VISIBLE : View.GONE
                itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalseViewVISIBLEViewGONE = ((ItemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalse1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findajob.jobamax.bindingadapters.TextViewBinding.setText(this.itemReceiverFile, itemFile);
            com.findajob.jobamax.bindingadapters.ImageViewBinding.loadFromUrl(this.itemReceiverImage, item);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemSenderBody, itemMessage);
            this.itemSenderBody.setVisibility(itemMessageJavaLangObjectNullViewGONEViewVISIBLE);
            this.mboundView1.setVisibility(itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalseViewGONEViewVISIBLE);
            this.mboundView3.setVisibility(itemMessageJavaLangObjectNullViewVISIBLEViewGONE);
            this.mboundView5.setVisibility(itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalseViewVISIBLEViewGONE);
            this.mboundView6.setVisibility(itemMessageJavaLangObjectNullItemFileContainsJavaLangStringPdfBooleanFalseViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
        flag 2 (0x3L): item.message == null ? View.GONE : View.VISIBLE
        flag 3 (0x4L): item.message == null ? View.GONE : View.VISIBLE
        flag 4 (0x5L): item.message == null ? !item.file.contains(".pdf") : false ? View.GONE : View.VISIBLE
        flag 5 (0x6L): item.message == null ? !item.file.contains(".pdf") : false ? View.GONE : View.VISIBLE
        flag 6 (0x7L): item.message == null ? !item.file.contains(".pdf") : false
        flag 7 (0x8L): item.message == null ? !item.file.contains(".pdf") : false
        flag 8 (0x9L): item.message == null ? item.file.contains(".pdf") : false ? View.VISIBLE : View.GONE
        flag 9 (0xaL): item.message == null ? item.file.contains(".pdf") : false ? View.VISIBLE : View.GONE
        flag 10 (0xbL): item.message == null ? View.VISIBLE : View.GONE
        flag 11 (0xcL): item.message == null ? View.VISIBLE : View.GONE
        flag 12 (0xdL): item.message == null ? item.file.contains(".pdf") : false
        flag 13 (0xeL): item.message == null ? item.file.contains(".pdf") : false
    flag mapping end*/
    //end
}