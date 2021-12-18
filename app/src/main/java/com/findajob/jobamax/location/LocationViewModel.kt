package com.findajob.jobamax.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Location
import com.findajob.jobamax.repo.LocationRepo
import com.findajob.jobamax.util.Resource
import com.findajob.jobamax.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LocationViewModel"

@HiltViewModel
class LocationViewModel @Inject constructor(val repo: LocationRepo) : BaseViewModel() {

    private val _locationListener = MutableLiveData<List<Location>>()
    val locationListener: LiveData<List<Location>> = _locationListener


    fun queryCity(text: String) {
        viewModelScope.launch(Dispatchers.IO) {

            when (val res = repo.queryLocation(text)) {
                is Resource.Loading -> setLoading(true, post = true)
                is Resource.Error -> {
                    log("error data -> ${res.message}")
                    setLoading(false, post = true)
                    if (text.trim().isNotEmpty()) setError(res.message)
                }
                is Resource.Success -> {
                    log("success data -> ${res.data}")
                    _locationListener.postValue(res.data ?: emptyList())
                    setLoading(false, post = true)
                }
            }
        }
    }


    private val _selectedLocationListener = MutableLiveData<Location>()
    val selectedLocationListener: LiveData<Location> = _selectedLocationListener

    fun queryLocationDetails(placeId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val res = repo.queryLocationDetails(placeId)) {
                is Resource.Loading -> setLoading(true, post = true)
                is Resource.Error -> {
                    log("error data -> ${res.message}")
                    setLoading(false, post = true)
                    if (placeId.trim().isNotEmpty()) setError(res.message)
                }
                is Resource.Success -> {
                    log("success data -> ${res.data}")
                    _selectedLocationListener.postValue(res.data!!)
                    setLoading(false, post = true)
                }
            }
        }
    }

}