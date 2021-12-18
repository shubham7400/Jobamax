package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse


import android.os.Bundle
import android.text.SpannableString
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.instructor.InstructorsFragment
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.review.ReviewsFragment
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.syllabus.SyllabusFragment
import com.findajob.jobamax.databinding.ActivityOnlineCourseDetailsBinding
import com.findajob.jobamax.util.ViewPagerAdapter
import com.findajob.jobamax.util.setSize
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnlineCourseDetailsActivity : BaseActivityMain<ActivityOnlineCourseDetailsBinding>() {
    lateinit var vpa: ViewPagerAdapter
    private lateinit var onlineCourse: OnlineCourse

    val viewModel: OnlineCourseViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.activity_online_course_details

    override fun getViewModel(): ViewModel? {
        return viewModel
    }

    override fun onCreated(instance: Bundle?) {
        setupViewPager()
        initObservers()
        getExtras()
        initView()
    }

    private fun getExtras() {
        onlineCourse = viewModel.onlineCourse!!
    }

    private fun initObservers() {
        binding.viewPagerAdapter = vpa
    }

    private fun initView() {
        binding.apply {
            onlineCourseCtl.addOnTabSelectedListener(
                TabLayout.ViewPagerOnTabSelectedListener(
                    binding.vpa
                )
            )
            vpa.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.onlineCourseCtl))
            onlineCourseTitle.text = onlineCourse.title
            val instructorName = onlineCourse.visible_instructors?.first()?.display_name ?: ""
            val profileLabel = SpannableString(
                String.format(
                    "%s\n%s",
                    instructorName,
                    getString(R.string.instructor)
                )
            )
            profileLabel.setSize(18, instructorName)
            profileLabel.setSize(14, getString(R.string.instructor))
            onlineCourseInstructorProfileName.text = profileLabel
            onlineCourseInstructorProfileImage.load(onlineCourse.visible_instructors?.first()?.image_small) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            ivBanner.load(onlineCourse.image) {
                crossfade(true)
                transformations(RoundedCornersTransformation(24F))

            }
            enrollForTv.text =
                String.format("%s %s", getString(R.string.enroll_for), onlineCourse.price)

            backBtn.setOnClickListener {
                finish()
            }
        }
    }

    private fun setupViewPager() {

        vpa = ViewPagerAdapter(supportFragmentManager)

        //TODO: add about fragment

        vpa.addFragment(InstructorsFragment(), InstructorsFragment::class.java.simpleName)
        vpa.addFragment(SyllabusFragment(), SyllabusFragment::class.java.simpleName)
        vpa.addFragment(ReviewsFragment(), ReviewsFragment::class.java.simpleName)


        binding.apply {
            onlineCourseCtl.addTab(onlineCourseCtl.newTab().setText("Instructors"))
            onlineCourseCtl.addTab(onlineCourseCtl.newTab().setText("Syllabus"))
            onlineCourseCtl.addTab(onlineCourseCtl.newTab().setText("Reviews"))
        }
    }


}