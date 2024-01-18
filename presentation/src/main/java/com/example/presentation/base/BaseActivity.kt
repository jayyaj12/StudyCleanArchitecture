package com.example.presentation.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.example.presentation.databinding.ActivityBaseBinding
import com.example.presentation.view.book.BookFragment
import com.example.presentation.view.book.BookViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_base)
        setupFragmentContainer()
    }

    private fun setupFragmentContainer() {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment_container, BookFragment()).commitAllowingStateLoss()
    }
}