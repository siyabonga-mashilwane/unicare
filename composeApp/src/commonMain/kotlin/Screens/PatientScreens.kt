package Screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PatientDashboard(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Patient Dashboard", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun PatientVisitsScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Patient - Visits", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun PatientNotificationsScreen(){

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Patient - Notifications", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun PatientFilesScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Patient - Files", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun PatientPrescriptionScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Patient - Prescription", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun PatientProfileScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Patient Profile", style = MaterialTheme.typography.headlineMedium)
    }
}