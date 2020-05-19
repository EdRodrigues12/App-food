package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.villasfood.model.Itens
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.cart_itens_detail.view.*

class ListCartAdapter (
    private val context: Context,
    private val itens: MutableList<Itens> = mutableListOf()
) : RecyclerView.Adapter<ListCartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val viewCriada = LayoutInflater.from(context)
            .inflate(
                R.layout.cart_itens_detail,
                parent, false
            )
        return ViewHolder(viewCriada)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.vincula(item)
    }

    fun atualiza(itens: List<Itens>) {
        notifyItemRangeRemoved(0, this.itens.size)
        this.itens.clear()
        this.itens.addAll(itens)
        notifyItemRangeInserted(0, this.itens.size)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var item: Itens

        fun vincula(item: Itens) {
            this.item = item
            val imagem: ImageView = itemView.item_cart_imagem
            if(item.food != null) {
                val drawableImagemPacote: Drawable? = ResourceUtil
                    .devolveDrawable(context, item.food!!.food_image)
                imagem.setImageDrawable(drawableImagemPacote)
                itemView.item_cart_local.text = item.food!!.food_name
                itemView.item_cart__preco.text = ResourceUtil.formatBrazilianPrice(item.food!!.foodPrice)
            } else if(item.sodas != null) {
                val drawableImagemPacote: Drawable? = ResourceUtil
                    .devolveDrawable(context, item.sodas!!.sodasImage)
                imagem.setImageDrawable(drawableImagemPacote)
                itemView.item_cart_local.text = item.sodas!!.sodas_name
                itemView.item_cart__preco.text = ResourceUtil.formatBrazilianPrice(item.sodas!!.sodasPrice)
            } else {
                val drawableImagemPacote: Drawable? = ResourceUtil
                    .devolveDrawable(context, item.wine!!.wineImage)
                imagem.setImageDrawable(drawableImagemPacote)
                itemView.item_cart_local.text = item.wine!!.wine_name
                itemView.item_cart__preco.text = ResourceUtil.formatBrazilianPrice(item.wine!!.winePrice)
            }

        }

    }
}