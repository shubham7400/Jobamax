// Generated by view binder compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.findajob.jobamax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogNewConfirmationDialogBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton btnYes;

  @NonNull
  public final TextView tvConfirmationMessage;

  @NonNull
  public final TextView tvNo;

  @NonNull
  public final TextView tvNotificationHeader;

  @NonNull
  public final View vBackground;

  private DialogNewConfirmationDialogBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton btnYes, @NonNull TextView tvConfirmationMessage,
      @NonNull TextView tvNo, @NonNull TextView tvNotificationHeader, @NonNull View vBackground) {
    this.rootView = rootView;
    this.btnYes = btnYes;
    this.tvConfirmationMessage = tvConfirmationMessage;
    this.tvNo = tvNo;
    this.tvNotificationHeader = tvNotificationHeader;
    this.vBackground = vBackground;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogNewConfirmationDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogNewConfirmationDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_new_confirmation_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogNewConfirmationDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnYes;
      AppCompatButton btnYes = ViewBindings.findChildViewById(rootView, id);
      if (btnYes == null) {
        break missingId;
      }

      id = R.id.tvConfirmationMessage;
      TextView tvConfirmationMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvConfirmationMessage == null) {
        break missingId;
      }

      id = R.id.tvNo;
      TextView tvNo = ViewBindings.findChildViewById(rootView, id);
      if (tvNo == null) {
        break missingId;
      }

      id = R.id.tvNotificationHeader;
      TextView tvNotificationHeader = ViewBindings.findChildViewById(rootView, id);
      if (tvNotificationHeader == null) {
        break missingId;
      }

      id = R.id.vBackground;
      View vBackground = ViewBindings.findChildViewById(rootView, id);
      if (vBackground == null) {
        break missingId;
      }

      return new DialogNewConfirmationDialogBinding((ConstraintLayout) rootView, btnYes,
          tvConfirmationMessage, tvNo, tvNotificationHeader, vBackground);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}