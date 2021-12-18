package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemEventBindingImpl extends ItemEventBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rlDate, 4);
        sViewsWithIds.put(R.id.tvDate, 5);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemEventBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemEventBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.rvTime.setTag(null);
        this.tvEventName.setTag(null);
        this.tvEventOrganiser.setTag(null);
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
        if (BR.event == variableId) {
            setEvent((com.findajob.jobamax.model.Event) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setEvent(@Nullable com.findajob.jobamax.model.Event Event) {
        this.mEvent = Event;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.event);
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
        java.lang.String eventDateToLocaleString = null;
        java.lang.String eventOrganiserGetStringJavaLangStringFirstName = null;
        java.util.Date eventDate = null;
        com.parse.ParseObject eventOrganiser = null;
        com.findajob.jobamax.model.Event event = mEvent;
        java.lang.String eventName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (event != null) {
                    // read event.date
                    eventDate = event.getDate();
                    // read event.organiser
                    eventOrganiser = event.getOrganiser();
                    // read event.name
                    eventName = event.getName();
                }


                if (eventDate != null) {
                    // read event.date.toLocaleString()
                    eventDateToLocaleString = eventDate.toLocaleString();
                }
                if (eventOrganiser != null) {
                    // read event.organiser.getString("firstName")
                    eventOrganiserGetStringJavaLangStringFirstName = eventOrganiser.getString("firstName");
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.rvTime, eventDateToLocaleString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvEventName, eventName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvEventOrganiser, eventOrganiserGetStringJavaLangStringFirstName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): event
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}