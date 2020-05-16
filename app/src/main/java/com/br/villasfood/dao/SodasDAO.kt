package com.br.villasfood.dao

import com.br.villasfood.model.Sodas
import java.math.BigDecimal
import java.util.*

class SodasDAO {
    companion object {
        fun lista(): List<Sodas?>? {
            return ArrayList<Sodas>(
                Arrays.asList<Sodas>(
                    Sodas(BigDecimal(11.99), "Coca-Cola 2 Litros", "coca_2l", "01 - Coca-Cola 2L"),
                    Sodas(BigDecimal(8.50), "Fanta Guarana 2 Litros", "fanta_gua", "02 - Fanta Guarana 2L"),
                    Sodas(BigDecimal(8.50), "Fanta Laranja 2 Litros", "fanta_laranja", "03 - Fanta Laranja 2L")
                     )
            )
        }
    }
}