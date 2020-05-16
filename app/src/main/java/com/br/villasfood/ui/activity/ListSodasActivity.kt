package com.br.villasfood.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.villasfood.R
import com.br.villasfood.dao.SodasDAO
import com.br.villasfood.model.Sodas
import com.br.villasfood.ui.adapter.recyclerview.ListSodasAdapter
import kotlinx.android.synthetic.main.activity_list_food.*

class ListSodasActivity: AppCompatActivity() {

    private val adapter by lazy {
        val sodas: List<Sodas> = SodasDAO.lista() as List<Sodas>
        ListSodasAdapter(context = this, sodas = sodas as MutableList<Sodas>)
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
        //configAdapter()
    }
}