package Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons

@Composable
fun PatientVisitsScreen(){
    val visits = listOf(
        "15/01/2024" to "Annual Physical",
        "09/03/2025" to "Special Referral",
        "20/09/2025" to "Vaccinations"
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ){
        Text(
            text = "Health Care Visits",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        //Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Visit Type",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        // Visits list
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(visits){ visit ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = visit.first, //date
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = visit.second, //type
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PatientNotificationsScreen() {
    @Composable
    fun PatientNotificationsScreen() {
        val notifications = listOf(
            "Prescription collection due",
            "Appointment reminder: Annual Physical tomorrow",
            "New test results available",
            "Insurance claim processed",
            "Doctor's note added to your file"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {


            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(notifications) { notification ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "•",
                                modifier = Modifier.padding(end = 8.dp),
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = notification,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PatientFilesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Text(
            text = "Files",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        //Patient infor header
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(
                    text = "Patient ID: *********0856 | DOB: March 15, 1985 (Age 40) | Gender: Male",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Last Updated: 21 September 2025",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Access Notes: Viewable by patient with consent. Sensitive sections redacted. Contact doctor for questions.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 12.sp
                )
            }
        }
    }

    // Personal & Demographic info
    InfoSection(title = "Personal & Demographic Info"){
        InfoItem("Name", "Simon Grimsby")
        InfoItem("Contact", "087 569 3214")
        InfoItem("Address", "123 Elm St, Anytown, RSA 12345")
        InfoItem("Emergency Contact", "Jane Grimsby (Spouse) - 086 594 0944")
        InfoItem("Insurance", "Discovery | Policy: BC-789012 | Active (1 Jan 2024)")

    }

    Spacer(modifier = Modifier.height(16.dp))

    // Medical History
    InfoSection(title = "Medical History"){
        InfoItem("Diabetes Notes", "Type 2; A1C 7.2% (Target <7.0%); Complications: Mild neuropathy; Goals: Diet Control, quarterly eye exams.")
        InfoItem("Hospitalizations", "15 July 2022 (Hyperglycemia ER; 2-day stay, insulin started)")
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Lab & Test Results
    InfoSection(title = "Lab & Test Results"){
        InfoItem("Blood work (15 Aug 2025)", "HbA1c 7.2% (High); Fasting Glucose 142 mg/dL (high); Chol 185 mg/dL (Normal); BP 128/82 (Borderline)")
        InfoItem("Imaging", "MRI Abdomen (July 2023: Normal); Retinal Exam (May 2025: No retinopathy)")
    }
}


@Composable
fun PatientPrescriptionScreen(){
    val prescriptions = listOf(
        Triple("ER", "1000 mg Tablest", "30 days"),
        Triple("Lisinopril", "20 mg Tablet", "30 days"),
        Triple("Atorvastatin", "20 mg Tablet", "30 days"),
        Triple("Levothyroxin", "75 mcg Tablet", "30 days"),
        Triple("Aspirin", "61 mg Tablet", "30 days")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ){
        Text(
            text = "Prescriptions",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        //Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Medication",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(2f)
            )
            Text(
                text = "Dose & Form",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(2f)
            )
            Text(
                text = "Days Supply",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
        }

        // Prescriptions list
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(prescriptions){ (med, dose, supply) ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = med,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(2f)
                        )
                        Text(
                            text = dose,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(2f)
                        )
                        Text(
                            text = supply,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PatientProfileScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Patient Profile", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun InfoSection(title: String, content: @Composable () -> Unit){
    Card(
        modifier = Modifier.fillMaxWidth()
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            content()
        }
    }
}

@Composable
fun InfoItem(label: String, value: String){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ){
        Text(
            text = " - $label:",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}