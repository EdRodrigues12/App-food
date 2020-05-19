package com.br.villasfood.di.modules

import androidx.room.Room
import com.br.villasfood.database.AppDatabase
import com.br.villasfood.database.dao.ItemDAO
import com.br.villasfood.repository.ItemRepository
import com.br.villasfood.ui.activity.viewmodel.SaveItemViewModel
import com.br.villasfood.ui.activity.viewmodel.ListCartViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DE_DADOS = "villas.db"

val appModules = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).build()
    }
    single<ItemDAO> {
        get<AppDatabase>().itemDAO
    }
    single<ItemRepository> {
        ItemRepository(get())
    }
    viewModel<SaveItemViewModel> {
        SaveItemViewModel(get())
    }
    viewModel<ListCartViewModel> {
        ListCartViewModel(get())
    }
}
