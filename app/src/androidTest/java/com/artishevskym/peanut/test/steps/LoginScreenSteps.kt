package com.artishevskym.peanut.test.steps

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.artishevskym.peanut.MainActivity
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import org.junit.Assert.assertTrue
import com.artishevskym.peanut.R
import cucumber.api.java.en.Then

class LoginScreenSteps {
    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @After("@login-feature")
    fun tearDown() {
        activityScenario.close()
    }

    @Before("@login-feature")
    fun setup() {
        launchActivity()
    }

    @Given("I am on login screen")
    fun I_am_on_login_screen() {
        assertTrue(activityScenario.state == Lifecycle.State.RESUMED)
    }

    @Then("I should see text: Hello World!")
    fun I_should_see_text_Hello_World() {
        onView(withId(R.id.infoText)).check(matches(withText("Hello World!")))
    }

    private fun launchActivity(newState: Lifecycle.State? = null) {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        newState?.let { activityScenario.moveToState(it) }
    }
}