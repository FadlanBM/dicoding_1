package com.example.restaurantreview.util

import java.text.SimpleDateFormat
import java.util.Locale


object DateUtils {
    fun formatDate(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("id", "ID"))
        val date = inputFormat.parse(dateString)
        val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale("id", "ID"))
        return outputFormat.format(date)
    }
}