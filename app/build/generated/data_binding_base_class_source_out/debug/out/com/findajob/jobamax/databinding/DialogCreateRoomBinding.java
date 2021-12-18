// Generated by view binder compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.findajob.jobamax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogCreateRoomBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button createRoomButton;

  @NonNull
  public final LinearLayout parentLayout;

  @NonNull
  public final EditText roomField;

  @NonNull
  public final Spinner spinnerCategory;

  private DialogCreateRoomBinding(@NonNull LinearLayout rootView, @NonNull Button createRoomButton,
      @NonNull LinearLayout parentLayout, @NonNull EditText roomField,
      @NonNull Spinner spinnerCategory) {
    this.rootView = rootView;
    this.createRoomButton = createRoomButton;
    this.parentLayout = parentLayout;
    this.roomField = roomField;
    this.spinnerCategory = spinnerCategory;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogCreateRoomBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogCreateRoomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_create_room, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogCreateRoomBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.createRoomButton;
      Button createRoomButton = ViewBindings.findChildViewById(rootView, id);
      if (createRoomButton == null) {
        break missingId;
      }

      LinearLayout parentLayout = (LinearLayout) rootView;

      id = R.id.roomField;
      EditText roomField = ViewBindings.findChildViewById(rootView, id);
      if (roomField == null) {
        break missingId;
      }

      id = R.id.spinnerCategory;
      Spinner spinnerCategory = ViewBindings.findChildViewById(rootView, id);
      if (spinnerCategory == null) {
        break missingId;
      }

      return new DialogCreateRoomBinding((LinearLayout) rootView, createRoomButton, parentLayout,
          roomField, spinnerCategory);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
