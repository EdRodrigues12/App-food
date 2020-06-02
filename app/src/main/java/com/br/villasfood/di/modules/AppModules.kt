package com.br.villasfood.di.modules

import androidx.room.Room
import com.br.data.db.AppDatabase
import com.br.data.db.dao.ItemDAO
import com.br.data.db.local.ShowItensLocalData
import com.br.data.db.local.ShowItensLocalDataImpl
import com.br.data.repository.ItemCartRepositoryImpl
import com.br.domain.repository.ItemCartRepository
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import com.br.villasfood.ui.activity.cart.ListCartViewModel
import com.br.villasfood.ui.activity.food.ListFoodAdapter
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DE_DADOS = "villas.db"

val appModules = module {
    single<com.br.data.db.AppDatabase> {
        Room.databaseBuilder(
            get(),
            com.br.data.db.AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).build()
    }
    single<ItemDAO> {
        get<AppDatabase>().itemDAO
    }
    single<ItemCartRepositoryImpl> {
        ItemCartRepositoryImpl(get())
    }
    single<ItemCartRepository> {
        ItemCartRepositoryImpl(get())
    }
    single<ShowItensLocalData> {
        ShowItensLocalDataImpl(get())
    }
    factory<ListFoodAdapter> {
        ListFoodAdapter(get()) {}
    }
    viewModel<SaveItemViewModel> {
        SaveItemViewModel(get())
    }
    viewModel<ListCartViewModel> {
        ListCartViewModel(get())
    }
}
