package com.br.data.db.local

import androidx.lifecycle.LiveData
import com.br.domain.entity.Itens
import com.br.domain.repository.Resource

interface ShowItensLocalData {

    fun buscaTodos(): LiveData<Resource<List<Itens>?>>

    fun salva(itens:Itens): LiveData<Resource<Void?>>
}