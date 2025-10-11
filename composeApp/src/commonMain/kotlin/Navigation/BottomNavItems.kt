package Navigation

import androidx.compose.ui.graphics.Color


//User type enum


// Base sealed class for navigation items
sealed class BottomNavItems (
    val route: String,
    val title: String,
    val iconName: String,
    val selectedColor: Color = Color(0xFF2196F3), //Blue from design
    val unselectedColor: Color = Color(0xFF757575), //Grey from design
) {
    //Doctor Navigation items
    object DoctorPatients : BottomNavItems(
        route = "doctor_patients",
        title = "Patients",
        iconName = "people",
    )

    object DoctorSearch : BottomNavItems(
        route = "doctor_search",
        title = "Search",
        iconName = "search",
    )

    object AddPatient : BottomNavItems(
        route = "add_patient",
        title = "Add",
        iconName = "person_add",
    )

    object DoctorProfile : BottomNavItems(
        route = "doctor_profile",
        title = "Profile",
        iconName = "person",
    )

    // Patient Navigation Items
    object PatientVisits : BottomNavItems(
        route = "patient_visits",
        title = "Visits",
        iconName = "medical_services"
    )

    object PatientNotifications : BottomNavItems(
        route = "patient_notifications",
        title = "Notifications",
        iconName = "notifications"
    )

    object PatientFiles : BottomNavItems(
        route = "patient_files",
        title = "Files",
        iconName = "folder"
    )

    object PatientPrescription : BottomNavItems(
        route = "patient_prescription",
        title = "Rx",
        iconName = "medication"
    )
}

//Helper function to get navigation items based on user type
fun getNavigationItems(userType: UserType): List<BottomNavItems> {
    return when (userType) {
        UserType.DOCTOR -> listOf(
            BottomNavItems.DoctorPatients,
            BottomNavItems.DoctorSearch,
            BottomNavItems.AddPatient,
            BottomNavItems.DoctorProfile
        )
        UserType.PATIENT -> listOf(
            BottomNavItems.PatientVisits,
            BottomNavItems.PatientNotifications,
            BottomNavItems.PatientFiles,
            BottomNavItems.PatientPrescription
        )
    }
}