package com.example.domains.architecture.usecase

/**
 * UseCaseExceutor와 모든 usecase 간에 contract를 명시하는 인터페이스
 * UseCase 인터페이스는 threading과 같은 디테일에 대해서는 신경쓸 필요 없음
 */
interface UseCase<REQUEST, RESULT> {
    suspend fun execute(input: REQUEST, onResult: (RESULT) -> Unit)
}