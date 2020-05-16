package com.br.villasfood.ui.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.br.villasfood.R
import com.br.villasfood.model.Food
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.activity_resume_food.*

class FoodResumeActivity: AppCompatActivity() {

    private val orderFood: Boolean by lazy {
        intent.hasExtra(ORDER_FOOD_ID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_food)
        foodSelected()
    }

    private fun foodSelected() {
        if(orderFood){
            val food: Food = intent.getSerializableExtra(ORDER_FOOD_ID) as Food
            inicializeOrder(food)
            buttonConfig(food)
        }
    }

    private fun inicializeOrder(food: Food) {
        val drawableImagemPacote: Drawable? = ResourceUtil
            .devolveDrawable(this, food.image)
        resumo_food_imagem.setImageDrawable(drawableImagemPacote)
        resumo_food_name.text = food.food_name
        resumo_food_description.text = food.description
        resumo_pacote_preco.text = ResourceUtil.formatBrazilianPrice(food.price)
    }

    private fun buttonConfig(food: Food) {
        val buttonOrderPlace: Button  = resumo_pacote_botao_realiza_pagamento
        buttonOrderPlace.setOnClickListener { orderPlace(food) }

    }

    private fun orderPlace(food: Food) {
        val intent =  Intent(this, FinishOrderActivity::class.java )
        intent.putExtra(ORDER_FOOD_ID, food)
        startActivity(intent)
    }
}

