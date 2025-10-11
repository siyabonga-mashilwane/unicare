package Navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import Screens.*

@Composable
fun AppRouter() {
    val navigator = rememberAppNavigator()

    //Start with splash if no screens in stack
    if (navigator.backStack.isEmpty()) {
        navigator.navigateTo(Screen.Splash)
    }

    AppRouterContent(navigator = navigator)
}

@Composable
fun AppRouterContent(navigator: AppNavigator) {
    val currentScreen = navigator.currentScreen
    val userType = navigator.getUserType()

    BoxWithBottomNav(
        navigator = navigator,
        userType = userType,
        currentRoute = navigator.currentRoute
    ){
        when (currentScreen) {
            //Auth FLow
            is Screen.Splash -> SplashScreen(
                onLoadingComplete = {
                    navigator.navigateAndReplace(Screen.Onboarding)
                }
            )

            is Screen.Onboarding -> OnboardingScreen(
                onGetStarted = { navigator.navigateAndReplace(Screen.SignIn) },
                onSkipToHome = { navigator.navigateAndReplace(Screen.Home) }
            )

            is Screen.SignIn -> SignInScreen(
                onSignInSuccess = {
                    //After sign in, go to appropriate dashboard based on user type
                    val dashboard = if(userType == UserType.DOCTOR)
                        Screen.DoctorDashboard else Screen.PatientDashboard
                    navigator.navigateAndReplace(dashboard)
                },
                onSignUpClick = { navigator.navigateTo(Screen.SignUp) },
                onBackClick = { navigator.goBack() }
            )

            is Screen.SignUp -> SignUpScreen(
                onSignUpSuccess = {
                    val dashboard = if(userType == UserType.DOCTOR)
                        Screen.DoctorDashboard else Screen.PatientDashboard
                    navigator.navigateAndReplace(dashboard)
                },
                onSignInClick = { navigator.navigateTo(Screen.SignIn) },
                onBackClick = { navigator.goBack() }
            )

            is Screen.Home -> HomeScreen(
                onDoctorClick = {
                    navigator.navigateTo(Screen.DoctorDashboard)
                },
                onPatientClick = {
                    navigator.navigateTo(Screen.PatientProfile)
                }
            )

            //Doctor Screens
            is Screen.DoctorDashboard -> DoctorDashboard()
            is Screen.DoctorPatients -> DoctorPatientsScreen()
            is Screen.DoctorSearch -> DoctorSearchScreen()
            is Screen.AddPatient -> AddPatientScreen()
            is Screen.DoctorProfile -> DoctorProfileScreen()

            //Patient Screens
            is Screen.PatientDashboard -> PatientDashboard()
            is Screen.PatientVisits -> PatientVisitsScreen()
            is Screen.PatientNotifications -> PatientNotificationsScreen()
            is Screen.PatientFiles -> PatientFilesScreen()
            is Screen.PatientPrescription -> PatientPrescriptionScreen()
            is Screen.PatientProfile -> PatientProfileScreen()
        }
    }
}

@Composable
fun BoxWithBottomNav(
    navigator: AppNavigator,
    userType: UserType,
    currentRoute: String,
    content: @Composable () -> Unit
) {
    val showBottomNav = when (navigator.currentScreen) {
        Screen.Splash, Screen.Onboarding, Screen.SignIn, Screen.SignUp, Screen.Home -> false
        else -> true
    }

    Scaffold(
        bottomBar = {
            if (showBottomNav) {
                FloatingBottomNav(
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navigator.navigateTo(item.route.toScreen())
                    },
                    userType = userType
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            content()
        }
    }
}