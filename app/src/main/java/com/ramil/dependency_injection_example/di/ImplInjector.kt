package com.ramil.dependency_injection_example.di

import com.ramil.dependency_injection_example.di.dependencies.DependencySendService
import com.ramil.dependency_injection_example.domain.ISendService
import java.lang.Exception

class ImplInjector(builder : Builder) : Injector {

    private val dependencySendService: DependencySendService =
        builder.getDependencySendService() ?: throw InjectorException()

    override fun getISendService(): ISendService =
        dependencySendService.iSendService

    class Builder{
        private var dependencySendService : DependencySendService? = null

        fun dependencySendService(iSendService: ISendService) : Builder = this.apply {
            dependencySendService = DependencySendService(iSendService)
        }

        fun getDependencySendService() = dependencySendService

        fun build() : ImplInjector{
            return ImplInjector(this)
        }
    }

    class InjectorException() : Exception("dependencies has null")

}