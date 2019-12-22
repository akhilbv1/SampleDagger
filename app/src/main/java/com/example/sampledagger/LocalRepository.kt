package com.example.sampledagger

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@ActivityScope
class LocalRepository @Inject constructor() {

    private val TAG: String = "Networking"

    @Inject
    lateinit var retrofitClient: NetworkManager

    fun validateUser(user: UserModel): ResultModel {
        val isSuccess: Boolean = usersList.any {
            it.userName.equals(
                user.userName,
                true
            ) && it.password.equals(user.password, false)
        }
        val reason: String = if (isSuccess) "Login Success" else "Login Failed"
        return ResultModel(isSuccess, reason)
    }

    fun getUsers(
        onSuccess: (Any) -> Unit,
        onFailed: (code: String) -> Unit
    ) {

        val call = retrofitClient.getUsers(2)

        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                onFailed.invoke(t.localizedMessage?:"Empty")
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful)
                    onSuccess.invoke(response.body()!!)
            }

        })
    }
}