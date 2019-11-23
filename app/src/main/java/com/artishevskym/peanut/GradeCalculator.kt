package com.artishevskym.peanut

import kotlin.math.roundToInt

class GradeCalculator {
    var totalMarks = 0

    fun calculateGrade(obtainedMarks: Int, totalMarks: Int): String {
        val percent = calculatePercent(obtainedMarks, totalMarks)
        return when {
            percent >= 90 -> "A"
            percent in 80..89 -> "B"
            percent in 70..79 -> "C"
            percent in 60..69 -> "D"
            percent in 50..59 -> "E"
            else -> "F"
        }
    }

    private fun calculatePercent(obtainedMarks: Int, totalMarks: Int): Int {
        return (100f * obtainedMarks / totalMarks).roundToInt()
    }
}