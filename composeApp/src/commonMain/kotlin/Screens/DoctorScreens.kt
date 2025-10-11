package Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DoctorDashboard(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Doctor Dashboard", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun DoctorPatientsScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Doctor - Patients", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun DoctorSearchScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Doctor - Search", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun AddPatientScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Add Patient", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun DoctorProfileScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Doctor Profile", style = MaterialTheme.typography.headlineMedium)
    }
}