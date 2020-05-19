package com.br.villasfood.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.br.villasfood.R
import com.br.villasfood.model.Itens
import com.br.villasfood.model.Wine
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.activity_resume_wine.*
import org.koin.android.viewmodel.ext.android.viewModel

private const val MENSAGEM_ERRO_SALVAR = "Não foi possível salvar notícia"

class WineResumeActivity: AppCompatActivity() {

    private val orderWine: Boolean by lazy {
        intent.hasExtra(WINE_ID)
    }

    private val viewModel by viewModel<SaveItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_wine)
        foodSelected()
    }

    private fun foodSelected() {
        if(orderWine){
            val wine: Wine = intent.getSerializableExtra(WINE_ID) as Wine
            inicializeOrder(wine)
            buttonConfig(wine)
        }
    }

    private fun inicializeOrder(wine: Wine) {
        val drawableImagemPacote: Drawable? = ResourceUtil
            .devolveDrawable(this, wine.wineImage)
        resumo_wine_imagem.setImageDrawable(drawableImagemPacote)
        resumo_wine_name.text = wine.wine_name
        resumo_wine_description.text = wine.wineDescription
        resumo_wine_preco.text = ResourceUtil.formatBrazilianPrice(wine.winePrice)
    }

    private fun buttonConfig(wine: Wine) {
        val buttonOrderPlace: Button  = resumo_wine_botao_enviar_carrinho
        buttonOrderPlace.setOnClickListener { sendCart(wine) }

    }
    private fun sendCart(wine: Wine) {
        val itens = Itens(0L, null, wine, null)
        viewModel.salva(itens).observe(this, Observer {
            if (it.erro == null) {
                finish()
            } else {
                mostraErro(MENSAGEM_ERRO_SALVAR)
            }
        })
    }
}

