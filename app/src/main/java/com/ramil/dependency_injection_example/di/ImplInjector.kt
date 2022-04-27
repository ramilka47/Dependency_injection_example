package com.ramil.dependency_injection_example.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.ramil.dependency_injection_example.di.dependencies.DependencySendService
import com.ramil.dependency_injection_example.di.dependencies.DependencySharedPreferences
import com.ramil.dependency_injection_example.domain.ISendService
import java.lang.Exception

class ImplInjector(builder : Builder) : Injector {

    private val dependencySendService: DependencySendService =
        builder.getDependencySendService() ?: throw InjectorException()

    private val dependencySharedPreferences : DependencySharedPreferences =
        builder.getDependencySharePreferences() ?: throw InjectorException()

    override fun getISendService(): ISendService =
        dependencySendService.iSendService

    override fun getSharedPreferences(): SharedPreferences =
        dependencySharedPreferences.sharedPreferences

    class Builder{
        private var dependencySendService : DependencySendService? = null
        private var dependencySharePreferences : DependencySharedPreferences? = null

        fun dependencySendService(iSendService: ISendService) : Builder = this.apply {
            dependencySendService = DependencySendService(iSendService)
        }

        fun dependencySharedPreferences(context : Context) : Builder = this.apply {
            dependencySharePreferences = DependencySharedPreferences(context.getSharedPreferences("local_share", MODE_PRIVATE))
        }

        fun dependencySharedPreferences(sharedPreferences: SharedPreferences) : Builder = this.apply {
            dependencySharePreferences = DependencySharedPreferences(sharedPreferences)
        }

        fun getDependencySendService() = dependencySendService

        fun getDependencySharePreferences() = dependencySharePreferences

        fun build() : ImplInjector{
            return ImplInjector(this)
        }
    }

    class InjectorException() : Exception("dependencies has null")

}