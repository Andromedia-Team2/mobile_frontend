package com.fs.monize.repo.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fs.monize.repo.source.local.entity.FundEntity
import com.fs.monize.repo.source.local.entity.UserEntity

@Dao
interface FundDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFund(fund: FundEntity)

    @Update
    fun updateFund(fund: FundEntity)

    @Delete
    fun deleteFund(fund: FundEntity)

    @Query("SELECT * FROM tbl_fund")
    fun getFund(): LiveData<List<FundEntity>>

    @Query("SELECT * FROM tbl_fund WHERE fund_id = :fund_id")
    fun getFundById(fund_id: Int): LiveData<FundEntity>
}