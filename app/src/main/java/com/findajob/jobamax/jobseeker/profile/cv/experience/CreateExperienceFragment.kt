package com.findajob.jobamax.jobseeker.profile.cv.experience

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentCreateExperienceBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Experience
import com.findajob.jobamax.location.ManageLocationActivity
import com.findajob.jobamax.util.*
import com.whiteelephant.monthpicker.MonthPickerDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class CreateExperienceFragment : BaseFragmentMain<FragmentCreateExperienceBinding>(),
    CreateExperienceHandler {

    val viewModel: JobSeekerResumeViewModel by activityViewModels()

    lateinit var navController: NavController

    var experience: Experience = Experience()


    private val isUpdateObservable = MutableLiveData<Boolean>()

    override fun onCreated(savedInstance: Bundle?) {
        setHasOptionsMenu(true)
        checkArguments()
        initViews()
    }

    private fun initViews() {

        binding.handler = this
        navController = findNavController()


        // make the end date field inactive, when the currently working is checked
        binding.cbCurrentlyWorking.setOnCheckedChangeListener { _, isCurrentlyWorking ->
            binding.experienceEndDateField.isEnabled = !isCurrentlyWorking
        }

        observe(isUpdateObservable) {
            if (it == true) {
                binding.apply {
                    jobNameField.setText(experience.job)
                    companyField.setText(experience.company)
                    expDescriptionField.setText(experience.description)
                    experienceStartDateField.text = experience.startDate.parseDisplayMonthFormat()

                    // if the end date is not specified that means he is currently working
                    if (experience.endDate.isEmpty()) binding.experienceEndDateField.text =
                        getString(R.string.currently_working)
                    else binding.experienceEndDateField.text =
                        experience.endDate.parseDisplayMonthFormat()
                }
            }
        }

    }

    private fun checkArguments() {
        lifecycleScope.launch(Dispatchers.IO) {
            val param = arguments?.getString(ARG_EXPERIENCE, "") ?: ""
            if (param.isNotEmpty()) {
                experience = gson.fromJson(param, Experience::class.java)
                log("experience id is ${experience.id}")
                isUpdateObservable.postValue(true)
            } else {
                isUpdateObservable.postValue(false)
            }
        }
    }


    override fun onSaveButtonClicked() {

        experience.job = binding.jobNameField.text.toString()
        experience.company = binding.companyField.text.toString()
        experience.startDate = binding.experienceStartDateField.text.toString().parseMonthFormat()

        binding.cbCurrentlyWorking.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                experience.endDate = ""
                binding.experienceEndDateField.text = ""
            } else experience.endDate =
                binding.experienceEndDateField.text.toString().parseMonthFormat()

        }
        experience.description = binding.expDescriptionField.text.toString()

        if (validateFields()) {
            observe(isUpdateObservable) {
                if (it == true) viewModel.updateExperience(experience)
                else viewModel.addExperience(experience)
                navController.navigateUp()
            }
        }
    }

    private fun validateFields(): Boolean {
        if (experience.job.isEmpty()) {
            binding.jobNameField.error = getString(R.string.enter_job)
            toast(getString(R.string.enter_job))
            return false
        } else if (experience.company.isEmpty()) {
            binding.companyField.error = getString(R.string.enter_company)
            toast(getString(R.string.enter_company))
            return false

        } else if (experience.startDate.isEmpty()) {
            binding.experienceStartDateField.error = getString(R.string.enter_start_date)
            toast(getString(R.string.enter_start_date))
            return false

        } else {
            return true
        }
    }

    override fun onDateClicked(view: View, flag: Int) {
        val today = Calendar.getInstance()

        MonthPickerDialog.Builder(
            requireContext(),
            { selectedMonth, selectedYear ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, selectedYear)
                calendar.set(Calendar.MONTH, selectedMonth)
                calendar.set(Calendar.DATE, 1)
                (view as TextView).text = calendar.time.mm_yy_disp()
            },
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
        )
            .setActivatedMonth(today.get(Calendar.MONTH))
            .setMinYear(today.get(Calendar.YEAR))
            .setActivatedYear(today.get(Calendar.YEAR))
            .setMaxYear(today.get(Calendar.YEAR))
            .setMinYear(today.get(Calendar.YEAR) - 50)
            .setTitle("Select")
            .build()
            .show()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_create_experience


    override fun getViewModel(): ViewModel = viewModel

    override fun onBackButtonClicked() {
        navController.navigateUp()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, d: Intent?) {
        super.onActivityResult(requestCode, resultCode, d)

        if (requestCode == REQUEST_LOCATION_CODE && resultCode == Activity.RESULT_OK) {

            d?.let { data ->
                val location = data.getStringExtra(ARG_LOCATION) ?: ""
                if (location.isNotEmpty()) {
                    experience.location = location
                    binding.tvLocationField.text = location
                }

            }
        }
    }

    override fun onLocationClicked() {
        if (PLACE_API_KEY.isNotEmpty()) {

            val locationIntent = Intent(
                requireContext(),
                ManageLocationActivity::class.java
            )

            locationIntent.putExtra(ARG_CITY_FLAG, false)

            startActivityForResult(locationIntent, REQUEST_LOCATION_CODE)

        } else toast("Places API Key Required!")
    }
}

