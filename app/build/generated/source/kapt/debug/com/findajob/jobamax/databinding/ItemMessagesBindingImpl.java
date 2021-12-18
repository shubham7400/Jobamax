package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemMessagesBindingImpl extends ItemMessagesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.bottom_wraper, 5);
        sViewsWithIds.put(R.id.ivShortList, 6);
        sViewsWithIds.put(R.id.ivDelete, 7);
        sViewsWithIds.put(R.id.bottom_wrapper1, 8);
        sViewsWithIds.put(R.id.btnLocation, 9);
        sViewsWithIds.put(R.id.clMessageBody, 10);
        sViewsWithIds.put(R.id.item_messages_iv_avatar, 11);
        sViewsWithIds.put(R.id.iv_seen_indicator, 12);
        sViewsWithIds.put(R.id.vHorizontalLine, 13);
    }
    // views
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.ImageView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemMessagesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ItemMessagesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.ImageButton) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.cardview.widget.CardView) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[6]
            , (com.daimajia.swipe.SwipeLayout) bindings[0]
            , (android.view.View) bindings[13]
            );
        this.itemMessagesIvMessage.setTag(null);
        this.itemMessagesIvName.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (android.widget.ImageView) bindings[3];
        this.mboundView3.setTag(null);
        this.slMessageSwipe.setTag(null);
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
        if (BR.item == variableId) {
            setItem((com.findajob.jobamax.data.pojo.Message) variable);
        }
        else if (BR.recieverName == variableId) {
            setRecieverName((java.lang.String) variable);
        }
        else if (BR.parseUser == variableId) {
            setParseUser((com.parse.ParseUser) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.findajob.jobamax.data.pojo.Message Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setRecieverName(@Nullable java.lang.String RecieverName) {
        this.mRecieverName = RecieverName;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.recieverName);
        super.requestRebind();
    }
    public void setParseUser(@Nullable com.parse.ParseUser ParseUser) {
        this.mParseUser = ParseUser;
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
        com.findajob.jobamax.data.pojo.Message item = mItem;
        com.parse.ParseObject itemGetParseObjectJavaLangStringMessage = null;
        boolean parseUserGetCurrentUserUsernameEqualsItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToString = false;
        java.lang.String itemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrlToString = null;
        java.lang.String itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrlToString = null;
        com.parse.ParseObject itemGetParseObjectJavaLangStringReceiverId = null;
        java.lang.String recieverName = mRecieverName;
        java.lang.Object itemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrl = null;
        java.lang.String itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToString = null;
        java.lang.String parseUserGetCurrentUserUsernameEqualsItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToStringItemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrlToStringItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrlToString = null;
        java.lang.Object itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrl = null;
        com.parse.ParseObject itemGetParseObjectJavaLangStringSenderId = null;
        boolean itemIsSource = false;
        java.lang.String itemGetParseObjectJavaLangStringMessageGetJavaLangStringMessageToString = null;
        android.graphics.drawable.Drawable itemIsSourceMboundView3AndroidDrawableIcTopArrowMboundView3AndroidDrawableIcMessages = null;
        java.lang.Object itemGetParseObjectJavaLangStringMessageGetJavaLangStringMessage = null;
        java.lang.Object itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsername = null;
        java.lang.String parseUserGetCurrentUserUsername = null;

        if ((dirtyFlags & 0x9L) != 0) {

                // read ParseUser.getCurrentUser().username
                parseUserGetCurrentUserUsername = com.parse.ParseUser.getCurrentUser().getUsername();


                if (item != null) {
                    // read item.getParseObject("message")
                    itemGetParseObjectJavaLangStringMessage = item.getParseObject("message");
                    // read item.getParseObject("receiverId")
                    itemGetParseObjectJavaLangStringReceiverId = item.getParseObject("receiverId");
                    // read item.isSource
                    itemIsSource = item.isSource();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsSource) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }


                if (itemGetParseObjectJavaLangStringMessage != null) {
                    // read item.getParseObject("message").get("message")
                    itemGetParseObjectJavaLangStringMessageGetJavaLangStringMessage = itemGetParseObjectJavaLangStringMessage.get("message");
                }
                if (itemGetParseObjectJavaLangStringReceiverId != null) {
                    // read item.getParseObject("receiverId").get("username")
                    itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsername = itemGetParseObjectJavaLangStringReceiverId.get("username");
                }
                // read item.isSource ? @android:drawable/ic_top_arrow : @android:drawable/ic_messages
                itemIsSourceMboundView3AndroidDrawableIcTopArrowMboundView3AndroidDrawableIcMessages = ((itemIsSource) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView3.getContext(), R.drawable.ic_top_arrow)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView3.getContext(), R.drawable.ic_messages)));


                if (itemGetParseObjectJavaLangStringMessageGetJavaLangStringMessage != null) {
                    // read item.getParseObject("message").get("message").toString()
                    itemGetParseObjectJavaLangStringMessageGetJavaLangStringMessageToString = itemGetParseObjectJavaLangStringMessageGetJavaLangStringMessage.toString();
                }
                if (itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsername != null) {
                    // read item.getParseObject("receiverId").get("username").toString()
                    itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToString = itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsername.toString();
                }


                if (parseUserGetCurrentUserUsername != null) {
                    // read ParseUser.getCurrentUser().username.equals(item.getParseObject("receiverId").get("username").toString())
                    parseUserGetCurrentUserUsernameEqualsItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToString = parseUserGetCurrentUserUsername.equals(itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToString);
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(parseUserGetCurrentUserUsernameEqualsItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToString) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
        }
        if ((dirtyFlags & 0xaL) != 0) {
        }
        // batch finished

        if ((dirtyFlags & 0x10L) != 0) {

                if (itemGetParseObjectJavaLangStringReceiverId != null) {
                    // read item.getParseObject("receiverId").get("profilePicUrl")
                    itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrl = itemGetParseObjectJavaLangStringReceiverId.get("profilePicUrl");
                }


                if (itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrl != null) {
                    // read item.getParseObject("receiverId").get("profilePicUrl").toString()
                    itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrlToString = itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrl.toString();
                }
        }
        if ((dirtyFlags & 0x20L) != 0) {

                if (item != null) {
                    // read item.getParseObject("senderId")
                    itemGetParseObjectJavaLangStringSenderId = item.getParseObject("senderId");
                }


                if (itemGetParseObjectJavaLangStringSenderId != null) {
                    // read item.getParseObject("senderId").get("profilePicUrl")
                    itemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrl = itemGetParseObjectJavaLangStringSenderId.get("profilePicUrl");
                }


                if (itemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrl != null) {
                    // read item.getParseObject("senderId").get("profilePicUrl").toString()
                    itemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrlToString = itemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrl.toString();
                }
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read ParseUser.getCurrentUser().username.equals(item.getParseObject("receiverId").get("username").toString()) ? item.getParseObject("senderId").get("profilePicUrl").toString() : item.getParseObject("receiverId").get("profilePicUrl").toString()
                parseUserGetCurrentUserUsernameEqualsItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToStringItemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrlToStringItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrlToString = ((parseUserGetCurrentUserUsernameEqualsItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToString) ? (itemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrlToString) : (itemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrlToString));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemMessagesIvMessage, itemGetParseObjectJavaLangStringMessageGetJavaLangStringMessageToString);
            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrlCircular(this.mboundView1, parseUserGetCurrentUserUsernameEqualsItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringUsernameToStringItemGetParseObjectJavaLangStringSenderIdGetJavaLangStringProfilePicUrlToStringItemGetParseObjectJavaLangStringReceiverIdGetJavaLangStringProfilePicUrlToString);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.mboundView3, itemIsSourceMboundView3AndroidDrawableIcTopArrowMboundView3AndroidDrawableIcMessages);
        }
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemMessagesIvName, recieverName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): recieverName
        flag 2 (0x3L): parseUser
        flag 3 (0x4L): null
        flag 4 (0x5L): ParseUser.getCurrentUser().username.equals(item.getParseObject("receiverId").get("username").toString()) ? item.getParseObject("senderId").get("profilePicUrl").toString() : item.getParseObject("receiverId").get("profilePicUrl").toString()
        flag 5 (0x6L): ParseUser.getCurrentUser().username.equals(item.getParseObject("receiverId").get("username").toString()) ? item.getParseObject("senderId").get("profilePicUrl").toString() : item.getParseObject("receiverId").get("profilePicUrl").toString()
        flag 6 (0x7L): item.isSource ? @android:drawable/ic_top_arrow : @android:drawable/ic_messages
        flag 7 (0x8L): item.isSource ? @android:drawable/ic_top_arrow : @android:drawable/ic_messages
    flag mapping end*/
    //end
}