package com.jobamax.appjobamax.cropper;

import java.lang.System;

/**
 * Built-in activity for image cropping.<br></br>
 * Use [CropImage.activity] to create a builder to start this activity.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J*\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0015\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\"\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0015J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0012\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\r2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0016J+\u0010.\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00192\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0011002\u0006\u00101\u001a\u000202H\u0016\u00a2\u0006\u0002\u00103J(\u00104\u001a\u00020\r2\u0006\u0010\'\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0016J\b\u00105\u001a\u00020\rH\u0014J\b\u00106\u001a\u00020\rH\u0014J\u0010\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0019H\u0004J*\u00109\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0015\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\b\u0010:\u001a\u00020\rH\u0002J \u0010;\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0019H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006>"}, d2 = {"Lcom/jobamax/appjobamax/cropper/CropImageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/jobamax/appjobamax/cropper/CropImageView$OnSetImageUriCompleteListener;", "Lcom/jobamax/appjobamax/cropper/CropImageView$OnCropImageCompleteListener;", "()V", "mCropImageUri", "Landroid/net/Uri;", "mOptions", "Lcom/jobamax/appjobamax/cropper/CropImageOptions;", "outputUri", "getOutputUri", "()Landroid/net/Uri;", "cropImage", "", "getPhotoFile", "Ljava/io/File;", "fileName", "", "getResultIntent", "Landroid/content/Intent;", "uri", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "sampleSize", "", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onCropImageComplete", "view", "Lcom/jobamax/appjobamax/cropper/CropImageView;", "result", "Lcom/jobamax/appjobamax/cropper/CropImageView$CropResult;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSetImageUriComplete", "onStart", "onStop", "rotateImage", "degrees", "setResult", "setResultCancel", "updateMenuItemIconColor", "itemId", "color", "app_release"})
public class CropImageActivity extends androidx.appcompat.app.AppCompatActivity implements com.jobamax.appjobamax.cropper.CropImageView.OnSetImageUriCompleteListener, com.jobamax.appjobamax.cropper.CropImageView.OnCropImageCompleteListener {
    
    /**
     * Persist URI image to crop URI if specific permissions are required
     */
    private android.net.Uri mCropImageUri;
    
    /**
     * the options that were set for the crop image
     */
    private com.jobamax.appjobamax.cropper.CropImageOptions mOptions;
    private java.util.HashMap _$_findViewCache;
    
    public CropImageActivity() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.io.File getPhotoFile(java.lang.String fileName) {
        return null;
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @android.annotation.SuppressLint(value = {"NewApi"})
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onSetImageUriComplete(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.cropper.CropImageView view, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.Exception error) {
    }
    
    @java.lang.Override()
    public void onCropImageComplete(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.cropper.CropImageView view, @org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.cropper.CropImageView.CropResult result) {
    }
    
    /**
     * Execute crop image and save the result tou output uri.
     */
    protected final void cropImage() {
    }
    
    /**
     * Rotate the image in the crop image view.
     */
    protected final void rotateImage(int degrees) {
    }
    
    private final android.net.Uri getOutputUri() {
        return null;
    }
    
    /**
     * Result with cropped image data or error if failed.
     */
    protected final void setResult(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.Exception error, int sampleSize) {
    }
    
    /**
     * Cancel of cropping activity.
     */
    private final void setResultCancel() {
    }
    
    /**
     * Get intent instance to be used for the result of this activity.
     */
    @org.jetbrains.annotations.NotNull()
    protected final android.content.Intent getResultIntent(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.Exception error, int sampleSize) {
        return null;
    }
    
    /**
     * Update the color of a specific menu item to the given color.
     */
    private final void updateMenuItemIconColor(android.view.Menu menu, int itemId, int color) {
    }
}