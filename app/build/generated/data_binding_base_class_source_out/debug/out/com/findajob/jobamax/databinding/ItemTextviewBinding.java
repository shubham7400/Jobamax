// Generated by view binder compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.findajob.jobamax.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ItemTextviewBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  private ItemTextviewBinding(@NonNull TextView rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemTextviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemTextviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_textview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemTextviewBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ItemTextviewBinding((TextView) rootView);
  }
}
