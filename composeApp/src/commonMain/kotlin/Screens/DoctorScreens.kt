package Screens

import ProfileScreen
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unicare.CreatePatientScreen
import com.example.unicare.CustomSearchBar
import com.example.unicare.PatientSearchScreen
import com.example.unicare.Patient

@Composable
fun DoctorDashboard(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Doctor Dashboard", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun DoctorPatientsScreen(
    onClick: () -> Unit
){
    //Sample patient data
    val patients = listOf(
        "John Smith" to "*********0856",
        "Sarah Johnson" to "*********0857",
        "Michael Brown" to "*********0858",
        "Emily Davis" to "*********0859",
        "David Wilson" to "*********0860",
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        // Header
        Text(
            text = "Patients",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        //Patients list
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ){
            items(patients){ (name, id) ->
                // PatientListItem component inline
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .clickable {
                            //Handle patient item click
                            onClick()
                        }
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    //Left side - Patient Information
                    Column(
                        modifier = Modifier.weight(1f)
                    ){
                        Text(
                            text = name,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = id,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 14.sp
                        )
                    }

                    //Right side Chevron
                    Icon(
                        imageVector = Icons.Filled.ChevronRight,
                        contentDescription = "View patient details",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DoctorSearchScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Doctor - Search", style = MaterialTheme.typography.headlineMedium)
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

        PatientSearchScreen(patients)
    }
}

@Composable
fun AddPatientScreen(){
    CreatePatientScreen()
}

@Composable
fun DoctorProfileScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        ProfileScreen()
    }
}