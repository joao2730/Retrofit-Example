package com.example.retrofitexample_0.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample_0.Model.Remote.pojo.MarsRealState
import com.example.retrofitexample_0.Model.Remote.MarsRepository
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {


    private val repository: MarsRepository

    // PARTE 1
    //  val liveDataFromInternet: LiveData<List<MarsRealState>>


    //PARTE 2 SE VA CAER CON LATENIINIT

    lateinit var  liveDataFromInternet :LiveData<List<MarsRealState>>

    init {
       repository = MarsRepository()
        //PARTE 1
        //liveDataFromInternet = repository.fetchDataMars()


        // PARTE 2 // MANEJO LA COROUTINE
            viewModelScope.launch {
             //PARTE 1 NO ADMITE LA VARIABLE DENTRO DEL INIT
          // liveDataFromInternet = repository.fetchDataFromInternetCoroutines()
            repository.fetchDataFromInternetCoroutines()
        }
       // PARTE 2
        liveDataFromInternet = repository.dataFromInternet


    }
        //---------------------------------------------------------------------------------




 /*   fun getFetchTerrains(): LiveData<List<MarsRealState>>{
        return repository.fetchDataMars()
    }*/
    private var selectedMarsTerrain: MutableLiveData<MarsRealState> = MutableLiveData()

    fun selected(marsTerrain: MarsRealState){
        selectedMarsTerrain.value = marsTerrain
    }
    fun selectedItem(): LiveData<MarsRealState> = selectedMarsTerrain

}
