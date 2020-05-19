package com.br.villasfood.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.br.villasfood.database.converter.BigDecimalConverter
import com.br.villasfood.database.dao.ItemDAO
import com.br.villasfood.model.Itens

@Database(entities = [Itens::class], version = 1, exportSchema = false)
@TypeConverters(value = [BigDecimalConverter::class])
abstract class AppDatabase: RoomDatabase() {

    abstract val itemDAO: ItemDAO
}