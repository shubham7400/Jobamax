package com.findajob.jobamax.jobseeker.jobsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Categories
import com.findajob.jobamax.data.pojo.CategoryGroup
import com.findajob.jobamax.databinding.FragmentSeekerJobSearchFilterCategoriesBinding
 import com.findajob.jobamax.databinding.ItemJobSearchFilterCategoryBinding
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.findajob.jobamax.preference.setJobSearchFilterCategories
import com.findajob.jobamax.util.PROFILE_PIC_URL
import com.findajob.jobamax.util.getJobCategories
import com.findajob.jobamax.util.loadImageFromUrl
 import com.google.gson.Gson

class SeekerJobSearchFilterCategoriesDialogFragment : Fragment(), IOnBackPressed {
    var onDialogDismiss : () -> Unit = {}

    lateinit var binding: FragmentSeekerJobSearchFilterCategoriesBinding

    private var categories = arrayListOf<Categories>()
    private var profilePicUrl = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobSearchFilterCategoriesBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        profilePicUrl = requireArguments().getString(PROFILE_PIC_URL, "")
        loadImageFromUrl(binding.civUser, profilePicUrl, R.drawable.default_user_img)
         setAdapter()
        binding.ivBackButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobSearchFilterCategoriesDialogFragment_to_seekerJobsFilterFragment, null))

        binding.civUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobSearchFilterCategoriesDialogFragment_to_nav_seeker_profile, null))
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



   /* companion object {
        fun newInstance(profilePicUrl: String): SeekerJobSearchFilterCategoriesDialogFragment {
            val fragment =  SeekerJobSearchFilterCategoriesDialogFragment()
            val args = Bundle()
            args.putSerializable(PROFILE_PIC_URL, profilePicUrl)
            fragment.arguments = args
            return fragment
        }
    }*/

    override fun onBackPressed(callback: () -> Unit) {
         binding.ivBackButton.performClick()
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