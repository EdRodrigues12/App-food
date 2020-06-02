package com.br.villasfood.ui.extensions

import android.widget.ImageView
import com.br.villasfood.R
import com.bumptech.glide.Glide

private const val DRAWABLE = "drawable"

fun ImageView.carregaImagem(
    endereco: String,
    imagemDeErro: Int = R.drawable.erro_carrega_imagem
) {
    val resID = resources.getIdentifier(
        endereco,
        DRAWABLE, "com.br.villasfood"
    )
    Glide.with(this)
        .load(resID)
        .error(imagemDeErro)
        .into(this)
}