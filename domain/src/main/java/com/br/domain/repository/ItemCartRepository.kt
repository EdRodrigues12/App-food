package com.br.domain.repository

import androidx.lifecycle.LiveData
import com.br.domain.entity.Itens

interface ItemCartRepository {
    fun buscaTodos(): LiveData<Resource<List<Itens>?>>

    fun salva(itens:Itens): LiveData<Resource<Void?>>

}