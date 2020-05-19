package com.br.villasfood.model

import java.io.Serializable
import java.math.BigDecimal

data class Wine (
    val winePrice: BigDecimal,
    val wineDescription: String = "",
    val wineImage: String,
    val wine_name: String = ""
) : Serializable