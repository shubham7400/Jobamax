package com.jobamax.appjobamax.jobseeker.profile.account.deleteAccount
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
 import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.jobseeker.profile.account.deleteAccount.adapter.LeavingReason
import com.jobamax.appjobamax.jobseeker.profile.account.deleteAccount.adapter.LeavingReasonAdapter

class SeekerDeleteAccountFragment : BaseFragment(), SeekerDeleteAccountInterface {
    lateinit var binding: FragmentSeekerDeleteAccountBinding

    private lateinit var navController: NavController
    private val leavingAdapter: LeavingReasonAdapter by lazy {
        LeavingReasonAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerDeleteAccountBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.handler = this
        navController = findNavController()
        initUi()
    }






    private fun initUi() {
        initRvLeaveReason()
    }

    private fun initRvLeaveReason() {
        leavingAdapter.collection = resources.getStringArray(R.array.leaving_reason).map { LeavingReason(it, false) }
        binding.apply {
            rvReason.adapter = leavingAdapter
        }
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }

    override fun onContinue() {
        val reasons = leavingAdapter.fetchLeavingReason()
        val args = Bundle()
        if (reasons.isEmpty()) {
            BasicDialog(requireActivity(), getString(R.string.please_select_reason), false) {}.show()
            return
        }
        args.putString(LeavingReason::class.simpleName, reasons.toString())
        navController.navigate(R.id.action_seekerDeleteAccountFragment_to_seekerDeleteAccountFinalFragment, args)
    }


}