package com.jobamax.appjobamax.jobseeker.profile.account.deleteAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jobamax.appjobamax.NewSplashActivity;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountFinalBinding;
import com.jobamax.appjobamax.dialog.DeleteAccountDialog;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseUser;
import com.pushwoosh.Pushwoosh;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/account/deleteAccount/SeekerDeleteAccountFinalInterface;", "", "onBackPress", "", "onDeleteAccount", "app_debug"})
public abstract interface SeekerDeleteAccountFinalInterface {
    
    public abstract void onDeleteAccount();
    
    public abstract void onBackPress();
}