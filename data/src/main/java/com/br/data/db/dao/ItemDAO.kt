package com.br.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.br.domain.entity.Itens

@Dao
interface ItemDAO {

    @Query("SELECT * FROM Itens ")
    fun buscaTodos(): LiveData<List<com.br.domain.entity.Itens>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(cart: com.br.domain.entity.Itens)

    @Delete
    fun remove(cart: com.br.domain.entity.Itens)

//    @Query("SELECT * FROM Cart WHERE id_cart = :id")
//    fun buscaPorId(id: Long): LiveData<Cart?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(cart: List<com.br.domain.entity.Itens>)
}