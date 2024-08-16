package com.example.assignmentproject.presentation



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.assignmentproject.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
   // val viewModel: HomeViewModel = viewModel()
    val data by viewModel.data.collectAsState() // Collect state from the ViewModel

    Scaffold(
        topBar = {
           // TopAppBar(title = { Text("Home Screen") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
           /* items(data) { item ->
                ListItem(
                    modifier = Modifier.padding(8.dp),
                    headlineContent = { Text(item.name) } // Correct parameter name
                )
            }*/
        }
    }
}