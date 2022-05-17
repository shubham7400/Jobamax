package com.jobamax.appjobamax

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.base.BaseActivityMain
import com.jobamax.appjobamax.databinding.ActivityLicenseBinding
import com.jobamax.appjobamax.util.setUp
import kotlinx.android.synthetic.main.activity_license.*

class LicenseActivity : BaseActivityMain<ActivityLicenseBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_license

    override fun getViewModel(): ViewModel? = null

    override fun onCreated(instance: Bundle?) {
        setSupportActionBar(toolbar)
        supportActionBar?.setUp("Licenses")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }


}