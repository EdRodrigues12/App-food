package com.br.villasfood.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.br.villasfood.asynctask.BaseAsyncTask
import com.br.villasfood.database.dao.ItemDAO
import com.br.villasfood.model.Cart
import com.br.villasfood.model.Itens

class ItemRepository(
    private val dao: ItemDAO
) {
    private val mediador = MediatorLiveData<Resource<List<Itens>?>>()

    fun buscaTodos(): LiveData<Resource<List<Itens>?>> {

        mediador.addSource(buscaInterno()) { noticiasEncontradas ->
            mediador.value = Resource(dado = noticiasEncontradas)
        }
        return mediador
    }

    private fun buscaInterno() : LiveData<List<Itens>> {
        return dao.buscaTodos()
    }

    fun salva(
        itens: Itens
    ): LiveData<Resource<Void?>> {
        val liveData = MutableLiveData<Resource<Void?>>()
        salvaInterno(itens, quandoSucesso = {
            liveData.value = Resource(null)
        }, quandoFalha = { erro ->
            liveData.value = Resource(dado = null, erro = erro)
        })
        return liveData
    }

    private fun salvaInterno(
        itens: Itens,
        quandoSucesso: () -> Unit,
        quandoFalha: (erro: String?) -> Unit
    ) {
        BaseAsyncTask(quandoExecuta = {
            dao.salva(itens)
        }, quandoFinaliza = {
            quandoSucesso()
        }
        ).execute()
    }
}