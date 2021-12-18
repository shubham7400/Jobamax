package com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u000bH\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\u008b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001J\t\u00100\u001a\u00020\u000bH\u00d6\u0001J\u0013\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000103H\u00d6\u0003J\t\u00104\u001a\u00020\u000bH\u00d6\u0001J\t\u00105\u001a\u00020\u0003H\u00d6\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015\u00a8\u0006;"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/syllabus/Syllabus;", "Landroid/os/Parcelable;", "_class", "", "asset", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/syllabus/Asset;", "can_be_previewed", "", "created", "description", "id", "", "is_downloadable", "is_free", "is_published", "sort_order", "title", "title_cleaned", "transcript", "(Ljava/lang/String;Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/syllabus/Asset;ZLjava/lang/String;Ljava/lang/String;IZZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "get_class", "()Ljava/lang/String;", "getAsset", "()Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/syllabus/Asset;", "getCan_be_previewed", "()Z", "getCreated", "getDescription", "getId", "()I", "getSort_order", "getTitle", "getTitle_cleaned", "getTranscript", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Syllabus implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String _class = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Asset asset = null;
    private final boolean can_be_previewed = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String created = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final int id = 0;
    private final boolean is_downloadable = false;
    private final boolean is_free = false;
    private final boolean is_published = false;
    private final int sort_order = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title_cleaned = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String transcript = null;
    public static final android.os.Parcelable.Creator<com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus copy(@org.jetbrains.annotations.NotNull()
    java.lang.String _class, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Asset asset, boolean can_be_previewed, @org.jetbrains.annotations.NotNull()
    java.lang.String created, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int id, boolean is_downloadable, boolean is_free, boolean is_published, int sort_order, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String title_cleaned, @org.jetbrains.annotations.NotNull()
    java.lang.String transcript) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Syllabus(@org.jetbrains.annotations.NotNull()
    java.lang.String _class, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Asset asset, boolean can_be_previewed, @org.jetbrains.annotations.NotNull()
    java.lang.String created, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int id, boolean is_downloadable, boolean is_free, boolean is_published, int sort_order, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String title_cleaned, @org.jetbrains.annotations.NotNull()
    java.lang.String transcript) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String get_class() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Asset component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Asset getAsset() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getCan_be_previewed() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean is_downloadable() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean is_free() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean is_published() {
        return false;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int getSort_order() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle_cleaned() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTranscript() {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus[] newArray(int size) {
            return null;
        }
    }
}