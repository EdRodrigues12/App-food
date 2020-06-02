package com.br.villasfood.ui.databinding

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

private const val DRAWABLE = "drawable"
private const val PORTUGUES = "pt"
private const val BRASIL = "br"
private const val FORMATO_PADRAO = "R$"
private const val FORMATO_COM_ESPACO = "R$ "

class ResourceUtil {

    companion object {
        fun devolveDrawable(
            context: Context?,
            drawableEmTexto: String?
        ): Drawable? {
            val resources: Resources? = context?.resources
            val idDoDrawable = resources?.getIdentifier(drawableEmTexto,
                DRAWABLE, context.packageName)

            return resources?.getDrawable(idDoDrawable!!)

        }

        fun formatBrazilianPrice(price: BigDecimal): String {
            val formatBrazilian: NumberFormat = DecimalFormat.getCurrencyInstance(
                Locale(
                    PORTUGUES,
                    BRASIL
                ))
            return formatBrazilian
                .format(price)
                .replace(
                    FORMATO_PADRAO,
                    FORMATO_COM_ESPACO
                )
        }
    }
}
