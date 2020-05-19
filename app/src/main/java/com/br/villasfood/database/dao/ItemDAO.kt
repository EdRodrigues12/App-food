package com.br.villasfood.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.br.villasfood.model.Itens

@Dao
interface ItemDAO {

    @Query("SELECT * FROM Itens ")
    fun buscaTodos(): LiveData<List<Itens>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(cart: Itens)

    @Delete
    fun remove(cart: Itens)

//    @Query("SELECT * FROM Cart WHERE id_cart = :id")
//    fun buscaPorId(id: Long): LiveData<Cart?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(cart: List<Itens>)
}