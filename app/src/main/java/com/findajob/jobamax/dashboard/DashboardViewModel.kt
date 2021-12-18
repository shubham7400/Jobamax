package com.findajob.jobamax.dashboard

import android.app.Application
import android.view.MenuItem
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findajob.jobamax.base.BaseAndroidViewModel

class DashboardViewModel(val context: Application) : BaseAndroidViewModel(context) {


    val navItemId = MutableLiveData<Int>()

    var pageSelected = MutableLiveData(0)

    var currentPage = MutableLiveData<Int>()
    var offscreenPageLimit: Int = 0

    fun onPageSelected(position: Int) {
        pageSelected.value = position
    }

    fun onNavigationClick(item: MenuItem): Boolean {
        navItemId.value = item.itemId
        return true
    }

}