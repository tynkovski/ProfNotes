package com.tynkovski.android.profnotes.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            setContentView(root)
            setSupportActionBar(toolbar)

            val navController = findNavController(R.id.navigationHost)
            val appBarConfiguration = AppBarConfiguration(
                setOf(R.id.navigation_home, R.id.navigation_preferences)
            )
            setupActionBarWithNavController(navController, appBarConfiguration)

            bottomNavigationView.setupWithNavController(navController)
        }
    }
}