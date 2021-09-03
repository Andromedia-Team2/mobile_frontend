package com.fs.monize.repo.source.local

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.entity.*
import com.fs.monize.repo.source.local.room.dao.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LocalDataSource private constructor(
    private val mUserDao: UserDao,
    private val mTransactionDao: TransactionDao,
    private val mFundDao: FundDao,
    private val mAssetDao: AssetDao,
    private val mSavingDao: SavingDao){

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(
            userDao: UserDao,
            transactionDao: TransactionDao,
            fundDao: FundDao,
            assetDao: AssetDao,
            savingDao: SavingDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(userDao, transactionDao, fundDao, assetDao, savingDao)
    }

    //User Dao
    fun insertUser(user: UserEntity) = executorService.execute{mUserDao.insertUser(user)}
    fun updateUser(user: UserEntity) = executorService.execute{mUserDao.updateUser(user)}
    fun deleteUser(user: UserEntity) = executorService.execute{mUserDao.deleteUser(user)}
    fun getUser(): LiveData<List<UserEntity>> = mUserDao.getUser()
    fun getUserById(userId: Int): LiveData<UserEntity> = mUserDao.getUserById(userId)

    //Transaction Dao
    fun insertTransaction(transaction: TransactionEntity) = executorService.execute{mTransactionDao.insertTransaction(transaction)}
    fun updateTransaction(transaction: TransactionEntity) = executorService.execute{mTransactionDao.updateTransaction(transaction)}
    fun deleteTransaction(transaction: TransactionEntity) = executorService.execute{mTransactionDao.deleteTransaction(transaction)}
    fun getTransaction(): LiveData<List<TransactionEntity>> = mTransactionDao.getTransaction()
    fun getTransactionById(transactionId: Int): LiveData<TransactionEntity> = mTransactionDao.getTransactionById(transactionId)

    //Fund Dao
    fun insertFund(fund: FundEntity) = executorService.execute{mFundDao.insertFund(fund)}
    fun updateFund(fund: FundEntity) = executorService.execute{mFundDao.updateFund(fund)}
    fun deleteFund(fund: FundEntity) = executorService.execute{mFundDao.deleteFund(fund)}
    fun getFund(): LiveData<List<FundEntity>> = mFundDao.getFund()
    fun getFundById(fundId: Int): LiveData<FundEntity> = mFundDao.getFundById(fundId)

    //Asset Dao
    fun insertAsset(asset: AssetEntity) = executorService.execute{mAssetDao.insertAsset(asset)}
    fun updateAsset(asset: AssetEntity) = executorService.execute{mAssetDao.updateAsset(asset)}
    fun deleteAsset(asset: AssetEntity) = executorService.execute{mAssetDao.deleteAsset(asset)}
    fun getAsset(): LiveData<List<AssetEntity>> = mAssetDao.getAsset()
    fun getAssetById(assetId: Int): LiveData<AssetEntity> = mAssetDao.getAssetById(assetId)

    //Saving Dao
    fun insertSaving(saving: SavingEntity) = executorService.execute{mSavingDao.insertSaving(saving)}
    fun updateSaving(saving: SavingEntity) = executorService.execute{mSavingDao.updateSaving(saving)}
    fun deleteSaving(saving: SavingEntity) = executorService.execute{mSavingDao.deleteSaving(saving)}
    fun getSaving(): LiveData<List<SavingEntity>> = mSavingDao.getSaving()
    fun getSavingById(savingId: Int): LiveData<SavingEntity> = mSavingDao.getSavingById(savingId)
}