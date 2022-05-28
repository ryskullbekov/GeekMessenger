package com.example.telegramlocalization.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.telegramlocalization.common.local.Localization
import com.example.telegramlocalization.di.PreferencesHelper
import com.example.telegramlocalization.databinding.FragmentLanguagesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LanguagesFragment : Fragment() {

    private lateinit var binding: FragmentLanguagesBinding

    @Inject
    lateinit var preferences: PreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLanguagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkboxRus.isChecked = preferences.getLanguage() == "ru"
        setupRussian()
    }

    private fun setupRussian() = with(binding) {
        checkboxEng.setOnCheckedChangeListener { compoundButton, b ->
            setLocale(Localization.RUSSIAN)
            checkboxEng.isChecked = false

        }
        binding.checkboxEng.setOnCheckedChangeListener { chip, isChecked ->
            checkboxEng.isChecked = true
            if (isChecked) {
                setLocale(Localization.ENGLISH)
                binding.checkboxRus.isChecked = false
                binding.checkboxKg.isChecked = false
            }
            if (!isChecked) {
                checkboxEng.isChecked = false

            }
        }

        binding.checkboxKg.setOnCheckedChangeListener { chip, isChecked ->
            checkboxKg.isChecked = true
            if (isChecked) {
                setLocale(Localization.KYRGYZ)
                binding.checkboxEng.isChecked = false
                binding.checkboxRus.isChecked = false
            }
            if (!isChecked) {
                checkboxKg.isChecked = false

            }
        }

        binding.checkboxRus.setOnCheckedChangeListener { chip, isChecked ->
            checkboxRus.isChecked = true
            if (isChecked) {
                setLocale(Localization.RUSSIAN)
                binding.checkboxEng.isChecked = false
                binding.checkboxKg.isChecked = false
            }
            if (!isChecked) {
                checkboxRus.isChecked = false
            }
        }


    }

    private fun setLocale(locale: Localization) {
        if (preferences.getLanguageCode() != locale.languageCode) {
            preferences.setLocale(locale)
            activity?.recreate()
        }
    }


}