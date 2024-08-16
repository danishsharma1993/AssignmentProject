package com.example.assignmentproject.data.model

    data class ApiResponse(val result: List<ApiData>)
    data class ApiData(val id:Int,val name:String)