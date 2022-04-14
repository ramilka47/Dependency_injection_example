package com.ramil.dependency_injection_example.di

import com.ramil.dependency_injection_example.domain.ISendService

interface Injector {

    fun getISendService() : ISendService

}