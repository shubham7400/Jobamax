package com.jobamax.appjobamax.repos;

import com.jobamax.appjobamax.model.SearchQueryCompany;
import com.jobamax.appjobamax.network.ApiFetchCompaniesService;
import com.google.gson.Gson;
import org.json.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0012\u0004\u0012\u00020\n0\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/jobamax/appjobamax/repos/SearchQueryCompanyRepo;", "", "apiFetchCompaniesService", "Lcom/jobamax/appjobamax/network/ApiFetchCompaniesService;", "(Lcom/jobamax/appjobamax/network/ApiFetchCompaniesService;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "getCompanies", "", "searchQuery", "", "onSuccess", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/SearchQueryCompany;", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class SearchQueryCompanyRepo {
    private final com.jobamax.appjobamax.network.ApiFetchCompaniesService apiFetchCompaniesService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public SearchQueryCompanyRepo(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.network.ApiFetchCompaniesService apiFetchCompaniesService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    public final void getCompanies(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.ArrayList<com.jobamax.appjobamax.model.SearchQueryCompany>, kotlin.Unit> onSuccess) {
    }
}