package com.findajob.jobamax.jobseeker.wishlist

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentSeekerFilterJobBinding
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.jobseeker.profile.account.SeekerSearchUniversityDialogFragment


class SeekerFilterJobFragment : DialogFragment() {
    lateinit var binding: FragmentSeekerFilterJobBinding
    var onGoClickListener: (ArrayList<String>) -> Unit = {}
    var filteredJobTypes = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerFilterJobBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            dismiss()
        }
        binding.btnGo.setOnClickListener {
            // call onGoClickListener and create that listener parameter and pass in it whatever you want.
            filteredJobTypes.clear()
            if (binding.cbAll.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.ALL.name)
            }
            if (binding.cbFavorite.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.FAVORITE.name)
            }
            if (binding.cbApplied.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.APPLIED.name)
            }
            if (binding.cbAssessments.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.ASSESSMENTS.name)
            }
            if (binding.cbHired.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.HIRED.name)
            }
            if (binding.cbInterview.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.INTERVIEW.name)
            }
            if (binding.cbMostRecentOne.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.MOST_RECENT_ONES.name)
            }
            if (binding.cbOnlineIntervie.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.ONLINE_INTERVIEW.name)
            }
            if (binding.cbPhoneCall.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.PHONE_CALL.name)
            }
            if (binding.cbRefused.isChecked){
                filteredJobTypes.add(SeekerWishlistJobFilter.REFUSED.name)
            }
            onGoClickListener(filteredJobTypes)
            dismiss()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

    companion object {
        fun newInstance(): SeekerFilterJobFragment = SeekerFilterJobFragment()
    }
 }