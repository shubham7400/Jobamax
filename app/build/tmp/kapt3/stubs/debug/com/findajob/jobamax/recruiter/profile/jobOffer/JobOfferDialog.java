package com.findajob.jobamax.recruiter.profile.jobOffer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R,\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/JobOfferDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "jobOffers", "", "Lcom/parse/ParseObject;", "navCreateJob", "Lkotlin/Function0;", "", "onOfferSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "(Landroid/app/Activity;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "getJobOffers", "()Ljava/util/List;", "getNavCreateJob", "()Lkotlin/jvm/functions/Function0;", "getOnOfferSelected", "()Lkotlin/jvm/functions/Function1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class JobOfferDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.parse.ParseObject> jobOffers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> navCreateJob = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.parse.ParseObject, kotlin.Unit> onOfferSelected = null;
    
    public JobOfferDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> jobOffers, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navCreateJob, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> onOfferSelected) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.parse.ParseObject> getJobOffers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getNavCreateJob() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.parse.ParseObject, kotlin.Unit> getOnOfferSelected() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}