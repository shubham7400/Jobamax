package com.jobamax.appjobamax.repos;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\"\u0010\t\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/jobamax/appjobamax/repos/SearchQueryCompanyRepo;", "", "apiFetchCompaniesService", "Lcom/jobamax/appjobamax/network/ApiFetchCompaniesService;", "(Lcom/jobamax/appjobamax/network/ApiFetchCompaniesService;)V", "getCompanies", "", "searchQuery", "", "onSuccess", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/SearchQueryCompany;", "Lkotlin/collections/ArrayList;", "app_release"})
public final class SearchQueryCompanyRepo {
    private final com.jobamax.appjobamax.network.ApiFetchCompaniesService apiFetchCompaniesService = null;
    
    public SearchQueryCompanyRepo(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.network.ApiFetchCompaniesService apiFetchCompaniesService) {
        super();
    }
    
    public final void getCompanies(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.ArrayList<com.jobamax.appjobamax.model.SearchQueryCompany>, kotlin.Unit> onSuccess) {
    }
}