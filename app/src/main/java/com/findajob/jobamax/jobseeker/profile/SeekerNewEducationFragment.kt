package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerNewEducationBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.util.mm_yy_disp
import com.findajob.jobamax.util.toast
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.util.*


class SeekerNewEducationFragment : BaseFragmentMain<FragmentSeekerNewEducationBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_new_education
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var educationOld: Education? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerNewEducationBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    override fun onCreated(savedInstance: Bundle?) {
        arguments?.getSerializable("education")?.let {
            educationOld = arguments?.getSerializable("education") as Education
        }
        educationOld?.let {
            binding.etSchool.setText(educationOld!!.name)
            binding.etProgram.setText(educationOld!!.program)
            binding.etGpa.setText(educationOld!!.gpa.toString())
            binding.tvStartDate.text = educationOld!!.startDate
            if (educationOld!!.endDate == ""){
                val calendar = Calendar.getInstance(TimeZone.getDefault());
                binding.tvEndDate.text = "${calendar.get(Calendar.DAY_OF_MONTH)}/ ${calendar.get(Calendar.MONTH) + 1}/ ${calendar.get(Calendar.YEAR)}"
            }else{
                binding.tvEndDate.text = educationOld!!.endDate
            }
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            (activity as SeekerProfileActivity).onBackPressed()
        }
        binding.tvStartDate.setOnClickListener {
            onDateClicked(binding.tvStartDate)
        }
        binding.tvEndDate.setOnClickListener {
            onDateClicked(binding.tvEndDate)
        }
        binding.btnSaveInfo.setOnClickListener {
            when {
                binding.etSchool.text.isNullOrEmpty() -> {
                    toast("Enter school name.")
                }
                binding.etProgram.text.isNullOrEmpty() -> {
                    toast("Enter program name.")
                }
                binding.etGpa.text.isNullOrEmpty() -> {
                    toast("Enter education level name.")
                }
                binding.tvStartDate.text.isNullOrEmpty() -> {
                    toast("Select start date.")
                }
                else -> {
                   val education = if (educationOld != null){
                       educationOld
                   }else{
                       Education()
                   }
                    education!!.name = binding.etSchool.text.toString()
                    education.program = binding.etProgram.text.toString()
                    education.gpa = binding.etGpa.text.toString().toDouble()
                    education.startDate = binding.tvStartDate.text.toString()
                    if (binding.tvEndDate.text.isNullOrEmpty()){
                        education.endDate =  ""
                    }else{
                        education.endDate =  binding.tvEndDate.text.toString()
                    }
                     viewModel.addNewOrUpdateEducation(education) {
                         if (it == null){
                             toast("Education added")
                             requireActivity().onBackPressed()
                         }else{
                             toast("${it.message.toString()} Something went wrong")
                         }
                     }
                }
            }
        }
    }


    fun onDateClicked(view: View ) {
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

}