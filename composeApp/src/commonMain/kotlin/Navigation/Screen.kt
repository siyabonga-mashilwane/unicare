package Navigation

import androidx.compose.ui.graphics.Color

//User type enum
enum class UserType {
    DOCTOR, PATIENT
}

sealed class Screen(val route: String) {
    //Auth & Main
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object SignIn : Screen("signin")
    object SignUp : Screen("signup")
    object Home : Screen("home")

    // Doctor Screens
    object DoctorDashboard : Screen("doctor_dashboard")
    object DoctorPatients : Screen("doctor_patients")
    object DoctorSearch : Screen("doctor_search")
    object AddPatient : Screen("add_patient")
    object DoctorProfile : Screen("doctor_profile")

    // Patient Screens
    object PatientDashboard : Screen("patient_dashboard")
    object PatientProfile : Screen("patient_profile")
    object PatientVisits : Screen("patient_visits")
    object PatientNotifications : Screen("patient_notifications")
    object PatientPrescription : Screen("patient_prescription")
    object PatientFiles : Screen("patient_files")
    //Add other patient screens as needed
}

// Helper function for navigation
fun String?.toScreen(): Screen{
    return when (this) {
        Screen.Splash.route -> Screen.Splash
        Screen.Onboarding.route -> Screen.Onboarding
        Screen.SignIn.route -> Screen.SignIn
        Screen.SignUp.route -> Screen.SignUp
        Screen.Home.route -> Screen.Home

        // Doctor screens
        Screen.DoctorDashboard.route -> Screen.DoctorDashboard
        Screen.DoctorPatients.route -> Screen.DoctorPatients
        Screen.DoctorSearch.route -> Screen.DoctorSearch
        Screen.AddPatient.route -> Screen.AddPatient
        Screen.DoctorProfile.route -> Screen.DoctorProfile

        //Patient screens
        Screen.PatientDashboard.route -> Screen.PatientDashboard
        Screen.PatientProfile.route -> Screen.PatientProfile
        Screen.PatientPrescription.route -> Screen.PatientPrescription
        Screen.PatientNotifications.route -> Screen.PatientNotifications
        Screen.PatientVisits.route -> Screen.PatientVisits
        Screen.PatientFiles.route -> Screen.PatientFiles


        else -> Screen.Home //default
    }
}
