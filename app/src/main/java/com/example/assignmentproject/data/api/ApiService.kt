package com.example.assignmentproject.data.api

import com.example.assignmentproject.data.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("data")
    suspend fun getData():ApiResponse
}