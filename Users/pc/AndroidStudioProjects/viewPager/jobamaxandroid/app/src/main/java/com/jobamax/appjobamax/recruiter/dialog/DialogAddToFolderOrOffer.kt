package com.jobamax.appjobamax.recruiter.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogAddToFolderOrOfferBinding
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.SeekerFolder
import com.jobamax.appjobamax.util.getShader

class DialogAddToFolderOrOffer(var activity: Activity, private val _jobTitleFilterList: List<JobTitleFilter>?, private val _seekerFolders: HashSet<SeekerFolder>? , val onJobSelection: (JobTitleFilter) -> Unit, val onSeekerFolderSelection: (SeekerFolder) -> Unit) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogAddToFolderOrOfferBinding

    private val jobTitleFilterList = arrayListOf<JobTitleFilter>()

    private val seekerFolders = arrayListOf<SeekerFolder>()

    var selectedJobTitleFilter: JobTitleFilter? = null
    var selectedSeekerFolder: SeekerFolder? = null

    private lateinit var seekerFolderSpinnerAdapter: SeekerFolderSpinnerAdapter
    private lateinit var jobTitleFilterSpinnerAdapter: JobTitleFilterSpinnerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jobTitleFilterList.clear()
        jobTitleFilterList.add(JobTitleFilter("","Votre offre d'emploi: :"))
        _jobTitleFilterList?.forEach { jobTitleFilterList.add(it) }

        seekerFolders.clear()
        seekerFolders.add(SeekerFolder("Offre d'emploi",""))
        _seekerFolders?.forEach { seekerFolders.add(it) }

        initViews()
    }


    private fun initViews() {
        setUpDialogView()
        setClickListeners()
        setJobTitleFilterSpinnerAdapter()
        setSeekerFoldersSpinnerAdapter()
    }

    private fun setSeekerFoldersSpinnerAdapter() {
        seekerFolderSpinnerAdapter = SeekerFolderSpinnerAdapter(activity, R.layout.item_textview, seekerFolders )
        binding.spOffer.adapter = seekerFolderSpinnerAdapter
        binding.spOffer.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (seekerFolders[position].folderId.isNotEmpty()) {
                    selectedSeekerFolder = seekerFolders[position]
                    setJobTitleFilterSpinnerAdapter()
                    selectedJobTitleFilter = null
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        seekerFolderSpinnerAdapter.onTitleClick = {
            binding.spOffer.onDetachedFromWindow()
        }
    }

    private fun setJobTitleFilterSpinnerAdapter() {
        jobTitleFilterSpinnerAdapter = JobTitleFilterSpinnerAdapter(activity, R.layout.item_textview, jobTitleFilterList)
        binding.spJobSeekerFolder.adapter = jobTitleFilterSpinnerAdapter
        binding.spJobSeekerFolder.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (jobTitleFilterList[position].jobOfferId.isNotEmpty()) {
                    selectedJobTitleFilter = jobTitleFilterList[position]
                    setSeekerFoldersSpinnerAdapter()
                    selectedSeekerFolder = null
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        jobTitleFilterSpinnerAdapter.onTitleClick = {
            binding.spJobSeekerFolder.onDetachedFromWindow()
        }
    }



    private fun setClickListeners() {
        binding.btnSort.setOnClickListener {
            if (selectedSeekerFolder != null) {
                onSeekerFolderSelection(selectedSeekerFolder!!)
                dismiss()
            }else if (selectedJobTitleFilter != null){
                onJobSelection(selectedJobTitleFilter!!)
                dismiss()
            }else{
                activity.toast("Please select something.")
            }
        }

    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddToFolderOrOfferBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }



}


class SeekerFolderSpinnerAdapter(private val activity: Activity, id: Int, var list: List<SeekerFolder>) : ArrayAdapter<SeekerFolder>(activity, id, list) {
    var onTitleClick: () -> Unit = {}
    var onAddMoreClick: () -> Unit = {}
    var folderId = ""
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].name
        if (position == 0){
            tv.paint.shader = activity.getShader(tv)
            tv.textSize = 20f
            tv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_up_gradient,0)
            tv.setOnClickListener { onTitleClick() }
        }else{
            if (tv.text.toString() == "Poster une nouvelle offre"){
                tv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_add_gradient_holo,0)
                tv.setOnClickListener {
                    onAddMoreClick()
                }
            }else{
                tv.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            }
            if (folderId == list[position].folderId && folderId.isNotEmpty()){
                tv.setBackgroundColor( activity.resources.getColor(R.color.greyishWhite,null))
            }
        }
        return  view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].name
        if (position != 0){
            folderId = list[position].folderId
        }
        return view
    }


    override fun isEnabled(position: Int): Boolean {
        super.isEnabled(position)
        return position != 0
    }

}