package com.jobamax.appjobamax.jobseeker.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jobamax.appjobamax.model.JobSeeker;
import com.parse.ParseObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/view_model/BuildProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isJobSeekerUpdated", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setJobSeekerUpdated", "(Landroidx/lifecycle/MutableLiveData;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "jobSeekerObject", "Lcom/parse/ParseObject;", "getJobSeekerObject", "()Lcom/parse/ParseObject;", "setJobSeekerObject", "(Lcom/parse/ParseObject;)V", "app_debug"})
public final class BuildProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeekerObject;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isJobSeekerUpdated;
    
    public BuildProfileViewModel() {
        super();
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
}