package com.br.villasfood.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.br.domain.entity.Itens
import com.br.domain.entity.Sodas
import com.br.villasfood.R
import com.br.villasfood.databinding.ActivityResumeSodasBinding
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import com.br.villasfood.ui.databinding.ResourceUtil
import kotlinx.android.synthetic.main.activity_resume_sodas.*
import org.koin.android.viewmodel.ext.android.viewModel

private const val MENSAGEM_ERRO_SALVAR = "Não foi possível salvar"

class SodasResumeActivity: AppCompatActivity() {

    private val orderSodas: Boolean by lazy {
        intent.hasExtra(SODAS_ID)
    }

    private val viewModel by viewModel<SaveItemViewModel>()
    private lateinit var binding: ActivityResumeSodasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resume_sodas)
        if(orderSodas){
            val sodas: Sodas = intent.getSerializableExtra(SODAS_ID) as Sodas
            binding.soda = sodas
            binding.resumoSodasBotaoEnviarCarrinho.setOnClickListener {
                sendCart(sodas)
            }
        }
        binding.executePendingBindings()
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