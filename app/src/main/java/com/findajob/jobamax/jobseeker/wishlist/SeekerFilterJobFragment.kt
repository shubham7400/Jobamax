package com.findajob.jobamax.jobseeker.wishlist

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.findajob.jobamax.databinding.FragmentSeekerFilterJobBinding
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.util.log


class SeekerFilterJobFragment( ) : DialogFragment() {
    lateinit var binding: FragmentSeekerFilterJobBinding
    var onGoClickListener: (SeekerWishlistJobFilter) -> Unit = {}
    var filteredJob = SeekerWishlistJobFilter.ALL

    var all = 0
    var favorite = 0
    var archive = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerFilterJobBinding.inflate(inflater, container, false)
        this.all = arguments?.getInt("all") ?: 0
        this.favorite = arguments?.getInt("favorite") ?: 0
        this.archive = arguments?.getInt("archive") ?: 0
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        binding.tvAll.text = binding.tvAll.text.toString()+" ($all)"
        binding.tvFavorite.text = binding.tvFavorite.text.toString()+" ($favorite)"
        binding.tvArchive.text = binding.tvArchive.text.toString()+" ($archive)"
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            dismiss()
        }
        binding.cbAll.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbFavorite.isChecked = false
                binding.cbArchive.isChecked = false
                filteredJob = SeekerWishlistJobFilter.ALL
            }
        }
        binding.cbFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbArchive.isChecked = false
                filteredJob = SeekerWishlistJobFilter.FAVORITE
            }
        }
        binding.cbArchive.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbFavorite.isChecked = false
                binding.cbAll.isChecked = false
                filteredJob = SeekerWishlistJobFilter.ARCHIVE
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

    fun newInstance(all: Int, favorite: Int, archive: Int): SeekerFilterJobFragment {
        val fragment = SeekerFilterJobFragment()
        val args = Bundle()
        args.putInt("all", all)
        args.putInt("favorite", favorite)
        args.putInt("archive", archive)
        fragment.arguments = args
        return fragment
    }
 }