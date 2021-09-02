package com.fs.monize.repo

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.LocalDataSource
import com.fs.monize.repo.source.local.entity.FundEntity
import com.fs.monize.repo.source.local.entity.TransactionEntity
import com.fs.monize.repo.source.local.entity.UserEntity

class FundRepository private constructor(private val localDataSource: LocalDataSource) : FundDataSource{
    companion object {

        @Volatile
        private var instance: FundRepository? = null

        fun getInstance(localDataSource: LocalDataSource): FundRepository =
            instance ?: synchronized(this) {
                instance ?: FundRepository(localDataSource).apply { instance = this }
            }
    }

    override fun insertUser(user: UserEntity) = localDataSource.insertUser(user)

    override fun updateUser(user: UserEntity) = localDataSource.updateUser(user)

    override fun deleteUser(user: UserEntity) = localDataSource.deleteUser(user)

    override fun getUser(): LiveData<List<UserEntity>> = localDataSource.getUser()

    override fun getUserById(userId: Int): LiveData<UserEntity> = localDataSource.getUserById(userId)

    override fun insertTransaction(transaction: TransactionEntity) = localDataSource.insertTransaction(transaction)

    override fun updateTransaction(transaction: TransactionEntity) = localDataSource.updateTransaction(transaction)

    override fun deleteTransaction(transaction: TransactionEntity) = localDataSource.deleteTransaction(transaction)

    override fun getTransaction(): LiveData<List<TransactionEntity>> = localDataSource.getTransaction()

    override fun getTransactionById(transactionId: Int): LiveData<TransactionEntity> = localDataSource.getTransactionById(transactionId)

    override fun insertFund(fund: FundEntity)  = localDataSource.insertFund(fund)

    override fun updateFund(fund: FundEntity) = localDataSource.updateFund(fund)

    override fun deleteFund(fund: FundEntity) = localDataSource.deleteFund(fund)

    override fun getFund(): LiveData<List<FundEntity>> = localDataSource.getFund()

    override fun getFundById(fundId: Int): LiveData<FundEntity> = localDataSource.getFundById(fundId)
}