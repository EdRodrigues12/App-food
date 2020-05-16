package com.br.villasfood.dao

import com.br.villasfood.model.Food
import com.google.gson.Gson
import org.json.JSONArray
import java.math.BigDecimal
import java.util.*

class FoodDao {
     companion object {
        fun lista(): List<Food?>? {
            return ArrayList<Food>(
                Arrays.asList<Food>(
                    Food(BigDecimal(20.99), "Pão hamburguer, hamburguer, queijo, alface, maionese, tomate", "x_salada", "01 - X-Salada"),
                    Food(BigDecimal(25.50), "Pão hamburguer, hamburguer, queijo", "double_cheeseburger", "02 - X-Burger"),
                    Food(BigDecimal(28.20), "Pão hamburguer, hamburguer, queijo, bacon, alface, maionese", "x_bacon", "03 - X - Bacon"),
                    Food(BigDecimal(22.99), "Pão hamburguer, hamburguer, queijo, ovo, alface, maionese, tomate", "x_egg", "04 - X - Egg"),
                    Food(BigDecimal(30.99), "Pão hamburguer, hamburguer, creme de milho, queijo, bacon", "big_burguer", "05 - Big Burger"),
                    Food(BigDecimal(35.99), "Pão hamburguer, 2 hamburguers, queijo, tomate, alface, maionese", "burguer_especial", "06 - Especial")
                )
            )
        }
    }
}
