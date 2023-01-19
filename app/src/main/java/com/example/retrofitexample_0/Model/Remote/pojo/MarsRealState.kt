package com.example.retrofitexample_0.Model.Remote.pojo

import com.google.gson.annotations.SerializedName

data class MarsRealState( @SerializedName("id")
                          val id :String,
                          @SerializedName("price")
                          // cambiar a long
                          val price :Long,
                          @SerializedName("type")
                          val type : String,
                          @SerializedName("img_src")
                          val imgSrc : String



)
