package com.findajob.jobamax.jobseeker.jobsearch

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.data.pojo.Categories
import com.findajob.jobamax.data.pojo.CategoryGroup
import com.findajob.jobamax.databinding.FragmentSeekerJobSearchFilterCategoriesDialogBinding
import com.findajob.jobamax.databinding.ItemJobSearchFilterCategoryBinding
import com.findajob.jobamax.preference.setJobSearchFilterCategories
import com.findajob.jobamax.util.getJobCategories
import com.findajob.jobamax.util.log
import com.google.gson.Gson

class SeekerJobSearchFilterCategoriesDialogFragment : DialogFragment() {
    var onDialogDismiss : () -> Unit = {}
    lateinit var binding: FragmentSeekerJobSearchFilterCategoriesDialogBinding

    private var categories = arrayListOf<Categories>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobSearchFilterCategoriesDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setAdapter()
        binding.ivBackButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        onDialogDismiss()
    }

    private fun setAdapter() {
        categories = getJobCategories(requireContext())
        val adapter =  SeekerJobSearchFilterCategoriesAdapter(categories)
        binding.rvCategories.adapter = adapter
        adapter.onCheckBoxStateChange = { list ->
            requireContext().setJobSearchFilterCategories(Gson().toJson(CategoryGroup(list)))
            adapter.submitList(getJobCategories(requireContext()))
            adapter.notifyDataSetChanged()
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
        fun newInstance(): SeekerJobSearchFilterCategoriesDialogFragment = SeekerJobSearchFilterCategoriesDialogFragment()
    }

}

class SeekerJobSearchFilterCategoriesAdapter(var list: ArrayList<Categories>) : RecyclerView.Adapter<SeekerJobSearchFilterCategoriesAdapter.ViewHolder>(){
    var onCheckBoxStateChange : (ArrayList<Categories>) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemJobSearchFilterCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvText.text = item.text
        holder.binding.checkBox.isChecked = item.isSelected
        holder.binding.checkBox.setOnClickListener {
            item.isSelected = item.isSelected != true
            onCheckBoxStateChange(list)
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(categories: ArrayList<Categories>) {
        list = categories
    }

    class ViewHolder(val binding: ItemJobSearchFilterCategoryBinding) : RecyclerView.ViewHolder(binding.root)
}