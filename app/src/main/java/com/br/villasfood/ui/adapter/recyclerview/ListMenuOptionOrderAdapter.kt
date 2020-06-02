package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.villasfood.ui.databinding.ResourceUtil
import kotlinx.android.synthetic.main.menu_option_order.view.*
import java.util.*

class ListMenuOptionOrderAdapter (private val context: Context,
                                  var quandoItemClicado: (menu: com.br.domain.entity.MenuOption)-> Unit = {}

) : RecyclerView.Adapter<ListMenuOptionOrderAdapter.ViewHolder>() {

    val menus: MutableList<com.br.domain.entity.MenuOption> = lista() as MutableList<com.br.domain.entity.MenuOption>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val viewCriada = LayoutInflater.from(context)
            .inflate(
                R.layout.menu_option_order,
                parent, false
            )
        return ViewHolder(viewCriada)
    }

    override fun getItemCount() = menus.size

    //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = menus[position]
        holder.vincula(menu)
    }

    fun lista(): List<com.br.domain.entity.MenuOption?>? {
        return ArrayList<com.br.domain.entity.MenuOption>(
            Arrays.asList<com.br.domain.entity.MenuOption>(
                com.br.domain.entity.MenuOption("Lanches", "x_salada"),
                com.br.domain.entity.MenuOption("Refrigerantes", "coca_2l"),
                com.br.domain.entity.MenuOption("Vinhos", "pergola_bord_suave"),
                com.br.domain.entity.MenuOption("Combos", "combo")
            )
        )
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var menu: com.br.domain.entity.MenuOption

        init {
            itemView.setOnClickListener {
                if (::menu.isInitialized) {
                    quandoItemClicado(menu)
                }
            }
        }

        //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun vincula(menu: com.br.domain.entity.MenuOption) {
            this.menu = menu
            val imagem: ImageView = itemView.food_imagem
            val drawableImagemPacote: Drawable? = ResourceUtil
                .devolveDrawable(context, menu.image)
            imagem.setImageDrawable(drawableImagemPacote)
            itemView.item_pacote_local.text = menu.name

        }

    }
}