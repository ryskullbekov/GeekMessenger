package com.example.telegramlocalization.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.telegramlocalization.common.local.LocaleHelper
import com.example.telegramlocalization.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var localeHelper: LocaleHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localeHelper.loadLocale(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}