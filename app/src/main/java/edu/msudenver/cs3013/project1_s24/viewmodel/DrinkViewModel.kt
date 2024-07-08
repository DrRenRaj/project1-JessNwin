package edu.msudenver.cs3013.project1_s24.viewmodel

import androidx.lifecycle.ViewModel
import edu.msudenver.cs3013.project1_s24.model.Drink
import edu.msudenver.cs3013.project1_s24.repository.DrinkRepository

class DrinkViewModel(private val drinkRepository: DrinkRepository) : ViewModel() {
    fun getRandomDrink(): Drink {
        return drinkRepository.getRandomDrink()
    }
}