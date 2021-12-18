package com.findajob.jobamax.recruiter.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.findajob.jobamax.BaseActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityRecruiterHomeBinding
import com.findajob.jobamax.dialog.ConfirmJobDeletionDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoActivity
import com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInfoIntroActivity
import com.findajob.jobamax.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_recruiter_home.*

@AndroidEntryPoint
class RecruiterHomeActivity : BaseActivityMain<ActivityRecruiterHomeBinding>(),
    RecruiterHomeInterface {

    val viewModel: RecruiterHomeViewModel by viewModels()
    override fun getViewModel(): ViewModel = viewModel

    var trackToggleFlag = true
    var currentPosition = -1
    lateinit var navController: NavController

    override val layoutRes: Int
        get() = R.layout.activity_recruiter_home

    override fun onCreated(instance: Bundle?) {
        binding.handler = this
        intent.data?.let { uri ->
            val list = uri.pathSegments
            log(list.lastOrNull() ?: "null")
        }

        navController = findNavController(R.id.nav_host_fragment)
        viewModel.getRecruiter()
        onIconClicked(2)

        navController.addOnDestinationChangedListener { _, dest, _ ->
            if (dest.id == R.id.recruiterCourseFragment || dest.id == R.id.recruiterMessagesFragment || dest.id == R.id.recruiterRecruitFragment || dest.id == R.id.recruiterSourceFragment || dest.id == R.id.recruiterProfileFragment) {
                appbar.visibility = View.VISIBLE
            } else appbar.visibility = View.GONE
        }
        subscribeObserver()
        checkForJobOfferAction()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        checkForJobOfferAction()
    }


    private fun checkForJobOfferAction() {
        val jobId = intent?.getStringExtra(ARG_JOB_ID) ?: ""
        val jobName = intent?.getStringExtra(ARG_JOB_NAME) ?: ""
        log("onNewIntent() jobId: $jobId, jobName: $jobName")
        if (jobId.isNotEmpty()) {
            ConfirmJobDeletionDialog(this, jobName) {
                progressHud.show()
                viewModel.archiveJobOffer(jobId)
            }.show()
        }
    }

    private fun subscribeObserver() {

        observe(viewModel.getCompanyObserver()) { company ->
            progressHud.dismiss()
            if (company == null) toast("Could not retrieve the company information")
        }

        observe(viewModel.archiveJobOfferSuccess) {
            progressHud.dismiss()

            it?.let {
                val id = it.first
                if (it.second) {
                    cancelAlarm(id)
                    viewModel.getRecruiter()
                    toast("Job Offer Deleted")
                } else errorToast()

            }
        }
    }

    override fun onBackPressed() {
        val currDest = navController.currentDestination?.id
        if (currDest == R.id.recruiterCourseFragment || currDest == R.id.recruiterMessagesFragment || currDest == R.id.recruiterProfileFragment) {
            onIconClicked(2)
        } else
            super.onBackPressed()
    }

    override fun onIconClicked(position: Int) {
        if (position == 2 && currentPosition == 2) {
            trackToggleFlag = !trackToggleFlag
            if (trackToggleFlag) {
                toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_source))
                navController.popBackStack()
                navController.navigate(R.id.recruiterRecruitFragment)
            } else {
                toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_recruit))
                navController.popBackStack()
                navController.navigate(R.id.recruiterSourceFragment)
            }

        } else {
            binding.state = position
            currentPosition = position
            setUpAppbar()
        }
    }

    fun setUpAppbar() {
        if (currentPosition == 2) {
            toggleIcon.visibility = View.VISIBLE
            secondIcon.visibility = View.GONE
            if (trackToggleFlag)
                toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_source))
            else
                toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_recruit))
        } else {
            toggleIcon.visibility = View.GONE
            secondIcon.visibility = View.VISIBLE
        }

        firstIcon.requestLayout()
        firstIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        firstIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        secondIcon.requestLayout()
        secondIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        secondIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        thirdIcon.requestLayout()
        thirdIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        thirdIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        fourthIcon.requestLayout()
        fourthIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_20dp).toInt()
        fourthIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_20dp).toInt()
        when (currentPosition) {
            1 -> {
                firstIcon.requestLayout()
                firstIcon.layoutParams.height =
                    resources.getDimension(R.dimen.home_icon_48dp).toInt()
                firstIcon.layoutParams.width =
                    resources.getDimension(R.dimen.home_icon_48dp).toInt()
                navController.popBackStack()
                navController.navigate(R.id.recruiterCourseFragment)
            }
            2 -> {
                secondIcon.requestLayout()
                secondIcon.layoutParams.height =
                    resources.getDimension(R.dimen.home_icon_40dp).toInt()
                secondIcon.layoutParams.width =
                    resources.getDimension(R.dimen.home_icon_40dp).toInt()
                if (trackToggleFlag) {
                    navController.popBackStack()
                    toggleIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ic_source
                        )
                    )
                    navController.navigate(R.id.recruiterRecruitFragment)
                } else {
                    navController.popBackStack()
                    toggleIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ic_recruit
                        )
                    )
                    navController.navigate(R.id.recruiterSourceFragment)
                }
            }
            3 -> {
                thirdIcon.requestLayout()
                thirdIcon.layoutParams.height =
                    resources.getDimension(R.dimen.home_icon_40dp).toInt()
                thirdIcon.layoutParams.width =
                    resources.getDimension(R.dimen.home_icon_40dp).toInt()
                navController.popBackStack()
                navController.navigate(R.id.recruiterMessagesFragment)
            }
            else -> {
                fourthIcon.requestLayout()
                fourthIcon.layoutParams.height =
                    resources.getDimension(R.dimen.home_icon_32dp).toInt()
                fourthIcon.layoutParams.width =
                    resources.getDimension(R.dimen.home_icon_32dp).toInt()
                navController.popBackStack()
                navController.navigate(R.id.recruiterProfileFragment)
            }
        }
    }

}

interface RecruiterHomeInterface {
    fun onIconClicked(position: Int)
}