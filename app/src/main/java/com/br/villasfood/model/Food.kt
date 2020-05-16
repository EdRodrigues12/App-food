package com.br.villasfood.model

import java.io.Serializable
import java.math.BigDecimal

class Food (val price: BigDecimal,
            val description: String = "",
            val image: String,
            val food_name: String = ""
            ): Serializable