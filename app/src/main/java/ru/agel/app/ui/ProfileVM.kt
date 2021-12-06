package ru.agel.app.ui

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import ru.agel.app.ui.common.App

class ProfileVM(application: Application) : AndroidViewModel(application) {
    fun changeMainFragment(fragment: Fragment){
        getApplication<App>().mainRouter.changeMainFragment(fragment)
    }

}