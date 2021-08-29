package com.fs.monize.repo

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.entity.GoalsBoardEntity
import com.fs.monize.repo.source.local.entity.UserEntity

interface FundDataSource {
    //User Dao
    fun insertUser(user: UserEntity)
    fun updateUser(user: UserEntity)
    fun deleteUser(user: UserEntity)
    fun getUser(): LiveData<List<UserEntity>>
    fun getUserById(userId: Int): LiveData<UserEntity>

    //Goals Dao
    fun insertGoals(goals: GoalsBoardEntity)
    fun updateGoals(goals: GoalsBoardEntity)
    fun deleteGoals(goals: GoalsBoardEntity)
    fun getGoals(): LiveData<List<GoalsBoardEntity>>
    fun getGoalsById(goalId: Int): LiveData<GoalsBoardEntity>
    fun getGoalsByIdf(goalIdf: Int): LiveData<GoalsBoardEntity>
}