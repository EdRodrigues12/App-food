package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.villasfood.model.Food
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.food_detail.view.*

class ListFoodAdapter(private val context: Context,
                      private val food: MutableList<Food> = mutableListOf(),
                      var quandoItemClicado: (food: Food) -> Unit = {}
) : RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val viewCriada = LayoutInflater.from(context)
            .inflate(
                R.layout.food_detail,
                parent, false
            )
        return ViewHolder(viewCriada)
    }

    override fun getItemCount() = food.size

    //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = food[position]
        holder.vincula(food)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var food: Food

        init {
            itemView.setOnClickListener {
                if (::food.isInitialized) {
                    quandoItemClicado(food)
                }
            }
        }

        //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun vincula(food: Food) {
            this.food = food
            val imagem: ImageView = itemView.food_imagem
            val drawableImagemPacote: Drawable? = ResourceUtil
                .devolveDrawable(context, food.food_image)
            imagem.setImageDrawable(drawableImagemPacote)
            itemView.item_pacote_local.text = food.food_name
            itemView.item_food_description.text = food.food_description
            itemView.item_pacote_preco.text = ResourceUtil.formatBrazilianPrice(food.foodPrice)

        }

    }

}