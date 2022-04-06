package com.example.cryptolize.utils

import java.text.NumberFormat
import java.util.*


object Formatter {
    private const val COUNTRY = "US"
    private const val LANGUAGE = "en"
    fun formatCurrency(value: Any): String {
        val numberFormat = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY))
        return numberFormat.format(value)
    }
}