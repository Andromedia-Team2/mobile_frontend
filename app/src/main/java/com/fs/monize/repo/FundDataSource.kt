package com.fs.monize.repo

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.entity.*

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

    //Asset Dao
    fun insertAsset(asset: AssetEntity)
    fun updateAsset(asset: AssetEntity)
    fun deleteAsset(asset: AssetEntity)
    fun getAsset(): LiveData<List<AssetEntity>>
    fun getAssetById(assetId: Int): LiveData<AssetEntity>

    //Saving Dao
    fun insertSaving(saving: SavingEntity)
    fun updateSaving(saving: SavingEntity)
    fun deleteSaving(saving: SavingEntity)
    fun getSaving(): LiveData<List<SavingEntity>>
    fun getSavingById(savingId: Int): LiveData<SavingEntity>
}