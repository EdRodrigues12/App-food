package com.br.villasfood.ui.activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.br.villasfood.model.Itens
import com.br.villasfood.repository.ItemRepository
import com.br.villasfood.repository.Resource

class ListCartViewModel (
    private val repository: ItemRepository
) : ViewModel() {

    fun buscaTodos() : LiveData<Resource<List<Itens>?>> {
        return repository.buscaTodos()
    }
}