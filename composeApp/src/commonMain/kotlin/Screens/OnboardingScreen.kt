package Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import com.example.unicare.UIComponents.ButtonFactory
import com.example.unicare.UIComponents.ButtonType

@Composable
fun OnboardingScreen(
    onGetStarted: () -> Unit,
    onSkipToHome: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //Welcome Text
        Text(
            text = "Welcome to\nUnicare",
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        //Subtitle
        Text(
            text = "Your complete healthcare solution",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        //Get Started Button
        ButtonFactory.CreateButton(
            text = "Get Started",
            type = ButtonType.LARGE,
            rounded = true,
            onClickAction = onGetStarted,

        )
    }
}