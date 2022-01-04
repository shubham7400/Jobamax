package com.findajob.jobamax.databinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityChatBindingImpl extends ActivityChatBinding implements com.findajob.jobamax.generated.callback.OnClickListener.Listener, com.findajob.jobamax.generated.callback.OnTextChanged.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 17);
        sViewsWithIds.put(R.id.cvUserImage, 18);
        sViewsWithIds.put(R.id.loading, 19);
        sViewsWithIds.put(R.id.chat_rv_message, 20);
        sViewsWithIds.put(R.id.rlBottomSendPart, 21);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.Button mboundView10;
    @NonNull
    private final android.widget.ImageView mboundView16;
    @NonNull
    private final android.widget.Button mboundView8;
    @NonNull
    private final android.widget.Button mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback59;
    @Nullable
    private final android.view.View.OnClickListener mCallback55;
    @Nullable
    private final android.view.View.OnClickListener mCallback62;
    @Nullable
    private final android.view.View.OnClickListener mCallback56;
    @Nullable
    private final android.view.View.OnClickListener mCallback63;
    @Nullable
    private final android.view.View.OnClickListener mCallback57;
    @Nullable
    private final android.view.View.OnClickListener mCallback65;
    @Nullable
    private final androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged mCallback64;
    @Nullable
    private final android.view.View.OnClickListener mCallback60;
    @Nullable
    private final android.view.View.OnClickListener mCallback58;
    @Nullable
    private final android.view.View.OnClickListener mCallback54;
    @Nullable
    private final android.view.View.OnClickListener mCallback61;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChatBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private ActivityChatBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[11]
            , (androidx.cardview.widget.CardView) bindings[15]
            , (android.widget.EditText) bindings[14]
            , (android.widget.LinearLayout) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (androidx.cardview.widget.CardView) bindings[18]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[5]
            , (com.github.loadingview.LoadingView) bindings[19]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[21]
            , (androidx.appcompat.widget.Toolbar) bindings[17]
            , (android.widget.TextView) bindings[3]
            );
        this.chatBCamera.setTag(null);
        this.chatBFile.setTag(null);
        this.chatBImage.setTag(null);
        this.chatBMessage.setTag(null);
        this.chatEtMessage.setTag(null);
        this.chatLlTemplate.setTag(null);
        this.ivBackButton.setTag(null);
        this.ivCallButton.setTag(null);
        this.ivRequirementOpenButton.setTag(null);
        this.ivUserImage.setTag(null);
        this.ivVideoButton.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (android.widget.Button) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView16 = (android.widget.ImageView) bindings[16];
        this.mboundView16.setTag(null);
        this.mboundView8 = (android.widget.Button) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.Button) bindings[9];
        this.mboundView9.setTag(null);
        this.tvUsername.setTag(null);
        setRootTag(root);
        // listeners
        mCallback59 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 6);
        mCallback55 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 2);
        mCallback62 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 9);
        mCallback56 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 3);
        mCallback63 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 10);
        mCallback57 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 4);
        mCallback65 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 12);
        mCallback64 = new com.findajob.jobamax.generated.callback.OnTextChanged(this, 11);
        mCallback60 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 7);
        mCallback58 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 5);
        mCallback54 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 1);
        mCallback61 = new com.findajob.jobamax.generated.callback.OnClickListener(this, 8);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x200L;
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
            setVm((com.findajob.jobamax.dashboard.messages.ChatViewModel) variable);
        }
        else if (BR.profilePictureUrl == variableId) {
            setProfilePictureUrl((java.lang.String) variable);
        }
        else if (BR.handler == variableId) {
            setHandler((com.findajob.jobamax.dashboard.messages.ChatHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.findajob.jobamax.dashboard.messages.ChatViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public void setProfilePictureUrl(@Nullable java.lang.String ProfilePictureUrl) {
        this.mProfilePictureUrl = ProfilePictureUrl;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.profilePictureUrl);
        super.requestRebind();
    }
    public void setHandler(@Nullable com.findajob.jobamax.dashboard.messages.ChatHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmFormGetValue((com.findajob.jobamax.dashboard.messages.ChatForm) object, fieldId);
            case 1 :
                return onChangeVmFormMessage((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeVmForm((androidx.lifecycle.MutableLiveData<com.findajob.jobamax.dashboard.messages.ChatForm>) object, fieldId);
            case 3 :
                return onChangeVmName((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmFormGetValue(com.findajob.jobamax.dashboard.messages.ChatForm VmFormGetValue, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.showTemplate) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        else if (fieldId == BR.messageValid) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmFormMessage(androidx.databinding.ObservableField<java.lang.String> VmFormMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmForm(androidx.lifecycle.MutableLiveData<com.findajob.jobamax.dashboard.messages.ChatForm> VmForm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.messageValid) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmName(androidx.lifecycle.LiveData<java.lang.String> VmName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
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
        com.findajob.jobamax.dashboard.messages.ChatForm vmFormGetValue = null;
        com.findajob.jobamax.dashboard.messages.ChatViewModel vm = mVm;
        androidx.databinding.ObservableField<java.lang.String> vmFormMessage = null;
        int vmFormMessageValidMboundView16AndroidColorComFacebookMessengerBlueMboundView16AndroidColorGrey = 0;
        androidx.lifecycle.MutableLiveData<com.findajob.jobamax.dashboard.messages.ChatForm> vmForm = null;
        java.lang.String profilePictureUrl = mProfilePictureUrl;
        androidx.lifecycle.LiveData<java.lang.String> vmName = null;
        java.lang.String vmFormMessageGet = null;
        int vmFormMessageValidChatBMessageAndroidColorGreyishWhiteChatBMessageAndroidColorWhite = 0;
        boolean vmFormMessageValid = false;
        java.lang.String vmNameGetValue = null;
        com.findajob.jobamax.dashboard.messages.ChatHandler handler = mHandler;
        int vmFormShowTemplate = 0;

        if ((dirtyFlags & 0x39fL) != 0) {


            if ((dirtyFlags & 0x397L) != 0) {

                    if (vm != null) {
                        // read vm.form
                        vmForm = vm.getForm();
                    }
                    updateLiveDataRegistration(2, vmForm);


                    if (vmForm != null) {
                        // read vm.form.getValue()
                        vmFormGetValue = vmForm.getValue();
                    }
                    updateRegistration(0, vmFormGetValue);

                if ((dirtyFlags & 0x217L) != 0) {

                        if (vmFormGetValue != null) {
                            // read vm.form.getValue().message
                            vmFormMessage = vmFormGetValue.getMessage();
                        }
                        updateRegistration(1, vmFormMessage);


                        if (vmFormMessage != null) {
                            // read vm.form.getValue().message.get()
                            vmFormMessageGet = vmFormMessage.get();
                        }
                }
                if ((dirtyFlags & 0x315L) != 0) {

                        if (vmFormGetValue != null) {
                            // read vm.form.getValue().messageValid
                            vmFormMessageValid = vmFormGetValue.getMessageValid();
                        }
                    if((dirtyFlags & 0x315L) != 0) {
                        if(vmFormMessageValid) {
                                dirtyFlags |= 0x800L;
                                dirtyFlags |= 0x2000L;
                        }
                        else {
                                dirtyFlags |= 0x400L;
                                dirtyFlags |= 0x1000L;
                        }
                    }


                        // read vm.form.getValue().messageValid ? @android:color/com_facebook_messenger_blue : @android:color/grey
                        vmFormMessageValidMboundView16AndroidColorComFacebookMessengerBlueMboundView16AndroidColorGrey = ((vmFormMessageValid) ? (getColorFromResource(mboundView16, R.color.com_facebook_messenger_blue)) : (getColorFromResource(mboundView16, R.color.grey)));
                        // read vm.form.getValue().messageValid ? @android:color/greyishWhite : @android:color/white
                        vmFormMessageValidChatBMessageAndroidColorGreyishWhiteChatBMessageAndroidColorWhite = ((vmFormMessageValid) ? (getColorFromResource(chatBMessage, R.color.greyishWhite)) : (getColorFromResource(chatBMessage, R.color.white)));
                }
                if ((dirtyFlags & 0x295L) != 0) {

                        if (vmFormGetValue != null) {
                            // read vm.form.getValue().showTemplate
                            vmFormShowTemplate = vmFormGetValue.getShowTemplate();
                        }
                }
            }
            if ((dirtyFlags & 0x218L) != 0) {

                    if (vm != null) {
                        // read vm.name
                        vmName = vm.getName();
                    }
                    updateLiveDataRegistration(3, vmName);


                    if (vmName != null) {
                        // read vm.name.getValue()
                        vmNameGetValue = vmName.getValue();
                    }
            }
        }
        if ((dirtyFlags & 0x220L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x200L) != 0) {
            // api target 1

            this.chatBCamera.setOnClickListener(mCallback62);
            this.chatBFile.setOnClickListener(mCallback63);
            this.chatBImage.setOnClickListener(mCallback61);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.chatEtMessage, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, mCallback64, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, (androidx.databinding.InverseBindingListener)null);
            this.ivBackButton.setOnClickListener(mCallback54);
            this.ivCallButton.setOnClickListener(mCallback55);
            this.ivRequirementOpenButton.setOnClickListener(mCallback57);
            this.ivVideoButton.setOnClickListener(mCallback56);
            this.mboundView10.setOnClickListener(mCallback60);
            this.mboundView16.setOnClickListener(mCallback65);
            this.mboundView8.setOnClickListener(mCallback58);
            this.mboundView9.setOnClickListener(mCallback59);
        }
        if ((dirtyFlags & 0x315L) != 0) {
            // api target 1

            this.chatBMessage.setCardBackgroundColor(vmFormMessageValidChatBMessageAndroidColorGreyishWhiteChatBMessageAndroidColorWhite);
            this.mboundView16.setEnabled(vmFormMessageValid);
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.mboundView16.setImageTintList(androidx.databinding.adapters.Converters.convertColorToColorStateList(vmFormMessageValidMboundView16AndroidColorComFacebookMessengerBlueMboundView16AndroidColorGrey));
            }
        }
        if ((dirtyFlags & 0x217L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.chatEtMessage, vmFormMessageGet);
        }
        if ((dirtyFlags & 0x295L) != 0) {
            // api target 1

            this.chatLlTemplate.setVisibility(vmFormShowTemplate);
        }
        if ((dirtyFlags & 0x220L) != 0) {
            // api target 1

            com.findajob.jobamax.util.ImageBindingAdaptersKt.loadImageFromUrlCircular(this.ivUserImage, profilePictureUrl);
        }
        if ((dirtyFlags & 0x218L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvUsername, vmNameGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 6: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.findajob.jobamax.dashboard.messages.ChatViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.setInputTemplate(1);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.dashboard.messages.ChatHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCallButtonPressed();
                }
                break;
            }
            case 9: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.dashboard.messages.ChatHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.launchCamera();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.dashboard.messages.ChatHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onVideoCallButtonPressed();
                }
                break;
            }
            case 10: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.findajob.jobamax.dashboard.messages.ChatViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.setSelectFiles(true);
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.dashboard.messages.ChatHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onRequirementsButtonPressed();
                }
                break;
            }
            case 12: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.dashboard.messages.ChatHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onSendMessage();
                }
                break;
            }
            case 7: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.findajob.jobamax.dashboard.messages.ChatViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.setInputTemplate(2);
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.findajob.jobamax.dashboard.messages.ChatViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.setInputTemplate(0);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                com.findajob.jobamax.dashboard.messages.ChatHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onBackPress();
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.findajob.jobamax.dashboard.messages.ChatViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.setSelectImage(true);
                }
                break;
            }
        }
    }
    public final void _internalCallbackOnTextChanged(int sourceId , java.lang.CharSequence callbackArg_0, int callbackArg_1, int callbackArg_2, int callbackArg_3) {
        // localize variables for thread safety
        // vm != null
        boolean vmJavaLangObjectNull = false;
        // vm
        com.findajob.jobamax.dashboard.messages.ChatViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {



            vm.onMessageChange(callbackArg_0);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.form.getValue()
        flag 1 (0x2L): vm.form.getValue().message
        flag 2 (0x3L): vm.form
        flag 3 (0x4L): vm.name
        flag 4 (0x5L): vm
        flag 5 (0x6L): profilePictureUrl
        flag 6 (0x7L): handler
        flag 7 (0x8L): vm.form.getValue().showTemplate
        flag 8 (0x9L): vm.form.getValue().messageValid
        flag 9 (0xaL): null
        flag 10 (0xbL): vm.form.getValue().messageValid ? @android:color/com_facebook_messenger_blue : @android:color/grey
        flag 11 (0xcL): vm.form.getValue().messageValid ? @android:color/com_facebook_messenger_blue : @android:color/grey
        flag 12 (0xdL): vm.form.getValue().messageValid ? @android:color/greyishWhite : @android:color/white
        flag 13 (0xeL): vm.form.getValue().messageValid ? @android:color/greyishWhite : @android:color/white
    flag mapping end*/
    //end
}