package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.villasfood.databinding.CartItensDetailBinding
import com.br.villasfood.ui.databinding.ResourceUtil
import kotlinx.android.synthetic.main.cart_itens_detail.view.*

class ListCartAdapter (
    private val context: Context,
    private val itens: MutableList<com.br.domain.entity.Itens> = mutableListOf()
) : RecyclerView.Adapter<ListCartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.cart_itens_detail,
                parent,
                false
            )
        )
//        val viewCriada = LayoutInflater.from(context)
//            .inflate(
//                R.layout.cart_itens_detail,
//                parent, false
//            )
//        return ViewHolder(viewCriada)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.vincula(item)
    }

    fun atualiza(itens: List<com.br.domain.entity.Itens>) {
        notifyItemRangeRemoved(0, this.itens.size)
        this.itens.clear()
        this.itens.addAll(itens)
        notifyItemRangeInserted(0, this.itens.size)
    }

    inner class ViewHolder(private val viewDataBinding: CartItensDetailBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        private lateinit var item: com.br.domain.entity.Itens

        fun vincula(item: com.br.domain.entity.Itens) {
            this.item = item
            viewDataBinding.item = item
//            val imagem: ImageView = itemView.item_cart_imagem
//            if(item.food != null) {
//                val drawableImagemPacote: Drawable? = ResourceUtil
//                    .devolveDrawable(context, item.food!!.food_image)
//                imagem.setImageDrawable(drawableImagemPacote)
//                itemView.item_cart_local.text = item.food!!.food_name
//                itemView.item_cart__preco.text = ResourceUtil.formatBrazilianPrice(item.food!!.foodPrice)
//            } else if(item.sodas != null) {
//                val drawableImagemPacote: Drawable? = ResourceUtil
//                    .devolveDrawable(context, item.sodas!!.sodasImage)
//                imagem.setImageDrawable(drawableImagemPacote)
//                itemView.item_cart_local.text = item.sodas!!.sodas_name
//                itemView.item_cart__preco.text = ResourceUtil.formatBrazilianPrice(item.sodas!!.sodasPrice)
//            } else {
//                val drawableImagemPacote: Drawable? = ResourceUtil
//                    .devolveDrawable(context, item.wine!!.wineImage)
//                imagem.setImageDrawable(drawableImagemPacote)
//                itemView.item_cart_local.text = item.wine!!.wine_name
//                itemView.item_cart__preco.text = ResourceUtil.formatBrazilianPrice(item.wine!!.winePrice)
//            }

        }

    }
}