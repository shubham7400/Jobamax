package com.jobamax.appjobamax.jobseeker.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogJobSeekerThreadFilterBinding
import com.jobamax.appjobamax.jobseeker.chat.SeekerChatListFragment
import kotlinx.android.synthetic.main.dailog_wishlist_filter.*

class DialogJobSeekerThreadFilter(var activity: Activity, private val appliedFilter: SeekerChatListFragment.SeekerChatListFilter) : Dialog(activity, R.style.DialogTopEndPosition)  {
    lateinit var binding: DialogJobSeekerThreadFilterBinding

    var onFilterOptionClick: (SeekerChatListFragment.SeekerChatListFilter) -> Unit = {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()
        when(appliedFilter){
            SeekerChatListFragment.SeekerChatListFilter.All -> { binding.cbAll.isChecked = true }
            SeekerChatListFragment.SeekerChatListFilter.UNOPENED -> { binding.cbUnopened.isChecked = true }
            SeekerChatListFragment.SeekerChatListFilter.RECENT -> { binding.cbRecent.isChecked = true }
        }
    }

    private fun setUpObservers() {
        iv_arrow_down.setOnClickListener { dismiss() }
        binding.cbAll.setOnCheckedChangeListener { _, _ ->
            binding.cbUnopened.isChecked = false
            binding.cbRecent.isChecked = false
            onFilterOptionClick(SeekerChatListFragment.SeekerChatListFilter.All)
            dismiss()
        }
        binding.cbUnopened.setOnCheckedChangeListener { _, _ ->
            binding.cbAll.isChecked = false
            binding.cbRecent.isChecked = false
            onFilterOptionClick(SeekerChatListFragment.SeekerChatListFilter.UNOPENED)
            dismiss()
        }
        binding.cbRecent.setOnCheckedChangeListener { _, _ ->
            binding.cbAll.isChecked = false
            binding.cbUnopened.isChecked = false
            onFilterOptionClick(SeekerChatListFragment.SeekerChatListFilter.RECENT)
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogJobSeekerThreadFilterBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}