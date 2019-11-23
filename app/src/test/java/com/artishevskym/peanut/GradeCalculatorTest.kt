package com.artishevskym.peanut

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec

class GradeCalculatorTest : BehaviorSpec({
    Given("a grade calculator") {
        val calculator = GradeCalculator()

        When("obtained marks are below 60%") {
            val grade = calculator.calculateGrade(0, 100)

            Then("grade is F") {
                grade.shouldBe("F")
            }
        }

        When("obtained marks are between 60% and 69%") {
            val grade = calculator.calculateGrade(63, 100)

            Then("grade is E") {
                grade.shouldBe("E")
            }
        }

    }
})