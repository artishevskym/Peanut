package com.artishevskym.peanut

import kotlin.math.roundToInt

// TODO: when obtained marks are between 60% and 69%, then the grade is D
// TODO: when obtained marks are between 70% and 79%, then the grade is C
// TODO: when obtained marks are between 80% and 89%, then the grade is B
// TODO: when obtained marks are 90% or above, then the grade is A

class GradeCalculator {
    fun calculateGrade(obtainedMarks: Int, totalMarks: Int): String {
        val percent = calculatePercent(obtainedMarks, totalMarks)
        return when {
            percent >= 50 -> "E"
            else -> "F"
        }
    }

    private fun calculatePercent(obtainedMarks: Int, totalMarks: Int): Int {
        return (100f * obtainedMarks / totalMarks).roundToInt()
    }
}