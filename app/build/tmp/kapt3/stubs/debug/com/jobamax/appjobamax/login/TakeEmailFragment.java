package com.jobamax.appjobamax.login;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentTakeEmailBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.dialog.MessageDialog;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.model.UserTempInfo;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/jobamax/appjobamax/login/TakeEmailFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentTakeEmailBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentTakeEmailBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentTakeEmailBinding;)V", "user", "Lcom/jobamax/appjobamax/model/UserTempInfo;", "getUser", "()Lcom/jobamax/appjobamax/model/UserTempInfo;", "setUser", "(Lcom/jobamax/appjobamax/model/UserTempInfo;)V", "configureUi", "", "isEmailAlreadyRegistered", "callback", "Lkotlin/Function0;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "app_debug"})
public final class TakeEmailFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentTakeEmailBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.UserTempInfo user;
    private java.util.HashMap _$_findViewCache;
    
    public TakeEmailFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentTakeEmailBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentTakeEmailBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.UserTempInfo getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.UserTempInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void isEmailAlreadyRegistered(com.jobamax.appjobamax.model.UserTempInfo user, kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
}