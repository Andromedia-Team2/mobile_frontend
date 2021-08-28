package com.fs.monize.repo.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fs.monize.repo.source.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM tbl_user")
    fun getUser(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM tbl_user WHERE user_id = :user_id")
    fun getUserById(user_id: Int): LiveData<UserEntity>
}