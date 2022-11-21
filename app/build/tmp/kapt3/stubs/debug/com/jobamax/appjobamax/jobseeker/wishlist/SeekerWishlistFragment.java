package com.jobamax.appjobamax.jobseeker.wishlist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.WebViewActivity;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentSeekerWishlistBinding;
import com.jobamax.appjobamax.databinding.ItemNewWishlistBinding;
import com.jobamax.appjobamax.dialog.DialogYesNoSimple;
import com.jobamax.appjobamax.jobseeker.dialog.WishlistFilterDialog;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.model.WishlistJob;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.util.SwipeHelper;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import org.json.JSONObject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00016B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001d0!J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\u0012\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u0010\u001a\u001a\u00020\u001dH\u0002J$\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u00112\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001d0!H\u0002J&\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u00112\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001d0!H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u00067"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishlistFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "appliedFilter", "", "getAppliedFilter", "()I", "setAppliedFilter", "(I)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerWishlistBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentSeekerWishlistBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentSeekerWishlistBinding;)V", "wishlist", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/WishlistJob;", "getWishlist", "()Ljava/util/ArrayList;", "setWishlist", "(Ljava/util/ArrayList;)V", "wishlistAdapter", "Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerNewWishlistAdapter;", "getWishlistAdapter", "()Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerNewWishlistAdapter;", "setWishlistAdapter", "(Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerNewWishlistAdapter;)V", "apply", "", "jobOfferId", "", "applyStatus", "Lkotlin/Function1;", "", "configureUi", "fetchWishlist", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "setClickListeners", "updateArchiveStatus", "wishlistJob", "archiveStatus", "updateFavoriteStatus", "updateWishlist", "filterId", "WishlistJobFilter", "app_debug"})
public final class SeekerWishlistFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentSeekerWishlistBinding binding;
    public com.jobamax.appjobamax.jobseeker.wishlist.SeekerNewWishlistAdapter wishlistAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.WishlistJob> wishlist;
    private int appliedFilter;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerWishlistFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentSeekerWishlistBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentSeekerWishlistBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.wishlist.SeekerNewWishlistAdapter getWishlistAdapter() {
        return null;
    }
    
    public final void setWishlistAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.wishlist.SeekerNewWishlistAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.WishlistJob> getWishlist() {
        return null;
    }
    
    public final void setWishlist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.WishlistJob> p0) {
    }
    
    public final int getAppliedFilter() {
        return 0;
    }
    
    public final void setAppliedFilter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void configureUi() {
    }
    
    public final void apply(@org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> applyStatus) {
    }
    
    private final void updateFavoriteStatus(com.jobamax.appjobamax.model.WishlistJob wishlistJob, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> applyStatus) {
    }
    
    private final void updateArchiveStatus(com.jobamax.appjobamax.model.WishlistJob wishlistJob, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> archiveStatus) {
    }
    
    private final void fetchWishlist() {
    }
    
    private final void setWishlistAdapter() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void updateWishlist(int filterId) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishlistFragment$WishlistJobFilter;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "All", "ARCHIVE", "TO_DO", "PROGRESS", "app_debug"})
    public static enum WishlistJobFilter {
        /*public static final*/ All /* = new All(0) */,
        /*public static final*/ ARCHIVE /* = new ARCHIVE(0) */,
        /*public static final*/ TO_DO /* = new TO_DO(0) */,
        /*public static final*/ PROGRESS /* = new PROGRESS(0) */;
        private final int value = 0;
        
        WishlistJobFilter(int value) {
        }
        
        public final int getValue() {
            return 0;
        }
    }
}