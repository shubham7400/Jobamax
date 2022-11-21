package com.jobamax.appjobamax.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.location.Geocoder;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.model.JobSeeker;
import com.parse.ParseFile;
import com.parse.SaveCallback;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0007\u001a\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u001e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b\u001a \u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u0001\u001a>\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0%\u001a\u0012\u0010\'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020+\u001a\u0012\u0010\'\u001a\u00020(*\u00020,2\u0006\u0010*\u001a\u00020+\u001a\f\u0010-\u001a\u00020.*\u0004\u0018\u00010/\u001a\u0012\u00100\u001a\u00020\f*\u00020)2\u0006\u00101\u001a\u00020\u0007\u001a\u0012\u00100\u001a\u00020\f*\u00020,2\u0006\u00101\u001a\u00020\u0007\u00a8\u00062"}, d2 = {"calculateCompleteProfile", "", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "changeColorOfSubString", "Landroid/text/SpannableString;", "msg", "", "startIndex", "endIndex", "colorCode", "changeDrawableColor", "", "tag", "Landroid/view/View;", "backgroundColor", "convertAudioToByteArray", "", "path", "convertMillisToMinuteAndSecond", "millis", "", "getAddressByLatLng", "lat", "", "lng", "requireContext", "Landroid/content/Context;", "loadImageFromUrl", "imageView", "Landroid/widget/ImageView;", "url", "defaultImage", "uploadImageToParse", "uri", "Landroid/net/Uri;", "onException", "Lkotlin/Function1;", "onSuccess", "getShader", "Landroid/graphics/LinearGradient;", "Landroid/app/Activity;", "textView", "Landroid/widget/TextView;", "Landroidx/fragment/app/Fragment;", "isValidEmail", "", "", "openLink", "link", "app_debug"})
public final class HelperUtilKt {
    
    @org.jetbrains.annotations.Nullable()
    public static final byte[] convertAudioToByteArray(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String convertMillisToMinuteAndSecond(long millis) {
        return null;
    }
    
    public static final void loadImageFromUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String url, int defaultImage) {
    }
    
    public static final void uploadImageToParse(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onException, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getAddressByLatLng(double lat, double lng, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.LinearGradient getShader(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$getShader, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.LinearGradient getShader(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$getShader, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView) {
        return null;
    }
    
    public static final boolean isValidEmail(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence $this$isValidEmail) {
        return false;
    }
    
    public static final void changeDrawableColor(@org.jetbrains.annotations.NotNull()
    android.view.View tag, int backgroundColor) {
    }
    
    public static final void openLink(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$openLink, @org.jetbrains.annotations.NotNull()
    java.lang.String link) {
    }
    
    public static final void openLink(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$openLink, @org.jetbrains.annotations.NotNull()
    java.lang.String link) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.text.SpannableString changeColorOfSubString(@org.jetbrains.annotations.NotNull()
    java.lang.String msg, int startIndex, int endIndex, int colorCode) {
        return null;
    }
    
    public static final int calculateCompleteProfile(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.JobSeeker jobSeeker) {
        return 0;
    }
}