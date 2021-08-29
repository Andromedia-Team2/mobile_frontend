package com.fs.monize.repo

import android.content.Context
import com.fs.monize.repo.source.local.LocalDataSource
import com.fs.monize.repo.source.local.room.db.MonizeDatabase

object Injection {
    fun provideRepository(context: Context): FundRepository {
        val database =MonizeDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(database.userDao(), database.goalsDao())
        return FundRepository.getInstance(localDataSource)
    }
}