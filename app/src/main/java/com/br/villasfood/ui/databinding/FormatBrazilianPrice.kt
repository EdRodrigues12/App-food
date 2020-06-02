package com.br.villasfood.ui.databinding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

private const val PORTUGUES = "pt"
private const val BRASIL = "br"
private const val FORMATO_PADRAO = "R$"
private const val FORMATO_COM_ESPACO = "R$ "

@BindingAdapter("formatPrice")
fun formatPrice(textView: TextView, price: BigDecimal){
    val formatBrazilian: NumberFormat = DecimalFormat.getCurrencyInstance(
        Locale(
            PORTUGUES,
            BRASIL
        )
    )
    textView.text = formatBrazilian
        .format(price)
        .replace(
            FORMATO_PADRAO,
            FORMATO_COM_ESPACO
        )
}
