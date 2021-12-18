package com.findajob.jobamax.training.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentManageRoomBinding
import com.findajob.jobamax.dialog.CreateRoomDialog
import com.findajob.jobamax.model.LiveRoom
import com.findajob.jobamax.repo.SaveRoomCallback
import com.findajob.jobamax.util.errorToast
import com.parse.ParseObject
import kotlinx.android.synthetic.main.fragment_manage_room.*

class ManageRoomFragment : BaseFragment(), ManageRoomInterface {
	
	lateinit var viewModel: ManageRoomViewModel
	lateinit var binding: FragmentManageRoomBinding
	lateinit var roomAdapter: ManageRoomAdapter
	lateinit var navController: NavController
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewModel = ViewModelProvider(requireActivity()).get(ManageRoomViewModel::class.java)
		roomAdapter = ManageRoomAdapter {
			forwardToLiveRoom(it)
		}
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentManageRoomBinding.inflate(inflater, container, false)
		binding.handler = this
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		navController = Navigation.findNavController(view)
		progressHud.show()
		viewModel.loadRooms()
		subscribeObserver()
		rv_location_list.layoutManager = LinearLayoutManager(requireContext())
		rv_location_list.adapter = roomAdapter
	}
	
	
	fun subscribeObserver() {
		viewModel.getRoomObserver().observe(viewLifecycleOwner, {
			progressHud.dismiss()
			roomAdapter.notifyRoomChanged(it)
		})
	}
	
	override fun onBackButtonClicked() {
		requireActivity().onBackPressed()
	}
	
	override fun startRoom() {
		CreateRoomDialog(requireActivity(), viewModel.interestsList) { roomName, category ->
			if (!viewModel.roomList.map { LiveRoom(it).name }.contains(roomName)) {
				progressHud.show()
				viewModel.loadRooms()
				viewModel.saveRoom(roomName, category, object : SaveRoomCallback {
					override fun onFinish(isSuccessful: Boolean) {
						progressHud.dismiss()
						if (isSuccessful) {
							forwardToLiveRoom(viewModel.roomList.find { LiveRoom(it).name == roomName }!!)
						} else requireActivity().errorToast()
					}
				})
			} else forwardToLiveRoom(viewModel.roomList.find { LiveRoom(it).name == roomName }!!)
		}.show()
	}
	
	fun forwardToLiveRoom(room: ParseObject) {
		viewModel.selectedRoom = room
		navController.navigate(R.id.action_manage_room_to_welcome)
	}
}