package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.domain.entity.MenuOption
import com.br.villasfood.R
import com.br.villasfood.databinding.MenuOptionOrderBinding
import com.br.villasfood.ui.databinding.ResourceUtil
import kotlinx.android.synthetic.main.menu_option_order.view.*
import java.util.*

class ListMenuOptionOrderAdapter (private val context: Context,
                                  var quandoItemClicado: (menu: com.br.domain.entity.MenuOption)-> Unit = {}

) : RecyclerView.Adapter<ListMenuOptionOrderAdapter.ViewHolder>() {

    val menus: MutableList<MenuOption> = lista() as MutableList<MenuOption>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.menu_option_order,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = menus.size

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

    inner class ViewHolder(private val viewDataBinding: MenuOptionOrderBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {

        private lateinit var menu: MenuOption

        override fun onClick(view: View?) {
                if (::menu.isInitialized) {
                    quandoItemClicado(menu)
                }
            }

        init {
            viewDataBinding.clickMenu = this
        }

        fun vincula(menu: MenuOption) {
            this.menu = menu
            viewDataBinding.menu = menu

        }

    }
}