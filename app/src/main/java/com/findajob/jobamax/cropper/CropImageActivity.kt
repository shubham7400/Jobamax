package com.findajob.jobamax.cropper

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.findajob.jobamax.R
import com.findajob.jobamax.util.log
import kotlinx.android.synthetic.main.crop_image_activity.*
import java.io.File
import java.io.IOException

private lateinit var photoFile: File
private const val SCANNED_FILE_NAME = "readmore_cache_"

/**
 * Built-in activity for image cropping.<br></br>
 * Use [CropImage.activity] to create a builder to start this activity.
 */

open class CropImageActivity : AppCompatActivity(), CropImageView.OnSetImageUriCompleteListener,
    CropImageView.OnCropImageCompleteListener {

    /**
     * Persist URI image to crop URI if specific permissions are required
     */
    private var mCropImageUri: Uri? = null

    /**
     * the options that were set for the crop image
     */
    private var mOptions: CropImageOptions? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crop_image_activity)
        val bundle = intent.getBundleExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE)
        mCropImageUri = bundle!!.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE)
        mOptions = bundle.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS)
        photoFile = getPhotoFile(SCANNED_FILE_NAME)
        if (savedInstanceState == null) {
            if (mCropImageUri == null || mCropImageUri == Uri.EMPTY) {
                if (CropImage.isExplicitCameraPermissionRequired(this)) {
                    // request permissions and handle the result in onRequestPermissionsResult()
                    requestPermissions(
                        arrayOf(Manifest.permission.CAMERA),
                        CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE
                    )
                } else {
                    CropImage.startPickImageActivity(this, photoFile)
                }
            } else if (CropImage.isReadExternalStoragePermissionsRequired(this, mCropImageUri!!)) {
                // request permissions and handle the result in onRequestPermissionsResult()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE
                    )
                }
            } else {
                // no permissions required or already grunted, can start crop image activity
                cropImageView.setImageUriAsync(mCropImageUri)
            }
        }
        val actionBar = supportActionBar
        if (actionBar != null) {
            val title =
                if (mOptions != null && mOptions!!.activityTitle != null && mOptions!!.activityTitle.length > 0
                ) mOptions!!.activityTitle else ""
            actionBar.title = title
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun getPhotoFile(fileName: String): File {
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDir)
    }

    override fun onStart() {
        super.onStart()
        cropImageView.setOnSetImageUriCompleteListener(this)
        cropImageView.setOnCropImageCompleteListener(this)
    }

    override fun onStop() {
        super.onStop()
        cropImageView.setOnSetImageUriCompleteListener(null)
        cropImageView.setOnCropImageCompleteListener(null)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.crop_image_menu, menu)
        if (!mOptions!!.allowRotation) {
            menu.removeItem(R.id.crop_image_menu_rotate_left)
            menu.removeItem(R.id.crop_image_menu_rotate_right)
        } else if (mOptions!!.allowCounterRotation) {
            menu.findItem(R.id.crop_image_menu_rotate_left).isVisible = true
        }
        if (!mOptions!!.allowFlipping) {
            menu.removeItem(R.id.crop_image_menu_flip)
        }
        if (mOptions!!.cropMenuCropButtonTitle != null) {
            menu.findItem(R.id.crop_image_menu_crop).title = mOptions!!.cropMenuCropButtonTitle
        }
        var cropIcon: Drawable? = null
        try {
            if (mOptions!!.cropMenuCropButtonIcon != 0) {
                cropIcon = ContextCompat.getDrawable(this, mOptions!!.cropMenuCropButtonIcon)
                menu.findItem(R.id.crop_image_menu_crop).icon = cropIcon
            }
        } catch (e: Exception) {
            Log.w("AIC", "Failed to read menu crop drawable", e)
        }
        if (mOptions!!.activityMenuIconColor != 0) {
            updateMenuItemIconColor(
                menu,
                R.id.crop_image_menu_rotate_left,
                mOptions!!.activityMenuIconColor
            )
            updateMenuItemIconColor(
                menu,
                R.id.crop_image_menu_rotate_right,
                mOptions!!.activityMenuIconColor
            )
            updateMenuItemIconColor(
                menu,
                R.id.crop_image_menu_flip,
                mOptions!!.activityMenuIconColor
            )
            if (cropIcon != null) {
                updateMenuItemIconColor(
                    menu,
                    R.id.crop_image_menu_crop,
                    mOptions!!.activityMenuIconColor
                )
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.crop_image_menu_crop) {
            cropImage()
            return true
        }
        if (item.itemId == R.id.crop_image_menu_rotate_left) {
            rotateImage(-mOptions!!.rotationDegrees)
            return true
        }
        if (item.itemId == R.id.crop_image_menu_rotate_right) {
            rotateImage(mOptions!!.rotationDegrees)
            return true
        }
        if (item.itemId == R.id.crop_image_menu_flip_horizontally) {
            cropImageView.flipImageHorizontally()
            return true
        }
        if (item.itemId == R.id.crop_image_menu_flip_vertically) {
            cropImageView.flipImageVertically()
            return true
        }
        if (item.itemId == android.R.id.home) {
            setResultCancel()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResultCancel()
    }

    @SuppressLint("NewApi")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // handle result of pick image chooser
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_CANCELED) {
                // User cancelled the picker. We don't have anything to crop
                setResultCancel()
            }
            if (resultCode == Activity.RESULT_OK) {

                //Bitmap takenImage = (Bitmap) data.getExtras().get("data");
                //Uri imageUri = CropImage.getPickImageResultUri(this, data);

                if (photoFile.exists()) {
                    log("PhotoFile Exists")
                } else log("PhotoFile Doesn't Exists")

                log("intent ka data: " + data?.data?.toString())
                if (data?.data == null)
                    mCropImageUri = FileProvider.getUriForFile(
                        this,
                        "com.applligent.jobamax.provider",
                        photoFile
                    )
                else mCropImageUri = data.data
                //mCropImageUri = CropImage.getPickImageResultUri(this, data)
                log("mCropImageUri: " + mCropImageUri.toString())
                log("photoFile: " + photoFile.toPath())
                if (CropImage.isReadExternalStoragePermissionsRequired(this, mCropImageUri!!)) {
                    // request permissions and handle the result in onRequestPermissionsResult()
                    requestPermissions(
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE
                    )
                } else {
                    // no permissions required or already grunted, can start crop image activity
                    cropImageView.setImageUriAsync(mCropImageUri)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE) {
            if (mCropImageUri != null && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                // required permissions granted, start crop image activity
                cropImageView.setImageUriAsync(mCropImageUri)
            } else {
                Toast.makeText(this, R.string.crop_image_activity_no_permissions, Toast.LENGTH_LONG)
                    .show()
                setResultCancel()
            }
        }
        if (requestCode == CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE) {
            // Irrespective of whether camera permission was given or not, we show the picker
            // The picker will not add the camera intent if permission is not available
            CropImage.startPickImageActivity(this, photoFile)
        }
    }

    override fun onSetImageUriComplete(view: CropImageView, uri: Uri, error: Exception?) {
        log("onSetImageUriComplete() error: " + error?.message)
        if (error == null) {
            if (mOptions!!.initialCropWindowRectangle != null) {
                cropImageView.cropRect = mOptions!!.initialCropWindowRectangle
            }
            if (mOptions!!.initialRotation > -1) {
                cropImageView.rotatedDegrees = mOptions!!.initialRotation
            }
        } else {
            setResult(null, error, 1)
        }
    }

    override fun onCropImageComplete(view: CropImageView, result: CropImageView.CropResult) {
        log("onCropImageComplete() error: " + result.error?.message)
        setResult(result.uri, result.error, result.sampleSize)
    }
    // region: Private methods
    /**
     * Execute crop image and save the result tou output uri.
     */
    protected fun cropImage() {
        if (mOptions!!.noOutputImage) {
            setResult(null, null, 1)
        } else {
            val outputUri = outputUri
            cropImageView.saveCroppedImageAsync(
                outputUri,
                mOptions!!.outputCompressFormat,
                mOptions!!.outputCompressQuality,
                mOptions!!.outputRequestWidth,
                mOptions!!.outputRequestHeight,
                mOptions!!.outputRequestSizeOptions
            )
        }
    }

    /**
     * Rotate the image in the crop image view.
     */
    protected fun rotateImage(degrees: Int) {
        cropImageView.rotateImage(degrees)
    }

    /**
     * Get Android uri to save the cropped image into.<br></br>
     * Use the given in options or create a temp file.
     */
    private val outputUri: Uri?
        get() {
            var outputUri = mOptions!!.outputUri
            if (outputUri == null || outputUri == Uri.EMPTY) {
                outputUri = try {
                    val ext =
                        if (mOptions!!.outputCompressFormat == Bitmap.CompressFormat.JPEG) ".jpg" else if (mOptions!!.outputCompressFormat == Bitmap.CompressFormat.PNG) ".png" else ".webp"
                    Uri.fromFile(File.createTempFile("cropped", ext, cacheDir))
                } catch (e: IOException) {
                    throw RuntimeException("Failed to create temp file for output image", e)
                }
            }
            return outputUri
        }

    /**
     * Result with cropped image data or error if failed.
     */
    protected fun setResult(uri: Uri?, error: Exception?, sampleSize: Int) {
        log("setResult(): " + error?.message)
        val resultCode =
            if (error == null) Activity.RESULT_OK else CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE
        setResult(resultCode, getResultIntent(uri, error, sampleSize))
        //TODO: photoFile.delete()
        finish()
    }

    /**
     * Cancel of cropping activity.
     */
    private fun setResultCancel() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    /**
     * Get intent instance to be used for the result of this activity.
     */
    protected fun getResultIntent(uri: Uri?, error: Exception?, sampleSize: Int): Intent {
        val result = CropImage.ActivityResult(
            cropImageView.imageUri,
            uri,
            error,
            cropImageView.cropPoints,
            cropImageView.cropRect,
            cropImageView.rotatedDegrees,
            cropImageView.wholeImageRect,
            sampleSize
        )
        val intent = Intent()
        intent.putExtras(getIntent())
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_RESULT, result)
        return intent
    }

    /**
     * Update the color of a specific menu item to the given color.
     */
    private fun updateMenuItemIconColor(menu: Menu, itemId: Int, color: Int) {
        val menuItem = menu.findItem(itemId)
        if (menuItem != null) {
            val menuItemIcon = menuItem.icon
            if (menuItemIcon != null) {
                try {
                    menuItemIcon.mutate()
                    menuItemIcon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                    menuItem.icon = menuItemIcon
                } catch (e: Exception) {
                    log( "Failed to update menu item color")
                }
            }
        }
    } // endregion
}