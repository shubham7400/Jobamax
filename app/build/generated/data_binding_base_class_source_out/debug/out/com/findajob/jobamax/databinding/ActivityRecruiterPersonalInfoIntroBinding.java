// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.model.Company;
import com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInfoIntroInterface;
import com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel;
import com.hbb20.CountryCodePicker;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityRecruiterPersonalInfoIntroBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnSave;

  @NonNull
  public final CountryCodePicker ccp;

  @NonNull
  public final ConstraintLayout clActionBar;

  @NonNull
  public final EditText etEmailField;

  @NonNull
  public final EditText etFirstName;

  @NonNull
  public final EditText etInvitationCode;

  @NonNull
  public final EditText etLastName;

  @NonNull
  public final EditText etPhoneNumber;

  @NonNull
  public final EditText etPostalCode;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final LinearLayout llPhoneNumberField;

  @NonNull
  public final RelativeLayout rlGenderButton;

  @NonNull
  public final ScrollView svMainBody;

  @NonNull
  public final TextView tvDateOfBirth;

  @NonNull
  public final TextView tvDateOfBirthField;

  @NonNull
  public final TextView tvEmail;

  @NonNull
  public final TextView tvFirstNameLabel;

  @NonNull
  public final TextView tvGenderHint;

  @NonNull
  public final TextView tvGenderLabel;

  @NonNull
  public final TextView tvInvitationCode;

  @NonNull
  public final TextView tvLastNameLabel;

  @NonNull
  public final TextView tvPhoneNumber;

  @NonNull
  public final TextView tvPostalCode;

  @Bindable
  protected RecruiterPersonalInfoIntroInterface mHandler;

  @Bindable
  protected Company mCompany;

  @Bindable
  protected RecruiterPersonalInformationModel mRecruiter;

  protected ActivityRecruiterPersonalInfoIntroBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatButton btnSave, CountryCodePicker ccp,
      ConstraintLayout clActionBar, EditText etEmailField, EditText etFirstName,
      EditText etInvitationCode, EditText etLastName, EditText etPhoneNumber, EditText etPostalCode,
      ImageView ivBackButton, LinearLayout llPhoneNumberField, RelativeLayout rlGenderButton,
      ScrollView svMainBody, TextView tvDateOfBirth, TextView tvDateOfBirthField, TextView tvEmail,
      TextView tvFirstNameLabel, TextView tvGenderHint, TextView tvGenderLabel,
      TextView tvInvitationCode, TextView tvLastNameLabel, TextView tvPhoneNumber,
      TextView tvPostalCode) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSave = btnSave;
    this.ccp = ccp;
    this.clActionBar = clActionBar;
    this.etEmailField = etEmailField;
    this.etFirstName = etFirstName;
    this.etInvitationCode = etInvitationCode;
    this.etLastName = etLastName;
    this.etPhoneNumber = etPhoneNumber;
    this.etPostalCode = etPostalCode;
    this.ivBackButton = ivBackButton;
    this.llPhoneNumberField = llPhoneNumberField;
    this.rlGenderButton = rlGenderButton;
    this.svMainBody = svMainBody;
    this.tvDateOfBirth = tvDateOfBirth;
    this.tvDateOfBirthField = tvDateOfBirthField;
    this.tvEmail = tvEmail;
    this.tvFirstNameLabel = tvFirstNameLabel;
    this.tvGenderHint = tvGenderHint;
    this.tvGenderLabel = tvGenderLabel;
    this.tvInvitationCode = tvInvitationCode;
    this.tvLastNameLabel = tvLastNameLabel;
    this.tvPhoneNumber = tvPhoneNumber;
    this.tvPostalCode = tvPostalCode;
  }

  public abstract void setHandler(@Nullable RecruiterPersonalInfoIntroInterface handler);

  @Nullable
  public RecruiterPersonalInfoIntroInterface getHandler() {
    return mHandler;
  }

  public abstract void setCompany(@Nullable Company company);

  @Nullable
  public Company getCompany() {
    return mCompany;
  }

  public abstract void setRecruiter(@Nullable RecruiterPersonalInformationModel recruiter);

  @Nullable
  public RecruiterPersonalInformationModel getRecruiter() {
    return mRecruiter;
  }

  @NonNull
  public static ActivityRecruiterPersonalInfoIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_recruiter_personal_info_intro, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRecruiterPersonalInfoIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityRecruiterPersonalInfoIntroBinding>inflateInternal(inflater, R.layout.activity_recruiter_personal_info_intro, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRecruiterPersonalInfoIntroBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_recruiter_personal_info_intro, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRecruiterPersonalInfoIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityRecruiterPersonalInfoIntroBinding>inflateInternal(inflater, R.layout.activity_recruiter_personal_info_intro, null, false, component);
  }

  public static ActivityRecruiterPersonalInfoIntroBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityRecruiterPersonalInfoIntroBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityRecruiterPersonalInfoIntroBinding)bind(component, view, R.layout.activity_recruiter_personal_info_intro);
  }
}