package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0083\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t2\u0006\u0010\u000f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/repo/JobSeekerResumeRepo;", "", "saveResumeData", "", "jobSeekerPo", "Lcom/parse/ParseObject;", "educations", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Education;", "Lkotlin/collections/ArrayList;", "experiences", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;", "skills", "", "activities", "aboutMe", "(Lcom/parse/ParseObject;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface JobSeekerResumeRepo {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveResumeData(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject jobSeekerPo, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.jobseeker.profile.cv.model.Education> educations, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.jobseeker.profile.cv.model.Experience> experiences, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> skills, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> activities, @org.jetbrains.annotations.NotNull()
    java.lang.String aboutMe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
}