package com.findajob.jobamax.dialog

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.findajob.jobamax.R
import com.findajob.jobamax.model.Event
import com.findajob.jobamax.util.retrieveDate
import com.findajob.jobamax.util.startOfDay
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import java.text.SimpleDateFormat
import java.util.*


class AddEventDialog(
    private val activity: Activity,
    private val providedOrganiser: ParseObject,
    private val selectedRoom: ParseObject?,
    private var getEvent: (event: Event) -> Unit
) : Dialog(activity) {

    lateinit var etName: EditText
    lateinit var dpDate: DatePicker
    lateinit var btnSave: Button
    lateinit var tvSkipButton: TextView
    var isNameGotten = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.dialog_add_event)

        window?.apply {
            setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
        }

        etName = findViewById(R.id.etName)
        dpDate = findViewById(R.id.dpDate)
        btnSave = findViewById(R.id.btnSave)
        tvSkipButton = findViewById(R.id.tvSkipButton)
    }

    private fun setUpObservers() {


        if (!isNameGotten) {
            dpDate.visibility = View.GONE
            etName.visibility = View.VISIBLE
            toggleButtonName()
        }

        btnSave.setOnClickListener {

            if (!isNameGotten) {
                isNameGotten = true
                hideKeyboard()
                etName.visibility = View.GONE
                dpDate.visibility = View.VISIBLE
                toggleButtonName()
            } else {
                dismiss()
                Event().apply {
                    name = etName.text.toString()
                    val dateAndDay = getDateAndDay()
                    date = dateAndDay.first
                    day = dateAndDay.second
                    interest = selectedRoom
                    organiser = providedOrganiser
                }.also {
                    getEvent(it)
                }
            }
        }


        tvSkipButton.setOnClickListener {
            dismiss()
            activity.toast("You didn't save an event.")
        }


    }


    private fun toggleButtonName() {

        if (!isNameGotten) {
            btnSave.text = activity.getString(R.string.next)
        } else {
            btnSave.text = activity.getString(R.string.save)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDateAndDay(): Pair<Date, String> {
        val date = dpDate.retrieveDate().startOfDay()

        val dateFormat = SimpleDateFormat("EEEE")
        val day = dateFormat.format(date)

        return Pair(date, day)
    }


    private fun hideKeyboard() {
        this.currentFocus?.let { view ->
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}