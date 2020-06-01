package com.br.villasfood.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.villasfood.R
import com.br.data.db.dao.SodasDAO
import com.br.domain.entity.Sodas
import com.br.villasfood.ui.adapter.recyclerview.ListSodasAdapter
import kotlinx.android.synthetic.main.activity_list_food.*

class ListSodasActivity: AppCompatActivity() {

    private val adapter by lazy {
        val sodas: List<com.br.domain.entity.Sodas> = com.br.data.db.dao.SodasDAO.lista() as List<com.br.domain.entity.Sodas>
        ListSodasAdapter(context = this, sodas = sodas as MutableList<com.br.domain.entity.Sodas>)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sodas)

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

    private fun abreVisualizadorNoticia(it: com.br.domain.entity.Sodas) {
        val intent = Intent(this, SodasResumeActivity::class.java)
        intent.putExtra(SODAS_ID, it)
        startActivity(intent)
    }
}