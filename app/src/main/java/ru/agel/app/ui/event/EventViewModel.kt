package ru.agel.app.ui.event

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.agel.app.model.EventReminder
import ru.agel.app.ui.AddEventFragment
import ru.agel.app.ui.common.App
import java.util.*

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val eventsReminder: MutableLiveData<MutableList<EventReminder>> = MutableLiveData()

    init{
        loadEventReminder()
    }

    fun getEvents(): LiveData<MutableList<EventReminder>>{
        return eventsReminder
    }

    fun addEvent(event: EventReminder){
        eventsReminder.value?.add(event)
        eventsReminder.value = eventsReminder.value
    }

    fun showAddEventFragment(){
        getApplication<App>().mainRouter.changeMainFragment(AddEventFragment())
    }

    fun closeAddEventFragment(){
        getApplication<App>().mainRouter.closeLastFragment()
    }

    fun loadEventReminder(){
        val list = mutableListOf(
            EventReminder("Событие 1", "Описание 1", Date(123, 3, 28)),
            EventReminder("Событие 2", "Описание 2", Date(123, 3, 28)),
            EventReminder("Событие 3", "Описание 3", Date(123, 3, 28)),
            EventReminder("Событие 4", "Описание 4", Date(123, 3, 28)),
            EventReminder("Событие 5", "Описание 5", Date(123, 3, 28)),
            EventReminder("Событие 6", "Описание 6", Date(123, 3, 28)),
        )
        eventsReminder.postValue(list)
    }
}