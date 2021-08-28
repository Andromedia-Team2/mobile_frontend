package com.fs.monize.repo.source.local.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fs.monize.repo.source.local.entity.*
import com.fs.monize.repo.source.local.room.dao.GoalsDao
import com.fs.monize.repo.source.local.room.dao.UserDao

@Database(
    entities = [
        UserEntity::class,
        GoalsBoardEntity::class,
        SavingEntity::class,
        AssetEntity::class,
        FundEntity::class,
        DebitEntity::class,
        CreditEntity::class,
        CategoryEntity::class,
        LimitBoardEntity::class,
        ScoreBoardEntity::class],
    version = 1,
    exportSchema = false)
abstract class MonizeDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun goalsDao(): GoalsDao

    companion object {
        @Volatile
        private var INSTANCE: MonizeDatabase? = null

        fun getInstance(context: Context): MonizeDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MonizeDatabase::class.java,
                    "monize.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}