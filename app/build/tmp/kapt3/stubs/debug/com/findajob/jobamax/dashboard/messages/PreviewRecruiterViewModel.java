package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/PreviewRecruiterViewModel;", "Lcom/findajob/jobamax/base/BaseViewModel;", "repo", "Lcom/findajob/jobamax/repo/MessageRepository;", "(Lcom/findajob/jobamax/repo/MessageRepository;)V", "getRecruiter", "", "Lcom/parse/ParseObject;", "userId", "", "loadJobOffers", "", "callback", "Lcom/findajob/jobamax/repo/GetAllJobOfferCallback;", "app_debug"})
public final class PreviewRecruiterViewModel extends com.findajob.jobamax.base.BaseViewModel {
    private final com.findajob.jobamax.repo.MessageRepository repo = null;
    
    @javax.inject.Inject()
    public PreviewRecruiterViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.MessageRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.parse.ParseObject> getRecruiter(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    public final void loadJobOffers(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
}