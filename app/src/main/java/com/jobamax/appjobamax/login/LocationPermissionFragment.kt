package com.jobamax.appjobamax.login

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.jobamax.appjobamax.databinding.FragmentLocationPermissionBinding
import com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoActivity
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.*

class LocationPermissionFragment : Fragment(), LocationPermissionInterface {

    lateinit var binding: FragmentLocationPermissionBinding
    lateinit var navController: NavController
    var user : UserTempInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = arguments?.getSerializable(ARG_USER) as UserTempInfo
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
        if (checkForPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))) {
            startActivity(Intent(requireContext(), JobSeekerPersonalIntroInfoActivity::class.java).putExtra(ARG_USER, user))
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }


    override fun onTellMeMoreClicked() {

    }

}


interface LocationPermissionInterface {

    fun onAllowLocationClicked()

    fun onTellMeMoreClicked()
}