package com.br.villasfood.ui.activity.cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.villasfood.R
import com.br.villasfood.ui.activity.order.FinishOrderActivity
import com.br.villasfood.ui.activity.ORDER_ID
import com.br.villasfood.ui.activity.mostraErro
import kotlinx.android.synthetic.main.activity_cart_itens.*
import kotlinx.android.synthetic.main.activity_cart_itens.resumo_food_botao_enviar_carrinho
import org.koin.android.viewmodel.ext.android.viewModel
import java.math.BigDecimal

private const val MENSAGEM_FALHA_CARREGAR_CARRINHO = "Não foi possível carregar o carrinho"

class ListCartActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListCartAdapter(context = this)
    }
    private val viewModel by viewModel<ListCartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_itens)
        val textView: TextView = findViewById(R.id.itens_carrinho)
        textView.text = "Carrinho vazio"
        val buttonView: TextView = findViewById(R.id.resumo_food_botao_enviar_carrinho)
        buttonView.visibility = View.GONE
        configuraRecyclerView()
        buscaItensCarrinho()
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        lista_pacotes_listview.addItemDecoration(divisor)
        lista_pacotes_listview.adapter = adapter

    }

    private fun buscaItensCarrinho() {
        viewModel.buscaTodos().observe(this, Observer { resource ->
            resource.dado?.let {
                adapter.atualiza(it)
                if (!resource.dado.isNullOrEmpty()) {
                    val textView: TextView = findViewById(R.id.itens_carrinho)
                    textView.text = getString(R.string.itens_cart)
                    val buttonView: TextView = findViewById(R.id.resumo_food_botao_enviar_carrinho)
                    buttonView.visibility = View.VISIBLE
                    buttonConfig(resource.dado!!)
                }
            }
            resource.erro?.let {
                mostraErro(MENSAGEM_FALHA_CARREGAR_CARRINHO)
            }
        })
    }

    private fun buttonConfig(itens: List<com.br.domain.entity.Itens>) {
        val finalPrice = calcfinalPrice(itens)
        val buttonOrderPlace: Button = resumo_food_botao_enviar_carrinho
        buttonOrderPlace.setOnClickListener { placeOrder(finalPrice) }

    }

    private fun placeOrder(dado: BigDecimal) {
        val intent = Intent(this, FinishOrderActivity::class.java)
        intent.putExtra(ORDER_ID, dado)
        startActivity(intent)
    }

    private fun calcfinalPrice(itens: List<com.br.domain.entity.Itens>): BigDecimal {
        var finalPrice = BigDecimal.ZERO
        for(item in itens){
          if(item.food != null) {
              finalPrice = finalPrice.plus(item.food!!.foodPrice)
          }else if(item.sodas != null) {
                finalPrice = finalPrice.plus(item.sodas!!.sodasPrice)
            } else {
                finalPrice = finalPrice.plus(item.wine!!.winePrice)
            }
        }

        return finalPrice

    }
}
