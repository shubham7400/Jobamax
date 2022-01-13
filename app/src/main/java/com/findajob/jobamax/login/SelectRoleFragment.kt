package com.findajob.jobamax.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentSelectRoleBinding
import com.findajob.jobamax.preference.setLoginType
import com.findajob.jobamax.preference.setUserFullName
import com.findajob.jobamax.preference.setUserType
import com.findajob.jobamax.util.ROLE_JOB_SEEKER
import com.findajob.jobamax.util.ROLE_RECRUITER
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SelectRoleFragment : Fragment(), SelectRoleInterface {
	
	lateinit var binding: FragmentSelectRoleBinding
	lateinit var navController: NavController
	lateinit var viewModel: LoginViewModel
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentSelectRoleBinding.inflate(inflater, container, false)
		binding.handler = this
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		navController = Navigation.findNavController(view)
	}
	
	override fun onJobSeekerClicked() {
		requireContext().setUserType(2)
		binding.seekerIcon.setImageResource(R.drawable.ic_job_seeker_blue)
		viewModel.roleType = ROLE_JOB_SEEKER
		doAsync {
			Thread.sleep(100)
			uiThread {
				/*navController.navigate(R.id.action_selectRoleFragment_to_jobSeekerLoginFragment)*/
			}
		}
	}
	
	override fun onRecruiterClicked() {
		requireContext().setUserType(1)
		binding.recruiterIcon.setImageResource(R.drawable.ic_recruiter)
		viewModel.roleType = ROLE_RECRUITER
		doAsync {
			Thread.sleep(100)
			uiThread {
				/*navController.navigate(R.id.action_selectRoleFragment_to_jobSeekerLoginFragment)*/
			}
		}
	}
}

interface SelectRoleInterface {
	fun onJobSeekerClicked()
	
	fun onRecruiterClicked()
}