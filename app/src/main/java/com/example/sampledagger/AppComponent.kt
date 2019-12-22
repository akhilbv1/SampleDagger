package com.example.sampledagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubComponentsModule::class,NetworkModule::class])
interface AppComponent {

    fun getLoginComponent(): LoginComponent.Factory

}