package com.example.unicare

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.unicare.ui.theme.UniCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    UniCareTheme {
        // Shared patient list across screens
        var patients by remember {
            mutableStateOf(
                listOf(
                    Patient("Ofentse Masia", "SG-4782", 40, "09/03/2025"),
                    Patient("Refentje Mkhabela", "JD-2024", 32, "15/01/2024"),
                    Patient("Siyabonga Mashilwane", "AM-9123", 29, "20/09/2025"),
                    Patient("Zanele Khumalo", "ZK-1001", 44, "21/08/2025"),
                    Patient("Peter Daniels", "PD-7777", 51, "18/06/2025")
                )
            )
        }

        // Tracks current screen view
        var currentScreen by remember { mutableStateOf("patients") }

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            when (currentScreen) {
                                "patients" -> "UniCare Patients"
                                "create_patient" -> "Add New Patient"
                                "components" -> "Components"
                                else -> "UniCare"
                            }
                        )
                    },
                    actions = {
                        // Navigation toggle button in top bar
                        TextButton(onClick = {
                            currentScreen = when (currentScreen) {
                                "patients" -> "components"
                                "components" -> "patients"
                                else -> "patients"
                            }
                        }) {
                            Text(
                                if (currentScreen == "patients") "Go to Components" else "Go to Patients",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when (currentScreen) {
                    // 🩺 Patient list + search + FAB to add
                    "patients" -> PatientSearchScreen(
                        patients = patients,
                        onAddPatientClick = { currentScreen = "create_patient" }
                    )

                    // ➕ Create new patient screen
                    "create_patient" -> CreatePatientScreen(
                        onPatientAdded = { newPatient ->
                            patients = listOf(newPatient) + patients
                            currentScreen = "patients"
                        }
                    )

                    // 🧩 Components screen
                    "components" -> TextComponentScreen()
                }
            }
        }
    }
}


