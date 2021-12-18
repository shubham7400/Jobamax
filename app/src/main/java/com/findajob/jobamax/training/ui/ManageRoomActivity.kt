package com.findajob.jobamax.training.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivityManageRoomBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ManageRoomActivity : TrainingBaseActivity() {

    lateinit var binding: ActivityManageRoomBinding
    val viewModel: ManageRoomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_room)
    }

    override fun initUIandEvent() {

    }

    override fun deInitUIandEvent() {}


}

interface ManageRoomInterface {

    fun onBackButtonClicked()

    fun startRoom()

}