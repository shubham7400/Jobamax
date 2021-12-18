package com.findajob.jobamax.data.pojo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0002R(\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR$\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR(\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010&\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\'\u0010\u0006\"\u0004\b(\u0010\bR0\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"\u00a8\u0006-"}, d2 = {"Lcom/findajob/jobamax/data/pojo/Message;", "Lcom/parse/ParseObject;", "()V", "Chat", "file", "getFile", "()Lcom/parse/ParseObject;", "setFile", "(Lcom/parse/ParseObject;)V", "isArchived", "", "()Z", "setArchived", "(Z)V", "isReach", "isJob", "setJob", "isNetworking", "setNetworking", "isSource", "setSource", "message", "getMessage", "setMessage", "receiverId", "getReceiverId", "setReceiverId", "list", "", "", "requirements", "getRequirements", "()Ljava/util/List;", "setRequirements", "(Ljava/util/List;)V", "seenBy", "getSeenBy", "setSeenBy", "senderId", "getSenderId", "setSenderId", "shortListedBy", "getShortListedBy", "setShortListedBy", "Companion", "app_debug"})
@com.parse.ParseClassName(value = "Message")
public final class Message extends com.parse.ParseObject {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.data.pojo.Message.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MESSAGE = "message";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_JOB = "isJob";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_NETWORKING = "isNetworking";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_ARCHIVED = "isArchived";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SENDER_ID = "senderId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RECEIVER_ID = "receiverId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILE = "file";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SHORT_LISTED_BY = "shortListedBy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_SOURCE = "isSource";
    
    public Message() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject Chat) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject getSenderId() {
        return null;
    }
    
    public final void setSenderId(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject senderId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject getReceiverId() {
        return null;
    }
    
    public final void setReceiverId(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject receiverId) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject Chat) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getShortListedBy() {
        return null;
    }
    
    public final void setShortListedBy(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSeenBy() {
        return null;
    }
    
    public final void setSeenBy(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> seenBy) {
    }
    
    public final boolean isJob() {
        return false;
    }
    
    public final void setJob(boolean isReach) {
    }
    
    public final boolean isNetworking() {
        return false;
    }
    
    public final void setNetworking(boolean isNetworking) {
    }
    
    public final boolean isSource() {
        return false;
    }
    
    public final void setSource(boolean isSource) {
    }
    
    public final boolean isArchived() {
        return false;
    }
    
    public final void setArchived(boolean isArchived) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRequirements() {
        return null;
    }
    
    public final void setRequirements(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/findajob/jobamax/data/pojo/Message$Companion;", "", "()V", "FILE", "", "IS_ARCHIVED", "IS_JOB", "IS_NETWORKING", "IS_SOURCE", "MESSAGE", "RECEIVER_ID", "SENDER_ID", "SHORT_LISTED_BY", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}