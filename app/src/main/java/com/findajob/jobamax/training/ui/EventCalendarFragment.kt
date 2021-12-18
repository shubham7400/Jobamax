package com.findajob.jobamax.training.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.databinding.FragmentEventCalendarBinding
import com.findajob.jobamax.dialog.AddEventDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.util.startOfDay
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import com.parse.ParseUser
import java.util.*


class EventCalendarFragment : BaseFragment(), EventCalendarHandler {

    lateinit var binding: FragmentEventCalendarBinding

    lateinit var viewModel: ManageRoomViewModel

    lateinit var todayEventAdapter: EventAdapter
    lateinit var upcomingEventAdapter: EventAdapter

    var currentlySelectedDate: Date = Date().startOfDay()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ManageRoomViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.handler = this
        initViews()
        initObservers()
    }


    private fun initViews() {

        progressHud.show()

        binding.apply {
            rvTodayEvents.apply {
                todayEventAdapter = EventAdapter()
                adapter = todayEventAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            rvUpcomingEvents.apply {
                upcomingEventAdapter = EventAdapter()
                adapter = upcomingEventAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }


            ivAddButton.setOnClickListener {
                saveEvent()
            }


        }
    }


    private fun getOrganiser(): ParseObject {

        // for now creates a new user object, just to set it to the organiser
        val user =
            ParseObject.createWithoutData("_User", ParseUser.getCurrentUser().objectId)
        user.put("firstName", ParseUser.getCurrentUser().username)

        return user
    }


    private fun saveEvent() {
        val organiser = getOrganiser()

        val selectedRoom = viewModel.selectedRoom

        AddEventDialog(requireActivity(), organiser, selectedRoom) { event ->

            progressHud.show()

            viewModel.apply {

                addEvent(event)
                observe(eventSuccessListener) { isSuccessful ->

                    refreshList()

                    progressHud.dismiss()

                    isSuccessful?.let {
                        if (isSuccessful) {
                            toast("Event has been saved.")
                        } else {
                            toast("Event could not be saved.")
                        }
                    }
                }
            }
        }.show()

    }


    private fun refreshList() {
        viewModel.apply {

            progressHud.show()

            getSelectedDateEvents(currentlySelectedDate)

            getUpcomingEvents(currentlySelectedDate)
        }
    }


    private fun initObservers() {
        viewModel.apply {


            getSelectedDateEvents(currentlySelectedDate)
            observe(todayEvents) { todayEvents ->
                progressHud.dismiss()
                if (todayEvents != null) {
                    todayEventAdapter.differ.submitList(todayEvents)
                }
            }


            getUpcomingEvents(currentlySelectedDate)
            observe(upcomingEvents) { upcomingEvents ->
                progressHud.dismiss()
                if (upcomingEvents != null) {
                    upcomingEventAdapter.differ.submitList(upcomingEvents)
                }
            }


        }
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }
}