package com.example.assignmentproject.data.mapper


import com.example.assignmentproject.data.model.ApiResponse
import com.example.assignmentproject.domain.model.ApiData

class ApiMapper {
        fun mapToDomain(response: ApiResponse): List<ApiData> {
        return response.result.map { ApiData(it.id, it.name) }
    }
}