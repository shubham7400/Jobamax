package com.jobamax.appjobamax.jobseeker.delegation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.view.ViewAnimationUtils
import kotlin.math.hypot

interface CircularRevealViewAnimation {
    fun showViewAnimationFromLeft(view: View)
    fun hideViewAnimationFromLeft(view: View)
    fun showViewAnimationFromRight(view: View)
    fun hideViewAnimationFromRight(view: View)
}

class CircularRevealViewAnimationImpl : CircularRevealViewAnimation {
    override fun showViewAnimationFromLeft(view: View) {
        val endRadius = hypot(view.width.toDouble(), view.height.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(view, view.left, view.top, 0f, endRadius)
        anim.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                view.visibility = View.VISIBLE
            }
        })
        anim.start()
    }

    override fun hideViewAnimationFromLeft(view: View) {
        val startRadius = hypot(view.width.toDouble(), view.height.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(view, view.left, view.top, startRadius, 0f)
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                view.visibility = View.GONE
            }
        })
        anim.start()
    }

    override fun showViewAnimationFromRight(view: View) {
        val endRadius = hypot(view.width.toDouble(), view.height.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(view, view.right, view.top, 0f, endRadius)
        anim.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                view.visibility = View.VISIBLE
            }
        })
        anim.start()
    }

    override fun hideViewAnimationFromRight(view: View) {
        val startRadius = hypot(view.width.toDouble(), view.height.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(view, view.right, view.top, startRadius, 0f)
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                view.visibility = View.GONE
            }
        })
        anim.start()
    }

}