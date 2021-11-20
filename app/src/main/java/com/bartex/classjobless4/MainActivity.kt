package com.bartex.classjobless4

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    private lateinit var toolbar:Toolbar
    private val navController by lazy{
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initToolbar()

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_lessons,
            R.id.navigation_homeworks,R.id.navigation_liked ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun initViews() {
        navView = findViewById(R.id.nav_view)

        toolbar = findViewById<Toolbar>(R.id.toolbar_main)
    }

    private fun initToolbar() {
        //поддержка экшенбара
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) //отключаем показ заголовка - у нас свой
        //текстовое поле в тулбаре
        with(toolbar.findViewById<TextView>(R.id.toolbar_title)){
            textSize = 16f
            setTextColor(Color.WHITE)
            text = context.getString(R.string.app_name)
        }
    }
}