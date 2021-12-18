package com.findajob.jobamax.jobseeker.profile.cv.education

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
import com.findajob.jobamax.databinding.FragmentCreateEducationBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.util.*
import com.google.gson.Gson
import com.whiteelephant.monthpicker.MonthPickerDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_education.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class CreateEducationFragment : BaseFragmentMain<FragmentCreateEducationBinding>(),
    CreateEducationHandler {

    @Inject
    lateinit var jsonConverter: Gson

    val viewModel: JobSeekerResumeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var navController: NavController

    var education: Education = Education()

    private val isUpdateObservable = MutableLiveData<Boolean>()

    override val layoutRes: Int
        get() = R.layout.fragment_create_education

    override fun onCreated(savedInstance: Bundle?) {
        checkArguments()
        initViews()
    }


    private fun checkArguments() {
        lifecycleScope.launch(Dispatchers.IO) {
            val param = arguments?.getString(ARG_EDUCATION, "") ?: ""
            if (param.isNotEmpty()) {
                education = jsonConverter.fromJson(param, Education::class.java)
                log("updating education is ${education.name}")
                isUpdateObservable.postValue(true)
            } else {
                isUpdateObservable.postValue(false)
            }
        }
    }

    private fun initViews() {
        binding.handler = this
        setHasOptionsMenu(true)
        navController = findNavController()

        observe(isUpdateObservable) {
            if (it == true) {
                log("Everything is updating")
                binding.schoolNameField.setText(education.name)
                binding.programNameField.setText(education.program)
                binding.educationStartDateField.text = education.startDate.parseDisplayMonthFormat()
                binding.educationEndDateField.text = education.endDate.parseDisplayMonthFormat()
                binding.tvGpa.setText(education.gpa.toString())
            }
        }
    }

    override fun onAddEducationClicked() {
        education.name = schoolNameField.text.toString()
        education.program = programNameField.text.toString()

        education.startDate = educationStartDateField.text.toString().parseMonthFormat()
        education.endDate = educationEndDateField.text.toString().parseMonthFormat()

        education.gpa = try {
            binding.tvGpa.text.toString().toDouble()
        } catch (e: Exception) {
            0.0
        }

        if (validateFields()) {
            observe(isUpdateObservable) {
                if (it == true) {
                    viewModel.updateEducation(education)
                } else viewModel.addEducation(education)
                navController.navigateUp()
            }
        }
    }

    private fun validateFields(): Boolean {
        when {
            education.name.isEmpty() -> {
                schoolNameField.error = getString(R.string.enter_school_name)
                toast(getString(R.string.enter_school_name))
                return false
            }
            education.program.isEmpty() -> {
                programNameField.error = getString(R.string.enter_program)
                toast(getString(R.string.enter_program))
                return false

            }
            education.startDate.isEmpty() -> {
                educationStartDateField.error = getString(R.string.enter_start_date)
                toast(getString(R.string.enter_start_date))
                return false

            }
            education.endDate.isEmpty() -> {
                educationEndDateField.error = getString(R.string.enter_end_date)
                toast(getString(R.string.enter_end_date))
                return false

            }
            education.gpa == 0.0 -> {
                tv_gpa.error = "Enter your GPA"
                toast("Enter your GPA")
                return false

            }
            else -> return true
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
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
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

    override fun onBackButtonClicked() {
        navController.navigateUp()
    }
}

