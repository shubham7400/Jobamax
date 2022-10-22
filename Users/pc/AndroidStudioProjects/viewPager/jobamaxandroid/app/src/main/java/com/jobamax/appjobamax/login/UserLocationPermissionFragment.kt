package com.jobamax.appjobamax.login

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentUserLocationPermissionBinding
import com.jobamax.appjobamax.databinding.FragmentUserRoleBinding
import com.jobamax.appjobamax.extensions.checkForPermissions
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER
import com.jobamax.appjobamax.util.permissions


class UserLocationPermissionFragment : Fragment() {
    lateinit var binding: FragmentUserLocationPermissionBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUserLocationPermissionBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnActivateLocation.setOnClickListener {
            if (checkForPermissions(permissions)){
                val args = Bundle()
                args.putSerializable(ARG_USER, user)
                findNavController().navigate( R.id.action_userLocationPermissionFragment_to_sendMessagePermissionFragment, args)
            }
        }
        binding.tvTellMeMore.setOnClickListener {
            if (binding.tvTellMeMore.isVisible){
                binding.llBtn.animate().setListener(object : Animator.AnimatorListener{
                    override fun onAnimationStart(p0: Animator) {}
                    override fun onAnimationEnd(p0: Animator) {
                        binding.clLogo.visibility = View.GONE
                        binding.tvTellMeMore.visibility = View.GONE
                        binding.llDes.visibility = View.VISIBLE
                        binding.ivCircleUp.visibility = View.VISIBLE
                    }
                    override fun onAnimationCancel(p0: Animator) {}
                    override fun onAnimationRepeat(p0: Animator) {}
                }).translationY(-(binding.llBtn.y - 100)).duration = 1000
            }
        }
        binding.ivCircleUp.setOnClickListener {
            if (!binding.tvTellMeMore.isVisible){
                binding.llBtn.animate().setListener(object : Animator.AnimatorListener{
                    override fun onAnimationStart(p0: Animator) {}
                    override fun onAnimationEnd(p0: Animator) {
                        binding.clLogo.visibility = View.VISIBLE
                        binding.tvTellMeMore.visibility = View.VISIBLE
                        binding.llDes.visibility = View.GONE
                        binding.ivCircleUp.visibility = View.GONE
                    }
                    override fun onAnimationCancel(p0: Animator) {}
                    override fun onAnimationRepeat(p0: Animator) {}
                }).translationY(0f).duration = 1000
            }
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
    }

}