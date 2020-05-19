package com.br.villasfood.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.br.villasfood.R
import com.br.villasfood.model.Itens
import com.br.villasfood.model.Sodas
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.activity_resume_sodas.*
import org.koin.android.viewmodel.ext.android.viewModel

private const val MENSAGEM_ERRO_SALVAR = "Não foi possível salvar notícia"

class SodasResumeActivity: AppCompatActivity() {

    private val orderSodas: Boolean by lazy {
        intent.hasExtra(SODAS_ID)
    }

    private val viewModel by viewModel<SaveItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_sodas)
        foodSelected()
    }

    private fun foodSelected() {
        if(orderSodas){
            val sodas: Sodas = intent.getSerializableExtra(SODAS_ID) as Sodas
            inicializeOrder(sodas)
            buttonConfig(sodas)
        }
    }

    private fun inicializeOrder(sodas: Sodas) {
        val drawableImagemPacote: Drawable? = ResourceUtil
            .devolveDrawable(this, sodas.sodasImage)
        resumo_sodas_imagem.setImageDrawable(drawableImagemPacote)
        resumo_sodas_name.text = sodas.sodas_name
        resumo_sodas_description.text = sodas.sodasDescription
        resumo_sodas_preco.text = ResourceUtil.formatBrazilianPrice(sodas.sodasPrice)
    }

    private fun buttonConfig(sodas: Sodas) {
        val buttonOrderPlace: Button = resumo_sodas_botao_enviar_carrinho
        buttonOrderPlace.setOnClickListener { sendCart(sodas) }

    }

    private fun sendCart(sodas: Sodas) {
        val itens = Itens(0L, null, null, sodas)
        viewModel.salva(itens).observe(this, Observer {
            if (it.erro == null) {
                finish()
            } else {
                mostraErro(MENSAGEM_ERRO_SALVAR)
            }
        })
    }
}