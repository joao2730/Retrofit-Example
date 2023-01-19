package com.example.retrofitexample_0.Model.Remote

import com.example.retrofitexample_0.Model.Remote.pojo.MarsRealState
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response

// Interfaz de Conexion operaciones para enviar o recibir cosas
// OBTIENE  LOS DATOS
interface MarsApi {
    @GET("realestate")
    fun fetchMarsData(): Call<List<MarsRealState>> // VIEJA CONFIABLE




    // PARTE 2   CON COROUTINES

    @GET("realestate")
    suspend fun fetchMarsDataCoroutine(): Response<List<MarsRealState>> // nueva Forma

    //@POST()


}