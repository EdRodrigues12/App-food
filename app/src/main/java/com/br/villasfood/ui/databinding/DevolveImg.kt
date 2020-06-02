package com.br.villasfood.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.br.villasfood.ui.extensions.carregaImagem

@BindingAdapter("carregaImagem")
fun ImageView.carregaImagemPorUrl(url: String?){
    url?.let { carregaImagem(url) }
}