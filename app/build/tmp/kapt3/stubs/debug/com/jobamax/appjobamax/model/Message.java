package com.jobamax.appjobamax.model;

import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.parse.ParseObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010+\u001a\u00020\u0003R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0004R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u001a\u0010\"\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001a\u0010%\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Lcom/jobamax/appjobamax/model/Message;", "", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "()V", "mediaCaption", "", "getMediaCaption", "()Ljava/lang/String;", "setMediaCaption", "(Ljava/lang/String;)V", "mediaUrl", "getMediaUrl", "setMediaUrl", "messageId", "getMessageId", "setMessageId", "messageParseObject", "getMessageParseObject", "()Lcom/parse/ParseObject;", "setMessageParseObject", "seenBy", "", "getSeenBy", "()Ljava/util/List;", "setSeenBy", "(Ljava/util/List;)V", "senderId", "getSenderId", "setSenderId", "text", "getText", "setText", "threadId", "getThreadId", "setThreadId", "type", "", "getType", "()I", "setType", "(I)V", "toParseObject", "app_debug"})
public final class Message {
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject messageParseObject;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String senderId = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> seenBy;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mediaCaption = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String messageId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String threadId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mediaUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String text = "";
    private int type = -1;
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getMessageParseObject() {
        return null;
    }
    
    public final void setMessageParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSenderId() {
        return null;
    }
    
    public final void setSenderId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSeenBy() {
        return null;
    }
    
    public final void setSeenBy(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMediaCaption() {
        return null;
    }
    
    public final void setMediaCaption(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessageId() {
        return null;
    }
    
    public final void setMessageId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    public final void setThreadId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMediaUrl() {
        return null;
    }
    
    public final void setMediaUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getText() {
        return null;
    }
    
    public final void setText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getType() {
        return 0;
    }
    
    public final void setType(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    public Message(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    public Message() {
        super();
    }
}