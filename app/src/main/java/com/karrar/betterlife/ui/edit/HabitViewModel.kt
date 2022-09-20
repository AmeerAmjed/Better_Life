package com.karrar.betterlife.ui.edit

import androidx.lifecycle.*
import com.karrar.betterlife.data.database.entity.Habit
import com.karrar.betterlife.data.repository.BetterRepository
import com.karrar.betterlife.ui.HabitInteractionListener
import com.karrar.betterlife.util.Event

class HabitViewModel : ViewModel(), HabitInteractionListener {
    private val repository = BetterRepository()

    val habits: LiveData<List<Habit>> = repository.getAllHabit().asLiveData()

    private val _navigateTOEditHabitDialog = MutableLiveData<Event<Long>>()
    val navigateTOEditHabitDialog: LiveData<Event<Long>>
        get() = _navigateTOEditHabitDialog

    private val _navigateTODeleteHabitDialog = MutableLiveData<Event<Long>>()
    val navigateTODeleteHabitDialog: LiveData<Event<Long>>
        get() = _navigateTODeleteHabitDialog


    override fun onClickDeleteHabit(habitId: Long) {
        _navigateTODeleteHabitDialog.postValue(Event((habitId)))
    }

    override fun onClickEditHabit(habitId: Long) {
        _navigateTOEditHabitDialog.postValue(Event(habitId))
    }

}

