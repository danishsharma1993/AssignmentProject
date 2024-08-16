package com.example.assignmentproject.domain.repository

import com.example.assignmentproject.domain.model.ApiData
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    suspend fun fetchData(): Flow<List<ApiData>>
}