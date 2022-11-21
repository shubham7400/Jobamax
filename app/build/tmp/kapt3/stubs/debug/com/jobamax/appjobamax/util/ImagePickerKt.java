package com.jobamax.appjobamax.util;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.FileProvider;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jobamax.appjobamax.R;
import id.zelory.compressor.Compressor;
import kotlinx.coroutines.Dispatchers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0004"}, d2 = {"IMAGE_PICKER_TYPE_CAMERA", "", "IMAGE_PICKER_TYPE_GALLERY", "IMAGE_PICKER_TYPE_NONE", "app_debug"})
public final class ImagePickerKt {
    public static final int IMAGE_PICKER_TYPE_GALLERY = 1;
    public static final int IMAGE_PICKER_TYPE_CAMERA = 2;
    public static final int IMAGE_PICKER_TYPE_NONE = 3;
}