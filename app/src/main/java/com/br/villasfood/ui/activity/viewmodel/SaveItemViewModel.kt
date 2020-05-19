package com.br.villasfood.ui.activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.br.villasfood.model.Itens
import com.br.villasfood.repository.ItemRepository
import com.br.villasfood.repository.Resource

class SaveItemViewModel(
    private val repository: ItemRepository
) : ViewModel() {

    fun salva(item: Itens): LiveData<Resource<Void?>> {

            return repository.salva(item)
    }
}