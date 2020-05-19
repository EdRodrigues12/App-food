package com.br.villasfood.model

import androidx.room.Entity
import java.io.Serializable
import java.math.BigDecimal


data class Food (
    val foodPrice: BigDecimal,
    val food_description: String = "",
    val food_image: String,
    val food_name: String = ""
            ): Serializable