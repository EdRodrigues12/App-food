package com.br.data.db.dao

import com.br.domain.entity.Wine
import java.math.BigDecimal
import java.util.*

class WineDAO {

    companion object {
        fun lista(): List<com.br.domain.entity.Wine?>? {
            return ArrayList<com.br.domain.entity.Wine>(
                Arrays.asList<com.br.domain.entity.Wine>(
                    com.br.domain.entity.Wine(
                        BigDecimal(25.99),
                        "Pergola Suave 750ml",
                        "pergola_bord_suave",
                        "01 - Pergola Suave 750ml"
                    ),
                    com.br.domain.entity.Wine(
                        BigDecimal(32.50),
                        "Vinho Aurora Reserva Merlot 750ml",
                        "vinho_aurora_reserva_merlot",
                        "02 - Vinho Aurora 750ml"
                    ),
                    com.br.domain.entity.Wine(
                        BigDecimal(28.20),
                        "Vinho Confidencial 750ml",
                        "vinho_confidencial_tto_750ml",
                        "03 - Vinho Confidencial 750ml"
                    )
                )
            )
        }
    }
}