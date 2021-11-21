package com.bartex.classjobless4

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    private lateinit var toolbar:Toolbar
    private lateinit var toolbarTitle:TextView
    private val navController by lazy{  findNavController(R.id.nav_host_fragment)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initToolbar()

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_lessons,
            R.id.navigation_homeworks,R.id.navigation_liked ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun initViews() {
        navView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar_main)
        toolbarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
    }

    private fun initToolbar() {
        //поддержка экшенбара
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) //отключаем показ заголовка - у нас свой
        //текстовое поле в тулбаре
        with(toolbarTitle){
            textSize = 16f
            setTextColor(Color.WHITE)
            text = context.getString(R.string.hello_mike)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_home, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu):Boolean {
        val id = navController.currentDestination?.id
        //заголовок тулбара
        toolbarTitle.text = when (id) {
            R.id.navigation_home -> getString(R.string.hello_mike)
            R.id.navigation_lessons -> getString(R.string.lesss)
            R.id.navigation_homeworks -> getString(R.string.title_homeworks)
            R.id.navigation_liked -> getString(R.string.title_liked)
            R.id.videoFragment -> getString(R.string.video_frag)
            else -> ""
        }
        // видимость иконок в тулбаре
        id?.let {
            menu.findItem(R.id.edit)?.isVisible = it == R.id.navigation_lessons
            menu.findItem(R.id.setting)?.isVisible = it == R.id.navigation_home
            menu.findItem(R.id.send)?.isVisible = it == R.id.navigation_lessons
            menu.findItem(R.id.find)?.isVisible = it == R.id.navigation_home
                    || it == R.id.navigation_lessons
        }
        return super.onPrepareOptionsMenu(menu)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.edit -> {Toast.makeText(this, "Stub edit!", Toast.LENGTH_SHORT).show()}
            R.id.setting -> {Toast.makeText(this  , "Stub setting!", Toast.LENGTH_SHORT).show()}
            R.id.send -> {Toast.makeText(this  , "Stub send!", Toast.LENGTH_SHORT).show()}
            R.id.find -> {Toast.makeText(this  , "Stub find!", Toast.LENGTH_SHORT).show()}
        }
        return super.onOptionsItemSelected(item)
    }
}