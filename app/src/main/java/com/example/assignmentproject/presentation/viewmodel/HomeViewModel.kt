package com.example.assignmentproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentproject.domain.model.ApiData
import com.example.assignmentproject.domain.usecase.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMyDataUseCase: GetDataUseCase
) : ViewModel() {

    private val _data = MutableStateFlow<List<ApiData>>(emptyList())
    val data: StateFlow<List<ApiData>> = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            getMyDataUseCase.execute()
                .collect { result ->
                    _data.value = result
                }
        }
    }
}

