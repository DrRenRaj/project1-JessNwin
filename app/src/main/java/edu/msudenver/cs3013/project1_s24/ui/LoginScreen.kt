package edu.msudenver.cs3013.project1_s24.ui

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.msudenver.cs3013.project1_s24.viewmodel.LoginViewModel
import edu.msudenver.cs3013.project1_s24.viewmodel.LoginViewModelFactory
import edu.msudenver.cs3013.project1_s24.repository.UserRepository

@Composable
fun LoginScreen(context: Context) {
    val userRepository = remember { UserRepository() }
    val loginViewModel: LoginViewModel = viewModel(factory = LoginViewModelFactory(userRepository))

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoginMode by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = username,
            onValueChange = { newValue -> username = newValue },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { newValue -> password = newValue },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (isLoginMode) {
                    if (loginViewModel.login(username, password)) {
                        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                        context.startActivity(Intent(context, MainActivity::class.java))
                    } else {
                        Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    loginViewModel.signup(username, password)
                    Toast.makeText(context, "Sign up successful", Toast.LENGTH_SHORT).show()
                    isLoginMode = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isLoginMode) "Login" else "Sign Up")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { isLoginMode = !isLoginMode }) {
            Text(if (isLoginMode) "Don't have an account? Sign Up" else "Already have an account? Login")
        }
    }
}
