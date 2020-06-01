package com.br.domain.entity

import java.io.Serializable
import java.math.BigDecimal

data class Sodas(
    val sodasPrice: BigDecimal,
    val sodasDescription: String = "",
    val sodasImage: String,
    val sodas_name: String = ""
) : Serializable