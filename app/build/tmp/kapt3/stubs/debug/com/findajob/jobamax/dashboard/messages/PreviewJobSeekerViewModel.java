package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/PreviewJobSeekerViewModel;", "Lcom/findajob/jobamax/base/BaseViewModel;", "repo", "Lcom/findajob/jobamax/repo/MessageRepository;", "(Lcom/findajob/jobamax/repo/MessageRepository;)V", "getJobSeeker", "", "Lcom/parse/ParseObject;", "userId", "", "app_debug"})
public final class PreviewJobSeekerViewModel extends com.findajob.jobamax.base.BaseViewModel {
    private final com.findajob.jobamax.repo.MessageRepository repo = null;
    
    @javax.inject.Inject()
    public PreviewJobSeekerViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.MessageRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.parse.ParseObject> getJobSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
}