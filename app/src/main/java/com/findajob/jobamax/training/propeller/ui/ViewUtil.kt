package com.findajob.jobamax.training.propeller.ui

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.SystemClock
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import org.slf4j.LoggerFactory

object ViewUtil {
	internal const val DEBUG_ENABLED = false
	private val log = LoggerFactory.getLogger(ViewUtil::class.java)
	private const val DEFAULT_TOUCH_TIMESTAMP = -1 // first time
	private const val TOUCH_COOL_DOWN_TIME = 500 // ms
	private var mLastTouchTime = DEFAULT_TOUCH_TIMESTAMP.toLong()

	/* package */
	fun checkDoubleTouchEvent(event: MotionEvent, view: View): Boolean {
		if (DEBUG_ENABLED) {
			log.debug("dispatchTouchEvent $mLastTouchTime $event")
		}
		if (event.action == MotionEvent.ACTION_DOWN) { // only check touch down event
			if (mLastTouchTime == DEFAULT_TOUCH_TIMESTAMP.toLong() || SystemClock.elapsedRealtime() - mLastTouchTime >= TOUCH_COOL_DOWN_TIME) {
				mLastTouchTime = SystemClock.elapsedRealtime()
			} else {
				log.warn("too many touch events " + view + " " + MotionEvent.ACTION_DOWN)
				return true
			}
		}
		return false
	}

	/* package */
	fun checkDoubleKeyEvent(event: KeyEvent, view: View): Boolean {
		if (DEBUG_ENABLED) {
			log.debug("dispatchKeyEvent $mLastTouchTime $event")
		}
		if (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER) {
			if (mLastTouchTime != DEFAULT_TOUCH_TIMESTAMP.toLong() && SystemClock.elapsedRealtime() - mLastTouchTime < TOUCH_COOL_DOWN_TIME) {
				log.warn("too many key events " + view + " " + KeyEvent.ACTION_DOWN)
				return true
			}
			mLastTouchTime = SystemClock.elapsedRealtime()
		}
		return false
	}

	fun setBackground(view: View, drawable: Drawable?) {
		view.background = drawable
	}
}