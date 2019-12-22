package com.example.sampledagger

import android.util.Log
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

@ActivityScope
class LoginViewModel @Inject constructor(private val localRepository: LocalRepository) {

    private val TAG: String = LoginViewModel::class.java.simpleName

    // private val resultResponse: MutableLiveData<ResultModel> = MutableLiveData()

    private var dummmy = "It's Empty"

    fun validateUser(userName: String, password: String) {
        val res = localRepository.validateUser(user = UserModel(userName, password))
        Log.i(TAG, "${res.reason} and ${res.isSuccess}")
        localRepository.getUsers({
            Log.i(TAG, "response is $it")
        },{
            Log.i(TAG, "error is $it")
        })

        //  resultResponse.postValue(res)

    }

    fun creatDummy() {
        dummmy = "Created and changed"
    }

    fun printDummyVariable() {
        Log.i(TAG, dummmy)
    }


    // fun getResultResponse(): MutableLiveData<ResultModel> = resultResponse

}