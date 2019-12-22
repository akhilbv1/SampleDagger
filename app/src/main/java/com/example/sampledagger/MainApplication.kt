package com.example.sampledagger

import android.app.Application
import dagger.Component

class MainApplication : Application() {

   private var daggerComponent:AppComponent? = null


    override fun onCreate() {
        super.onCreate()
        daggerComponent =  DaggerAppComponent.create()
    }

    fun getDaggerAppComponent():AppComponent? = daggerComponent
}