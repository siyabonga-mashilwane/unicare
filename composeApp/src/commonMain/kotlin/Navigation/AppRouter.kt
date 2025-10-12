package Navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import Screens.*
import kotlinx.coroutines.delay

@Composable
fun AppRouter() {
    val navigator = rememberAppNavigator()
    var userRole by remember { mutableStateOf<UserType?>(null) }

    //Start with splash if no screens in stack
    if (navigator.backStack.isEmpty()) {
        navigator.navigateTo(Screen.Splash)
    }

    AppRouterContent(
        navigator = navigator,
        userRole = userRole,
        onUserRoleSelected = { role ->
            userRole = role
        }
    )
}

@Composable
fun AppRouterContent(
    navigator: AppNavigator,
    userRole: UserType?,
    onUserRoleSelected: (UserType?) -> Unit
) {
    val currentScreen = navigator.currentScreen

    BoxWithBottomNav(
        navigator = navigator,
        userType = userRole ?: UserType.DOCTOR, //Default to Doctor if not selected
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
                onSkipToHome = { navigator.navigateAndReplace(Screen.RoleSelection) }
            )

            is Screen.SignIn -> SignInScreen(
                onSignInSuccess = {
                    navigator.navigateAndReplace(Screen.RoleSelection)
                },
                onSignUpClick = { navigator.navigateTo(Screen.SignUp) },
                onBackClick = { navigator.goBack() }
            )

            is Screen.SignUp -> SignUpScreen(
                onSignUpSuccess = {
                    navigator.navigateAndReplace(Screen.RoleSelection)
                },
                onSignInClick = { navigator.navigateTo(Screen.SignIn) },
                onBackClick = { navigator.goBack() }
            )

            // Role Selection
            is Screen.RoleSelection -> RoleSelectionScreen(
                onDoctorSelected = {
                    onUserRoleSelected(UserType.DOCTOR)
                    navigator.navigateAndReplace(Screen.DoctorDashboard)
                },
                onPatientSelected = {
                    onUserRoleSelected(UserType.PATIENT)
                    navigator.navigateAndReplace(Screen.PatientDashboard)
                },
                onBackClick = { navigator.goBack() }
            )

            // Home Screen (if you have one)
            is Screen.Home -> HomeScreen(
                onDoctorClick = {
                    navigator.navigateTo(Screen.DoctorDashboard)
                },
                onPatientClick = {
                    navigator.navigateTo(Screen.PatientDashboard)
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
        Screen.Splash, Screen.Onboarding, Screen.SignIn, Screen.SignUp, Screen.Home, Screen.RoleSelection-> false
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