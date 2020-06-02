package com.br.villasfood.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.br.villasfood.R
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import com.br.villasfood.ui.databinding.ResourceUtil
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
            val sodas: com.br.domain.entity.Sodas = intent.getSerializableExtra(SODAS_ID) as com.br.domain.entity.Sodas
            inicializeOrder(sodas)
            buttonConfig(sodas)
        }
    }

    private fun inicializeOrder(sodas: com.br.domain.entity.Sodas) {
        val drawableImagemPacote: Drawable? = ResourceUtil
            .devolveDrawable(this, sodas.sodasImage)
        resumo_sodas_imagem.setImageDrawable(drawableImagemPacote)
        resumo_sodas_name.text = sodas.sodas_name
        resumo_sodas_description.text = sodas.sodasDescription
        resumo_sodas_preco.text = ResourceUtil.formatBrazilianPrice(sodas.sodasPrice)
    }

    private fun buttonConfig(sodas: com.br.domain.entity.Sodas) {
        val buttonOrderPlace: Button = resumo_sodas_botao_enviar_carrinho
        buttonOrderPlace.setOnClickListener { sendCart(sodas) }

    }

    private fun sendCart(sodas: com.br.domain.entity.Sodas) {
        val itens = com.br.domain.entity.Itens(0L, null, null, sodas)
        viewModel.salva(itens).observe(this, Observer {
            if (it.erro == null) {
                finish()
            } else {
                mostraErro(MENSAGEM_ERRO_SALVAR)
            }
        })
    }
}