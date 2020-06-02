package com.br.villasfood.ui.activity.food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.domain.entity.Food
import com.br.villasfood.databinding.FoodDetailBinding

class ListFoodAdapter(private val context: Context,
                      private val food: MutableList<Food> = mutableListOf(),
                      var quandoItemClicado: (food: Food) -> Unit = {}
) : RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder( DataBindingUtil.inflate(
            LayoutInflater.from(context),
                R.layout.food_detail,
                parent,
            false
            )
        )
    }

    override fun getItemCount() = food.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = food[position]
        holder.vincula(food)
    }

    inner class ViewHolder(private val viewDataBinding: FoodDetailBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {

        private lateinit var food: Food

        override fun onClick(view: View?) {
            if (::food.isInitialized) {
                quandoItemClicado(food)
            }
        }

        init {
            viewDataBinding.clickFood = this
        }

        fun vincula(food: Food) {
            this.food = food
            viewDataBinding.food = food

         }

    }

}