package com.example.sampledagger

import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
    fun inject(mainFragment: MainFragment)
}