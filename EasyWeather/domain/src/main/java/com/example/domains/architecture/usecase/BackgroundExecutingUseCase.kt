package com.example.domains.architecture.usecase

import com.example.domains.architecture.coroutine.CoroutineContextProvider
import kotlinx.coroutines.withContext

/**
 * 코루틴을 사용하는 추상 클래스.
 * threading 처리해야할 때 사용할 수 있음
 * 요 abstract class를 소비하는 usecase들에게 코루틴이라는 기술을 쓰고 있다는 사실을 숨겨줌
 * 요 abstract 클래스가 코루틴을 쓰기 때문에, 자식 usecase들이 coroutine scope와 coroutine context를 넘겨줘야 함. <- 요건 coroutineContextProvider 인스턴스를 통해 넘겨줌
 */
abstract class BackgroundExecutingUseCase<REQUEST, RESULT>(
    private val coroutineContextProvider: CoroutineContextProvider
): UseCase<REQUEST, RESULT> {

    // final 접근자 사용한 이유 : 자식 usecase들이 execute 함수를 오버라이딩하는 것을 방지하기 위해.
    final override suspend fun execute(input: REQUEST, onResult: (RESULT) -> Unit) {
        val result = withContext(coroutineContextProvider.io) {
            executeInBackground(input)
        }
        onResult(result)
    }

    abstract suspend fun executeInBackground(
        request: REQUEST
    ): RESULT
}