package com.findajob.jobamax.dialog

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.findajob.jobamax.R
import com.findajob.jobamax.training.ui.ManageRoomViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_room_invite.*


class RoomInviteDialog(val viewModel: ManageRoomViewModel, val activity: Activity) : BottomSheetDialog(activity, R.style.SheetDialog) {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestWindowFeature(Window.FEATURE_NO_TITLE)
		setContentView(R.layout.dialog_room_invite)
		window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
		window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
		button.setOnClickListener {
			this@RoomInviteDialog.dismiss()
			viewModel.sendInvite(roomField.text.toString())
		}
	}
}
