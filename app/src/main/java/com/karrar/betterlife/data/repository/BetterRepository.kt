package com.karrar.betterlife.data.repository

import com.karrar.betterlife.data.database.BetterLiveDatabase
import com.karrar.betterlife.data.database.entity.DailyHabits
import com.karrar.betterlife.data.database.entity.Habit
import com.karrar.betterlife.data.database.entity.Task

class BetterRepository {

    private val habitDao = BetterLiveDatabase.getInstanceByApplicationContext().habitDao()

    private val taskDao = BetterLiveDatabase.getInstanceByApplicationContext().taskDao()


    suspend fun insertNewHabit(habit: Habit) = habitDao.insert(habit)

    suspend fun insertHabits(habits: List<Habit>) = habitDao.insertHabits(habits)

    suspend fun updateHabit(habit: Habit) = habitDao.update(habit)

    suspend fun deleteHabit(habit: Habit) {
        habitDao.delete(habit)
        habitDao.deleteHabitIdFromDailyHabit(habit.habitID)
    }

    fun getAllHabit() = habitDao.getAllHabit()

    suspend fun getHabitById(habitId: Long) = habitDao.getHabitById(habitId)

    suspend fun isAnyHabitsInThisDay(day: Long) = habitDao.isAnyHabitsInThisDay(day)

    suspend fun insertAllHabitsPerDay(todayHabits: List<DailyHabits>) = habitDao.insert(todayHabits)

    suspend fun getAllHabitPerDay(day: Long) = habitDao.getAllHabitPerDay(day)

    suspend fun getPointsWeekly() = habitDao.getPointsWeekly()

    suspend fun getPointsInRange(startDate: Long, endDate: Long) =
        habitDao.getPointsInRange(startDate, endDate)

    suspend fun getPointDuringYearWithDate(maxYear: Long) =
        habitDao.getPointDuringYearWithDate(maxYear)

    suspend fun insertTodayHabits(todayHabits: DailyHabits) = habitDao.insert(todayHabits)


    suspend fun insertNewTask(task: Task) = taskDao.insert(task)

    suspend fun deleteTask(task: Task) = taskDao.delete(task)

    suspend fun update(task: Task) = taskDao.update(task)

    fun getAllTasks() = taskDao.getAllTasks()

}