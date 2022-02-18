package com.findajob.jobamax.jobseeker.track.newtrack

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
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBinding
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.jobseeker.wishlist.SeekerFilterJobFragment


class SeekerTrackingJobFilterDialogFragment : DialogFragment() {
    lateinit var binding: FragmentSeekerTrackingJobFilterDialogBinding
    var onGoClickListener: (String) -> Unit = {}
    var filteredJob = SeekerWishlistJobFilter.ALL.name

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerTrackingJobFilterDialogBinding.inflate(inflater, container, false)
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
        binding.cbAll.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbFavorite.isChecked = false
                binding.cbArchive.isChecked = false
                filteredJob = SeekerWishlistJobFilter.ALL.name
            }
        }
        binding.cbFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbArchive.isChecked = false
                filteredJob = SeekerWishlistJobFilter.FAVORITE.name
            }
        }
        binding.cbArchive.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbFavorite.isChecked = false
                binding.cbAll.isChecked = false
                filteredJob = SeekerWishlistJobFilter.ARCHIVE.name
            }
        }
        binding.btnGo.setOnClickListener {
            // call onGoClickListener and create that listener parameter and pass in it whatever you want.
            onGoClickListener(filteredJob)
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
        fun newInstance(): SeekerTrackingJobFilterDialogFragment = SeekerTrackingJobFilterDialogFragment()
    }
}