package com.example.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}