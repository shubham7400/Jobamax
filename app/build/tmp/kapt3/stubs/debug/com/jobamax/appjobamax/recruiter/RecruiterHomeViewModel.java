package com.jobamax.appjobamax.recruiter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.recruiter.model.CompanySubscription;
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter;
import com.jobamax.appjobamax.recruiter.model.SeekerFolder;
import com.jobamax.appjobamax.recruiter.model.SourcingCriteria;
import com.parse.ParseObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0005J\u0014\u00103\u001a\u0002012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001e\u00105\u001a\u0002012\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`%J\u0010\u00106\u001a\u0002012\b\u00107\u001a\u0004\u0018\u00010\bJ\u0014\u00108\u001a\u0002012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u001a\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\'\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`%0\u00108F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0012R\u0019\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00108F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0012R(\u0010)\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010*0*0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0012\u00a8\u00069"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_companySubscription", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jobamax/appjobamax/recruiter/model/CompanySubscription;", "_jobTitleFilterList", "", "Lcom/jobamax/appjobamax/recruiter/model/JobTitleFilter;", "_seekerFolders", "Ljava/util/HashSet;", "Lcom/jobamax/appjobamax/recruiter/model/SeekerFolder;", "_selectedJobTitleFilter", "_sourcingCriteriaList", "Lcom/jobamax/appjobamax/recruiter/model/SourcingCriteria;", "companySubscription", "Landroidx/lifecycle/LiveData;", "getCompanySubscription", "()Landroidx/lifecycle/LiveData;", "isRecruiterUpdated", "", "()Landroidx/lifecycle/MutableLiveData;", "setRecruiterUpdated", "(Landroidx/lifecycle/MutableLiveData;)V", "jobTitleFilterList", "getJobTitleFilterList", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "recruiterObject", "Lcom/parse/ParseObject;", "getRecruiterObject", "()Lcom/parse/ParseObject;", "setRecruiterObject", "(Lcom/parse/ParseObject;)V", "seekerFolders", "Lkotlin/collections/HashSet;", "getSeekerFolders", "selectedJobTitleFilter", "getSelectedJobTitleFilter", "shouldBeSelectedSourcingCriteriaSourcingId", "", "kotlin.jvm.PlatformType", "getShouldBeSelectedSourcingCriteriaSourcingId", "setShouldBeSelectedSourcingCriteriaSourcingId", "sourcingCriteriaList", "getSourcingCriteriaList", "setCompanySubscription", "", "cs", "setJobTitleFilterList", "list", "setSeekerFolders", "setSelectedJobTitleFilter", "jobTitleFilter", "setSourcingCriteriaList", "app_debug"})
public final class RecruiterHomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject recruiterObject;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isRecruiterUpdated;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.jobamax.appjobamax.recruiter.model.SourcingCriteria>> _sourcingCriteriaList = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> shouldBeSelectedSourcingCriteriaSourcingId;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.jobamax.appjobamax.recruiter.model.JobTitleFilter>> _jobTitleFilterList = null;
    private final androidx.lifecycle.MutableLiveData<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> _selectedJobTitleFilter = null;
    private final androidx.lifecycle.MutableLiveData<java.util.HashSet<com.jobamax.appjobamax.recruiter.model.SeekerFolder>> _seekerFolders = null;
    private final androidx.lifecycle.MutableLiveData<com.jobamax.appjobamax.recruiter.model.CompanySubscription> _companySubscription = null;
    
    public RecruiterHomeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getRecruiterObject() {
        return null;
    }
    
    public final void setRecruiterObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isRecruiterUpdated() {
        return null;
    }
    
    public final void setRecruiterUpdated(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.jobamax.appjobamax.recruiter.model.SourcingCriteria>> getSourcingCriteriaList() {
        return null;
    }
    
    public final void setSourcingCriteriaList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.jobamax.appjobamax.recruiter.model.SourcingCriteria> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getShouldBeSelectedSourcingCriteriaSourcingId() {
        return null;
    }
    
    public final void setShouldBeSelectedSourcingCriteriaSourcingId(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.jobamax.appjobamax.recruiter.model.JobTitleFilter>> getJobTitleFilterList() {
        return null;
    }
    
    public final void setJobTitleFilterList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.jobamax.appjobamax.recruiter.model.JobTitleFilter> getSelectedJobTitleFilter() {
        return null;
    }
    
    public final void setSelectedJobTitleFilter(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.JobTitleFilter jobTitleFilter) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.HashSet<com.jobamax.appjobamax.recruiter.model.SeekerFolder>> getSeekerFolders() {
        return null;
    }
    
    public final void setSeekerFolders(@org.jetbrains.annotations.NotNull()
    java.util.HashSet<com.jobamax.appjobamax.recruiter.model.SeekerFolder> seekerFolders) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.jobamax.appjobamax.recruiter.model.CompanySubscription> getCompanySubscription() {
        return null;
    }
    
    public final void setCompanySubscription(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.model.CompanySubscription cs) {
    }
}