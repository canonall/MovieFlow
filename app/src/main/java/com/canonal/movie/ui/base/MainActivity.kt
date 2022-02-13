package com.canonal.movie.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.canonal.movie.R
import com.canonal.movie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment?
                ?: return

        val navController = host.navController
        setBottomNavBar(navController)
    }

    private fun setBottomNavBar(navController: NavController) {
        binding.bottomNavigation.setupWithNavController(navController)
    }
}