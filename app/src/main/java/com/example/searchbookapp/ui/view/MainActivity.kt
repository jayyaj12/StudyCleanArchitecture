package com.example.searchbookapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.searchbookapp.R
import com.example.searchbookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupJetpackNavigationView()
//        setupBottomNavigationView()
//
//        if (savedInstanceState == null) {
//            binding.bottomNavigationView.selectedItemId = R.id.fragment_search
//        }
    }

//    private fun setupBottomNavigationView() {
//        binding.apply {
//            bottomNavigationView.setOnItemSelectedListener { item ->
//                when (item.itemId) {
//                    R.id.fragment_setting -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.frame_layout, FirstFragment()).commit()
//                        true
//                    }
//                    R.id.fragment_search -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.frame_layout, SecondFragment()).commit()
//                        true
//                    }
//                    R.id.fragment_favorite -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.frame_layout, ThirdFragment()).commit()
//                        true
//                    }
//                    else -> false
//                }
//            }
//        }
//    }

    private fun setupJetpackNavigationView() {
        val host =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
                ?: return
        navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}