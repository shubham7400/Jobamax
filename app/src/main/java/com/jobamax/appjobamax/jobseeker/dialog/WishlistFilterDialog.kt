package com.jobamax.appjobamax.jobseeker.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishlistFragment
import kotlinx.android.synthetic.main.dailog_wishlist_filter.*

class WishlistFilterDialog(var activity: Activity, val appliedFilter: Int) : Dialog(activity) {
    var onFilterOptionClick: (Int) -> Unit = {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()
        when(appliedFilter){
            SeekerWishlistFragment.WishlistJobFilter.All.value -> { cb_all.isChecked = true }
            SeekerWishlistFragment.WishlistJobFilter.ARCHIVE.value -> { cb_archive.isChecked = true }
            SeekerWishlistFragment.WishlistJobFilter.TO_DO.value -> { cb_done.isChecked = true }
            SeekerWishlistFragment.WishlistJobFilter.PROGRESS.value -> { cb_in_progress.isChecked = true }
        }
    }

    private fun setUpObservers() {
        iv_arrow_down.setOnClickListener { dismiss() }
        cb_all.setOnCheckedChangeListener { _, isChecked ->
            cb_archive.isChecked = false
            cb_done.isChecked = false
            cb_in_progress.isChecked = false
            if (isChecked){ onFilterOptionClick(SeekerWishlistFragment.WishlistJobFilter.All.value) }
            dismiss()
        }
        cb_archive.setOnCheckedChangeListener { _, isChecked ->
            cb_all.isChecked = false
            cb_done.isChecked = false
            cb_in_progress.isChecked = false
            if (isChecked){ onFilterOptionClick(SeekerWishlistFragment.WishlistJobFilter.ARCHIVE.value) }
            dismiss()
        }
        cb_done.setOnCheckedChangeListener { _, isChecked ->
            cb_archive.isChecked = false
            cb_all.isChecked = false
            cb_in_progress.isChecked = false
            if (isChecked){ onFilterOptionClick(SeekerWishlistFragment.WishlistJobFilter.TO_DO.value) }
            dismiss()
        }
        cb_in_progress.setOnCheckedChangeListener { _, isChecked ->
            cb_all.isChecked = false
            cb_done.isChecked = false
            cb_archive.isChecked = false
            if (isChecked){ onFilterOptionClick(SeekerWishlistFragment.WishlistJobFilter.PROGRESS.value) }
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dailog_wishlist_filter)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}