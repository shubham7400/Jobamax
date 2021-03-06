package com.jobamax.appjobamax.jobseeker.profile.idealjob

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.cropper.CropImage
import com.jobamax.appjobamax.cropper.CropImageView
import com.jobamax.appjobamax.data.pojo.IdealJob
import com.jobamax.appjobamax.databinding.FragmentIdealJobImagesBinding
import com.jobamax.appjobamax.databinding.ItemPortfolioImageBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.util.*
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import java.util.*

const val ADD_NEW_ITEM = "new item"

class IdealJobImagesFragment : BaseFragmentMain<FragmentIdealJobImagesBinding>() , ImagePicker.GetImage, IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_ideal_job_images
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var idealJob: IdealJob? = null
    private lateinit var imagePicker: ImagePicker
    lateinit var adapter: IdealJobImageAdapter

    private val idealJobImageUrlList = arrayListOf(ADD_NEW_ITEM)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentIdealJobImagesBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setAdapter()
    }

    private fun getIdealJobData() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.IDEAL_JOB.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER.value, viewModel.jobSeeker.pfObject)
        query.include("jobSeeker")
        progressHud.show()
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result != null -> {
                    idealJob = IdealJob(result)

                    idealJob!!.arrImages.forEach {
                        idealJobImageUrlList.add(it)
                    }
                    adapter.submitList(idealJobImageUrlList)
                    adapter.notifyDataSetChanged()

                }
            }
        }
    }

    private fun setAdapter() {
        adapter = IdealJobImageAdapter(idealJobImageUrlList)
        binding.rvImageAndVideo.adapter = adapter
        adapter.addImage = {
            setupImagePicker()
        }
        adapter.removeImage = {
            idealJobImageUrlList.remove(it)
            adapter.submitList(idealJobImageUrlList)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupImagePicker() {
        imagePicker = ImagePicker(this)
        imagePicker.show(requireActivity().supportFragmentManager, imagePicker.tag)
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }


    private fun saveDataToParse(callback : () -> Unit) {
        idealJobImageUrlList.remove(ADD_NEW_ITEM)
        if (idealJob == null){
            val portfolioParseObject = ParseObject(ParseTableName.IDEAL_JOB.value)
            viewModel.jobSeeker.pfObject?.let { it1 ->
                portfolioParseObject.put("jobSeeker", it1)
            }
            portfolioParseObject.put("arrImages", idealJobImageUrlList)
            progressHud.show()
            portfolioParseObject.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                }
                callback()
            }
        }else{
            val portfolioParseObject = idealJob!!.pfObject
            portfolioParseObject?.let {
                viewModel.jobSeeker.pfObject?.let { it1 -> it.put("jobSeeker", it1) }
                it.put("arrImages", idealJobImageUrlList)
            }
            progressHud.show()
            portfolioParseObject?.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                    callback()
                }else{
                    /*toast("Data saved.")*/
                    callback()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val result = CropImage.getActivityResult(data)
                val profilePicUri = result.uri
                if (profilePicUri != null) {
                    uploadImageToParse(profilePicUri, requireContext(), { exception ->
                        toast(exception)
                    },
                        { imageUrl ->
                            idealJobImageUrlList.add(imageUrl)
                            adapter.submitList(idealJobImageUrlList)
                            adapter.notifyDataSetChanged()
                        })
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                requireContext().errorToast()
            }
        }
    }

    override fun setImageUri(imageUri: Uri?) {
        imageUri?.let { cropImageFromUri(it) }
    }


    private fun cropImageFromUri(uri: Uri) {
        CropImage.activity(uri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .setAspectRatio(1, 1)
            .setRequestedSize(480, 0, CropImageView.RequestSizeOptions.RESIZE_FIT)
            .start(this)
    }


    override fun onCreated(savedInstance: Bundle?) {
        getIdealJobData()
        binding.jobSeeker = viewModel.jobSeeker
    }

    override fun onBackPressed(callback: () -> Unit) {
        saveDataToParse {
            callback()
        }
    }

}

class IdealJobImageAdapter(var list : ArrayList<String>) : RecyclerView.Adapter<IdealJobImageAdapter.ViewHolder>() {
    var addImage : () -> Unit = {}
    var removeImage : (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemPortfolioImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            when (item) {
                ADD_NEW_ITEM -> {
                    this.ivAction.setImageResource(R.drawable.add_blue)
                    this.roundedImageView.setImageBitmap(null)
                    this.ivAction.setOnClickListener {
                        addImage()
                    }
                }
                else -> {
                    this.ivAction.setImageResource(R.drawable.close_blue_white_background)
                    Picasso.get().load(item).into(this.roundedImageView)
                    this.ivAction.setOnClickListener {
                        removeImage(item)
                    }
                }
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(idealJobImageUrlList: ArrayList<String>) {
        if (!idealJobImageUrlList.contains(ADD_NEW_ITEM)){
            idealJobImageUrlList.add(ADD_NEW_ITEM)
        }
        if (idealJobImageUrlList.isNotEmpty() && idealJobImageUrlList.size > 1){
            Collections.swap(idealJobImageUrlList, idealJobImageUrlList.indexOf(ADD_NEW_ITEM),idealJobImageUrlList.lastIndex)
        }
        list = idealJobImageUrlList
    }

    class ViewHolder(val binding: ItemPortfolioImageBinding) : RecyclerView.ViewHolder(binding.root)
}
