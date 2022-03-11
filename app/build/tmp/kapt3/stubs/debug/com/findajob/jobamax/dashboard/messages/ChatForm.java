package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatForm;", "Landroidx/databinding/BaseObservable;", "()V", "file", "Landroidx/databinding/ObservableField;", "", "getFile", "()Landroidx/databinding/ObservableField;", "setFile", "(Landroidx/databinding/ObservableField;)V", "infoValid", "", "getInfoValid", "()Z", "setInfoValid", "(Z)V", "message", "getMessage", "setMessage", "messageValid", "getMessageValid", "setMessageValid", "showTemplate", "", "getShowTemplate", "()I", "setShowTemplate", "(I)V", "app_debug"})
public final class ChatForm extends androidx.databinding.BaseObservable {
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> message;
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> file;
    private boolean messageValid = false;
    private int showTemplate = android.view.View.GONE;
    private boolean infoValid = false;
    
    public ChatForm() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @androidx.databinding.Bindable()
    public final boolean getMessageValid() {
        return false;
    }
    
    public final void setMessageValid(boolean messageValid) {
    }
    
    @androidx.databinding.Bindable()
    public final int getShowTemplate() {
        return 0;
    }
    
    public final void setShowTemplate(int showTemplate) {
    }
    
    @androidx.databinding.Bindable()
    public final boolean getInfoValid() {
        return false;
    }
    
    public final void setInfoValid(boolean infoValid) {
    }
}