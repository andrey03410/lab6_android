package ru.agel.app.ui.common

import android.app.Application
import ru.agel.app.MainRouter

class App : Application() {
    lateinit var mainRouter: MainRouter

    override fun onCreate() {
        super.onCreate()
    }
}