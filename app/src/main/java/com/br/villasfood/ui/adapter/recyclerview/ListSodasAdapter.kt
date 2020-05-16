package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.villasfood.model.Sodas
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.sodas_detail.view.*

class ListSodasAdapter(private val context: Context,
                       private val sodas: MutableList<Sodas> = mutableListOf(),
                       var quandoItemClicado: (sodas: Sodas) -> Unit = {}
) : RecyclerView.Adapter<ListSodasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val viewCriada = LayoutInflater.from(context)
            .inflate(
                R.layout.sodas_detail,
                parent, false
            )
        return ViewHolder(viewCriada)
    }

    override fun getItemCount() = sodas.size

    //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = sodas[position]
        holder.vincula(food)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var sodas: Sodas

        init {
            itemView.setOnClickListener {
                if (::sodas.isInitialized) {
                    quandoItemClicado(sodas)
                }
            }
        }

        //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun vincula(sodas: Sodas) {
            this.sodas = sodas
            val imagem: ImageView = itemView.sodas_imagem
            val drawableImagemPacote: Drawable? = ResourceUtil
                .devolveDrawable(context, sodas.image)
            imagem.setImageDrawable(drawableImagemPacote)
            itemView.item_pacote_local.text = sodas.sodas_name
            itemView.item_sodas_description.text = sodas.description
            itemView.item_pacote_preco.text = ResourceUtil.formatBrazilianPrice(sodas.price)

        }

    }
}