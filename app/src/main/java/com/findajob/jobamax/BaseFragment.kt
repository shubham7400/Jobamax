package com.findajob.jobamax

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kaopiz.kprogresshud.KProgressHUD

open class BaseFragment : Fragment() {
	
	lateinit var progressHud: KProgressHUD
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		progressHud = KProgressHUD.create(requireActivity())
			.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
			.setCancellable(false)
			.setAnimationSpeed(2)
			.setDimAmount(0.5f)
	}
}