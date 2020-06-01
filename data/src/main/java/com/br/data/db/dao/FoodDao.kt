package com.br.data.db.dao

import com.br.domain.entity.Food
import java.math.BigDecimal
import java.util.*

class FoodDao {
     companion object {
        fun lista(): List<com.br.domain.entity.Food?>? {
            return ArrayList<com.br.domain.entity.Food>(
                Arrays.asList<com.br.domain.entity.Food>(
                    com.br.domain.entity.Food(
                        BigDecimal(20.99),
                        "Pão hamburguer, hamburguer, queijo, alface, maionese, tomate",
                        "x_salada",
                        "01 - X-Salada"
                    ),
                    com.br.domain.entity.Food(
                        BigDecimal(25.50),
                        "Pão hamburguer, hamburguer, queijo",
                        "double_cheeseburger",
                        "02 - X-Burger"
                    ),
                    com.br.domain.entity.Food(
                        BigDecimal(28.20),
                        "Pão hamburguer, hamburguer, queijo, bacon, alface, maionese",
                        "x_bacon",
                        "03 - X - Bacon"
                    ),
                    com.br.domain.entity.Food(
                        BigDecimal(22.99),
                        "Pão hamburguer, hamburguer, queijo, ovo, alface, maionese, tomate",
                        "x_egg",
                        "04 - X - Egg"
                    ),
                    com.br.domain.entity.Food(
                        BigDecimal(30.99),
                        "Pão hamburguer, hamburguer, creme de milho, queijo, bacon",
                        "big_burguer",
                        "05 - Big Burger"
                    ),
                    com.br.domain.entity.Food(
                        BigDecimal(35.99),
                        "Pão hamburguer, 2 hamburguers, queijo, tomate, alface, maionese",
                        "burguer_especial",
                        "06 - Especial"
                    )
                )
            )
        }
    }
}
