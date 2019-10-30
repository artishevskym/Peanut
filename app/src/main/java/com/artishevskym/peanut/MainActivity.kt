package com.artishevskym.peanut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            validateInputFields()
        }
    }

    private fun validateInputFields() {
        validateEmailInputField()
        validatePasswordInputField()
    }

    private fun validatePasswordInputField() {
        val password = passwordInputField.text.toString()
        val invalidPassword = password.length < MINIMUM_PASSWORD_LENGTH
        passwordInputField.error = if (invalidPassword) getString(R.string.login_password_error) else null
    }

    private fun validateEmailInputField() {
        val email = emailInputField.text.toString()
        val invalidEmail = EMAIL_ADDRESS.matcher(email).matches().not()
        emailInputField.error = if (invalidEmail) getString(R.string.login_email_error) else null
    }

    companion object {
        private const val MINIMUM_PASSWORD_LENGTH = 5
    }
}
