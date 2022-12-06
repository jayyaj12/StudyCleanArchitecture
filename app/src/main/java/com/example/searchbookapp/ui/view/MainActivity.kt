package com.example.searchbookapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.searchbookapp.R
import com.example.searchbookapp.data.db.SearchBookDatabase
import com.example.searchbookapp.data.repository.SearchBookRepository
import com.example.searchbookapp.data.repository.SearchBookRepositoryImpl
import com.example.searchbookapp.databinding.ActivityMainBinding
import com.example.searchbookapp.ui.viewmodel.SearchBookViewModel
import com.example.searchbookapp.ui.viewmodel.SearchBookViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var navController: NavController
    lateinit var searchBookViewModel: SearchBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupJetpackNavigationView()
        setupViewModels()

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
        navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun setupViewModels() {
        val repository: SearchBookRepository =
            SearchBookRepositoryImpl(SearchBookDatabase.getInstance(applicationContext))
        val factory = SearchBookViewModelFactory(repository)
        searchBookViewModel =
            ViewModelProvider(this, factory)[SearchBookViewModel::class.java]
    }
}