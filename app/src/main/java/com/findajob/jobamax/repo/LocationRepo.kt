package com.findajob.jobamax.repo

import com.findajob.jobamax.data.pojo.Location
import com.findajob.jobamax.data.remote.GoogleApiService
import com.findajob.jobamax.training.model.ConstantApp
import com.findajob.jobamax.util.Resource
import com.findajob.jobamax.util.log
import javax.inject.Inject


class LocationRepo @Inject constructor(val api: GoogleApiService) {

    suspend fun queryLocation(query: String): Resource<List<Location>> {
        val response =
            api.getMapTextSearchResponse(ConstantApp.GOOGLE_PLAY_SERVICE_API, query)


        response.body()?.let {
            val locationList: List<Location> = it.predictions.map { prediction ->
                Location(prediction.placeId, prediction.structuredFormatting.mainText, 0.0, 0.0)
            }

            return if (locationList.isNotEmpty()) {
                log("location list -> $locationList")
                Resource.Success(locationList)
            } else {
                Resource.Error("Could not find the location")
            }
        }

        return Resource.Error("Something went wrong.")
    }

    suspend fun queryLocationDetails(placeId: String): Resource<Location> {


        val response =
            api.getPlaceDetailsResponse(ConstantApp.GOOGLE_PLAY_SERVICE_API, placeId)


        response.body()?.let {
            val address = it.result.formattedAddress
            val latitude = it.result.geometry.location.lat
            val longitude = it.result.geometry.location.lng

            var city = ""

            it.result.addressComponents.forEach { ac ->
                if (ac.types.contains("locality")) city = ac.shortName
            }

            val location = Location(placeId, address, latitude, longitude, city = city)

            return Resource.Success(location)

        }

        return Resource.Error("Something went wrong.")
    }
}