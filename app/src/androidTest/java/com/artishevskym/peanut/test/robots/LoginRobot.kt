package com.artishevskym.peanut.test.robots

import com.artishevskym.peanut.R
import com.schibsted.spain.barista.assertion.BaristaErrorAssertions.assertError
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo

class LoginRobot {
    fun inputEmail(email: String) = apply {
        writeTo(R.id.emailInputField, email)
    }

    fun inputPassword(password: String) = apply {
        writeTo(R.id.passwordInputField, password)
    }

    fun clickLoginButton() = apply {
        clickOn(R.id.loginButton)
    }

    fun assertEmptyEmail() = apply {
        assertDisplayed(R.id.emailInputField, EMPTY)
    }

    fun assertEmptyPassword() = apply {
        assertDisplayed(R.id.passwordInputField, EMPTY)
    }

    fun assertPasswordError() = apply {
        assertError(R.id.passwordInputField, R.string.login_password_error)
    }

    fun assertEmailError() = apply {
        assertError(R.id.emailInputField, R.string.login_email_error)
    }

    companion object {
        const val EMPTY = ""
    }
}