package com.jobamax.appjobamax.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentMeetNearbyPeopleBinding
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeActivity
import com.jobamax.appjobamax.util.*


class MeetPeopleNearbyFragment : Fragment(), MeetPeopleNearbyInterface {

    lateinit var binding: FragmentMeetNearbyPeopleBinding
    lateinit var navController: NavController
    var action: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        action = arguments?.getString(ARG_ACTION, "") ?: ""
        log("arg_action: $action")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMeetNearbyPeopleBinding.inflate(inflater, container, false)
        binding.handler = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onAllowLocationClicked() {
        when (action) {
            ACTION_REGISTER -> navController.navigate(R.id.keepMePostedFragment)
            ACTION_LOGIN -> {
                startActivity(Intent(requireActivity(),JobSeekerHomeActivity::class.java))
                requireActivity().finishAffinity()
            }
            else -> {}
        }
    }

    override fun onTopupClicked() {
        /*navController.navigate(R.id.action_meetPeopleNearbyFragment_to_locationPermissionFragment)*/
    }
}

interface MeetPeopleNearbyInterface {
    fun onAllowLocationClicked()

    fun onTopupClicked()
}