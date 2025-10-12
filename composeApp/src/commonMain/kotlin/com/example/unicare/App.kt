package com.example.unicare

import androidx.compose.runtime.*
import androidx.compose.material3.MaterialTheme
import Navigation.*
import OneLightColorScheme
import Screens.*


// Define your app states
enum class AppScreen {
    ONBOARDING,
    ROLE_SELECTION,
    SIGN_IN,
    SIGN_UP,
    DOCTOR_MAIN,
    PATIENT_MAIN
}

@Composable
fun App() {
    MaterialTheme(colorScheme = OneLightColorScheme) {
        UniCareApp()
    }
}

@Composable
fun UniCareApp() {
    var currentScreen by remember { mutableStateOf(AppScreen.ONBOARDING) }
    var currentUserType by remember { mutableStateOf(UserType.DOCTOR) }
    var currentRoute by remember { mutableStateOf("doctor_dashboard") }

    when (currentScreen) {
        AppScreen.ONBOARDING -> {
            OnboardingScreen(
                onGetStarted = { currentScreen = AppScreen.ROLE_SELECTION },
                onSkipToHome = {
                    currentUserType = UserType.PATIENT
                    currentScreen = AppScreen.PATIENT_MAIN
                    currentRoute = "patient_dashboard"
                }
            )
        }
        AppScreen.ROLE_SELECTION -> {
            RoleSelectionScreen(
                onDoctorSelected = {
                    currentUserType = UserType.DOCTOR
                    currentScreen = AppScreen.SIGN_IN
                },
                onPatientSelected = {
                    currentUserType = UserType.PATIENT
                    currentScreen = AppScreen.SIGN_IN
                },
                onBackClick = { currentScreen = AppScreen.ONBOARDING }
            )
        }
        AppScreen.SIGN_IN -> {
            SignInScreen(
                onSignInSuccess = {
                    when (currentUserType) {
                        UserType.DOCTOR -> {
                            currentScreen = AppScreen.DOCTOR_MAIN
                            currentRoute = "doctor_dashboard"
                        }
                        UserType.PATIENT -> {
                            currentScreen = AppScreen.PATIENT_MAIN
                            currentRoute = "patient_dashboard"
                        }
                    }
                },
                onSignUpClick = { currentScreen = AppScreen.SIGN_UP },
                onBackClick = { currentScreen = AppScreen.ROLE_SELECTION }
            )
        }
        AppScreen.SIGN_UP -> {
            SignUpScreen(
                onSignUpSuccess = {
                    when (currentUserType) {
                        UserType.DOCTOR -> {
                            currentScreen = AppScreen.DOCTOR_MAIN
                            currentRoute = "doctor_dashboard"
                        }
                        UserType.PATIENT -> {
                            currentScreen = AppScreen.PATIENT_MAIN
                            currentRoute = "patient_dashboard"
                        }
                    }
                },
                onSignInClick = { currentScreen = AppScreen.SIGN_IN },
                onBackClick = { currentScreen = AppScreen.SIGN_IN }
            )
        }
        AppScreen.DOCTOR_MAIN -> {
            DoctorMainScreen(
                currentRoute = currentRoute,
                onNavigationItemClick = { navItem ->
                    currentRoute = navItem.route
                },
                onBackToAuth = {
                    currentScreen = AppScreen.ROLE_SELECTION
                    currentRoute = "doctor_dashboard"
                }
            )
        }
        AppScreen.PATIENT_MAIN -> {
            PatientMainScreen(
                currentRoute = currentRoute,
                onNavigationItemClick = { navItem ->
                    currentRoute = navItem.route
                },
                onBackToAuth = {
                    currentScreen = AppScreen.ROLE_SELECTION
                    currentRoute = "patient_dashboard"
                }
            )
        }
    }
}

@Composable
fun DoctorMainScreen(
    currentRoute: String,
    onNavigationItemClick: (BottomNavItems) -> Unit,
    onBackToAuth: () -> Unit
) {
    androidx.compose.material3.Scaffold(
        bottomBar = {
            FloatingBottomNav(
                currentRoute = currentRoute,
                onItemClick = onNavigationItemClick,
                userType = UserType.DOCTOR
            )
        }
    ) { paddingValues ->
        when (currentRoute) {
            "doctor_patients" -> DoctorPatientsScreen()
            "doctor_search" -> DoctorSearchScreen()
            "add_patient" -> AddPatientScreen()
            "doctor_profile" -> DoctorProfileScreen()
            else -> DoctorPatientsScreen()
        }
    }
}

@Composable
fun PatientMainScreen(
    currentRoute: String,
    onNavigationItemClick: (BottomNavItems) -> Unit,
    onBackToAuth: () -> Unit
) {
    androidx.compose.material3.Scaffold(
        bottomBar = {
            FloatingBottomNav(
                currentRoute = currentRoute,
                onItemClick = onNavigationItemClick,
                userType = UserType.PATIENT
            )
        }
    ) { paddingValues ->
        when (currentRoute) {
            "patient_visits" -> PatientVisitsScreen()
            "patient_notifications" -> PatientNotificationsScreen()
            "patient_files" -> PatientFilesScreen()
            "patient_prescription" -> PatientPrescriptionScreen()
            "patient_profile" -> PatientProfileScreen()
            else -> PatientVisitsScreen()
        }
    }
}