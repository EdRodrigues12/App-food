package com.br.villasfood.ui.activity.wine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.br.domain.entity.Wine
import com.br.villasfood.R
import com.br.villasfood.databinding.ActivityResumeWineBinding
import com.br.villasfood.ui.activity.WINE_ID
import com.br.villasfood.ui.activity.mostraErro
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import org.koin.android.viewmodel.ext.android.viewModel

private const val MENSAGEM_ERRO_SALVAR = "Não foi possível salvar"

class WineResumeActivity: AppCompatActivity() {

    private val orderWine: Boolean by lazy {
        intent.hasExtra(WINE_ID)
    }

    private val viewModel by viewModel<SaveItemViewModel>()
    private lateinit var binding: ActivityResumeWineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resume_wine)
        if(orderWine){
            val wine: Wine = intent.getSerializableExtra(WINE_ID) as Wine
            binding.wine = wine
            binding.resumoWineBotaoEnviarCarrinho.setOnClickListener {
                sendCart(wine)
            }
        }
        binding.executePendingBindings()
    }

    private fun sendCart(wine: Wine) {
        val itens = com.br.domain.entity.Itens(0L, null, wine, null)
        viewModel.salva(itens).observe(this, Observer {
            if (it.erro == null) {
                finish()
            } else {
                mostraErro(MENSAGEM_ERRO_SALVAR)
            }
        })
    }
}

