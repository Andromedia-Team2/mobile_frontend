package com.fs.monize.repo.source.local

import androidx.lifecycle.LiveData
import com.fs.monize.repo.source.local.entity.GoalsBoardEntity
import com.fs.monize.repo.source.local.entity.UserEntity
import com.fs.monize.repo.source.local.room.dao.GoalsDao
import com.fs.monize.repo.source.local.room.dao.UserDao

class LocalDataSource private constructor(private val mUserDao: UserDao, private val mGoalsDao: GoalsDao){
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(userDao: UserDao, goalsDao: GoalsDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(userDao, goalsDao)
    }

    //User Dao
    fun insertUser(user: UserEntity) = mUserDao.insertUser(user)
    fun updateUser(user: UserEntity) = mUserDao.updateUser(user)
    fun deleteUser(user: UserEntity) = mUserDao.deleteUser(user)
    fun getUser(): LiveData<List<UserEntity>> = mUserDao.getUser()
    fun getUserById(userId: Int): LiveData<UserEntity> = mUserDao.getUserById(userId)

    //Goals Dao
    fun insertGoals(goals: GoalsBoardEntity) = mGoalsDao.insertGoals(goals)
    fun updateGoals(goals: GoalsBoardEntity) = mGoalsDao.updateGoals(goals)
    fun deleteGoals(goals: GoalsBoardEntity) = mGoalsDao.deleteGoals(goals)
    fun getGoals(): LiveData<List<GoalsBoardEntity>> = mGoalsDao.getGoals()
    fun getGoalsById(goalId: Int): LiveData<GoalsBoardEntity> = mGoalsDao.getGoalsById(goalId)
    fun getGoalsByIdf(goalIdf: Int): LiveData<GoalsBoardEntity> = mGoalsDao.getGoalsByIdf(goalIdf)
}