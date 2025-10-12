package Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.unicare.UIComponents.ButtonFactory
import com.example.unicare.UIComponents.ButtonType

@Composable
fun SignInScreen(
    onSignInSuccess:() -> Unit,
    onSignUpClick: () -> Unit,
    onBackClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ){
        //Back Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ){
            ButtonFactory.BackButton(
                text = "Back",
                onClick = onBackClick
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        //Title
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        //Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = MaterialTheme.shapes.medium
        )

        //password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            shape = MaterialTheme.shapes.medium
        )

        //Sign In Button
        ButtonFactory.CreateButton(
            text = "Sign In",
            type = ButtonType.LARGE,
            rounded = true,
            onClickAction = onSignInSuccess
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Sign Up Link
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            TextButton(onClick = onSignUpClick) {
                Text("Don't have an account? Sign Up")
            }
        }
    }
}