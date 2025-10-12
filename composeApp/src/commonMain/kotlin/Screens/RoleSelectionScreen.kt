package Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import Navigation.*

@Composable
fun RoleSelectionScreen(
    onDoctorSelected: () -> Unit,
    onPatientSelected: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ){
        // Back Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            com.example.unicare.UIComponents.ButtonFactory.BackButton(
                text = "Back",
                onClick = onBackClick
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        //Title
        Text (
            text = "Select Your Role",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        //Subtitle
        Text(
            text = "Choose how you want to use UniCare",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        //Doctor Card
        Card(
            onClick =  onDoctorSelected,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(bottom = 20.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Text(
                        text = "🧑‍⚕️",
                        style = MaterialTheme.typography.displayMedium
                    )
                    Column{
                        Text(
                            text = "I'm a Doctor",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            text = "Manage patients anf appointments",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        //Patient Card
        Card(
            onClick = onPatientSelected,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Text(
                        text = "👤",
                        style = MaterialTheme.typography.displayMedium
                    )
                    Column{
                        Text(
                            text = "I'm a Patient",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            text = "Book appointments and manage health",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}