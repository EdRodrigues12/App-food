package com.br.villasfood.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.villasfood.R
import com.br.villasfood.model.Food
import com.br.villasfood.ui.activity.ORDER_FOOD_ID
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.activity_finish_order.*

class FinishOrderActivity: AppCompatActivity() {

    private val orderFood: Boolean by lazy {
        intent.hasExtra(ORDER_FOOD_ID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_order)
        buildOrder()
    }

    private fun buildOrder() {
        if(orderFood){
            val food: Food = intent.getSerializableExtra(ORDER_FOOD_ID) as Food
            fillText(food)
        }
    }

    private fun fillText(food: Food) {
        pagamento_preco_pacote.text = ResourceUtil.formatBrazilianPrice(food.price)
    }
}