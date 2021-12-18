package com.findajob.jobamax.recruiter.track

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterRecruitBinding
import com.findajob.jobamax.dialog.RejectReasonDialog
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.jobOffer.JobOfferDialog
import com.findajob.jobamax.util.ARG_VIDEO_URL
import com.findajob.jobamax.util.log
import com.parse.ParseObject
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recruiter_recruit.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.support.v4.longToast
import kotlin.math.max

@AndroidEntryPoint
class RecruiterRecruitFragment : BaseFragmentMain<FragmentRecruiterRecruitBinding>(),
    RecruiterRecruitInterface, CardStackListener {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private lateinit var manager: CardStackLayoutManager
    lateinit var navController: NavController

    private val adapter = JobSeekerRecruitCardAdapter(gson) {
        navController.navigate(
            R.id.action_recruiterTrackFragment_to_playVideoFragment,
            bundleOf(ARG_VIDEO_URL to it)
        )
    }

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_recruit

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        subscribeObserver()
    }

    private fun initViews() {
        binding.handler = this
        navController = findNavController()
        manager = CardStackLayoutManager(requireContext(), this)
        progressBar.visibility = View.GONE
    }


    private fun subscribeObserver() {
        viewModel.getApplicantsObserver().observe(viewLifecycleOwner, {
            if (it != null) {
                cardStackView.visibility = View.VISIBLE
                initialize()
                adapter.notifyJobSeekersChanged(it)
                manager.topPosition = viewModel.recruitIndex
                updateBottomNavigation()
                footerLayout.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        })

        viewModel.getAllJobOffersObserver().observe(viewLifecycleOwner, {
            if (it != null && it.isNotEmpty()) {
                jobOfferLabel.text = it.first()["name"].toString()
                progressBar.visibility = View.VISIBLE
                cardStackView.visibility = View.GONE
                loadApplicants(it.first())
            }
            updateBottomNavigation()
        })
    }

    private fun updateBottomNavigation() {
        if (!viewModel.isRecruitExhausted && viewModel.applicants.size == viewModel.recruitIndex && viewModel.applicants.size > 0) {
            viewModel.loadApplicants()
            binding.progressBar.visibility = View.VISIBLE
        }

        binding.noJobSeekerFoundLabel.visibility =
            if (viewModel.applicants.size == viewModel.recruitIndex && viewModel.isRecruitExhausted) View.VISIBLE else View.GONE
        binding.rewindButton.imageTintList =
            if (viewModel.recruitIndex == 0) ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.divider
                )
            ) else null
        binding.refuseButton.imageTintList =
            if (viewModel.applicants.size == viewModel.recruitIndex) ColorStateList.valueOf(
                ContextCompat.getColor(requireContext(), R.color.divider)
            ) else null
        binding.acceptButton.imageTintList =
            if (viewModel.applicants.size == viewModel.recruitIndex) ColorStateList.valueOf(
                ContextCompat.getColor(requireContext(), R.color.divider)
            ) else null
    }

    private fun initialize() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(false)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    override fun onRewindClicked() {
        val setting = RewindAnimationSetting.Builder()
            .setDirection(Direction.Bottom)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(DecelerateInterpolator())
            .build()
        manager.setRewindAnimationSetting(setting)
        cardStackView.rewind()

        if (viewModel.recruitIndex > 0) {
            viewModel.undoJob(viewModel.applicants[viewModel.recruitIndex - 1])
            viewModel.recruitIndex = max(0, viewModel.recruitIndex - 1)
        }
        updateBottomNavigation()
    }

    override fun onCancelClicked() {
        if (viewModel.applicants.size == viewModel.recruitIndex)
            return
        val overlayLayout = manager.topView?.findViewById<RelativeLayout>(R.id.overlayLayout)
        val overlayLabel = manager.topView?.findViewById<TextView>(R.id.overlayLabel)
        overlayLayout?.visibility = View.VISIBLE
        overlayLabel?.text = getString(R.string.refuse)
        overlayLayout?.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.trans_red
            )
        )

        val setting = SwipeAnimationSetting.Builder()
            .setDirection(Direction.Left)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(AccelerateInterpolator())
            .build()
        manager.setSwipeAnimationSetting(setting)
        cardStackView.swipe()
    }

    override fun onAcceptClicked() {
        if (viewModel.applicants.size == viewModel.recruitIndex)
            return

        val overlayLayout = manager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        val overlayLabel = manager.topView.findViewById<TextView>(R.id.overlayLabel)
        overlayLayout.visibility = View.VISIBLE
        overlayLabel.text = getString(R.string.recruit)
        overlayLayout.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.trans_green
            )
        )

        val setting = SwipeAnimationSetting.Builder()
            .setDirection(Direction.Right)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(AccelerateInterpolator())
            .build()
        manager.setSwipeAnimationSetting(setting)
        cardStackView.swipe()
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        val overlayLayout = manager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        val overlayLabel = manager.topView.findViewById<TextView>(R.id.overlayLabel)
        overlayLayout.visibility = View.VISIBLE

        if (direction != null) {
            val (textId, colorId) = when (direction) {
                Direction.Left -> Pair(R.string.refuse, R.color.trans_red)
                Direction.Right -> Pair(R.string.recruit, R.color.trans_green)
                Direction.Bottom -> Pair(R.string.text_return, R.color.trans_yellow)
                else -> {
                    overlayLayout.visibility = View.GONE
                    Pair(R.string.text_return, R.color.trans_yellow)
                }
            }
            overlayLabel.text = getString(textId)
            overlayLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), colorId))
        }
    }

    override fun onCardSwiped(direction: Direction?) {
        log("Item Count: " + manager.itemCount)
        when (direction) {
            Direction.Left -> {

                viewModel.refuse(viewModel.applicants[viewModel.recruitIndex])
                RejectReasonDialog(
                    requireActivity(),
                    viewModel.applicants[viewModel.recruitIndex]
                ) { reason, applicant ->
                    viewModel.addRejectReason(applicant, reason)
                }.show()

                viewModel.recruitIndex++
            }
            Direction.Right -> {
                if (viewModel.matchCount > viewModel.matchDailyLimit) {
                    longToast("You have reached the daily limit.")
                    lifecycleScope.launch {
                        delay(500)
                        withContext(Dispatchers.Main) {
                            onRewindClicked()
                        }
                    }
                } else {
                    viewModel.recruit(viewModel.applicants[viewModel.recruitIndex])
                    onJobSeekerSelected(viewModel.applicants[viewModel.recruitIndex])
//					requireActivity().cancelAlarm(JobOffer(viewModel.currentJobOffer!!).jobOfferId)
                    viewModel.recruitIndex++
                }
            }
            else -> {
                log("do some work")
            }
        }
        updateBottomNavigation()
    }

    private fun onJobSeekerSelected(jobSeeker: ParseObject) {
        log("onJobSeekerSelected ${jobSeeker.className}")
    }

    override fun onCardRewound() {
        val overlayLayout = manager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        overlayLayout.visibility = View.GONE
    }

    override fun onCardCanceled() {
        val overlayLayout = manager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        overlayLayout.visibility = View.GONE
    }

    override fun onCardAppeared(view: View?, position: Int) {
        val overlayLayout = manager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        overlayLayout.visibility = View.GONE
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        val overlayLayout = manager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        overlayLayout.visibility = View.GONE
    }

    override fun onJobOfferClicked() {
        JobOfferDialog(
            requireActivity(),
            viewModel.allJobOffers,
            { navController.navigate(R.id.action_recruiterRecruitFragment_to_createJobOfferFragment) }) {
            jobOfferLabel.text = it["name"].toString()
            progressBar.visibility = View.VISIBLE
            cardStackView.visibility = View.GONE
            noJobSeekerFoundLabel.visibility = View.GONE
            footerLayout.visibility = View.GONE
            loadApplicants(it)
        }.show()
    }

    private fun loadApplicants(it: ParseObject) {
        viewModel.recruitIndex = 0
        viewModel.recruitPageIndex = 0
        viewModel.isRecruitExhausted = false
        viewModel.applicants = arrayListOf()
        viewModel.selectedJobOffer = it
        viewModel.loadApplicants()
    }
}

interface RecruiterRecruitInterface {

    fun onRewindClicked()

    fun onCancelClicked()

    fun onAcceptClicked()

    fun onJobOfferClicked()

}