package com.example.assignmentproject.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignmentproject.domain.model.ApiData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(dataId: Int) {
    // Mock data for demonstration. You would fetch this based on dataId.
    val data = remember { ApiData(dataId, "Item Name $dataId") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detail Screen") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(text = "ID: ${data.id}", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${data.name}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}