// Generated by view binder compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.findajob.jobamax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogChangePasswordBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button btnOk;

  @NonNull
  public final TextView tvEmail;

  @NonNull
  public final TextView tvMessage;

  private DialogChangePasswordBinding(@NonNull CardView rootView, @NonNull Button btnOk,
      @NonNull TextView tvEmail, @NonNull TextView tvMessage) {
    this.rootView = rootView;
    this.btnOk = btnOk;
    this.tvEmail = tvEmail;
    this.tvMessage = tvMessage;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogChangePasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_change_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogChangePasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_ok;
      Button btnOk = ViewBindings.findChildViewById(rootView, id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.tv_email;
      TextView tvEmail = ViewBindings.findChildViewById(rootView, id);
      if (tvEmail == null) {
        break missingId;
      }

      id = R.id.tv_message;
      TextView tvMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvMessage == null) {
        break missingId;
      }

      return new DialogChangePasswordBinding((CardView) rootView, btnOk, tvEmail, tvMessage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
