package com.lml.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.lml.sunnyweather.logic.Repository
import com.lml.sunnyweather.logic.model.Place

class PlaceViewModel : ViewModel(){
    private val searchLiveData=MutableLiveData<String>()
    val placeList=ArrayList<Place>()

    val placeLiveData=Transformations.switchMap(searchLiveData){query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query:String){
        searchLiveData.value=query
    }
}