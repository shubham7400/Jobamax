package com.jobamax.appjobamax

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.base.BaseActivityMain
import com.jobamax.appjobamax.databinding.ActivityPrivacyPreferenceBinding
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.util.setUp
import kotlinx.android.synthetic.main.activity_privacy_preference.*

class PrivacyPreferenceActivity : BaseActivityMain<ActivityPrivacyPreferenceBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_privacy_preference

    override fun getViewModel(): ViewModel? = null

    override fun onCreated(instance: Bundle?) {
        initViews()
    }

    private fun initViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.setUp("Privacy Preference Center")

        marketingPermissionSwitch.isChecked = getMarketingCheck()
        allowAdvertisingSwitch.isChecked = getAdvertisingCheck()
        socialMediaSwitch.isChecked = getSocialMediaCheck()

        allowButton.setOnClickListener {
            toggleSwitch(true)
        }

        refuseButton.setOnClickListener {
            toggleSwitch(false)
        }
    }


    private fun toggleSwitch(flag: Boolean) {
        marketingPermissionSwitch.isChecked = flag
        allowAdvertisingSwitch.isChecked = flag
        socialMediaSwitch.isChecked = flag
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        super.onStop()
        setMarketingCheck(marketingPermissionSwitch.isChecked)
        setAdvertisingCheck(allowAdvertisingSwitch.isChecked)
        setSocialMediaCheck(socialMediaSwitch.isChecked)
    }

}