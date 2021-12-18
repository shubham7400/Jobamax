// Generated by view binder compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.findajob.jobamax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogBasic2Binding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final AppCompatButton btnCancel;

  @NonNull
  public final AppCompatButton btnOk;

  @NonNull
  public final AppCompatTextView tvMessage;

  @NonNull
  public final View vDivider;

  private DialogBasic2Binding(@NonNull CardView rootView, @NonNull AppCompatButton btnCancel,
      @NonNull AppCompatButton btnOk, @NonNull AppCompatTextView tvMessage,
      @NonNull View vDivider) {
    this.rootView = rootView;
    this.btnCancel = btnCancel;
    this.btnOk = btnOk;
    this.tvMessage = tvMessage;
    this.vDivider = vDivider;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogBasic2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogBasic2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_basic_2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogBasic2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_cancel;
      AppCompatButton btnCancel = ViewBindings.findChildViewById(rootView, id);
      if (btnCancel == null) {
        break missingId;
      }

      id = R.id.btn_ok;
      AppCompatButton btnOk = ViewBindings.findChildViewById(rootView, id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.tv_message;
      AppCompatTextView tvMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvMessage == null) {
        break missingId;
      }

      id = R.id.v_divider;
      View vDivider = ViewBindings.findChildViewById(rootView, id);
      if (vDivider == null) {
        break missingId;
      }

      return new DialogBasic2Binding((CardView) rootView, btnCancel, btnOk, tvMessage, vDivider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
