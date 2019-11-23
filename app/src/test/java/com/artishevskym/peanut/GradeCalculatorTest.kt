package com.artishevskym.peanut

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.mockk.spyk

class GradeCalculatorTest : BehaviorSpec({
    Given("a grade calculator") {
        val calculator = spyk(GradeCalculator())

        When("obtained marks") {
            val grade = calculator.calculateGrade(0, 100)

            Then("grade is F") {
                grade.shouldBe("F")
            }
        }
    }
})