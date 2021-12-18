// Generated by view binder compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.findajob.jobamax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemExperienceBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView companyLabel;

  @NonNull
  public final ImageView deleteButton;

  @NonNull
  public final ImageView editButton;

  @NonNull
  public final TextView jobLabel;

  @NonNull
  public final LinearLayout llActionButton;

  @NonNull
  public final TextView locationLabel;

  @NonNull
  public final TextView timeLabel;

  private ItemExperienceBinding(@NonNull LinearLayout rootView, @NonNull TextView companyLabel,
      @NonNull ImageView deleteButton, @NonNull ImageView editButton, @NonNull TextView jobLabel,
      @NonNull LinearLayout llActionButton, @NonNull TextView locationLabel,
      @NonNull TextView timeLabel) {
    this.rootView = rootView;
    this.companyLabel = companyLabel;
    this.deleteButton = deleteButton;
    this.editButton = editButton;
    this.jobLabel = jobLabel;
    this.llActionButton = llActionButton;
    this.locationLabel = locationLabel;
    this.timeLabel = timeLabel;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemExperienceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_experience, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemExperienceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.companyLabel;
      TextView companyLabel = ViewBindings.findChildViewById(rootView, id);
      if (companyLabel == null) {
        break missingId;
      }

      id = R.id.deleteButton;
      ImageView deleteButton = ViewBindings.findChildViewById(rootView, id);
      if (deleteButton == null) {
        break missingId;
      }

      id = R.id.editButton;
      ImageView editButton = ViewBindings.findChildViewById(rootView, id);
      if (editButton == null) {
        break missingId;
      }

      id = R.id.jobLabel;
      TextView jobLabel = ViewBindings.findChildViewById(rootView, id);
      if (jobLabel == null) {
        break missingId;
      }

      id = R.id.ll_action_button;
      LinearLayout llActionButton = ViewBindings.findChildViewById(rootView, id);
      if (llActionButton == null) {
        break missingId;
      }

      id = R.id.locationLabel;
      TextView locationLabel = ViewBindings.findChildViewById(rootView, id);
      if (locationLabel == null) {
        break missingId;
      }

      id = R.id.timeLabel;
      TextView timeLabel = ViewBindings.findChildViewById(rootView, id);
      if (timeLabel == null) {
        break missingId;
      }

      return new ItemExperienceBinding((LinearLayout) rootView, companyLabel, deleteButton,
          editButton, jobLabel, llActionButton, locationLabel, timeLabel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
