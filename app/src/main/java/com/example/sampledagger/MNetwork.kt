package com.example.sampledagger

import retrofit2.Call
import retrofit2.http.*


interface NetworkManager {

    @GET(MConfig.USERS)
    fun getUsers(@Query("page") page: Int): Call<Any>

}