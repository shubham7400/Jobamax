package com.findajob.jobamax.dashboard.home.training.masterclass

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityMasterClassBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MasterClassActivity : BaseActivityMain<ActivityMasterClassBinding>() {

    override val layoutRes: Int get() = R.layout.activity_master_class

    override fun getViewModel(): ViewModel? {
        return null
    }

    override fun onCreated(instance: Bundle?) {
        binding.lifecycleOwner = this
    }

}