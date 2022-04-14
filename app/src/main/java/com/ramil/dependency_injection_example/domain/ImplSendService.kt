package com.ramil.dependency_injection_example.domain

class ImplSendService : ISendService {

    override fun send(msg: String) {
        println(msg)
    }

}