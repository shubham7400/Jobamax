package com.findajob.jobamax.jobseeker.track

import android.content.Intent
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
import com.findajob.jobamax.WebViewActivity
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.messages.ChatActivity
import com.findajob.jobamax.databinding.FragmentJobSeekerApplyBinding
import com.findajob.jobamax.dialog.JobamaxReachDialog
import com.findajob.jobamax.dialog.ReachDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.util.*
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_seeker_apply.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.uiThread
import java.util.*
import kotlin.math.max

@AndroidEntryPoint
class JobSeekerApplyFragment : BaseFragmentMain<FragmentJobSeekerApplyBinding>(), CardStackListener, JobSeekerApplyInterface {

    val viewModel: JobSeekerApplyViewModel by activityViewModels()
    val jobSeekerHomeViewModel: JobSeekerHomeViewModel by activityViewModels()

    private lateinit var cardStackLayoutManager: CardStackLayoutManager
    private lateinit var navController: NavController

    private val jobOfferCardAdapter by lazy {
        JobOfferCardAdapter {
            navController.navigate(R.id.action_jobSeekerApplyFragment_to_jobOfferCardInfoFragment)
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        subscribeObserver()
    }


    private fun initViews() {
        binding.handler = this
        binding.keywordLabel.text = if (viewModel.jobSeeker.job.isEmpty()) getString(R.string.what_job_are_you_looking_for) else viewModel.jobSeeker.job
        cardStackLayoutManager = CardStackLayoutManager(context, this)
        progressBar.visibility = View.VISIBLE
        navController = findNavController()
    }

    override fun onStart() {
        super.onStart()
        if (jobSeekerHomeViewModel.jobOfferButtonCallback != JobOfferButtonCallback.NONE) {
            lifecycleScope.launch(Dispatchers.IO) {
                Thread.sleep(500)
                when (jobSeekerHomeViewModel.jobOfferButtonCallback) {
                    JobOfferButtonCallback.REJECT -> {
                        withContext(Dispatchers.Main) { onCancelClicked() }
                    }
                    JobOfferButtonCallback.ACCEPT -> {
                        withContext(Dispatchers.Main) { onAcceptClicked() }
                    }
                    JobOfferButtonCallback.CHAT -> {
                        withContext(Dispatchers.Main) { onChatClicked() }
                    }
                    else -> {
                    }
                }
                jobSeekerHomeViewModel.jobOfferButtonCallback = JobOfferButtonCallback.NONE
            }
        }
    }


    private fun subscribeObserver() {
        observe(jobSeekerHomeViewModel.jobOfferLiveData) {
            it?.let { jobOffers ->
                viewModel.jobSeekerObject = jobSeekerHomeViewModel.jobSeekerObject
                progressBar.visibility = View.GONE
                configureCardStackLayout()
                jobOfferCardAdapter.submitJobOffers(jobOffers)
                if (jobSeekerHomeViewModel.currentIndex > 0)
                    cardStackLayoutManager.topPosition = jobSeekerHomeViewModel.currentIndex
                updateBottomNavigation()
            }
        }


        observe(viewModel.getExternalJobObserver()) {
            it?.let { videoUrl ->
                if (videoUrl.isNotEmpty()) {
                    startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, videoUrl))
                    viewModel.setJobUrlEmpty()
                }
            }
        }
    }

    private fun configureCardStackLayout() {
        cardStackLayoutManager.apply {
            setStackFrom(StackFrom.None)
            setVisibleCount(3)
            setTranslationInterval(8.0f)
            setScaleInterval(0.95f)
            setSwipeThreshold(0.3f)
            setMaxDegree(20.0f)
            setDirections(Direction.FREEDOM)
            setCanScrollHorizontal(true)
            setCanScrollVertical(true)
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
        }

        cardStackView.layoutManager = cardStackLayoutManager
        cardStackView.adapter = jobOfferCardAdapter

        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }

    }

    private fun updateBottomNavigation() {
        if (!jobSeekerHomeViewModel.isJobOfferExhausted && jobSeekerHomeViewModel.jobOffers.size == jobSeekerHomeViewModel.currentIndex) {
            jobSeekerHomeViewModel.loadJobOffers()
            binding.progressBar.visibility = View.VISIBLE
        }
        binding.noJobFoundLabel.visibility = if (jobSeekerHomeViewModel.jobOffers.size == jobSeekerHomeViewModel.currentIndex && jobSeekerHomeViewModel.isJobOfferExhausted) View.VISIBLE else View.GONE
        binding.rewindButton.imageTintList = if (jobSeekerHomeViewModel.currentIndex == 0) ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.divider)) else null
        binding.chatButton.imageTintList = if (jobSeekerHomeViewModel.jobOffers.size == jobSeekerHomeViewModel.currentIndex) ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.divider)) else null
        binding.rejectButton.imageTintList = if (jobSeekerHomeViewModel.jobOffers.size == jobSeekerHomeViewModel.currentIndex) ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.divider)) else null
        binding.acceptButton.imageTintList = if (jobSeekerHomeViewModel.jobOffers.size == jobSeekerHomeViewModel.currentIndex) ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.divider)) else null
        footerLayout.visibility = View.VISIBLE
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        if (topViewExist()) {
            val overlayLayout = cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
            val overlayLabel = cardStackLayoutManager.topView.findViewById<TextView>(R.id.overlayLabel)
            overlayLayout.visibility = View.VISIBLE

            if (direction != null) {
                val (textId, colorId) = when (direction) {
                    Direction.Left -> Pair(R.string.cancel, R.color.trans_red)
                    Direction.Right -> Pair(R.string.apply, R.color.trans_green)
                    Direction.Top -> Pair(R.string.reach, R.color.trans_purple)
                    else -> Pair(R.string.text_return, R.color.trans_yellow)
                }
                overlayLabel.text = getString(textId)
                overlayLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), colorId))
            }
        }
    }

    override fun onCardSwiped(direction: Direction?) {
        when (direction) {
            Direction.Left -> {
                viewModel.rejectJob(jobSeekerHomeViewModel.jobOffers[jobSeekerHomeViewModel.currentIndex])
                jobSeekerHomeViewModel.currentIndex++
            }
            Direction.Right -> {
                viewModel.acceptJob(jobSeekerHomeViewModel.jobOffers[jobSeekerHomeViewModel.currentIndex])
                jobSeekerHomeViewModel.currentIndex++
            }
            Direction.Bottom -> {
                if (jobSeekerHomeViewModel.currentIndex > 0) {
                    viewModel.undoJob(jobSeekerHomeViewModel.jobOffers[jobSeekerHomeViewModel.currentIndex - 1])
                    jobSeekerHomeViewModel.currentIndex--
                    lifecycleScope.launch {
                        delay(500)
                        withContext(Dispatchers.Main) {
                            cardStackView.smoothScrollToPosition(jobSeekerHomeViewModel.currentIndex)
                        }
                    }
                } else {
                    jobSeekerHomeViewModel.currentIndex++
                    doAsync {
                        Thread.sleep(500)
                        uiThread {
                            onRewindClicked()
                        }
                    }

                }
            }
            Direction.Top -> {
                // chat code here
                val jobOffer = jobSeekerHomeViewModel.jobOffers[jobSeekerHomeViewModel.currentIndex]
                if (jobOffer.getString("jobOfferId")!! == ADZUNA_JOB || jobOffer.getString("jobOfferId")!! == REMOTIVE_JOB || jobOffer.getString("jobOfferId")!! == JOOBLE_JOB || jobOffer.getString("jobOfferId")!! == USAJOBS_JOB || jobOffer.getString("jobOfferId")!! == JOBSPIKR_JOB) {
                    longToast("Not available for external jobs")
                    lifecycleScope.launch {
                        delay(500)
                        withContext(Dispatchers.Main) {
                            onRewindClicked()
                        }
                    }
                } else if (viewModel.jobSeeker.totalReach + viewModel.jobSeeker.todayReach != null) {
                    val jobOffer = jobSeekerHomeViewModel.jobOffers[jobSeekerHomeViewModel.currentIndex]

                    val recruiter = try {
                        Recruiter(jobOffer.getParseObject(Recruiter.CLASS_NAME.lowercase(Locale.getDefault()))?.fetchIfNeeded()!!)
                    } catch (e: Exception) {
                        log("Could not get it the recruiter in ${this::class.java.simpleName}", e)
                        null
                    }
                    viewModel.matchUser(ROLE_JOB_SEEKER, recruiter?.userId ?: "",)


                    // show popup to continue swiping or not
                    ReachDialog(requireActivity(), jobOffer.get("companyName").toString(),) { button ->
                        if (button == ReachDialog.SubmitButton.POSITIVE) {

                            viewModel.decrementReach()
                            jobSeekerHomeViewModel.currentIndex++

                            activity?.goToActivity(
                                ChatActivity::class.java,
                                false,
                                bundleOf(
                                    Pair(ChatActivity.EXTRA_RECEIVER_ID, recruiter?.userId ?: ""),
                                    Pair(ChatActivity.EXTRA_PROFILE_PICTURE_URL, recruiter?.profilePicUrl ?: ""),
                                    Pair(ChatActivity.EXTRA_MESSAGE_SOURCE, CHAT_IS_JOB),
                                    Pair(ChatActivity.EXTRA_IS_SOURCE, true),
                                    Pair(ChatActivity.EXTRA_JOB_OFFER_ID, jobOffer.objectId ?: "")
                                ),
                            )
                            (requireActivity() as JobSeekerHomeActivity).onIconClicked(3)
                            navController.navigate(R.id.messagesFragment)
                        }
                    }.show()
                } else {
                    JobamaxReachDialog(requireActivity()) {
                        (requireActivity() as JobSeekerHomeActivity).initBilling()
                    }.show()
                    longToast("Reach has exhausted")
                    doAsync {
                        Thread.sleep(500)
                        uiThread {
                            onRewindClicked()
                        }
                    }
                }
            }
        }
        updateBottomNavigation()
    }

    override fun onCardRewound() {
        if (topViewExist()) {
            val overlayLayout = cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
            overlayLayout.visibility = View.GONE
        }
    }

    override fun onCardCanceled() {
        if (topViewExist()) {
            val overlayLayout = cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
            overlayLayout.visibility = View.GONE
        }
    }

    override fun onCardAppeared(view: View?, position: Int) {
        cardStackLayoutManager.setCanScrollVertical(true)
        if (topViewExist()) {
            val overlayLayout = cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
            overlayLayout.visibility = View.GONE
        }
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    override fun onRewindClicked() {
        val setting = RewindAnimationSetting.Builder()
            .setDirection(Direction.Bottom)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(DecelerateInterpolator())
            .build()
        cardStackLayoutManager.setRewindAnimationSetting(setting)
        cardStackView.rewind()

        if (jobSeekerHomeViewModel.currentIndex > 0) {
            viewModel.undoJob(jobSeekerHomeViewModel.jobOffers[jobSeekerHomeViewModel.currentIndex - 1])
            jobSeekerHomeViewModel.currentIndex = max(0, jobSeekerHomeViewModel.currentIndex - 1)
        }
        updateBottomNavigation()
    }

    override fun onCancelClicked() {
        swipe(R.color.trans_red, getString(R.string.cancel), Direction.Left)
    }

    override fun onChatClicked() {
        swipe(R.color.trans_purple, getString(R.string.reach), Direction.Top)
    }

    override fun onAcceptClicked() {
        swipe(R.color.trans_green, getString(R.string.apply), Direction.Right)
    }

    private fun swipe(overlayColorId: Int, overlayText: String, direction: Direction) {
        if (jobSeekerHomeViewModel.jobOffers.size == jobSeekerHomeViewModel.currentIndex)
            return
        if (topViewExist()) {
            val overlayLayout = cardStackLayoutManager.topView.findViewById<RelativeLayout>(R.id.overlayLayout)
            val overlayLabel = cardStackLayoutManager.topView.findViewById<TextView>(R.id.overlayLabel)
            overlayLayout.visibility = View.VISIBLE
            overlayLabel.text = overlayText
            overlayLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), overlayColorId))
        }
        val setting = SwipeAnimationSetting.Builder()
            .setDirection(direction)
            .setDuration(Duration.Normal.duration)
            .setInterpolator(AccelerateInterpolator())
            .build()
        cardStackLayoutManager.setSwipeAnimationSetting(setting)
        cardStackView.swipe()
    }

    override fun onSearchClicked() {
        navController.navigate(R.id.action_jobSeekerApplyFragment_to_jobSearchFragment2)
    }

    private fun topViewExist(): Boolean {
        return cardStackLayoutManager.topView != null
    }

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_apply


    override fun getViewModel(): ViewModel = viewModel
}
