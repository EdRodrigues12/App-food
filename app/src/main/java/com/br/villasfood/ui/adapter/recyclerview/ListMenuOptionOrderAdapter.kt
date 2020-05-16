package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.villasfood.R
import com.br.villasfood.model.MenuOption
import com.br.villasfood.util.ResourceUtil
import kotlinx.android.synthetic.main.menu_option_order.view.*
import java.util.*

class ListMenuOptionOrderAdapter (private val context: Context,
                                  var quandoItemClicado: (menu: MenuOption)-> Unit = {}

) : RecyclerView.Adapter<ListMenuOptionOrderAdapter.ViewHolder>() {

    val menus: MutableList<MenuOption> = lista() as MutableList<MenuOption>
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

    fun lista(): List<MenuOption?>? {
        return ArrayList<MenuOption>(
            Arrays.asList<MenuOption>(
                MenuOption("Lanches", "x_salada"),
                MenuOption("Refrigerantes", "coca_2l"),
                MenuOption("Vinhos", "pergola_bord_suave"),
                MenuOption("Combos", "combo")
            )
        )
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var menu: MenuOption

        init {
            itemView.setOnClickListener {
                if (::menu.isInitialized) {
                    quandoItemClicado(menu)
                }
            }
        }

        //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun vincula(menu: MenuOption) {
            this.menu = menu
            val imagem: ImageView = itemView.food_imagem
            val drawableImagemPacote: Drawable? = ResourceUtil
                .devolveDrawable(context, menu.image)
            imagem.setImageDrawable(drawableImagemPacote)
            itemView.item_pacote_local.text = menu.name

        }

    }
}