package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.HardSkill
import com.findajob.jobamax.databinding.FragmentSeekerEducationBinding
import com.findajob.jobamax.databinding.FragmentSeekerMySkillBinding
import com.findajob.jobamax.databinding.ItemSeekerHardSkillBinding
import com.findajob.jobamax.databinding.RecruiterHomeBindingImpl
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.toast
import com.google.android.material.chip.Chip
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONArray
import org.json.JSONObject





class SeekerMySkillFragment : BaseFragmentMain<FragmentSeekerMySkillBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_my_skill
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var hardSkillSuggestions = ArrayList<String>()
    var ownedHardSkills = ArrayList<HardSkill>()
    lateinit var adapter: SeekerHardSkillAdapter

    var ownedSoftSkills = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerMySkillBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreated(savedInstance: Bundle?) {
        viewModel.getJobSeeker()
    }


    private fun configureUi() {
         setClickListeners()
        setAdapter()
        viewModelObserver()
    }

    private fun setAdapter() {
        adapter = SeekerHardSkillAdapter(ownedHardSkills)
        binding.rvHardSkill.adapter = adapter
        adapter.clickListener = {
            ownedHardSkills.remove(it)
            adapter.submitList(ownedHardSkills)
            adapter.notifyDataSetChanged()
        }
        adapter.skillLevelChangeListener = { hardSkill, skillLevelNewValue ->
            val index = ownedHardSkills.indexOf(hardSkill)
            if(ownedHardSkills.indexOf(hardSkill) != -1){
                ownedHardSkills[index].skillLevel = skillLevelNewValue
            }
        }
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, Observer {
             if(it){
                 ownedHardSkills.clear()
                 if (viewModel.jobSeeker.hardSkills != ""){
                     val hardSkillJsonObj = JSONObject(viewModel.jobSeeker.hardSkills)
                     for (key in hardSkillJsonObj.keys().iterator())  {
                         ownedHardSkills.add(HardSkill(key, hardSkillJsonObj.getInt(key)))
                     }
                 }
                 adapter.submitList(ownedHardSkills)
                 adapter.notifyDataSetChanged()

                 ownedSoftSkills.clear()
                 if (viewModel.jobSeeker.softSkills != ""){
                     val softSkills =  JSONArray(viewModel.jobSeeker.softSkills)
                     var i = 0
                     while (i < softSkills.length()){
                         ownedSoftSkills.add(softSkills.getString(i) )
                         i++
                     }
                 }
                 binding.cgSoftSkill.removeAllViews()
                 ownedSoftSkills.forEach {
                     val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgSoftSkill, false) as Chip
                     chip.text = it
                     chip.setOnCloseIconClickListener { c ->
                         ownedSoftSkills.remove((c as Chip).text)
                         binding.cgSoftSkill.removeView(c)
                     }
                     chip.setCloseIconResource(R.drawable.close_white)
                     chip.setCloseIconTintResource(R.color.white)
                     chip.isCloseIconVisible = true
                      binding.cgSoftSkill.addView(chip)
                 }
             }
         })
    }

    private fun setClickListeners() {
         binding.ivBackButton.setOnClickListener {
             (activity as SeekerProfileActivity).onBackPressed()
         }

        binding.ivHardSkillAddBtn.setOnClickListener {
            if (binding.etHardSkill.text.isNullOrEmpty()){
                toast("Please first enter the tag.")
            }else{
                addHardSkill()
            }
        }

        binding.ivSoftSkillAddBtn.setOnClickListener {
            if (binding.etSoftSkill.text.isNullOrEmpty()){
                toast("Please first enter the tag.")
            }else{
                addSoftSkill()
            }
        }

        binding.btnSaveInfo.setOnClickListener {
            val hardSkillJsonObj = JSONObject()
            ownedHardSkills.forEach {
                hardSkillJsonObj.put(it.skillName, it.skillLevel)
            }
            progressHud.show()
            viewModel.saveHardSkills(hardSkillJsonObj) {
                progressHud.dismiss()
                if(it == null){
                    saveSoftSkill()
                }else{
                    toast("${it.message.toString()} Something went wrong.")
                }
            }

        }
    }

    private fun saveSoftSkill() {
        val softSkillJsonArray = JSONArray()
        ownedSoftSkills.forEach {
            softSkillJsonArray.put(it)
        }
        progressHud.show()
        viewModel.saveSoftSkills(softSkillJsonArray){
            progressHud.dismiss()
            if(it == null){
                toast("Skills Added.")
                requireActivity().onBackPressed()
            }else{
                toast("${it.message.toString()} Something went wrong.")
            }
        }
    }

    private fun addHardSkill() {
        ownedHardSkills.add(HardSkill(binding.etHardSkill.text.toString(), 3))
        adapter.submitList(ownedHardSkills)
        adapter.notifyDataSetChanged()
        binding.etHardSkill.text.clear()
    }

    private fun addSoftSkill() {
        ownedSoftSkills.add(binding.etSoftSkill.text.toString())
        val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgSoftSkill, false) as Chip
        chip.text = binding.etSoftSkill.text.toString()
        chip.setOnCloseIconClickListener { c ->
            ownedSoftSkills.remove((c as Chip).text)
            binding.cgSoftSkill.removeView(c)
        }
        chip.isCloseIconVisible = true
        chip.setCloseIconResource(R.drawable.close_white)
        chip.setCloseIconTintResource(R.color.white)
         binding.cgSoftSkill.addView(chip)
        binding.etSoftSkill.text.clear()
    }


}

class SeekerHardSkillAdapter(var list: ArrayList<HardSkill>) : RecyclerView.Adapter<SeekerHardSkillAdapter.ViewHolder>(){
    var clickListener: (HardSkill) -> Unit = {}
    var skillLevelChangeListener: (HardSkill, Int ) -> Unit = { hardSkill, value -> }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerHardSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hardSkill = list[position]
        holder.binding.tvHardSkill.text = hardSkill.skillName
        holder.binding.sbHardSkill.progress = hardSkill.skillLevel
        holder.binding.ivRemoveBtn.setOnClickListener {
            clickListener(hardSkill)
        }
        holder.binding.sbHardSkill.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, value: Int, p2: Boolean) {
                skillLevelChangeListener(hardSkill, value)
             }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }
    override fun getItemCount(): Int = list.size
    fun submitList(ownedHardSkills: ArrayList<HardSkill>) {
        list = ownedHardSkills
    }
    class ViewHolder(val binding: ItemSeekerHardSkillBinding) : RecyclerView.ViewHolder(binding.root)
}