package com.br.villasfood.ui.activity.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.villasfood.R
import com.br.villasfood.ui.activity.ORDER_ID
import com.br.villasfood.ui.databinding.ResourceUtil
import kotlinx.android.synthetic.main.activity_finish_order.*
import java.math.BigDecimal

class FinishOrderActivity: AppCompatActivity() {

    private val orderFood: Boolean by lazy {
        intent.hasExtra(ORDER_ID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_order)
        buildOrder()
    }

    private fun buildOrder() {
        if(orderFood){
            val finalPrice: BigDecimal = intent.getSerializableExtra(ORDER_ID) as BigDecimal
            fillText(finalPrice)
        }
    }

    private fun fillText(food: BigDecimal) {
        pagamento_preco_pacote.text = ResourceUtil.formatBrazilianPrice(food)
    }
}