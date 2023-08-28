package com.example.presentation.architecture.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domains.architecture.exception.DomainException
import com.example.domains.architecture.usecase.UseCase
import com.example.domains.architecture.usecase.UseCaseExecutor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * 원칙적으로 클린아키텍처에 따르려면, Presentation 레이어가 Android에 의존해서는 안되지만,
 * 구글 아키텍처 컴포넌트 & 힐트를 쓰려면 Presentation이 Android에 의존하지 않는 것은 불가능함..
 *
 * Presentation 레이어가 ui에 state가 변경되었음을 알리는 방법 : state 업데이트
 * view state : 현재 state에 대한 데이터를 홀딩하는 stateflow 형태로 가지고 있을 것임. 지금 로딩중인지 아닌지 & 어떤 데이터를 사용자에게 보여줄건지에 대한 정보
 */
abstract class BaseViewModel<UI_STATE: Any>(
    private val useCaseExecutor: UseCaseExecutor
) : ViewModel() {
    internal abstract fun initialState(): UI_STATE
    private val _uiState = MutableStateFlow(initialState())
    val uiState = _uiState.asStateFlow()

    private val currentUiState: UI_STATE
        get() = uiState.value

    private fun updateUiState(newUiState: UI_STATE) {
        _uiState.update { newUiState }
    }

    internal fun updateUiState(
        updatedState: UI_STATE.() -> UI_STATE
    ) = updateUiState(currentUiState.updatedState())

    protected fun <OUTPUT> UseCase<Unit, OUTPUT>.run(
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        useCaseExecutor.execute(this, onResult, onException)
    }

    protected fun <INPUT, OUTPUT> UseCase<INPUT, OUTPUT>.run(
        value: INPUT,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        useCaseExecutor.execute(this, value, onResult, onException)
    }

}