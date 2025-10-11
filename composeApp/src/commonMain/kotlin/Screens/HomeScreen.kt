package Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onDoctorClick: () -> Unit,
    onPatientClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Welcome to Unicare",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Select your role",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        //Doctor Card
        Card(
            onClick = onDoctorClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text("🧑‍⚕️", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "I'm a Doctor",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }

        // Patient Card
        Card(
            onClick = onPatientClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            elevation = CardDefaults.cardElevation(8.dp)

        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text("👤", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "I'm a Patient",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}