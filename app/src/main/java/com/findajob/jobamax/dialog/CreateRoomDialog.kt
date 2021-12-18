package com.findajob.jobamax.dialog

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import com.findajob.jobamax.R
import com.findajob.jobamax.util.toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_create_room.*

class CreateRoomDialog(val activity: Activity, val interestList: List<String>, val createRoom: (name: String, category: String) -> Unit) : BottomSheetDialog(activity, R.style.SheetDialog) {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_create_room)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val aa = ArrayAdapter(context, android.R.layout.simple_spinner_item, interestList)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(spinnerCategory)
        {
            adapter = aa
            setSelection(0, false)
            prompt = "Select a category"
            gravity = Gravity.CENTER

        }
        createRoomButton.setBackgroundResource(R.drawable.bg_button_gradient)
        createRoomButton.setOnClickListener {
            
            if (roomField.text.toString().trim().isEmpty()) {
                activity.toast("Enter Room")
            } else {
                createRoom(roomField.text.toString().trim(), spinnerCategory.selectedItem.toString())
                this@CreateRoomDialog.dismiss()
            }
        }
    }
}
