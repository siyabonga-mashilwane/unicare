import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Picture
//        Icon(
//
//            contentDescription = "Profile Picture",
//            modifier = Modifier
//                .size(120.dp)
//                .padding(8.dp)
//                .clip(CircleShape),
//            contentScale = ContentScale.Crop
//        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name
        Text(
            text = "Siyabonga Mashilwane",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Email
        Text(
            text = "siyabonga@example.com",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Job Title
        Text(
            text = "Surgeon",
            fontSize = 18.sp
        )

        // Location
        Text(
            text = "Johannesburg, Gauteng",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Edit Button
        Button(onClick = { /* TODO: Add edit functionality */ }) {
            Text("Edit Profile")
        }
    }
}