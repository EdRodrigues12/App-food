package com.br.data.repository

import androidx.lifecycle.LiveData
import com.br.data.db.local.ShowItensLocalData
import com.br.domain.entity.Itens
import com.br.domain.repository.ItemCartRepository
import com.br.domain.repository.Resource

class ItemCartRepositoryImpl( private val showItensLocalData: ShowItensLocalData
): ItemCartRepository {
    override fun buscaTodos(): LiveData<Resource<List<Itens>?>> {
        return showItensLocalData.buscaTodos()
    }

    override fun salva(itens: Itens): LiveData<Resource<Void?>> {
        return showItensLocalData.salva(itens)
    }

}