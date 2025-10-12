package Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FloatingBottomNav(
    currentRoute: String,
    onItemClick: (BottomNavItems) -> Unit,
    userType: UserType = UserType.DOCTOR,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
){
    val navItems = getNavigationItems(userType)

    // Floating container
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(70.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(35.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            navItems.forEach { item ->
                NavigationItem(
                    item = item,
                    isSelected = currentRoute == item.route,
                    onClick = { onItemClick(item) },
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor
                )
            }
        }
    }
}

@Composable
fun NavigationItem(
    item: BottomNavItems,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedColor: Color,
    unselectedColor: Color
){
    val contentColor = if (isSelected) item.selectedColor else item.unselectedColor
    val backgroundColor = if (isSelected) item.selectedColor.copy(alpha = 0.1f) else Color.Transparent

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 6.dp)
            .height(56.dp)

    ){
        // Icon container with background when selected
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(
                    color = backgroundColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ){
            // Using proper Material icons
            Icon(
                imageVector = getMaterialIcon(item.iconName, isSelected),
                contentDescription = item.title,
                tint = contentColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = item.title,
            color = contentColor,
            fontSize = 10.sp,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            maxLines = 1
        )
    }
}

//Helper function to get emoji placeholders for icons
fun getMaterialIcon(iconName: String, isSelected: Boolean): ImageVector{
    return when(iconName){
        "people" -> if(isSelected) Icons.Filled.People else Icons.Outlined.Person
        "search" -> if (isSelected) Icons.Filled.Search else Icons.Outlined.Search
        "person_add" -> if (isSelected) Icons.Filled.PersonAdd else Icons.Outlined.PersonAdd
        "person" -> if (isSelected) Icons.Filled.Person else Icons.Outlined.Person
        "medical_services" -> if (isSelected) Icons.Filled.MedicalServices else Icons.Outlined.MedicalServices
        "notifications" -> if (isSelected) Icons.Filled.Notifications else Icons.Outlined.PersonAdd
        "folder" -> if (isSelected) Icons.Filled.Folder else Icons.Outlined.Folder
        "medication" -> if (isSelected) Icons.Filled.Medication else Icons.Outlined.Medication

        else -> if (isSelected) Icons.Filled.Circle else Icons.Outlined.Circle
    }
}
