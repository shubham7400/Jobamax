package com.findajob.jobamax

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityLicenseBinding
import com.findajob.jobamax.util.setUp
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