package com.example.unicare

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Patient(
    val name: String,
    val id: String,
    val age: Int,
    val recentVisit: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientSearchScreen(
    patients: List<Patient>,
    onAddPatientClick: () -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var searchStatus by remember { mutableStateOf("Ready to search patients.") }
    var recentSearches by remember {
        mutableStateOf(listOf("Simon Grimsby", "0123456789", "Aspirin 81mg"))
    }

    val filteredPatients = remember(searchQuery, patients) {
        if (searchQuery.isBlank()) patients
        else patients.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
                    it.id.contains(searchQuery, ignoreCase = true)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomSearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = { query ->
                    searchStatus = "Searching for \"$query\"..."
                    if (!recentSearches.contains(query) && query.isNotBlank()) {
                        recentSearches = (listOf(query) + recentSearches).take(5)
                    }
                },
                recentSearches = recentSearches
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "Patients",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(Modifier.height(6.dp))

            AnimatedVisibility(visible = filteredPatients.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    items(filteredPatients) { patient ->
                        PatientResultItem(
                            patient = patient,
                            onClick = {
                                searchQuery = patient.name
                                searchStatus = "Selected ${patient.name}"
                            }
                        )
                    }
                }
            }

            if (filteredPatients.isEmpty()) {
                Text(
                    text = "No Patients Found",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )
            }
        }
    }
}

@Composable
fun PatientResultItem(patient: Patient, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.background,
        tonalElevation = 1.dp,
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = patient.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text("ID: ${patient.id}", style = MaterialTheme.typography.bodySmall)
                Text(
                    text = "Recent visit: ${patient.recentVisit}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text("${patient.age} yrs", style = MaterialTheme.typography.bodyMedium)
        }
    }
}



