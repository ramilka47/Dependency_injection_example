package com.ramil.dependency_injection_example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ramil.dependency_injection_example.Application
import com.ramil.dependency_injection_example.domain.ISendService

class SplashFragment : Fragment() {

    lateinit var iSendService: ISendService

    init {
        iSendService = Application.injector.getISendService()
        // если требуется проинжектировать viewModel или presenter нужно инициализировать в методе onCreate
        // так же инициализация зависит от возможности использования контекста
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}