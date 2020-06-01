package com.br.domain.entity

import java.io.Serializable
import java.math.BigDecimal

data class Wine (
    val winePrice: BigDecimal,
    val wineDescription: String = "",
    val wineImage: String,
    val wine_name: String = ""
) : Serializable