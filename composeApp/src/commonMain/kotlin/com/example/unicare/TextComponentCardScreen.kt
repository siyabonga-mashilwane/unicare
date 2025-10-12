package com.example.unicare

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextComponentScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val textComponents = remember {
        mutableStateListOf(
            "Blood Pressure notes",
            "Diabetes Notes",
            "Allergy Details",
            "MRI Scan Notes"
        )
    }

    val filteredComponents = remember(searchQuery) {
        if (searchQuery.isBlank()) textComponents
        else textComponents.filter {
            it.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CustomSearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearch = {},
            placeholderText = "Search components..."
        )

        Spacer(Modifier.height(16.dp))

        filteredComponents.forEach { title ->
            TextComponentCard(
                title = title,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }
    }
}
