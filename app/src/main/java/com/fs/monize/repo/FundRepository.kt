package com.fs.monize.repo

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.LocalDataSource
import com.fs.monize.repo.source.local.entity.GoalsBoardEntity
import com.fs.monize.repo.source.local.entity.UserEntity

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

    override fun insertGoals(goals: GoalsBoardEntity) = localDataSource.insertGoals(goals)

    override fun updateGoals(goals: GoalsBoardEntity) = localDataSource.updateGoals(goals)

    override fun deleteGoals(goals: GoalsBoardEntity) = localDataSource.deleteGoals(goals)

    override fun getGoals(): LiveData<List<GoalsBoardEntity>> = localDataSource.getGoals()

    override fun getGoalsById(goalId: Int): LiveData<GoalsBoardEntity> = localDataSource.getGoalsById(goalId)

    override fun getGoalsByIdf(goalIdf: Int): LiveData<GoalsBoardEntity> = localDataSource.getGoalsByIdf(goalIdf)
}