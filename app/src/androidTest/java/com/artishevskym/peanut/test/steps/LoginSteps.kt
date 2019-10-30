package com.artishevskym.peanut.test.steps

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import com.artishevskym.peanut.MainActivity
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import org.junit.Assert.assertTrue
import com.artishevskym.peanut.test.robots.LoginRobot
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class LoginSteps {
    private lateinit var activityScenario: ActivityScenario<MainActivity>
    private lateinit var loginRobot: LoginRobot

    @After("@login-feature")
    fun tearDown() {
        activityScenario.close()
    }

    @Before("@login-feature")
    fun setup() {
        loginRobot = LoginRobot()
        launchActivity()
    }

    @Given("^I see empty login form$")
    fun iSeeEmptyLoginForm() {
        assertTrue(activityScenario.state == Lifecycle.State.RESUMED)
        loginRobot
            .assertEmptyEmail()
            .assertEmptyPassword()
    }

    @When("^I input valid email$")
    fun iInputValidEmail() {
        loginRobot.inputEmail("test@google.com")
    }

    @And("^I input invalid password$")
    fun iInputInvalidPassword() {
        loginRobot.inputPassword("a")
    }

    @And("^I press login button$")
    fun iPressLoginButton() {
        loginRobot.clickLoginButton()
    }

    @Then("^I should see error on password view$")
    fun iShouldSeeErrorOnPasswordView() {
        loginRobot.assertPasswordError()
    }

    private fun launchActivity(newState: Lifecycle.State? = null) {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        newState?.let { activityScenario.moveToState(it) }
    }
}