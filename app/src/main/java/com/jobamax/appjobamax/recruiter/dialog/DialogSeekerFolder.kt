package com.jobamax.appjobamax.recruiter.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogFilterJobRoleWiseBinding
import com.jobamax.appjobamax.databinding.DialogSeekerFolderBinding
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.SeekerFolder

class DialogSeekerFolder(var activity: Activity, private val _seekerFolders: HashSet<SeekerFolder>?, val onContinueClick: (SeekerFolder) -> Unit) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogSeekerFolderBinding

    private val seekerFolders = arrayListOf<SeekerFolder>()

    var selectedSeekerFolder: SeekerFolder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        seekerFolders.clear()
        seekerFolders.add(SeekerFolder("dossier",""))
        _seekerFolders?.forEach { seekerFolders.add(it) }

        initViews()
    }


    private fun initViews() {
        setUpDialogView()
        setClickListeners()
        setJobTitleFilterSpinnerAdapter()
        validateReason()
    }

    private fun validateReason() {
        if (selectedSeekerFolder == null) {
            binding.btnSort.isEnabled = false
            binding.btnSort.background = activity.resources.getDrawable(R.drawable.rounded_grey_box_50, null)
            binding.btnSort.setTextColor(activity.resources.getColor(R.color.navi_blue, null))
        } else {
            binding.btnSort.isEnabled = true
            binding.btnSort.background = activity.resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
            binding.btnSort.setTextColor(activity.resources.getColor(R.color.white, null))
        }
    }

    private fun setJobTitleFilterSpinnerAdapter() {
        val spinnerAdapter = SeekerFolderSpinnerAdapter(activity, R.layout.item_textview, seekerFolders)
        binding.spJobSeekerFolder.adapter = spinnerAdapter
        binding.spJobSeekerFolder.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (seekerFolders[position].folderId.isNotEmpty()) {
                    selectedSeekerFolder = seekerFolders[position]
                    validateReason()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        spinnerAdapter.onTitleClick = {
            binding.spJobSeekerFolder.onDetachedFromWindow()
        }

    }



    private fun setClickListeners() {
        binding.btnSort.setOnClickListener {
            if (selectedSeekerFolder == null) {
                activity.toast("Please select folder first")
            }else{
                onContinueClick(selectedSeekerFolder!!)
                dismiss()
            }
        }
        binding.ivClose.setOnClickListener { dismiss() }

    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogSeekerFolderBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }



}