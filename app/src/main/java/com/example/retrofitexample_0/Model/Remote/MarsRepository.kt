package com.example.retrofitexample_0.Model.Remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitexample_0.Model.Remote.pojo.MarsRealState

class MarsRepository {

    private val retrofitClient = RetrofitClient.getRetrofit()
    var  dataFromInternet = MutableLiveData<List<MarsRealState>>()


    // ANTIGUA FORMA


  /*  fun fetchDataMars(): LiveData<List<MarsRealState>> {  // Vieja confiable
        Log.d("REPO", "VIEJA CONFIABLE")
        // Incluye la lista mas el verbo con la solicitud
        retrofitClient.fetchMarsData().enqueue(object : Callback<List<MarsRealState>> {
            override fun onResponse(
                call: Call<List<MarsRealState>>,
                response: Response<List<MarsRealState>>
            ) {
                when (response.code()) {
                    in 200..299 -> dataFromInternet.value = response.body()
                    in 300..301 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                    else -> Log.d(
                        "REPO",
                        "${response.code()} --- ${response.errorBody().toString()}"
                    )
                }
            }

            override fun onFailure(call: Call<List<MarsRealState>>, t: Throwable) {
                Log.e("REPO", "${t.message}")
            }
        })
        return dataFromInternet
    }

*/


    //-------------------------------parte 2--------------------------------------------
// Manejo las Coroutines en ViewModel

    // Obtener datos con corutinas PRIMERO SE CAE Y CAMBIO ESTA PARTE
   // suspend fun fetchDataFromInternetCoroutines(): LiveData<List<MarsRealState>> {

  suspend fun fetchDataFromInternetCoroutines(){
    try {
            val response = retrofitClient.fetchMarsDataCoroutine()
            when (response.code()) {
                in 200..299 -> dataFromInternet.value = response.body()
                in 300..301 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO", "${response.code()} --- ${response.errorBody().toString()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "${t.message}")
        }
    }


    // funcion para selecccionar
    // guardarmos la selecciona en una mutableLiveData
    private var selectedMarsTerrain: MutableLiveData<MarsRealState> = MutableLiveData()

    // Ocupamos una función  y tomamos la posiciona seleccionada
    fun selected(mars : MarsRealState){
        selectedMarsTerrain.value = mars
    }

    fun selectedItem(): LiveData<MarsRealState> = selectedMarsTerrain






}