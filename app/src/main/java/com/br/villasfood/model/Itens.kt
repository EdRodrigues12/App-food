package com.br.villasfood.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Itens(
    @PrimaryKey(autoGenerate = true)
    val id_itens: Long = 0,
    @Embedded
    var food: Food?,
    @Embedded
    val wine: Wine?,
    @Embedded
    val sodas: Sodas?
): Serializable