package com.br.villasfood.model

import java.io.Serializable
import java.math.BigDecimal

class Wine (
    val price: BigDecimal,
    val description: String = "",
    val image: String,
    val wine_name: String = ""
) : Serializable