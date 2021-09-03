package com.fs.monize.repo

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.LocalDataSource
import com.fs.monize.repo.source.local.entity.*

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

    override fun insertAsset(asset: AssetEntity) = localDataSource.insertAsset(asset)

    override fun updateAsset(asset: AssetEntity) = localDataSource.updateAsset(asset)

    override fun deleteAsset(asset: AssetEntity) = localDataSource.deleteAsset(asset)

    override fun getAsset(): LiveData<List<AssetEntity>> = localDataSource.getAsset()

    override fun getAssetById(assetId: Int): LiveData<AssetEntity> = localDataSource.getAssetById(assetId)

    override fun insertSaving(saving: SavingEntity) = localDataSource.insertSaving(saving)

    override fun updateSaving(saving: SavingEntity) = localDataSource.updateSaving(saving)

    override fun deleteSaving(saving: SavingEntity) = localDataSource.deleteSaving(saving)

    override fun getSaving(): LiveData<List<SavingEntity>> = localDataSource.getSaving()

    override fun getSavingById(savingId: Int): LiveData<SavingEntity> = localDataSource.getSavingById(savingId)
}