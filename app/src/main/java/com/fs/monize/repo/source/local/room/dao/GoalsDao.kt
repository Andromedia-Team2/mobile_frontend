package com.fs.monize.repo.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fs.monize.repo.source.local.entity.GoalsBoardEntity

@Dao
interface GoalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoals(goal: GoalsBoardEntity)

    @Update
    fun updateGoals(goal: GoalsBoardEntity)

    @Delete
    fun deleteGoals(goal: GoalsBoardEntity)

    @Query("SELECT * FROM tbl_goals_board")
    fun getGoals(): LiveData<List<GoalsBoardEntity>>

    @Query("SELECT * FROM tbl_goals_board WHERE goals_id = :goal_id")
    fun getGoalsById(goal_id: Int): LiveData<GoalsBoardEntity>

    @Query("SELECT * FROM tbl_goals_board WHERE user_id = :user_id")
    fun getGoalsByIdf(user_id: Int): LiveData<GoalsBoardEntity>
}