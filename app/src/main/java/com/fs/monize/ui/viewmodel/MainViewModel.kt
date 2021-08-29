package com.fs.monize.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fs.monize.repo.FundRepository
import com.fs.monize.repo.source.local.entity.GoalsBoardEntity
import com.fs.monize.repo.source.local.entity.UserEntity

class MainViewModel (private val fundRepository: FundRepository): ViewModel() {

    fun insertUser(user: UserEntity) = fundRepository.insertUser(user)
    fun updateUser(user: UserEntity) = fundRepository.updateUser(user)
    fun deleteUser(user: UserEntity) = fundRepository.deleteUser(user)
    fun getUser(): LiveData<List<UserEntity>> = fundRepository.getUser()
    fun getUserById(userId: Int): LiveData<UserEntity> = fundRepository.getUserById(userId)

    fun insertGoals(goals: GoalsBoardEntity) = fundRepository.insertGoals(goals)
    fun updateGoals(goals: GoalsBoardEntity) = fundRepository.updateGoals(goals)
    fun deleteGoals(goals: GoalsBoardEntity) = fundRepository.deleteGoals(goals)
    fun getGoals(): LiveData<List<GoalsBoardEntity>> = fundRepository.getGoals()
    fun getGoalsById(goalId: Int): LiveData<GoalsBoardEntity> = fundRepository.getGoalsById(goalId)
    fun getGoalsByIdf(goalIdf: Int): LiveData<GoalsBoardEntity> = fundRepository.getGoalsByIdf(goalIdf)
}