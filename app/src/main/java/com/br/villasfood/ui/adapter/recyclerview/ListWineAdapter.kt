package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.villasfood.model.Wine
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.wine_detail.view.*

class ListWineAdapter (private val context: Context,
                       private val wines: MutableList<Wine> = mutableListOf(),
                       var quandoItemClicado: (wines: Wine) -> Unit = {}
) : RecyclerView.Adapter<ListWineAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val viewCriada = LayoutInflater.from(context)
            .inflate(
                R.layout.wine_detail,
                parent, false
            )
        return ViewHolder(viewCriada)
    }

    override fun getItemCount() = wines.size

    //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = wines[position]
        holder.vincula(food)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var wine: Wine

        init {
            itemView.setOnClickListener {
                if (::wine.isInitialized) {
                    quandoItemClicado(wine)
                }
            }
        }

        //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun vincula(wine: Wine) {
            this.wine = wine
            val imagem: ImageView = itemView.wine_imagem
            val drawableImagemPacote: Drawable? = ResourceUtil
                .devolveDrawable(context, wine.wineImage)
            imagem.setImageDrawable(drawableImagemPacote)
            itemView.item_pacote_local.text = wine.wine_name
            itemView.item_wine_description.text = wine.wineDescription
            itemView.item_pacote_preco.text = ResourceUtil.formatBrazilianPrice(wine.winePrice)

        }

    }
}