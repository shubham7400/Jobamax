package com.findajob.jobamax.recruiter.profile.jobOffer.location

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentLocationPermissionBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.login.LoginActivity
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.preference.getUserType
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.findajob.jobamax.util.*

class LocationPermissionFragment : Fragment(), LocationPermissionInterface {

    lateinit var binding: FragmentLocationPermissionBinding
    lateinit var navController: NavController
    var action: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        action = arguments?.getString(ARG_ACTION, "") ?: ""
        log("arg_action: $action")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLocationPermissionBinding.inflate(inflater, container, false)
        binding.handler = this
        binding.lifecycleOwner = viewLifecycleOwner

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding.root
    }

    override fun onAllowLocationClicked() {
        // From Android 11, if any permission is denied two times, it will be count as permanently denied.
        // To resolve this, use 3rd party lib Dexter to manage the permission stuff which detects if any permission is denied permanently.
        this.context?.manageLocationPermission(
            {
                when (action) {
                    ACTION_REGISTER -> navController.navigate(R.id.keepMePostedFragment)
                    ACTION_LOGIN -> {
                        startActivity(
                            Intent(
                                requireActivity(),
                                if (requireActivity().getUserType() == 2) JobSeekerHomeActivity::class.java else RecruiterHomeActivity::class.java
                            )
                        )
                        requireActivity().finishAffinity()
                    }
                    else -> {
                        (requireActivity() as LoginActivity).navLocationPicker()
                        navController.popBackStack()
                    }
                }
            },
            {
                toast("All permissions request must be granted to access this application")
            },
            {
                toast("Grant permission manually from app settings")
                this.context?.openAppSettings()
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }


    override fun onTellMeMoreClicked() {
        navController.navigate(
            R.id.action_locationPermissionFragment_to_meetPeopleNearbyFragment,
            bundleOf(ARG_ACTION to action)
        )
    }

}