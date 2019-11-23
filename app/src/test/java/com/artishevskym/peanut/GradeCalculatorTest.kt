package com.artishevskym.peanut

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.mockk.every
import io.mockk.spyk

class GradeCalculatorTest : BehaviorSpec({
    Given("a grade calculator") {
        val calculator = spyk(GradeCalculator())
        every { calculator.totalMarks } returns 100
        val totalMarks = calculator.totalMarks

        When("obtained marks are below 60%") {
            val grade = calculator.calculateGrade(1, totalMarks)

            Then("grade is F") {
                grade.shouldBe("F")
            }
        }

        When("obtained marks are between 50% and 59%") {
            val grade = calculator.calculateGrade(53, totalMarks)

            Then("grade is E") {
                grade.shouldBe("E")
            }
        }

        When("obtained marks are between 60% and 69%") {
            val grade = calculator.calculateGrade(67, totalMarks)

            Then("grade is D") {
                grade.shouldBe("D")
            }
        }

        When("obtained marks are between 70% and 79%") {
            val grade = calculator.calculateGrade(71, totalMarks)

            Then("grade is C") {
                grade.shouldBe("C")
            }
        }

        When("obtained marks are between 80% and 89%") {
            val grade = calculator.calculateGrade(89, totalMarks)

            Then("grade is B") {
                grade.shouldBe("B")
            }
        }

        When("obtained marks are 90% or above") {
            val grade = calculator.calculateGrade(90, totalMarks)

            Then("grade is A") {
                grade.shouldBe("A")
            }
        }
    }
})