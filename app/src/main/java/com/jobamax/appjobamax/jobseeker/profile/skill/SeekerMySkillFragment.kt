package com.jobamax.appjobamax.jobseeker.profile.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.HardSkill
import com.jobamax.appjobamax.databinding.FragmentSeekerMySkillBinding
import com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding
import com.jobamax.appjobamax.dialog.YesNoDialog
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.jobamax.appjobamax.model.GetAllUserCallback
import com.jobamax.appjobamax.util.log
import com.jobamax.appjobamax.util.toast
import com.google.android.material.chip.Chip
import com.parse.ParseObject
import org.json.JSONArray
import org.json.JSONObject





class SeekerMySkillFragment : BaseFragmentMain<FragmentSeekerMySkillBinding>(), IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_seeker_my_skill
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var hardSkillSuggestions = ArrayList<String>()
    var softSkillSuggestions = ArrayList<String>()
    var ownedHardSkills = ArrayList<HardSkill>()
    lateinit var adapter: SeekerHardSkillAdapter

    private var ownedSoftSkills = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerMySkillBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreated(savedInstance: Bundle?) {
        viewModel.getJobSeeker()
        viewModel.getExistingHardSkillTags(object : GetAllUserCallback {
            override fun onSuccess(parseObject: List<ParseObject>) {
                hardSkillSuggestions.clear()
                parseObject.forEach {
                    it.getString("name")?.let { tag -> hardSkillSuggestions.add(tag) }
                }
                binding.actvHardSkill.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, hardSkillSuggestions))
            }
            override fun onFailure(e: Exception?) {
                if (e != null) {
                    log("${e.message.toString()} Something Went Wrong")
                }
            }
        })
        viewModel.getExistingSoftSkillTags(object : GetAllUserCallback {
            override fun onSuccess(parseObject: List<ParseObject>) {
                softSkillSuggestions.clear()
                parseObject.forEach {
                    it.getString("name")?.let { tag -> softSkillSuggestions.add(tag) }
                }
                binding.actvSoftSkill.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, softSkillSuggestions))
            }
            override fun onFailure(e: Exception?) {
                if (e != null) {
                    log("${e.message.toString()} Something Went Wrong")
                }
            }
        })
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

            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
                ownedHardSkills.remove(it)
                adapter.submitList(ownedHardSkills)
                adapter.notifyDataSetChanged()
            },{}).show()
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
                 binding.jobSeeker = viewModel.jobSeeker
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
             requireActivity().onBackPressed()
         }
        binding.ivUserProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerMySkillFragment_to_seekerProfileFragment, null))

        binding.ivHardSkillAddBtn.setOnClickListener {
            if (binding.actvHardSkill.text.isNullOrEmpty()){
                toast("Please first enter the tag.")
            }else{
                addHardSkill()
            }
        }

        binding.ivSoftSkillAddBtn.setOnClickListener {
            if (binding.actvSoftSkill.text.isNullOrEmpty()){
                toast("Please first enter the tag.")
            }else{
                addSoftSkill()
            }
        }
    }

    private fun saveSoftSkill(callback: () -> Unit) {
        val softSkillJsonArray = JSONArray()
        ownedSoftSkills.forEach {
            softSkillJsonArray.put(it)
        }
        progressHud.show()
        viewModel.saveSoftSkills(softSkillJsonArray){
            progressHud.dismiss()
            if(it == null){
                callback()
            }else{
                callback()
                toast("${it.message.toString()} Something went wrong.")
            }
        }
    }

    private fun addHardSkill() {
        if (! hardSkillSuggestions.contains(binding.actvHardSkill.text.toString())){
            viewModel.saveHardSkillTag(binding.actvHardSkill.text.toString())
        }
        if (isHardSkillAlreadyExist()){
            toast("This Skill is already exist.")
        }else{
            ownedHardSkills.add(HardSkill(binding.actvHardSkill.text.toString(), 3))
            adapter.submitList(ownedHardSkills)
            adapter.notifyDataSetChanged()
            binding.actvHardSkill.text.clear()
        }
    }

    private fun isHardSkillAlreadyExist(): Boolean {
        var isExist = false
        ownedHardSkills.forEach {
            if (it.skillName == binding.actvHardSkill.text.toString()){
                isExist = true
            }
        }
        return isExist
    }

    private fun addSoftSkill() {
         if (! softSkillSuggestions.contains(binding.actvSoftSkill.text.toString())){
            viewModel.saveSoftSkillTag(binding.actvSoftSkill.text.toString())
        }
        if (ownedSoftSkills.contains(binding.actvSoftSkill.text.toString())){
            toast("This Skill is already exist.")
        }else{
            ownedSoftSkills.add(binding.actvSoftSkill.text.toString())
            val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgSoftSkill, false) as Chip
            chip.text = binding.actvSoftSkill.text.toString()
            chip.setOnCloseIconClickListener { c ->
                YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
                    ownedSoftSkills.remove((c as Chip).text)
                    binding.cgSoftSkill.removeView(c)
                }, {}).show()
            }
            chip.isCloseIconVisible = true
            chip.setCloseIconResource(R.drawable.close_white)
            chip.setCloseIconTintResource(R.color.white)
            binding.cgSoftSkill.addView(chip)
            binding.actvSoftSkill.text.clear()
        }
    }

    override fun onBackPressed(callback: () -> Unit) {
        val hardSkillJsonObj = JSONObject()
        ownedHardSkills.forEach {
            hardSkillJsonObj.put(it.skillName, it.skillLevel)
        }
       /* progressHud.show()*/
        viewModel.saveHardSkills(hardSkillJsonObj) {
           /* progressHud.dismiss()*/
            if(it == null){
                /*callback()*/
            }else{
               /* toast("${it.message.toString()} Something went wrong.")*/
                /*callback()*/
            }
        }
        saveSoftSkill { /*callback()*/ }
        callback()
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