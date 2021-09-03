package com.fs.monize.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fs.monize.repo.FundRepository
import com.fs.monize.repo.source.local.entity.*

class MainViewModel (private val fundRepository: FundRepository): ViewModel() {

    fun insertUser(user: UserEntity) = fundRepository.insertUser(user)
    fun updateUser(user: UserEntity) = fundRepository.updateUser(user)
    fun deleteUser(user: UserEntity) = fundRepository.deleteUser(user)
    fun getUser(): LiveData<List<UserEntity>> = fundRepository.getUser()
    fun getUserById(userId: Int): LiveData<UserEntity> = fundRepository.getUserById(userId)

    fun insertTransaction(transaction: TransactionEntity) = fundRepository.insertTransaction(transaction)
    fun updateTransaction(transaction: TransactionEntity) = fundRepository.updateTransaction(transaction)
    fun deleteTransaction(transaction: TransactionEntity) = fundRepository.deleteTransaction(transaction)
    fun getTransaction(): LiveData<List<TransactionEntity>> = fundRepository.getTransaction()
    fun getTransactionById(transactionId: Int): LiveData<TransactionEntity> = fundRepository.getTransactionById(transactionId)

    fun insertFund(fund: FundEntity) = fundRepository.insertFund(fund)
    fun updateFund(fund: FundEntity) = fundRepository.updateFund(fund)
    fun deleteFund(fund: FundEntity) = fundRepository.deleteFund(fund)
    fun getFund(): LiveData<List<FundEntity>> = fundRepository.getFund()
    fun getFundById(fundId: Int): LiveData<FundEntity> = fundRepository.getFundById(fundId)

    fun insertAsset(asset: AssetEntity) = fundRepository.insertAsset(asset)
    fun updateAsset(asset: AssetEntity) = fundRepository.updateAsset(asset)
    fun deleteAsset(asset: AssetEntity) = fundRepository.deleteAsset(asset)
    fun getAsset(): LiveData<List<AssetEntity>> = fundRepository.getAsset()
    fun getAssetById(assetId: Int): LiveData<AssetEntity> = fundRepository.getAssetById(assetId)

    fun insertSaving(saving: SavingEntity) = fundRepository.insertSaving(saving)
    fun updateSaving(saving: SavingEntity) = fundRepository.updateSaving(saving)
    fun deleteSaving(saving: SavingEntity) = fundRepository.deleteSaving(saving)
    fun getSaving(): LiveData<List<SavingEntity>> = fundRepository.getSaving()
    fun getSavingById(savingId: Int): LiveData<SavingEntity> = fundRepository.getSavingById(savingId)
}