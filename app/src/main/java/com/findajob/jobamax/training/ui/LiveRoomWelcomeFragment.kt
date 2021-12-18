package com.findajob.jobamax.training.ui

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.FragmentLiveRoomWelcomeBinding
import com.findajob.jobamax.dialog.AddLinkedInDialog
import com.findajob.jobamax.dialog.RequirementsDialog
import com.findajob.jobamax.model.LiveRoom

class LiveRoomWelcomeFragment : BaseFragmentMain<FragmentLiveRoomWelcomeBinding>(),
    LiveRoomWelcomeInterface {

    lateinit var viewModel: ManageRoomViewModel
    lateinit var navController: NavController

    override val layoutRes: Int
        get() = R.layout.fragment_live_room_welcome

    override fun onCreated(savedInstance: Bundle?) {
        viewModel = ViewModelProvider(requireActivity()).get(ManageRoomViewModel::class.java)
        initViews()
        initObserver()

        // show linkedIn popup
        if (!viewModel.isLinkedInSaved()) {
            AddLinkedInDialog(
                requireActivity(),
            ) { button, username ->
                if (button == AddLinkedInDialog.SubmitButton.POSITIVE) {
                    val linkedIn = username.trim()
                    if (linkedIn.isNotEmpty()) {
                        viewModel.saveLinkedIn(linkedIn)
                    }
                }
            }.show()
        }
    }

    private fun initViews() {

        binding.handler = this
        navController = findNavController()

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })

        binding.cvRoom.setOnClickListener {
            navController.navigate(R.id.action_welcome_to_room)
        }

        binding.cvParticipants.setOnClickListener {
            navController.navigate(R.id.action_welcome_to_participants)
        }

        binding.cvCalendar.setOnClickListener {
            navController.navigate(R.id.action_welcome_event_calendar)
        }


    }

    private fun initObserver() {


        viewModel.apply {

            // set room name
            val room = LiveRoom(selectedRoom!!)
            val welcomeRoom = binding.tvWelcome.text.toString() + " " + room.name
            binding.tvWelcome.text = welcomeRoom
        }
    }

    override fun getViewModel(): ViewModel? = viewModel

    override fun onBackButtonClicked() {
        requireActivity().onBackPressed()
    }

    override fun onLeaveButtonClicked() {
        viewModel.leaveSavedRoom()
        navController.popBackStack()
    }
}