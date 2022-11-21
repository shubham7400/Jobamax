package com.jobamax.appjobamax.jobseeker.view_model;

import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.model.*;
import com.parse.ParseException;
import com.parse.ParseObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_chatThreadList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/jobamax/appjobamax/model/ChatThread;", "chatThreadList", "Landroidx/lifecycle/LiveData;", "getChatThreadList", "()Landroidx/lifecycle/LiveData;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "isJobSeekerUpdated", "", "()Landroidx/lifecycle/MutableLiveData;", "setJobSeekerUpdated", "(Landroidx/lifecycle/MutableLiveData;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "jobSeekerObject", "Lcom/parse/ParseObject;", "getJobSeekerObject", "()Lcom/parse/ParseObject;", "setJobSeekerObject", "(Lcom/parse/ParseObject;)V", "setChatThreadList", "", "list", "app_debug"})
public final class SeekerHomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeekerObject;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isJobSeekerUpdated;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.jobamax.appjobamax.model.ChatThread>> _chatThreadList = null;
    
    public SeekerHomeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getJobSeekerObject() {
        return null;
    }
    
    public final void setJobSeekerObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isJobSeekerUpdated() {
        return null;
    }
    
    public final void setJobSeekerUpdated(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.jobamax.appjobamax.model.ChatThread>> getChatThreadList() {
        return null;
    }
    
    public final void setChatThreadList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.jobamax.appjobamax.model.ChatThread> list) {
    }
}