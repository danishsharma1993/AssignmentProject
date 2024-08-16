package com.example.assignmentproject.domain.usecase

import com.example.assignmentproject.domain.model.ApiData
import com.example.assignmentproject.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val myRepository: DataRepository
) {
    fun execute(): Flow<List<ApiData>> = flow {
        try {
            val data = myRepository.fetchData()
           // emit(data) // Emit the data
        } catch (e: Exception) {
            // Handle exceptions and emit an empty list or handle errors
            emit(emptyList())
        }
    }
}
