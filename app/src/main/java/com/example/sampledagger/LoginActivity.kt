package com.example.sampledagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject
import kotlin.math.log

class LoginActivity : AppCompatActivity() {


    @Inject
    lateinit var loginViewModel: LoginViewModel

     lateinit var loginComponent: LoginComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        instantiateDaggerComponent()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setListeners()
    }

    private fun instantiateDaggerComponent() {
        loginComponent =
            (applicationContext as MainApplication).getDaggerAppComponent()?.getLoginComponent()!!.create()
        loginComponent.inject(this)
    }

    private fun setListeners() {
        loginViewModel.creatDummy()
        loginViewModel.printDummyVariable()


        btnLogin.setOnClickListener {
            //loginViewModel.validateUser(etLogin.text.toString(), etPassword.text.toString())
            val fragment = MainFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(fragment, "Details Fragment")
            transaction.commit()
        }
    }

}
