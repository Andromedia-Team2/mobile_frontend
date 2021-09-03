package com.fs.monize.repo.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fs.monize.repo.source.local.entity.AssetEntity
import com.fs.monize.repo.source.local.entity.FundEntity

@Dao
interface AssetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAsset(asset: AssetEntity)

    @Update
    fun updateAsset(asset: AssetEntity)

    @Delete
    fun deleteAsset(asset: AssetEntity)

    @Query("SELECT * FROM tbl_asset")
    fun getAsset(): LiveData<List<AssetEntity>>

    @Query("SELECT * FROM tbl_asset WHERE asset_id = :asset_id")
    fun getAssetById(asset_id: Int): LiveData<AssetEntity>
}