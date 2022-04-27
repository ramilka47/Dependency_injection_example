package com.ramil.dependency_injection_example

import android.app.Application
import com.ramil.dependency_injection_example.di.ImplInjector
import com.ramil.dependency_injection_example.di.Injector
import com.ramil.dependency_injection_example.domain.ImplSendService

class Application : Application() {

    companion object{
        lateinit var injector: Injector
    }

    override fun onCreate() {
        super.onCreate()

        injector = ImplInjector
            .Builder()
            .dependencySendService(ImplSendService())
            .dependencySharedPreferences(applicationContext)
            .build()
        // Если нужно включить контекст(допустим для создания базы данных или sharedPreference, или еще чего-нибудь, то инициализировать инжектор надо тут)
    }

}