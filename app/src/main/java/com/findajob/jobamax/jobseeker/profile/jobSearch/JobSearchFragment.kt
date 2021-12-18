package com.findajob.jobamax.jobseeker.profile.jobSearch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.FragmentJobSearchBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.location.ManageLocationActivity
import com.findajob.jobamax.util.*
import com.kaopiz.kprogresshud.KProgressHUD
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_search.*

@AndroidEntryPoint
class JobSearchFragment : BaseFragmentMain<FragmentJobSearchBinding>(), JobSearchInterface {

    lateinit var navController: NavController
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    lateinit var jobSearchState: JobSearchState
    private var jobSearchArg: Boolean = false


    override fun onCreated(savedInstance: Bundle?) {
        progressHud = KProgressHUD.create(activity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
        progressHud.show()
        configureViewModel()
//        initViews()
        subscribeObserver()
        checkArguments()
    }

    private fun initViews() {
        setHasOptionsMenu(true)
        navController = findNavController()
        binding.apply {
            handler = this@JobSearchFragment

            state = jobSearchState
            partTimeCheck.isChecked = jobSearchState.typeOfWork.contains(CONST_PART_TIME)
            fullTimeCheck.isChecked = jobSearchState.typeOfWork.contains(CONST_FULL_TIME)
            seekBar.max = 100
            seekBar.progress = jobSearchState.distance
            distanceLabel.text = "${jobSearchState.distance} KM"
            jobField.setText(jobSearchState.job)
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    distanceLabel.text = "$progress KM"
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })

        }
    }

    private fun configureViewModel() {

    }


    override fun onResetClicked() {
        jobSearchState = JobSearchState()
        viewModel.apply {
//            jobSearchStateObservable = jobSearchStateObservable
            viewModel.isCurrentLocation = true
        }
        binding.apply {
            state = jobSearchState
            seekBar.progress = jobSearchState.distance
            distanceLabel.text = "${jobSearchState.distance} KM"
            jobField.setText(jobSearchState.job)
            partTimeCheck.isChecked = false
            fullTimeCheck.isChecked = false
        }

        viewModel.saveJobSearch()
    }

    fun subscribeObserver() {
        observe(viewModel.jobSearchStateObservable) { jss ->
            progressHud.dismiss()
            jobSearchState = jss ?: JobSearchState()
            initViews()
        }
    }


    override fun onBackButtonClicked() = requireActivity().onBackPressed()

    override fun onLocationClicked() {
        if (PLACE_API_KEY.isNotEmpty()) {

            val locationIntent = Intent(
                requireContext(),
                ManageLocationActivity::class.java
            )

            locationIntent.putExtra(ARG_CITY_FLAG, false)

            startActivityForResult(locationIntent, REQUEST_LOCATION_CODE)
//            locationActivityResultLauncher.launch(locationIntent)

        } else toast("Places API Key Required!")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, d: Intent?) {
        super.onActivityResult(requestCode, resultCode, d)

        if (requestCode == REQUEST_LOCATION_CODE && resultCode == Activity.RESULT_OK) {

            d?.let { data ->
                val location = data.getStringExtra(ARG_LOCATION) ?: ""
                if (location.isNotEmpty()) {
                    jobSearchState.location = location
                    binding.state = jobSearchState
                }

                val lat = data.getDoubleExtra(ARG_LAT, 0.0)
                val lng = data.getDoubleExtra(ARG_LNG, 0.0)

                if (lat > 0 && lng > 0) viewModel.submitLocation(lat, lng)

            }
        }
    }

    override fun onTemporaryPermanentClicked(view: View) {
        val popupMenu = PopupMenu(requireActivity(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_job_type, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            /*if (it.itemId == R.id.temporaryItem) {
                jobSearchState.jobType = CONST_TEMPORARY
            } else if (it.itemId == R.id.permanentItem) {
                jobSearchState.jobType = CONST_PERMANENT
            }*/
            binding.state = jobSearchState
            true
        }
        popupMenu.show()
    }

    override fun onSubmitButtonClicked() {

        progressHud.show()

        jobSearchState.distance = binding.seekBar.progress
        jobSearchState.job = binding.jobField.text.toString()

        jobSearchState.typeOfWork = mutableListOf()

        if (binding.partTimeCheck.isChecked) {
            jobSearchState.typeOfWork.add(CONST_PART_TIME)
        }

        if (binding.fullTimeCheck.isChecked) {
            jobSearchState.typeOfWork.add(CONST_FULL_TIME)
        }

        viewModel.saveJobSearchState(jobSearchState)
        viewModel.saveJobSearch()

        if (jobSearchArg) {
            startActivity(Intent(context, JobSeekerHomeActivity::class.java))
        } else {
            progressHud.dismiss()
            activity?.onBackPressed()
        }
    }


    private fun checkArguments() {
        jobSearchArg = (arguments?.get(ARG_JOBSEARCH) ?: false) as Boolean
    }

    override val layoutRes: Int
        get() = R.layout.fragment_job_search

    override fun getViewModel(): BaseViewModel? = null
}