package com.br.villasfood.model

import java.io.Serializable
import java.math.BigDecimal

class Sodas(
    val price: BigDecimal,
    val description: String = "",
    val image: String,
    val sodas_name: String = ""
) : Serializable