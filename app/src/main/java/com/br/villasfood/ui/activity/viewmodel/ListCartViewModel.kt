package com.br.villasfood.ui.activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.br.data.repository.ItemCartRepositoryImpl
import com.br.domain.entity.Itens
import com.br.domain.repository.Resource

class ListCartViewModel (
    private val repository: ItemCartRepositoryImpl
) : ViewModel() {

    fun buscaTodos() : LiveData<com.br.domain.repository.Resource<List<com.br.domain.entity.Itens>?>> {
        return repository.buscaTodos()
    }
}