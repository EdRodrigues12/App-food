package com.br.data.db.dao

import com.br.domain.entity.Sodas
import java.math.BigDecimal
import java.util.*

class SodasDAO {
    companion object {
        fun lista(): List<com.br.domain.entity.Sodas?>? {
            return ArrayList<com.br.domain.entity.Sodas>(
                Arrays.asList<com.br.domain.entity.Sodas>(
                    com.br.domain.entity.Sodas(
                        BigDecimal(11.99),
                        "Coca-Cola 2 Litros",
                        "coca_2l",
                        "01 - Coca-Cola 2L"
                    ),
                    com.br.domain.entity.Sodas(
                        BigDecimal(8.50),
                        "Fanta Guarana 2 Litros",
                        "fanta_gua",
                        "02 - Fanta Guarana 2L"
                    ),
                    com.br.domain.entity.Sodas(
                        BigDecimal(8.50),
                        "Fanta Laranja 2 Litros",
                        "fanta_laranja",
                        "03 - Fanta Laranja 2L"
                    )
                     )
            )
        }
    }
}