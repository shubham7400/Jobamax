package com.findajob.jobamax.jobseeker.calender

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.Phase
import com.findajob.jobamax.databinding.CalendarCellBinding
import com.findajob.jobamax.databinding.FragmentSeekerCalenderBinding
import com.findajob.jobamax.databinding.ItemCalenderEventCardBinding
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import dagger.hilt.android.AndroidEntryPoint
 import org.json.JSONObject
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList



@AndroidEntryPoint
class SeekerCalenderFragment : BaseFragmentMain<FragmentSeekerCalenderBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_calender
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

     var phases = ArrayList<Phase>()
    private lateinit var calendarAdapter: CalendarAdapter

    lateinit var selectedDate: LocalDate

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerCalenderBinding.inflate(inflater, container, false)
        configureUi()
        selectedDate = LocalDate.now()
        setMonthView()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setMonthView() {
        binding.monthYearTV.text =    monthYearFromDate(selectedDate)
        val daysInMonth: java.util.ArrayList<String> = daysInMonthArray(selectedDate)
        calendarAdapter = CalendarAdapter(daysInMonth, phases, selectedDate)
        binding.calendarRecyclerView.adapter = calendarAdapter
        calendarAdapter.onDateClick = {
            if (it != "") {
                showClickedDateEvents(it)
            }
        }
        binding.btnNextMonth.setOnClickListener {
            nextMonthAction()
        }
        binding.btnPreviousMonth.setOnClickListener {
            previousMonthAction()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showClickedDateEvents(dayOfMonth: String) {
        val selectedDateEvents = ArrayList<Phase>()
        val monthFormatter = DateTimeFormatter.ofPattern("MMMM")
        val yearFormatter = DateTimeFormatter.ofPattern("yyyy")
        var sdf = SimpleDateFormat("MMM dd, yyyy")
        val clickedDate = sdf.parse(selectedDate.format(monthFormatter)+" $dayOfMonth"+", "+selectedDate.format(yearFormatter))
        phases.forEach {
            var date: Date? = null
            try {
                sdf = SimpleDateFormat("MMM dd, yyyy")
                date = sdf.parse(it.date)
            }catch (e: Exception){
                sdf = SimpleDateFormat("MMM dd, yyyy", Locale.FRANCE)
                date = sdf.parse(it.date)
            }
            if (date != null) {
                if (date.compareTo(clickedDate) == 0){
                    selectedDateEvents.add(it)
                }
            }
        }
        binding.rvEvents.adapter = SelectedDateEventAdapter(selectedDateEvents, dayOfMonth)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun monthYearFromDate(date: LocalDate): String? {
        val formatter = DateTimeFormatter.ofPattern("MMMM yyyy")
        return date.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun daysInMonthArray(date: LocalDate): java.util.ArrayList<String> {
        val daysInMonthArray = java.util.ArrayList<String>()
        val yearMonth = YearMonth.from(date)
        val daysInMonth = yearMonth.lengthOfMonth()
        val firstOfMonth = selectedDate.withDayOfMonth(1)
        val dayOfWeek = firstOfMonth.dayOfWeek.value
        for (i in 1..42) {
            if (i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
                daysInMonthArray.add("")
            } else {
                daysInMonthArray.add((i - dayOfWeek).toString())
            }
        }
        return daysInMonthArray
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun previousMonthAction() {
        selectedDate = selectedDate.minusMonths(1)
        setMonthView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun nextMonthAction() {
        selectedDate = selectedDate.plusMonths(1)
        setMonthView()
    }

    private fun configureUi() {
        setClickListeners()
        getCalendarData()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
            progressHud.dismiss()
            if (it) {
                binding.jobSeeker = viewModel.jobSeeker
            }
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun getCalendarData(){
        ParseCloud.callFunctionInBackground("getTrackingList", hashMapOf(ParseTableFields.jobSeekerId.toString() to requireContext().getUserId()), FunctionCallback<Any> { response, e ->
            when {
                e != null ->{
                    toast("${e.message.toString()}")
                }
                response == null -> {
                    toast("result not found.")
                }
                else -> {
                    val mainObject = JSONObject(Gson().toJson(response))
                    val list = mainObject.getJSONArray("data")
                    phases.clear()
                    var i = 0
                    while (i < list.length()){
                        phases.add(Gson().fromJson(list.getJSONObject(i).toString(), Phase::class.java))
                        i++
                    }
                    calendarAdapter.submitList(phases)
                    calendarAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    override fun onCreated(savedInstance: Bundle?) {
        if (viewModel.jobSeekerObject == null){
            lifecycleScope.launchWhenStarted {
                viewModel.getJobSeeker()
            }
        }
        binding.jobSeeker = viewModel.jobSeeker
    }


}

class CalendarAdapter(private val daysOfMonth: java.util.ArrayList<String>, var phases: ArrayList<Phase>, var selectedDate: LocalDate) : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {
    var onDateClick : (String) -> Unit = {}
    var selected_index = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder  = CalendarViewHolder(CalendarCellBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val item = daysOfMonth[position]
        holder.binding.apply {
            this.cellDayText.text = item
            this.cellDayText.setOnClickListener {
                onDateClick(item)
                selected_index = position
                notifyDataSetChanged()
            }
            if (item != ""){
                phases.forEach {
                    var sdf: SimpleDateFormat? = null
                    var date1: Date? = null
                    try {
                        sdf = SimpleDateFormat("MMM dd, yyyy")
                        date1 = sdf.parse(it.date)
                    }catch (e: Exception){
                        sdf = SimpleDateFormat("MMM dd, yyyy", Locale.FRANCE)
                        try {
                            date1 = sdf.parse(it.date)
                        }catch (e: Exception){}
                    }
                    val monthFormatter = DateTimeFormatter.ofPattern("MMMM")
                    val yearFormatter = DateTimeFormatter.ofPattern("yyyy")
                    var date2: Date? = null
                    try {
                        sdf = SimpleDateFormat("MMM dd, yyyy")
                        date2 = sdf.parse(selectedDate.format(monthFormatter)+" $item"+", "+selectedDate.format(yearFormatter))
                    }catch (e: Exception){
                        sdf = SimpleDateFormat("MMM dd, yyyy", Locale.FRANCE)
                        date2 = sdf.parse(selectedDate.format(monthFormatter)+" $item"+", "+selectedDate.format(yearFormatter))
                    }
                    log("fddkfd $date1,  $date2")
                    if (date1 != null) {
                        if (date1.compareTo(date2) == 0){
                            vEventHint.visibility = View.VISIBLE
                        }
                    }
                }
            }
            if (selected_index == position){
                this.cellDayText.setTextColor(Color.WHITE)
                this.cellDayText.setBackgroundResource(R.drawable.bg_gradient_rounded)
                vEventHint.visibility = View.GONE
            }else{
                this.cellDayText.setBackgroundResource(0)
            }
         }
    }
    override fun getItemCount(): Int = daysOfMonth.size
    fun submitList(list: ArrayList<Phase>) {
        phases = list
    }
    class CalendarViewHolder(val binding: CalendarCellBinding) : RecyclerView.ViewHolder(binding.root)
}

class SelectedDateEventAdapter(val list: ArrayList<Phase>,val dayOfMonth: String) : RecyclerView.Adapter<SelectedDateEventAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemCalenderEventCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvDate.text = item.date
            this.tvName.text = item.name
            this.tvTitle.text = item.jobTitle
            if (dayOfMonth.length == 1){
                this.tvDay.text = "0$dayOfMonth"
            }else{
                this.tvDay.text = dayOfMonth
            }
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemCalenderEventCardBinding) : RecyclerView.ViewHolder(binding.root)
}
