package com.arslan.utils

import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


const val TIMESTAMP_WITH_DATE_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss'Z'"
fun convertTimestampToLong(
    timestamp: String,
    dateFormat: String = TIMESTAMP_WITH_DATE_TIME_ZONE
): Long {
    return try {
        val formatter = SimpleDateFormat(dateFormat, Locale.US)
        formatter.parse(timestamp)?.time ?: 0L
    } catch (e: ParseException) {
        Timber.e(e.localizedMessage)
        0L
    }
}

fun calculatePassedTime(timestamp: Long): String {
    val currentTime = System.currentTimeMillis()
    val difference = currentTime - timestamp
    val seconds = difference / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    val remainingMinutes = minutes % 60
    val remainingHours = hours % 24
    val remainingDays = days % 24

    return when {
        remainingDays > 0L -> "${getDaysString(remainingDays)} ago"
        remainingHours > 0L -> "${getHoursString(remainingHours)} ago"
        else -> "${getMinutesString(remainingMinutes)} ago"
    }
}

private fun getDaysString(days: Long) = if (days == 1L) "$days day" else "$days days"
private fun getHoursString(hours: Long) = if (hours == 1L) "$hours hour" else "$hours hours"
private fun getMinutesString(minutes: Long) = if (minutes == 1L) "$minutes minute" else "$minutes minutes"