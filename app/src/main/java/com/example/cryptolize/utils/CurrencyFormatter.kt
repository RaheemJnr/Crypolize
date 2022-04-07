package com.example.cryptolize.utils

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


object Formatter {
    //
    private val formatter1 = DecimalFormat("#.##")
    private val formatter2 = DecimalFormat("##.##")
    private val formatter3 = DecimalFormat("##.###")
    fun Double.roundToTwoDecimals() = formatter2.format(this).toString()
    fun Double.roundToThreeDecimals() = formatter3.format(this).toString()
    fun Double.roundPriceChange() = formatter1.format(this).toString()

    //
    private const val COUNTRY = "US"
    private const val LANGUAGE = "en"
    fun formatCurrency(value: Any): String {
        val numberFormat = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY))
        return numberFormat.format(value)
    }
}