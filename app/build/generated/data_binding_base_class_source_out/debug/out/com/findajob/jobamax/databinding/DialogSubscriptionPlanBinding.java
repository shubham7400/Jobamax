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

public final class DialogSubscriptionPlanBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView descriptionText;

  @NonNull
  public final Button okButton;

  @NonNull
  public final TextView priceText;

  @NonNull
  public final TextView titleText;

  private DialogSubscriptionPlanBinding(@NonNull CardView rootView,
      @NonNull TextView descriptionText, @NonNull Button okButton, @NonNull TextView priceText,
      @NonNull TextView titleText) {
    this.rootView = rootView;
    this.descriptionText = descriptionText;
    this.okButton = okButton;
    this.priceText = priceText;
    this.titleText = titleText;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogSubscriptionPlanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogSubscriptionPlanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_subscription_plan, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogSubscriptionPlanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.descriptionText;
      TextView descriptionText = ViewBindings.findChildViewById(rootView, id);
      if (descriptionText == null) {
        break missingId;
      }

      id = R.id.okButton;
      Button okButton = ViewBindings.findChildViewById(rootView, id);
      if (okButton == null) {
        break missingId;
      }

      id = R.id.priceText;
      TextView priceText = ViewBindings.findChildViewById(rootView, id);
      if (priceText == null) {
        break missingId;
      }

      id = R.id.titleText;
      TextView titleText = ViewBindings.findChildViewById(rootView, id);
      if (titleText == null) {
        break missingId;
      }

      return new DialogSubscriptionPlanBinding((CardView) rootView, descriptionText, okButton,
          priceText, titleText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}