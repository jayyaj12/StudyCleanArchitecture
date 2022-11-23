package com.example.searchbookapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.searchbookapp.R
import com.example.searchbookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNavigationView()

        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.fragment_search
        }
    }

    private fun setupBottomNavigationView() {
        binding.apply {
            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.fragment_setting -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, FirstFragment()).commit()
                        true
                    }
                    R.id.fragment_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, SecondFragment()).commit()
                        true
                    }
                    R.id.fragment_favorite -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, ThirdFragment()).commit()
                        true
                    }
                    else -> false
                }
            }
        }
    }
}