package com.fs.monize.repo

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.entity.FundEntity
import com.fs.monize.repo.source.local.entity.TransactionEntity
import com.fs.monize.repo.source.local.entity.UserEntity

interface FundDataSource {
    //User Dao
    fun insertUser(user: UserEntity)
    fun updateUser(user: UserEntity)
    fun deleteUser(user: UserEntity)
    fun getUser(): LiveData<List<UserEntity>>
    fun getUserById(userId: Int): LiveData<UserEntity>

    //Goals Dao
    fun insertTransaction(transaction: TransactionEntity)
    fun updateTransaction(transaction: TransactionEntity)
    fun deleteTransaction(transaction: TransactionEntity)
    fun getTransaction(): LiveData<List<TransactionEntity>>
    fun getTransactionById(transactionId: Int): LiveData<TransactionEntity>

    //Fund Dao
    fun insertFund(fund: FundEntity)
    fun updateFund(fund: FundEntity)
    fun deleteFund(fund: FundEntity)
    fun getFund(): LiveData<List<FundEntity>>
    fun getFundById(fundId: Int): LiveData<FundEntity>
}