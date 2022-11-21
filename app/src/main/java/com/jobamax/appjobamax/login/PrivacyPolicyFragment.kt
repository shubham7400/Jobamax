package com.jobamax.appjobamax.login

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentPrivacyPolicyBinding
import com.jobamax.appjobamax.enums.LoginType
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER


class PrivacyPolicyFragment : Fragment() {
    lateinit var binding: FragmentPrivacyPolicyBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPrivacyPolicyBinding.inflate(inflater, container, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = requireActivity().window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.white, null)
        }
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnAgree.setOnClickListener {
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            if (user != null){
                if (user!!.loginType == LoginType.GOOGLE.type || user!!.loginType == LoginType.LINKEDIN.type){
                    findNavController().navigate(R.id.action_privacyPolicyFragment_to_takeAgeFragment, args)
                }else{
                    findNavController().navigate(R.id.action_privacyPolicyFragment_to_takeEmailFragment, args)
                }
            }else{
                findNavController().navigate(R.id.action_privacyPolicyFragment_to_takeEmailFragment, args)
            }
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
    }

}