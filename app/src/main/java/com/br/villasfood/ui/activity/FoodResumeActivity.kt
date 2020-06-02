package com.br.villasfood.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.br.villasfood.R
import com.br.domain.entity.Food
import com.br.villasfood.databinding.ActivityResumeItemBinding
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.math.BigDecimal
import java.math.BigInteger


private const val MENSAGEM_ERRO_SALVAR = "Não foi possível salvar notícia"

class FoodResumeActivity: AppCompatActivity() {

    private val orderFood: Boolean by lazy {
        intent.hasExtra(FOOD_ID)
    }

    private val viewModel by viewModel<SaveItemViewModel>()
    private lateinit var binding: ActivityResumeItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resume_item)
        if (orderFood) {
            val food: Food = intent.getSerializableExtra(FOOD_ID) as Food
            binding.food = food
            binding.resumoFoodBotaoEnviarCarrinho.setOnClickListener {
                sendCart(food)
            }

            binding.executePendingBindings()
        }
    }

        private fun sendCart(food: Food) {

            val itens = com.br.domain.entity.Itens(0L, food, null, null)
            viewModel.salva(itens).observe(this, Observer {
                if (it.erro == null) {
                    finish()
                } else {
                    mostraErro(MENSAGEM_ERRO_SALVAR)
                }
            })
        }
}

