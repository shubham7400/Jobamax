package com.jobamax.appjobamax.model;

import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.parse.ParseObject;
import java.io.Serializable;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005J\u0006\u00104\u001a\u00020\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0004R\u001a\u0010\"\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010%\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001c\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0004R\u001a\u00101\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001b\u00a8\u00065"}, d2 = {"Lcom/jobamax/appjobamax/model/ChatThread;", "Ljava/io/Serializable;", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "()V", "archivedBy", "", "", "getArchivedBy", "()Ljava/util/List;", "setArchivedBy", "(Ljava/util/List;)V", "chatThreadParseObject", "getChatThreadParseObject", "()Lcom/parse/ParseObject;", "setChatThreadParseObject", "deleteHistory", "getDeleteHistory", "setDeleteHistory", "deletedBy", "getDeletedBy", "setDeletedBy", "jobOfferId", "getJobOfferId", "()Ljava/lang/String;", "setJobOfferId", "(Ljava/lang/String;)V", "jobSeekerId", "getJobSeekerId", "setJobSeekerId", "jobSeekerParseObject", "getJobSeekerParseObject", "setJobSeekerParseObject", "jobTitle", "getJobTitle", "setJobTitle", "jsFilter", "", "getJsFilter", "()I", "setJsFilter", "(I)V", "latestText", "getLatestText", "setLatestText", "recruiterParseObject", "getRecruiterParseObject", "setRecruiterParseObject", "threadId", "getThreadId", "setThreadId", "toParseObject", "app_debug"})
public final class ChatThread implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Transient()
    private transient com.parse.ParseObject chatThreadParseObject;
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Transient()
    private transient com.parse.ParseObject jobSeekerParseObject;
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Transient()
    private transient com.parse.ParseObject recruiterParseObject;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String threadId = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> deleteHistory;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> deletedBy;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String latestText = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> archivedBy;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobTitle = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobSeekerId = "";
    private int jsFilter = -1;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobOfferId = "";
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getChatThreadParseObject() {
        return null;
    }
    
    public final void setChatThreadParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getJobSeekerParseObject() {
        return null;
    }
    
    public final void setJobSeekerParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getRecruiterParseObject() {
        return null;
    }
    
    public final void setRecruiterParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    public final void setThreadId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getDeleteHistory() {
        return null;
    }
    
    public final void setDeleteHistory(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getDeletedBy() {
        return null;
    }
    
    public final void setDeletedBy(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLatestText() {
        return null;
    }
    
    public final void setLatestText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getArchivedBy() {
        return null;
    }
    
    public final void setArchivedBy(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobTitle() {
        return null;
    }
    
    public final void setJobTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final void setJobSeekerId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getJsFilter() {
        return 0;
    }
    
    public final void setJsFilter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    public final void setJobOfferId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    public ChatThread(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    public ChatThread() {
        super();
    }
}