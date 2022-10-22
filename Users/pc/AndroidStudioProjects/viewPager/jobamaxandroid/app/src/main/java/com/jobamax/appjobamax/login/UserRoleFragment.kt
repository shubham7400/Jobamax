package com.jobamax.appjobamax.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentUserRoleBinding
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER


class UserRoleFragment : Fragment() {
    lateinit var binding: FragmentUserRoleBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUserRoleBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        val args = requireActivity().intent.extras
        user = args?.getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnRecruiter.setOnClickListener{
            if (user != null){
                user!!.userType  = 1
            }else{
                user = UserTempInfo().also { it.userType = 1 }
            }
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate( R.id.action_userRoleFragment_to_userLoginFragment, args)
        }
        binding.btnJobSeeker.setOnClickListener{
            if (user != null){
                user!!.userType  = 2
            }else{
                user = UserTempInfo().also { it.userType = 2 }
            }
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(R.id.action_userRoleFragment_to_loginRegistrationOptionFragment,args)
        }
    }

}