package com.jobamax.appjobamax.jobseeker.profile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseActivity;
import com.jobamax.appjobamax.databinding.ActivitySeekerCreateCvBinding;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/SeekerCreateCvActivity;", "Lcom/jobamax/appjobamax/base/BaseActivity;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/ActivitySeekerCreateCvBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ActivitySeekerCreateCvBinding;", "binding$delegate", "Lkotlin/Lazy;", "modifyCvScreenPositionY", "", "getModifyCvScreenPositionY", "()I", "setModifyCvScreenPositionY", "(I)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "configureUi", "", "getJobSeeker", "callback", "Lkotlin/Function1;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SeekerCreateCvActivity extends com.jobamax.appjobamax.base.BaseActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy binding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private int modifyCvScreenPositionY = 0;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerCreateCvActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.ActivitySeekerCreateCvBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
    }
    
    public final int getModifyCvScreenPositionY() {
        return 0;
    }
    
    public final void setModifyCvScreenPositionY(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configureUi() {
    }
    
    public final void getJobSeeker(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
}