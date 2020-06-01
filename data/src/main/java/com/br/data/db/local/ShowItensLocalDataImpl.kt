package com.br.data.db.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.br.data.db.asynctask.BaseAsyncTask
import com.br.data.db.dao.ItemDAO
import com.br.domain.entity.Itens
import com.br.domain.repository.Resource

class ShowItensLocalDataImpl(private val dao: ItemDAO
): ShowItensLocalData {
    private val mediador = MediatorLiveData<com.br.domain.repository.Resource<List<com.br.domain.entity.Itens>?>>()

    override fun buscaTodos(): LiveData<Resource<List<Itens>?>> {
        mediador.addSource(buscaInterno()) { noticiasEncontradas ->
            mediador.value =
                com.br.domain.repository.Resource(dado = noticiasEncontradas)
        }
        return mediador
    }

    private fun buscaInterno() : LiveData<List<com.br.domain.entity.Itens>> {
        return dao.buscaTodos()
    }

    override fun salva(itens:Itens): LiveData<Resource<Void?>> {
        val liveData = MutableLiveData<com.br.domain.repository.Resource<Void?>>()
        salvaInterno(itens, quandoSucesso = {
            liveData.value = com.br.domain.repository.Resource(null)
        }, quandoFalha = { erro ->
            liveData.value =
                com.br.domain.repository.Resource(dado = null, erro = erro)
        })
        return liveData

    }

    private fun salvaInterno(
        itens: com.br.domain.entity.Itens,
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