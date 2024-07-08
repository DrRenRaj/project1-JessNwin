package edu.msudenver.cs3013.project1_s24.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.msudenver.cs3013.project1_s24.ui.theme.AlchemistElixirsTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.Person
import edu.msudenver.cs3013.project1_s24.repository.UserRepository
import edu.msudenver.cs3013.project1_s24.viewmodel.LoginViewModel
import edu.msudenver.cs3013.project1_s24.viewmodel.LoginViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlchemistElixirsTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = "login", modifier = Modifier.padding(innerPadding)) {
            composable("login") { LoginScreen(context = LocalContext.current) }
            composable("home") { HomeScreen() }
            composable("random_drink") { RandomDrinkScreen() }
            composable("calculator") { CalculatorScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = navController.currentDestination?.route == "home",
            onClick = { navController.navigate("home") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.LocalBar, contentDescription = "Random Drink") },
            label = { Text("Random Drink") },
            selected = navController.currentDestination?.route == "random_drink",
            onClick = { navController.navigate("random_drink") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Calculate, contentDescription = "Calculator") },
            label = { Text("Calculator") },
            selected = navController.currentDestination?.route == "calculator",
            onClick = { navController.navigate("calculator") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = navController.currentDestination?.route == "profile",
            onClick = { navController.navigate("profile") }
        )
    }
}

@Composable
fun HomeScreen() {
    // Home screen content
}

@Composable
fun RandomDrinkScreen() {
    val drinks = listOf("Mojito", "Martini", "Margarita", "Old Fashioned", "Cosmopolitan")
    val randomDrink = remember { drinks.random() }
    Text(text = "Your random drink is: $randomDrink")
}

@Composable
fun CalculatorScreen() {
    var ingredient by remember { mutableStateOf("") }
    var servingSize by remember { mutableStateOf("1") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = ingredient,
            onValueChange = { newValue -> ingredient = newValue },
            label = { Text("Ingredient") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = servingSize,
            onValueChange = { newValue -> servingSize = newValue },
            label = { Text("Serving Size") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        val result = (ingredient.toIntOrNull() ?: 0) * (servingSize.toIntOrNull() ?: 1)
        Text(text = "Total: $result")
    }
}

@Composable
fun ProfileScreen() {
    Text(text = "Profile Screen")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlchemistElixirsTheme {
        HomeScreen()
    }
}
