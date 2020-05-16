package com.br.villasfood.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.villasfood.R
import com.br.villasfood.dao.WineDAO
import com.br.villasfood.model.Wine
import com.br.villasfood.ui.adapter.recyclerview.ListWineAdapter
import kotlinx.android.synthetic.main.activity_list_wine.*

class ListWineActivity: AppCompatActivity() {

    private val adapter by lazy {
        val wines: List<Wine> = WineDAO.lista() as List<Wine>
        ListWineAdapter(context = this, wines = wines as MutableList<Wine>)
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
        //configAdapter()
    }
}