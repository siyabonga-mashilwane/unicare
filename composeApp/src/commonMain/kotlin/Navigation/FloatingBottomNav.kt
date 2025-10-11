package Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FloatingBottomNav(
    currentRoute: String,
    onItemClick: (BottomNavItems) -> Unit,
    userType: UserType = UserType.DOCTOR
){
    val navItems = getNavigationItems(userType)

    // Floating container
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(80.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(25.dp),
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
                    onClick = { onItemClick(item) }
                )
            }
        }
    }
}

@Composable
fun NavigationItem(
    item: BottomNavItems,
    isSelected: Boolean,
    onClick: () -> Unit
){
    val contentColor = if (isSelected) item.selectedColor else item.unselectedColor

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp)

    ){
        // Icon container with background when selected
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(
                    color = if (isSelected) contentColor.copy(alpha = 0.15f)
                        else Color.Transparent,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ){
            // Using emojis for cross-platform compatibility
            Text(
                text = getIconEmoji(item.iconName),
                fontSize = 18.sp,
                color = contentColor
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = item.title,
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
        )
    }
}

//Helper function to get emoji placeholders for icons
fun getIconEmoji(iconName: String): String{
    return when(iconName){
        "people" -> "👥" //people emoji
        "search" -> "🔍" // magnifying glass emoji
        "person_add" -> "➕" // plus emoji
        "person" -> "👤" //person emoji
        "medical_services" -> "🏥" // hospital emoji
        "notifications" -> "🔔" // bell emoji
        "folder" -> "📁" // file folder emoji
        "medication" -> "💊" // pill emoji
        else -> "o" //fall back circle
    }
}
