package com.br.villasfood.database.dao

import com.br.villasfood.model.Wine
import java.math.BigDecimal
import java.util.*

class WineDAO {

    companion object {
        fun lista(): List<Wine?>? {
            return ArrayList<Wine>(
                Arrays.asList<Wine>(
                    Wine(BigDecimal(25.99), "Pergola Suave 750ml", "pergola_bord_suave", "01 - Pergola Suave 750ml"),
                    Wine(BigDecimal(32.50), "Vinho Aurora Reserva Merlot 750ml", "vinho_aurora_reserva_merlot", "02 - Vinho Aurora 750ml"),
                    Wine(BigDecimal(28.20), "Vinho Confidencial 750ml", "vinho_confidencial_tto_750ml", "03 - Vinho Confidencial 750ml")
                )
            )
        }
    }
}