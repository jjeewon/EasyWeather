package com.example.domains.architecture.coroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * 코루틴 컨텍스트를 추상화해서 제공해주기 위한 인터페이스.
 */
interface CoroutineContextProvider {
    val main: CoroutineContext
    val io: CoroutineContext

    object Default : CoroutineContextProvider {
        override val main: CoroutineContext = Dispatchers.Main
        override val io: CoroutineContext = Dispatchers.IO
    }
}