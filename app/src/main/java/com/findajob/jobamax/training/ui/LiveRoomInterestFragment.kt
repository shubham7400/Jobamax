package com.findajob.jobamax.training.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentLiveRoomInterestsBinding
import com.findajob.jobamax.dialog.GroupAlertDialog
import com.findajob.jobamax.model.Interests
import com.findajob.jobamax.repo.GetInterestsCallback
import com.findajob.jobamax.repo.GetRoomCallback
import com.findajob.jobamax.repo.GetSavedRoomCallback
import com.findajob.jobamax.repo.SaveInterestsCallback
import com.findajob.jobamax.util.MAXIMUM_INTERESTS
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.showBasicDialog
import com.google.android.material.chip.Chip
import com.parse.ParseObject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


@AndroidEntryPoint
class LiveRoomInterestFragment : BaseFragment(),
    LiveRoomInterestInterface {

    val viewModel: ManageRoomViewModel by activityViewModels()
    lateinit var navController: NavController
    lateinit var binding: FragmentLiveRoomInterestsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLiveRoomInterestsBinding.inflate(inflater, container, false)
        binding.handler = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpNavigation(view)
    }

    private fun initViews() {
        binding.btnContinue.isEnabled = false

        log("activity is -> $activity")
    }

    private fun setUpNavigation(view: View) {
        navController = Navigation.findNavController(view)
        progressHud.show()
        viewModel.loadSavedRoom(object : GetSavedRoomCallback {
            override fun onFinish(exists: Boolean) {
                if (exists) {
                    progressHud.dismiss()
                    navController.navigate(R.id.action_interest_to_welcome)
                } else {
                    initViews()
                    initObserver()
                }
            }
        })
    }

    private fun initObserver() {

        viewModel.loadInterests(object : GetInterestsCallback {
            override fun onFinish(interests: List<ParseObject>) {

                progressHud.dismiss()

                for ((index, interest) in interests.withIndex()) {
                    val item = Interests(interest)

                    val chip = layoutInflater.inflate(
                        R.layout.interests_chip_view,
                        binding.chipGroup,
                        false
                    ) as Chip

                    chip.text = item.name
                    chip.id = index

                    chip.setOnCheckedChangeListener { _, checked ->
                        val ids: List<Int> = binding.chipGroup.checkedChipIds
                        if (checked) {
                            //Get all checked chips in the group
                            if (ids.size > MAXIMUM_INTERESTS) {
                                chip.isChecked = false //force to unchecked the chip
                            }
                        }
                        binding.btnContinue.isEnabled = ids.isNotEmpty()
                    }
                    binding.chipGroup.addView(chip)
                }

                progressHud.dismiss()
            }
        })
    }

    private fun showNotificationDialog() {

        progressHud.dismiss()

        val notificationDialog = GroupAlertDialog(requireActivity()) { allowed ->
            if (allowed) {

                progressHud.show()

                viewModel.loadRooms(object : GetRoomCallback {

                    override fun onFinish(rooms: List<ParseObject>, interests: List<String>) {
                        if (rooms.isNullOrEmpty()) {
                            progressHud.dismiss()
                            showBasicDialog(
                                requireContext(),
                                "There is no room available for this category",
                                null,
                                null
                            )
                        } else {
                            viewModel.selectRandomRoom()
                            progressHud.dismiss()
                            navController.navigate(R.id.action_interest_to_welcome)
                        }
                    }

                })

            } else {
                progressHud.dismiss()
                navController.navigate(R.id.action_liveRoomInterestFragment_to_manageRoomFragment)
            }
        }

        notificationDialog.show()
    }


    override fun onBackButtonClicked() {
        requireActivity().onBackPressed()
    }

    override fun onContinuteClicked() {
        binding.btnContinue.isEnabled = false

        progressHud.show()

        val ids: List<Int> = binding.chipGroup.checkedChipIds
        val names: ArrayList<String> = arrayListOf()
        for (id in ids) {
            val chip = binding.chipGroup.findViewById<Chip>(id)
            names.add(chip.text.toString())
        }

        viewModel.saveSelectedInterests(names, object : SaveInterestsCallback {
            override fun onFinish(isSuccessful: Boolean) {
                showNotificationDialog()
            }
        })
    }
}