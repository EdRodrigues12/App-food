package com.br.villasfood.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.br.villasfood.R
import com.br.villasfood.model.Food
import com.br.villasfood.model.Itens
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.activity_resume_item.*
import org.koin.android.viewmodel.ext.android.viewModel


private const val MENSAGEM_ERRO_SALVAR = "Não foi possível salvar notícia"

class FoodResumeActivity: AppCompatActivity() {

    private val orderFood: Boolean by lazy {
        intent.hasExtra(FOOD_ID)
    }

    private val viewModel by viewModel<SaveItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_item)
        foodSelected()
    }

    private fun foodSelected() {
        if(orderFood){
            val food: Food = intent.getSerializableExtra(FOOD_ID) as Food
            inicializeOrder(food)
            buttonConfig(food)
        }
    }

    private fun inicializeOrder(food: Food) {
        val drawableImagemPacote: Drawable? = ResourceUtil
            .devolveDrawable(this, food.food_image)
        resumo_food_imagem.setImageDrawable(drawableImagemPacote)
        resumo_food_name.text = food.food_name
        resumo_food_description.text = food.food_description
        resumo_pacote_preco.text = ResourceUtil.formatBrazilianPrice(food.foodPrice)
    }

    private fun buttonConfig(food: Food) {
        val buttonOrderPlace: Button  = resumo_food_botao_enviar_carrinho
        buttonOrderPlace.setOnClickListener { sendCart(food) }

    }

    private fun sendCart(food: Food) {
//        val intent =  Intent(this, FinishOrderActivity::class.java )
//        intent.putExtra(FOOD_ID, food)
//        startActivity(intent)

        val itens = Itens(0L, food, null, null)
        viewModel.salva(itens).observe(this, Observer {
            if (it.erro == null) {
                finish()
            } else {
                mostraErro(MENSAGEM_ERRO_SALVAR)
            }
        })
    }

}

