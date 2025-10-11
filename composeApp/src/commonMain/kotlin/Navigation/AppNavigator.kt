package Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class AppNavigator {
    internal val backStack = mutableListOf<Screen>()

    val currentScreen: Screen
        get() = backStack.lastOrNull() ?: Screen.Splash

    val currentRoute: String
        get() = currentScreen.route

    fun navigateTo(screen: Screen) {
        backStack.add(screen)
    }

    fun navigateAndReplace(screen: Screen) {
        backStack.clear()
        backStack.add(screen)
    }

    fun goBack(): Boolean {
        if (backStack.size > 1){
            backStack.removeAt(backStack.size - 1)
            return true
        }
        return false
    }

    fun getUserType(): UserType {
        return when(currentScreen) {
            is Screen.DoctorDashboard,
            is Screen.DoctorPatients,
            is Screen.DoctorSearch,
            is Screen.AddPatient,
            is Screen.DoctorProfile -> UserType.DOCTOR

            is Screen.PatientDashboard,
            is Screen.PatientVisits,
            is Screen.PatientNotifications,
            is Screen.PatientFiles,
            is Screen.PatientPrescription,
            is Screen.PatientProfile -> UserType.PATIENT

            else -> UserType.DOCTOR //default
        }
    }
}

@Composable
fun rememberAppNavigator(): AppNavigator {
    return remember { AppNavigator() }
}