package com.arslan.utils

import org.junit.Assert.assertEquals
import org.junit.Test

internal class DateUtilsTest {

    @Test
    fun `given correct timestamp, when passing to convertTimestampToLong, should return unix timestamp`() {
        val testTimestamp = "2023-01-12T16:29:00Z"
        val expectedTimestamp = 1673526540000L
        val timestampInSeconds = convertTimestampToLong(testTimestamp)
        assertEquals(expectedTimestamp, timestampInSeconds)
    }

    @Test
    fun `given wrong timestamp, when passing to convertTimestampToLong, should return 0L`() {
        val testTimestamp = "2023-012T16:29:00Z"
        val expectedTimestamp = 0L
        val timestampInSeconds = convertTimestampToLong(testTimestamp)
        assertEquals(expectedTimestamp, timestampInSeconds)
    }

    @Test
    fun `given past time, when passing to calculatePassedTime, should return 1 day ago`() {
        val currentTime = System.currentTimeMillis()
        val pastTimestamp =
            currentTime - (24 * 60 * 60 * 1000) - (4 * 60 * 60 * 1000) - (20 * 60 * 1000)
        val expectedResult = "1 day ago"
        val result = calculatePassedTime(pastTimestamp)
        assertEquals(expectedResult, result)
    }
    @Test
    fun `given past time, when passing to calculatePassedTime, should return 2 days ago`() {
        val currentTime = System.currentTimeMillis()
        val pastTimestamp =
            currentTime - (24 * 60 * 60 * 1000) - (24 * 60 * 60 * 1000) - (4 * 60 * 60 * 1000) - (20 * 60 * 1000)
        val expectedResult = "2 days ago"
        val result = calculatePassedTime(pastTimestamp)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `given past time, when passing to calculatePassedTime, should return 1 hour ago`() {
        val currentTime = System.currentTimeMillis()
        val pastTimestamp = currentTime - (1 * 60 * 60 * 1000) - (20 * 60 * 1000)
        val expectedResult = "1 hour ago"
        val result = calculatePassedTime(pastTimestamp)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `given past time, when passing to calculatePassedTime, should return 4 hours ago`() {
        val currentTime = System.currentTimeMillis()
        val pastTimestamp = currentTime - (4 * 60 * 60 * 1000) - (20 * 60 * 1000)
        val expectedResult  = "4 hours ago"
        val result = calculatePassedTime(pastTimestamp)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `given past time, when passing to calculatePassedTime, should return 1 minutes ago`() {
        val currentTime = System.currentTimeMillis()
        val pastTimestamp = currentTime - (1 * 60 * 1000)
        val expectedResult = "1 minute ago"
        val result = calculatePassedTime(pastTimestamp)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `given past time, when passing to calculatePassedTime, should return 20 minutes ago`() {
        val currentTime = System.currentTimeMillis()
        val pastTimestamp = currentTime - (20 * 60 * 1000)
        val expectedResult = "20 minutes ago"
        val result = calculatePassedTime(pastTimestamp)
        assertEquals(expectedResult, result)
    }

}


