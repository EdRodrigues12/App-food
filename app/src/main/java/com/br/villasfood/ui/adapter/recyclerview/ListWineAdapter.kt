package com.br.villasfood.ui.adapter.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.domain.entity.Wine
import com.br.villasfood.R
import com.br.villasfood.databinding.WineDetailBinding
import com.br.villasfood.ui.databinding.ResourceUtil
import kotlinx.android.synthetic.main.wine_detail.view.*

class ListWineAdapter (private val context: Context,
                       private val wines: MutableList<Wine> = mutableListOf(),
                       var quandoItemClicado: (wines: Wine) -> Unit = {}
) : RecyclerView.Adapter<ListWineAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.wine_detail,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = wines.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = wines[position]
        holder.vincula(food)
    }

    inner class ViewHolder(private val viewDataBinding: WineDetailBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {

        private lateinit var wine: Wine

        override fun onClick(view: View?) {
            if (::wine.isInitialized) {
                quandoItemClicado(wine)
            }
        }

        init {
            viewDataBinding.clickWine = this
        }

        fun vincula(wine: Wine) {
            this.wine = wine
            viewDataBinding.wine = wine

        }

    }
}