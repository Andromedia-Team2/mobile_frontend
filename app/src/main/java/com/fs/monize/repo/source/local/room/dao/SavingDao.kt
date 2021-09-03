package com.fs.monize.repo.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fs.monize.repo.source.local.entity.FundEntity
import com.fs.monize.repo.source.local.entity.SavingEntity

@Dao
interface SavingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSaving(saving: SavingEntity)

    @Update
    fun updateSaving(saving: SavingEntity)

    @Delete
    fun deleteSaving(saving: SavingEntity)

    @Query("SELECT * FROM tbl_saving")
    fun getSaving(): LiveData<List<SavingEntity>>

    @Query("SELECT * FROM tbl_saving WHERE saving_id = :saving_id")
    fun getSavingById(saving_id: Int): LiveData<SavingEntity>
}