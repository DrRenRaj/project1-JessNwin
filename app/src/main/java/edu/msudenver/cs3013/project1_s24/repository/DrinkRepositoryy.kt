package edu.msudenver.cs3013.project1_s24.repository

import edu.msudenver.cs3013.project1_s24.model.Drink

class DrinkRepository {
    private val drinks = listOf(
        Drink("Mojito", listOf("Rum", "Mint", "Sugar", "Lime", "Soda")),
        Drink("Martini", listOf("Gin", "Vermouth", "Olive")),
        Drink("Margarita", listOf("Tequila", "Triple sec", "Lime juice")),
        Drink("Old Fashioned", listOf("Whiskey", "Sugar", "Bitters", "Orange")),
        Drink("Cosmopolitan", listOf("Vodka", "Triple sec", "Cranberry juice", "Lime juice"))
    )

    fun getRandomDrink(): Drink {
        return drinks.random()
    }
}