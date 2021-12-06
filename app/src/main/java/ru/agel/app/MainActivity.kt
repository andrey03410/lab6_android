package ru.agel.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.agel.app.databinding.ActivityMainBinding
import ru.agel.app.ui.EventListFragment
import ru.agel.app.ui.HolidaysFragment
import ru.agel.app.ui.ProfileFragment
import ru.agel.app.ui.common.App

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).mainRouter = MainRouter(supportFragmentManager)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.EventNavigation -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, EventListFragment()).commit()
                    true
                }
                R.id.HolidaysNavigation -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, HolidaysFragment()).commit()
                    true
                }
                R.id.ProfileNavigation -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, EventListFragment()).commit()
    }
}