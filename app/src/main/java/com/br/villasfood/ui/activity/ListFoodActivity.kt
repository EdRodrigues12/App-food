package com.br.villasfood.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.data.db.dao.FoodDao
import com.br.villasfood.R
import com.br.domain.entity.Food
import com.br.villasfood.databinding.ActivityListFoodBinding
import com.br.villasfood.ui.adapter.recyclerview.ListFoodAdapter
import kotlinx.android.synthetic.main.activity_list_food.*

class ListFoodActivity : AppCompatActivity() {

    private val adapter by lazy {
        val pacotes: List<Food> = FoodDao.lista() as List<Food>
        ListFoodAdapter(context = this, food = pacotes as MutableList<Food>)
    }

    private lateinit var binding: ActivityListFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_food)

        configRecyclerView()
    }

    private fun configRecyclerView() {
        val divisor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        binding.listaPacotesListview.addItemDecoration(divisor)
        binding.listaPacotesListview.adapter = adapter
        configAdapter()
    }

    private fun configAdapter() {
        adapter.quandoItemClicado = this::abreVisualizadorNoticia
    }

    private fun abreVisualizadorNoticia(it: Food) {
        val intent = Intent(this, FoodResumeActivity::class.java)
        intent.putExtra(FOOD_ID, it)
        startActivity(intent)
    }
}