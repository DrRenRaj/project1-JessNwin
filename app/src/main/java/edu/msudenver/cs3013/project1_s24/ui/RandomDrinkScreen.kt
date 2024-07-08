package edu.msudenver.cs3013.project1_s24.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.msudenver.cs3013.project1_s24.viewmodel.DrinkViewModel

@Composable
fun RandomDrinkScreen(drinkViewModel: DrinkViewModel = viewModel()) {
    val drink = drinkViewModel.getRandomDrink()
    Text(text = "Your random drink is: ${drink.name}\nIngredients: ${drink.ingredients.joinToString()}")
}