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

public final class HomeTabBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView navIcon;

  @NonNull
  public final TextView navLabel;

  @NonNull
  public final LinearLayout navTab;

  private HomeTabBinding(@NonNull LinearLayout rootView, @NonNull ImageView navIcon,
      @NonNull TextView navLabel, @NonNull LinearLayout navTab) {
    this.rootView = rootView;
    this.navIcon = navIcon;
    this.navLabel = navLabel;
    this.navTab = navTab;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static HomeTabBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HomeTabBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.home_tab, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HomeTabBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.nav_icon;
      ImageView navIcon = ViewBindings.findChildViewById(rootView, id);
      if (navIcon == null) {
        break missingId;
      }

      id = R.id.nav_label;
      TextView navLabel = ViewBindings.findChildViewById(rootView, id);
      if (navLabel == null) {
        break missingId;
      }

      LinearLayout navTab = (LinearLayout) rootView;

      return new HomeTabBinding((LinearLayout) rootView, navIcon, navLabel, navTab);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
