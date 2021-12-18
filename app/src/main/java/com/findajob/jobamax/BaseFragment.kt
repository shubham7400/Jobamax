package com.findajob.jobamax

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kaopiz.kprogresshud.KProgressHUD
import com.uxcam.UXCam

open class BaseFragment : Fragment() {
	
	lateinit var progressHud: KProgressHUD
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		progressHud = KProgressHUD.create(requireActivity())
			.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
			.setCancellable(false)
			.setAnimationSpeed(2)
			.setDimAmount(0.5f)

		setupUxCam()
	}

	private fun setupUxCam(){
		// get the name of concrete class
		UXCam.tagScreenName(this::class.java.simpleName)
	}
}