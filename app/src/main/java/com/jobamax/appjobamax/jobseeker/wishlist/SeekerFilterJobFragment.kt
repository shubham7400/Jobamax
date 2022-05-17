package com.jobamax.appjobamax.jobseeker.wishlist

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.jobamax.appjobamax.databinding.FragmentSeekerFilterJobBinding
import com.jobamax.appjobamax.enums.SeekerWishlistJobFilter


class SeekerFilterJobFragment( ) : DialogFragment() {
    lateinit var binding: FragmentSeekerFilterJobBinding
    var onGoClickListener: (SeekerWishlistJobFilter) -> Unit = {}
    var selectedFilter = SeekerWishlistJobFilter.ALL

    var all = 0
    var favorite = 0
    var archive = 0
    var inProgress = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerFilterJobBinding.inflate(inflater, container, false)
        this.all = arguments?.getInt("all") ?: 0
        this.favorite = arguments?.getInt("favorite") ?: 0
        this.archive = arguments?.getInt("archive") ?: 0
        this.inProgress = arguments?.getInt("in_progress") ?: 0
        this.selectedFilter = arguments?.get("selected_filter") as SeekerWishlistJobFilter
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.tvAll.text = binding.tvAll.text.toString()+" ($all)"
        binding.tvFavorite.text = binding.tvFavorite.text.toString()+" ($favorite)"
        binding.tvArchive.text = binding.tvArchive.text.toString()+" ($archive)"
        binding.tvInProgress.text = binding.tvInProgress.text.toString()+" ($inProgress)"
        when(selectedFilter){
            SeekerWishlistJobFilter.ALL -> {
                binding.cbAll.isChecked = true
            }
            SeekerWishlistJobFilter.ARCHIVE -> {
                binding.cbArchive.isChecked = true
            }
            SeekerWishlistJobFilter.FAVORITE -> {
                binding.cbFavorite.isChecked = true
            }
            SeekerWishlistJobFilter.IN_PROGRESS -> {
                binding.cbInProgress.isChecked = true
            }
        }
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.cbAll.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbInProgress.isChecked = false
                binding.cbFavorite.isChecked = false
                binding.cbArchive.isChecked = false
                selectedFilter = SeekerWishlistJobFilter.ALL
                onGoClickListener(selectedFilter)
                dismiss()
            }
        }
        binding.cbFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbInProgress.isChecked = false
                binding.cbAll.isChecked = false
                binding.cbArchive.isChecked = false
                selectedFilter = SeekerWishlistJobFilter.FAVORITE
                onGoClickListener(selectedFilter)
                dismiss()
            }
        }
        binding.cbArchive.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbInProgress.isChecked = false
                binding.cbFavorite.isChecked = false
                binding.cbAll.isChecked = false
                selectedFilter = SeekerWishlistJobFilter.ARCHIVE
                onGoClickListener(selectedFilter)
                dismiss()
            }
        }
        binding.cbInProgress.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbInProgress.isChecked = false
                binding.cbFavorite.isChecked = false
                binding.cbAll.isChecked = false
                selectedFilter = SeekerWishlistJobFilter.IN_PROGRESS
                onGoClickListener(selectedFilter)
                dismiss()
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(InsetDrawable(ColorDrawable(Color.TRANSPARENT), 20, 10, 20, 10))
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    fun newInstance(
        all: Int,
        favorite: Int,
        archive: Int,
        inProgress: Int,
        selectedFilter: SeekerWishlistJobFilter
    ): SeekerFilterJobFragment {
        val fragment = SeekerFilterJobFragment()
        val args = Bundle()
        args.putInt("all", all)
        args.putInt("favorite", favorite)
        args.putInt("archive", archive)
        args.putInt("in_progress", inProgress)
        args.putSerializable("selected_filter", selectedFilter)
        fragment.arguments = args
        return fragment
    }
 }