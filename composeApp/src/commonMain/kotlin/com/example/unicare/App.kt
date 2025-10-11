package com.example.unicare

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import Navigation.*
import Screens.*

@Composable
fun App(){
    var currentScreen by remember {mutableStateOf("splash")} //start with splash
    var userType by remember {mutableStateOf(UserType.DOCTOR)}

    MaterialTheme {
        Box(Modifier.fillMaxSize()) {
            // show appropriate screens based on user type and current screen
            when{
                currentScreen == "splash" -> SplashScreen(
                    onLoadingComplete = {
                        currentScreen = "onboarding"
                    }
                )

                currentScreen == "onboarding" -> OnboardingScreen(
                    onGetStarted = { currentScreen = "signin" },
                    onSkipToHome = {
                        currentScreen = if (userType == UserType.DOCTOR)
                            "doctor_dashboard" else "patient_dashboard"
                    }
                )

                currentScreen == "signin" -> SignInScreen(
                    onSignInSuccess = {
                        currentScreen = if (userType == UserType.DOCTOR)
                            "doctor_dashboard" else "patient_dashboard"
                    },

                    onSignUpClick = { currentScreen = "signup" },
                    onBackClick = { currentScreen = "onboarding" }
                )

                currentScreen == "signup" -> SignUpScreen(
                    onSignUpSuccess = {
                        currentScreen = if (userType == UserType.DOCTOR)
                            "doctor_dashboard" else "patient_dashboard"
                    },
                    onSignInClick = { currentScreen = "signin" },
                    onBackClick = { currentScreen = "onboarding" }
                )

                currentScreen == "home" -> HomeScreen(
                    onDoctorClick = {
                            userType = UserType.DOCTOR
                            currentScreen = "doctor_dashboard"
                    },
                    onPatientClick = {
                        userType = UserType.PATIENT
                        currentScreen = "patient_dashboard"
                    }
                )

                userType == UserType.DOCTOR -> {
                    when (currentScreen) {
                        "doctor_dashboard" -> DoctorDashboard()
                        "doctor_patients" -> DoctorPatientsScreen()
                        "doctor_search" -> DoctorSearchScreen()
                        "add_patient" -> AddPatientScreen()
                        "doctor_profile" -> DoctorProfileScreen()
                        else -> DoctorDashboard()
                    }
                }

                userType == UserType.PATIENT -> {
                    when (currentScreen) {
                        "patient_dashboard" -> PatientDashboard()
                        "patient_visits" -> PatientVisitsScreen()
                        "patient_notifications" -> PatientNotificationsScreen()
                        "patient_files" -> PatientFilesScreen()
                        "patient_prescription" -> PatientPrescriptionScreen()
                        "patient_profile" -> PatientProfileScreen()
                        else -> PatientDashboard()
                    }
                }
            }

            // Show bottom nav only on main app screens, not auth screens
            val showBottomNav = when(currentScreen) {
                "splash", "onboarding", "signin", "signup", "home" -> false
                else -> true
            }

            if (showBottomNav) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                ){
                    FloatingBottomNav(
                        currentRoute = currentScreen,
                        onItemClick = { item ->
                            currentScreen = item.route
                        },
                        userType = userType
                    )
                }
            }
        }
    }
}

