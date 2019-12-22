package com.example.sampledagger

import com.example.sampledagger.MConfig.Companion.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object{
        @Singleton
        @Provides
        @JvmStatic
        fun getRetrofitClient(): NetworkManager {
            var retrofit: Retrofit? = null
            val gson = GsonBuilder()
                .setLenient()
                .create()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create(gson))
                .build()
            return retrofit!!.create(NetworkManager::class.java)
        }
    }


}