package com.findajob.jobamax.training.propeller.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/findajob/jobamax/training/propeller/ui/ViewUtil;", "", "()V", "DEBUG_ENABLED", "", "DEFAULT_TOUCH_TIMESTAMP", "", "TOUCH_COOL_DOWN_TIME", "log", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "mLastTouchTime", "", "checkDoubleKeyEvent", "event", "Landroid/view/KeyEvent;", "view", "Landroid/view/View;", "checkDoubleTouchEvent", "Landroid/view/MotionEvent;", "setBackground", "", "drawable", "Landroid/graphics/drawable/Drawable;", "app_debug"})
public final class ViewUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.training.propeller.ui.ViewUtil INSTANCE = null;
    public static final boolean DEBUG_ENABLED = false;
    private static final org.slf4j.Logger log = null;
    private static final int DEFAULT_TOUCH_TIMESTAMP = -1;
    private static final int TOUCH_COOL_DOWN_TIME = 500;
    private static long mLastTouchTime = -1L;
    
    private ViewUtil() {
        super();
    }
    
    public final boolean checkDoubleTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
        return false;
    }
    
    public final boolean checkDoubleKeyEvent(@org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
        return false;
    }
    
    public final void setBackground(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable drawable) {
    }
}