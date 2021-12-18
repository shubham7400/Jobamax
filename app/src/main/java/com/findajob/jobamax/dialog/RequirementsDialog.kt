package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.util.inflate
import kotlinx.android.synthetic.main.dialog_requirements.*
import kotlinx.android.synthetic.main.item_requirements.view.*

class RequirementsDialog(
    var activity: Activity,
    var requirementsList: ArrayList<String>,
    private val isRequested: Boolean,
    val onButtonClicked: (button: SubmitButton, arrChecked: ArrayList<String>) -> Unit
) : Dialog(activity), View.OnClickListener{


    private lateinit var tvNotificationBody: TextView
    private lateinit var btnPositive: Button
    private lateinit var btnNegative: Button
    lateinit var reqAdapter: RequirementsAdapter
    val arrCheckBoxes = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()

        tvNotificationBody = findViewById(R.id.tvNotificationBody)
        btnPositive = findViewById(R.id.btnPositive)
        btnNegative = findViewById(R.id.btnNegative)
        val cb0 = findViewById<CheckBox>(R.id.checkbox_0)
        val cb1 = findViewById<CheckBox>(R.id.checkbox_1)
        val cb2 = findViewById<CheckBox>(R.id.checkbox_2)
        val cb3 = findViewById<CheckBox>(R.id.checkbox_3)
        val cb4 = findViewById<CheckBox>(R.id.checkbox_4)
        cb0.setOnClickListener(this)
        cb1.setOnClickListener(this)
        cb2.setOnClickListener(this)
        cb3.setOnClickListener(this)
        cb4.setOnClickListener(this)

        if(!isRequested) {
            checkboxGroup.visibility = View.GONE
            reqAdapter = RequirementsAdapter()
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = reqAdapter
            reqAdapter.notifyListChanged(requirementsList.toList())
        } else {
            recyclerView.visibility = View.GONE
        }

        for(item in requirementsList) {
            if(cb0.text.contains(item)) cb0.performClick()
            if(cb1.text.contains(item)) cb1.performClick()
            if(cb2.text.contains(item)) cb2.performClick()
            if(cb3.text.contains(item)) cb3.performClick()
            if(cb4.text.contains(item)) cb4.performClick()
        }
    }

    private fun setUpObservers() {
        btnNegative.setOnClickListener {
            onButtonClicked(SubmitButton.NEGATIVE, arrayListOf())
            dismiss()
        }

        btnPositive.setOnClickListener {
            onButtonClicked(SubmitButton.POSITIVE, arrCheckBoxes)
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_requirements)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    enum class SubmitButton{
        POSITIVE,
        NEGATIVE,
    }

    override fun onClick(view: View?) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            if(checked) {
                arrCheckBoxes.add(view.text.toString())
            } else {
                arrCheckBoxes.remove(view.text.toString())
            }
        }
    }

}

class RequirementsAdapter() : RecyclerView.Adapter<RequirementsAdapter.ShowRequirementsViewHolder>() {

    private var requirements: List<String> = listOf()

    fun notifyListChanged(requirement: List<String>) {
        this.requirements = requirement
        notifyDataSetChanged()
    }

    inner class ShowRequirementsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTo(item: String) {
            itemView.tvRequirement.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ShowRequirementsViewHolder(parent.inflate(R.layout.item_requirements))

    override fun onBindViewHolder(holder: ShowRequirementsViewHolder, position: Int) = holder.bindTo(requirements[position])

    override fun getItemCount(): Int = requirements.size
}