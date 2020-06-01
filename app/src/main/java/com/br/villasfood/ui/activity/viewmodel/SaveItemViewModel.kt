package com.br.villasfood.ui.activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.br.data.repository.ItemCartRepositoryImpl
import com.br.domain.entity.Itens
import com.br.domain.repository.Resource

class SaveItemViewModel(
    private val repository: ItemCartRepositoryImpl
) : ViewModel() {

   fun salva(item: com.br.domain.entity.Itens): LiveData<com.br.domain.repository.Resource<Void?>> {

            return repository.salva(item)
    }
}