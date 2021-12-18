package com.findajob.jobamax.training.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.FragmentLiveRoomParticipantsBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.util.toast

class LiveRoomParticipantsFragment : BaseFragmentMain<FragmentLiveRoomParticipantsBinding>(),
    LiveRoomParticipantHandler {

    private lateinit var participantAdapter: ParticipantAdapter
    lateinit var liveRoomViewModel: ManageRoomViewModel

    override val layoutRes: Int
        get() = R.layout.fragment_live_room_participants

    override fun onCreated(savedInstance: Bundle?) {
        liveRoomViewModel =
            ViewModelProvider(requireActivity()).get(ManageRoomViewModel::class.java)
        initView()
        initObserver()
    }


    private fun initView() {
        binding.handler = this
        progressHud.show()
        liveRoomViewModel.loadRoom()
        participantAdapter = ParticipantAdapter(requireActivity())
        binding.rvParticpants.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = participantAdapter
        }
    }

    private fun initObserver() {
        progressHud.dismiss()
        liveRoomViewModel.apply {
            observe(membersLiveData) {
                if (it != null) {
                    participantAdapter.collection = it
                } else {
                    toast("The participant list could not be retrieved ")
                    findNavController().navigateUp()
                }
            }

        }
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }

    override fun getViewModel(): BaseViewModel? = null
}