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
import com.findajob.jobamax.dashboard.messages.ChatActivity
import com.findajob.jobamax.databinding.FragmentRecruiterSourceBinding
import com.findajob.jobamax.dialog.ReachDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.util.ARG_VIDEO_URL
import com.findajob.jobamax.util.CHAT_IS_JOB
import com.findajob.jobamax.util.log
import com.parse.ParseObject
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recruiter_source.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.support.v4.longToast
import kotlin.math.max

@AndroidEntryPoint
class RecruiterSourceFragment : BaseFragmentMain<FragmentRecruiterSourceBinding>(),
    RecruiterSourceInterface, CardStackListener {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private lateinit var cardStackLayoutManager: CardStackLayoutManager
    lateinit var navController: NavController

    private val sourceCardAdapter: JobSeekerSourceCardAdapter by lazy {
        JobSeekerSourceCardAdapter(gson, { flag ->
            if (flag) {
                cardStackLayoutManager.setDirections(mutableListOf(Direction.Left, Direction.Top))
                cardStackLayoutManager.setCanScrollVertical(true)
            } else {
                cardStackLayoutManager.setDirections(mutableListOf(Direction.Left))
                cardStackLayoutManager.setCanScrollVertical(false)
            }
        }) {
            navController.navigate(
                R.id.action_recruiterTrackFragment_to_playVideoFragment,
                bundleOf(ARG_VIDEO_URL to it)
            )
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        subscribeObserver()
    }


    private fun initViews() {
        progressHud.show()
        binding.apply {
            handler = this@RecruiterSourceFragment
        }
        cardStackLayoutManager = CardStackLayoutManager(requireContext(), this)
        navController = findNavController()
    }

    private fun subscribeObserver() {
        observe(viewModel.jobSeekerLiveData) {
            it?.let { jobSeekers ->
                configureCardStack()
                sourceCardAdapter.submitJobSeekers(jobSeekers)
                cardStackLayoutManager.topPosition = viewModel.sourceIndex
                updateBottomNavigation()
                progressHud.dismiss()
            }
        }
    }


    private fun configureCardStack() {
        cardStackLayoutManager.setStackFrom(StackFrom.None)
        cardStackLayoutManager.setVisibleCount(3)
        cardStackLayoutManager.setTranslationInterval(8.0f)
        cardStackLayoutManager.setScaleInterval(0.95f)
        cardStackLayoutManager.setSwipeThreshold(0.3f)
        cardStackLayoutManager.setMaxDegree(20.0f)
        cardStackLayoutManager.setDirections(listOf(Direction.Left, Direction.Top))
        cardStackLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        cardStackLayoutManager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = cardStackLayoutManager
        cardStackView.adapter = sourceCardAdapter
        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    override fun onRewindClicked() {
        log("onRewindClicked()")
        val setting = RewindAnimationSetting.Builder()
            .setDirection(Direction.Bottom)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(DecelerateInterpolator())
            .build()
        cardStackLayoutManager.setRewindAnimationSetting(setting)
        cardStackView.rewind()
        if (viewModel.sourceIndex > 0) {
            viewModel.undoCancel(viewModel.jobSeekers[viewModel.sourceIndex - 1])
            viewModel.sourceIndex = max(0, viewModel.sourceIndex - 1)
        }

        updateBottomNavigation()
    }

    override fun onCancelClicked() {
        log("onCancelClicked()")

        if (viewModel.jobSeekers.size == viewModel.sourceIndex)
            return
        val overlayLayout =
            cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        val overlayLabel = cardStackLayoutManager.topView.findViewById<TextView>(R.id.overlayLabel)
        overlayLayout.visibility = View.VISIBLE
        overlayLabel.text = getString(R.string.refuse)
        overlayLayout.setBackgroundColor(
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
        cardStackLayoutManager.setSwipeAnimationSetting(setting)
        cardStackView.swipe()
    }

    override fun onChatClicked() {
        log("onAcceptClicked()")
        if (viewModel.jobSeekers.size == viewModel.sourceIndex)
            return
        val overlayLayout = cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        val overlayLabel = cardStackLayoutManager.topView.findViewById<TextView>(R.id.overlayLabel)
        overlayLayout.visibility = View.VISIBLE
        overlayLabel.text = getString(R.string.reach)
        overlayLayout.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.trans_purple
            )
        )
        val setting = SwipeAnimationSetting.Builder()
            .setDirection(Direction.Top)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(AccelerateInterpolator())
            .build()
        cardStackLayoutManager.setSwipeAnimationSetting(setting)
        cardStackView.swipe()
    }

    private fun showMessagePopUp(jobSeekerPo: ParseObject) {
        val jobSeeker = try {
            JobSeeker(jobSeekerPo)
        } catch (e: Exception) {
            log(
                "Could not turn the parse object to job seeker in ${this::class.java.simpleName}",
                e
            )
            null
        }
        jobSeeker?.let { js ->
            ReachDialog(
                requireActivity(),
                "${js.firstName} ${js.lastName}",
            ) { button ->
                if (button == ReachDialog.SubmitButton.POSITIVE) {
                    viewModel.sourceIndex++
                    viewModel.sourceUser(requireActivity().getRole(), jobSeekerPo.objectId)
                    activity?.goToActivity(
                        ChatActivity::class.java,
                        false,
                        bundleOf(
                            Pair(
                                ChatActivity.EXTRA_RECEIVER_ID,
                                js.userId
                            ),
                            Pair(
                                ChatActivity.EXTRA_PROFILE_PICTURE_URL,
                                js.profilePicUrl
                            ),
                            Pair(ChatActivity.EXTRA_MESSAGE_SOURCE, CHAT_IS_JOB),
                            Pair(ChatActivity.EXTRA_IS_SOURCE, true),
                            Pair(
                                ChatActivity.EXTRA_JOB_OFFER_ID,
                                viewModel.currentJobOffer?.objectId ?: ""
                            )
                        ),
                    )
                    (requireActivity() as RecruiterHomeActivity).onIconClicked(3)
//                    navController.navigate(R.id.messagesFragment)
                }
            }.show()
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        val overlayLayout =
            cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        val overlayLabel = cardStackLayoutManager.topView.findViewById<TextView>(R.id.overlayLabel)
        overlayLayout.visibility = View.VISIBLE

        if (direction != null) {
            val (textId, colorId) = when (direction) {
                Direction.Left -> Pair(R.string.refuse, R.color.trans_red)
                Direction.Top -> Pair(R.string.source, R.color.trans_purple)
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
        log("onCardSwiped(direction: $direction)")
        when (direction) {
            Direction.Top -> {
                if (viewModel.sourceCount > viewModel.sourceDailyLimit + 1) {
                    longToast("You have reached the daily limit.")
                    lifecycleScope.launch {
                        delay(500)
                        withContext(Dispatchers.Main) {
                            onRewindClicked()
                        }
                    }
                } else {
                    val jobSeeker: ParseObject = viewModel.jobSeekers[viewModel.sourceIndex]
                    showMessagePopUp(jobSeeker)
                    log("${this::class.java.simpleName} onCardSwiped: job seeker index is ${viewModel.sourceIndex} and the job seeker is $jobSeeker")
                    navController.navigate(R.id.recruiterMessagesFragment)
                    (requireActivity() as RecruiterHomeActivity).onIconClicked(3)

                }
            }
            Direction.Left -> {
                viewModel.cancel(viewModel.jobSeekers[viewModel.sourceIndex])

                viewModel.sourceIndex++
                log("source index: " + viewModel.sourceIndex)
            }
            else -> log("${this::class.java.simpleName} onCardSwiped: There is nothing to select")
        }

        updateBottomNavigation()
    }


    private fun updateBottomNavigation() {
        if (!viewModel.isSourceExhausted && viewModel.jobSeekers.size == viewModel.sourceIndex) {
            viewModel.loadJobSeekers()
//            progressHud.show()
//            binding.progressBar.visibility = View.VISIBLE
        }
        binding.noJobSeekerFoundLabel.visibility =
            if (viewModel.jobSeekers.size == viewModel.sourceIndex && viewModel.isSourceExhausted) View.VISIBLE else View.GONE
        binding.rewindButton.imageTintList = if (viewModel.sourceIndex == 0) ColorStateList.valueOf(
            ContextCompat.getColor(
                requireContext(),
                R.color.divider
            )
        ) else null
        binding.refuseButton.imageTintList =
            if (viewModel.jobSeekers.size == viewModel.sourceIndex) ColorStateList.valueOf(
                ContextCompat.getColor(requireContext(), R.color.divider)
            ) else null
        binding.sourceButton.imageTintList =
            if (viewModel.jobSeekers.size == viewModel.sourceIndex) ColorStateList.valueOf(
                ContextCompat.getColor(requireContext(), R.color.divider)
            ) else null
    }

    override fun onCardRewound() {
        log("onCardRewound")

        /*val overlayLayout = manager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        val overlayLabel = manager.topView.findViewById<TextView>(R.id.overlayLabel)
        overlayLayout.visibility = View.VISIBLE
        overlayLabel.text = getString(R.string.text_return)
        overlayLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.trans_yellow))
        */
    }

    override fun onCardCanceled() {
        log("onCardCanceled")
        val overlayLayout =
            cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        overlayLayout.visibility = View.GONE
    }

    override fun onCardAppeared(view: View?, position: Int) {
        log("onCardAppeared()")
        //manager.setCanScrollVertical(true)
        cardStackLayoutManager.setDirections(mutableListOf(Direction.Left, Direction.Top))
        val overlayLayout =
            cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
        overlayLayout.visibility = View.GONE
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        log("onCardDisappeared()")
    }

    override fun onSourceClicked() {
        navController.navigate(R.id.jobSourceFragment)
    }

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_source


}

interface RecruiterSourceInterface {

    fun onSourceClicked()

    fun onRewindClicked()

    fun onCancelClicked()

    fun onChatClicked()

}