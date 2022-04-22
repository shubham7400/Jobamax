package com.findajob.jobamax.login

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentLocationPermissionBinding
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.model.UserTempInfo
import com.findajob.jobamax.util.*

class LocationPermissionFragment : Fragment(), LocationPermissionInterface {

    lateinit var binding: FragmentLocationPermissionBinding
    lateinit var navController: NavController
    var action: String = ""
    var user : UserTempInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        action = arguments?.getString(ARG_ACTION, "") ?: ""
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
            when (action) {
                ACTION_REGISTER -> {
                    user?.let {
                        if (user!!.loginType != LoginType.EMAIL.type)
                        (requireActivity() as LoginActivity).isEmailAlreadyRegistered(it) {
                            (requireActivity() as LoginActivity).getUserLogin(user!!)
                        }else{
                            navController.navigate(R.id.keepMePostedFragment, bundleOf(ARG_USER to user))
                        }
                    }
                }
                ACTION_LOGIN -> {
                    startActivity(Intent(requireActivity(), JobSeekerHomeActivity::class.java))
                    requireActivity().finishAffinity()
                }
                else -> {}
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_ALL_PERMISSIONS){
            binding.btnAllowLocation.performClick()
        }
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


interface LocationPermissionInterface {

    fun onAllowLocationClicked()

    fun onTellMeMoreClicked()
}