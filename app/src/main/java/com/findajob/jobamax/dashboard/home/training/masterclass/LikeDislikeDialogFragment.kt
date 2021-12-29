package com.findajob.jobamax.dashboard.home.training.masterclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.findajob.jobamax.databinding.FragmentLikeDislikeDialogBinding
import android.R
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.findajob.jobamax.data.pojo.Category
import org.jetbrains.anko.internals.AnkoInternals.createAnkoContext


class LikeDislikeDialogFragment : DialogFragment(), View.OnClickListener {
    lateinit var binding: FragmentLikeDislikeDialogBinding
    internal var clickListener: (Int) -> Unit = { _ -> }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
         binding = FragmentLikeDislikeDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivLike.setOnClickListener(this)
        binding.ivDislike.setOnClickListener(this)
        binding.ivCancel.setOnClickListener(this)
    }

    companion object{
        val LIKE = 1
        val DISLIKE = -1
        fun newInstance(): LikeDislikeDialogFragment = LikeDislikeDialogFragment()
    }

    override fun onClick(view: View?) {
         when(view){
             binding.ivLike -> {
                 clickListener(LIKE)
                 dismiss()
             }
             binding.ivDislike -> {
                 clickListener(DISLIKE)
                dismiss()
             }
             binding.ivCancel -> {
                dismiss()
             }
         }
    }

}