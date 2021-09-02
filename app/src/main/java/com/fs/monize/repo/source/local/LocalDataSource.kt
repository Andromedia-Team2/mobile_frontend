package com.fs.monize.repo.source.local

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.entity.FundEntity
import com.fs.monize.repo.source.local.entity.TransactionEntity
import com.fs.monize.repo.source.local.entity.UserEntity
import com.fs.monize.repo.source.local.room.dao.FundDao
import com.fs.monize.repo.source.local.room.dao.TransactionDao
import com.fs.monize.repo.source.local.room.dao.UserDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LocalDataSource private constructor(
    private val mUserDao: UserDao,
    private val mTransactionDao: TransactionDao,
    private val mFundDao: FundDao){

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(
            userDao: UserDao,
            transactionDao: TransactionDao,
            fundDao: FundDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(userDao, transactionDao, fundDao)
    }

    //User Dao
    fun insertUser(user: UserEntity) = mUserDao.insertUser(user)
    fun updateUser(user: UserEntity) = mUserDao.updateUser(user)
    fun deleteUser(user: UserEntity) = mUserDao.deleteUser(user)
    fun getUser(): LiveData<List<UserEntity>> = mUserDao.getUser()
    fun getUserById(userId: Int): LiveData<UserEntity> = mUserDao.getUserById(userId)

    //Transaction Dao
    fun insertTransaction(transaction: TransactionEntity) = executorService.execute{mTransactionDao.insertTransaction(transaction)}
    fun updateTransaction(transaction: TransactionEntity) = executorService.execute{mTransactionDao.updateTransaction(transaction)}
    fun deleteTransaction(transaction: TransactionEntity) = executorService.execute{mTransactionDao.deleteTransaction(transaction)}
    fun getTransaction(): LiveData<List<TransactionEntity>> = mTransactionDao.getTransaction()
    fun getTransactionById(transactionId: Int): LiveData<TransactionEntity> = mTransactionDao.getTransactionById(transactionId)

    //Fund Dao
    fun insertFund(fund: FundEntity) = mFundDao.insertFund(fund)
    fun updateFund(fund: FundEntity) = mFundDao.updateFund(fund)
    fun deleteFund(fund: FundEntity) = mFundDao.deleteFund(fund)
    fun getFund(): LiveData<List<FundEntity>> = mFundDao.getFund()
    fun getFundById(fundId: Int): LiveData<FundEntity> = mFundDao.getFundById(fundId)
}