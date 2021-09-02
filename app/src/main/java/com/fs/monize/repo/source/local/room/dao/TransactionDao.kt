package com.fs.monize.repo.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fs.monize.repo.source.local.entity.TransactionEntity

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransaction(transaction: TransactionEntity)

    @Update
    fun updateTransaction(transaction: TransactionEntity)

    @Delete
    fun deleteTransaction(transaction: TransactionEntity)

    @Query("SELECT * FROM tbl_transaction")
    fun getTransaction(): LiveData<List<TransactionEntity>>

    @Query("SELECT * FROM tbl_transaction WHERE transaction_id = :transaction_id")
    fun getTransactionById(transaction_id: Int): LiveData<TransactionEntity>
}