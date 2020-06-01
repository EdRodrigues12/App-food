package com.br.domain.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.io.Serializable
import java.math.BigDecimal

data class Cart(
//    @PrimaryKey(autoGenerate = true)
//    val id_cart: Long = 0,
//    @Embedded
//    val iten: Itens,
//    @Relation(parentColumn ="id_itens", entityColumn = "id_itens")
//    val itens: MutableList<Itens>
    val price: BigDecimal,
    val description: String = "",
    val image: String,
    val name: String = ""
): Serializable
