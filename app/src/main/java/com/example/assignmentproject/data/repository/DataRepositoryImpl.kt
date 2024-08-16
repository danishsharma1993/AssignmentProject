package com.example.assignmentproject.data.repository

import com.example.assignmentproject.data.api.ApiService
import com.example.assignmentproject.data.mapper.ApiMapper
import com.example.assignmentproject.domain.model.ApiData
import com.example.assignmentproject.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ApiMapper
) : DataRepository {

    override suspend fun fetchData(): Flow<List<ApiData>> = flow {
        val response = apiService.getData()
        emit(mapper.mapToDomain(response))
    }
}