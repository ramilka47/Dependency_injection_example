package com.ramil.dependency_injection_example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramil.dependency_injection_example.Application
import com.ramil.dependency_injection_example.R
import com.ramil.dependency_injection_example.domain.ISendService

class MainActivity : AppCompatActivity() {

    lateinit var iSendService: ISendService

    init {
        iSendService = Application.injector.getISendService()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iSendService.send(this::class.java.name)
        toSplashFragment()
    }

    fun toSplashFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, SplashFragment()).commit()
    }

}