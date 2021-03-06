package com.br.villasfood.ui.activity.wine

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.villasfood.R
import com.br.data.db.dao.WineDAO
import com.br.domain.entity.Wine
import com.br.villasfood.ui.activity.WINE_ID
import kotlinx.android.synthetic.main.activity_list_wine.*

class ListWineActivity: AppCompatActivity() {

    private val adapter by lazy {
        val wines: List<Wine> = WineDAO.lista() as List<Wine>
        ListWineAdapter(
            context = this,
            wines = wines as MutableList<Wine>
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_wine)

        configRecyclerView()
    }

    private fun configRecyclerView() {
        val divisor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        lista_pacotes_listview.addItemDecoration(divisor)
        lista_pacotes_listview.adapter = adapter
        configAdapter()
    }

    private fun configAdapter() {
        adapter.quandoItemClicado = this::abreVisualizadorNoticia
    }

    private fun abreVisualizadorNoticia(it: Wine) {
        val intent = Intent(this, WineResumeActivity::class.java)
        intent.putExtra(WINE_ID, it)
        startActivity(intent)
    }
}