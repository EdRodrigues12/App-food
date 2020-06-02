package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.domain.entity.Sodas
import com.br.villasfood.R
import com.br.villasfood.databinding.SodasDetailBinding
import com.br.villasfood.ui.databinding.ResourceUtil
import kotlinx.android.synthetic.main.sodas_detail.view.*

class ListSodasAdapter(private val context: Context,
                       private val sodas: MutableList<com.br.domain.entity.Sodas> = mutableListOf(),
                       var quandoItemClicado: (sodas: com.br.domain.entity.Sodas) -> Unit = {}
) : RecyclerView.Adapter<ListSodasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.sodas_detail,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = sodas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = sodas[position]
        holder.vincula(food)
    }

    inner class ViewHolder(private val viewDataBinding: SodasDetailBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {

        private lateinit var sodas: Sodas

        override fun onClick(view: View?) {
                if (::sodas.isInitialized) {
                    quandoItemClicado(sodas)
                }
            }

        init {
            viewDataBinding.clickSoda = this
        }

        fun vincula(sodas: Sodas) {
            this.sodas = sodas
            viewDataBinding.soda = sodas

        }

    }
}