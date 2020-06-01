package com.br.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.br.data.db.converter.BigDecimalConverter
import com.br.data.db.dao.ItemDAO

@Database(entities = [com.br.domain.entity.Itens::class], version = 1, exportSchema = false)
@TypeConverters(value = [BigDecimalConverter::class])
abstract class AppDatabase: RoomDatabase() {

    abstract val itemDAO: ItemDAO
}