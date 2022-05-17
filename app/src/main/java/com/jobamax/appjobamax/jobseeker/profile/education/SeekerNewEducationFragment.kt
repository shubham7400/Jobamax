package com.jobamax.appjobamax.jobseeker.profile.education

 import android.os.Bundle
 import android.text.Editable
 import android.text.TextWatcher
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import android.widget.TextView
 import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
 import androidx.recyclerview.widget.RecyclerView
 import com.jobamax.appjobamax.DatePickerDialogFragment
 import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.Education
import com.jobamax.appjobamax.data.pojo.University
import com.jobamax.appjobamax.databinding.FragmentSeekerNewEducationBinding
 import com.jobamax.appjobamax.databinding.ItemSeekerSearchUniversityBinding
 import com.jobamax.appjobamax.enums.ParseTableName
 import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
 import com.jobamax.appjobamax.jobseeker.profile.idealjob.IOnBackPressed
 import com.jobamax.appjobamax.preference.getLanguage
 import com.jobamax.appjobamax.util.*
 import com.parse.ParseObject
 import com.parse.ParseQuery
 import java.lang.Exception
 import java.util.*


class SeekerNewEducationFragment : BaseFragmentMain<FragmentSeekerNewEducationBinding>(), IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_seeker_new_education
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var educationOld: Education? = null
    var university: University? = null
    var canFetchList = true
    lateinit var adapter: SeekerSearchUniversityAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerNewEducationBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.etSchool.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etSchool.text.isNullOrEmpty()){
                    binding.rvUniversities.visibility = View.GONE
                }else{
                    if (canFetchList){
                        university = null
                        getUniversities {
                            val universities = arrayListOf<University>()
                            for (obj in it.iterator()){
                                universities.add(University(null, obj.getString("logo") ?: "", obj.getString("name") ?: "", null))
                            }
                            adapter.submitList(universities)
                            adapter.notifyDataSetChanged()
                            if (universities.isNotEmpty()){
                                binding.rvUniversities.visibility = View.VISIBLE
                            }
                        }
                    }
                    canFetchList = true
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        setAdapterFunctionality()

        binding.jobSeeker = viewModel.jobSeeker
        setClickListeners()
        if (binding.cbCurrentStudent.isChecked){
            binding.clEndDate.visibility = View.GONE
        }else{
            binding.clEndDate.visibility = View.VISIBLE
        }
    }

    private fun updateView() {
        if (binding.tvStartDate.text.isNotEmpty()) {
            binding.ivClearStartDate.visibility = View.VISIBLE
        } else {
            binding.ivClearStartDate.visibility = View.GONE
        }
        if (binding.tvEndDate.text.isNotEmpty()) {
            binding.ivClearEndDate.visibility = View.VISIBLE
        } else {
            binding.ivClearEndDate.visibility = View.GONE
        }
        binding.ivClearStartDate.setOnClickListener {
            binding.tvStartDate.text = ""
            binding.ivClearStartDate.visibility = View.GONE
        }
        binding.ivClearEndDate.setOnClickListener {
            binding.tvEndDate.text = ""
            binding.ivClearEndDate.visibility = View.GONE
        }
    }

    private fun setAdapterFunctionality() {
        adapter = SeekerSearchUniversityAdapter(arrayListOf())
        binding.rvUniversities.adapter = adapter
        adapter.clickListener = { company ->
            university = company
            binding.rvUniversities.visibility = View.GONE
            canFetchList = false
            binding.etSchool.setText(university?.name)
        }
    }

    private fun getUniversities(result: (List<ParseObject>) -> Unit) {
        val query = ParseQuery<ParseObject>(ParseTableName.UNIVERSITY.value)
        query.whereMatches("name",  "^.*?((?i)(${binding.etSchool.text})).*$")
        query.findInBackground { res, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                else -> {
                    result(res)
                }
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        arguments?.getSerializable("education")?.let {
            educationOld = arguments?.getSerializable("education") as Education
        }
        educationOld?.let {
            canFetchList = false
            binding.etSchool.setText(educationOld!!.name)
            binding.etProgram.setText(educationOld!!.program)
            binding.etDescription.setText( educationOld!!.description)
            binding.etGpa.setText(educationOld!!.gpa.toString())
            binding.tvStartDate.text = educationOld!!.startDate
            if (educationOld!!.startDate == ""){

            }else{
                binding.tvStartDate.text = educationOld!!.startDate
                binding.tvEndDate.text = educationOld!!.endDate
            }
            binding.rvUniversities.visibility = View.GONE
        }
        updateView()
    }

    private fun setClickListeners() {
        binding.cbCurrentStudent.setOnClickListener {
            if (binding.cbCurrentStudent.isChecked){
                binding.clEndDate.visibility = View.GONE
            }else{
                binding.clEndDate.visibility = View.VISIBLE
            }
        }
        binding.ivUserProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerNewEducationFragment_to_seekerProfileFragment, null))
       binding.ivBackButton.setOnClickListener {
           requireActivity().onBackPressed()
       }
        binding.tvStartDate.setOnClickListener {
            onDateClicked(binding.tvStartDate)
        }
        binding.tvEndDate.setOnClickListener {
            onDateClicked(binding.tvEndDate)
        }
        binding.clMostParent.setOnClickListener {
            binding.rvUniversities.visibility = View.GONE
        }
    }


    private fun onDateClicked(view: View ) {
        val datePickerDialogFragment = DatePickerDialogFragment()
        datePickerDialogFragment.show(childFragmentManager, "datePicker")
        datePickerDialogFragment.selectedDate = { date ->
            (view as TextView).text = date.MMM_d_yyyy(requireContext().getLanguage())
            updateView()
        }
    }

    override fun onBackPressed(callback: () -> Unit) {
        when {
            binding.etSchool.text.isNullOrEmpty() -> {
                toast("Enter school name.")
                callback()
            }
           /* binding.etProgram.text.isNullOrEmpty() -> {
                toast("Enter program name.")
                callback()
            }
            binding.etGpa.text.isNullOrEmpty() -> {
                toast("Enter education level name.")
                callback()
            }
            binding.tvStartDate.text.isNullOrEmpty() -> {
                toast("Select start date.")
                callback()
            }
            !binding.cbCurrentStudent.isChecked && binding.tvEndDate.text.isNullOrEmpty() -> {
                toast("Select end date.")
                callback()
            }
            binding.etDescription.text.isNullOrEmpty() -> {
                toast("Enter description.")
                callback()
            }*/
            else -> {
                val education = if (educationOld != null){
                    educationOld
                }else{
                    Education()
                }
                education!!.name = binding.etSchool.text.toString()
                education.program = binding.etProgram.text.toString()
                education.description = binding.etDescription.text.toString()
                education.gpa = try {
                    binding.etGpa.text.toString().toDouble()
                }catch (e: Exception){0.0}
                education.startDate = binding.tvStartDate.text.toString()
                education.logo = university?.logo ?: ""
                if (binding.cbCurrentStudent.isChecked){
                    education.endDate =  ""
                }else{
                    education.endDate =  binding.tvEndDate.text.toString()
                }
                viewModel.addNewOrUpdateEducation(education) {
                    if (it == null){
                        toast("Education added")
                        callback()
                    }else{
                        toast("${it.message.toString()} Something went wrong")
                        callback()
                    }
                }
            }
        }
    }

}

class SeekerSearchUniversityAdapter(var list: ArrayList<University>) : RecyclerView.Adapter<SeekerSearchUniversityAdapter.ViewHolder>(){
    var clickListener: (University) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerSearchUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = list[position]
        holder.binding.apply {
            loadImageFromUrl(this.civUniversityImg, university.logo)
            this.rvUniversityName.text = university.name
            this.tvCountryName.text = university.country
            this.clParent.setOnClickListener {
                clickListener(university)
            }
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(universities: ArrayList<University>) {
        list = universities
    }
    class ViewHolder(val binding: ItemSeekerSearchUniversityBinding) : RecyclerView.ViewHolder(binding.root)
}
