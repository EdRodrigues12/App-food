package com.br.data.db.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverter {

    @TypeConverter
    fun paraDouble(valor: BigDecimal): Double? {
        return valor.toDouble()
    }

    @TypeConverter
    fun paraBigDecimal(valor: Double?): BigDecimal? {
        return valor?.let { BigDecimal(it) } ?: BigDecimal.ZERO
    }
}